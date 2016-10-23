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
public class Patient extends Person{
    
    private String patientID;
    private ArrayList<Caregiver> caregiverList = null;
    
    public Patient(){
        this.Name = "";
        this.caregiverList = new ArrayList<Caregiver>();
        this.password = "";
        this.patientID = "";
    }
    
    public Patient(String Name, ArrayList<Caregiver> caregiverList, String password, String patientID){
        this.Name = Name;
        this.caregiverList = caregiverList;
        this.userName = userName;
        this.password = password;
        this.patientID = patientID;
    }
    
    public String getPatientID(){
        return this.patientID;
    }
    
    public ArrayList<Caregiver> getCaregiverList(){
        return this.caregiverList;
    }
    
    public void addCaregiver(Caregiver newCaregiver){
        caregiverList.add(newCaregiver);
    }
    
    
}
