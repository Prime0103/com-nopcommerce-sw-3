package computer;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utiliy;

public class TestSuite extends Utiliy {
    String baseurl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseurl);
    }

    @Test
    public void verifyProductArrangeInAlphaBaticalOrder() throws InterruptedException {
        //Click on Computer Menu
        clickOnElement(By.xpath("//ul[@class='top-menu notmobile']//a[normalize-space()='Computers']"));
        //Click on Desktop
        clickOnElement(By.xpath("//a[@title='Show products in category Desktops'][normalize-space()='Desktops']"));
        Thread.sleep(1000);
        clickOnElement(By.xpath("//select[@id='products-orderby']"));
        Thread.sleep(1000);
        // Select Sort By position "Name: A to Z"
        selectByVisibleTextFromDropDown(By.xpath("(//select[@id='products-orderby'])[1]"), "Name: A to Z");
        //Click on "Add To Cart"
        Thread.sleep(1000);
        clickOnElement(By.xpath("(//*[@class='button-2 product-box-add-to-cart-button'])[1]"));

        // 2.5 Verify the Text "Build your own computer"
        String expectedText = "Build your own computer";
        String actualText = driver.findElement(By.xpath("//a[contains(text(),'Build your own computer')]")).getText();
        Assert.assertEquals(expectedText, actualText);

        Thread.sleep(1000);
        // 2.6 Select "2.2 GHz Intel Pentium Dual-Core E2200" using Select class"
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='product_attribute_1']"), "2.2 GHz Intel Pentium Dual-Core E2200");
        // 2.7 Select "8GB [+$60.00]" using Select class.
        Thread.sleep(1000);
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='product_attribute_2']"), "8GB [+$60.00]");
        // 2.8 Select HDD radio "400 GB [+$100.00]"
        Thread.sleep(1000);
        selectRadioButton(By.xpath("//input[@id='product_attribute_3_7']"));
        //2.9 Select OS radio "Vista Premium [+$60.00]"
        Thread.sleep(1000);
        selectRadioButton(By.xpath("//input[@id='product_attribute_4_9']"));
        //2.10  Check Two Check boxes "Microsoft Office [+$50.00]" and "Total Commander
        Thread.sleep(1000);
        selectCheckBox(By.xpath("//*[@id='product_attribute_5_10']"));
        selectCheckBox(By.xpath("//*[@id='product_attribute_5_12']"));
        Thread.sleep(1000);
        // 2.11 Verify the price "$1,475.00"
        String expectedMessage = "$1,475.00";
        String actualMessage = getTextFromElement(By.xpath("//span[@id='price-value-1']"));
        Assert.assertEquals(expectedMessage, actualMessage);
        // 2.12 Click on "ADD TO CART" Button.
        clickOnElement(By.xpath("//button[@id='add-to-cart-button-1']"));
        Thread.sleep(1000);
        // 2.13 Verify the Message "The product has been added to your shopping cart" on Top green Bar
        String expectedMesg = "The product has been added to your shopping cart";
        String actualMesg = getTextFromElement(By.xpath("//p[contains(text(),'product ')]"));
        Assert.assertEquals(expectedMesg, actualMesg);
        clickOnElement(By.xpath("//span[@class='close']"));
        Thread.sleep(1000);
        // 2.14 Then MouseHover on "Shopping cart" and Click on "GO TO CART" button.
        mouseHoverToElement(By.xpath("//span[@class='cart-label']"));
        Thread.sleep(1000);
        mouseHoverToElementAndClick(By.xpath("//button[contains(text(),'Go to cart')]"));
        Thread.sleep(1000);
        String expectedTexts = "Shopping cart";
        String actualTexts = getTextFromElement(By.xpath("//h1[contains(text(),'Shopping cart')]"));
        Assert.assertEquals("", expectedTexts, actualTexts);
        // 2 16 Change the Qty to "2" and Click on "Update shopping cart"
        driver.findElement(By.xpath("//input[contains(@id,'itemquantity')]")).clear();
        sendTextToElements(By.xpath("//input[contains(@id,'itemquantity')]"), "2");
        clickOnElement(By.xpath("//button[@id='updatecart']"));
        Thread.sleep(1000);
        //2 17  Verify the Total"$2,950.00"
        String expectedMessag = "$2,950.00";
        String actualMessag = getTextFromElement(By.xpath("//span[@class='value-summary']//strong"));
        Assert.assertEquals(expectedMessag, actualMessag);
        Thread.sleep(1000);
        //2.18 click on checkbox, "I agree with the terms of service”
        clickOnElement(By.xpath("//input[@id='termsofservice']"));
        //2.19 click on "CHECKOUT"
        clickOnElement(By.xpath("//button[@id='checkout']"));

        Thread.sleep(1000);
        //2.20  Verify the Text “Welcome, Please Sign In!”
        String ExpectedMessage = "Welcome, Please Sign In!";
        String ActualMessage = getTextFromElement(By.xpath("//h1"));
        Assert.assertEquals(ExpectedMessage, ActualMessage);
