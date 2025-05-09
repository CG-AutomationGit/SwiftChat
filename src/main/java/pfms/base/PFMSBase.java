package pfms.base;

import base.PageObjectModel;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

/**
 * Created By IPrajapati on 28-Jan-2025
 * Convegenius Automation v1.0
 */
public class PFMSBase extends PageObjectModel {

    String StudentName="";
    String FullName="";
    String SchemeSpecificID="";
    String Standard="";
    String Gender="";
    String SchoolCode="";
    String SchoolName="";
    String Village="";
    String Cluster="";
    String Block="";
    String District="";
    String State="";
    String Country="";
    String BankName="";
    String BranchName="";
    String IFSCCode="";
    String AccountNumber="";
    String AadhaarNumber="";
    String PinCode="";
    String DistrictBlockVerifiedAt="";
    String DistrictBlockVerifiedBy="";
    String CreditStatus="";
    String BeneficiaryCode="";
    String CreditedOn="";
    String approveDialogText="Are you sure you want to approve this student?";
    String successMessage = "Successfully Submitted";

    public PFMSBase(ChromeDriver chromeDriver){
         super(chromeDriver);
    }
    public void isRecordAvailableInGrid(String verificationMonthFilter){

    }
    public void isRecordAvailableInGrid(String verificationMonthFilter , String verificationByDistrictFilter){

    }
    public void isRecordAvailableInGrid(String verificationMonthFilter , String verificationByDistrictFilter , String creditStatusFilter){

    }
    public void isRecordAvailableInGridByCreditStatus(String creditStatusFilter){

    }
    public void isRecordAvailableInGridByVerificationDistrict(String creditStatusFilter) {

    }
    public void downloadExcelFirstTimeVerification(){
        chromeDriver.findElement(By.xpath("//div[@role='tabpanel'][1]//div/button/span[text()='Download Excel']"));
    }
    public void downloadTemplateByState(){

    }
    public void uploadCsvByState(){

    }
    private String getTotalRecords(){


        return "";
    }
    public void closeMessage(){

    }
    public void verifyMessage(String msg){
        chromeDriver.findElement(By.xpath("//div[text()='"+msg+"']")); //Successfully Submitted
    }
    public void tapOnFirstVerificationTab() throws InterruptedException {
        Thread.sleep(10000);
        chromeDriver.findElement(By.xpath("//li/button[text()='First Time Verification']")).click();
    }
    public void tapOnRecurringVerificationTab(){

    }
    public void tapOnPaymentLogsTab(){

    }
    public void tapOnUploadLogsTab(){

    }
    public void isRecordAvailableInPaymentLogsGrid(String student_CTSUID){

    }
    private String getTotalRecordsByPaymentLogs(){
        return "";
    }
    public void clickOnButton(String buttonName){

    }
    public void selectValueFromPicklistFirstTimeVerification(String picklistName , String valueName) throws InterruptedException {
        waitForLoading(1);
        chromeDriver.findElement(By.xpath("//div[@role='tabpanel'][1]//div/label[text()='"+picklistName+"']//following-sibling::div")).click();
        String option = chromeDriver.findElement(By.xpath("//div[@role='tabpanel'][1]//div/label[text()='Verification Status']//following-sibling::div/div[text()]")).getText();
        chromeDriver.findElement(By.xpath("//div[text()='"+option+"']//following-sibling::ul/li[text()='"+valueName+"']")).click();
        waitForLoading(1);

    }
    public void clickOnReloadButton(){

    }

    public void clickOnYesButtonOnDialogIfDisplayed(){
        try {
            Assert.assertNotNull(chromeDriver.findElement(By.xpath("//p[text()]/following-sibling::div/button[text()='Yes']")),
                    "Yes Button On Dialog Not Displayed");
            chromeDriver.findElement(By.xpath("//p[text()]/following-sibling::div/button[text()='Yes']")).click();
        }catch (AssertionError error){
            error.getMessage();
        }

    }
    public void searchRecordFirstTimeVerification(String studentUID){
        chromeDriver.findElement(By.xpath("//div[@role='tabpanel'][1]//label[text()='Search Student']" +
                "/following-sibling::div/input")).sendKeys(studentUID);
        chromeDriver.findElement(By.xpath("//div[@role='tabpanel'][1]//label[text()='Search Student']" +
                "/following-sibling::div/button")).click();
        TakesScreenshot take = (TakesScreenshot) chromeDriver;
        //take.ta
    }

