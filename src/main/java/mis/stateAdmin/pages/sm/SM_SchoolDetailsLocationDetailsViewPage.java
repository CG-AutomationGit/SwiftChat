package mis.stateAdmin.pages.sm;

import mis.base.MIS_Base;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.lang.reflect.InvocationTargetException;

public class SM_SchoolDetailsLocationDetailsViewPage extends MIS_Base {

    WebElement cancelButton , editButton , firstSection , secondSection , thirdSection , forthSection;

    @FindBy(xpath = "//input[@placeholder='Enter School Address']")
    private WebElement schoolAddress;

    @FindBy(xpath = "//input[@placeholder='Enter School Pincode']")
    private WebElement schoolPincode;

    @FindBy(xpath = "//input[@placeholder='Enter Latitude']")
    private WebElement latitude;

    @FindBy(xpath = "//input[@placeholder='Enter Longitude']")
    private WebElement longitude;

    @FindBy(xpath = "//input[@placeholder='Enter Name of Revenue Block']")
    private WebElement revenueBlock;

    @FindBy(xpath = "//input[@placeholder='Enter Village Name']")
    private WebElement villageName;

    @FindBy(xpath = "//input[@placeholder='Enter Gram Panchayat']")
    private WebElement gramPanchayat;

    @FindBy(xpath = "//input[@placeholder='Enter Urban Local Body']")
    private WebElement urbanLocalBody;

    @FindBy(xpath = "//input[@placeholder='Enter Ward Name']")
    private WebElement wardName;

    public boolean isSchoolAddressEnabled() {
        return schoolAddress.isEnabled();
    }

    public boolean isSchoolPincodeEnabled() {
        return schoolPincode.isEnabled();
    }

    public boolean isLatitudeEnabled() {
        return latitude.isEnabled();
    }

    public boolean isLongitudeEnabled() {
        return longitude.isEnabled();
    }

    public boolean isRevenueBlockEnabled() {
        return revenueBlock.isEnabled();
    }

    public boolean isVillageNameEnabled() {
        return villageName.isEnabled();
    }

    public boolean isGramPanchayatEnabled() {
        return gramPanchayat.isEnabled();
    }

    public boolean isUrbanLocalBodyEnabled() {
        return urbanLocalBody.isEnabled();
    }

    public boolean isWardNameEnabled() {
        return wardName.isEnabled();
    }

    public boolean isSchoolAddressDisplayed() {
        return schoolAddress.isDisplayed();
    }

    public boolean isSchoolPincodeDisplayed() {
        return schoolPincode.isDisplayed();
    }

    public boolean isLatitudeDisplayed() {
        return latitude.isDisplayed();
    }

    public boolean isLongitudeDisplayed() {
        return longitude.isDisplayed();
    }

    public boolean isRevenueBlockDisplayed() {
        return revenueBlock.isDisplayed();
    }

    public boolean isVillageNameDisplayed() {
        return villageName.isDisplayed();
    }

    public boolean isGramPanchayatDisplayed() {
        return gramPanchayat.isDisplayed();
    }

    public boolean isUrbanLocalBodyDisplayed() {
        return urbanLocalBody.isDisplayed();
    }

    public boolean isWardNameDisplayed() {
        return wardName.isDisplayed();
    }

    public void setSchoolAddress(String schoolAddress) {
        this.schoolAddress.sendKeys(schoolAddress);
    }

    public void setSchoolPincode(String schoolPincode) {
        this.schoolPincode.sendKeys(schoolPincode);
    }

    public void setLatitude(String latitude) {
        this.latitude.sendKeys(latitude);
    }

    public void setLongitude(String longitude) {
        this.longitude.sendKeys(longitude);
    }

    public void setRevenueBlock(String revenueBlock) {
        this.revenueBlock.sendKeys(revenueBlock);
    }

    public void setVillageName(String villageName) {
        this.villageName.sendKeys(villageName);
    }

    public void setGramPanchayat(String gramPanchayat) {
        this.gramPanchayat.sendKeys(gramPanchayat);
    }

    public void setUrbanLocalBody(String urbanLocalBody) {
        this.urbanLocalBody.sendKeys(urbanLocalBody);
    }

    public void setWardName(String wardName) {
        this.wardName.sendKeys(wardName);
    }

    public String getSchoolAddress() {
        return schoolAddress.getText();
    }

    public String getSchoolPincode() {
        return schoolPincode.getText();
    }

