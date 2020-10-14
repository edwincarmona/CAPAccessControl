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
public class CAPAbsenceResponse {
    protected String external_key;
    protected String nts;
    protected String type_name;

    public String getExternal_key() {
        return external_key;
    }

    public void setExternal_key(String external_key) {
        this.external_key = external_key;
    }

    public String getNts() {
        return nts;
    }

    public void setNts(String nts) {
        this.nts = nts;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }
}
