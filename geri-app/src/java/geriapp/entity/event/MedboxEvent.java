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
public class MedboxEvent {
    private String patientId;
    private int threshold; //within x milliseconds
    private int numSupposedToTake; //
    private int numCanMiss;
    private int medboxEventId;

    public int getMedboxEventId() {
        return medboxEventId;
    }

    public void setMedboxEventId(int medboxEventId) {
        this.medboxEventId = medboxEventId;
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
