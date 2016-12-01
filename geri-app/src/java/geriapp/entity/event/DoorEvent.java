/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geriapp.entity.event;

import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author muhammadims.2013
 */
public class DoorEvent {
    private String patientId;
    private int threshold; //within x milliseconds
    private int numSupposedToTake; //
    private int numCanMiss;
    private int doorEventId;

    public int getDoorEventId() {
        return doorEventId;
    }

    public void setDoorEventId(int doorEventId) {
        this.doorEventId = doorEventId;
    }

    public int getNumCanMiss() {
        return numCanMiss;
    }

    public void setNumCanMiss(int numOfMissed) {
        this.numCanMiss = numOfMissed;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public int getThreshold() {
        return threshold;
    }

    public void setThreshold(int threshold) {
        this.threshold = threshold;
    }

    public int getNumSupposedToTake() {
        return numSupposedToTake;
    }

    public void setNumSupposedToTake(int numOfTakes) {
        this.numSupposedToTake = numOfTakes;
    }
    
}
