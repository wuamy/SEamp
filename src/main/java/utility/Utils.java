package utility;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by wu on 9/18/2016.
 */
public class Utils {
    public static WebDriver driver = null;
    public static WebDriver OpenBrowser(int iTestCaseRow) throws Exception{
        String sBrowsername;
        try {
            sBrowsername = ExcelUtils.getCellData(iTestCaseRow, Constant.Col_Browser);
            if (sBrowsername.equalsIgnoreCase("Mozilla")){
                driver = new FirefoxDriver();
                Log.info("New driver instantiated");
                driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            }
        }
    }
}
