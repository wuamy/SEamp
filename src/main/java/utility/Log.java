package utility;

import org.apache.log4j.Logger;

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
}
