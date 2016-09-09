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
        //
    }
}
