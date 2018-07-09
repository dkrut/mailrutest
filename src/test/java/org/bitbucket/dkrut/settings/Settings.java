package org.bitbucket.dkrut.settings;

import org.bitbucket.dkrut.pages.InboxMessages;
import org.bitbucket.dkrut.pages.MainPage;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by @author Denis Krutikov on 09.07.2018.
 */

public class Settings {
    protected WebDriver driver;
    protected MainPage mainPage;
    protected InboxMessages inbox;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/java/org/bitbucket/dkrut/resources/webdrivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://mail.ru/");
        mainPage = new MainPage(driver);
        inbox = new InboxMessages(driver);
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
