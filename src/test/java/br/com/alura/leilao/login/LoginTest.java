package br.com.alura.leilao.login;

import br.com.alura.leilao.lance.LancesPage;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class LoginTest {

    private LoginPage LoginPage;


    @BeforeEach
    public void beforeEach(){
         this.LoginPage = new LoginPage();
    }

    @AfterEach
    public void afterEach(){
        LoginPage.closePage();
    }

    @Test
    public void userValid(){
        LoginPage.fillLoginForm("fulano","pass");
        LoginPage.Login();

        String userLogged = LoginPage.getNameUserLogged();
        Assert.assertEquals("fulano",userLogged);
        Assert.assertFalse(LoginPage.isPageActual());

    }

    @Test
    public void invalidUser(){

        LoginPage.fillLoginForm("invalid","error");
        LoginPage.Login();

        Assert.assertNull(LoginPage.getNameUserLogged());
        Assert.assertTrue(LoginPage.isPageActual());
        Assert.assertTrue(LoginPage.invalidUserMensage());

    }


    @Test
    public void RestrictUrl(){
        LancesPage bidsPage = new LancesPage();
        Assert.assertFalse(bidsPage.isPageActual());
        Assert.assertFalse(bidsPage.isTitleAuctionVisible());
        bidsPage.closePage();


    }

}
