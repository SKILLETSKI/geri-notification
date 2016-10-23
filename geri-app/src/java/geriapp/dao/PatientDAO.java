/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geriapp.dao;
import geriapp.entity.Patient;
import geriapp.entity.Caregiver;
import java.util.ArrayList;

/**
 *
 * @author AvinashDash
 */
public class PatientDAO {
    
    private ArrayList<Patient> patientList = null;
    
    public Patient getPatient(String patientID){
        Patient matchedPatient = null;
        //Add in DB query to get the patientList
        for(Patient checkPatient: patientList){
            if(checkPatient.getPatientID() == patientID)
                matchedPatient = checkPatient;
        }
        
        return matchedPatient;
    }
    
    public ArrayList<Patient> getAllPatients(){
        return patientList; //Add in DB query to get patientList
    }
    
    public ArrayList<Caregiver> getCaregiverList(String patientID){
        ArrayList<Caregiver> returnCaregiverList = new ArrayList<Caregiver>();
        for(Patient matchPatient: patientList){
            if(matchPatient.getPatientID() == patientID){
                returnCaregiverList = matchPatient.getCaregiverList();
            }
        }
        return returnCaregiverList;
    }
    
}
