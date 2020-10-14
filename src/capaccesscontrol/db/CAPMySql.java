/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaccesscontrol.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Edwin Carmona
 */
public class CAPMySql {
    // Librería de MySQL
    private String driver = "com.mysql.jdbc.Driver";
    // Nombre de la base de datos
    private String database;
    // Host
    private String hostname;
    // Puerto
    private String port;
    // Ruta de nuestra base de datos (desactivamos el uso de SSL con "?useSSL=false")
    private String url;
    // Nombre de usuario
    private String username;
    // Clave de usuario
    private String password;
    private Connection oConnection;

    public CAPMySql(String database, String hostname, String port, String username, String password) {
        this.database = database;
        this.hostname = hostname;
        this.port = port;
        this.username = username;
        this.password = password;
    }

    public Connection connectMySQL() {
        try {
            if (oConnection != null && oConnection.isValid(3)) {
                return oConnection;
            }
            
            Class.forName(driver);
            url = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?useSSL=false";
            
            oConnection = DriverManager.getConnection(url, username, password);
        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return oConnection;
    }
}
