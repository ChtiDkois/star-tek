package fr.vlaamsdk.startek;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.nuiton.config.ApplicationConfig;
import org.nuiton.config.ArgumentsParserException;

/**
 * @author ymartel (martel@codelutin.com)
 */
public class StarTekConfig {

    private static final Log log = LogFactory.getLog(StarTekConfig.class);

    protected static StarTekConfig instance = new StarTekConfig();

    public static StarTekConfig get() {
        return instance;
    }

    protected ApplicationConfig config;

    protected StarTekConfig() {
        ApplicationConfig configDefault = new ApplicationConfig("star-tek.properties");
        try {
            configDefault.parse();
        } catch (ArgumentsParserException e) {
            log.error("Error during config parsing.", e);
        }

        this.config = new ApplicationConfig(configDefault.getFlatOptions(), "star-tek-test.properties");
        try {
            this.config.parse();
        } catch (ArgumentsParserException e) {
            log.error("Error during test config parsing", e);
        }
    }

    public String getMongoUrl() {
        return this.config.getOption("startek.mongo.url");
    }

    public int getMongoPort() {
        return this.config.getOptionAsInt("startek.mongo.port");
    }

    public String getMongoDatabase() {
        return this.config.getOption("teko.mongo.database");
    }
}
