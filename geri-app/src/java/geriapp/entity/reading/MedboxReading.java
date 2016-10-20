/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geriapp.entity.reading;

import java.sql.Timestamp;

/**
 *
 * @author muhammadims.2013
 */
public class MedboxReading extends Reading {
    private int gw_id;
    private Timestamp server_timestamp;
    private int sequence;
    private Timestamp gw_timestamp;
    private int sensor_id;
    private int reed_val;

    public int getGw_id() {
        return gw_id;
    }

    public void setGw_id(int gw_id) {
        this.gw_id = gw_id;
    }

    public Timestamp getServer_timestamp() {
        return server_timestamp;
    }

    public void setServer_timestamp(Timestamp server_timestamp) {
        this.server_timestamp = server_timestamp;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public Timestamp getGw_timestamp() {
        return gw_timestamp;
    }

    public void setGw_timestamp(Timestamp gw_timestamp) {
        this.gw_timestamp = gw_timestamp;
    }

    public int getSensor_id() {
        return sensor_id;
    }

    public void setSensor_id(int sensor_id) {
        this.sensor_id = sensor_id;
    }

    public int getReed_val() {
        return reed_val;
    }

    public void setReed_val(int reed_val) {
        this.reed_val = reed_val;
    }
    
    
}
