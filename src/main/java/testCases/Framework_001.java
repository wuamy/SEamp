package testCases;

import org.apache.log4j.xml.DOMConfigurator;
import org.apache.poi.hpsf.Util;
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
        //Getting the Test Case name, as it will going to use in so many places
        //The main use is to get the TestCase row from the Test Data sheet
        sTestCaseName = this.toString();
        //From above method we get long test case name including package and class name
        //The below method will refine your test case name, exactly the name user have used
        sTestCaseName = Utils.getTestCaseName(this.toString());
        //Start printing the logs and printing the Test case name
        Log.startTestCase(sTestCaseName);
        // Setting up the Test data excel file using Constants variables
        // For constant variables please see http://toolsqa.wpengine.com/selenium-webdriver/constant-variables/
        // For setting up Excel for data driven testing, please see http://toolsqa.wpengine.com/selenium-webdriver/data-driven-testing-excel-poi/
        ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"Sheet1");
        //Fetching the Test Case row number from teh test data sheet
        //This row number will be feed to so many functions, to get the relevant data from the Test Data sheet
        iTestCaseRow = ExcelUtils.getRowContains(sTestCaseName, Constant.Col_TestCaseName);




    }
}
