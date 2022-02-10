package br.com.alura.leilao.login;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    String url = "http://localhost:8080/login";
    String urlLoginInvalido="http://localhost:8080/login?error";

    @Test
    public void loginValido(){

        System.setProperty("webdriver.chrome.driver", "C://Users//jntd//Downloads//chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.navigate().to(url);
        browser.findElement(By.id("username")).sendKeys("fulano");
        browser.findElement(By.id("password")).sendKeys("pass");
        browser.findElement(By.id("login-form")).submit();

        Assert.assertFalse(browser.getCurrentUrl().equals(url));
        Assert.assertEquals("fulano", browser.findElement(By.id("usuario-logado")).getText());

        browser.quit();
    }


    @Test
    public void loginInvalido(){

        System.setProperty("webdriver.chrome.driver", "C://Users//jntd//Downloads//chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.navigate().to(url);
        browser.findElement(By.id("username")).sendKeys("usuario-invalido");
        browser.findElement(By.id("password")).sendKeys("senha-invalida");
        browser.findElement(By.id("login-form")).submit();

        Assert.assertTrue(browser.getCurrentUrl().equals(urlLoginInvalido));
        Assert.assertTrue(browser.getPageSource().contains("Usuário e senha inválidos."));
        Assert.assertThrows(NoSuchElementException.class, () -> browser.findElement(By.id("usuario-logado")));
        String codePage=browser.getPageSource();
        System.out.println(codePage);
        

    }


}
