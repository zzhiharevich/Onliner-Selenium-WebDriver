package elements;

import driver.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public abstract class Elements {
    private By locator;

    Elements(By locator) {
        this.locator = locator;
    }

    WebElement getElement() {
        return Browser.getDriver().findElement(locator);
    }

    public List<WebElement> getElements(){
        return Browser.getDriver().findElements(locator);
    }

    public void click(){
        getElement().click();
    }

    public String getText(){
        return getElement().getText();
    }

    public boolean isExist(){
        return getElements().size() > 0;
    }
}
