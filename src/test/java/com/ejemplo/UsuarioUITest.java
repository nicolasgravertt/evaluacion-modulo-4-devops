package com.ejemplo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UsuarioUITest extends BaseSeleniumTest {

    @Test
    void testFormularioUsuario() {

        // Prueba en local con el archivo chromedriver.exe
        // String driverPath = new File("chromedriver.exe").getAbsolutePath();
        // System.setProperty("webdriver.chrome.driver", driverPath);
        // WebDriver driver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");         // Headless for CI (Chrome 109+)
        options.addArguments("--no-sandbox");           // Requerido en CI
        options.addArguments("--disable-dev-shm-usage"); // Fix for limited /dev/shm space

        WebDriver driver = new ChromeDriver(options);

        try {
            File htmlFile = new File("src/test/resources/html/usuario-form.html");
            String url = "file:///" + htmlFile.getAbsolutePath();
            driver.get(url);

            WebElement nombreInput = driver.findElement(By.id("nombre"));
            WebElement pesoInput = driver.findElement(By.id("peso"));
            WebElement actualizarButton = driver.findElement(By.id("actualizar"));

            nombreInput.clear();
            nombreInput.sendKeys("Ana");
            pesoInput.clear();
            pesoInput.sendKeys("65");
            actualizarButton.click();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            WebElement resultado = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("resultado")));

            assertEquals("Usuario: Ana, Peso Actual: 65 kg", resultado.getText());
        } finally {
            driver.quit();
        }
    }
}
