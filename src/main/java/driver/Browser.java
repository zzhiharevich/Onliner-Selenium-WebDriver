package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * Класс для управления драйвером браузера.
 * @author Александра Жихаревич
 * @version 1.0
 */
public class Browser {

    /**
     * Приватный объект класс WebDriver, предоставляющий функционал для работы с драйвером.
     */
    private static WebDriver driver;

    /**
     * Публичный метод для получения объекта driver.
     * @return Объект класса WebDriver.
     */
    public static WebDriver getDriver() {
        return driver;
    }

    /**
     * Публичный метод, установливающий драйвер для определенного браузера. Тип браузера получает через параметр.
     * Перед установкой драйвела, проверяет, был ли драйвер установлен ранее. Если был, то закрывает предыдущий драйвер.
     * @param type Строка с типом браузера.
     */
    public static void setBrowser(String type) {
        if (null != driver){
            driver.quit();
        }

        if ("CHROME".equals(type)) {
            driver = browserChrome();
        } else if ("FIREFOX".equals(type)) {
            driver = browserFirefox();
        } else if ("IE".equals(type)) {
            driver = browserIE();
        }
    }

    /**
     * Приватный метод для настройки драйвера для типа браузепа CHROME.
     * @return Драйвер для браузера типа CHROME.
     */
    private static WebDriver browserChrome() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    /**
     * Приватный метод для настройки драйвера для типа браузепа FIREFOX.
     * @return Драйвер для браузера типа FIREFOX.
     */
    private static WebDriver browserFirefox() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    /**
     * Приватный метод для настройки драйвера для типа браузепа IE.
     * @return Драйвер для браузера типа IE.
     */
    private static WebDriver browserIE() {
        WebDriverManager.iedriver().setup();
        return new InternetExplorerDriver();
    }
}