//2.21 Click on “CHECKOUT AS GUEST” Tab
        clickOnElement(By.xpath("//button[@class='button-1 checkout-as-guest-button']"));
        // 2.22 Fill all mandatory field
        sendTextToElements(By.xpath("//input[@id='BillingNewAddress_FirstName']"), "khushi");
        sendTextToElements(By.xpath("//input[@id='BillingNewAddress_LastName']"), "patel");
        sendTextToElements(By.xpath("//input[@id='BillingNewAddress_Email']"), "abc@gmail.com");
        Thread.sleep(1000);
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='BillingNewAddress_CountryId']"), "United Kingdom");
        sendTextToElements(By.xpath("//input[@id='BillingNewAddress_City']"), "London");
        sendTextToElements(By.xpath("//input[@id='BillingNewAddress_Address1']"), "london road");
        Thread.sleep(1000);
        sendTextToElements(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"), "we2 4rt");
        sendTextToElements(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"), "08156345355");
        //2.23 click on continue
        clickOnElement(By.xpath("//button[@onclick='Billing.save()']"));

        Thread.sleep(1000);
        //2.24 click on radio button “Next Day Air($0.00)”
        selectRadioButton(By.xpath("//input[@id='shippingoption_1']"));
        //2.25  Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 shipping-method-next-step-button']"));
        Thread.sleep(1000);
        //2.26  Select Radio Button “Credit Card”
        selectRadioButton(By.xpath("//input[@id='paymentmethod_1']"));
        // 2.27 Select “Master card” From Select credit card dropdown
        clickOnElement(By.xpath("//button[@class='button-1 payment-method-next-step-button']"));
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='CreditCardType']"), "Master card");
        Thread.sleep(1000);
        // 2.28 Fill all the details
        sendTextToElements(By.xpath("//input[@id='CardholderName']"), "Prime testing");
        sendTextToElements(By.xpath("//input[@id='CardNumber']"), "5467212143120987");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='ExpireMonth']"), "03");
        selectByVisibleTextFromDropDown(By.xpath("//select[@id='ExpireYear']"), "2027");
        sendTextToElements(By.xpath("//input[@id='CardCode']"), "890");
        // 2.29 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[@class='button-1 payment-info-next-step-button']"));
        Thread.sleep(1000);
        // 2.30 Verify “Payment Method” is “Credit Card”
        String expectedtext = "Payment Method” is “Credit Card";
        String actualtext = getTextFromElement(By.xpath("//span[normalize-space='Credit Card"));
        Assert.assertEquals(expectedtext, actualtext);
        //2.31 verify "shopping Method" is "Next Day Air"
        Thread.sleep(1000);
        String expectedMessage1 = "Next Day Air";
        String actualMessage1 = getTextFromElement(By.xpath("//span[normalize-space()='Next Day Air']"));
        Assert.assertEquals(expectedMessage1, actualMessage1);
        //2.32 Verify Total is “$2,950.00”
        String expectedMessage2 = "$2,950.00";
        String actualMessage2 = getTextFromElement(By.xpath("//span[@class='product-subtotal']"));
        Assert.assertEquals(expectedMessage2, actualMessage2);
        Thread.sleep(1000);
        // 2.33 Click on “CONFIRM”
        clickOnElement(By.xpath("//button[normalize-space()='Confirm']"));
        // 2.34 Verify the Text “Thank You”
        String expectedMessage3 = "Thank you";
        String actualMessage3 = getTextFromElement(By.xpath("//h1[normalize-space()='Thank you']"));
        Assert.assertEquals(expectedMessage3, actualMessage3);
        Thread.sleep(1000);
        // 2.35 Verify the message “Your order has been successfully processed!”
        String expectedMessage4 = "Your order has been successfully processed!";
        String actualMessage4 = getTextFromElement(By.xpath("//strong[normalize-space()='Your order has been successfully processed!']"));
        Assert.assertEquals(expectedMessage4, actualMessage4);
        Thread.sleep(1000);
        //2.36 Click on “CONTINUE”
        clickOnElement(By.xpath("//button[normalize-space()='Continue']"));
        // 2.37Verify the text “Welcome to our store”
        String expectedMessage5 = "Welcome to our store";
        String actualMessage5 = getTextFromElement(By.xpath("//h2[normalize-space()='Welcome to our store']"));
        Assert.assertEquals(expectedMessage5, actualMessage5);

    }
}









