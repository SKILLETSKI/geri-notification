package geriapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import geriapp.dao.*;
import geriapp.entity.Caregiver;
import geriapp.entity.Event;
import geriapp.entity.Patient;

public class CaregiverDAO {

    private static Connection conn;
    private static PreparedStatement pstmt;
    private static ResultSet rs;

    public static Caregiver getCaregiverById(String caregiverNRIC) {
        Caregiver caregiverOfInterest = null;

        try {
            conn = ConnectionManager.getConnection();
            pstmt = conn.prepareStatement("SELECT phone, name, address, photo from CAREGIVER where CaregiverNRIC = '?'");
            pstmt.setString(1, caregiverNRIC);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                caregiverOfInterest = new Caregiver(caregiverNRIC, rs.getString("phone"), rs.getString("address"), rs.getString("name"), rs.getString("photo"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, pstmt, rs);
        }

        return caregiverOfInterest;
    }

    public static void updateCaregiver(Caregiver caregiver) {
        try {

            conn = ConnectionManager.getConnection();
            PreparedStatement ps = conn.prepareStatement("UPDATE caregiver SET phone='?', address='?', name='?', photo='?' WHERE caregiverNRIC='?'");

            ps.setString(1, caregiver.getPhone());
            ps.setString(2, caregiver.getAddress());
            ps.setString(3, caregiver.getName());
            ps.setString(4, caregiver.getPassword());
            ps.setString(5, caregiver.getPhoto());
            ps.setString(6, caregiver.getNRIC());

            ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, pstmt, rs);
        }

    }

    public static void deleteCaregiver(String caregiverNRIC) {

        try {

            conn = ConnectionManager.getConnection();
            PreparedStatement ps = conn.prepareStatement("DELETE FROM Caregiver WHERE caregiverNRIC='?'");

            ps.setString(1, caregiverNRIC);

            ps.executeUpdate();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, pstmt, rs);
        }

    }

    public static ArrayList<Caregiver> retrieveAllCaregiver() {

        ArrayList<Caregiver> caregiverList = new ArrayList<Caregiver>();
        
        try {

            conn = ConnectionManager.getConnection();
            PreparedStatement ps = conn.prepareStatement("SELECT * from caregiver");
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Caregiver caregiver = new Caregiver(rs.getString("caregiverNRIC"), rs.getString("phone"), rs.getString("address"), rs.getString("name"), rs.getString("photo"));
                caregiverList.add(caregiver);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, pstmt, rs);
        }
        
        return caregiverList;
    }

}
