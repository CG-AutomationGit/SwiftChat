package pfms.block.nl;

import org.openqa.selenium.chrome.ChromeDriver;
import pfms.base.PFMSBase;

public class NL_BlockFirstTimeVerification extends PFMSBase {

    public NL_BlockFirstTimeVerification(ChromeDriver chromeDriver){
          super(chromeDriver);
    }
    public void verifyRecordAndApprove_Yes(String studentUID){
        searchRecordFirstTimeVerification(studentUID);
        clickOnApproveIconFirstTimeVerification();
        clickOnYesButtonForApproval();
        waitFor(3);
        validateNoDataDisplayedOnGridFirstTimeVerification();
        waitFor(2);
        clearStudentSearchFirstTimeVerification();
    }

    public void verifyRecordAndApprove_No(String studentUID){

    }

    public void verifyRecordAndTemporaryReject(String studentUID , String reason){
        searchRecordFirstTimeVerification(studentUID);
        temporaryRejectFirstTimeVerification(reason);
        validateNoDataDisplayedOnGridFirstTimeVerification();
        waitFor(2);
        clearStudentSearchFirstTimeVerification();
    }
    public void verifyRecordAndTemporaryRejectOtherReason(String studentUID , String reason){

    }

    public void verifyRecordAndPermanentReject(String studentUID , String reason){
        searchRecordFirstTimeVerification(studentUID);
        temporaryRejectFirstTimeVerification(reason);
        validateNoDataDisplayedOnGridFirstTimeVerification();
        waitFor(2);
        clearStudentSearchFirstTimeVerification();
    }
    public void verifyRecordAndPermanentRejectOtherReason(String studentUID , String reason){

    }

    public void validateRecordIsAvailable(String picklist , String option , String studentUID) throws InterruptedException {
        selectValueFromPicklistFirstTimeVerification(picklist,option);
        searchRecordFirstTimeVerification(studentUID);
        isRecordAvailableFirstTimeVerification(studentUID);
    }
}
