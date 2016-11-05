/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geriapp.thread;

import geriapp.dao.ReadingDAO;
import geriapp.entity.reading.MedboxReading;
import java.sql.Timestamp;

/**
 *
 * @author muhammadims.2013
 */
public class MedboxReadThread implements Runnable {

    MedboxReading mbReading = null;
    private boolean run = true;
    Timestamp startTime = null;
    Timestamp endTime = null;

    public MedboxReadThread() {
        //init params?
    }

    public MedboxReadThread(Timestamp startTime, Timestamp endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public void run() {
        if (startTime == null || endTime == null) {
            while (run) {
                mbReading = (MedboxReading) ReadingDAO.getLatestReading("medbox");
            }
        } else {
            while(run) {
                mbReading = (MedboxReading) ReadingDAO.getReadingsBetween("medbox",startTime,endTime);
            }
        }
    }

    public MedboxReading getMbReading() {
        return mbReading;
    }

    public void setRun(boolean run) {
        this.run = run;
    }
}
