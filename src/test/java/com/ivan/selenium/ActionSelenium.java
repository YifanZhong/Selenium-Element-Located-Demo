package com.ivan.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ActionSelenium {

    public WebDriver driver;

    public void InitDriver(){
        System.setProperty("webdriver.chrome.driver","chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.imooc.com/user/newlogin/from_url/");
        driver.manage().window().maximize();

    }

    public void inputBox(){
        driver.findElement(By.name("email")).sendKeys("ivanzhong0310@gmail.com");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.name("email")).clear();
        String s = driver.findElement(By.name("email")).getAttribute("placeholder");
        System.out.println(s);
    }

    public static void main(String[] args){

        ActionSelenium actionSelenium = new ActionSelenium();
        actionSelenium.InitDriver();
        actionSelenium.inputBox();
    }
}
