/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geriapp.entity;

import java.util.ArrayList;

/**
 *
 * @author muhammadims.2013
 */
public class Event {
    
    //private ArrayList<String[]> conditions;
    
    	private String EventID;
	private String PatientNRIC;
	private String currentval;
	private String eventtype;

    public Event(String EventID, String PatientNRIC, String currentval, String eventtype) {
        this.EventID = EventID;
        this.PatientNRIC = PatientNRIC;
        this.currentval = currentval;
        this.eventtype = eventtype;
    }

    public String getEventID() {
        return EventID;
    }

    public void setEventID(String EventID) {
        this.EventID = EventID;
    }

    public String getPatientNRIC() {
        return PatientNRIC;
    }

    public void setPatientNRIC(String PatientNRIC) {
        this.PatientNRIC = PatientNRIC;
    }

    public String getCurrentval() {
        return currentval;
    }

    public void setCurrentval(String currentval) {
        this.currentval = currentval;
    }

    public String getEventtype() {
        return eventtype;
    }

    public void setEventtype(String eventtype) {
        this.eventtype = eventtype;
    }
        
        
}
