package com.NIMS.Interogation.Dominterrogation;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;

public class BasicDomInterrogation {
    public static final String testUrl = "https://compendiumdev.co.uk/selenium/find_by_playground.php";
    public static WebDriver driver;

    @BeforeClass
    public static void startDriver(){
        driver = new ChromeDriver();
    }

    @Test
    public void findByIdExerciseTest(){

        driver.navigate().to(testUrl);
        driver.manage().window().maximize();

        WebElement element1 = driver.findElement(By.id("p1"));
        assertEquals("element A test is correct",
                "This is a paragraph text", element1.getText());
    }

    @Test
    public void findByLinkTextExerciseTest(){

        driver.navigate().to(testUrl);
        driver.manage().window().maximize();

        WebElement element2 = driver.findElement(By.linkText("jump to para 0"));
        assertEquals("element 2 test is correct",
                "jump to para 0", element2.getText());
    }

    @Test
    public void findByPartialLinkTextExerciseTest(){

        driver.navigate().to(testUrl);
        driver.manage().window().maximize();

        WebElement element3 = driver.findElement(By.partialLinkText("para 0"));
        assertEquals("element 3 test is correct",
                "jump to para 0", element3.getText());
    }


    @Test
    public void findByNameTextExerciseTest(){

        driver.navigate().to(testUrl);
        driver.manage().window().maximize();

        WebElement element3 = driver.findElement(By.name("pName14"));
        assertEquals("element A test is correct",
                "This is n paragraph text", element3.getText());
    }

    @Test
    public void findByClassNameTextExerciseTest(){
        driver.navigate().to(testUrl);
        driver.manage().window().maximize();

        WebElement element4 = driver.findElement(By.className("normal"));
        assertEquals("element 4 test is correct",
                "This is a paragraph text", element4.getText());
    }




    @AfterClass
    public static void stopDriver(){
        driver.close();
        driver.quit();
    }
}
