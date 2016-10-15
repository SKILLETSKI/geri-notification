/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geriapp.controller;

import com.mongodb.DBObject;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.util.JSON;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import org.bson.Document;

/**
 *
 * @author muhammadims.2013
 */
public class BootstrapController {

    public static String importJSONFileToDB(String pathToFile, MongoDatabase db, String collectionName) {
        // open file
        FileInputStream fstream = null;
        try {
            fstream = new FileInputStream(pathToFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("file not exist, exiting");
            return "File Not Found";
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

        // read it line by line
        String strLine;
        MongoCollection newColl = db.getCollection(collectionName);
        try {
            while ((strLine = br.readLine()) != null) {
                // convert line by line to BSON
                Document doc = Document.parse(strLine);
                // insert BSONs to database
                try {
                    newColl.insertOne(doc);
                } catch (MongoException e) {
                    // duplicate key
                    return "Database insertion error";
                }

            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        return "Success!";

    }
}
