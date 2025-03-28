package US_205;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Negative_Login extends BaseDriver{
    @Test
    public void NegativeLogin(){
        driver.get("https://demowebshop.tricentis.com/");
        Myfunc.Bekle(2);
        Actions aksiyonlar = new Actions(driver);

        // login butonuna tıkla
        WebElement LoginButton = driver.findElement(By.xpath("//a[@href='/login']"));
        Action Loginbtn= aksiyonlar.moveToElement(LoginButton).click().build();
        Myfunc.Bekle(1);
        Loginbtn.perform();

        // 1. durum : Email ve şifre boş girilirse hata vermeli
        WebElement Email = driver.findElement(By.xpath("//input[@id='Email']"));
        Email.sendKeys("");
        Myfunc.Bekle(1);

        WebElement Password = driver.findElement(By.xpath("//input[@id='Password']"));
        Password.sendKeys("");
        Myfunc.Bekle(1);

        WebElement Login = driver.findElement(By.xpath("//input[@value='Log in']"));
        Login.click();
        Myfunc.Bekle(1);
        WebElement ErrorMessage =driver.findElement(By.xpath("//div[@class='validation-summary-errors']"));
        Assert.assertTrue("Beklenen Hata Oluşmadı",ErrorMessage.getText().contains("Login was unsuccessful. Please correct the errors and try again."));
        System.out.println("The credentials provided are incorrect");

        // 2.durum : Email doğru, şifre boş olarak girilirse
        WebElement Email2 = driver.findElement(By.xpath("//input[@id='Email']"));
        Email2.sendKeys("tteam.5.techno@gmail.com");
        Myfunc.Bekle(1);

        WebElement Password2 = driver.findElement(By.xpath("//input[@id='Password']"));
        Password2.sendKeys("");
        Myfunc.Bekle(1);

        WebElement Login2 = driver.findElement(By.xpath("//input[@value='Log in']"));
        Login2.click();
        Myfunc.Bekle(1);

        WebElement ErrorMessage2 =driver.findElement(By.xpath("//div[@class='validation-summary-errors']"));
        Assert.assertTrue("Beklenen Hata Oluşmadı",ErrorMessage2.getText().contains("The credentials provided are incorrect"));
        System.out.println("The credentials provided are incorrect");

        // 3.durum : Email boş, şifre doğru olarak girilirse
        WebElement Email3 = driver.findElement(By.xpath("//input[@id='Email']"));
        Email3.sendKeys("");
        Myfunc.Bekle(1);

        WebElement Password3 = driver.findElement(By.xpath("//input[@id='Password']"));
        Password3.sendKeys("Team5.123");
        Myfunc.Bekle(1);

        WebElement Login3 = driver.findElement(By.xpath("//input[@value='Log in']"));
        Login3.click();
        Myfunc.Bekle(1);
        WebElement ErrorMessage3 =driver.findElement(By.xpath("//div[@class='validation-summary-errors']"));
        Assert.assertTrue("Beklenen Hata Oluşmadı",ErrorMessage3.getText().contains("No customer account found"));
        System.out.println("No customer account found");

        // 4.durum : Email hatalı, şifre hatalı olarak girilirse
        WebElement Email4 = driver.findElement(By.xpath("//input[@id='Email']"));
        Email4.sendKeys("tteam.5.123techno@gmail.com");
        Myfunc.Bekle(1);

        WebElement Password4 = driver.findElement(By.xpath("//input[@id='Password']"));
        Password4.sendKeys("Team5555");
        Myfunc.Bekle(1);

        WebElement Login4 = driver.findElement(By.xpath("//input[@value='Log in']"));
        Login4.click();
        Myfunc.Bekle(1);

        WebElement ErrorMessage4 =driver.findElement(By.xpath("//div[@class='validation-summary-errors']"));
        Assert.assertTrue("Beklenen Hata Oluşmadı",ErrorMessage4.getText().contains("No customer account found"));
        System.out.println("No customer account found");



    }
}
