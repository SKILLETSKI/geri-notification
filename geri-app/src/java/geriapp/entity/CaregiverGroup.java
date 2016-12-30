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
public class CaregiverGroup{
    
    private String groupID;
    private String patientNRIC;
    private ArrayList<Caregiver> caregiverList;
    
    public CaregiverGroup(String patientNRIC, ArrayList<Caregiver> caregiverList){
        this.patientNRIC = patientNRIC;
        this.caregiverList = caregiverList;
    }
    
    public String getGroupID(){
        return this.groupID;
    }
    
    public void setGroupID(String groupID){
    	this.groupID = groupID;
    }
    
    public String getPatientNRIC(){
    	return patientNRIC;
    }
    public void setPatientNRIC(String patientNRIC){
    	this.patientNRIC = patientNRIC;
    }
    public ArrayList<Caregiver> getCaregiverGroupList(){
    	return caregiverList;
    }
    public void addCaregiver(Caregiver caregiver){
    	caregiverList.add(caregiver);
    }
}
