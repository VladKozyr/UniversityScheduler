package com.kma.scheduler.universityscheduler.logs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ErrorLogger {
    private static final Logger logger = LogManager.getLogger(ErrorLogger.class);

    public void logError(String message){
        logger.error(message);
    }

    public void logWarn(String message){
        logger.warn(message);
    }

    public void logFatal(String message) {logger.fatal(message);}
}
