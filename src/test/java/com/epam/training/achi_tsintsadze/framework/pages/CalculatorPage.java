package com.epam.training.achi_tsintsadze.framework.pages;

import com.epam.training.achi_tsintsadze.framework.models.Engine;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.*;

public class CalculatorPage extends AbstractPage {
    private JavascriptExecutor j = (JavascriptExecutor) driver;
    private final Logger logger = LogManager.getRootLogger();
    private Engine engine;

    private WebElement desiredOs;
    private WebElement desiredSerie;
    private WebElement desiredMachineType;
    private WebElement desiredGPU;
    private WebElement desiredGPUNumber;
    private WebElement desiredSSD;
    private WebElement desiredLocation;
    private WebElement desiredUsage;

    @FindBy(xpath = ".//*[@id=\"input_80\"]") // click first
    private WebElement numberOfInstances;

    @FindBy(xpath = ".//md-select[@ng-model=\"listingCtrl.computeServer.os\"]")
    private WebElement operatingSystemDropdown;

    @FindBy(xpath = ".//md-select[@ng-model=\"listingCtrl.computeServer.series\"]")
    private WebElement seriesDropdown;

    @FindBy(xpath = ".//md-select[@ng-model=\"listingCtrl.computeServer.instance\"]") // click
    private WebElement machineTypeDropdown;

    @FindBy(xpath = ".//md-checkbox[@ng-model=\"listingCtrl.computeServer.addGPUs\"]")
    private WebElement addGPUs;

    @FindBy(xpath = ".//md-select[@ng-model=\"listingCtrl.computeServer.gpuType\"]") // click
    private WebElement GPUDropdown;

    @FindBy(xpath = ".//md-select[@ng-model=\"listingCtrl.computeServer.gpuCount\"]")
    private WebElement GPUNumberDropdown;

    @FindBy(xpath = ".//md-select[@ng-model=\"listingCtrl.computeServer.ssd\"]") // click
    private WebElement SSDDropdown;

    @FindBy(xpath = ".//md-select[@ng-model=\"listingCtrl.computeServer.location\"]")
    private WebElement DatacenterlocationDropdown;

    @FindBy(xpath = ".//md-select[@ng-model=\"listingCtrl.computeServer.cud\"]")
    private WebElement committedUsageDropdown;

    @FindBy(xpath = ".//*[@ng-click=\"listingCtrl.addComputeServer(ComputeEngineForm);\"]")
    private WebElement addToEstimate;

    @FindBy(xpath = ".//b[@class=\"ng-binding\"]")
    private WebElement totalEstimatedCost;

    @FindBy(xpath = ".//button[@aria-label = \"Email Estimate\"]")
    private WebElement emailEstimate;

    @FindBy(xpath = ".//input[@ng-model=\"emailQuote.user.email\"]")
    private WebElement emailInput;

    @FindBy(xpath = ".//button[@aria-label=\"Send Email\"]")
    private WebElement sendEmail;

    public CalculatorPage(WebDriver driver, Engine engine) {
        super(driver);
        this.engine = engine;

        // Wait for page to fully load
        JavascriptExecutor j = (JavascriptExecutor) driver;
        new WebDriverWait(driver, 30)
                .until(dr -> j.executeScript("return document.readyState").toString().equals("complete"));

        // Switch to application frame
        driver.switchTo().frame(driver.findElement(By.xpath("/html/body/section/section/main/devsite-content/article/div[2]/article/devsite-iframe/iframe")));
        driver.switchTo().frame(driver.findElement(By.id("myFrame")));
        logger.info("Calculator application loaded");

        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }

