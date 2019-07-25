package com.ivan.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.*;

public class ActionSelenium {

    public WebDriver driver;
    public String windowsHandle;

    public void InitDriver(){
        System.setProperty("webdriver.chrome.driver","chromedriver");
        driver = new ChromeDriver();
        //driver.get("https://www.imooc.com/user/newlogin/from_url/");
        driver.get("https://www.imooc.com");
        driver.manage().window().maximize();

    }

    public void inputBox(){
        driver.findElement(By.name("email")).sendKeys("ivanzhong0310@gmail.com");
        try {
            sleep(2000);
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
            sleep(4000);
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
            sleep(2000);
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
            sleep(4000);
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
            sleep(4000);
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


    public void upFile(){
        driver.get("https://www.imooc.com/user/setbindsns");
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String jsString = "document.getElementsByClassName(\"update-avator\")[0].style.bottom='0';";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(jsString);
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //driver.findElement(By.className("js-avator-link")).click();
        driver.findElement(By.className("update-avator")).click();
        driver.findElement(By.id("upload")).sendKeys("/Users/aaa./Documents/7.jpeg");

    }

    /**
     * 下拉框操作
     */
    public void downSelectBox(){
        driver.get("https://www.imooc.com/user/setprofile");
        driver.findElement(By.className("pull-right")).click();
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement formElement = driver.findElement(By.id("profile"));

        WebElement job = formElement.findElement(By.id("job"));
        Select downList = new Select(job);
        //one of them;
        /*
        downList.selectByIndex(2);
        downList.selectByValue("18");
        downList.selectByVisibleText("学生");


        downList.deselectAll();
        downList.deselectByIndex(2);
        downList.deselectByValue("");
        downList.deselectByVisibleText("");
        */

        downList.selectByIndex(3);
        //System.out.println(downList.isMultiple());
        //downList.deselectByIndex(3);
        List<WebElement> List = downList.getAllSelectedOptions();
        for (WebElement option:List){
            System.out.println(option.getText());
        }
        System.out.println(downList.getFirstSelectedOption().getText());

    }

    /**
     * 鼠标事件
     */
    public void mouseAction(){
        //WebElement login = driver.findElement(By.id("js-signin-btn"));
        //WebElement login = driver.findElement(By.id("a"));
        WebElement login = driver.findElement(By.className("menuContent"));
        List<WebElement> item = login.findElements(By.className("item"));
        Actions actions = new Actions(driver);
        //actions.click(login).perform();
        /*
        actions.doubleClick(login).perform();
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        actions.contextClick(login).perform();
        */
        actions.moveToElement(item.get(1)).perform();
        try {
            sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        windowsHandle = driver.getWindowHandle();
        driver.findElement(By.linkText("HTML/CSS")).click();

    }

    /**
     * iframe Switch
     */
    public void iframe(){
        driver.get("https://www.imooc.com/wiki/create");
        WebElement iframeElement = driver.findElement(By.id("ueditor_0"));
        driver.switchTo().frame(iframeElement);
        driver.findElement(By.tagName("body")).sendKeys("This is a test!");

    }

    /**
     *
     * windowsHandle
     */
    public void windowsHandle(){
        Set<String> handles = driver.getWindowHandles();
        for (String s:handles){
            if (s.equals(windowsHandle)){
                continue;
            }
            System.out.println(s);
            driver.switchTo().window(s);
        }
        driver.findElement(By.linkText("初级")).click();
    }

    /**
     * waiting
     */
    public void waitforElement(){
        //隐式等待
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //显式等待
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("test")));

    }

    public static void main(String[] args){

        ActionSelenium actionSelenium = new ActionSelenium();
        actionSelenium.InitDriver();
        //actionSelenium.checkBox();
        //actionSelenium.inputBox();
        //actionSelenium.webForm();

        //actionSelenium.webForm();
        //actionSelenium.button();
        //actionSelenium.inputBox();
        //actionSelenium.radioBox();
        //actionSelenium.upFile();
        //actionSelenium.downSelectBox();
        //actionSelenium.mouseAction();
        //actionSelenium.iframe();
        //actionSelenium.windowsHandle();
        actionSelenium.waitforElement();
    }
}
