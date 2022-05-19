package course3.lesson6;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


// Log4j ver.2
// SLF4j
//SEVERE > WARNING > INFO > CONFIG > FINE > FINEST > ALL
public class AppJavaLogger {
    private static final Logger log =  Logger.getLogger(AppJavaLogger.class.getName());

    public static void main(String[] args) {
        log.setLevel(Level.INFO);
        try {
            FileHandler fileHandler = new FileHandler("mylog.log");
            fileHandler.setFormatter(new SimpleFormatter());
            log.addHandler(fileHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.log(Level.FINE, "Program started");
        AppJavaLogger appJavaLogger = new AppJavaLogger();
        appJavaLogger.m("abc", 5);
        log.fine("Program started");
    }
    private void m(String abc, int i) {
        log.info(" Method m() start a = " + abc + ", i = " + i);
        try {
            i /= 0;
        } catch (Exception e) {
            log.severe(" Error " + e.getMessage());
            e.printStackTrace();
        }
    }
}
