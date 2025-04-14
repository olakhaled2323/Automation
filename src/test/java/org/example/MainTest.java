package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class MainTest {
    WebDriver driver = new ChromeDriver();

    @Test
    public void loginWithValidCredentials() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/practice-test-login/");
        driver.findElement(By.id("username")).sendKeys("student");
        driver.findElement(By.id("password")).sendKeys("Password123");
        driver.findElement(By.id("submit")).click();
        Thread.sleep(1000);
        WebElement loggedInMsg = driver.findElement(By.className("post-title"));
        String actualMsg = loggedInMsg.getText();
        Assert.assertEquals(actualMsg, "Logged In Successfully");
        driver.close();
    }

    @Test
    public void loginWithInvalidCredentials() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/practice-test-login/");
        driver.findElement(By.id("username")).sendKeys("student1");
        driver.findElement(By.id("password")).sendKeys("Password123");
        driver.findElement(By.id("submit")).click();
        Thread.sleep(1000);
        WebElement errorLoggedInMsg = driver.findElement(By.id("error"));
        String actualErrorMsg = errorLoggedInMsg.getText();
        Assert.assertEquals(actualErrorMsg, "Your username is invalid!");
        driver.close();
    }
}