package com.epam.training.achi_tsintsadze.framework.tests;

import com.epam.training.achi_tsintsadze.framework.driver.DriverSingleton;
import com.epam.training.achi_tsintsadze.framework.models.Engine;
import com.epam.training.achi_tsintsadze.framework.pages.CalculatorPage;
import com.epam.training.achi_tsintsadze.framework.pages.MainPage;
import com.epam.training.achi_tsintsadze.framework.service.EngineCreator;
import com.epam.training.achi_tsintsadze.framework.util.TestListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

@Listeners({TestListener.class})
public class VerifyEstimatedCostsTest {
    private final Logger logger = LogManager.getRootLogger();
    private WebDriver driver;
    private final String WEBSITE = "https://cloud.google.com";

    @BeforeTest
    public void setup() {
        driver = DriverSingleton.getDriver();
    }

    @Test
    public void verifyEstimatedCostsTest() {
        Engine testEngine = EngineCreator.withSpecsFromProperty();

        // Get Google Cloud website
        MainPage main = new MainPage(driver, WEBSITE);

        // Obtain calculator
        CalculatorPage calculator = main.getCalculator(testEngine);

        // Fill application with given properties
        calculator.fillInfo();

        String estimatedOnWebsite = calculator.getTotalEstimatedCostFromWebsite();
        logger.info("Obtained estimated cost from website");
        logger.info(estimatedOnWebsite);
        String estimatedOnEmail = calculator.getTotalEstimatedCostFromMail();
        logger.info("Obtained estimated cost from email");
        logger.info(estimatedOnEmail);

        assertThat(estimatedOnWebsite, is(equalTo(estimatedOnEmail)));
    }

    @AfterTest(alwaysRun = true)
    public void stopBrowser() {
        DriverSingleton.closeDriver();
    }
}
