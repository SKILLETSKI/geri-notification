package geriapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import geriapp.dao.*;
import geriapp.entity.Caregiver;
import geriapp.entity.CaregiverGroup;
import geriapp.entity.Event;
import geriapp.entity.Patient;
import java.util.HashMap;

public class CaregiverGroupDAO {

    private static Connection conn;
    private static PreparedStatement pstmt;
    private static ResultSet rs;

    public static HashMap<Patient, ArrayList<Caregiver>> retrieveAllGroup() {

        HashMap<Patient, ArrayList<Caregiver>> allGroups = new HashMap<Patient, ArrayList<Caregiver>>();
        ArrayList<Caregiver> caregiverList = null;
        PatientDAO patientList = new PatientDAO();
        CaregiverDAO caregivertList = new CaregiverDAO();
        Patient patient = null;
        Caregiver caregiver = null;

        try {
            conn = ConnectionManager.getConnection();
            pstmt = conn.prepareStatement("SELECT * from caregiver_group");
            rs = pstmt.executeQuery();
            while (rs.next()) {

                patient = patientList.retrievebyPatientID(rs.getString("PatientNRIC"));
                caregiver = caregivertList.getCaregiverById(rs.getString("CaregiverNRIC"));

                if (allGroups.containsKey(patient)) {
                    caregiverList = allGroups.get(patient);
                    caregiverList.add(caregiver);
                } else {
                    caregiverList = new ArrayList<Caregiver>();
                    caregiverList.add(caregiver);
                    allGroups.put(patient, caregiverList);
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, pstmt, rs);
        }
        return allGroups;
    }

    public static ArrayList<Caregiver> retrieveCaregiverGroupByPatientNRIC(String patientNRIC) {

        ArrayList<Caregiver> caregiverList = new ArrayList<Caregiver>();
        CaregiverDAO caregiverDAO = new CaregiverDAO();
        Caregiver caregiver = null;
        try {
            conn = ConnectionManager.getConnection();
            pstmt = conn.prepareStatement("SELECT caregiverNRIC from caregiver_group where PatientNRIC = '?'");
            pstmt.setString(1, patientNRIC);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                caregiver = caregiverDAO.getCaregiverById(rs.getString("caregiverNRIC"));
                if (caregiver != null) {
                    caregiverList.add(caregiver);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, pstmt, rs);
        }
        return caregiverList;
    }

    public static void addCaregiverToGroup(Patient patient, Caregiver caregiver) {

        HashMap<Patient, ArrayList<Caregiver>> updatedGroups = retrieveAllGroup();
        ArrayList<Caregiver> caregiverList = null;

        try {
            conn = ConnectionManager.getConnection();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO caregiver_group (groupID, PatientNRIC, CaregiverNRIC) VALUES ('?','?','?')");

            ps.setString(1, "2");
            ps.setString(2, patient.getNRIC());
            ps.setString(3, caregiver.getNRIC());

            ps.execute();
            ps.close();

            if (updatedGroups.containsKey(patient)) {
                caregiverList = updatedGroups.get(patient);
                caregiverList.add(caregiver);
            } else {
                caregiverList = new ArrayList<Caregiver>();
                caregiverList.add(caregiver);
                updatedGroups.put(patient, caregiverList);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, pstmt, rs);
        }

        //return updatedGroups;
    }

    public static void deleteCaregiverFromGroup(Patient patient, Caregiver caregiver) {
        try {
            conn = ConnectionManager.getConnection();
            PreparedStatement ps = conn.prepareStatement("DELETE FROM caregiver_group WHERE PatientNRIC = '?' AND CagiverNRIC = '?' ");

            ps.setString(1, patient.getNRIC());
            ps.setString(2, caregiver.getNRIC());

            ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, pstmt, rs);
        }

        ArrayList<Caregiver> caregiverList = retrieveCaregiverGroupByPatientNRIC(patient.getNRIC());

    }

    public static HashMap<Integer, ArrayList<Caregiver>> getCaregiversByEscalation(String patientId) {
        HashMap<Integer, ArrayList<Caregiver>> result = new HashMap<Integer, ArrayList<Caregiver>>();

        try {
            conn = ConnectionManager.getConnection();
            pstmt = conn.prepareStatement("select c.caregiverNRIC,c.phone,c.address,c.name,c.photo,e.escalationLvl from escalation_level e inner join caregiver c on e.caregiverId = c.caregiverId where e.patientId=?");
            pstmt.setString(1, patientId);
            rs = pstmt.executeQuery();
            while (rs.next()) {

                Caregiver caregiver = new Caregiver(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
                Integer escalationLvl = rs.getInt(6);
                ArrayList<Caregiver> temp = result.get(escalationLvl);
                if (temp == null) {
                    ArrayList<Caregiver> temp2 = new ArrayList<Caregiver>();
                    temp2.add(caregiver);
                    result.put(escalationLvl, temp2);
                } else if (!temp.contains(caregiver)) {
                    temp.add(caregiver);
                }
                result.put(escalationLvl, temp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, pstmt, rs);
        }
        return result;
    }

    public static Caregiver getCaregiverByPhoneNumber(String phone) {
       
        Caregiver caregiverOfInterest = null;

        try {
            conn = ConnectionManager.getConnection();
            pstmt = conn.prepareStatement("SELECT * from CAREGIVER where phone = '?' ");
            pstmt.setString(1, phone);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                caregiverOfInterest = new Caregiver(rs.getString("caregiverNRIC"), rs.getString("phone"), rs.getString("address"), rs.getString("name"), rs.getString("photo"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, pstmt, rs);
        }

        return caregiverOfInterest;
    }
    /*
    
     public static ArrayList<Caregiver> retriveCaregiverByPatientID(String patientNRIC) {

     ArrayList<Caregiver> cList = new ArrayList<Caregiver>();
     try {
     conn = ConnectionManager.getConnection();
     pstmt = conn.prepareStatement("SELECT * from Caregiver where patientID = ?");
     pstmt.setString(1, pID);
     rs = pstmt.executeQuery();
     while (rs.next()) {
     String caregiverID = rs.getString("CaregiverID");
     String phoneNum = rs.getString("phonenum");
     String name = rs.getString("name");

     Caregiver caregiver = new Caregiver(caregiverID, phoneNum, name);
     cList.add(caregiver);
     }
     } catch (SQLException e) {
     e.printStackTrace();
     } finally {
     ConnectionManager.close(conn, pstmt, rs);
     }

     return cList;
     }



     */
}
