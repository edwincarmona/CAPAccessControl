/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaccesscontrol.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Edwin Carmona
 */
public class CAPConfigReader {
    public CAPConfig readConfig() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            CAPConfig config = mapper.readValue(new File("cfg.json"), CAPConfig.class);
            
            return config;
        }
        catch (JsonProcessingException ex) {
            Logger.getLogger(CAPConfigReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CAPConfigReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
}
