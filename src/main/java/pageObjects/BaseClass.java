package pageObjects;

import org.openqa.selenium.WebDriver;

/**
 * Created by amy on 9/19/2016.
 */
public class BaseClass {
    public static WebDriver driver;
    public static boolean bResult;
    public BaseClass(WebDriver driver){
        BaseClass.driver = driver;
        BaseClass.bResult = true;
    }
}
