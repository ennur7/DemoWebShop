package US_209;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class DownloadOrderHistory extends BaseDriver {
    @Test
    public void Test1()
    {
        driver.get("https://demowebshop.tricentis.com/");
        Actions actions = new Actions(driver);


        Assert.assertEquals("Yanlış sayfaya gidildi!", "https://demowebshop.tricentis.com/", driver.getCurrentUrl());
        System.out.println("DemoWebShop doğru şekilde yüklendi.");
        MyFunc.Bekle(2);

        WebElement login= driver.findElement(By.xpath("//*[@class='ico-login'] "));
        actions.moveToElement(login).click().perform();
        System.out.println("Giriş butonuna tıklandı.");
        MyFunc.Bekle(2);

        WebElement email=driver.findElement(By.xpath("//*[@id='Email'] "));
        email.sendKeys("tteam.5.techno@gmail.com");
        Assert.assertEquals("E-posta girilemedi", "tteam.5.techno@gmail.com", email.getAttribute("value"));
        System.out.println("E-posta doğru şekilde girildi.");
        MyFunc.Bekle(2);

        WebElement password=driver.findElement(By.xpath("//*[@id='Password'] "));
        password.sendKeys("Team5.123");
        System.out.println("Şifre girildi.");
        MyFunc.Bekle(2);

        WebElement loginButton=driver.findElement(By.xpath("//input[@class='button-1 login-button'] "));
        actions.moveToElement(loginButton).click().perform();
        Assert.assertEquals("Yanlış sayfaya gidildi!", "https://demowebshop.tricentis.com/", driver.getCurrentUrl());
        System.out.println("Ana sayfa doğru bir şekilde yüklendi.");
        MyFunc.Bekle(2);

        WebElement accountbutton=driver.findElement(By.xpath("//*[@class='account']"));
        actions.moveToElement(accountbutton).click().perform();
        Assert.assertEquals("Yanlış sayfaya gidildi!", "https://demowebshop.tricentis.com/customer/info", driver.getCurrentUrl());
        System.out.println("Hesabım sayfası yüklendi.");
        MyFunc.Bekle(2);

        WebElement orders=driver.findElement(By.linkText("Orders"));
        actions.moveToElement(orders).click().perform();
        MyFunc.Bekle(2);

        Assert.assertEquals("Yanlış sayfaya gidildi!", "https://demowebshop.tricentis.com/customer/orders", driver.getCurrentUrl());
        System.out.println("Siparişler sayfası yüklendi.");
        MyFunc.Bekle(1);

        List<WebElement> detailsButton=driver.findElements(By.xpath("//input[@type='button' and @value='Details']"));
        if (detailsButton.size()>0)
        {
            actions.moveToElement(detailsButton.get(1)).click().perform();
            System.out.println("Sipariş detaylarına girildi.");
        }
        MyFunc.Bekle(2);

        WebElement invoice=driver.findElement(By.xpath("//*[@class='button-2 pdf-order-button']"));
        actions.moveToElement(invoice).click().perform();
        System.out.println("Fatura indirildi.");
        MyFunc.Bekle(2);

        BekleKapat();
    }
}
