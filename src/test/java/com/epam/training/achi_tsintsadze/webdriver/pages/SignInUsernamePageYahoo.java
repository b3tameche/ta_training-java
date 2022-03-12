package com.epam.training.achi_tsintsadze.webdriver.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInUsernamePageYahoo {
    private WebDriver driver;

    private By usernameBy = By.id("login-username");
    private By passwordBy = By.id("login-passwd");
    private By nextBy = By.id("login-signin");
    private By signinBy = By.id("ybarMailLink");

    public SignInUsernamePageYahoo(WebDriver driver) {
        this.driver = driver;
    }

    public void setUserName(String username){
        driver.findElement(usernameBy).sendKeys(username);
    }

    public void setPassword(String password){
        driver.findElement(passwordBy).sendKeys(password);
    }

    public void clickNext() {
        driver.findElement(nextBy).click();
    }

    public void clickSignIn() {
        driver.findElement(signinBy).click();
    }

    public void loginToReceiverYahoo(String username, String password) {
        this.setUserName(username);
        this.clickNext();

        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(passwordBy));
        this.setPassword(password);
        this.clickNext();

        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(signinBy));
        this.clickSignIn();
    }
}
