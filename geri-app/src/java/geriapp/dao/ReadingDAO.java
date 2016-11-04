/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geriapp.dao;

import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import geriapp.entity.reading.MedboxReading;
import geriapp.entity.reading.Reading;
import org.bson.Document;

/**
 *
 * @author muhammadims.2013
 */
public class ReadingDAO {
    public static void storeReading(Reading reading) {
        
        MongoClient mongo = new MongoClient("54.254.204.169", 27017);
        
        MongoDatabase db = mongo.getDatabase("GERI");
        MongoCollection newColl;
        
        if (reading instanceof MedboxReading) {
            newColl = db.getCollection("Medbox");
            Document medboxReading = new Document("gw_id", ((MedboxReading) reading).getGw_id());
            medboxReading.append("server_timestamp",((MedboxReading) reading).getServer_timestamp());
            medboxReading.append("sequence",((MedboxReading) reading).getSequence());
            medboxReading.append("gw_timestamp",((MedboxReading) reading).getGw_timestamp());
            medboxReading.append("sensor_id",((MedboxReading) reading).getSensor_id());
            medboxReading.append("reed_val",((MedboxReading) reading).getReed_val());
            newColl.insertOne(medboxReading);
//TODO: append reading attributes
        }
    }
    
    public static Reading getLatestReading(String type) {
        MongoClient mongo = new MongoClient("54.254.204.169", 27017);
        
        MongoDatabase db = mongo.getDatabase("GERI");
        
        MongoCollection<Document> newColl;
        
        Gson gson = new Gson();
        
        if (type.equals("medbox")) {
            newColl = db.getCollection("Medbox");
            Document latestEntry = newColl.find().iterator().next();
            String json = latestEntry.toJson();
            Reading reading = gson.fromJson(json, MedboxReading.class);
            return reading;
        }
        return null; //throw Exception??
    }
}
