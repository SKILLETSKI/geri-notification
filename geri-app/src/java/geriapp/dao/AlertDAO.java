/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geriapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author muhammadims.2013
 */
public class AlertDAO {

    public static void createNewAlert(Timestamp timestamp, String type, String patientId, int numInstances) {
        ArrayList<Integer> resultMaxAlertId = new ArrayList<Integer>();
        ArrayList<Integer> resultEventId = new ArrayList<Integer>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int maxAlertId;
        int eventId;

        try {
            conn = ConnectionManager.getConnection();
            pstmt = conn.prepareStatement(
                    "select max(alertid) from alert");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                resultMaxAlertId.add(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (!resultMaxAlertId.isEmpty()) {
            maxAlertId = resultMaxAlertId.get(0) + 1;
        } else {
            maxAlertId = 1;
        }
        
        try {
            pstmt = conn.prepareStatement(
                    "select eventid from event where patientid = ? and eventtype = ?");
            pstmt.setString(1, patientId);
            pstmt.setString(2, type);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                resultEventId.add(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        eventId = resultEventId.get(0);

        String insertAlert = "INSERT INTO ALERT"
                + "(ALERTID, EVENTID, PATIENTID, NUMINSTANCES) VALUES"
                + "(?,?,?,?)";
        
        String insertAlertTimestamp = "INSERT INTO ALERT_TIMESTAMP"
                + "(ALERTID,TIMESTAMP) VALUES"
                + "(?,?)";

        try {
            pstmt = conn.prepareStatement(insertAlert);

            pstmt.setInt(1, maxAlertId);
            pstmt.setInt(2, eventId);
            pstmt.setString(3, patientId);
            pstmt.setInt(4, numInstances);

            // execute insert SQL stetement
            pstmt.executeUpdate();
            
            pstmt = conn.prepareStatement(insertAlertTimestamp);
            
            pstmt.setInt(1, maxAlertId);
            pstmt.setTimestamp(2, timestamp);
            
            pstmt.executeUpdate();

        } catch (SQLException e) {
            
        } finally {
            ConnectionManager.close(conn, pstmt, rs);
        }
    }
}
