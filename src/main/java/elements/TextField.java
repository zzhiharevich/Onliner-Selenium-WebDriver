package elements;

import org.openqa.selenium.By;

public class TextField extends Elements{

    public TextField(By locator){
        super(locator);
    }

    public void sendKeys(String keys) {
        getElement().sendKeys(keys);
    }
}
