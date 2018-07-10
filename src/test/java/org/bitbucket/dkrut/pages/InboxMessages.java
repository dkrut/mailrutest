package org.bitbucket.dkrut.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by @author Denis Krutikov on 09.07.2018.
 */

public class InboxMessages {
    private WebDriver driver;

    public InboxMessages(WebDriver driver) {
        this.driver = driver;
    }

    private By createMessage = By.xpath("//a[@title='Написать письмо (N)']");
    private By to = By.cssSelector(".compose-head__row-wrapper_to [tabindex=\"4\"]");
    private By subject = By.cssSelector(".compose-head__row_nohr .compose-head__cell:nth-of-type(2) .b-input");
    private By frame = By.xpath("//iframe");
    private By body = By.cssSelector("#tinymce");

    public void createNewMessage(String to, String subject, String body){
        driver.findElement(createMessage).click();
        driver.findElement(this.to).sendKeys(to);
        driver.findElement(this.subject).sendKeys(subject);
        driver.switchTo().frame(driver.findElement(frame));
        WebElement messageBody = driver.findElement(this.body);
        messageBody.click();
        messageBody.sendKeys(body);
        messageBody.sendKeys(Keys.CONTROL, Keys.ENTER);
    }
}