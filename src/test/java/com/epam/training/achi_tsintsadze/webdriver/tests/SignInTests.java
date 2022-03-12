package com.epam.training.achi_tsintsadze.webdriver.tests;

import com.epam.training.achi_tsintsadze.webdriver.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SignInTests {
    private final String RECEIVER_ADDR = "receiverepam";
    private final String RECEIVER_PASS = "receivefromgmail";
    private final String SENDER_ADDR = "senderepam";
    private final String SENDER_PASS = "senderepam22_";

    private WebDriver driver;
    private SignInUsernamePageYahoo yahooLoginPage;
    private SignInUsernamePageGmail gmailLoginPage;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.gecko.driver", "D:/webdrivers/geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @Test
    public void testYahoo() {
        driver.get("https://login.yahoo.com");
        yahooLoginPage = new SignInUsernamePageYahoo(driver);
        yahooLoginPage.loginToReceiverYahoo(RECEIVER_ADDR, RECEIVER_PASS);
        Assert.assertTrue(driver.getTitle().contains("receiverepam@yahoo.com - Yahoo Mail"));
    }

    @Test
    public void testGmail() {
        driver.get("https://mail.google.com");
        gmailLoginPage = new SignInUsernamePageGmail(driver);
        gmailLoginPage.loginToSenderGmail(SENDER_ADDR, SENDER_PASS);
        Assert.assertEquals(driver.getTitle(), "Gmail");
    }

    @AfterTest
    public void terminate() {
        driver.quit();
    }
}
