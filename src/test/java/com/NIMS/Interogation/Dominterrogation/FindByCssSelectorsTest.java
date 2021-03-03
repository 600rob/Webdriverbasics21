package com.NIMS.Interogation.Dominterrogation;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;




public class FindByCssSelectorsTest {

        public static WebDriver driver;
        String TEST_URL = "https:/compendiumdev.co.uk/selenium/find_by_playground.php";

        @BeforeClass
        public static void StartDriver() {
            driver = new ChromeDriver();
        }

        @Test
        public void canFindelementsByCssSelector(){
            driver.navigate().to(TEST_URL);
            driver.manage().window().maximize();

            //use different location methods to find the same web elements

//        WebElement element1 = driver.findElement(By.id("p31"));
// using # does a css search by id
            WebElement element1 = driver.findElement(By.cssSelector("#p31"));
//        WebElement element2 = driver.findElement(By.name("ulName1"));
            WebElement element2 = driver.findElement(By.cssSelector("ul[name='ulName1']"));
//        WebElement element3 = driver.findElement(By.className("specialDiv"));
            // using the dot operator matches a class name
            WebElement element3 = driver.findElement(By.cssSelector(".specialDiv"));
//        WebElement element4 = driver.findElement(By.tagName("li"));
            //using the tag name string matches the tag name
            WebElement element4 = driver.findElement(By.cssSelector("li"));
//        WebElement element4 = driver.findElement(By.cssSelector("li[name='liName1']"));

            assertEquals("element 1 has name pName31", "pName31", element1.getAttribute("name"));
            assertEquals("element 2 has id ul1", "ul1", element2.getAttribute("id"));
            assertEquals("element 3 has id div1", "div1", element3.getAttribute("id"));
            assertEquals("element 4 has tag name liName1", "liName1", element4.getAttribute("name"));

            System.out.println(element1.getAttribute("name"));
            System.out.println(element2.getAttribute("id"));
            System.out.println(element3.getAttribute("id"));
            System.out.println(element4.getAttribute("name"));

        }


        @AfterClass
        public static void stopDriver(){
            driver.close();
            driver.quit();
        }
    }
