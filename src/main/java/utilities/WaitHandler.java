package utilities;

import driver.Browser;
import elements.Elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Класс, предоставляющий методы для работы с ожиданиями.
 * @author Александра Жихаревич
 * @version 1.0
 */
public class WaitHandler {

    WebDriver driver = Browser.getDriver();

    /**
     * Приватный объект класса WebDriverWait
     */
    private WebDriverWait wait = new WebDriverWait(driver, 20);

    /**
     * Метод, ожидающий до тех пор, пока веб-элемент больше не будет отображаться на странице.
     * @param element Веб-элемент
     */
    public void waitUntilStaleness(WebElement element) {
        wait.until(ExpectedConditions.stalenessOf(element));
    }

    /**
     * Метод, ожидающий до тех пор, пока веб-элемент отобразится на странице.
     * @param element Веб-элемент
     */
    public void waitUntilVisible(Elements element) {
        wait.until(ExpectedConditions.visibilityOf(element.getElement()));
    }

    /**
     * Метод, ожидающий до тех пор, пока веб-элемент станет кликабельным.
     * @param element Веб-элемент
     */
    public void waitUntilClickable(Elements element) {
        wait.until(ExpectedConditions.elementToBeClickable(element.getElement()));
    }
}
