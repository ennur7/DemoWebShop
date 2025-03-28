package US_208;

import Utility.BaseDriver;
import Utility.Myfunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class US_208 extends BaseDriver
{
    @Test
    public void Test1() {
        driver.get("https://demowebshop.tricentis.com/");
        Myfunc.Bekle(2);

        WebElement login = driver.findElement(By.xpath("//a[@href='/login']"));
        login.click();
        Myfunc.Bekle(2);

        WebElement email = driver.findElement(By.xpath("//input[@id='Email']"));
        email.sendKeys("tteam.5.techno@gmail.com");
        Myfunc.Bekle(2);

        WebElement password = driver.findElement(By.xpath("//input[@id='Password']"));
        password.sendKeys("Team5.123");
        Myfunc.Bekle(2);

        WebElement loginHesap = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        loginHesap.click();
        Myfunc.Bekle(2);

        WebElement computerLogin = driver.findElement(By.xpath("(//*[@href='/computers'])[1]"));
        Actions aksiyonlar = new Actions(driver);
        Action aksiyon = aksiyonlar.moveToElement(computerLogin).build();
        aksiyon.perform();
        Myfunc.Bekle(2);

        WebElement notebookLogin = driver.findElement(By.xpath("(//*[@href='/notebooks'])[1]"));
        notebookLogin.click();
        Myfunc.Bekle(2);

        WebElement notebookClick = driver.findElement(By.xpath("//h2[@class='product-title']/a"));
        notebookClick.click();
        Myfunc.Bekle(2);

        WebElement addtoCard = driver.findElement(By.xpath("//input[@id='add-to-cart-button-31']"));
        addtoCard.click();
        Myfunc.Bekle(2);

        WebElement sepetDogrumu = driver.findElement(By.xpath("//p[@class='content']"));
        Assert.assertTrue("Sepete eklenemedi.", sepetDogrumu.getText().contains("The product has been added to your "));

        WebElement sepet = driver.findElement(By.xpath("//*[text()='Shopping cart']"));
        sepet.click();
        Myfunc.Bekle(2);

        WebElement clickCoupon = driver.findElement(By.xpath("//input[@name='applydiscountcouponcode']"));
        clickCoupon.click();
        Myfunc.Bekle(2);
        // AsserTrue ile doğrula The coupon code you entered couldn't be applied to your order

        WebElement addGift = driver.findElement(By.xpath("//input[@name='applygiftcardcouponcode']"));
        addGift.click();
        Myfunc.Bekle(2);

        WebElement country = driver.findElement(By.xpath("//select[@id='CountryId']"));
        country.click();
        Myfunc.Bekle(2);

        Select countrMenu = new Select(country);
        countrMenu.selectByValue("1");
        Myfunc.Bekle(2);

        WebElement state = driver.findElement(By.xpath("//select[@id='StateProvinceId']"));
        state.click();
        Myfunc.Bekle(2);

        Select StateMenu = new Select(state);
        StateMenu.selectByValue("40");
        Myfunc.Bekle(2);

        WebElement checkbox = driver.findElement(By.xpath("//input[@id='termsofservice']"));
        checkbox.click();
        Myfunc.Bekle(2);

        WebElement checkout = driver.findElement(By.xpath("//button[@id='checkout']"));
        checkout.click();
        Myfunc.Bekle(2);

        WebElement company = driver.findElement(By.xpath("//input[@id='BillingNewAddress_Company']"));
        company.sendKeys("technostudy");
        Myfunc.Bekle(1);

        WebElement country2 = driver.findElement(By.xpath("//select[@id='BillingNewAddress_CountryId']"));
        country2.click();
        Myfunc.Bekle(1);

        Select country23 = new Select(country2);
        country23.selectByValue("1");
        Myfunc.Bekle(2);

        WebElement state235 = driver.findElement(By.xpath("//select[@id='BillingNewAddress_StateProvinceId']"));
        country2.click();
        Myfunc.Bekle(1);

        Select state23 = new Select(state235);
        state23.selectByValue("40");
        Myfunc.Bekle(2);

        WebElement city = driver.findElement(By.xpath("//input[@id='BillingNewAddress_City']"));
        city.sendKeys("New York / Manhattan");
        Myfunc.Bekle(1);

        WebElement adress1 = driver.findElement(By.xpath("//input[@id='BillingNewAddress_Address1']"));
        adress1.sendKeys("Manhattan Timesquare");
        Myfunc.Bekle(1);

        WebElement adress2 = driver.findElement(By.xpath("//input[@id='BillingNewAddress_Address2']"));
        adress2.sendKeys("Manhattan Timesquare 155 Street");
        Myfunc.Bekle(1);

        WebElement zippostal = driver.findElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"));
        zippostal.sendKeys("35000");
        Myfunc.Bekle(1);

        WebElement phoneNumber = driver.findElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"));
        phoneNumber.sendKeys("+1(555)4333456");
        Myfunc.Bekle(1);

        WebElement continuee = driver.findElement(By.xpath("//input[@class='button-1 new-address-next-step-button']"));
        continuee.click();
        Myfunc.Bekle(2);

        WebElement checkbox2 = driver.findElement(By.xpath("//input[@id='PickUpInStore']"));
        checkbox2.click();
        Myfunc.Bekle(2);

        WebElement continue2 = driver.findElement(By.xpath("//input[@onclick='Shipping.save()']"));
        continue2.click();
        Myfunc.Bekle(2);

        WebElement paymentClick = driver.findElement(By.xpath("//input[@class='button-1 payment-method-next-step-button']"));
        paymentClick.click();
        Myfunc.Bekle(2);

        WebElement continue3 = driver.findElement(By.xpath("//input[@class='button-1 payment-info-next-step-button']"));
        continue3.click();
        Myfunc.Bekle(2);

        WebElement confirm = driver.findElement(By.xpath("//input[@class='button-1 confirm-order-next-step-button']"));
        confirm.click();
        Myfunc.Bekle(2);

        WebElement siparisAlindi = driver.findElement(By.xpath("//*[text()='Your order has been successfully processed!']"));
        Assert.assertTrue("Siparişiniz oluşturulamadı.", siparisAlindi.getText().contains("Your order has been successfully processed!"));

        WebElement continue4 = driver.findElement(By.xpath("//input[@class='button-2 order-completed-continue-button']"));
        continue4.click();
        Myfunc.Bekle(2);


        BekleKapat();
    }
}

