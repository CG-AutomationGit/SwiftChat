package namolaxmi;

import bot.BotLogin;
import bot.base.BotBase;
import bot.botChat.BotList;
import bot.botChat.Chat;
import bot.webview.WebViewBase;
import bot.webview.namo_lakshmi.NamoBotsWebView;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.security.InvalidKeyException;

import static bot.botData.BotData.schoolID;
import static bot.botData.BotData.teacherID;

public class NL_AutomationRun0005 extends NamoBotsWebView {

    public NL_AutomationRun0005() {
        super(null);
    }

    BotLogin loginPage;
    BotList botList;
    Chat chat;
    NamoBotsWebView namoBotsWebView;


    @BeforeTest(alwaysRun = true)
    public void step1_openChrome() throws MalformedURLException, InvalidKeyException, InterruptedException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        loginPage = launchChromeForBot("NL",BotLogin.class);
    }

    @Test(priority = 1)
    public void login() throws MalformedURLException, InvalidKeyException, InterruptedException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        botList = loginPage.loginWithMobileNumber("9723064078");
        }

    @Test(priority = 1)
    public void waitForLogin() throws InterruptedException {
        waitFor(50);
    }

    @Test(priority = 2)
    public void continueBotChat() throws Exception {
        chat = botList.clickOnContinueButton();
        chat.waitFixTime();
    }

    @Test(priority = 3)
    public void resumeForm() throws InterruptedException {
        chat.clickOnComponentButton("Resume Form");
    }

    @Test(priority = 4)
    public void switchToWebView() throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        namoBotsWebView = chat.createBotPageForChrome(NamoBotsWebView.class);
        namoBotsWebView.switchToWebview();
    }

    @Test(priority = 5)
    public void validateDefaultFields() {
        namoBotsWebView.validateAllDefaultFieldsAreAvilalable("Update Student Details");
        namoBotsWebView.validateAllDefaultFieldsAreAvilalable("Search Student");
    }

    @Test(priority = 6)
    public void validateEditableFields() {
        namoBotsWebView.validateAllDefaultFieldsAreEditable("Update Student Details");
        namoBotsWebView.validateAllDefaultFieldsAreEditable("Search Student");
    }

    @Test(priority = 7)
    public void selectStudent() throws InterruptedException {
        namoBotsWebView.clickOnTab("Update Student Details");
        namoBotsWebView.selectRandomStudentValue();
    }

    @Test(priority = 8)
    public void validateFieldsDisplayed() {
        namoBotsWebView.validateAllFieldsAreDisplayed();
    }

    @Test(priority = 9)
    public void validateFieldsEditable() {
        namoBotsWebView.validateAllFieldsAreEditable();
    }

    @Test(priority = 10)
    public void validateHiddenFields() throws InterruptedException {
        namoBotsWebView.validateHiddenFieldsBusinessRules();
    }

    @Test(priority = 11)
    public void validateSubmitButtonAction() throws InterruptedException {
        namoBotsWebView.clickOnSubmitForValidation();
    }

    @Test(priority = 12)
    public void validateGuardianMobileNoMessages() throws InterruptedException {
        namoBotsWebView.validateMessagesForGuardianMobileNo();
    }

    @Test(priority = 13)
    public void validateStudentNameAsPerAadharMessages() throws InterruptedException {
        namoBotsWebView.validateMessagesForStudentNameAsPerAadhar();
    }

    @Test(priority = 14)
    public void validateStudentAadharNumberMessages() throws InterruptedException {
        namoBotsWebView.validateMessagesForStudentAddharNumber();
    }

    @Test(priority = 15)
    public void validateStudentAadharFrontPageMessages() throws InterruptedException {
        namoBotsWebView.validateMessagesForStudentAddharFrontPage();
    }

    @Test(priority = 16)
    public void validateStudentAadharBackPageMessages() throws InterruptedException {
        namoBotsWebView.validateMessagesForStudentAddharBackPage();
    }

    @Test(priority = 17)
    public void validateMotherNameAsPerAadharMessages() throws InterruptedException {
        namoBotsWebView.validateMessagesForMotherNameAsPerAadhar();
    }

    @Test(priority = 18)
    public void validateMotherAadharNumberMessages() throws InterruptedException {
        namoBotsWebView.validateMessagesForMotherAddharNumber();
    }

    @Test(priority = 19)
    public void validateMotherAadharFrontPageMessages() throws InterruptedException {
        namoBotsWebView.validateMessagesForMotherAddharFrontPage();
    }

    @Test(priority = 20)
    public void validateMotherAadharBackPageMessages() throws InterruptedException {
        namoBotsWebView.validateMessagesForMotherAddharBackPage();
    }

    @Test(priority = 21)
    public void validateLCPageMessages() throws InterruptedException {
        namoBotsWebView.validateMessagesForLCPage();
    }

    @Test(priority = 22)
    public void validateIFSCCodeMessages() throws InterruptedException {
        namoBotsWebView.validateMessagesForIFSCCode();
    }

}
