package com.basictests;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class ChromeTest {
    @Test
    public void chromeDriverTest(){
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http://testpages.herokuapp.com");
        assertTrue(driver.getTitle().startsWith("Selenium"));

        driver.close();
        driver.quit();

    }

}
