package fr.vlaamsdk.startek.persistence;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;
import fr.vlaamsdk.startek.StarTekConfig;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

/**
 * @author ymartel (martel@codelutin.com)
 */
public class MongoUtils {

    protected StarTekConfig config = StarTekConfig.get();

    protected CodecRegistry pojoCodecRegistry;
    protected MongoClient mongoClient;
    protected MongoClientOptions mongoClientOptions;

    public MongoDatabase getDatabase() {
        MongoDatabase database = getMongoClient().getDatabase(config.getMongoDatabase());
        return database;
    }

    protected MongoClient getMongoClient() {
        if (this.mongoClient == null) {
            this.mongoClient = new MongoClient(new ServerAddress(config.getMongoUrl(), config.getMongoPort()), getMongoClientOptions());
        }
        return mongoClient;
    }

    protected MongoClientOptions getMongoClientOptions() {
        if (this.mongoClientOptions == null) {
            this.mongoClientOptions = MongoClientOptions.builder().codecRegistry(getPojoCodecRegistry()).build();
        }
        return this.mongoClientOptions;
    }

    protected CodecRegistry getPojoCodecRegistry() {
        if (this.pojoCodecRegistry == null) {
            this.pojoCodecRegistry = fromRegistries(MongoClient.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        }
        return this.pojoCodecRegistry;
    }
}
