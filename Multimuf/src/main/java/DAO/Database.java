/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class Database {
	static MongoDatabase database;



	public MongoCollection<Document> getCollection(String collection){
		if(database == null)
			new Database("multimif");
		return database.getCollection(collection);
	}

	public Database(String db){
		MongoClient client = new MongoClient();
		database = client.getDatabase(db);
	}
        
        
}