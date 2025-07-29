package attendance;

import bot.BotLogin;
import bot.base.BotBase;
import bot.botChat.BotList;
import bot.botChat.Chat;
import bot.botData.AT_Data;
import bot.webview.namo_lakshmi.NamoBotsWebView;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.security.InvalidKeyException;

public class Attendence_001 extends BotBase implements AT_Data {
    public Attendence_001() {
        super(null);
    }

    BotLogin loginPage;
    BotList botList;
    Chat chat;
    NamoBotsWebView namoBotsWebView;


    @BeforeTest(alwaysRun = true)
    public void step1_openChrome() throws MalformedURLException, InvalidKeyException, InterruptedException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        loginPage = launchChromeForBot("ATTENDANCE",BotLogin.class);
        setLanguage("English");
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
    }
    // Java
    @Test(priority = 3)
    public void testSelectEditRegistration() throws Exception {
        chat.selectPersistentMenuOption("Edit Registration");
    }

    @Test(priority = 4)
    public void testIgnoreHint() throws Exception {
        chat.ignoreHint();
    }

    @Test(priority = 5)
    public void testSelectYesButton() throws Exception {
        //chat.selectButtonOptionFromChat("Yes");  DEFECTIVE: This button is not available in the current chat flow
    }

    @Test(priority = 6)
    public void testSendUserReset() throws Exception {
        chat.sendMessage("user reset");
    }

    @Test(priority = 7)
    public void testSendHi() throws Exception {
        chat.sendMessage("Hi");
    }

    @Test(priority = 8)
    public void testValidateResponseGifSt009() throws Exception {
        //chat.validateResponseStringForNamoLaxmi("GIF", "ST009");
    }

    @Test(priority = 9)
    public void testSelectEnglishButton() throws Exception {
        chat.selectButtonOptionFromChat("English");
    }

    @Test(priority = 10)
    public void testValidateResponseGifVideoSt010() throws Exception {
        chat.validateResponseStringForAttendanceBot("GIF", "ST003");
        chat.selectButtonOptionFromChat("Next");
        chat.validateResponseStringForAttendanceBot("ST005");
        chat.sendMessage("92015678910");
        chat.validateResponseStringForAttendanceBot("ST007");

    }


}
