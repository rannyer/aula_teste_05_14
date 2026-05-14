import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.plaf.TableHeaderUI;
import java.io.FilterOutputStream;

public class PrimeiroTesteSelenium {

    @Test
    void deveAbrirSiteCapgemini() throws InterruptedException {
        WebDriver driver = new ChromeDriver();


        driver.get("https://www.capgemini.com/br-pt/");

        WebElement element = driver.findElement(By.xpath("//a[@class='analytics-hero-banner-title']"));
        System.out.println(element.getText());
        element.click();
        Thread.sleep(5000); // Espera 5 segundos para a página carregar completamente

        System.out.println(driver.getTitle());

        driver.quit();
    }
}
