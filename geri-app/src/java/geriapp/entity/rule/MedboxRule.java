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
    private int numSupposedToTake; //
    private int numCanMiss;

    public int getNumCanMiss() {
        return numCanMiss;
    }

    public void setNumCanMiss(int numOfMissed) {
        this.numCanMiss = numOfMissed;
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

    public int getNumSupposedToTake() {
        return numSupposedToTake;
    }

    public void setNumSupposedToTake(int numOfTakes) {
        this.numSupposedToTake = numOfTakes;
    }
    
}
