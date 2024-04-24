package org.selenium.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.selenium.pom.base.BasePage;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }
    private final By searchBarLink = By.cssSelector("#mainSearchbar");

    public HomePage load(){
        load("/");
        return this;
    }

    public StoragePage  navigateToStoreUsingMenu(){
        driver.findElement(searchBarLink).click();
        return new StoragePage(driver);

    }


}