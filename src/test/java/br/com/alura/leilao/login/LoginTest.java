package br.com.alura.leilao.login;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    private WebDriver browser;
    private static final String URL_LOGIN = "http://localhost:8080/login";
    private static final String URL_LANCES = "http://localhost:8080/leiloes/2";


    @BeforeAll
    public static void beforeAll(){
        System.setProperty("webdriver.chrome.driver", "C://Users//jntd//Downloads//chromedriver.exe");

    }

    @BeforeEach
    public void beforeEach(){
         this.browser = new ChromeDriver();
         browser.navigate().to("http://localhost:8080/login");
    }

    @AfterEach
    public void afterEach(){
        this.browser.quit();
    }


    @Test
    public void loginValido(){
        browser.navigate().to(URL_LOGIN);

        browser.findElement(By.id("username")).sendKeys("fulano");
        browser.findElement(By.id("password")).sendKeys("pass");
        browser.findElement(By.id("login-form")).submit();

        Assert.assertFalse(browser.getCurrentUrl().equals("http://localhost:8080/login"));
        Assert.assertEquals("fulano", browser.findElement(By.id("usuario-logado")).getText());

    }


    @Test
    public void loginInvalido(){
        browser.navigate().to(URL_LOGIN);
        String urlLoginInvalido="http://localhost:8080/login?error";
        browser.findElement(By.id("username")).sendKeys("usuario-invalido");
        browser.findElement(By.id("password")).sendKeys("senha-invalida");
        browser.findElement(By.id("login-form")).submit();

        Assert.assertTrue(browser.getCurrentUrl().equals(urlLoginInvalido));
        Assert.assertTrue(browser.getPageSource().contains("Usuário e senha inválidos."));
        Assert.assertThrows(NoSuchElementException.class, () -> browser.findElement(By.id("usuario-logado")));


    }

    @Test
    public void urlRestrita(){
        browser.navigate().to(URL_LANCES);
        Assert.assertTrue(browser.getCurrentUrl().equals("http://localhost:8080/login"));
        Assert.assertFalse(browser.getPageSource().contains("Dados do Leilão"));
    }

}
