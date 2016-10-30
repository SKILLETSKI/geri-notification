/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geriapp.controller;

import geriapp.dao.AlertDAO;
import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author muhammadims.2013
 */
public class AlertController {
    public static void createAlert(String type, String patientId, int numInstances) {
        Date date = new Date();
        Timestamp now = new Timestamp(date.getTime());
        AlertDAO.createNewAlert(now, type, patientId, numInstances);
    }
}
