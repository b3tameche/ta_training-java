package com.epam.training.achi_tsintsadze.webdriver.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class GmailHomePage {
    private WebDriver driver;

    private By composeBy = By.cssSelector(".T-I-KE");
    private By recipientBy = By.xpath(".//*[@aria-label=\"To\"]");
    private By contentBy = By.xpath(".//*[@class=\"Am Al editable LW-avf tS-tW\"]");
    private By sendBy = By.xpath(".//*[@aria-label=\"Send \u202A(Ctrl-Enter)\u202C\"]");

    public GmailHomePage(WebDriver driver) {
        this.driver = driver;
    }

    private void clickCompose() {
        driver.findElement(composeBy).click();
    }

    private void setRecipient(String recipient) {
        driver.findElement(recipientBy).sendKeys(recipient);
        driver.findElement(recipientBy).sendKeys(Keys.ENTER);
    }

    private void setContent(String content) {
        driver.findElement(contentBy).sendKeys(content);
    }

    private void clickSend() {
        driver.findElement(sendBy).click();
    }

    public void sendEmailToYahooReceiver(String recipient, String content) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(composeBy));
        this.clickCompose();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", driver.findElement(recipientBy));
        this.setRecipient(recipient);
        this.setContent(content);

        try {
            Thread.sleep(5000);
            this.clickSend();
            Thread.sleep(5000);
        } catch (InterruptedException e) {}

    }
}
