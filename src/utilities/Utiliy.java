package utilities;

import browserfactory.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utiliy extends BaseTest
{
    // This method will click on method
    public void clickOnElement(By by)
    {
        driver.findElement(by).click();
    }
    //This method will Enter the input into TextField
    public void sendTextToElements(By by, String text)
    {
        driver.findElement(by).sendKeys(text);
    }
    //This method will Get Text from Element
    public String getTextFromElement(By by)
    {
        return driver.findElement(by).getText();
    }
    //This method will select the option by visible text
    public void selectByVisibleTextFromDropDown(By by, String text)
    {
        WebElement dropDown = driver.findElement(by);
        Select select = new Select(dropDown);
        select.selectByVisibleText(text);
    }
    //This method will select the option by visible value
    public void selectByValueFromDropDown(By by,String value)
    {
        new Select(driver.findElement(by)).selectByValue(value);
    }
    //selectByIndex (int index)
    public void selectByIndex(By by, int index)
    {
        new Select(driver.findElement(by)).selectByIndex(index);
    }
    ////selectOptionByContainsText
    public void mouseHoverToElement(By by)
    {
        Actions actions =new Actions(driver);
        WebElement computer = driver.findElement(by);
        WebElement software = driver.findElement(by);
        //Mouse hover to computers
        actions.moveToElement(computer).build().perform();
    }
    //mouseHoverToElementAndClick
    public void mouseHoverToElementAndClick(By by)
    {
        Actions actions = new Actions(driver);
        WebElement computer = driver.findElement(by);
        WebElement software = driver.findElement(by);

        //Click on software in computer
        actions.moveToElement(software).click().build().perform();
    }
    /**
     * This method is used to  select radio button
     */
    public void selectRadioButton(By by) {
        driver.findElement(by).click();
    }
    /**
     * This method is used to select CheckBox
     */
    public void selectCheckBox(By by) {

        WebElement checkBox = driver.findElement(by);
        Actions actions = new Actions(driver);
        actions.moveToElement(checkBox);
        actions.perform();
        if (checkBox.isSelected()) {

        } else {
            checkBox.click();
        }
    }



}
