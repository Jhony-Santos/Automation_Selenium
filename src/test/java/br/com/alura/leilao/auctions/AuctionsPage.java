package br.com.alura.leilao.auctions;

import org.openqa.selenium.WebDriver;

public class AuctionsPage {

  private static final String URL_REGISTER_ACTIONS="http://localhost:8080/login/new";
  private WebDriver browser;

  public AuctionsPage(WebDriver browser){
      this.browser = browser;
      this.browser.navigate().to(URL_REGISTER_ACTIONS);

  }


  public void quit(){
      this.browser.quit();
  }

  public String codePage(){
      return browser.getPageSource();

  }

  public AuctionsPage toChargeForm(){
        this.browser.navigate().to(URL_REGISTER_ACTIONS);
        return new AuctionsPage(browser);

  }



}