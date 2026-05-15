import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
//        password.sendKeys(Keys.ENTER);

        WebElement mensagem = driver.findElement(By.id("flash"));


        assertTrue(mensagem.getText().contains("You logged into a secure area!"));
        assertTrue(driver.getCurrentUrl().contains("/secure"));

    }

    @Test
    void deveAdicionarERemoverElementos(){
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        WebElement buttonAdd = driver.findElement(By.cssSelector("button[onclick='addElement()']"));
//        buttonAdd = driver.findElement(By.xpath("//button[text()='Add Element']"));
        buttonAdd.click();
        buttonAdd.click();
        buttonAdd.click();

        int quantidaeBototesDelete = driver.findElements(By.className("added-manually")).size();
        assertEquals(3, quantidaeBototesDelete);

        WebElement primeiroDelete = driver.findElement(By.className("added-manually"));
        primeiroDelete.click();

        int quantidadeDepoisDeRemover = driver.findElements(By.className("added-manually")).size();
        assertEquals(2, quantidadeDepoisDeRemover);

    }
    @Test
    void deveValidarCheckbox(){
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        WebElement checkbox1 = driver.findElements(By.cssSelector("input[type='checkbox']")).get(0);
        WebElement checkbox2 = driver.findElements(By.cssSelector("input[type='checkbox']")).get(1);

        assertFalse(checkbox1.isSelected());

        assertTrue(checkbox2.isSelected());

        checkbox1.click();

        assertTrue(checkbox1.isSelected());
    }





}
