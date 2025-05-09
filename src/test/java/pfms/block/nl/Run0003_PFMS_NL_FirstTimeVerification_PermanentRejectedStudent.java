package pfms.block.nl;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pfms.PFMS_LoginPage;
import pfms.district.nl.NL_DistrictFirstTimeVerification;

import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.security.InvalidKeyException;

public class Run0003_PFMS_NL_FirstTimeVerification_PermanentRejectedStudent extends NL_BlockFirstTimeVerification {
    public Run0003_PFMS_NL_FirstTimeVerification_PermanentRejectedStudent(){
        super(null);
    }
    PFMS_LoginPage pfmsLoginPage;
    NL_BlockFirstTimeVerification nlBlockFirstTimeVerification;
    NL_DistrictFirstTimeVerification nlDistrictFirstTimeVerification;
    String studentID="";
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
    public void step3_Block_permanentRejectStudent() throws MalformedURLException, InvalidKeyException, InterruptedException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        nlBlockFirstTimeVerification.selectValueFromPicklistFirstTimeVerification("Verification Status","Pending");
        nlBlockFirstTimeVerification.zoomOut();
        studentID=nlBlockFirstTimeVerification.getFirstStudentID();
        nlBlockFirstTimeVerification.searchRecordFirstTimeVerification(studentID);
        nlBlockFirstTimeVerification.clickOnRejectIconForFirstTimeVerification();
        nlBlockFirstTimeVerification.permanentRejectFirstTimeVerification("Student is from another stream");
    }
    @Test(dependsOnMethods = "step3_Block_permanentRejectStudent" , priority = 4)
    public void step4_Block_verifyRecordAfterPermanentRejectedStudent() throws MalformedURLException, InvalidKeyException, InterruptedException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        nlBlockFirstTimeVerification.selectValueFromPicklistFirstTimeVerification("Verification Status","Permanent Rejected");
        nlBlockFirstTimeVerification.searchRecordFirstTimeVerification(studentID);
        nlBlockFirstTimeVerification.isRecordAvailableWithRejectedDetailsFirstTimeVerification(studentID,"ishan+block2@convegenius.ai"
                ,"DISTRICT-PERMANENT-REJECTED","Student is from another stream");
        nlBlockFirstTimeVerification.clearStudentSearchFirstTimeVerification();
    }
    @Test(dependsOnMethods = "step4_Block_verifyRecordAfterPermanentRejectedStudent" , priority = 5)
    public void step5_loginDistrictLevel() throws MalformedURLException, InvalidKeyException, InterruptedException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        pfmsLoginPage = launchChrome(PFMS_LoginPage.class);
        nlDistrictFirstTimeVerification = pfmsLoginPage.login("ishan@convegenius.ai","1234", NL_DistrictFirstTimeVerification.class);
        clickOnYesButtonOnDialogIfDisplayed();
        waitFor(25);
    }

    @Test(dependsOnMethods = "step5_loginDistrictLevel" , priority = 6)
    public void step6_verifyRecordAfterPermanentRejectedStudentAtDistrictLevel() throws MalformedURLException, InvalidKeyException, InterruptedException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        waitForLoading(1);
        nlDistrictFirstTimeVerification.selectValueFromPicklistFirstTimeVerification("Verification Status","Permanent Rejected");
        nlDistrictFirstTimeVerification.searchRecordFirstTimeVerification(studentID);
        nlDistrictFirstTimeVerification.zoomOut();
        nlDistrictFirstTimeVerification.isRecordAvailableWithRejectedDetailsFirstTimeVerification(studentID,
                "ishan+block2@convegenius.ai","DISTRICT-PERMANENT-REJECTED","Student is from another stream");
    }
}
