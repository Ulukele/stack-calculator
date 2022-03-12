package Logging;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class EventsLogger {
    private static final Logger logger = Logger.getLogger("events-logger");

    static public void configure() throws IOException {
        LogManager.getLogManager().readConfiguration(EventsLogger.class.getResourceAsStream("configuration.properties"));
    }

    static public void log(Level level, String message) {
        logger.log(level, message);
    }

    static public void logp(Level level, String sourceClass, String sourceMethod, String message) {
        logger.logp(level, sourceClass, sourceMethod, message);
    }

    static public void throwing(String sourceClass, String sourceMethod, Throwable thrown) {
        logger.throwing(sourceClass, sourceMethod, thrown);
    }
}
