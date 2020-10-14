/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaccesscontrol.db;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author Edwin Carmona
 */
public class CAPSiieDb {
    
    public static javax.swing.ImageIcon getPhoto(Connection conn, int idEmpSiie) {
        String sql = "SELECT img_pho_n FROM erp.hrsu_emp WHERE id_emp = " + idEmpSiie + ";";
        Blob blob = null;
        javax.swing.ImageIcon image = null;
        
        try {
            Statement st = conn.createStatement();
            ResultSet res = st.executeQuery(sql);
            
            if (res.next()) {
                blob = res.getBlob("img_pho_n");
                
                if (blob == null) {
                    image = new javax.swing.ImageIcon("img/userprof.png");
                    return image;
                }
                
                return CAPSiieDb.convertBlobToImageIcon(blob);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CAPSiieDb.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CAPSiieDb.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public static javax.swing.ImageIcon convertBlobToImageIcon(java.sql.Blob blob) throws java.sql.SQLException, java.io.IOException {
        int i = 0;
        int bytesRead = 0;
        int bytesReadTotal = 0;
        byte[] buffer = new byte[1024];
        byte[] bufferImageIcon = new byte[1024 * 1024];
        InputStream is = blob.getBinaryStream();

        while ((bytesRead = is.read(buffer)) != -1) {
            for (i = 0; i < bytesRead; i++) {
                bufferImageIcon[bytesReadTotal + i] = buffer[i];
            }
            bytesReadTotal += bytesRead;
        }

        return new ImageIcon(bufferImageIcon);
    }
}
