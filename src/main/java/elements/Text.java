package elements;

import org.openqa.selenium.By;

/**
 * Класс, наследуемый от обстрактного класса Elements, предоставляющий методы для работы с веб-элементами - текст.
 * @author Александра Жихаревич
 * @version 1.0
 */
public class Text extends Elements{

    /**
     * Конструктор, инициализирующий поле locator данными, переданными через параметр.
     * @param locator Локатор, идентифицирующий веб-элемент.
     */
    public Text(By locator){
        super(locator);
    }
}
