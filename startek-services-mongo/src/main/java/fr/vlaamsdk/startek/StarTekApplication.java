package fr.vlaamsdk.startek;

import fr.vlaamsdk.startek.services.ComicBookService;

import javax.naming.NamingException;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * @author ymartel (martel@codelutin.com)
 */
@ApplicationPath("/")
public class StarTekApplication extends Application {

    HashSet<Object> singletons = new HashSet<>();

    public StarTekApplication() throws NamingException {
        singletons.add(new ComicBookService());
    }

    @Override
    public Set<Class<?>> getClasses() {
        HashSet<Class<?>> set = new HashSet<>();
        return set;
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
}
