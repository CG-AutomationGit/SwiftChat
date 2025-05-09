package pfms.block.nl;

import PAL.fusionV2_5.login.LoginPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pfms.PFMS_LoginPage;
import pfms.block.nl.NL_BlockFirstTimeVerification;
import pfms.district.nl.NL_DistrictFirstTimeVerification;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.security.InvalidKeyException;

public class Run0001_PFMS_NL_FirstTimeVerification_ApproveStudent extends NL_BlockFirstTimeVerification {
    public Run0001_PFMS_NL_FirstTimeVerification_ApproveStudent(){
         super(null);
    }
    PFMS_LoginPage pfmsLoginPage;
    NL_BlockFirstTimeVerification nlBlockFirstTimeVerification;
    NL_DistrictFirstTimeVerification nlDistrictFirstTimeVerification;
    @BeforeTest(alwaysRun = true)
    public void step1_openChrome() throws MalformedURLException, InvalidKeyException, InterruptedException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        pfmsLoginPage = launchChrome(PFMS_LoginPage.class);
    }

    @Test( priority = 1)
    public void step1_loginByBlock() throws MalformedURLException, InvalidKeyException, InterruptedException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        nlBlockFirstTimeVerification = pfmsLoginPage.login("ishan+block2@convegenius.ai","1234",NL_BlockFirstTimeVerification.class);
        clickOnYesButtonOnDialogIfDisplayed();
        waitFor(25);
    }

    @Test(dependsOnMethods = "step1_loginByBlock" , priority = 2)
    public void step2_selectFirstTimeVerificationTab() throws MalformedURLException, InvalidKeyException, InterruptedException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        waitForLoading(1);
        nlBlockFirstTimeVerification.tapOnFirstVerificationTab();
        //Thread.sleep(5000);
        //nlBlockFirstTimeVerification.verifyMessage("Successfully Submitted"); // Defect : When we search student and then successfully submitted msg is not displayed after approved
    }

    @Test(dependsOnMethods = "step2_selectFirstTimeVerificationTab" , priority = 3)
    public void step3_searchStudentAndApprove() throws MalformedURLException, InvalidKeyException, InterruptedException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        nlBlockFirstTimeVerification.selectValueFromPicklistFirstTimeVerification("Verification Status","Pending");
        nlBlockFirstTimeVerification.searchRecordFirstTimeVerification("242202070641420081");
        nlBlockFirstTimeVerification.zoomOut();
        nlBlockFirstTimeVerification.clickOnApproveIconFirstTimeVerification();
        nlBlockFirstTimeVerification.clickOnYesButtonForApproval();
    }

    @Test(dependsOnMethods = "step3_searchStudentAndApprove" , priority = 5)
    public void step4_verifyRecordAfterApprovedStudent() throws MalformedURLException, InvalidKeyException, InterruptedException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        nlBlockFirstTimeVerification.selectValueFromPicklistFirstTimeVerification("Verification Status","Approved");
        nlBlockFirstTimeVerification.isRecordAvailableFirstTimeVerification("242202070641420081");
        nlBlockFirstTimeVerification.clearStudentSearchFirstTimeVerification();
    }

    @Test(dependsOnMethods = "step4_verifyRecordAfterApprovedStudent" , priority = 6)
    public void step5_loginDistrictLevel() throws MalformedURLException, InvalidKeyException, InterruptedException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        pfmsLoginPage = launchChrome(PFMS_LoginPage.class);
        nlDistrictFirstTimeVerification = pfmsLoginPage.login("ishan@convegenius.ai","1234", NL_DistrictFirstTimeVerification.class);
        clickOnYesButtonOnDialogIfDisplayed();
        waitFor(25);
    }

    @Test(dependsOnMethods = "step5_loginDistrictLevel" , priority = 7)
    public void step6_verifyRecordAfterApprovedStudentAtDistrictLevel() throws MalformedURLException, InvalidKeyException, InterruptedException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        waitForLoading(1);
        nlDistrictFirstTimeVerification.selectValueFromPicklistFirstTimeVerification("Verification Status","Approved");
        nlDistrictFirstTimeVerification.searchRecordFirstTimeVerification("242202070641420081");
        nlDistrictFirstTimeVerification.zoomOut();
        nlDistrictFirstTimeVerification.isRecordAvailableWithApprovedDetailsFirstTimeVerification("242202070641420081",
                "ishan+block2@convegenius.ai","DISTRICT-APPROVED");
    }
}
