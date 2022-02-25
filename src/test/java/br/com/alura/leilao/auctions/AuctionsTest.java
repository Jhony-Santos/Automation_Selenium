package br.com.alura.leilao.auctions;

import br.com.alura.leilao.login.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AuctionsTest {


    private AuctionsPage auctionsPage;

    @BeforeEach
    public void beforeEach(){

    }


    @AfterEach
    public void afterEach(){
        auctionsPage.quit();

    }

    @Test
    public void registerAuctions(){

        LoginPage loginPage = new LoginPage();
        loginPage.fillLoginForm("fulano","pass");
        loginPage.Login();
        auctionsPage=loginPage.Login();
        auctionsPage.toChargeForm();
        RegisterAuctionsPage registerAuctionsPage=auctionsPage.toChargeForm();




    }

    @Test
    public void codePag(){
        auctionsPage.codePage();
    }





}
