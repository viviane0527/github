package data.ws.config;

import data.ws.tools.Import;

public final class Configurator {

    private static volatile Config instance;

    private Configurator() {
        super();
    }

    public static Config getInstance() {
        synchronized (Configurator.class) {
            if (Configurator.instance == null) {
                Configurator.instance = (Config) Import.entityFromXML(Config.class, "ws-config.xml");
            }
        }
        return instance;
    }
}
