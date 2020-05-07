package pages;

import elements.Button;
import elements.Logo;
import utilities.Locators;

/**
 * Класс предоставляющий связь с главной веб-страницей сайта, когда пользователь еще не авторизовался.
 * @author Александра Жихаревич
 * @version 1.0
 */
public class OnlinerNotAuthorizedUserMainPage {

    /**
     * Приватный объект, предствавляющий веб-элемент типа Logo; логотип сайта onliner.
     */
    private Logo onlinerLogo = new Logo(Locators.getLocator("onlinerNotAuthorizedUserMainPage.logo.onliner_css"));
    /**
     * Приватный объект, предствавляющий веб-элемент типа Игеещт; кнопка Вход.
     */
    private Button loginButton = new Button(Locators.getLocator("onlinerNotAuthorizedUserMainPage.button.login_className"));

    /**
     * Метод, проверяющий, открылась ли главная страница.
     * @return true - открылась / false - не открылась.
     */
    public boolean isMainPageOpen(){
        return onlinerLogo.isExist();
    }

    /**
     * Метод, проверяющий, вышел ли пользователь из системы.
     * @return true - вышел / false - не вышел.
     */
    public boolean isLoggedOut(){
        return loginButton.isExist();
    }

    /**
     * Метод, выполняющий нажатие на кнопку входа и открывающий страницу авторизации.
     */
    public void clickLogIn() {
        loginButton.click();
    }
}
