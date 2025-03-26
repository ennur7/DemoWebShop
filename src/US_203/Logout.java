package US_203;

import Utility.BaseDriver;
import Utility.Myfunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Logout extends BaseDriver {

    @Test
    public void Logout(){

        driver.get("https://demowebshop.tricentis.com/");
        Myfunc.Bekle(2);

        WebElement login= driver.findElement(By.xpath("//*[@class='ico-login']"));
        login.click();
        Myfunc.Bekle(2);

        WebElement email= driver.findElement(By.xpath("//input[@id='Email']"));
        email.sendKeys("tteam.5.techno@gmail.com");
        Myfunc.Bekle(2);

        WebElement password= driver.findElement(By.xpath("//input[@id='Password']"));
        password.sendKeys("Team5.123");
        Myfunc.Bekle(2);

        WebElement loginBtn= driver.findElement(By.xpath("//*[@class='button-1 login-button']"));
        loginBtn.click();
        Myfunc.Bekle(2);

        WebElement logout= driver.findElement(By.xpath("//*[@class='ico-logout']"));
        logout.click();
        Myfunc.Bekle(2);


        BekleKapat();
    }
}