    public String getLatitude() {
        return latitude.getText();
    }

    public String getLongitude() {
        return longitude.getText();
    }

    public String getRevenueBlock() {
        return revenueBlock.getText();
    }

    public String getVillageName() {
        return villageName.getText();
    }

    public String getGramPanchayat() {
        return gramPanchayat.getText();
    }

    public String getUrbanLocalBody() {
        return urbanLocalBody.getText();
    }

    public String getWardName() {
        return wardName.getText();
    }

   

    public boolean areAllFieldsEnabled() {
        return schoolAddress.isEnabled()
                && schoolPincode.isEnabled()
                && latitude.isEnabled()
                && longitude.isEnabled()
                && revenueBlock.isEnabled()
                && villageName.isEnabled()
                && gramPanchayat.isEnabled()
                && urbanLocalBody.isEnabled()
                && wardName.isEnabled();
    }


    public boolean areAllFieldsDisplayed() {
        return schoolAddress.isDisplayed()
                && schoolPincode.isDisplayed()
                && latitude.isDisplayed()
                && longitude.isDisplayed()
                && revenueBlock.isDisplayed()
                && villageName.isDisplayed()
                && gramPanchayat.isDisplayed()
                && urbanLocalBody.isDisplayed()
                && wardName.isDisplayed();
    }



    public SM_SchoolDetailsLocationDetailsViewPage(ChromeDriver chromeDriver) {
        super(chromeDriver);
        PageFactory.initElements(chromeDriver , this);
    }

    public boolean isCancelAndEditButtonDisplayed(){
        try {
            cancelButton = chromeDriver.findElement(By.xpath("//button/span[text()='Cancel']"));
            editButton = chromeDriver.findElement(By.xpath("//button/span[text()='Edit']"));
            return cancelButton.getText().equals("Cancel") && editButton.getText().equals("Edit");
        }catch (NoSuchElementException e){
            return false;
        }
    }

    public boolean isSectionsDisplayed(){
        firstSection = chromeDriver.findElement(By.xpath("//div[@class='column']/h4[text()='General']" +
                "/following-sibling::h4[text()='Profile']"));
        secondSection = chromeDriver.findElement(By.xpath("//div[@class='column']/h4[text()='Location &']" +
                "/following-sibling::h4[text()='LGD Details']"));

        thirdSection = chromeDriver.findElement(By.xpath("//div[@class='column']/h4[text()='Contact']" +
                "/following-sibling::h4[text()='Details']"));
        forthSection = chromeDriver.findElement(By.xpath("//div[@class='column']/h4[text()='Additional']" +
                "/following-sibling::h4[text()='Details']"));
        return firstSection!=null && secondSection!=null && thirdSection!=null && forthSection!=null;
    }

    public SM_SchoolDetailsGeneralProfileViewPage openGeneralDetails() throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        secondSection = chromeDriver.findElement(By.xpath("//button[text()=' 1 ']"));
        secondSection.click();
        return createMISPageForChrome(SM_SchoolDetailsGeneralProfileViewPage.class);
    }


    public SM_SchoolDetailsLocationDetailsViewPage openLocationLGDDetails() throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        secondSection = chromeDriver.findElement(By.xpath("//button[text()=' 2 ']"));
        secondSection.click();
        return createMISPageForChrome(SM_SchoolDetailsLocationDetailsViewPage.class);
    }

    public SM_SchoolDetailsContactDetailsViewPage openContactDetails() throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        thirdSection = chromeDriver.findElement(By.xpath("//button[text()=' 3 ']"));
        thirdSection.click();
        return createMISPageForChrome(SM_SchoolDetailsContactDetailsViewPage.class);
    }

    public SM_SchoolDetailsAdditionalDetailsViewPage openAdditionalDetails() throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        forthSection = chromeDriver.findElement(By.xpath("//button[text()=' 4 ']"));
        forthSection.click();
        return createMISPageForChrome(SM_SchoolDetailsAdditionalDetailsViewPage.class);
    }

    public boolean areEditAndCancelButtonsDisplayed() {
        return editButton.isDisplayed() && cancelButton.isDisplayed();
    }


    public boolean areEditAndCancelButtonsEnabled() {
        return editButton.isEnabled() && cancelButton.isEnabled();
    }


    public void clickEditButton() {
        editButton.click();
    }

    public void clickCancelButton() {
        cancelButton.click();
    }

    


}
