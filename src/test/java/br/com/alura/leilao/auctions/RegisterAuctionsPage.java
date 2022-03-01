package br.com.alura.leilao.auctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterAuctionsPage {

    private WebDriver browser;

    public RegisterAuctionsPage(WebDriver browser){
        this.browser=browser;
    }


    public AuctionsPage registerAuctions(String name, String initialValue, String openingData)  {

        this.browser.findElement(By.id("nome")).sendKeys(name);
        this.browser.findElement(By.id("valorInicial")).sendKeys(initialValue);
        this.browser.findElement(By.id("dataAbertura")).sendKeys(openingData);

        this.browser.findElement(By.id("button-submit")).submit();

        return new AuctionsPage(browser);

    }


    public void quit(){
        this.browser.quit();
    }


}
