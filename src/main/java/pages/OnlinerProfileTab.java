package pages;

import driver.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Onliner profile tab class (tab that opens after click onto profile logo)
 * @author Aleksandra Zhiharevich
 * @version 1.0
 */
public class OnlinerProfileTab {

    /**
     * Constructor to find elements on page
     * @param browser browser[Firefox/Chrome]
     */
    public OnlinerProfileTab(Browser browser){
        exit = browser.getDriver()
                .findElement(By.xpath("//*[@id=\"userbar\"]/div[1]/div[1]/div/div[1]/div[1]/div[2]/div/a"));
    }

    /**
     * Exit element (link)
     */
    private WebElement exit;

    /**
     * To log out (click onto exit)
     */
    public void logOut()
    {
        exit.click();
    }
}
