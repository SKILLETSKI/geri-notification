/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geriapp.entity;


/**
 *
 * @author muhammadims.2013
 */
public class Event {
    private int eventId;
    private String patientId;
    private int currentVal;
    private String eventType;
    
    public Event(int eventId, String patientId, int currentVal, String eventType){
    	this.eventId = eventId;
    	this.patientId = patientId;
    	this.currentVal = currentVal;
    	this.eventType = eventType;
    }
    
    public int getEventId(){
    	return this.eventId;
    }
    
    public void setEventId(int eventId){
    	this.eventId = eventId;
    }
    
    public String getPatientId(){
    	return this.patientId;
    }
    
    public void setPatientId(String patientId){
    	this.patientId = patientId;
    }
    
    public int getCurrentVal(){
    	return this.currentVal;
    }
    
    public void setCurrentVal(int currentVal){
    	this.currentVal = currentVal;
    }
    
    public String getEventType(){
    	return this.eventType;
    }
    
    public void setEventType(String eventType){
    	this.eventType = eventType;
    }
}
