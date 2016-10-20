/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geriapp.controller;

import geriapp.dao.ReadingDAO;
import geriapp.entity.reading.Reading;
import geriapp.entity.rule.MedboxRule;
import geriapp.thread.MedboxReadThread;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author muhammadims.2013
 */
public class MedboxEventController {

    private MedboxRule medboxRule = new MedboxRule();
    private ReadingDAO readingDAO = new ReadingDAO();
    private MedboxReadThread mbReadThread = new MedboxReadThread();
    //consider adding a Medbox class for different medboxes

    public int startTimer() {
        long startTime = System.currentTimeMillis();
        long elapsedTime = 0;
        Thread medboxTimerThread = new Thread(mbReadThread);
        medboxTimerThread.start();
        ArrayList<Reading> latestMedboxReadings = new ArrayList<Reading>();

        while (elapsedTime < medboxRule.getThreshold()) {
            Reading reading = mbReadThread.getMbReading();
            if(!latestMedboxReadings.contains(reading) && reading != null) {
                latestMedboxReadings.add(reading);
            }
            elapsedTime = (new Date()).getTime() - startTime;
        } //TODO: identify unique readings and place into ArrayList
        
        return latestMedboxReadings.size();
    }
    
    public boolean soundAlarm(int numOfReadings,int numExpected) {
        return true;
    }
}
