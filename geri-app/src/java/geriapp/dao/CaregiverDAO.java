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
 * @author ASUS
 */
public class CaregiverDAO {
   private ArrayList<Caregiver> caregiverList = new ArrayList<Caregiver>();

    public ArrayList<Caregiver> getCaregiverList() {
        return caregiverList;
    }
    
        public Caregiver getCaregiverList(String caregiverID) {
            for(Caregiver caregiver: caregiverList){
                if(caregiver.getCaregiverID() == caregiverID){
                    return caregiver;
                }
            }
            return null;
        }
}
