package appModules;

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
    //iTestcaseRow is the row number of our Testcase name in the test data sheet
    //iTestcaseRow is passed as an argument to this method, so that it can use inside this method
    // for use of functions and parameters, pleas see http://toolsqa.wpengine.com/selenium-webdriver/function-parameters/
    public static void Execute(int iTestCaseRow) throws Exception{
        //Click on the My Account link on the Home Page
        Home_Page.lnk_MyAccout().click;
        Log.info("Click action is performed on My Account link");
        //store the UserName in to a String variable and getting the UserName from Test Data excel sheet
        //iTestcaseRow is the row number of our tset case name in the test data sheet
        //constant.col_UserName is the column number for UserName column in the test data sheet
        //Please see the constant class in the Utility Package
        //for use of constant variable, please see http://toolsqa.wpengine.com/selenium-webdriver/constant-variables/
        String sUserName = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_UserName);
        //Here we are sending the UserName string to the UserName Textbox on the Login page
        //This is call Page Object Model
        //for use of POM, please see http://toolsqa.wpengine.com/selenium-webdriver/page-object-model/
        LogIn_Page.txtbx_UserName().sendKeys(sUserName);
        //Printing the logs for what we have just performed
        Log.info(sUserName + "is entered in UserName textbox");
        String sPassword = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_Password);
        LogIn_Page.txtbx_Password().sendKeys(sPassword);
        Log.info(sPassword + " is entered in Password textbox");
        LogIn_Page.btn_LogIn().click();
        Log.info("Click action is performed on submit button");

    }
}
