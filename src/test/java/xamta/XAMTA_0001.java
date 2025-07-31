package xamta;

import bot.BotLogin;
import bot.base.BotBase;
import bot.botChat.BotList;
import bot.botChat.BotSettings;
import bot.botChat.Chat;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.security.InvalidKeyException;

public class XAMTA_0001 extends BotBase {

    public XAMTA_0001(){
        super(null);
    }

    BotLogin loginPage;
    BotList botList;
    Chat chat;
    BotSettings botSettings;


    @BeforeTest(alwaysRun = true)
    public void step1_openChrome() throws MalformedURLException, InvalidKeyException, InterruptedException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        loginPage = launchChromeForBot("XAMTA",BotLogin.class);
    }

    @Test(priority = 1)
    public void login() throws MalformedURLException, InvalidKeyException, InterruptedException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        botList = loginPage.loginWithMobileNumber("9723064078");
        botList.waitFor(20);
    }

    @Test(priority = 2)
    public void completeLogin() throws MalformedURLException, InvalidKeyException, InterruptedException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Thread.sleep(5000);

        chat = botList.clickOnContinueButton();
        chat.selectClassAndSectionRandomly();


    }
}
