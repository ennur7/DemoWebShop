package US206;

import Utility.BaseDriver;
import Utility.Myfunc;
import Utility.UserInformation;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

public class _US206_OrderingFeature extends BaseDriver {

    @Test
    public void testUS206() throws AWTException, InterruptedException {
        Myfunc.loginTest();
        WebDriverWait myWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        Actions actions = new Actions(driver);
        Myfunc.Bekle(2);

        if (!driver.findElement(By.xpath("//span[@class='cart-qty']")).getText().equals("(0)")) {
            actions.moveToElement(driver.findElement(By.xpath("//span[@class='cart-qty']"))).click().build().perform();
            driver.findElement(By.xpath("//*[contains(@name,'itemquantity')]")).clear();
            driver.findElement(By.xpath("//*[contains(@name,'itemquantity')]")).sendKeys("0");
            actions.sendKeys(Keys.ENTER);
            actions.moveToElement(driver.findElement(By.xpath("//*[@alt='Tricentis Demo Web Shop']"))).click().build().perform();
        }
        actions.moveToElement(driver.findElement(By.xpath("//*[text()='14.1-inch Laptop']"))).click().build().perform();
        myWait.until(ExpectedConditions.urlContains("141-inch-laptop"));

        String homePagePrice = driver.findElement(By.xpath("(//div[@class='prices'])[1]")).getText();
        Assert.assertTrue("Products specifications did not appear", driver.findElement(By.xpath("//*[text()='Products specifications']")).isDisplayed());

        Assert.assertTrue("Add to cart button did not appear", driver.findElement(By.xpath("//*[@id='add-to-cart-button-31']")).isDisplayed());

        actions.moveToElement(driver.findElement(By.xpath("//*[@id='add-to-cart-button-31']"))).click().build().perform();

        myWait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//*[contains(text(),'has been added')]"))));

        Assert.assertTrue("Product could not be added to cart", driver.findElement(By.xpath("//*[contains(text(),'has been added')]")).isDisplayed());

        myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Shopping cart')]")));

        Assert.assertTrue("Shopping cart button not be added to cart", driver.findElement(By.xpath("//*[contains(text(),'Shopping cart')]")).isDisplayed());

        actions.moveToElement(driver.findElement(By.xpath("//*[contains(text(),'Shopping cart')]"))).click().build().perform();

        Assert.assertTrue("Url not contains cart", driver.getCurrentUrl().contains("cart"));
        Assert.assertTrue("Prices are not the same", driver.findElement(By.xpath("//span[@class='product-unit-price']")).getText().contains(homePagePrice));

        Assert.assertTrue("Total price is not correct", driver.findElement(By.xpath("//span[@class='product-subtotal']")).getText().equals(homePagePrice));


        Select countrySelect = new Select(driver.findElement(By.xpath("//*[@id='CountryId']")));
        countrySelect.selectByVisibleText("United States");
        myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='United States']")));
        Assert.assertEquals("Country can not be selected",
                "United States", new Select(driver.findElement(By.xpath("//*[@id='CountryId']"))).getFirstSelectedOption().getText());


        Select stateSelect = new Select(driver.findElement(By.xpath("//*[@id='StateProvinceId']")));
        stateSelect.selectByVisibleText("New York");
        Assert.assertTrue("State can not be selected", driver.findElement(By.xpath("//*[text()='New York']")).isSelected());
        myWait.until(ExpectedConditions.elementToBeSelected(driver.findElement(By.xpath("//*[text()='New York']"))));

