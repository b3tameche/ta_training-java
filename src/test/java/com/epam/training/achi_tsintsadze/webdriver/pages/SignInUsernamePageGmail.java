package com.epam.training.achi_tsintsadze.webdriver.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInUsernamePageGmail {
    private WebDriver driver;

    private By usernameBy = By.xpath("//input[@id='identifierId']");
    private By passwordBy = By.xpath("//input[@name='password']");
    private By usernameNextBy = By.id("identifierNext");
    private By passwordNextBy = By.id("passwordNext");

    public SignInUsernamePageGmail(WebDriver driver) {
        this.driver = driver;
    }

    public void setUserName(String username){
        driver.findElement(usernameBy).sendKeys(username);
    }

    public void setPassword(String password){
        driver.findElement(passwordBy).sendKeys(password);
    }

    public void clickUsernameNext() {
        driver.findElement(usernameNextBy).click();
    }

    public void clickPasswordNext() {
        driver.findElement(passwordNextBy).click();
    }


    /**
     * This POM method will be exposed in test case to login in the application
     * @param username
     * @param password
     * @return
     */

    public void loginToSenderGmail(String username, String password) {
        this.setUserName(username);
        this.clickUsernameNext();

        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(passwordBy));
        this.setPassword(password);
        this.clickPasswordNext();
    }

}
