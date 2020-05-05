package pages;

import driver.Browser;
import driver.Wait;
import elements.Button;
import elements.Text;
import elements.TextField;
import org.openqa.selenium.WebElement;
import utilities.Locators;


public class OnlinerLoginPage {

    private TextField loginInput = new TextField(Locators.getLocator("onlinerLoginPage.textField.loginInput_xpath"));
    private TextField passwordInput = new TextField(Locators.getLocator("onlinerLoginPage.textField.passwordInput_xpath"));
    private Button loginButton = new Button(Locators.getLocator("onlinerLoginPage.button.login_xpath"));
    private Text entranceText = new Text(Locators.getLocator("onlinerLoginPage.text.entrance_xpath"));

    public void login(String login, String password) {
        loginInput.sendKeys(login);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    public boolean isPageOpen(){
        return entranceText.isExist();
    }

    private WebElement getLoginFormBackground() {
        return Browser.getDriver().findElement(Locators.getLocator("onlinerLoginPage.background_xpath"));
    }

    public void waitUntilBackgroundStaleness() {
        new Wait().waitUntilStaleness(getLoginFormBackground());
    }

}
