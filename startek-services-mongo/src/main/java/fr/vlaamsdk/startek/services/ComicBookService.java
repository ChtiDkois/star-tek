package fr.vlaamsdk.startek.services;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import fr.vlaamsdk.startek.persistence.ComicBook;
import fr.vlaamsdk.startek.persistence.MongoUtils;
import org.bson.Document;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author ymartel (martel@codelutin.com)
 */
@Path("")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ComicBookService {

    protected MongoUtils mongoUtils = new MongoUtils();

    @POST
    @Path("/comicbooks")
    public void create(ComicBook comicBook) {
        MongoDatabase database = mongoUtils.getDatabase();
        MongoCollection<ComicBook> comicBooksCollection = database.getCollection("ComicBooks", ComicBook.class);
        comicBooksCollection.insertOne(comicBook);
    }

    @GET
    @Path("/comicbooks/{id}")
    public ComicBook findComicBook(@PathParam("id") UUID id) {
        MongoDatabase database = mongoUtils.getDatabase();
        MongoCollection<ComicBook> comicBooksCollection = database.getCollection("ComicBooks", ComicBook.class);
        ComicBook comicBook = comicBooksCollection.find(Filters.eq("identifier", id)).first();
        return comicBook;
    }

    @GET
    @Path("/comicbooks/{id}/json")
    public Document findComicBookDocument(@PathParam("id") UUID id) {
        MongoDatabase database = mongoUtils.getDatabase();
        MongoCollection<Document> comicBooksCollection = database.getCollection("ComicBooks");
        Document comicBook = comicBooksCollection.find(Filters.eq("identifier", id)).first();
        return comicBook;
    }

    @GET
    @Path("/comicbooks")
    public List<ComicBook> findAll() {
        MongoDatabase database = mongoUtils.getDatabase();
        MongoCollection<ComicBook> comicBooksCollection = database.getCollection("ComicBooks", ComicBook.class);
        List<ComicBook> comicBooks = comicBooksCollection.find().into(new ArrayList<ComicBook>());

        return comicBooks;
    }
}
