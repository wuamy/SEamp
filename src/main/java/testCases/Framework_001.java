package testCases;

import org.apache.log4j.xml.DOMConfigurator;
import org.apache.poi.hpsf.Util;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utility.*;
import pageObjects.*;
import appModules.*;

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
        //Launching the browser, this will take the browser type from test data sheet
        driver = Utils.OpenBrowser(iTestCaseRow);
        //Initializing the base class for selenium driver
        //now we do need to provide the selenium driver to any of the Page classes or module actions
        //will soon write a post on base class
        new BaseClass(driver);

    }

    //This is the starting of the main test case
    @Test
    public void main() throws Exception{
        //Every exception throw from any class or method, will be catch here
        //For exception handling
        // please see http://toolsqa.wpengine.com/selenium-webdriver/exception-handling-selenium-webdriver/
        try {
            //Here we are calling the SignIn Action and passing argument(iTestCaseRow)
            //This is called Modulization, when we club series of actions into one Module
            //For Modular Drive Framework, please see
            //http://toolsqa.wpengine.com/selenium-webdriver/modular-driven/
            SignIn_Action.Execute(iTestCaseRow);
            //This action is to select the Product category from the Top navigation of
            //the Home Page
            //I have converted this in to a module, as there are som many logics involved
            //into this selection
            //and it is always a best idea to keep your logics separate from your test case
            /**
            ProductSelect_Action.productType(iTestCaseRow);
            //This action is to select the product from the produt listing page
            //I have again converted this in to a module, as there are so many logics
            //involved in to this selection
            ProductSelect_Action.productNumber(iTestCaseRow);
            //This is to assigning product name and price to the variable
            //from the check out page, so that it can be matching the latest verification
            CheckOut_Action.Execute();
            //here we are calling the payment details action and passing argument(iTestCaseRow)
            //This action will provide all teh personal detail and on the page
            //and complete the payment for the select product
            PaymentDetails_Action.execute(iTestCaseRow);
            //This is to assigning product name, price to teh variable from the confirmation
            //page, so that it can be matched later
            Confirmation_Action.Execute();
            //This is to match the product name,
            Verification_Action.Execute(); */
            //Now your test is about to finish but before that you need to take descision
            //to pass or fail. If any of your verification is failed, this is to check
            //that is any of your verification during the execution is failed
            if (BaseClass.bResult == true) {
                //If the value of boolean variable is true, then your test  is
                //complete pass and do this
                ExcelUtils.setCellData("Pass", iTestCaseRow, Constant.Col_Result);
            } else {
                // if the value of boolean variable is false, then your test is fail, and
                // you like to report it accordingly
                // this is to throw exception in case of fail test, this exception
                // will be caught by catch block below
                throw new Exception("Test Case Fail because of Verification");
            }
            //Below are the steps you may like ot perform in case of failed test or any exception faced
            //before ending your test
        }catch (Exception e){
            //if in case you got any exception during the test, it will mark your test
            //as fail in the test result sheet
            ExcelUtils.setCellData("Fail", iTestCaseRow, Constant.Col_Result);
            // if the exception is in between the test, bcoz of any element not found
            //or anything, this will take screen shot
            Utils.takeScreenshot(driver, sTestCaseName);
            //This will print the error log message
            Log.error(e.getMessage());
            //Again throwing the exception to fail the test completely in TestNG result
            throw(e);

        }
    }

    // its time to close the finish the test case
    @AfterMethod
    public void afterMethod(){
        Log.endTestCase(sTestCaseName);
        // Closing the opened driver
        driver.close();
    }

}