    public void fillInfo() {
        // number of instances
        numberOfInstances.sendKeys(engine.getNumberOfInstances());

        // Operating System
        j.executeScript("arguments[0].click();", operatingSystemDropdown);
        desiredOs = driver.findElement(By.xpath(".//md-option/div[contains(text(), \"" + engine.getOperatingSystem() + "\")]"));
        j.executeScript("arguments[0].click();", desiredOs);

        // Serial
        j.executeScript("arguments[0].click();", seriesDropdown);
        desiredSerie = driver.findElement(By.xpath(".//md-option/div[contains(text(), \"" + engine.getSeries() + "\")]"));
        j.executeScript("arguments[0].click();", desiredSerie);

        // Machine Type
        j.executeScript("arguments[0].click();", machineTypeDropdown);
        desiredMachineType = driver.findElement(By.xpath(".//md-option/div[contains(text(), \"" + engine.getMachineType() + "\")]"));
        j.executeScript("arguments[0].click();", desiredMachineType);

        // GPU
        j.executeScript("arguments[0].click();", addGPUs);
        j.executeScript("arguments[0].click();", GPUDropdown);
        desiredGPU = driver.findElement(By.xpath(".//md-option[@ng-repeat=\"item in listingCtrl.gpuList\"]/div[contains(text(), \"" + engine.getGpuType() + "\")]"));
        j.executeScript("arguments[0].click();", desiredGPU);

        // GPU Number
        j.executeScript("arguments[0].click();", GPUNumberDropdown);
        desiredGPUNumber = driver.findElement(By.xpath(".//md-option[@ng-repeat=\"item in listingCtrl.supportedGpuNumbers[listingCtrl.computeServer.gpuType]\"]/div[contains(text(), \"" + engine.getGpuNumber() + "\")]"));
        j.executeScript("arguments[0].click();", desiredGPUNumber);

        // SSD
        j.executeScript("arguments[0].click();", SSDDropdown);
        desiredSSD = driver.findElement(By.xpath(".//md-option/div[contains(text(), \"" + engine.getSsd() + "\")]"));
        j.executeScript("arguments[0].click();", desiredSSD);

        // Datacenter Location
        j.executeScript("arguments[0].click();", DatacenterlocationDropdown);
        desiredLocation = driver.findElement(By.xpath(".//md-option[@ng-repeat=\"item in listingCtrl.fullRegionList | filter:listingCtrl.inputRegionText.computeServer\"]/div[contains(text(), \"" + engine.getLocation() + "\")]"));
        j.executeScript("arguments[0].click();", desiredLocation);

        // Commited Usage
        j.executeScript("arguments[0].click();", committedUsageDropdown);
        desiredUsage = driver.findElement(By.xpath(".//div/md-select-menu/md-content/md-option/div[contains(text(), \"" + engine.getUsage() + "\")]"));
        j.executeScript("arguments[0].click();", desiredUsage);

        logger.info("Application is filled up with given properties");
        try {
            Thread.sleep(5000);
        }catch (Exception e){}

        j.executeScript("arguments[0].click();", addToEstimate);
        j.executeScript("arguments[0].click();", emailEstimate);

    }

    public String getTotalEstimatedCostFromWebsite() {
        String retrievedText =  totalEstimatedCost.getText();
        List<String> splitted = Arrays.asList(retrievedText.split(" "));
        int i = splitted.indexOf("USD");
        return splitted.get(i) + " " +splitted.get(i+1);
    }

    public String getTotalEstimatedCostFromMail() {
        // Open YOPmail on another tab
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://yopmail.com");

        // Generate random email address
        driver.findElement(By.xpath(".//b[contains(text(), \"Random Email Address\")]")).click();
        driver.findElement(By.id("cprnd")).click();

        // Switch to calculator tab
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));

        // Move to the frame "myFrame"
        driver.switchTo().frame(driver.findElement(By.xpath("/html/body/section/section/main/devsite-content/article/div[2]/article/devsite-iframe/iframe")));
        driver.switchTo().frame(driver.findElement(By.id("myFrame")));

        // Paste the generated mail address and send an email to it
        emailInput.sendKeys(Keys.CONTROL + "v");
        j.executeScript("arguments[0].click();", sendEmail);
        try {
            Thread.sleep(3000);
        } catch(Exception e) {}
        logger.info("Email with estimated cost was sent to mail");

        // Switch to YOPmail and check inbox
        driver.switchTo().window(tabs.get(1));
        driver.findElement(By.xpath(".//span[contains(text(), \"Check Inbox\")]")).click();

        // Switch to main frame on YOPmail and retrieve estimated cost
        driver.switchTo().frame("ifmail");
        String retrievedText = driver.findElement(By.xpath(".//h2[contains(text(), \"Estimated Monthly Cost\")]")).getText();
        List<String> splitted = Arrays.asList(retrievedText.split(" "));
        int i = splitted.indexOf("USD");
        return splitted.get(i) + " " + splitted.get(i+1);
    }
}
