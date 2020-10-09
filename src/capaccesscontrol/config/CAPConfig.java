/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaccesscontrol.config;

/**
 *
 * @author Edwin Carmona
 */
public class CAPConfig {
    protected int hoursLog;
    protected int searchScheduleDays;
    protected int minPrevSchedule;
    protected int minPostSchedule;
    protected CAPConnection siieConnection;
    protected CAPConnection capConnection;
    protected CAPCompanyData companyData;

    public int getHoursLog() {
        return hoursLog;
    }

    public void setHoursLog(int hoursLog) {
        this.hoursLog = hoursLog;
    }

    public int getSearchScheduleDays() {
        return searchScheduleDays;
    }

    public void setSearchScheduleDays(int searchScheduleDays) {
        this.searchScheduleDays = searchScheduleDays;
    }

    public int getMinPrevSchedule() {
        return minPrevSchedule;
    }

    public void setMinPrevSchedule(int minPrevSchedule) {
        this.minPrevSchedule = minPrevSchedule;
    }

    public int getMinPostSchedule() {
        return minPostSchedule;
    }

    public void setMinPostSchedule(int minPostSchedule) {
        this.minPostSchedule = minPostSchedule;
    }

    public CAPConnection getSiieConnection() {
        return siieConnection;
    }

    public void setSiieConnection(CAPConnection siieConnection) {
        this.siieConnection = siieConnection;
    }

    public CAPConnection getCapConnection() {
        return capConnection;
    }

    public void setCapConnection(CAPConnection capConnection) {
        this.capConnection = capConnection;
    }

    public CAPCompanyData getCompanyData() {
        return companyData;
    }

    public void setCompanyData(CAPCompanyData companyData) {
        this.companyData = companyData;
    }
    
    
}