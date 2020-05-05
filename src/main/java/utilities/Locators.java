package utilities;

import org.openqa.selenium.By;

import java.util.ResourceBundle;

public class Locators {

    private static ResourceBundle locatorsResourceBundle;

    private enum LocatorType{
        id, name, css, xpath, tag, text, partText, className;
    }

    static {
        locatorsResourceBundle = ResourceBundle.getBundle("locators");
    }

    public static By getLocator(String locator){
        String[] locatorItems = locator.split("_",2);
        LocatorType locatorType = LocatorType.valueOf(locatorItems[1]);

        switch(locatorType) {

            case id :{
                return By.id(locatorsResourceBundle.getString(locator));
            }

            case name:{
                return By.name(locatorsResourceBundle.getString(locator));
            }

            case css:{
                return By.cssSelector(locatorsResourceBundle.getString(locator));
            }

            case xpath:{
                return By.xpath(locatorsResourceBundle.getString(locator));
            }

            case tag:{
                return By.tagName(locatorsResourceBundle.getString(locator));
            }

            case text:{
                return By.linkText(locatorsResourceBundle.getString(locator));
            }

            case partText:{
                return By.partialLinkText(locatorsResourceBundle.getString(locator));
            }

            case className:{
                return By.className(locatorsResourceBundle.getString(locator));
            }

            default:{
                throw new IllegalArgumentException("No such locator type: " + locatorItems[0]);
            }
        }
    }
}
