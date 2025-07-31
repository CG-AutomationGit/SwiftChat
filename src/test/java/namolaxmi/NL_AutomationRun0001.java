package namolaxmi;

import bot.BotLogin;
import bot.base.BotBase;
import bot.botChat.BotList;
import bot.botChat.Chat;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.security.InvalidKeyException;

import static bot.botData.BotData.*;


import static bot.botData.BotData.schoolID;
import static bot.botData.BotData.teacherID;

public class NL_AutomationRun0001 extends BotBase {

    public NL_AutomationRun0001(){
        super(null);
    }

    BotLogin loginPage;
    BotList botList;
    Chat chat;


    @BeforeTest(alwaysRun = true)
    public void step1_openChrome() throws MalformedURLException, InvalidKeyException, InterruptedException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        loginPage = launchChromeForBot("NL",BotLogin.class);
    }

    @Test(priority = 1)
    public void login() throws InvalidKeyException, InterruptedException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
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
        chat.selectButtonOptionFromChat("Yes");
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
        chat.validateResponseStringForNamoLaxmi("GIF", "ST009");
    }

    @Test(priority = 9)
    public void testSelectEnglishButton() throws Exception {
        chat.selectButtonOptionFromChat("English");
    }

    @Test(priority = 10)
    public void testValidateResponseGifVideoSt010() throws Exception {
        chat.validateResponseStringForNamoLaxmi("GIF", "VIDEO", "ST010");
    }

    @Test(priority = 11)
    public void testSelectNextButton() throws Exception {
        chat.selectButtonOptionFromChat("Next");
    }

    @Test(priority = 12)
    public void testValidateResponseSt012() throws Exception {
        chat.validateResponseStringForNamoLaxmi("ST012");
    }

    @Test(priority = 13)
    public void testSendSchoolId() throws Exception {
        chat.setSchoolCode();
    }

    @Test(priority = 14)
    public void testValidateResponseSt016() throws Exception {
        chat.validateResponseStringForNamoLaxmi("ST016");
    }

    @Test(priority = 15)
    public void testSelectDetailsCorrectYes() throws Exception {
        chat.selectButtonOptionFromChat("Yes, the details are correct ");
    }

    @Test(priority = 16)
    public void testValidateResponseSt019() throws Exception {
        chat.validateResponseStringForNamoLaxmi("ST019");
    }

    @Test(priority = 17)
    public void testSendTeacherId() throws Exception {
        chat.setTeacherCode();
    }

    @Test(priority = 18)
    public void testValidateResponseSt020() throws Exception {
        chat.validateResponseStringForNamoLaxmi("ST020");
    }

    @Test(priority = 19)
    public void testSelectDetailsCorrectYesAgain() throws Exception {
        chat.selectButtonOptionFromChat("Yes, the details are correct ");
    }

    @Test(priority = 20)
    public void testValidateResponseGifSt025St026() throws Exception {
        chat.validateResponseStringForNamoLaxmi("GIF", "ST025", "ST026");
    }

    @Test(priority = 21)
    public void testValidateButtonsUpdateCheck() throws Exception {
        chat.validateButtons("Update Student Details", "Check Verification Status");
    }

    @Test(priority = 22)
    public void testSelectUpdateStudentDetails() throws Exception {
        chat.selectButtonOptionFromChat("Update Student Details");
    }

    @Test(priority = 23)
    public void testValidateResponseSt029() throws Exception {
        chat.validateResponseStringForNamoLaxmi("ST029");
    }

    @Test(priority = 24)
    public void testSelectClassAndSection() throws Exception {
        chat.selectClassAndSectionForNamoBots();
    }

    @Test(priority = 25)
    public void testValidateResponsePdfSt035St040() throws Exception {
        chat.validateResponseStringForNamoLaxmi("PDF", "ST035_COMP", "ST040");
    }

    @Test(priority = 26)
    public void testSelectContinueButton() throws Exception {
        chat.selectButtonOptionFromChat("Continue");
    }

    @Test(priority = 27)
    public void testValidateResponsePdfSt035St040Again() throws Exception {
        chat.validateResponseStringForNamoLaxmi("PDF", "ST035_COMP", "ST040");
    }

    @Test(priority = 28)
    public void testSelectHomeMenuButton() throws Exception {
        chat.selectButtonOptionFromChat("Home Menu");
    }

    @Test(priority = 29)
    public void testValidateResponseSt026() throws Exception {
        chat.validateResponseStringForNamoLaxmi("ST026");
    }

    @Test(priority = 30)
    public void testValidateButtonsUpdateCheckAgain() throws Exception {
        chat.validateButtons("Update Student Details", "Check Verification Status");
    }

    @Test(priority = 31)
    public void testSelectCheckVerificationStatus() throws Exception {
        chat.selectButtonOptionFromChat("Check Verification Status");
    }

    @Test(priority = 32)
    public void testValidateResponseSt042() throws Exception {
       // chat.validateResponseStringForNamoLaxmi("ST042");
    }

    @Test(priority = 33)
    public void testValidateResponseST046ST026() throws Exception {
        //chat.selectClassAndSection();
        chat.validateResponseStringForNamoLaxmi("ST046","ST026");
    }

    // Java
   /* @Test(priority = 34)
    public void testValidateResponseSt084() throws Exception {
        chat.validateResponseStringForNamoLaxmi("ST084");
    }*/

    @Test(priority = 35)
    public void testValidateButtonsUpdateDownload() throws Exception {
        chat.validateButtons("Update Student Details", "Download Report");
    }

    @Test(priority = 36)
    public void testSelectUpdateStudentDetailsAgain() throws Exception {
        chat.selectButtonOptionFromChat("Update Student Details");
    }

    @Test(priority = 37)
    public void testValidateResponseSt029Again() throws Exception {
        chat.validateResponseStringForNamoLaxmi("ST029");
    }

    @Test(priority = 38)
    public void testSelectHomeMenuAgain() throws Exception {
        chat.selectPersistentMenuOption("Home Menu");
    }

    @Test(priority = 39)
    public void testValidateResponseST005() throws Exception {
        chat.validateResponseStringForNamoLaxmi("ST005");
        chat.selectButtonOptionFromChat("Yes");
    }

    @Test(priority = 40)
    public void testValidateButtonsUpdateCheckAgain2() throws Exception {
        chat.validateButtons("Update Student Details", "Check Verification Status");
    }

    @Test(priority = 41)
    public void testSelectEditRegistrationAgain() throws Exception {
        chat.selectPersistentMenuOption("Edit Registration");
    }

    @Test(priority = 42)
    public void testValidateResponseSt005() throws Exception {
        chat.validateResponseStringForNamoLaxmi("ST005");
    }

    @Test(priority = 43)
    public void testSelectNoButton() throws Exception {
        chat.selectButtonOptionFromChat("No");
    }

    @Test(priority = 44)
    public void testValidateResponseSt029Final() throws Exception {
        chat.validateResponseStringForNamoLaxmi("ST026");
    }



}
