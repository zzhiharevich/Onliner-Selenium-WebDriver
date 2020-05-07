package utilities;

import driver.Browser;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Класс, предоставляющий методы для работы с ожиданиями.
 * @author Александра Жихаревич
 * @version 1.0
 */
public class Wait {

    /**
     * Приватный объект класса WebDriverWait
     */
    private WebDriverWait wait = new WebDriverWait(Browser.getDriver(), 20);

    /**
     * Метод, ожидающий до тех пор, пока веб-элемент больше не будет отображаться на странице.
     * @param elements Веб-элемент
     */
    public void waitUntilStaleness(WebElement elements) {
        wait.until(ExpectedConditions.stalenessOf(elements));
    }
}
