package com.ejemplo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
// import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UsuarioUITest {

    @Test
    void testFormularioUsuario() {

        // Prueba en local con el archivo chromedriver.exe
        // String driverPath = new File("chromedriver.exe").getAbsolutePath();
        // System.setProperty("webdriver.chrome.driver", driverPath);

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

            WebElement resultado = driver.findElement(By.id("resultado"));
            String texto = resultado.getText();

            assertTrue(texto.contains("Ana"));
            assertTrue(texto.contains("65"));
        } finally {
            driver.quit();
        }
    }
}
