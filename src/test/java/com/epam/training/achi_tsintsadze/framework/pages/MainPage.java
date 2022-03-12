package com.epam.training.achi_tsintsadze.framework.pages;

import com.epam.training.achi_tsintsadze.framework.models.Engine;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainPage extends AbstractPage {
    private final Logger logger = LogManager.getRootLogger();

    private By searchBy = By.xpath(".//input[@aria-label=\"Search\"]");
    private By calculatorBy = By.xpath(".//b[contains(text(), \"Google Cloud Pricing Calculator\")]");

    public MainPage(WebDriver driver, String url) {
        super(driver);
        driver.get(url);
        logger.info("Google Cloud page initialized");
    }

    // Returns calculator page
    public CalculatorPage getCalculator(Engine engine) {
        // Search for calculator
        WebElement search = new WebDriverWait(driver, 15).until(ExpectedConditions.presenceOfElementLocated(searchBy));
        search.click();
        search.sendKeys("Google Cloud Platform Pricing Calculator" + Keys.ENTER);

        new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfElementLocated(calculatorBy));
        driver.findElement(calculatorBy).click();

        return new CalculatorPage(driver, engine);
    }
}
