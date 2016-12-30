/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geriapp.dao;

/**
 *
 * @author muhammadims.2013
 */

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionManager {
     private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://fyptetrisdemodb.cshpafji2tup.ap-southeast-1.rds.amazonaws.com:3306/";
    private static final String DB_NAME = "GERI";
    static {
        try {
            Class.forName(DRIVER_NAME).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL + DB_NAME, "root", "12345678");
    }

    
      /**
   * close the given connection, statement and resultset
   *
   * @param conn the connection object to be closed
   * @param stmt the statement object to be closed
   * @param rs the resultset object to be closed
   */
  public static void close(Connection conn, Statement stmt, ResultSet rs) {
    try {
      if (rs != null) {
        rs.close();
      }
    } catch (SQLException ex) {
      Logger.getLogger(ConnectionManager.class.getName()).log(Level.WARNING,
              "Unable to close ResultSet", ex);
    }
    
    close(conn,stmt);
  }
  
  
  /**
   * close the given connection, statement
   *
   * @param conn the connection object to be closed
   * @param stmt the statement object to be closed
   */
  public static void close(Connection conn, Statement stmt) {
    try {
      if (stmt != null) {
        stmt.close();
      }
    } catch (SQLException ex) {
      Logger.getLogger(ConnectionManager.class.getName()).log(Level.WARNING,
              "Unable to close Statement", ex);
    }
    try {
      if (conn != null) {
        conn.close();
      }
    } catch (SQLException ex) {
      Logger.getLogger(ConnectionManager.class.getName()).log(Level.WARNING,
              "Unable to close Connection", ex);
    }
  }
}

