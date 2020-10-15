/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaccesscontrol.packet;

import capaccesscontrol.ui.CAPMainUI;
import capaccesscontrol.db.CAPSiieDb;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Edwin Carmona
 */
public class CAPRequest {
    
    public static CAPResponse requestEmployees(String url) {
        CAPResponse response;
        
        response = CAPRequest.request(url, "");
        
        return response;
    }
    
    public static CAPResponse requestByIdEmployee(Date dtDate, int idEmployee, int nextDays, String url) {
        CAPResponse response = null;
        try {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            DateFormat tf = new SimpleDateFormat("HH:mm");
            
            String charset = java.nio.charset.StandardCharsets.UTF_8.name();
            
            String sDate = df.format(dtDate);
            String sTime = tf.format(dtDate);
            
            String query = String.format("dt_date=%s&dt_time=%s&id_emp=%s&next_days=%s",
                    URLEncoder.encode(sDate, charset),
                    URLEncoder.encode(sTime, charset),
                    URLEncoder.encode(idEmployee + "", charset),
                    URLEncoder.encode(nextDays + "", charset)
            );
            
            response = CAPRequest.request(url, query);
            
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(CAPRequest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return response;
    }
    
    public static CAPResponse requestByNumEmployee(Date dtDate, String numEmployee, int nextDays, String url) {
        CAPResponse response = null;
        try {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            DateFormat tf = new SimpleDateFormat("HH:mm");
            
            String charset = java.nio.charset.StandardCharsets.UTF_8.name();
            
            String sDate = df.format(dtDate);
            String sTime = tf.format(dtDate);
            
            String query = String.format("dt_date=%s&dt_time=%s&num_emp=%s&next_days=%s",
                    URLEncoder.encode(sDate, charset),
                    URLEncoder.encode(sTime, charset),
                    URLEncoder.encode(numEmployee, charset),
                    URLEncoder.encode(nextDays + "", charset)
            );
            
            response = CAPRequest.request(url, query);
            
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(CAPRequest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return response;
    }
    
    private static CAPResponse request(String sURL, String query) {
        try {
            String charset = java.nio.charset.StandardCharsets.UTF_8.name();
            
            URLConnection connection = new URL(sURL + "?" + query).openConnection();
            connection.setRequestProperty("Accept-Charset", charset);
            connection.setRequestProperty("Content-Type", "application/json");
            InputStream response = connection.getInputStream();
            
            try (Scanner scanner = new Scanner(response)) {
                String responseBody = scanner.useDelimiter("\\A").next();
                System.out.println(responseBody);
                
                ObjectMapper mapper = new ObjectMapper();
                CAPResponse capResponse = mapper.readValue(responseBody, CAPResponse.class);
                
                return capResponse;
            }
        }
        catch (UnsupportedEncodingException ex) {
            Logger.getLogger(CAPMainUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (MalformedURLException ex) {
            Logger.getLogger(CAPMainUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (IOException ex) {
            Logger.getLogger(CAPMainUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
}
