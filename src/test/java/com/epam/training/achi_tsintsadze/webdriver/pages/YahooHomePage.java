package com.epam.training.achi_tsintsadze.webdriver.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class YahooHomePage {
    private WebDriver driver;
    private WebElement element;

    private By unreadBy = By.xpath(".//*[@aria-label=\"Unread - Click to see unread mails\"]");
    private By desiredEmailBy = By.xpath(".//span[@title=\"senderepam@gmail.com\"]");
    private By contentBy = By.xpath(".//*[@data-test-id=\"message-view-body-content\"]//div[@dir=\"ltr\"]");

    public YahooHomePage(WebDriver driver) {
        this.driver = driver;
    }

    private void clickUnread() {
        driver.findElement(unreadBy).click();
    }

    public boolean verifySenderAddress() {
        this.clickUnread();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        element = driver.findElement(desiredEmailBy);
        return (element != null);
    }

    public boolean verifyContent(String original) {
        element.click();
        return driver.findElement(contentBy).getText().equals(original);
    }

}
