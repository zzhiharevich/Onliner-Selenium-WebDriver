package pages;

import driver.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Log In Form class
 * @author Aleksandra Zhiharevich
 * @version 1.0
 */
public class LoginForm {

    /**
     * Constructor to find elements on page
     * @param browser browser[Firefox/Chrome]
     */
    public LoginForm(Browser browser){
        loginTextField = browser.getDriver()
                .findElement(By.xpath("//*[@id=\"auth-container\"]/div/div[2]/div/form/div[1]/div/div[2]/div/div/div/div/input"));
        passwordTextField = browser.getDriver()
                .findElement(By.xpath("//*[@id=\"auth-container\"]/div/div[2]/div/form/div[2]/div/div/div/div/input"));
        loginButton = browser.getDriver()
                .findElement(By.xpath("//*[@id=\"auth-container\"]/div/div[2]/div/form/div[3]/button"));
        entranceText = browser.getDriver()
                .findElements(By.xpath("//*[@id=\"auth-container\"]/div/div[2]/div/div[1]"));
    }

    /**
     * Log In text field
     */
    private WebElement loginTextField;
    /**
     * Password text field
     */
    private WebElement passwordTextField;
    /**
     * Log In button
     */
    private WebElement loginButton;
    /**
     * Entrance text "Вход"
     */
    private List<WebElement> entranceText;

    /**
     * Login method
     */
    public void login() {
        loginTextField.sendKeys("izhukharevich@icloud.com");
        passwordTextField.sendKeys("!Zzhiharevich");
        loginButton.click();
    }

    /**
     * Check is log in page open
     * @return true - yes / false - no
     */
    public boolean isPageOpen(){
        List<WebElement> elements = entranceText;
        if(elements.size() == 1)
            return true;
        return false;
    }

}
