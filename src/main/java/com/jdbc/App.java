package com.jdbc;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.MongoException;
import org.bson.Document;

public class App {

    public static void main(String[] args) {
        // Connection string format: mongodb://[username:password@]host1[:port1][,host2[:port2],...[,hostN[:portN]]][/[database][?options]]
        String connectionString = "mongodb://localhost:27017"; // Default MongoDB connection string
        
        try {
            // Create a MongoDB client
            MongoClient mongoClient = MongoClients.create(connectionString);

            // Connect to the "test" database
            MongoDatabase database = mongoClient.getDatabase("books_store");

            // Perform operations with the database
            System.out.println("Connected");
            MongoCollection<Document> collection = database.getCollection("Author");
            /*
            // Insert a single document
            Document document = new Document("fname", "John Doe")
                    .append("age", 30)
                    .append("city", "New York");
            collection.insertOne(document);
            
            // Insert multiple documents
            Document document1 = new Document("fname", "Alice")
                    .append("age", 25)
                    .append("city", "San Francisco");
            Document document2 = new Document("fname", "Bob")
                    .append("age", 35)
                    .append("city", "Los Angeles");
            collection.insertMany(List.of(document1, document2));*/

            //Read Query Documents
            /* 
            FindIterable<Document> documents = collection.find();
            try (MongoCursor<Document> cursor = documents.iterator()) {
                while (cursor.hasNext()) {
                    System.out.println(cursor.next());
                }
            }

            // Find documents with a specific condition
            FindIterable<Document> filteredDocuments = collection.find(new Document("age", new Document("$gt", 25)));*/
            //Updating Documents
            /*collection.updateOne(new Document("fname", "John Doe"), new Document("$set", new Document("age", 31)));

            // Update multiple documents
            collection.updateMany(new Document("age", new Document("$lt", 30)), new Document("$inc", new Document("age", 1)));*/
            //Delete Documents
            //collection.deleteOne(new Document("fname", "John Doe"));

            // Delete multiple documents
            //collection.deleteMany(new Document("age", new Document("$gte", 70)));
            // Close the MongoDB client
            mongoClient.close();
        } catch (MongoException e) {
            e.printStackTrace();
        }
    }
}
