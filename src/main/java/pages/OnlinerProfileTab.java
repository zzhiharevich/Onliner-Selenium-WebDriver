package pages;

import elements.Link;
import utilities.Locators;
import utilities.WaitHandler;

/**
 * Класс предоставляющий связь с открыващемся окном профиля на сайте, когда пользователь авторизован.
 * @author Александра Жихаревич
 * @version 1.0
 */
public class OnlinerProfileTab {

    /**
     * Приватный объект, предствавляющий веб-элемент типа Link; ссылка Выйти.
     */
    private Link exit = new Link(Locators.getLocator("onlinerProfileTab.link.exit_xpath"));

    /**
     * Метод, выполняющий нажатие на ссылку выйти и выход из системы.
     */
    public void logOut() {
        new WaitHandler().waitUntilClickable(exit);
        exit.click();
    }
}
