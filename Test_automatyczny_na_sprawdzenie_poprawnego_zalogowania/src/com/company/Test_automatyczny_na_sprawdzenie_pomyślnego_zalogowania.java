package com.company;

import jdk.jfr.StackTrace;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CheckLogin {
    private WebDriver wd;
    private String url;
    private String userName;
    private String userPass;

    @Before
    public void setUp(){
        wd = new FirefoxDriver();
        url = "https://www.phptravels.net/login";
        userName = "user@phptravels.com";
        userPass = "demouser"
    }

    @Test
    public void loginNegative(){
        wd.get(url);

        WebElement loginName = wd.findElement(By.name("email"));
        loginName.clear();
        loginName.sendKeys(userName);

        WebElement loginPass = wd.findElement(By.id("password"));
        loginPass.clear();
        loginPass.sendKeys(userPass);

        wd.findElement(By.xpath("//input[@data-style='zoom-in']")).click;

        Assert.assertFalse(wd.getPageSource().contains("Wrong credentials. try again!"));
    }

    @After
    public void tearDown(){
        wd.quit();
    }
}
