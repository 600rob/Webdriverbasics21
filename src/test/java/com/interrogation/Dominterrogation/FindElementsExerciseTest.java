package com.interrogation.Dominterrogation;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;

public class FindElementsExerciseTest {
    public static final String testUrl = "https://compendiumdev.co.uk/selenium/find_by_playground.php";
    public static WebDriver driver;


    @BeforeClass
    public static void startDriver(){
        driver = new ChromeDriver();
    }

    @Test
    public void findElementsExerciseTest(){

        driver.get(testUrl);
        driver.manage().window().maximize();

        List<WebElement> divElements;
        divElements = (driver.findElements(By.tagName("Div")));
        assertThat("there are 19 divs",divElements.size()==19);

    }

    @Test
    public void findElementsByHrefExerciseTest(){

        driver.get(testUrl);
        driver.manage().window().maximize();

        List<WebElement> anchors;
        anchors = (driver.findElements(By.partialLinkText("jump to")));
        assertThat("there are 25 anchors",anchors.size()==25);

    }

    @Test
    public void findNestedDivElementsExerciseTest(){

        driver.get(testUrl);
        driver.manage().window().maximize();

        List<WebElement> nestedDivs;
        nestedDivs = (driver.findElements(By.className("nestedDiv")));
        assertThat("there are 16 anchors",nestedDivs.size()==16);

    }

    @Test
    public void findParagraphElementsExerciseTest(){

        driver.get(testUrl);
        driver.manage().window().maximize();

        List<WebElement> paras;
        paras = (driver.findElements(By.tagName("p")));
        assertThat("there are 16 anchors",paras.size()==41);

    }





    @AfterClass
    public static void stopDriver(){
        driver.close();
        driver.quit();
    }
}
