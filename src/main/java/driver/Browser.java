package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public abstract class Browser {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }


    public static void setBrowser(Type type) {
        if (null != driver){
            driver.quit();
        }

        switch (type) {
            case CHROME: {
                driver = browserChrome();
                break;
            }
            case FIREFOX: {
                driver = browserFirefox();
                break;
            }
            case IE: {
                driver = browserIE();
                break;
            }
            default:
                break;
        }
    }

    private static WebDriver browserChrome() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    private static WebDriver browserFirefox() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    private static WebDriver browserIE() {
        WebDriverManager.iedriver().setup();
        return new InternetExplorerDriver();
    }
}
