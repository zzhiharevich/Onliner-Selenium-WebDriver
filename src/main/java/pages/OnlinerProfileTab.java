package pages;

import elements.Link;
import org.openqa.selenium.By;


public class OnlinerProfileTab {

    private static final String EXIT_LOCATOR = "//*[@id=\"userbar\"]/div[1]/div[1]/div/div[1]/div[1]/div[2]/div/a";

    private Link exit = new Link(By.xpath(EXIT_LOCATOR));

    public void logOut() {
        exit.click();
    }
}