        actions.moveToElement(driver.findElement(By.xpath("//*[@id='termsofservice']"))).click().build().perform();
        Assert.assertTrue("Check box is not checked", driver.findElement(By.xpath("//*[@id='termsofservice']")).isSelected());
        myWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='checkout']")));
        Assert.assertTrue("Checkout button is not clickable", driver.findElement(By.xpath("//button[@id='checkout']")).isEnabled());
        if (!driver.findElements(By.xpath("//button[@id='checkout']")).isEmpty()) {
            WebElement checkoutButton = driver.findElement(By.xpath("//button[@id='checkout']"));
            if (checkoutButton.isDisplayed() && checkoutButton.isEnabled()) {
                actions.moveToElement(checkoutButton).click().build().perform();
            }
        }

        myWait.until(ExpectedConditions.urlContains("checkout"));
        Assert.assertTrue("Url not contains checkout", driver.getCurrentUrl().contains("checkout"));

        myWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='billing-address-select']"))));

        myWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='billing-address-select']"))));

        Select newBillingAddressSelect = new Select(driver.findElement(By.xpath("//*[@id='billing-address-select']")));
        newBillingAddressSelect.selectByVisibleText("New Address");
        Assert.assertEquals("Billing address selection failed",
                "New Address", new Select(driver.findElement(By.xpath("//*[@id='billing-address-select']"))).getFirstSelectedOption().getText());


        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='BillingNewAddress_FirstName']")).getAttribute("value").equals(UserInformation.getFirstName()));
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='BillingNewAddress_LastName']")).getAttribute("value").equals(UserInformation.getLastName()));
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='BillingNewAddress_Email']")).getAttribute("value").equals(UserInformation.getEmail()));

        Select countryDropdown = new Select(driver.findElement(By.xpath("//*[@id='BillingNewAddress_CountryId']")));
        countryDropdown.selectByVisibleText("United States");

        myWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='BillingNewAddress_StateProvinceId']")));


        Myfunc.Bekle(1);
        Select newStateSelect1 = new Select(driver.findElement(By.xpath("//*[@id='BillingNewAddress_StateProvinceId']")));
        newStateSelect1.selectByVisibleText("New York");


        if (driver.findElement(By.xpath("//*[@id='BillingNewAddress_City']")).getAttribute("value").isEmpty()) {
            actions.moveToElement(driver.findElement(By.xpath("//*[@id='BillingNewAddress_City']"))).click().sendKeys("San Francisco").build().perform();
        }

        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='BillingNewAddress_City']")).getAttribute("value").equals("San Francisco"));


        if (driver.findElement(By.xpath("//*[@id='BillingNewAddress_Address1']")).getAttribute("value").isEmpty()) {
            actions.moveToElement(driver.findElement(By.xpath("//*[@id='BillingNewAddress_Address1']"))).click().sendKeys("240 W 55th St").build().perform();
        }
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='BillingNewAddress_Address1']")).getAttribute("value").equals("240 W 55th St"));

        if (driver.findElement(By.xpath("//*[@id='BillingNewAddress_ZipPostalCode']")).getAttribute("value").isEmpty()) {
            actions.moveToElement(driver.findElement(By.xpath("//*[@id='BillingNewAddress_ZipPostalCode']"))).click().sendKeys("10019").build().perform();
        }


        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='BillingNewAddress_ZipPostalCode']")).getAttribute("value").equals("10019"));

        if (driver.findElement(By.xpath("//*[@id='BillingNewAddress_PhoneNumber']")).getAttribute("value").isEmpty()) {
            actions.moveToElement(driver.findElement(By.xpath("//*[@id='BillingNewAddress_PhoneNumber']"))).click().sendKeys("+12129573536").build().perform();
        }

        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='BillingNewAddress_PhoneNumber']")).getAttribute("value").equals("+12129573536"));

        actions.moveToElement(driver.findElement(By.xpath("(//*[@value='Continue'])[1]"))).click().build().perform();

        Robot robot = new Robot();
        for (int i = 0; i < 32; i++) {
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyRelease(KeyEvent.VK_TAB);
            Myfunc.Bekle(1);
        }

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        myWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Shipping address')]")));

        Assert.assertTrue("Shipping Address Continue button isn't displayed ", driver.findElement(By.xpath("(//*[@value='Continue'])[2]")).isDisplayed());
        actions.moveToElement(driver.findElement(By.xpath("(//*[@value='Continue'])[2]"))).click().build().perform();
        Myfunc.Bekle(2);
        myWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id='shippingoption_2']"))));
        actions.moveToElement(driver.findElement(By.xpath("//*[@id='shippingoption_2']"))).click().build().perform();
        Assert.assertTrue("Radio button isn't selected", driver.findElement(By.xpath("//*[@id='shippingoption_2']")).isSelected());


        Assert.assertTrue("Shipping Method isn'n Displayed", driver.findElement(By.xpath("(//*[@value='Continue'])[3]")).isDisplayed());
        Assert.assertTrue("Shipping Method isn'n Enable", driver.findElement(By.xpath("(//*[@value='Continue'])[3]")).isEnabled());


        Assert.assertTrue("Shipping Address Continue button isn't displayed ", driver.findElement(By.xpath("(//*[@value='Continue'])[3]")).isDisplayed());
        actions.moveToElement(driver.findElement(By.xpath("(//*[@value='Continue'])[3]"))).click().build().perform();


        myWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='paymentmethod_2']")));
        Assert.assertTrue("Payment method button isn't enabled", driver.findElement(By.xpath("//*[@id='paymentmethod_2']")).isEnabled());
        actions.moveToElement(driver.findElement(By.xpath("//*[@id='paymentmethod_2']"))).click().build().perform();
        Assert.assertTrue("Payment method isn't selected", driver.findElement(By.xpath("//*[@id='paymentmethod_2']")).isSelected());

        myWait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@value='Continue'])[4]")));
        Assert.assertTrue("Shipping Address Continue button isn't displayed", driver.findElement(By.xpath("(//*[@value='Continue'])[4]")).isDisplayed());
        actions.moveToElement(driver.findElement(By.xpath("(//*[@value='Continue'])[4]"))).click().build().perform();



        Select ccSelect = new Select(myWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='CreditCardType']"))));
        ccSelect.selectByIndex(0);

        myWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='CardholderName']")));
        myWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='CardholderName']")));
        actions.moveToElement(driver.findElement(By.xpath("//*[@id='CardholderName']"))).click().sendKeys(UserInformation.getCcHolderName()).perform();
        Assert.assertTrue("Cardholder name does not match", driver.findElement(By.xpath("//*[@id='CardholderName']")).getAttribute("value").contains(UserInformation.getCcHolderName()));

        myWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='CardNumber']")));
        actions.moveToElement(driver.findElement(By.xpath("//*[@id='CardNumber']"))).click().sendKeys(UserInformation.getCcNumber()).perform();
        Assert.assertTrue("Card number does not match", driver.findElement(By.xpath("//*[@id='CardNumber']")).getAttribute("value").contains(UserInformation.getCcNumber()));

        new Select(driver.findElement(By.xpath("//*[@id='ExpireMonth']")))
                .selectByVisibleText(UserInformation.getCcExpirationMonth());
        Assert.assertEquals(UserInformation.getCcExpirationMonth(),
                new Select(driver.findElement(By.xpath("//*[@id='ExpireMonth']"))).getFirstSelectedOption().getText());

        new Select(driver.findElement(By.xpath("//*[@id='ExpireYear']")))
                .selectByVisibleText(UserInformation.getCcExpirationYear());
        Assert.assertEquals(UserInformation.getCcExpirationYear(),
                new Select(driver.findElement(By.xpath("//*[@id='ExpireYear']"))).getFirstSelectedOption().getText());

        new Actions(driver).moveToElement(myWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='CardCode']"))))
                .click().sendKeys(UserInformation.getCcCode()).perform();

        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='CardCode']"))
                .getAttribute("value").contains(UserInformation.getCcCode()));

        myWait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@value='Continue'])[5]")));
        actions.moveToElement(driver.findElement(By.xpath("(//*[@value='Continue'])[5]"))).click().build().perform();
        Assert.assertTrue("Shipping Address Continue button isn't displayed", driver.findElement(By.xpath("(//*[@value='Continue'])[5]")).isDisplayed());

        Myfunc.Bekle(2);
        Robot robot2 = new Robot();
        for (int i = 0; i < 3; i++) {
            robot2.keyPress(KeyEvent.VK_TAB);
            robot2.keyRelease(KeyEvent.VK_TAB);
            Myfunc.Bekle(1);

        }
        robot2.keyPress(KeyEvent.VK_ENTER);
        robot2.keyRelease(KeyEvent.VK_ENTER);
        robot2.keyPress(KeyEvent.VK_ENTER);
        robot2.keyRelease(KeyEvent.VK_ENTER);

        List<WebElement> urunler = driver.findElements(By.xpath("(//span[text()='1590.00'])[2]"));

        double urunUcretToplam = 0;

        for (WebElement e : urunler) {
            String StrUrunFiyat = e.getText().replaceAll("[^0-9,.]", "");
            double urunFiyat = Double.parseDouble(StrUrunFiyat);
            urunUcretToplam = urunUcretToplam + urunFiyat;
        }

        double ItemTotal=Double.parseDouble( driver.findElement(By.cssSelector("td.cart-total-right span.product-price")).getText().replaceAll("[^0-9,.]",""));

        Assert.assertTrue("Rakamlar eşit değil", urunUcretToplam==ItemTotal);



        myWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@value='Confirm']"))));
        actions.moveToElement(driver.findElement(By.xpath("//*[@value='Confirm']"))).click().build().perform();
        Assert.assertTrue("Confirm button isn't displayed", driver.findElement(By.xpath("//*[@value='Confirm']")).isDisplayed());




        myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'successfully ')]")));
        Assert.assertTrue("Your order could not be processed!",driver.findElement(By.xpath("//*[contains(text(),'successfully ')]")).getText().contains("successfully"));
        Assert.assertTrue(driver.getCurrentUrl().contains("completed"));
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(),'Order number')]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//*[contains(text(),'Order number')]")).getText().contains("Order number"));

        actions.moveToElement(driver.findElement(By.xpath("//*[@value='Continue']"))).click().build().perform();


        BekleKapat();
    }
}
