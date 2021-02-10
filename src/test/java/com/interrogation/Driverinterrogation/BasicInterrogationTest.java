package com.interrogation.Driverinterrogation;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BasicInterrogationTest {

    public static final String testUrl = "https://compendiumdev.co.uk/selenium/basic_web_page.html";
    public static WebDriver driver;

    @BeforeClass
    public static void startDriver(){
        driver = new ChromeDriver();
    }

    @Test
    public void driverLevelInterrogationExerciseTest(){

        driver.navigate().to(testUrl);
        driver.manage().window().maximize();
        assertEquals("Title is basic web page","Basic Web Page Title",driver.getTitle() );
        assertEquals("Url is correct",testUrl,driver.getCurrentUrl());
        assertTrue("page source contains a paragraph of text",
                driver.getPageSource().contains("A paragraph of text"));
    }

    @AfterClass
    public static void stopDriver(){
        driver.close();
        driver.quit();
    }
}
