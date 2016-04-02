/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import oracle.jdbc.pool.OracleDataSource;

/**
 *
 * @author hani
 */
public class DBConnection {
    
    private static DBConnection theConnection = null;
    final String url = "jdbc:oracle:thin:N00727363/oracle@dilbert.humber.ca:1521:grok";
    public String err = null;

    public boolean driverLoaded = false;
    public static Connection conn = null;

    private static PreparedStatement statement;

    private DBConnection() {
        theConnection = this; 
        init();
    }

    public static DBConnection getInstance() {
        if (theConnection == null) {
            theConnection = new DBConnection();
        }
        return theConnection;
    }

    private void init() {
        try {
            OracleDataSource ods = new OracleDataSource();
            ods.setURL(url);
            conn = ods.getConnection();
            //statement = conn.createStatement();
        } catch (Exception e1) {
            err = e1.toString();
        }
    }

    // this is used in queries
    public static Statement getStatement() {
        return statement;
    }    
    // close connection on server shutdown
    public void destroy() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e1) {
           
        }

    }

    
}
