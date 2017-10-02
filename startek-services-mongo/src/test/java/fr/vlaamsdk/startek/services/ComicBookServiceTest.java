package fr.vlaamsdk.startek.services;

import de.flapdoodle.embed.mongo.MongodExecutable;
import de.flapdoodle.embed.mongo.MongodStarter;
import de.flapdoodle.embed.mongo.config.IMongodConfig;
import de.flapdoodle.embed.mongo.config.MongoCmdOptionsBuilder;
import de.flapdoodle.embed.mongo.config.MongodConfigBuilder;
import de.flapdoodle.embed.mongo.config.Net;
import de.flapdoodle.embed.mongo.distribution.Version;
import fr.vlaamsdk.startek.StarTekConfig;
import fr.vlaamsdk.startek.persistence.ComicBook;
import fr.vlaamsdk.startek.persistence.MongoUtils;
import fr.vlaamsdk.startek.persistence.Person;
import org.bson.Document;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * @author ymartel (martel@codelutin.com)
 */
public class ComicBookServiceTest {

    protected static MongodExecutable mongodExecutable;
    protected static StarTekConfig starTekConfig = StarTekConfig.get();

    @BeforeClass
	public static void beforeClass() throws IOException {

        MongodStarter starter = MongodStarter.getDefaultInstance();

        IMongodConfig mongodConfig = new MongodConfigBuilder()
			.version(Version.Main.PRODUCTION)
			.net(new Net(starTekConfig.getMongoUrl(), starTekConfig.getMongoPort(), false))
			.cmdOptions(new MongoCmdOptionsBuilder()
			.useSmallFiles(true)
			.useNoJournal(true)
			.useNoPrealloc(true)
			.build()).build();

            mongodExecutable = starter.prepare(mongodConfig);
            mongodExecutable.start();
	}

	@AfterClass
    public static void afterClass() {
        if (mongodExecutable != null) {
            mongodExecutable.stop();
        }
    }

    @Test
    public void testCreate() throws Exception {

        ComicBookService service = new ComicBookService();

        ComicBook comicBook = new ComicBook();
        comicBook.setTitle("Infinite Loop Tome 1");
        comicBook.setPages(112);
        comicBook.setLanguage("fr");
        comicBook.setEditor("IDW");
        comicBook.setPublisher("Glenat Comics");
        comicBook.setCollection("Glenat Comics USA");
        comicBook.setSummary("Teddy vit dans un futur lointain, un monde édulcoré et sans aspérité où il n'y a plus d'enjeux, plus de haine, et surtout... plus d'amour. Un monde en apparence apaisé et sans conflit et où les voyages spatiotemporels font partie du quotidien. Teddy y mène une existence parfaite, exerçant son travail de correcteur d'anomalies temporelles au sein d'une brigade gouvernementale. Sa vie se déroule sans accroc jusqu'à ce que l'une de ces anomalies prenne la forme d'une jeune femme. Teddy est alors confrontée à un choix terrible : osera-t-elle défier sa hiérarchie et sauver l'anomalie ou va-t-elle purement et simplement la supprimer ? Comment s’épanouir quand on vous empêche d'aimer librement ? C’est la question à laquelle tentent de répondre Pierrick Colinet et Elsa Charretier, couple d’auteurs français évoluant sur le marché américain, avec The Infinite Loop : une histoire humaniste où la S.F. est un moyen d’aborder des sujets plus délicats. The Infinite Loop a été à l'origine financée avec succès sur la plateforme de financement participatif Ulule. La série est publiée mensuellement aux États-Unis par l’éditeur IDW depuis avril 2015. Les éditions Glénat décident de l’éditer dans sa première version hard cover en août 2015.");
        comicBook.setNumber(1);
        comicBook.setCountry("fr");

        Person colinet = new Person("Colinet", "Pierrick");
        Person charretier = new Person("Charretier", "Elsa");
        comicBook.addWriter(colinet);
        comicBook.addArtist(charretier);
        comicBook.addColorsArtist(charretier);
        comicBook.addCoverArtist(charretier);
        comicBook.addLetterer(colinet);

        service.create(comicBook);

        List<ComicBook> comicBooks = service.findAll();
        Assert.assertNotNull(comicBooks);
        Assert.assertEquals(1, comicBooks.size());
        Assert.assertEquals(comicBook.getIdentifier(), comicBooks.get(0).getIdentifier());

        ComicBook foundComicBook = service.findComicBook(comicBook.getIdentifier());
        Assert.assertNotNull(foundComicBook);
        Assert.assertEquals(comicBook.getIdentifier(), foundComicBook.getIdentifier());

        Document comicBookDocument = service.findComicBookDocument(comicBook.getIdentifier());
        Assert.assertNotNull(comicBookDocument);
    }
}
