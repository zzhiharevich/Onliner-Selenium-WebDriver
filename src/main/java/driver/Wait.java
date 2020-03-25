package driver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {

    private WebDriverWait wait = new WebDriverWait(Browser.getDriver(), 20);

    public void waitUntilStaleness(WebElement elements) {
        wait.until(ExpectedConditions.stalenessOf(elements));
    }
}