    public void isRecordAvailableFirstTimeVerification(String studentUID){
        Assert.assertNotNull(chromeDriver.findElement(By.xpath("//div[@role='tabpanel'][1]//tr/td[3]/div[text()='"+studentUID+"']"))
                ,"Student Not Found even after filtered data");
    }

    public void clickOnYesButtonForApproval(){
        chromeDriver.findElement(By.xpath("//dialog/p[text()='"+approveDialogText+"']/following-sibling::div/button[text()='Yes']")).click();
    }
    public void validateNoDataDisplayedOnGridFirstTimeVerification(){
        Assert.assertNotNull(chromeDriver.findElement(By.xpath("//div[@role='tabpanel'][1]//div/p[text()='No Data']"))
        ,"");
    }

    public void clearStudentSearchFirstTimeVerification(){
        chromeDriver.findElement(By.xpath("//div[@role='tabpanel'][1]//label[text()='Search Student']" +
                "/following-sibling::div/input")).sendKeys("");
    }

    public void clickOnApproveIconFirstTimeVerification(){
        chromeDriver.findElement(By.xpath("//div[@role='tabpanel'][1]//td/div/img[1]")).click();
    }

    public void clickOnRejectIconForFirstTimeVerification() throws InterruptedException {
        waitForLoading(1);
        chromeDriver.findElement(By.xpath("//div[@role='tabpanel'][1]//td/div/img[2]")).click();
    }

    public void clickOnRejectIconForRecurringVerification(){
        chromeDriver.findElement(By.xpath("//div[@role='tabpanel'][2]//td/div/img[2]")).click();
    }

    public void temporaryRejectFirstTimeVerification(String reason){
        chromeDriver.findElement(By.xpath("//span[text()='Temporary']")).click();
        chromeDriver.findElement(By.xpath("//div[text()='Select Rejection Reason']/following-sibling::div/input")).sendKeys(reason);
        Actions action = new Actions(chromeDriver);
        action.sendKeys(Keys.ENTER).perform();
        chromeDriver.findElement(By.xpath("//div[@role='tabpanel'][1]//dialog[1]//div/button[text()='Submit']")).click();
        //verifyMessage(successMessage);    // Defect
    }

    public void permanentRejectFirstTimeVerification(String reason){
        chromeDriver.findElement(By.xpath("//span[text()='Permanent']")).click();
        chromeDriver.findElements(By.xpath("//div[@role='tabpanel'][1]//div[text()='Select Rejection Reason']/" +
                "following-sibling::div/input")).getFirst().sendKeys(reason);
        Actions action = new Actions(chromeDriver);
        action.sendKeys(Keys.ENTER).perform();
        chromeDriver.findElement(By.xpath("//div[@role='tabpanel'][1]//dialog[1]//div/button[text()='Submit']")).click();
        //verifyMessage(successMessage); // Defect : when we search particulate student then message is not displayed even after approved or rejected
        }
      /////////////////////////////////////////////////

      public void isRecordAvailableWithApprovedDetailsFirstTimeVerification(String studentUID , String verifiedBy , String verificationStatus){
          Assert.assertNotNull(chromeDriver.findElement(By.xpath("//tr/td[3]/div[text()='"+studentUID+"']//parent::td//following-sibling::" +
                          "td[21]/div[text()='"+verifiedBy+"']/parent::td//following-sibling::td[2]/div[text()='"+verificationStatus+"']"))
                  ,"Approved Student is not displayed with approved details");
      }

    public void isRecordAvailableWithRejectedDetailsFirstTimeVerification(String studentUID , String verifiedBy , String verificationStatus, String reason){
        Assert.assertNotNull(chromeDriver.findElement(By.xpath("//tr/td[3]/div[text()='"+studentUID+"']//parent::td//following-sibling::" +
                        "td[21]/div[text()='"+verifiedBy+"']/parent::td//following-sibling::td[2]/div[text()='"+verificationStatus+"']/parent::td//" +
                        "following-sibling::td[1][text()='"+reason+"']"))
                ,"Rejected Student is not displayed with Rejected details");
    }

    public String getFirstStudentID(){
        return chromeDriver.findElement(By.xpath("//tr[1]/td[3]/div[text()]")).getText();
    }

}
