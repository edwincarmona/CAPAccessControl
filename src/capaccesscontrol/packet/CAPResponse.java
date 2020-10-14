/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaccesscontrol.packet;

import java.util.List;

/**
 *
 * @author Edwin Carmona
 */
public class CAPResponse {
    protected CAPEmployeeResponse employee;
    protected List<CAPAbsenceResponse> absences;
    protected List<CAPEventResponse> events;
    protected CAPSchedule schedule;
    protected CAPSchedule nextSchedule;

    public CAPEmployeeResponse getEmployee() {
        return employee;
    }

    public void setEmployee(CAPEmployeeResponse employee) {
        this.employee = employee;
    }

    public List<CAPAbsenceResponse> getAbsences() {
        return absences;
    }

    public void setAbsences(List<CAPAbsenceResponse> absences) {
        this.absences = absences;
    }

    public List<CAPEventResponse> getEvents() {
        return events;
    }

    public void setEvents(List<CAPEventResponse> events) {
        this.events = events;
    }

    public CAPSchedule getSchedule() {
        return schedule;
    }

    public void setSchedule(CAPSchedule schedule) {
        this.schedule = schedule;
    }

    public CAPSchedule getNextSchedule() {
        return nextSchedule;
    }

    public void setNextSchedule(CAPSchedule nextSchedule) {
        this.nextSchedule = nextSchedule;
    }
    
}
