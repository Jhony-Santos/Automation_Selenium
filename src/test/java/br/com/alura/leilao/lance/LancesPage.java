package br.com.alura.leilao.lance;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LancesPage {

    public static final String URL_LANCES="http://localhost:8080/leilao/2";
    private WebDriver browser;

    public LancesPage(){
        System.setProperty("webdriver.chrome.driver", "C://Users//jntd//Downloads//chromedriver.exe");
        this.browser = new ChromeDriver();
        this.browser.navigate().to(URL_LANCES);
    }

    public boolean isPageActual(){
        return browser.getCurrentUrl().contains(URL_LANCES);
    }


    public boolean isTitleAuctionVisible(){
        return browser.getPageSource().contains("Dados do Leilão");
    }

    public void closePage(){
        this.browser.quit();
    }

}
