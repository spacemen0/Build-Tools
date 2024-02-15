package se.liu.ida.hello;

import org.joda.time.LocalTime;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configuration;

public class TimeRetriever {
    public static String getTimeMessage() {
        Logger logger = LogManager.getLogger(TimeRetriever.class);
        LocalTime localTime = new LocalTime();
        LoggerContext context = (LoggerContext) LogManager.getContext(false);
        Configuration config = context.getConfiguration();
        logger.error("Configuration Source: " + config.getConfigurationSource().toString());
        logger.info("Requested time string: " + localTime.toString());
        return "TODO list: " + localTime.toString();
    }
}