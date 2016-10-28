/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geriapp.thread;

import geriapp.dao.ReadingDAO;
import geriapp.entity.reading.MedboxReading;

/**
 *
 * @author muhammadims.2013
 */
public class MedboxReadThread implements Runnable {
    
    MedboxReading mbReading = null;
    private boolean run = true;
    
    @Override
    public void run() {
        while(run) {
            mbReading = (MedboxReading) ReadingDAO.getLatestReading("medbox");
        }
    }

    public MedboxReading getMbReading() {
        return mbReading;
    }

    public void setRun(boolean run) {
        this.run = run;
    }
}
