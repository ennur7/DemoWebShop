package US_204;

import Utility.BaseDriver;
import Utility.Myfunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.lang.annotation.Target;

public class LoginPositive extends BaseDriver {
    @Test
    public void test(){
        driver.get("https://demowebshop.tricentis.com/");
        Myfunc.Bekle(2);

        WebElement loginLink = driver.findElement(By.xpath("//a[@href='/login']"));
        loginLink.click();
        Myfunc.Bekle(2);

        WebElement email = driver.findElement(By.id("Email"));
        email.sendKeys("tteam.5.techno@gmail.com");
        WebElement password = driver.findElement(By.id("Password"));
        password.sendKeys("Team5.123");
        WebElement loginButton = driver.findElement(By.xpath("(//input[@type='submit'])[2]"));
        loginButton.click();
        Myfunc.Bekle(2);


        WebElement profile = driver.findElement(By.xpath("(//a[@class='account'])[1]"));

        Assert.assertTrue("Giriş yapılamadı",profile.getText().contains("tteam.5.techno@gmail.com"));

        BekleKapat();
    }

}
