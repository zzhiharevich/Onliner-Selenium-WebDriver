package utilities;

import org.openqa.selenium.By;
import java.util.ResourceBundle;

/**
 * Класс, осуществляющий чтение и обработку значения локатора по ключу из properties файла.
 * @author Александра Жихаревич
 * @version 1.0
 */
public class Locators {

    /**
     * Приватный объект класса ResourceBundle, предоставляющий функционал для работы с properties файлом.
     */
    private static ResourceBundle locatorsResourceBundle;

    /**
     * Приватные типа локаторов.
     */
    private enum LocatorType{
        id, name, css, xpath, tag, text, partText, className;
    }

    /**
     * Инициализация поля locatorsResourceBundle.
     */
    static {
        locatorsResourceBundle = ResourceBundle.getBundle("locators");
    }

    /**
     * Метод, выполняющий чтение данных из properties файла. В зависимости от типа локатора, указанного в названии,
     * возвращает способ получения веб-элемента.
     * @param locator Ключ (имя) для поиска значения локатора в файле.
     * @return By объект (локатор)
     */
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
