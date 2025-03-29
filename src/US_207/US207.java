package US_207;


import Utility.BaseDriver;
import Utility.Myfunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;



import static Utility.BaseDriver.BekleKapat;
import static Utility.BaseDriver.driver;


public class US207 extends BaseDriver {



    @Test

    public void US_207() {

        driver.get("https://demowebshop.tricentis.com");


        WebElement excellentRadioButton = driver.findElement(By.xpath("//*[@id='pollanswers-1']"));
        Myfunc.Bekle(2);
        excellentRadioButton.click();

        WebElement voteButton = driver.findElement(By.xpath("//*[@id='vote-poll-1']"));
        Myfunc.Bekle(2);
        voteButton.click();

        WebElement errorText = driver.findElement(By.xpath("//*[contains(text(),'Only registered')]"));
        Assert.assertTrue(errorText.isDisplayed());

        WebElement loginButton = driver.findElement(By.xpath("//*[text()='Log in']"));
        Myfunc.Bekle(2);
        loginButton.click();

        WebElement usernameInputField = driver.findElement(By.xpath("//*[@id='Email']"));
        usernameInputField.sendKeys("tteam.5.techno@gmail.com");

        WebElement passwordInputField = driver.findElement(By.xpath("//*[@id='Password']"));
        passwordInputField.sendKeys("Team5.123");

        WebElement loginButton2 = driver.findElement(By.xpath("//*[@value='Log in']"));
        loginButton2.click();

        WebElement loggedMail = driver.findElement(By.xpath("//*[text()='tteam.5.techno@gmail.com']"));
        Myfunc.Bekle(2);
        Assert.assertTrue(loggedMail.isDisplayed());

        try {
            WebElement excellent = driver.findElement(By.xpath("//*[@id='pollanswers-1']"));
            Assert.assertTrue(excellent.isDisplayed());
            excellent.click();
            WebElement voteButtonLogged = driver.findElement(By.xpath("//*[@id='vote-poll-1']"));
            voteButtonLogged.click();
            Assert.assertTrue(voteButtonLogged.isDisplayed());

            WebElement voteText = driver.findElement(By.xpath("//*[@id='poll-block-1']"));
            Assert.assertTrue(voteText.isDisplayed());

            System.out.println(voteText.getText());


        } catch (Exception e) {
            WebElement voteText1 = driver.findElement(By.xpath("//*[@class='poll-results']"));
            System.out.println(voteText1.getText());
            System.out.println("Zaten oy kullandin ");

        }


        BekleKapat();

    }

}
