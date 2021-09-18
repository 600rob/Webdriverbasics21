package com.NIMS.manipulation;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.openqa.selenium.Keys.SHIFT;

public class ManipulateExercisesTest {

    public static WebDriver driver;
    String TEST_URL ="https:/compendiumdev.co.uk/selenium/basic_html_form.html";

    @BeforeClass
    public static void startDriver(){
        driver = new ChromeDriver();
    }

    @Test
    public void interactionEx1(){
        driver.navigate().to(TEST_URL);
        driver.manage().window().maximize();
        assertEquals("Title is html form elements","HTML Form Elements",driver.getTitle());
        WebElement submitButton = driver.findElement(By.cssSelector("input[type='submit']"));
        submitButton.click();
        assertEquals("Title is Processed Form Details","Processed Form Details",driver.getTitle());

    }

    @Test
    public void interactionEx2(){
        driver.navigate().to(TEST_URL);
        driver.manage().window().maximize();
        assertEquals("Title is html form elements","HTML Form Elements",driver.getTitle());
        WebElement textBox = driver.findElement(By.cssSelector("textarea[name='comments']"));
        WebElement submitButton = driver.findElement(By.cssSelector("input[type='submit']"));

        textBox.clear();
        textBox.sendKeys("robytest");
        submitButton.click();
        WebElement text = driver.findElement(By.cssSelector("li[id='_valuecomments']"));
        assertEquals("Title is Processed Form Details","Processed Form Details",driver.getTitle());
        assertEquals("updated text is robytest", "robytest", text.getText());

    }

    @Test
    public void interactionEx3(){
        driver.navigate().to(TEST_URL);
        driver.manage().window().maximize();
        assertEquals("Title is html form elements","HTML Form Elements",driver.getTitle());
        WebElement submitButton = driver.findElement(By.cssSelector("input[type='submit']"));
        submitButton.click();
        assertEquals("Title is Processed Form Details","Processed Form Details",driver.getTitle());
        WebElement radioVal = driver.findElement(By.cssSelector("li[id='_valueradioval']"));
        assertEquals("radio value selected is 2", "rd2", radioVal.getText());

    }
    @Test
    public void interactionEx4(){
        driver.navigate().to(TEST_URL);
        driver.manage().window().maximize();
        assertEquals("Title is html form elements","HTML Form Elements",driver.getTitle());

        WebElement submitButton = driver.findElement(By.cssSelector("input[type='submit']"));
        List<WebElement> checkBoxes = driver.findElements(By.cssSelector("input[name='checkboxes[]']"));
        checkBoxes.get(0).click();
        checkBoxes.get(2).click();

        submitButton.click();
        assertEquals("Title is Processed Form Details","Processed Form Details",driver.getTitle());
        List<WebElement> checkBoxList = driver.findElements(By.cssSelector("div[id='_checkboxes'] li"));

        assertEquals("only check box 1 is selected", 1, checkBoxList.size());
        assertEquals("only check box 1 is selected in output txt", "cb1", checkBoxList.get(0).getText());
    }

    @Test
    public void interactionEx5(){
        driver.navigate().to(TEST_URL);
        driver.manage().window().maximize();
        assertEquals("Title is html form elements","HTML Form Elements",driver.getTitle());

        WebElement submitButton = driver.findElement(By.cssSelector("input[type='submit']"));
        List<WebElement> dropdown = driver.findElements(By.cssSelector("select[name='dropdown'] option[value]"));
        dropdown.get(4).click();
        submitButton.click();

        assertEquals("Title is Processed Form Details","Processed Form Details",driver.getTitle());
        WebElement dropdownSelected = driver.findElement(By.cssSelector("li[id='_valuedropdown']"));

        assertEquals("drop down 5 is selected", "dd5", dropdownSelected.getText());
    }


    @Test
    public void interactionEx6(){
        driver.navigate().to(TEST_URL);
        driver.manage().window().maximize();
        assertEquals("Title is html form elements","HTML Form Elements",driver.getTitle());

        WebElement submitButton = driver.findElement(By.cssSelector("input[type='submit']"));
        List<WebElement> multiSelect = driver.findElements(By.cssSelector("select[multiple='multiple'] option"));
        Actions a = new Actions(driver);

        a.keyDown(SHIFT);
        multiSelect.get(0).click();
        multiSelect.get(1).click();
        multiSelect.get(2).click();
        multiSelect.get(3).click();
        a.keyUp(SHIFT);
        submitButton.click();
        assertEquals("Title is Processed Form Details","Processed Form Details",driver.getTitle());

        List<WebElement> mulltiselections = driver.findElements(By.cssSelector("div[id='_multipleselect'] li"));
        assertEquals("correcgt number of multislections were made", 3,mulltiselections.size() );
        //could add assertions on the text values of the seletced items here
    }


    @AfterClass
    public static void stopDriver() {
        driver.close();
        driver.quit();
    }

}
