package elements;

import org.openqa.selenium.By;

public class PopularTheme extends Elements{

    public PopularTheme(By locator){
        super(locator);
    }

    public int size(){
        return getElements().size();
    }
}
