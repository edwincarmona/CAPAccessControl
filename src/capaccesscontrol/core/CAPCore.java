/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaccesscontrol.core;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Edwin Carmona
 */
public class CAPCore {
    /**
     * Determina si la hora recibida está dentro del horario indicado.
     * Contempla minutos previos y posteriores al horario.
     * 
     * @param inDateTimeSch
     * @param outDateTimeSch
     * @param dtDate
     * @param nMinsPrevious
     * @param nMinsAfter
     * 
     * @return 
     */
    public static boolean isOnShift(String inDateTimeSch, String outDateTimeSch, Date dtDate, int nMinsPrevious, int nMinsAfter) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            Date dateScheIn = sdf.parse(inDateTimeSch);
            Date dateScheOut = sdf.parse(outDateTimeSch);
            
            Calendar calendarIn = CAPCore.dateToCalendar(dateScheIn);
            calendarIn.add(Calendar.MINUTE, - nMinsPrevious);
            Date dateIn = calendarIn.getTime();
            
            Calendar calendarOut = CAPCore.dateToCalendar(dateScheOut);
            calendarOut.add(Calendar.MINUTE, nMinsAfter);
            Date dateOut = calendarOut.getTime();
            
            return (dtDate.after(dateIn) || dtDate.equals(dateIn)) && (dtDate.before(dateOut) || dtDate.equals(dateOut));
        }
        catch (ParseException ex) {
            Logger.getLogger(CAPCore.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    /**
     * Convert Date to Calendar.
     * 
     * @param date
     * @return 
     */
    private static Calendar dateToCalendar(Date date) {

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            return calendar;

    }

    /**
     * Convert Calendar to Date
     * 
     * @param calendar
     * @return 
     */
    private Date calendarToDate(Calendar calendar) {
            return calendar.getTime();
    }
}
