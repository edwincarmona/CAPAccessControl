/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaccesscontrol;

import capaccesscontrol.ui.CAPMainUI;
import capaccesscontrol.config.CAPConfig;
import capaccesscontrol.config.CAPConfigReader;
import capaccesscontrol.core.CAPDigitalPersona;
import javax.swing.JFrame;

/**
 *
 * @author Edwin Carmona
 */
public class CAPAccessControl {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        CAPConfigReader cr = new CAPConfigReader();
        CAPConfig config = cr.readConfig();
        
        CAPMainUI ui = new CAPMainUI(config);
        ui.setTitle("CAP Access Control - " + config.getCompanyData().getCompanyName());
        ui.setSize(960, 620);
        ui.setResizable(false);
        ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ui.setLocationRelativeTo(null);
        
        CAPDigitalPersona obj = new CAPDigitalPersona(ui);
        
        ui.setVisible(true);
        
    }
    
}
