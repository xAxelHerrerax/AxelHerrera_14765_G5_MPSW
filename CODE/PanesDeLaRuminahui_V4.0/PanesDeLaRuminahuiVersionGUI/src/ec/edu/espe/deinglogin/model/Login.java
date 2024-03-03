package ec.edu.espe.deinglogin.model;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.eq;
import com.mongodb.client.result.UpdateResult;
import java.util.Scanner;
import org.bson.Document;
import org.bson.conversions.Bson;

/**
 *
 * 
 */
public class Login {

    public static void createDocument() {
        String uri = "mongodb+srv://AxelH:panaderia2024@cluster0.0xpbdx0.mongodb.net/?retryWrites=true&w=majority";
        Scanner readData = new Scanner(System.in);
        MongoClient mongoClient = null;

        try {
            mongoClient = MongoClients.create(uri);
            MongoDatabase database = mongoClient.getDatabase("Prueba");
            MongoCollection<Document> collection = database.getCollection("Login");

            System.out.print("Username: ");
            String username = readData.next();
            System.out.println("Password");
            String password = readData.next();

            String cifrada = "";
            int desplazar = 1;

            for (int i = 0; i < password.length(); i++) {
                int codigoLetra = password.codePointAt(i);
                char letraDesplazada = (char) (codigoLetra + desplazar);
                cifrada = cifrada + letraDesplazada;
            }

            Document doc1 = new Document("username", username).append("password", cifrada);
            collection.insertOne(doc1);

        } finally {
            if (mongoClient != null) {
                mongoClient.close();
            }
            readData.close();
        }
    }

    public static void deleteDocument() {
        boolean userLoop = true;
        boolean passwordLoop = true;
        String uri = "mongodb+srv://AxelH:panaderia2024@cluster0.0xpbdx0.mongodb.net/?retryWrites=true&w=majority";
        Scanner readData = new Scanner(System.in);
        MongoClient mongoClient = null;

        try {
            mongoClient = MongoClients.create(uri);
            MongoDatabase database = mongoClient.getDatabase("Prueba");
            MongoCollection<Document> collection = database.getCollection("Login");

            do {
                System.out.print("Username: ");
                String username = readData.next();
                Bson usernameFilter = Filters.eq("username", username);
                Document usernameVerification = collection.find(usernameFilter).first();

                if (usernameVerification != null) {
                    System.out.println("El dato existe en la colección.");
                    userLoop = false;
                } else {
                    System.out.println("El dato no existe en la colección.");
                }
            } while (userLoop);

            do {
                System.out.println("Password");
                String password = readData.next();

                String cifrada = "";
                int desplazar = 1;

                for (int i = 0; i < password.length(); i++) {
                    int codigoLetra = password.codePointAt(i);
                    char letraDesplazada = (char) (codigoLetra + desplazar);
                    cifrada = cifrada + letraDesplazada;
                }

                Bson cifradaFilter = Filters.eq("password", cifrada);
                Document cifradaVerification = collection.find(cifradaFilter).first();

                if (cifradaVerification != null) {
                    System.out.println(" El dato existe en la colección.");
                    passwordLoop = false;
                } else {
                    System.out.println(" El dato no existe en la colección.");
                }
            } while (passwordLoop);
        } finally {
            if (mongoClient != null) {
                mongoClient.close();
            }
            readData.close();
        }
    }

    public static void readDocument() {
        String uri = "mongodb+srv://AxelH:panaderia2024@cluster0.0xpbdx0.mongodb.net/?retryWrites=true&w=majority";
        Scanner readData = new Scanner(System.in);
        MongoClient mongoClient = null;

        try {
            mongoClient = MongoClients.create(uri);
            MongoDatabase database = mongoClient.getDatabase("Prueba");
            MongoCollection<Document> collection = database.getCollection("Login");

            System.out.println("What Username you want to view?");
            String search = readData.next();
            MongoCursor<Document> cursor = collection.find(eq("username", search)).iterator();

            try {
                while (cursor.hasNext()) {
                    System.out.println(cursor.next().toJson());
                }
            } finally {
                cursor.close();
            }
        } finally {
            if (mongoClient != null) {
                mongoClient.close();
            }
            readData.close();
        }
    }

    public static void modifyDocument() {
        String uri = "mongodb+srv://AxelH:panaderia2024@cluster0.0xpbdx0.mongodb.net/?retryWrites=true&w=majority";
        Scanner readData = new Scanner(System.in);
        MongoClient mongoClient = null;

        try {
            mongoClient = MongoClients.create(uri);
            MongoDatabase database = mongoClient.getDatabase("Prueba");
            MongoCollection<Document> collection = database.getCollection("Login");

            System.out.println("What Username you want to modify?");
            String search = readData.next();
            Document docmod = collection.find(eq("username", search)).first();
            System.out.println("Please insert new data:");

            System.out.print("Username: ");
            String username = readData.next();
            System.out.println("Password");
            String password = readData.next();

            Document doc1 = new Document("username", username).append("password", password);
            UpdateResult result = collection.replaceOne(docmod, doc1);
            System.out.println("Matched document count: " + result.getMatchedCount());
            System.out.println("Modified document count: " + result.getModifiedCount());
        } finally {
            if (mongoClient != null) {
                mongoClient.close();
            }
            readData.close();
        }
    }

    public static void showDatabase() {
        String uri = "mongodb+srv://AxelH:panaderia2024@cluster0.0xpbdx0.mongodb.net/?retryWrites=true&w=majority";
        Scanner readData = new Scanner(System.in);
        MongoClient mongoClient = null;

        try {
            mongoClient = MongoClients.create(uri);
            MongoDatabase database = mongoClient.getDatabase("Prueba");
            MongoCollection<Document> collection = database.getCollection("Login");

           MongoCursor<Document> cursor = collection.find().iterator();


            try {
                while (cursor.hasNext()) {
                    System.out.println(cursor.next().toJson());
                }
            } finally {
                cursor.close();
            }
        } finally {
            if (mongoClient != null) {
                mongoClient.close();
            }
            readData.close();
        }
    }

    public static void main(String[] args) {
        // Puedes llamar a tus métodos aquí según lo necesites
    }
}
