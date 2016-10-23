/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geriapp.entity;
import java.util.ArrayList;
import geriapp.entity.Patient;

/**
 *
 * @author AvinashDash
 */
public class Caregiver extends Person{
    
    private String caregiverID;
    private ArrayList<Patient> patientList = null;
    
    public Caregiver(){
        this.Name = "";
        this.userName = "";
        this.password = "";
        this.caregiverID = "";
        this.patientList = new ArrayList<Patient>();
    }
    
    
    public Caregiver(String Name, String userName, String password, String caregiverID, ArrayList<Patient> patientList){
        this.Name = Name;
        this.userName = userName;
        this.password = password;
        this.caregiverID = caregiverID;
        this.patientList = patientList;        
    }
    
    public String getCaregiverID(){
        return this.caregiverID;
    }
    
    public ArrayList<Patient> getPatientList(){
        return this.patientList;
    }
    
    public void addPatient(Patient newPatient){
        patientList.add(newPatient);
    }
    
    
    
    
    
}
