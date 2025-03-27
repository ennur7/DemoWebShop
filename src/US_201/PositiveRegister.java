package US_201;

import Utility.BaseDriver;
import Utility.Myfunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PositiveRegister extends BaseDriver {
    @Test
    public  void test1(){
        driver.get("https://demowebshop.tricentis.com/");
        WebElement register=driver.findElement(By.xpath("//a[@class='ico-register']"));
        register.click();
        Myfunc.Bekle(2);

        WebElement female=driver.findElement(By.xpath("//input[@id='gender-female']"));
        female.click();
       Myfunc.Bekle(2);

        WebElement firstName=driver.findElement(By.xpath("//input[@id='FirstName']"));
        firstName.sendKeys("team5");
        Myfunc.Bekle(2);

        WebElement lastName=driver.findElement(By.xpath("//input[@id='LastName']"));
        lastName.sendKeys("campus");
        Myfunc.Bekle(2);

        WebElement email=driver.findElement(By.xpath("//input[@id='Email']"));
        email.sendKeys("team5.126@gmail.com");
        Myfunc.Bekle(2);

        WebElement password=driver.findElement(By.xpath("//input[@id='Password']"));
        password.sendKeys("Team5.123");
        Myfunc.Bekle(2);

        WebElement confirmPassword=driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));
        confirmPassword.sendKeys("Team5.123");
        Myfunc.Bekle(2);

        WebElement register1=driver.findElement(By.xpath("//input[@id='register-button']"));
        register1.click();
        Myfunc.Bekle(2);

        WebElement kayıtOnayı=driver.findElement(By.xpath("//div[@class='result']"));
        try {
            Assert.assertTrue(kayıtOnayı.getText().contains("Your registration completed"));

        }catch (Exception e) {

            System.out.println("Kaydınız tamamlanmamıştır.");
        }

        finally {
            BekleKapat();
        }

    }
}
