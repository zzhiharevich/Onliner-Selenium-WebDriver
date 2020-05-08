package elements;

import driver.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Абстрактный класс, предоставляющий стандартные методы для работы с веб-элментами.
 * @author Александра Жихаревич
 * @version 1.0
 */
public abstract class Elements {

    /**
     * Приватный объект, хранящий в себе значение локатора, идентифицируещего веб-элемент.
     */
    private By locator;

    /**
     * Конструктор, инициализирующий поле locator данными, переданными через параметр.
     * @param locator локатор веб-элемента
     */
    Elements(By locator) {
        this.locator = locator;
    }

    /**
     * Метод для получения веб-элемента, найденного драйвером по заданному локатору.
     * @return Найденный WebElement
     */
    public WebElement getElement() {
        return Browser.getDriver().findElement(locator);
    }

    /**
     * Метод для получения листа веб-элементов, найденных драйвером по заданному локатору.
     * @return Найденный List<WebElement>
     */
    public List<WebElement> getElements(){
        return Browser.getDriver().findElements(locator);
    }

    /**
     * Метод, осуществляющий нажатие на веб-элемент.
     */
    public void click(){
        getElement().click();
    }

    /**
     * Метод для получения текста веб-элемента.
     * @return Текст веб-элемента как String
     */
    public String getText(){
        return getElement().getText();
    }

    /**
     * Метод, проверяющий существования веб-элемента.
     * @return true - существует / false - не существует.
     */
    public boolean isExist(){
        return getElements().size() > 0;
    }
}
