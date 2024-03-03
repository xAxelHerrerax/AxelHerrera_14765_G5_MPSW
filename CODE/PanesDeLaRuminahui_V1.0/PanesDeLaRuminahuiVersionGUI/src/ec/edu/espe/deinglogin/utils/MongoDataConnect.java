package ec.edu.espe.deinglogin.utils;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 *
 * @author Calvache Gabriel, Techware, DCCO-ESPE
 */
public class MongoDataConnect {

    private MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<Document> collection;

    public MongoDataConnect(String collections) {
        connect(collections);
    }

    private void connect(String collections) {
        String uri = "mongodb+srv://jcalderon:jcalderon@cluster0.94svwj5.mongodb.net/?retryWrites=true&w=majority";
        try {
            mongoClient = MongoClients.create(uri);
            database = mongoClient.getDatabase("PanesDeLaRuminahui");
            collection = database.getCollection(collections);
        } catch (Exception e) {
            System.err.println("Error connecting to MongoDB: " + e);
        }
    }

    public MongoClient getMongoClient() {
        return mongoClient;
    }

    public MongoDatabase getDatabase() {
        return database;
    }

    public MongoCollection<Document> getCollection() {
        return collection;
    }

}
