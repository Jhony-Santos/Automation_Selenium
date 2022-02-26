package br.com.alura.leilao.auctions;

import org.openqa.selenium.WebDriver;

public class RegisterAuctionsPage {

    private WebDriver browser;

    public RegisterAuctionsPage(WebDriver browser){
        this.browser=browser;
    }

    public void quit(){
        this.browser.quit();
    }

}
