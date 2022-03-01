package br.com.alura.leilao.auctions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AuctionsPage {

  private static final String URL_REGISTER_ACTIONS="http://localhost:8080/leiloes/new";
    private WebDriver browser;

  public AuctionsPage(WebDriver browser){
      this.browser = browser;
  }


  public void quit(){
      this.browser.quit();
  }


  public RegisterAuctionsPage toChargeForm(){
        this.browser.navigate().to(URL_REGISTER_ACTIONS);
        return new RegisterAuctionsPage(browser);

  }

    public boolean isAuctionRegister(String name, String value, String data){

      WebElement lineTableAuctions = this.browser.findElement(By.cssSelector("#table-auctions tbody tr:last-child"));

      WebElement columnNome = lineTableAuctions.findElement(By.cssSelector("td:nth-child(1)"));
      WebElement columnDataAbertura = lineTableAuctions.findElement(By.cssSelector("td:nth-child(2)"));
      WebElement columnValorInicial = lineTableAuctions.findElement(By.cssSelector("td:nth-child(3)"));


        // check the information

        return columnNome.getText().equals(name)
                && columnDataAbertura.getText().equals(data)
                && columnValorInicial.getText().equals(value);


    }


}
