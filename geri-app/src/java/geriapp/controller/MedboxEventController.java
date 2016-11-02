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
import geriapp.Twilio.TwilioMessageCreator;
import geriapp.Twilio.Credential;
import com.twilio.http.TwilioRestClient.Builder;
import com.twilio.http.TwilioRestClient;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 *
 * @author muhammadims.2013
 */
public class MedboxEventController {

    private MedboxEvent medboxEvent = new MedboxEvent();
    private ReadingDAO readingDAO = new ReadingDAO();
    private MedboxReadThread mbReadThread = new MedboxReadThread();
    private ArrayList<Reading> latestMedboxReadings = new ArrayList<Reading>();
    private Builder twilioClientBuilder = new Builder("ekthiara.2013@sis.smu.edu.sg", "S9009336c");
    private Credential twilioCredentials = new Credential();
    
    //consider adding a Medbox class for different medboxes

    public int startTimer() {
        long startTime = System.currentTimeMillis();
        long elapsedTime = 0;
        Thread medboxTimerThread = new Thread(mbReadThread);
        medboxTimerThread.start();

        while (elapsedTime < medboxEvent.getThreshold()) {
            Reading reading = mbReadThread.getMbReading();
            if (!latestMedboxReadings.contains(reading) && reading != null) {
                latestMedboxReadings.add(reading);
            }
            elapsedTime = (new Date()).getTime() - startTime;
        } //TODO: identify unique readings and place into ArrayList
        
        mbReadThread.setRun(false);
        return latestMedboxReadings.size();
    }

    public boolean soundAlarm() {
        if (latestMedboxReadings != null && !latestMedboxReadings.isEmpty()) {
            int numOpened = latestMedboxReadings.size();
            int numExpected = medboxEvent.getNumSupposedToTake();
            int numCanMiss = medboxEvent.getNumCanMiss();
            int numMissed = numExpected - numOpened;
            
            if (numMissed > numCanMiss) {
                //create alert
                //send SMS
                
                TwilioRestClient twilioClient = twilioClientBuilder.build();
                TwilioMessageCreator messageCreator = new TwilioMessageCreator(twilioClient);
                
                //Needs to be configured with deployment URL | Add in input phone number
                //Add in a parse JSON for the message content
                //messageCreator.create(twilioCredentials.getAccountSid(), "+6586568835", twilioCredentials.getMessagingServiveSid, "Patient not taking medicine");
                
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public void setMedboxEvent(String patientId, int threshold, int numOfTakes, int numOfMissed) {
        medboxEvent.setPatientId(patientId);
        medboxEvent.setThreshold(threshold);
        medboxEvent.setNumSupposedToTake(numOfTakes);
        medboxEvent.setNumCanMiss(numOfMissed);
        //comment this out if you are not using database
        MedboxEventDAO.createNewMedboxEvent(patientId, threshold, numOfTakes, numOfMissed);
    }
}
