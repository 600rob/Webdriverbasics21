package com.NIMS.Interogation.Dominterrogation;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class FindByCssSelectorsPathTest {


    public static WebDriver driver;
    static String TEST_URL = "https:/compendiumdev.co.uk/selenium/find_by_playground.php";

    @BeforeClass
    public static void StartDriver() {
        driver = new ChromeDriver();
        driver.navigate().to(TEST_URL);
        driver.manage().window().maximize();
    }


    @Test
    public void directDescendant(){

        assertEquals("div > p", 41,
                driver.findElements(By.cssSelector("div > p")).size());

        assertEquals("div > li", 0,
                driver.findElements(By.cssSelector("div > li")).size());
    }


    @Test
    public void anyDescendant(){

        assertEquals("div p", 41,
                driver.findElements(By.cssSelector("div p")).size());

        assertEquals("div li", 25,
                driver.findElements(By.cssSelector("div li")).size());

    }

    @Test
    public void siblingOfPreceding(){

        assertEquals("li + li", 24,
                driver.findElements(By.cssSelector("li + li")).size());

        // li are in a big list so li + li skipped the first one
        assertEquals("li", 25,
                driver.findElements(By.cssSelector("li")).size());

    }

    @Test
    public void firstChild(){

        // get the first child li we missed out in the test before
        assertEquals("li:first-child", 1,
                driver.findElements(By.cssSelector("li:first-child")).size());

    }





    @AfterClass
    public static void stopDriver(){
        driver.close();
        driver.quit();
    }


}
