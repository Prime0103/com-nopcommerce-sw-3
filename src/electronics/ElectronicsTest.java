package electronics;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utiliy;

public class ElectronicsTest extends Utiliy
{
    String baseUrl="https://demo.nopcommerce.com/";
    @Before
    public void setUp()
    {
        openBrowser(baseUrl);
    }
    @Test
    public void verifyUserShouldNavigateToCellPhonesPageSuccessfully()
    {
        //Mouse Hover on “Electronics” Tab
        mouseHoverToElement(By.xpath("//a[text()='Electronics '] "));
        //Mouse Hover on “Cell phones” and click
        mouseHoverToElementAndClick(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));
        String expectedMessage ="Cell phones";
        String actualMessage =getTextFromElement(By.xpath("//h1[contains(text(),'Cell phones')]"));
        Assert.assertEquals("",expectedMessage,actualMessage);
    }
    @Test

    public void  verifyThatTheProductAddedSuccessfullyAndPlaceOrderSuccessfully() throws InterruptedException {
        //Mouse Hover on “Electronics” Tab
        mouseHoverToElement(By.xpath("//a[text()='Electronics '] "));
        //Mouse Hover on “Cell phones” and click
        mouseHoverToElementAndClick(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Cell phones']"));
        String expectedMessage = "Cell phones";
        String actualMessage = getTextFromElement(By.xpath("//h1[contains(text(),'Cell phones')]"));
        Assert.assertEquals("", expectedMessage, actualMessage);
        // Click on List View Tab
        clickOnElement(By.xpath("//a[contains(text(),'List')]"));
        Thread.sleep(1000);
        // Click on product name “Nokia Lumia 1020” link
        clickOnElement(By.xpath("//h2[@class='product-title']//a[contains(text(),'Nokia Lumia 1020')]"));
        //Verify the text “Nokia Lumia 1020”
        String expectedTxt = "Nokia Lumia 1020";
        String actualTxt = getTextFromElement(By.xpath("//h1"));
        Assert.assertEquals("", expectedTxt, actualTxt);
        Thread.sleep(1000);
        //Verify the price “$349.00”
        String expectedPrice = "$349.00";
        String actualPrice = getTextFromElement(By.xpath("//span[@id='price-value-20']"));
        Assert.assertEquals("", expectedPrice, actualPrice);
        //Change quantity to 2
        driver.findElement(By.xpath("//input[@id='product_enteredQuantity_20']")).clear();
        sendTextToElements(By.xpath("//input[@id='product_enteredQuantity_20']"), "2");
        //Click on “ADD TO CART” tab
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-20']"));
        Thread.sleep(1000);
        String expectedMsg = "The product has been added to your shopping cart";
        String actualMsg = getTextFromElement(By.xpath("//p[@class='content']"));
        Assert.assertEquals("", expectedMsg, actualMsg);
        Thread.sleep(1000);
        //After that close the bar clicking on the cross button.
        clickOnElement(By.xpath("//span[@title='Close']"));
        // Then MouseHover on "Shopping cart" and Click on "GO TO CART" button
        mouseHoverToElementAndClick(By.xpath("//a[contains(text(),'shopping cart')]"));
        // Verify the message "Shopping cart"
        String expectedtxt = "Shopping cart";
        String actualtxt = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        Thread.sleep(1000);

        // Verify the quantity is 2
        //String expectedQnt= "2";
        //String actualQnt =getTextFromElement(By.xpath("//input[@id='itemquantity11231']"));
        //Assert.assertEquals(expectedQnt,actualQnt);

        //Verify the Total $698.00
        String expected_price="$698.00";
        String actual_price=getTextFromElement(By.xpath("//span[@class='product-subtotal']"));
        Assert.assertEquals("",expected_price,actual_price);
        // click on checkbox “I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        // Click on “CHECKOUT”
        clickOnElement(By.xpath("//button[@id='checkout']"));
        //
        String expStr="Welcome, Please Sign In!";
        String actstr= getTextFromElement(By.xpath("//h1"));
        Assert.assertEquals(expStr,actstr);
        // Click on “REGISTER” tab
        clickOnElement(By.xpath("//a[contains(text(),'Register')]"));
        String expectstr= "Register";
        String actualstr= getTextFromElement(By.xpath("//h1"));
        Assert.assertEquals(expectstr,actualstr);
        //Fill the mandatory fields
        clickOnElement(By.xpath("//label[contains(text(),'Female')]"));
        sendTextToElements(By.xpath("//input[@id='FirstName']"),"Nenshi");
        sendTextToElements(By.xpath("//input[@id='LastName']"),"patel");
        selectByVisibleTextFromDropDown(By.xpath("//select[@name='DateOfBirthDay']"),"2");
        selectByVisibleTextFromDropDown(By.xpath("//select[@name='DateOfBirthMonth']"),"March");
        selectByVisibleTextFromDropDown(By.xpath("//select[@name='DateOfBirthYear']"),"1993");
        sendTextToElements(By.xpath("//input[@id='Email']"),"prime007@gmail.com");
        clickOnElement(By.xpath("//input[@id='Newsletter']"));
        sendTextToElements(By.xpath("//input[@id='Password']"),"Prime@1234");
        sendTextToElements(By.xpath("//input[@id='ConfirmPassword']"),"Prime@1234");
        clickOnElement(By.xpath("//button[@id='register-button']"));
        // Verify the message “Your registration completed”
        String expMsg1="Your registration completed";
        String actMsg1=getTextFromElement(By.xpath("//div[contains(text(),'Your registration completed')]"));
        Assert.assertEquals(expMsg1,actMsg1);
        //Click on Continue tab
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
        // Verify the text “Shopping card”
        String expVerify= "Shopping cart";
        String actalverify= getTextFromElement(By.xpath("//h1"));
        Assert.assertEquals(expVerify, actalverify);
    }

}
