package org.bitbucket.dkrut.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by @author Denis Krutikov on 09.07.2018.
 */

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private By login = By.cssSelector("#mailbox\\:login");
    private By password = By.cssSelector("#mailbox\\:password");
    private By domainList = By.cssSelector("#mailbox\\:domain");
    private By domainName = By.cssSelector("#mailbox\\:domain option:nth-of-type(1)");
    private By submitButton = By.cssSelector("#mailbox\\:submit");

    private InboxMessages clickSubmitButton(){
        driver.findElement(submitButton).click();
        return new InboxMessages(driver);
    }

    public void authorization(String login, String password){
        driver.findElement(this.login).sendKeys(login);
        driver.findElement(this.password).sendKeys(password);
        driver.findElement(domainList).click();
        driver.findElement(domainName).click();
        clickSubmitButton();
    }
}