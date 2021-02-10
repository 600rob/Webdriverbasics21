package com.navigation;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.*;

public class NavigationExerciseTest {
    @Test
    public void canNavigateAndAssertUrls(){

        WebDriver driver = new ChromeDriver();

        driver.navigate().to("http://compendiumdev.co.uk/selenium");
        driver.manage().window().maximize();
        assertTrue(driver.getTitle().contains("Selenium Simplified"));

        driver.navigate().to("https://compendiumdev.co.uk/selenium/search.php");
        assertEquals("title is Selenium Simplified Search Engine",driver.getTitle(),
                "Selenium Simplified Search Engine");

        driver.navigate().back();
        assertTrue(driver.getTitle().contains("Selenium Simplified"));

        driver.navigate().forward();
        assertEquals("title is Selenium Simplified Search Engine",driver.getTitle(),
                "Selenium Simplified Search Engine");

        driver.navigate().to("https://compendiumdev.co.uk/selenium/basic_html_form.html");
        assertTrue(driver.getTitle().equals("HTML Form Elements"));

        driver.navigate().to("https://compendiumdev.co.uk/selenium/basic_web_page.html");
        assertTrue(driver.getTitle().equals("Basic Web Page Title"));

        driver.close();
        driver.quit();
    }
    @Test
    public void refreshPageTest(){
        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://compendiumdev.co.uk/selenium/refresh.php");
        assertTrue(driver.getTitle().contains("Refreshed Page on"));
        String currentTitle = driver.getTitle();

        driver.navigate().refresh();
        String newTitle = driver.getTitle();
        assertTrue(driver.getTitle().contains("Refreshed Page on"));
        assertFalse(currentTitle==newTitle);
//        assertTrue(driver.getTitle().equals("Basic Web Page Title"));

        driver.close();
        driver.quit();
    }

    @Test
    public void refreshPageTestOption2(){
        //this is the same test as above burt uses a different method of checking the data
        //Note, the number in the page title is actually the current time in seconds, so we use that to assert
        // the time has incremented on page refresh

        final String pageConstant = "Refreshed Page on ";

        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://compendiumdev.co.uk/selenium/refresh.php");
        assertTrue(driver.getTitle().startsWith("Refreshed Page on"));
        //get the title, strip out the string text and parse it to a Long for the start time

        long start = Long.parseLong(driver.getTitle().replaceFirst(pageConstant,""));
        System.out.println(start);

        long startTime = Long.parseLong(
                driver.getTitle().
                        replaceFirst(pageConstant, ""));

        // use a thread sleep to ensure some time passes - this means end time will be greater than start
//        try{Thread.sleep(2000);}
//            catch(InterruptedException e){/*ignore interrupt*/}
//
//        driver.navigate().refresh();
//        assertTrue(driver.getTitle().contains(pageConstant));
//
//        //get the title, strip out the string text and parse it to a Long for the end time
//        long endTime = Long.parseLong(
//                driver.getTitle().
//                        replaceFirst(pageConstant, ""));
//
//        assertTrue("expected end time is greater than start time", endTime > startTime);

        driver.close();
        driver.quit();

    }
}
