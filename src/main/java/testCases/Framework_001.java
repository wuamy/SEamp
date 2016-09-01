package testCases;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by amy on 9/1/2016.
 */
public class Framework_001 {
    public WebDriver driver;
    private String sTestCaseName;
    private int iTestCaseRow;

    //Following Testng Test case pattern, divided a test case in to three different part
    //in before method, the code was always be the same for every other test case
    // in other way before method is the prerequisties of your main Test Case
    @BeforeMethod
    public void beforeMethod() throws Exception {
        //Configuring Log4j logs. please see the following posts to learn about Log4j Logging
        //http://toolsqa.wpengine.com/selenium-webdriver/test-case-with-log4j/
        // http://toolsqa.wpengine.com/selenium-webdriver/log4j-logging/
        DOMConfigurator.configure("log4j.xml");


    }
}
