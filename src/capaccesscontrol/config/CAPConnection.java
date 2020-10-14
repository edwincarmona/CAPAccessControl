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
public class CAPConnection {
    protected String userDb;
    protected String pswdDb;
    protected String hostDb;
    protected String portDb;
    protected String nameDb;

    public String getUserDb() {
        return userDb;
    }

    public void setUserDb(String userDb) {
        this.userDb = userDb;
    }

    public String getPswdDb() {
        return pswdDb;
    }

    public void setPswdDb(String pswdDb) {
        this.pswdDb = pswdDb;
    }

    public String getHostDb() {
        return hostDb;
    }

    public void setHostDb(String hostDb) {
        this.hostDb = hostDb;
    }

    public String getNameDb() {
        return nameDb;
    }

    public void setNameDb(String nameDb) {
        this.nameDb = nameDb;
    }

    public String getPortDb() {
        return portDb;
    }

    public void setPortDb(String portDb) {
        this.portDb = portDb;
    }
    
}
