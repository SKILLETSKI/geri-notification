/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geriapp.controller;

import geriapp.dao.MedboxEventDAO;
import geriapp.dao.ReadingDAO;
import geriapp.entity.reading.Reading;
import geriapp.entity.event.MedboxEvent;
import geriapp.thread.MedboxReadThread;
import java.util.TimeZone;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author muhammadims.2013
 */
public class MedboxEventController {

    private MedboxEvent medboxEvent = new MedboxEvent();
    private ReadingDAO readingDAO = new ReadingDAO();
    private MedboxReadThread mbReadThread;
    private ArrayList<Reading> latestMedboxReadings = new ArrayList<Reading>();
    
    //consider adding a Medbox class for different medboxes
    /*
    public int startTimer() {
        
        long elapsedTimer = 0;
        
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        
        Calendar startCal = Calendar.getInstance(timeZone);
        long startTimer = startCal.getTimeInMillis();
        
        Timestamp startTimestamp = new Timestamp(startTimer - 80000);
        System.out.println(startTimestamp.toString());
        Calendar endCal = Calendar.getInstance(timeZone);
        
        Timestamp endTimestamp = new Timestamp(startTimer + threshold);
        System.out.println(endTimestamp.toString());
        while (elapsedTimer < threshold) {
            elapsedTimer = (new Date()).getTime() - startTimer;
        } //TODO: identify unique readings and place into ArrayList
        
        int result = readingDAO.getPastReadingsCountBetween("medbox", startTimestamp, endTimestamp);
        return result;
    }
    */
    
    public int startTimer(int threshold) {
        
        long elapsedTimer = 0;
        
        TimeZone timeZone = TimeZone.getTimeZone("GMT+8");
        //Timestamp startTimestamp = new Timestamp(startTimer-30000);
        
        Calendar startCal = Calendar.getInstance(timeZone);
        long startTimer = startCal.getTimeInMillis();
        
        Timestamp startTimestamp = new Timestamp(startTimer - 80000);
        System.out.println(startTimestamp.toString());
        Calendar endCal = Calendar.getInstance(timeZone);
        
        Timestamp endTimestamp = new Timestamp(startTimer + threshold + 20000);
        System.out.println(endTimestamp.toString());
        while (elapsedTimer < threshold) {
            elapsedTimer = (new Date()).getTime() - startTimer;
        } //TODO: identify unique readings and place into ArrayList
        
        int result = readingDAO.getPastReadingsCountBetween("medbox", startTimestamp, endTimestamp);
        return result;
    }

    public String soundAlarm() {
        if (latestMedboxReadings != null && !latestMedboxReadings.isEmpty()) {
            int numOpened = latestMedboxReadings.size();
            int numExpected = medboxEvent.getNumSupposedToTake();
            int numCanMiss = medboxEvent.getNumCanMiss();
            int numMissed = numExpected - numOpened;
            
            if (numMissed > numCanMiss) {
                
                return "Patient [S123 - Tommy Tan] has NOT taken medication from 1000 - 1400 hrs. Please input if you are\n1. Available\n2. Unavailable";
            } else {
                
                return "Patient [S123 - Tommy Tan] taking medication from 1000 - 1400 hrs as per normal";
            }
        } else {
            return "Error: No reading can be found!";
        }
    }

    public void setMedboxEvent(String patientId, int threshold, int numOfTakes, int numOfMissed) {
        medboxEvent.setPatientId(patientId);
        medboxEvent.setThreshold(threshold);
        medboxEvent.setNumSupposedToTake(numOfTakes);
        medboxEvent.setNumCanMiss(numOfMissed);
        //comment this out if you are not using database
        //MedboxEventDAO.createNewMedboxEvent(patientId, threshold, numOfTakes, numOfMissed);
    }
}
