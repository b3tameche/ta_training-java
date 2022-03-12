package com.epam.training.achi_tsintsadze.framework.pages;

import org.openqa.selenium.WebDriver;

public class AbstractPage {
    protected WebDriver driver;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }
}
