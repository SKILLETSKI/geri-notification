/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geriapp.entity.rule;

import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author muhammadims.2013
 */
public class MedboxRule {
    private int patientId;
    private int threshold; //within x milliseconds
    private Timestamp timestamp; //starting time
    private ArrayList<Timestamp> boxOpened; //timestamp when opened
    private int numOfTakes; //
    private int numOfMissed;

    public int getNumOfMissed() {
        return numOfMissed;
    }

    public void setNumOfMissed(int numOfMissed) {
        this.numOfMissed = numOfMissed;
    }

    public ArrayList<Timestamp> getBoxOpened() {
        return boxOpened;
    }

    public void setBoxOpened(Timestamp boxOpened) {
        this.boxOpened.add(boxOpened);
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getThreshold() {
        return threshold;
    }

    public void setThreshold(int threshold) {
        this.threshold = threshold;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public int getNumOfTakes() {
        return numOfTakes;
    }

    public void setNumOfTakes(int numOfTakes) {
        this.numOfTakes = numOfTakes;
    }
    
}
