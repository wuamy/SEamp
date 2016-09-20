package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.Log;
import utility.Utils;


/**
 * Created by amy on 9/19/2016.
 */
public class Home_Page extends BaseClass {
    private static WebElement element = null;
    public Home_Page(WebDriver driver){
        super(driver);

    }
    public static WebElement lnk_MyAccount() throws Exception{
        try {
            element = driver.findElement(By.cssSelector(".account_icon"));
            Log.info("My Account link is found on the home page");
        } catch (Exception e){
            Log.error("My account link is not found on the home page!");
            throw (e);
        }
        return element;
    }

    public static WebElement lnk_LogOut(WebDriver driver){
        try {
            element = driver.findElement(By.cssSelector("#account_logout>a"));
            Log.info("Log out link element is found");
        } catch (Exception e){
            Log.error("Log Out link is not found on the Home Page");
            throw (e);
        }
        return element;
    }
}
