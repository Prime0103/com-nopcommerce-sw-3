package homepage;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utiliy;

public class TopMenuTest extends Utiliy{
    String baseUrl="https://demo.nopcommerce.com/";

    @Before
    public void setUp()
    {
        openBrowser(baseUrl);
    }
    //Create method with name "SelectMenu" it has one parameter name "menu" of type string
    public void selectMenu(String menu)
    {
        //This method should click on the menu whatever  name is passed as parameter
        WebElement menuElement = driver.findElement(By.linkText(menu));
        menuElement.click();
    }
    //create the @Test method name verifyPageNavigation. use selectMenu method to select the Menu and
    //click on it and verify the page navigation.
}



