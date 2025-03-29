package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BaseDriver {
    public static WebDriver driver;

    static {
        KalanOncekileriKapat();
        driver = new ChromeDriver();

        // driver.manage().window().maximize(); // Ekranı max yapıyor.
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20)); // 20 sn mühlet: sayfayı yükleme mühlet
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // 20 sn mühlet: elementi bulma mühleti

    }

    public static void BekleKapat() {
        Myfunc.Bekle(3);
        driver.quit();
    }

    public static void KalanOncekileriKapat() {
        try {
            Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
        } catch (Exception ignored) {
        }
    }

}

