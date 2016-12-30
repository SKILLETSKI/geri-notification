/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geriapp.entity;
import java.util.ArrayList;
import geriapp.entity.Caregiver;

/**
 *
 * @author AvinashDash
 */
public class Patient{
    
    //private String patientID;
    private String name;
    private String NRIC;
    private String phone;
    private String address;
    private String notes;
    private String photo;

    
    public Patient(String name, String NRIC, String phone, String address,String notes, String photo){
        this.name = name;
        this.NRIC = NRIC;        
        this.phone = phone;
        this.address = address;
        this.photo = photo;
        this.notes = notes;
      
    }

    public String getNRIC() {
        return NRIC;
    }

    public void setNRIC(String NRIC) {
        this.NRIC = NRIC;
    }
    
    public String getName(){
    	return name;
    }
    public void setName(String name){
    	this.name = name;
    }
    public String getAddress(){
    	return address;
    }
    public void setAddress(String address){
    	this.address = address;
    }
    public String getPhone(){
    	return phone;
    }
    public void setPhone(String phone){
    	this.phone = phone;
    }
    public String getNotes(){
    	return notes;
    }
    public void setNotes(String notes){
    	this.notes = notes;
    }
    public String getPhoto(){
    	return photo;
    }
    public void setPhoto(String photo){
    	this.photo = photo;
    }
    
       
}
