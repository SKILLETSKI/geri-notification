package geriapp.dao;

import geriapp.entity.Caregiver;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import geriapp.entity.Event;
import geriapp.entity.Patient;
import java.util.ArrayList;
import java.util.HashMap;

public class EventDAO {

    private static Connection conn;
    private static PreparedStatement pstmt;
    private static ResultSet rs;

    public static Event getEventById(int eventId) {

        Event currentEvent = null;
        try {
            conn = ConnectionManager.getConnection();
            pstmt = conn.prepareStatement("select * from EVENT where EventID = ?");
            pstmt.setInt(1, eventId);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                String patientId = rs.getString("PatientNRIC");
                int currentVal = rs.getInt("currentval");
                String eventType = rs.getString("eventtype");
                currentEvent = new Event(eventId, patientId, currentVal, eventType);
                break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, pstmt, rs);
        }
        return currentEvent;
    }

    public static ArrayList<Event>  getEventByPatientNRIC(String patientNRIC) {
        ArrayList<Event> eventList = new ArrayList<Event>();
        try {
            conn = ConnectionManager.getConnection();
            pstmt = conn.prepareStatement("SELECT * FROM event WHERE patientNRIC =?");
            pstmt.setString(1, patientNRIC);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                eventList.add(new Event(rs.getInt("EventID"), patientNRIC, rs.getInt("currentval"), rs.getString("eventtype")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, pstmt, rs);
        }

        return eventList;
    }

    public static ArrayList<String> getExpression(String patientId) {
        ArrayList<String> output = null;
        Event currentEvent = null;
        try {
            conn = ConnectionManager.getConnection();
            pstmt = conn.prepareStatement("select expression from EVENT where PatientNRIC = ?");
            pstmt.setString(1, patientId);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                String expression = rs.getString("expression");
                output.add(expression);
                break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, pstmt, rs);
        }

        return output;
    }

    public static HashMap<String, HashMap<String, ArrayList<String>>> getAllExpressions() {
        //<PatientID, <EventType,ArrayList<Expression>>>
        HashMap<String, HashMap<String, ArrayList<String>>> output = new HashMap<String, HashMap<String, ArrayList<String>>>();

        Event currentEvent = null;
        try {
            conn = ConnectionManager.getConnection();
            pstmt = conn.prepareStatement("select patientNRIC, eventType, expression from event ev inner join expressions ex on ev.eventID = ex.eventId group by ev.patientNRIC ");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                String patientId = rs.getString("patientNRIC");
                String eventType = rs.getString("eventType");
                String expression = rs.getString("expression");

                if (output.get(patientId) == null) {
                    HashMap<String, ArrayList<String>> eventTypeExpression = new HashMap<String, ArrayList<String>>();
                    ArrayList<String> expressions = new ArrayList<String>();
                    expressions.add(expression);
                    eventTypeExpression.put(eventType, expressions);
                    output.put(patientId, eventTypeExpression);
                } else {
                    if (output.get(patientId).get(eventType) == null) {
                        HashMap<String, ArrayList<String>> eventTypeExpression = output.get(patientId);
                        ArrayList<String> expressions = new ArrayList<String>();
                        expressions.add(expression);
                        eventTypeExpression.put(eventType, expressions);
                        output.put(patientId, eventTypeExpression);
                    } else {
                        HashMap<String, ArrayList<String>> eventTypeExpression = output.get(patientId);
                        ArrayList<String> expressions = eventTypeExpression.get(eventType);
                        expressions.add(expression);
                        eventTypeExpression.put(eventType, expressions);
                        output.put(patientId, eventTypeExpression);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionManager.close(conn, pstmt, rs);
        }

        return output;
    }
}
