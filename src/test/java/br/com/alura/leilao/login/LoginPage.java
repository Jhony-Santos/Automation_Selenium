package br.com.alura.leilao.login;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {

    private static final String URL_LOGIN = "http://localhost:8080/login";
    private WebDriver browser;

    public LoginPage () {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        this.browser = new ChromeDriver();
        this.browser.navigate().to(URL_LOGIN);
    }



    public void  fillLoginForm(String username, String password){
        browser.findElement(By.id("username")).sendKeys(username);
        browser.findElement(By.id("password")).sendKeys(username);

    }

    public void Login(){
        browser.findElement(By.id("login-form")).submit();
    }


    public String getNameUserLogged(){
        try {
         return browser.findElement(By.id("usuario-logado")).getText();
        } catch (NoSuchElementException e){
            return null;
        }

    }


    public boolean isPageActual(){
        return browser.getCurrentUrl().contains(URL_LOGIN);
    }


    public boolean invalidUserMensage(){
        return browser.getPageSource().contains("usuário e senha inválidos");
    }


    public void closePage(){
        this.browser.quit();
    }



}
