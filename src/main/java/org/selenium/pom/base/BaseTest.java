package org.selenium.pom.base;


import org.openqa.selenium.WebDriver;
import org.selenium.pom.factory.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
// Prueba de Base Test
    public WebDriver driver;

    @BeforeMethod
    public void startDriver(){
        driver = new DriverManager().initializeDriver();
    }

   @AfterMethod

    public void quitDriver() throws InterruptedException {
       Thread.sleep(3000);
       //driver.quit();
    }
}