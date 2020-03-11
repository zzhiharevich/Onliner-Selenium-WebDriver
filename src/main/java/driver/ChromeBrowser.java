package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Chrome browser class implements Browser interface
 * @author Aleksandra Zhiharevich
 * @version 1.0
 */
public class ChromeBrowser implements Browser{

    /**
     * Driver field
     */
    private static WebDriver driver = null;

    /**
     * Constructor without params
     */
    public ChromeBrowser() { }

    /**
     * Method to check is driver created or to create driver
     * @return driver
     */
    public WebDriver getDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        return driver;
    }
}
