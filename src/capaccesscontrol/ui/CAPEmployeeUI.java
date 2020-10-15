/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaccesscontrol.ui;

/**
 *
 * @author Edwin Carmona
 */
public class CAPEmployeeUI {
    
    private int idEmployee;
    private String employeeName;
    private String employeeNumber;
    private int externalId;

    public CAPEmployeeUI(int idEmployee, String employeeName, String employeeNumber, int externalId) {
        this.idEmployee = idEmployee;
        this.employeeName = employeeName;
        this.employeeNumber = employeeNumber;
        this.externalId = externalId;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public int getExternalId() {
        return externalId;
    }

    public void setExternalId(int externalId) {
        this.externalId = externalId;
    }

    @Override
    public String toString() {
        return this.employeeName + "-" + this.employeeNumber;
    }
    
}
