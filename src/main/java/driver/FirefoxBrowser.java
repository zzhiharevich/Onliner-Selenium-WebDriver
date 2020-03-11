package driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Firefox browser class implements Browser interface
 * @author Aleksandra Zhiharevich
 * @version 1.0
 */
public class FirefoxBrowser implements Browser{

    /**
     * Driver field
     */
    private static WebDriver driver = null;

    /**
     * Constructor without params
     */
    public FirefoxBrowser() {}

    /**
     * Method to check is driver created or to create driver
     * @return driver
     */
    public WebDriver getDriver() {
        if (driver == null) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        return driver;
    }
}
