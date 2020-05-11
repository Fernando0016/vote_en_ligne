public class Database {
	static MongoDatabase database;
	static finale string MONGO_DATABASE = "multimif"


	static MongoCollection<Document> getCollection(string collection){
		if(database == null)
			new Database();
		return database.getCollection(collection);
	}

	private Database(){
		MongoClient client = new MongoClient();
		database = client.getDatabase(MONGO_DATABASE);
	}
}