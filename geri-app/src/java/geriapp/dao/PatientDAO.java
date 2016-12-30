package geriapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import geriapp.dao.*;
import geriapp.entity.Caregiver;
import geriapp.entity.Event;
import geriapp.entity.Patient;

public class PatientDAO {

    private static Connection conn;
    private static PreparedStatement pstmt;
    private static ResultSet rs;
    


    public static ArrayList<Patient> retrieveAllPatient() {
        
       Patient patient;
       ArrayList<Patient> patientList = new ArrayList<Patient>();
        
        try {
            conn = ConnectionManager.getConnection();
            pstmt = conn.prepareStatement("SELECT * from Patient");
            rs = pstmt.executeQuery();
            while (rs.next()) {

                patient = new Patient (rs.getString("name"),rs.getString("patientNRIC"),rs.getString("phone"), rs.getString("address"), rs.getString("note"), rs.getString("photo"));        
                patientList.add(patient);
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, pstmt, rs);
        }
        return patientList;
    }

    public static Patient retrievebyPatientID(String NRIC) {
        
        Patient patient = null;
        
        try {
            conn = ConnectionManager.getConnection();
            pstmt = conn.prepareStatement("SELECT * from Patient where patientNRIC = '?'");
            pstmt.setString(1, NRIC);
            rs = pstmt.executeQuery();
            rs.next();
            
            patient = new Patient(rs.getString("name"),rs.getString("patientNRIC"),rs.getString("phone"), rs.getString("address"), rs.getString("note"), rs.getString("photo"));

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, pstmt, rs);
        }
        return patient;
    }

    public static void updatePatient(Patient patient) {

        try {

            conn = ConnectionManager.getConnection();
            PreparedStatement ps = conn.prepareStatement("UPDATE patient SET phone='?', address='?', name='?', notes='?', photo='?', WHERE patientNRIC='?'");

            ps.setString(1, patient.getPhone());
            ps.setString(2, patient.getAddress());
            ps.setString(3, patient.getName());
            ps.setString(4, patient.getNotes());
            ps.setString(5, patient.getPhoto());
            ps.setString(6, patient.getNRIC());

            ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, pstmt, rs);
        }

    }

    public static void deletePatient(String NRIC) {

        try {

            conn = ConnectionManager.getConnection();
            pstmt = conn.prepareStatement("DELETE FROM Patient WHERE patientNRIC='?'");

            pstmt.setString(1, NRIC);

            pstmt.executeUpdate();
            pstmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, pstmt, rs);
        }

    }
    
    public static void AddPatient(Patient patient) {

        try {

            conn = ConnectionManager.getConnection();
            pstmt = conn.prepareStatement("INSERT INTO patient (patientNRIC, phone, address, name, notes, photo) VALUES ('?','?', '?', '?', '?', '?')");

            pstmt.setString(1, patient.getNRIC());
            pstmt.setString(1, patient.getPhone());
            pstmt.setString(1, patient.getAddress());
            pstmt.setString(1, patient.getName());
            pstmt.setString(1, patient.getNotes());            
            pstmt.setString(1, patient.getPhoto());
            
            pstmt.execute();
            pstmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, pstmt, rs);
        }

    }

}
