package pages;

import elements.Logo;
import elements.Text;
import utilities.Locators;

/**
 * Класс предоставляющий связь с главной веб-страницей сайта, когда пользователь авторизовался.
 * @author Александра Жихаревич
 * @version 1.0
 */
public class OnlinerThemePage {

    /**
     * Приватный объект, предствавляющий веб-элемент типа Text; заголовок страницы каталога.
     */
    private Text themeTitle = new Text(Locators.getLocator("onlinerThemePage.text.title_css"));
    /**
     * Приватный объект, предствавляющий веб-элемент типа Logo; логотип сайта onliner.
     */
    private Logo onlinerLogo = new Logo(Locators.getLocator("onlinerThemePage.logo.onliner_xpath"));

    /**
     * Метод для получения текста заголовка страницы каталога.
     * @return Текст заголовка типа String.
     */
    public String getThemeTitle(){
        return themeTitle.getText();
    }

    /**
     * Метод, выполняющий переход на главную страницу сайта.
     */
    public void goToMainPage(){
        onlinerLogo.click();
    }
}
