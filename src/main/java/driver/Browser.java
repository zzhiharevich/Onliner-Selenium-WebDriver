package driver;

import org.openqa.selenium.WebDriver;

/**
 * Browser interface
 * @author Aleksandra Zhiharevich
 * @version 1.0
 */
public interface Browser {
    /**
     * Method to check is driver created or to create driver
     * @return driver
     */
    WebDriver getDriver();
}
