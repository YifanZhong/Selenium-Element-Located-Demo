package com.ivan.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

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

        //preparing for radioBox
        driver.findElement(By.name("email")).sendKeys("ivanzhong0310@gmail.com");
        driver.findElement(By.name("password")).sendKeys("aaaaaaaa");
        driver.findElement(By.className("moco-btn")).click();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 单选框
     * radioBox
     */
    public void radioBox(){
        driver.get("https://www.imooc.com/user/setprofile");
        driver.findElement(By.className("pull-right")).click();
        //driver.findElement(By.xpath("/html/body/div[9]/div/div[2]/div/div/form/div[4]/div/label[1]")).click();
        List<WebElement> elements = driver.findElements(By.xpath("/html/body/div[9]/div/div[2]/div/div/form/div[4]/div/label//input"));
        System.out.println(elements.size());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (WebElement radio : elements){
            boolean flag = radio.isSelected();
            if (flag == false){
                radio.click();
                break;
            }else{
                System.out.println("isSelected");
            }
        }

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    /**
     * 多选框
     * checkBox
     */
    public void checkBox(){
        WebElement check = driver.findElement(By.id("auto-signin"));
        System.out.println("isSelected? " + check.isSelected());
        System.out.println("isEnabled? "+ check.isEnabled());
        //check.clear();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        check.click();
    }

    /**
     * 按钮
     * button
     */
    public void button(){
        WebElement button = driver.findElement(By.className("moco-btn"));
        System.out.println(button.isEnabled());
        System.out.println(button.getAttribute("value"));
        button.click();
    }

    public void webForm(){
        //拼接测试，API 拼接 test
        driver.get("xxxxxxxxx");
        driver.findElement(By.id("signup-form")).submit();
    }

    public static void main(String[] args){

        ActionSelenium actionSelenium = new ActionSelenium();
        actionSelenium.InitDriver();
        //actionSelenium.checkBox();
        actionSelenium.inputBox();
        actionSelenium.webForm();
        
        actionSelenium.webForm();
        //actionSelenium.button();
        //actionSelenium.inputBox();
        //actionSelenium.radioBox();
    }
}
