package course3.lesson6;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class AppLog4j {
    private static final Logger log = LogManager.getLogger(AppLog4j.class);

    // FATAL - 100
    // ERROR - 200
    // WARN - 300
    // INFO - 400
    // DEBUG - 500
    // TRACE - 600
    // ALL - Integer.MAX_VALUE
    public static void main(String[] args) {
        if(log.isDebugEnabled()){
            log.debug("Program");
        }
        log.info("Program started " + Arrays.toString(args));
        log.debug("Program started debug {}", () -> Arrays.toString(args));
    }
}
