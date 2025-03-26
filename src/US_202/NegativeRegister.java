package US_202;

import Utility.BaseDriver;
import Utility.Myfunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class NegativeRegister extends BaseDriver {
    @Test

    public void Test01(){

        driver.get("https://demowebshop.tricentis.com/");
        Myfunc.Bekle(2);

        WebElement registerbtn = driver.findElement(By.xpath("//a[@href='/register']"));
        registerbtn.click();
        Myfunc.Bekle(2);

        WebElement gender = driver.findElement(By.xpath("//input[@id='gender-male']"));
        gender.click();
        Myfunc.Bekle(2);

        WebElement firstname = driver.findElement(By.xpath("//input[@id='FirstName']"));
        firstname.sendKeys("Mustafa");
        Myfunc.Bekle(2);

        WebElement lastname = driver.findElement(By.xpath("//input[@id='LastName']"));
        lastname.sendKeys("Kemal");
        Myfunc.Bekle(2);

        WebElement email = driver.findElement(By.xpath("//input[@id='Email']"));
        email.sendKeys("tteam.5.techno@gmail.com");
        Myfunc.Bekle(2);

        WebElement password = driver.findElement(By.xpath("//input[@id='Password']"));
        password.sendKeys("Team5.123");
        Myfunc.Bekle(2);

        WebElement confirmpass = driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));
        confirmpass.sendKeys("Team5.123");
        Myfunc.Bekle(2);

        WebElement register = driver.findElement(By.xpath("//input[@id='register-button']"));
        register.click();
        Myfunc.Bekle(2);

        WebElement errortext = driver.findElement(By.xpath("//li[text()='The specified email already exists']"));

        try{
            Assert.assertTrue("Hata mesajı görüntülendi", errortext.getText().contains("The specified email already exists."));
        } catch (Exception e) {
            System.out.println("Hata mesajı görüntülenemedi");
        }
        finally {

            BekleKapat();
        }
    }
}
