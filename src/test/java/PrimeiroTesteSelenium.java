import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.plaf.TableHeaderUI;
import java.io.FilterOutputStream;

public class PrimeiroTesteSelenium {

    private WebDriver driver;
    @BeforeEach
    void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @AfterEach
    void close(){
        driver.quit();
    }

    @Test
    void deveTestarLoginComSucesso() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/login");

        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement buttonLogin = driver.findElement(By.cssSelector("button[type='submit']"));

        username.sendKeys("tomsmith");
        password.sendKeys("SuperSecretPassword!");
        buttonLogin.click();

        WebElement mensagem = driver.findElement(By.id("flash"));


        assertTrue(mensagem.getText().contains("You logged into a secure area!"));
        assertTrue(driver.getCurrentUrl().contains("/secure"));

    }





}
