package pages;

import elements.Logo;
import elements.PopularTheme;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import utilities.Locators;
import utilities.WaitHandler;

import java.util.Random;

/**
 * Класс предоставляющий связь с главной веб-страницей сайта, когда пользователь авторизовался.
 * @author Александра Жихаревич
 * @version 1.0
 */
public class OnlinerAuthorizedUserMainPage {

    /**
     * Приватный объект, предствавляющий веб-элемент типа Logo; логотип сайта onliner.
     */
    private Logo onlinerLogo = new Logo(Locators.getLocator("onlinerAuthorizedUserMainPage.logo.onliner_css"));
    /**
     * Приватный объект, представляющий веб-элемент типа Logo; логотип-фотография пользователя.
     */
    private Logo profileLogo = new Logo(Locators.getLocator("onlinerAuthorizedUserMainPage.logo.profile_xpath"));
    /**
     * Приватный объект, представляющий веб-элемент типа PopularTheme; список популярных тем на ве-странице.
     */
    private PopularTheme popularThemesList = new PopularTheme(Locators.getLocator("onlinerAuthorizedUserMainPage.popularThemes.themes_xpath"));

    /**
     * Метод, открывающий окно профиля.
     */
    public void logOut(){
        new WaitHandler().waitUntilVisible(profileLogo);
        profileLogo.click();
    }

    /**
     * Метод, для перехода на страницу каталога определенной популярной темы и получения названия этой темы.
     * @param themeNumber Номер популярной темы в листе, хранящем все популярные темы.
     * @return Название популярной темы типа String.
     */
    public String goToRandomTheme(int themeNumber){
        WebElement theme = popularThemesList.getElements().get(themeNumber);
        String themeText = theme.getText();
        theme.click();
        return  themeText;
    }

    /**
     * Метод для получения случайным образом номер одной популярной темы из всех.
     * @return Номер случайно популярной темы типа int.
     */
    public int getOneRandomPopularTheme(){
        Random random = new Random();
        int numberOfPopularThemes = popularThemesList.size();
        return random.nextInt(7);
    }

    /**
     * Метод, проверящий успешность авторизации пользователя.
     * @return true - пользователь авторизован / false - пользователь не авторизован.
     */
    public boolean isSuccessfulLogIn(){
        return profileLogo.isExist();
    }

    /**
     * Метод, проверяющий, открылась ли главная страница.
     * @return true - открылась / false - не открылась.
     */
    public boolean isMainPageOpen(){
        return onlinerLogo.isExist();
    }
}
