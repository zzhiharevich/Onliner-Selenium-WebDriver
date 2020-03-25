package pages;

import driver.Browser;
import driver.Wait;
import elements.Button;
import elements.Text;
import elements.TextField;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class LoginForm {

    private static final String LOGIN_FORM_BACKGROUNG_LOCATOR = "//div[@class='auth-content']";
    private static final String LOGIN_INPUT_LOCATOR = "//*[@id=\"auth-container\"]/div/div[2]/div/form/div[1]/div/div[2]/div/div/div/div/input";
    private static final String PASSWORD_INPUT_LOCATOR = "//*[@id=\"auth-container\"]/div/div[2]/div/form/div[2]/div/div/div/div/input";
    private static final String LOGIN_BUTTON_LOCATOR = "//*[@id=\"auth-container\"]/div/div[2]/div/form/div[3]/Button";
    private static final String ENTRANCE_TEXT_LOCATOR = "//*[@id=\"auth-container\"]/div/div[2]/div/div[1]";

    private TextField loginInput = new TextField(By.xpath(LOGIN_INPUT_LOCATOR));
    private TextField passwordInput = new TextField(By.xpath(PASSWORD_INPUT_LOCATOR));
    private Button loginButton = new Button(By.xpath(LOGIN_BUTTON_LOCATOR));
    private Text entranceText = new Text(By.xpath(ENTRANCE_TEXT_LOCATOR));

    public void login(String login, String password) {
        loginInput.sendKeys(login);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    public boolean isPageOpen(){
        return entranceText.isExist();
    }

    private WebElement getLoginFormBackground() {
        return Browser.getDriver().findElement(By.xpath(LOGIN_FORM_BACKGROUNG_LOCATOR));
    }

    public void waitUntilBackgroundStaleness() {
        new Wait().waitUntilStaleness(getLoginFormBackground());
    }

}
