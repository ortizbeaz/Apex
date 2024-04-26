package org.selenium;

import org.selenium.pom.base.BaseTest;
import org.selenium.pom.pages.HomePage;
import org.selenium.pom.pages.StoragePage;
import org.testng.annotations.Test;



public class Prueba extends BaseTest {
    @Test

    public  void TS01_TC01() {
        String searchFor = "Reloj";
        StoragePage storagePage = new HomePage(driver).
                load().
                navigateToStoreUsingMenu().
                searchArticle(searchFor).
                findArticles();

    }
@Test
    public  void TS01_TC02() {
        String searchFor = "riopan";
        StoragePage storagePage = new HomePage(driver).
                load().
                navigateToStoreUsingMenu().
                searchArticle(searchFor).
                findArticles();
    }

    @Test
    public  void TS01_TC03() {
        String searchFor = "reloj";
        StoragePage storagePage = new HomePage(driver).
                load().
                navigateToStoreUsingMenu().
                searchArticle(searchFor).
                findArticles().
                filterByBrand();
    }

    @Test
    public  void TS02_TC01() {
        String searchFor = "Smart Tv";
        String minimo = "6000";
        String maximo = "10000";
        String usuario = "ortiz.beaz@gmail.com";
        String password = "Apex1234";


        StoragePage storagePage = new HomePage(driver).
                load().
                navigateToStoreUsingMenu().
                searchArticle(searchFor).
                findArticles().filterByPrice(minimo, maximo).
                selecTv().buyingTv(usuario, password);




    }

    @Test
    public  void TS03_TC01() throws InterruptedException {

        StoragePage storagePage = new StoragePage(driver).
                createAccount().datosNuevoUsuario();
    }



    }





