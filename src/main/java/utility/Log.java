package utility;

import org.apache.log4j.Logger;
import org.apache.log4j.lf5.util.StreamUtils;

/**
 * Created by wu on 9/18/2016.
 */
public class Log {
    //initialize Log4j logs
    private static Logger Log = Logger.getLogger(utility.Log.class.getName());

    //This is to print log for the beginning of the test case,
    //as we usually run so many tst cases as a test suite
    public static void startTestCase(String sTestCaseName){
        Log.info("****************************************");
        Log.info("****************************************");
        Log.info("$$$$$$       "+sTestCaseName+"     $$$$$");
        Log.info("****************************************");
        Log.info("****************************************");
    }
    //This is to print log for the ending of the test case
    public static void endTestCase(String sTestCaseName){
        Log.info("XXXXXXXXXXXXXX    "+"E--N--D"+"   XXXXXX");
        Log.info("X");
        Log.info("X");
        Log.info("X");
        Log.info("X");
    }
    //need to create these method, so that they an be called
    public static void info(String message){
        Log.info(message);
    }
    public static void warn(String message){
        Log.warn(message);
    }
    public static void error(String message){
        Log.error(message);
    }
    public static void debug(String message){
        Log.debug(message);
    }
}
