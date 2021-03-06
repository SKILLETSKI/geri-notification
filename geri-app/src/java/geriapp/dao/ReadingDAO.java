/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geriapp.dao;

import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import geriapp.entity.reading.MedboxReading;
import geriapp.entity.reading.DoorReading;
import geriapp.entity.reading.Reading;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
            medboxReading.append("server_timestamp", ((MedboxReading) reading).getServer_timestamp());
            medboxReading.append("sequence", ((MedboxReading) reading).getSequence());
            medboxReading.append("gw_timestamp", ((MedboxReading) reading).getGw_timestamp());
            medboxReading.append("sensor_id", ((MedboxReading) reading).getSensor_id());
            medboxReading.append("reed_val", ((MedboxReading) reading).getReed_val());
            newColl.insertOne(medboxReading);
//TODO: append reading attributes
        }else if(reading instanceof DoorReading){
            newColl = db.getCollection("Door");
            Document doorReading = new Document("gw_id", ((DoorReading) reading).getGw_id());
            doorReading.append("server_timestamp", ((DoorReading) reading).getServer_timestamp());
            doorReading.append("sequence", ((DoorReading) reading).getSequence());
            doorReading.append("gw_timestamp", ((DoorReading) reading).getGw_timestamp());
            doorReading.append("sensor_id", ((DoorReading) reading).getSensor_id());
            doorReading.append("reed_val", ((DoorReading) reading).getReed_val());
            newColl.insertOne(doorReading);
        }
        
        mongo.close();
    }

    public static Reading getLatestReading(String type) {//Change later to ID instead of type
        MongoClient mongo = new MongoClient("54.254.204.169", 27017);

        MongoDatabase db = mongo.getDatabase("GERI");

        MongoCollection<Document> newColl;

        Gson gson = new Gson();

        if (type.equals("medbox")) {
            newColl = db.getCollection("Medbox");
            Document latestEntry = newColl.find().iterator().next();
            String json = latestEntry.toJson();
            Reading reading = gson.fromJson(json, MedboxReading.class);
            mongo.close();
            return reading;
        }else if(type.equals("door")){
            
        }
        return null; //throw Exception??
    }

    public static Reading getReadingsBetween(String type, Timestamp startTime, Timestamp endTime) {
        MongoClient mongo = new MongoClient("54.254.204.169", 27017);

        MongoDatabase db = mongo.getDatabase("GERI");

        MongoCollection<Document> newColl;

        Gson gson = new Gson();

        if (type.equals("medbox")) {
            newColl = db.getCollection("Medbox");
            Document latestEntry = newColl.find().iterator().next();
            String json = latestEntry.toJson();
            MedboxReading reading = gson.fromJson(json, MedboxReading.class);
            String thisTimestamp = reading.getGw_timestamp();
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date parsedTimestamp = null;
            try {
                parsedTimestamp = df.parse(thisTimestamp);
            } catch (ParseException e) {
                return null;
            }
            Timestamp gwTimestamp = new Timestamp(parsedTimestamp.getTime());
            mongo.close();
            if (gwTimestamp.after(startTime) && gwTimestamp.before(endTime)) {
                return reading;
            }
        }else if(type.equals("door")){
            newColl = db.getCollection("Door");
            Document latestEntry = newColl.find().iterator().next();
            String json = latestEntry.toJson();
            DoorReading reading = gson.fromJson(json, DoorReading.class);
            String thisTimestamp = reading.getGw_timestamp();
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date parsedTimestamp = null;
            try {
                parsedTimestamp = df.parse(thisTimestamp);
            } catch (ParseException e) {
                return null;
            }
            Timestamp gwTimestamp = new Timestamp(parsedTimestamp.getTime());
            mongo.close();
            if (gwTimestamp.after(startTime) && gwTimestamp.before(endTime)) {
                return reading;
            }
        }
        return null; //throw Exception??
    }

    public static int getPastReadingsCountBetween(String type, Timestamp startTime, Timestamp endTime) {
        MongoClient mongo = new MongoClient("54.254.204.169", 27017);

        MongoDatabase db = mongo.getDatabase("GERI");
        int size = 0;
        MongoCollection<Document> newColl;
        
        Gson gson = new Gson();

        if (type.equals("medbox")) {
            newColl = db.getCollection("Medbox");
            MongoCursor<Document> iterator = newColl.find().iterator();
            Document latestEntry = null;
            boolean run = true;
            ArrayList<MedboxReading> results = new ArrayList<MedboxReading>();
            while (run) {
                latestEntry = iterator.next();
                if (latestEntry==null) {
                    run = false;
                    size = 121;
                    break;
                }
                String json = latestEntry.toJson();
                MedboxReading reading = gson.fromJson(json, MedboxReading.class);
                String thisTimestamp = reading.getGw_timestamp();
                
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date parsedTimestamp = null;
                try {
                    parsedTimestamp = df.parse(thisTimestamp);
                    //System.out.println(""+parsedTimestamp);
                } catch (ParseException e) {
                    e.printStackTrace();
                    run = false;
                }
                Timestamp gwTimestamp = new Timestamp(parsedTimestamp.getTime());
                //if (gwTimestamp.after(startTime)) {
                if (gwTimestamp.after(startTime) && gwTimestamp.before(endTime)) {
                    results.add(reading);
                } 
                if(!iterator.hasNext()){
                    run = false;
                }
            }
            /*
            while (iterator.hasNext()) {
                latestEntry = iterator.next();
                String json = latestEntry.toJson();
                MedboxReading reading = gson.fromJson(json, MedboxReading.class);
                results.add(reading);
            }
            */
            mongo.close();
            size = results.size();
            return size;
        }else if(type.equals("door")){
            newColl = db.getCollection("Door");
            MongoCursor<Document> iterator = newColl.find().iterator();
            Document latestEntry = null;
            boolean run = true;
            ArrayList<DoorReading> results = new ArrayList<DoorReading>();
            while (run) {
                latestEntry = iterator.next();
                if (latestEntry==null) {
                    run = false;
                    size = 121;
                    break;
                }
                String json = latestEntry.toJson();
                DoorReading reading = gson.fromJson(json, DoorReading.class);
                String thisTimestamp = reading.getGw_timestamp();
                
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date parsedTimestamp = null;
                try {
                    parsedTimestamp = df.parse(thisTimestamp);
                    //System.out.println(""+parsedTimestamp);
                } catch (ParseException e) {
                    e.printStackTrace();
                    run = false;
                }
                Timestamp gwTimestamp = new Timestamp(parsedTimestamp.getTime());
                //if (gwTimestamp.after(startTime)) {
                if (gwTimestamp.after(startTime) && gwTimestamp.before(endTime)) {
                    results.add(reading);
                } 
                if(!iterator.hasNext()){
                    run = false;
                }
            }
            /*
            while (iterator.hasNext()) {
                latestEntry = iterator.next();
                String json = latestEntry.toJson();
                MedboxReading reading = gson.fromJson(json, MedboxReading.class);
                results.add(reading);
            }
            */
            mongo.close();
            size = results.size();
            return size;
        }
        return size; //throw Exception??
    }
}
