package com.ivan.selenium;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class seleniumTest1 {

    @Test
    public void WedDriver(){

        System.setProperty("webdriver.chrome.driver","chromedriver");
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.imooc.com/user/newlogin/from_url/");
        driver.findElement(By.tagName("input")).sendKeys("aaaaaaa@gmail.com");
        driver.findElement(By.name("password")).sendKeys("aaaaaaa");
        driver.findElement(By.tagName("label")).click();
        driver.findElement(By.className("moco-btn")).click();
        driver.manage().window().maximize();
        driver.get("http://www.imooc.com");
        driver.findElement(By.className("icon-search")).click();
        driver.findElement(By.className("search-input")).sendKeys("aaaaa");
        WebElement element = driver.findElement(By.className("nav-item"));
        List<WebElement> elements = element.findElements(By.tagName("li"));
        elements.get(3).click();

    }
}
