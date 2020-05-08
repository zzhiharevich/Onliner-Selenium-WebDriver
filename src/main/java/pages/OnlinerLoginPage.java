package pages;

import driver.Browser;
import utilities.WaitHandler;
import elements.Button;
import elements.Text;
import elements.TextField;
import org.openqa.selenium.WebElement;
import utilities.Locators;

/**
 * Класс предоставляющий связь с веб-страницей авторизации сайта.
 * @author Александра Жихаревич
 * @version 1.0
 */
public class OnlinerLoginPage {

    /**
     * Приватный объект, представляющий объект типа TextField; текстовое поле для ввода логина.
     */
    private TextField loginInput = new TextField(Locators.getLocator("onlinerLoginPage.textField.loginInput_xpath"));
    /**
     * Приватный объект, представляющий объект типа TextField; текстовое поле для ввода пароля.
     */
    private TextField passwordInput = new TextField(Locators.getLocator("onlinerLoginPage.textField.passwordInput_xpath"));
    /**
     * Приватный объект, представляющий объект типа Button; кнопка Войти.
     */
    private Button loginButton = new Button(Locators.getLocator("onlinerLoginPage.button.login_xpath"));
    /**
     * Приватный объект, представляющий объект тип Text; заголовок формы авторизации.
     */
    private Text entranceText = new Text(Locators.getLocator("onlinerLoginPage.text.entrance_xpath"));

    /**
     * Метода для авторизации пользователя.
     * @param login Логин
     * @param password Пароль
     */
    public void login(String login, String password) {
        loginInput.sendKeys(login);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    /**
     * Метод проверяет, открылась ли страница авторизации.
     * @return true - открылась / false - не открылась.
     */
    public boolean isPageOpen(){
        return entranceText.isExist();
    }

    /**
     * Метод для получения веб-элемента, отвещающего за страницу авторизации; используется в ожиданиях.
     * @return WebElement
     */
    private WebElement getLoginFormBackground() {
        return Browser.getDriver().findElement(Locators.getLocator("onlinerLoginPage.background_className"));
    }

    /**
     * Метод, использующий ожидания; ожидает до тех пор, пока не закроется страница авторизации.
     */
    public void waitUntilBackgroundStaleness() {
        new WaitHandler().waitUntilStaleness(getLoginFormBackground());
    }

}
