/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaccesscontrol.core;

import Formularios.Checador;
import Formularios.envioCorreo;
import capaccesscontrol.ui.CAPMainUI;
import com.digitalpersona.onetouch.DPFPDataPurpose;
import com.digitalpersona.onetouch.DPFPFeatureSet;
import com.digitalpersona.onetouch.DPFPGlobal;
import com.digitalpersona.onetouch.DPFPSample;
import com.digitalpersona.onetouch.DPFPTemplate;
import com.digitalpersona.onetouch.capture.DPFPCapture;
import com.digitalpersona.onetouch.capture.event.DPFPDataAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPDataEvent;
import com.digitalpersona.onetouch.capture.event.DPFPErrorAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPErrorEvent;
import com.digitalpersona.onetouch.capture.event.DPFPReaderStatusAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPReaderStatusEvent;
import com.digitalpersona.onetouch.verification.DPFPVerification;
import com.digitalpersona.onetouch.verification.DPFPVerificationResult;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.swing.SwingUtilities;

/**
 *
 * @author Edwin Carmona
 */
public class CAPDigitalPersona {
    
    //Varible que permite iniciar el dispositivo de lector de huella conectado con sus distintos metodos.
    private DPFPCapture oReader = DPFPGlobal.getCaptureFactory().createCapture();
    //Esta variable tambien captura una huella del lector y crea sus caracteristcas para auntetificarla o verificarla con alguna guarda en la BD
    private DPFPVerification oVerifier = DPFPGlobal.getVerificationFactory().createVerification();
    private static String TEMPLATE_PROPERTY = "template";
    private DPFPFeatureSet featuresDP;
    
    private Checador oChecador;
    private CAPMainUI oCapGui;

    public CAPDigitalPersona(CAPMainUI ui) {
        this.oCapGui = ui;
        oChecador = new Checador();
        this.startReaderMethods();
        this.start();
    }
    
    private void start() {
        oReader.startCapture();
    }
    
    private void startReaderMethods() {
        envioCorreo email = new envioCorreo();

        oReader.addDataListener(new DPFPDataAdapter() {
            @Override
            public void dataAcquired(final DPFPDataEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        processTake(e.getSample());
                    }
                });
            }
        });

        oReader.addReaderStatusListener(new DPFPReaderStatusAdapter() {
            @Override
            public void readerConnected(final DPFPReaderStatusEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        oChecador.EnviarTexto("Se conecto el lector biometrico en CAP Reloj Checador");
                        try {
                            email.enviar(5, "", "");
                        } catch (MessagingException ex) {
                            Logger.getLogger(Checador.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
            }

            @Override
            public void readerDisconnected(final DPFPReaderStatusEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        oChecador.EnviarTexto("Error 101: Se desconecto el lector biometrico en CAP Reloj Checador");
                        //email.sendEmail(4,"");
                        try {
                            email.enviar(4, "", "");
                        } catch (MessagingException ex) {
                            Logger.getLogger(Checador.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
            }
        });

        oReader.addErrorListener(new DPFPErrorAdapter() {
            public void errorReader(final DPFPErrorEvent e) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        oChecador.EnviarTexto("Error 103: Hubo un error en CAP Reloj Checador " + e.getError());
                        //email.sendEmail(3,"");
                        try {
                            email.enviar(3, "", "");
                        } catch (MessagingException ex) {
                            Logger.getLogger(Checador.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
            }
        });

    }
    
    private void processTake(DPFPSample sample) {
        // Procesar la muestra de la huella y crear un conjunto de características con el propósito de verificacion.
        featuresDP = oChecador.extraerCaracteristicas(sample, DPFPDataPurpose.DATA_PURPOSE_VERIFICATION);
        try {
            int id = identifyFingerprint();
            
            if (id > 0) {
                oCapGui.actionSearchEmployeeById(id);
            }
            
        } catch (IOException ex) {
            Logger.getLogger(Checador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // Identifica a una persona registrada por medio de su huella digital
    public int identifyFingerprint() throws IOException {
        //try{
        //Establece los valores para la sentencia SQL
        //Connection c = con.conectar();
        //Obtiene todas las huella de la bd
        //PreparedStatement identificarStmt = c.prepareStatement("SELECT id,employee_id,print FROM fingerprints");
        //ResultSet rs = identificarStmt.executeQuery();
        //Si se encuentra el nombre en la base de datos
        for (int i = 0; oChecador.getHuellas().size() > i; i++) {
            //Lee la plantilla de la base de datos
            //byte templateBuffer[] = rs.getBytes("print");
            byte templateBuffer[] = oChecador.getHuellas().get(i);
            //int employee_id = rs.getInt("employee_id");
            int employee_id = oChecador.getListaempleados().get(i);
            //Crea una nueva plantilla a partir de la guardada en la base de datos
            DPFPTemplate referenceTemplate = DPFPGlobal.getTemplateFactory().createTemplate(templateBuffer);
            //Envia la plantilla creada al objeto contenedor de Template del componente de huella digital
            oChecador.setTemplate(referenceTemplate);

            //Compara las caracteristicas de la huella recientemente capturada con alguna plantilla guardada en la base de datos que concide con ese tipo
            DPFPVerificationResult result = oVerifier.verify(featuresDP, oChecador.getTemplate());

            //Compara las plantillas, si encuentra correspondenica dibuja el mapa que indica el nombre de la persona que coincidio
            if (result.isVerified()) {
                return employee_id;
            }
        }
        
        return -1;
    }
}
