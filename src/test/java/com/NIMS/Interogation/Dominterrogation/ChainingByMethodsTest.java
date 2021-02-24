package com.NIMS.Interogation.Dominterrogation;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.pagefactory.ByChained;

import static org.junit.Assert.assertEquals;

public class ChainingByMethodsTest {
    public static final String testUrl = "https://compendiumdev.co.uk/selenium/find_by_playground.php";
    public static WebDriver driver;


    @BeforeClass
    public static void startDriver(){
        driver = new ChromeDriver();
    }

    // This uses a method of chaining individual find by's to locate an element in a similar way that we could do by traversing through the DOM with Xpath or CSS
    @Test
    public void chainingWithFindElement(){

        driver.get(testUrl);
        driver.manage().window().maximize();

        WebElement element = driver.findElement(By.id("div1")).
                findElement(By.name("pName3")).
                findElement(By.tagName("a"));

        assertEquals("expected a different id",
                "a3",
                element.getAttribute("id"));
    }

    //this does the same but it uses a support class called 'ByChained' this allows to chain by methods together and pass to a single find by method
    @Test
    public void chainingWithSupportClassByChained(){

        driver.get(testUrl);
        driver.manage().window().maximize();

        WebElement element;
        element = driver.findElement(
                new ByChained(
                        By.id("div1"),
                        By.name("pName9"),
                        By.tagName("a")));

        assertEquals("expected a different id",
                "a9",
                element.getAttribute("id"));
    }





    @AfterClass
    public static void stopDriver(){
        driver.close();
        driver.quit();
    }


}
