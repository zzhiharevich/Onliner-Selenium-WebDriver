package pages;

import elements.Link;
import utilities.Locators;


public class OnlinerProfileTab {

    private Link exit = new Link(Locators.getLocator("onlinerProfileTab.link.exit_xpath"));

    public void logOut() {
        exit.click();
    }
}
