package elements;

import org.openqa.selenium.By;

/**
 * Класс, наследуемый от обстрактного класса Elements, предоставляющий методы для работы с веб-элементами - текстовыми полями.
 * @author Александра Жихаревич
 * @version 1.0
 */
public class TextField extends Elements{

    /**
     * Конструктор, инициализирующий поле locator данными, переданными через параметр.
     * @param locator Локатор, идентифицирующий веб-элемент.
     */
    public TextField(By locator){
        super(locator);
    }

    /**
     * Метод для передачи веб-элементу (текстовому полю) данных в формате String.
     * @param keys Данные, передоваемые веб-элементу в формате String
     */
    public void sendKeys(String keys) {
        getElement().sendKeys(keys);
    }
}
