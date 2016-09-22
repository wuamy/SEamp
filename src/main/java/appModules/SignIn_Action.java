package appModules;

import com.thoughtworks.selenium.webdriven.commands.Click;
import org.testng.Reporter;
import pageObjects.Home_Page;
import pageObjects.LogIn_Page;
import utility.Constant;
import utility.ExcelUtils;
import utility.Log;
import utility.Utils;

/**
 * Created by wu on 9/5/2016.
 */
// This is called Modularization, when we club series of actions in to one
// Module. for Modular driven framework, please see
// http://toolsqa.wpengine.com/selenium-webdriver/modular-driven/
public class SignIn_Action {
    //iTestcaseRow is the row number of our Testcase name in the Test Data sheet
    //iTestcaseRow is passed as an argument to this method, so that it can used
    //inside this method. for use of functions, parameters. please check
    //http://toolsqa.wpengine.com/selenium-webdriver/function-parameters/

    public static void Execute(int iTestCaseRow) throws Exception{
        //Clicking on the my account link on the home page
        Home_Page.lnk_MyAccount().click();
        Log.info("Click action is performed on my account link");
        //Storing the username in to a string variable and getting the username from test
        //data excel sheet
        //iTestcaseRow is the row nmber of our testcase name in the test data sheet
        //Constant.col_username is the colum number for username column in the test data sheet
        //please see the constant class in the utility package
        //for use of constant variables, please see http://toolsqa.wpengine.com/selenium-webdriver/constant-variables/
        String sUserName = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_UserName);
        //here we are sending the username string to the username textbox on the LogIN page
        //This is call page object model
        //for use of pom, please see http://toolsqa.wpengine.com/selenium-webdriver/page-object-model/
        LogIn_Page.txtbx_UserName().sendKeys(sUserName);
        //printing the logs for what we have just performed
        String sPassword = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_Password);
        LogIn_Page.txtbx_Password().sendKeys(sPassword);
        Log.info(sPassword+" is entered in password text box");
        LogIn_Page.btn_LogIn().click();
        Log.info("Click action is performed on submit button");
        //I noticed in few run that selenium is trying to perform the next action before the complete page
        //load. so I have decided ot put a wait on the logout link element
        //now it will wait 10 secs separately before jumping out to next step
        Utils.waitForElement(Home_Page.lnk_LogOut());

        //this is another type of logging, with the help of testng reporter log
        //this has to be very carefully used, you should only print the very important
        //message in to this. this will populate the logs in the testng html report
        //i have used this reporter log just once in this whole module
        Reporter.log("SignIn action is successfully performed!");




    }

}
