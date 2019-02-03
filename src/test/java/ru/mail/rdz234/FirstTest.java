package ru.mail.rdz234;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class FirstTest {

    private static WebDriver driver;

    @BeforeClass

    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "/home/yaroslav/Work/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
        driver.get("https://yandex.ru/");

    }

    @Test

    public void userLogin() {
        WebElement firstButton = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div/div[1]/div/a[1]"));
        firstButton.click();
        WebElement loginField = driver.findElement(By.xpath("//*[@id='passp-field-login']"));
        loginField.sendKeys("testuser47@yandex.ru");
        WebElement enterButton = driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div/div[3]/div[2]/div/div[1]/form/div[3]/button[1]"));
        enterButton.click();
        WebElement passwordField = driver.findElement(By.xpath("//*[@id='passp-field-passwd']"));
        passwordField.sendKeys("TestpassworD"); //enter the incorrect password (correct=testpassworD)
        WebElement loginButton = driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div/div[3]/div[2]/div/div/form/div[2]/button"));
        loginButton.click();
        WebElement errorMessage = driver.findElement(By.xpath("//*[@id='root']/div/div[2]/div/div[3]/div[2]/div/div/form/div[1]/div/div[2]"));
        String mailUser = errorMessage.getText();
    }

    @AfterClass

    public static void tearDown(){
        driver.quit();
    }
}
