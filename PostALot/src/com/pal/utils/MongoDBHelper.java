package com.pal.utils;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoDBHelper {

	private static Logger LOGGER = Logger.getLogger(MongoDBHelper.class
			.getName());

	// To stop instantiation and access only static way
	private MongoDBHelper() {
		super();
	}

	private static MongoClient mongo;
	private static boolean isInitialized = false;
	private static MongoDatabase db;

	private static boolean init() {
		try {
			
			
			if (mongo == null) {
				
				MongoClientURI uri = new MongoClientURI("mongodb://test:test@ds217349.mlab.com:17349/mymongodb"); 
		        
					mongo = new MongoClient(uri);
					db = mongo.getDatabase(uri.getDatabase());
					
					System.out.println("COMMON ENVIRONMENT . Connecting to "+ uri );
				isInitialized = true;
			}
		} catch (Exception ex) {
			LOGGER.log(Level.WARNING, "Error in initizlizing MongoBB", ex);
			isInitialized = false;
		}
		return isInitialized;
	}

	public static MongoCollection getCollection(String collectionName) {

		if (init()) {
			return db.getCollection(collectionName);
		} else {
			return null;
		}

	}

}
