package com.epam.training.achi_tsintsadze.webdriver.tests;

import com.epam.training.achi_tsintsadze.webdriver.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SendingAndReceivingMailTest {
    private final String RECEIVER_ADDR = "receiverepam@yahoo.com";
    private final String RECEIVER_PASS = "receivefromgmail";
    private final String SENDER_ADDR = "senderepam@gmail.com";
    private final String SENDER_PASS = "senderepam22_";

    private final String CONTENT = "sent from epam sender gmail";

    private WebDriver driver;

    private SignInUsernamePageGmail gmailLoginPage;
    private GmailHomePage gmailHomePage;
    private SignInUsernamePageYahoo yahooLoginPage;
    private YahooHomePage yahooHomePage;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.gecko.driver", "D:/webdrivers/geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @Test
    public void verifyReceivedEmail() {
        driver.get("https://mail.google.com");
        gmailLoginPage = new SignInUsernamePageGmail(driver);
        gmailLoginPage.loginToSenderGmail(SENDER_ADDR, SENDER_PASS);

        gmailHomePage = new GmailHomePage(driver);
        gmailHomePage.sendEmailToYahooReceiver(RECEIVER_ADDR, CONTENT);

        driver.get("https://login.yahoo.com");
        yahooLoginPage = new SignInUsernamePageYahoo(driver);
        yahooLoginPage.loginToReceiverYahoo(RECEIVER_ADDR, RECEIVER_PASS);

        yahooHomePage = new YahooHomePage(driver);

        Assert.assertTrue(yahooHomePage.verifySenderAddress());
        Assert.assertTrue(yahooHomePage.verifyContent(CONTENT));
    }

    @AfterTest
    public void terminate() {
        driver.quit();
    }
}
