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

    }

}
