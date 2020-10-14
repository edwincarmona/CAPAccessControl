/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaccesscontrol.packet;

/**
 *
 * @author Edwin Carmona
 */
public class CAPSchedule {
    protected String inDateTimeSch;
    protected String outDateTimeSch;
    protected String isSpecialSchedule;

    public String getInDateTimeSch() {
        return inDateTimeSch;
    }

    public void setInDateTimeSch(String inDateTimeSch) {
        this.inDateTimeSch = inDateTimeSch;
    }

    public String getOutDateTimeSch() {
        return outDateTimeSch;
    }

    public void setOutDateTimeSch(String outDateTimeSch) {
        this.outDateTimeSch = outDateTimeSch;
    }

    public String getIsSpecialSchedule() {
        return isSpecialSchedule;
    }

    public void setIsSpecialSchedule(String isSpecialSchedule) {
        this.isSpecialSchedule = isSpecialSchedule;
    }
}
