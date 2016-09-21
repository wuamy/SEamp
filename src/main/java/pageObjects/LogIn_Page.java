package pageObjects;

import org.openqa.selenium.*;
import utility.ExcelUtils;
import utility.Log;

/**
 * Created by wu on 9/20/2016.
 */
public class LogIn_Page extends BaseClass {
    private static WebElement element = null;

    public LogIn_Page(WebDriver driver){
        super(driver);
    }

    public static WebElement txtbx_UserName() throws Exception {
        try {
            element = driver.findElement(By.id("log"));
            Log.info("username text box is found on the Login Page");
        } catch (Exception e){
            Log.error("Username textbox is not found on the login page");
            throw (e);
        }
        return element;
    }

    public static WebElement txtbx_Password() throws Exception{
        try {
            element = driver.findElement(By.id("pwd"));
            Log.info("Password text box is found on the login page");
        } catch (Exception e){
            Log.error("Password text  box is not found on the login page");
        }
        return element;
    }

    public static WebElement btn_LogIn() throws Exception {
        try {
            element = driver.findElement(By.id("login"));
            Log.info("submit button is found on the login page");
        } catch (Exception e){
            Log.error("Submit button is not found on the login page");
            throw(e);
        }
        return element;

    }

}
