package main;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 11/24/2013
 * Time: 1:26 AM
 * To change this template use File | Settings | File Templates.
 */
public class AcidothLogger {
    static Logger logger = Logger.getLogger("AcidothLog");

    static {

        FileHandler fh;

        try {

            // This block configure the logger with handler and formatter
            fh = new FileHandler("acidothlog.log");
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);

        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Logger getLogger(){
        return logger;
    }
}
