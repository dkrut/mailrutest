package org.bitbucket.dkrut.tests;

import org.bitbucket.dkrut.settings.Settings;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

/**
 * Created by @author Denis Krutikov on 09.07.2018.
 */

public class SendMailTest extends Settings {

    private By text = By.cssSelector(".message-sent__wrap .message-sent__title");

    @Test
    public void sendMailTest(){
        mainPage.authorization("qualitylabtest","labqualitytest1");
        inbox.createNewMessage("qualitylabtest@mail.ru", "test", "test");
        Assert.assertEquals("Ваше письмо отправлено. Перейти во Входящие", driver.findElement(text).getText());
        System.out.println("12" +driver.findElement(text).getText());
    }
}
