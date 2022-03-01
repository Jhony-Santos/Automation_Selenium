package br.com.alura.leilao.auctions;

import br.com.alura.leilao.login.LoginPage;
import br.com.alura.leilao.login.LoginTest;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AuctionsTest {


    private AuctionsPage auctionsPage;



    @AfterEach
    public void afterEach(){
        this.auctionsPage.quit();
    }

    @Test
    public void register() {

        LoginPage loginPage = new LoginPage();
        loginPage.fillLoginForm("fulano","pass");
        this.auctionsPage = loginPage.Login();
        auctionsPage.toChargeForm();
        RegisterAuctionsPage registerAuctionsPage = auctionsPage.toChargeForm();


        String today= LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String name = "Leilão do dia " + today;
        String value ="500.00";


       this.auctionsPage = registerAuctionsPage.registerAuctions(name, value, today);
       Assert.assertTrue(auctionsPage.isAuctionRegister(name,value, today));



    }



}
