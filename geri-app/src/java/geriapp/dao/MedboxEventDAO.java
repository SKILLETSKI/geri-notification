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
import java.util.ArrayList;

/**
 *
 * @author muhammadims.2013
 */
public class MedboxEventDAO {
    public static void createNewMedboxEvent(String patientId, int threshold,int expected,int numCanMiss) {
        ArrayList<Integer> resultMaxEventId = new ArrayList<Integer>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int maxEventId;

        try {
            conn = ConnectionManager.getConnection();
            pstmt = conn.prepareStatement(
                    "select max(eventid) from event");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                resultMaxEventId.add(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (!resultMaxEventId.isEmpty()) {
            maxEventId = resultMaxEventId.get(0) + 1;
        } else {
            maxEventId = 1;
        }
        
        String insertEvent = "INSERT INTO EVENT"
                + "(EVENTID, PATIENTID, CURRENTVAL, EVENTTYPE) VALUES"
                + "(?,?,?,?)";
        
        String insertMedboxEvent = "INSERT INTO MEDBOXEVENT"
                + "(MEDBOXEVENTID, THRESHOLD, EXPECTED, NUMCANMISS) VALUES"
                + "(?,?,?,?)";
        
        try {
            pstmt = conn.prepareStatement(insertEvent);

            pstmt.setInt(1, maxEventId);
            pstmt.setString(2, patientId);
            pstmt.setInt(3, 0);
            pstmt.setString(4, "Medbox");

            // execute insert SQL stetement
            pstmt.executeUpdate();
            
            pstmt = conn.prepareStatement(insertMedboxEvent);
            
            pstmt.setInt(1, maxEventId);
            pstmt.setInt(2, threshold);
            pstmt.setInt(3, expected);
            pstmt.setInt(4, numCanMiss);
            
            pstmt.executeUpdate();

        } catch (SQLException e) {
            
        } finally {
            ConnectionManager.close(conn, pstmt, rs);
        }
    }
}
