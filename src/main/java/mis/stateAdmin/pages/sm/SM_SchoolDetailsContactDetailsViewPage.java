package mis.stateAdmin.pages.sm;

import mis.base.MIS_Base;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.lang.reflect.InvocationTargetException;

public class SM_SchoolDetailsContactDetailsViewPage extends MIS_Base {

    WebElement cancelButton , editButton , firstSection , secondSection , thirdSection , forthSection;

    @FindBy(xpath = "//select[@formcontrolname='respondentType']")
    private WebElement respondentType;

    @FindBy(xpath = "//input[@formcontrolname='respondentName']")
    private WebElement respondentName;

    @FindBy(xpath = "//input[@formcontrolname='respondentMobile']")
    private WebElement respondentMobile;

    @FindBy(xpath = "//input[@formcontrolname='schoolMobile']")
    private WebElement schoolMobile;

    @FindBy(xpath = "//input[@formcontrolname='stdCode']")
    private WebElement stdCode;

    @FindBy(xpath = "//input[@formcontrolname='landlineNumber']")
    private WebElement landlineNumber;

    @FindBy(xpath = "//input[@formcontrolname='email']")
    private WebElement email;

    @FindBy(xpath = "//input[@formcontrolname='schoolWebsite']")
    private WebElement schoolWebsite;

    public SM_SchoolDetailsContactDetailsViewPage(ChromeDriver chromeDriver) {
        super(chromeDriver);
    }

    public boolean isRespondentTypeDisplayed() {
        return respondentType.isDisplayed();
    }

    public boolean isRespondentNameDisplayed() {
        return respondentName.isDisplayed();
    }

    public boolean isRespondentMobileDisplayed() {
        return respondentMobile.isDisplayed();
    }

    public boolean isSchoolMobileDisplayed() {
        return schoolMobile.isDisplayed();
    }

    public boolean isStdCodeDisplayed() {
        return stdCode.isDisplayed();
    }

    public boolean isLandlineNumberDisplayed() {
        return landlineNumber.isDisplayed();
    }

    public boolean isEmailDisplayed() {
        return email.isDisplayed();
    }

    public boolean isSchoolWebsiteDisplayed() {
        return schoolWebsite.isDisplayed();
    }


    public boolean isRespondentTypeEnabled() {
        return respondentType.isEnabled();
    }

    public boolean isRespondentNameEnabled() {
        return respondentName.isEnabled();
    }

    public boolean isRespondentMobileEnabled() {
        return respondentMobile.isEnabled();
    }

    public boolean isSchoolMobileEnabled() {
        return schoolMobile.isEnabled();
    }

    public boolean isStdCodeEnabled() {
        return stdCode.isEnabled();
    }

    public boolean isLandlineNumberEnabled() {
        return landlineNumber.isEnabled();
    }

    public boolean isEmailEnabled() {
        return email.isEnabled();
    }

    public boolean isSchoolWebsiteEnabled() {
        return schoolWebsite.isEnabled();
    }


    public void setRespondentType(String type) {
        respondentType.sendKeys(type);
    }

    public void setRespondentName(String name) {
        respondentName.sendKeys(name);
    }

    public void setRespondentMobile(String mobile) {
        respondentMobile.sendKeys(mobile);
    }

    public void setSchoolMobile(String mobile) {
        schoolMobile.sendKeys(mobile);
    }

    public void setStdCode(String code) {
        stdCode.sendKeys(code);
    }

    public void setLandlineNumber(String number) {
        landlineNumber.sendKeys(number);
    }

    public void setEmail(String emailId) {
        email.sendKeys(emailId);
    }

    public void setSchoolWebsite(String website) {
        schoolWebsite.sendKeys(website);
    }


    public String getRespondentType() {
        return respondentType.getText();
    }

    public String getRespondentName() {
        return respondentName.getAttribute("value");
    }

    public String getRespondentMobile() {
        return respondentMobile.getAttribute("value");
    }

    public String getSchoolMobile() {
        return schoolMobile.getAttribute("value");
    }

    public String getStdCode() {
        return stdCode.getAttribute("value");
    }

    public String getLandlineNumber() {
        return landlineNumber.getAttribute("value");
    }

    public String getEmail() {
        return email.getAttribute("value");
    }

    public String getSchoolWebsite() {
        return schoolWebsite.getAttribute("value");
    }


    public boolean areAllContactFieldsDisplayed() {
        return respondentType.isDisplayed()
                && respondentName.isDisplayed()
                && respondentMobile.isDisplayed()
                && schoolMobile.isDisplayed()
                && stdCode.isDisplayed()
                && landlineNumber.isDisplayed()
                && email.isDisplayed()
                && schoolWebsite.isDisplayed();
    }

    public boolean areAllContactFieldsEnabled() {
        return respondentType.isEnabled()
                && respondentName.isEnabled()
                && respondentMobile.isEnabled()
                && schoolMobile.isEnabled()
                && stdCode.isEnabled()
                && landlineNumber.isEnabled()
                && email.isEnabled()
                && schoolWebsite.isEnabled();
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


    public SM_SchoolDetailsContactDetailsEditPage clickEditButton() throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        editButton.click();
        return createMISPageForChrome(SM_SchoolDetailsContactDetailsEditPage.class);    }

    public SM_SchoolProfileGrid clickCancelButton() throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        cancelButton.click();
        return createMISPageForChrome(SM_SchoolProfileGrid.class);
    }

    
}
