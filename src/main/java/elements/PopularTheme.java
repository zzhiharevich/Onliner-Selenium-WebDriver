package elements;

import org.openqa.selenium.By;

/**
 * Класс, наследуемый от обстрактного класса Elements, предоставляющий методы для работы с веб-элементами, воспринимающимися
 * как популярные темы.
 * @author Александра Жихаревич
 * @version 1.0
 */
public class PopularTheme extends Elements{

    /**
     * Конструктор, инициализирующий поле locator данными, переданными через параметр.
     * @param locator Локатор, идентифицирующий веб-элемент.
     */
    public PopularTheme(By locator){
        super(locator);
    }

    /**
     * Метод для получения размера листа, хранящего веб-элементы заданного локатора.
     * @return
     */
    public int size(){
        return getElements().size();
    }
}
