package com.basictests;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.junit.Assert.assertTrue;

public class FFTest {
    @Test
    public void FFDriverTest() {
        WebDriver driver = new FirefoxDriver();
        driver.navigate().to("http://testpages.herokuapp.com");
        assertTrue(driver.getTitle().startsWith("Selenium"));

        driver.quit();
    }
}
