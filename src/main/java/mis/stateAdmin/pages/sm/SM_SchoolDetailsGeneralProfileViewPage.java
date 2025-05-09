package mis.stateAdmin.pages.sm;

import mis.base.MIS_Base;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.lang.reflect.InvocationTargetException;

public class SM_SchoolDetailsGeneralProfileViewPage extends MIS_Base {

    WebElement cancelButton , editButton , firstSection , secondSection , thirdSection , forthSection;

    @FindBy(xpath = "//label[text()=' 1). UDISE Code']/following-sibling::nz-input-group/input")
    private WebElement udiseCode;

    @FindBy(xpath = "//label[text()=' 2). School Name (In capital letters)']/following-sibling::nz-input-group/input")

    private WebElement schoolName;

    @FindBy(xpath = "//label[text()=' 3). District Name']/following-sibling::nz-input-group/input")

    private WebElement districtName;

    @FindBy(xpath = "//label[text()=' 4). Block Name']/following-sibling::nz-input-group/input")

    private WebElement blockName;

    @FindBy(xpath = "//label[text()=' 5). School Location Type']/following-sibling::nz-input-group//input")

    private WebElement schoolLocationType;

    @FindBy(xpath = "//label[text()=' 6). Cluster Resource Centre (CRC)']/following-sibling::nz-input-group//input")
    private WebElement clusterResourceCentre;

    @FindBy(xpath = "//label[text()=' 7). Assembly Constituency Code']/following-sibling::nz-input-group//input")
    private WebElement assemblyConstituencyCode;

    @FindBy(xpath = "//label[text()=' 8). Parliamentary Constituency Code']/following-sibling::nz-input-group//input")
    private WebElement parliamentaryConstituencyCode;

    @FindBy(xpath = "//label[text()=' 9). School Management Code']/following-sibling::nz-input-group//input")
    private WebElement schoolManagementCode;

    @FindBy(xpath = "//label[text()=' 10). For Management Code 101 mention Nodal Ministry/Dept.']/following-sibling::nz-input-group//input")
    private WebElement nodalMinistry;

    @FindBy(xpath = "//label[text()=' 11). School Category Code']/following-sibling::nz-input-group//input")
    private WebElement schoolCategoryCode;

    @FindBy(xpath = "//label[text()=' 12). Lowest Class']/following-sibling::nz-input-group//input")
    private WebElement lowestClass;

    @FindBy(xpath = "//label[text()=' 13). Highest Class']/following-sibling::nz-input-group//input")
    private WebElement highestClass;

    @FindBy(xpath = "//label[text()=' 14). Whether pre-primary section (other than Anganwadi) attached to school?']/following-sibling::nz-input-group//input")
    private WebElement prePrimaryAttached;

    @FindBy(xpath = "//label[text()=' 15). Number of Classes/Grades in Pre-Primary Section']/following-sibling::nz-input-group//input")
    private WebElement numClassesPrePrimary;

    @FindBy(xpath = "//label[text()=' 16). Type of School']/following-sibling::nz-input-group//input")
    private WebElement typeOfSchool;

    @FindBy(xpath = "//label[text()=' 17). School Status']/following-sibling::nz-input-group//input")
    private WebElement schoolStatus;

    @FindBy(xpath = "//label[text()=' 18). Session Start Date']/following-sibling::nz-input-group//input")
    private WebElement sessionStartDate;

    @FindBy(xpath = "//label[text()=' 19). Session End Date']/following-sibling::nz-input-group//input")
    private WebElement sessionEndDate;

    @FindBy(xpath = "//label[text()=' 20). Stream Arts']/following-sibling::nz-input-group//input")
    private WebElement streamArts;

    @FindBy(xpath = "//label[text()=' 21). Stream Vocational']/following-sibling::nz-input-group//input")
    private WebElement streamVocational;

    @FindBy(xpath = "//label[text()=' 22). Stream Science']/following-sibling::nz-input-group//input")
    private WebElement streamScience;

    @FindBy(xpath = "//label[text()=' 23). Stream Commerce']/following-sibling::nz-input-group//input")
    private WebElement streamCommerce;

    @FindBy(xpath = "//label[text()=' 24). Stream Others']/following-sibling::nz-input-group//input")
    private WebElement streamOthers;

    public SM_SchoolDetailsGeneralProfileViewPage(ChromeDriver chromeDriver) {
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

    // Methods to check editability
    public boolean isUDISECodeEditable() {
        return udiseCode.isEnabled();
    }

    public boolean isUDISECodeDisplayed() {
        return udiseCode.isDisplayed();
    }

    public boolean isSchoolNameEditable() {
        return schoolName.isEnabled();
    }

    public boolean isSchoolNameDisplayed() {
        return schoolName.isDisplayed();
    }

    public boolean isDistrictNameEditable() {
        return districtName.isEnabled();
    }

    public boolean isDistrictNameDisplayed() {
        return districtName.isDisplayed();
    }

    public boolean isBlockNameEditable() {
        return blockName.isEnabled();
    }

    public boolean isBlockNameDisplayed() {
        return blockName.isDisplayed();
    }

    public boolean isSchoolLocationTypeEditable() {
        return schoolLocationType.isEnabled();
    }

    public boolean isSchoolLocationTypeDisplayed() {
        return schoolLocationType.isDisplayed();
    }

    public boolean isClusterResourceCentreEditable() {
        return clusterResourceCentre.isEnabled();
    }

    public boolean isClusterResourceCentreDisplayed() {
        return clusterResourceCentre.isDisplayed();
    }

    public boolean isAssemblyConstituencyCodeEditable() {
        return assemblyConstituencyCode.isEnabled();
    }

    public boolean isAssemblyConstituencyCodeDisplayed() {
        return assemblyConstituencyCode.isDisplayed();
    }

    public boolean isParliamentaryConstituencyCodeEditable() {
        return parliamentaryConstituencyCode.isEnabled();
    }

    public boolean isParliamentaryConstituencyCodeDisplayed() {
        return parliamentaryConstituencyCode.isDisplayed();
    }

    public boolean isSchoolManagementCodeEditable() {
        return schoolManagementCode.isEnabled();
    }

    public boolean isSchoolManagementCodeDisplayed() {
        return schoolManagementCode.isDisplayed();
    }

    public boolean isNodalMinistryEditable() {
        return nodalMinistry.isEnabled();
    }

    public boolean isNodalMinistryDisplayed() {
        return nodalMinistry.isDisplayed();
    }

    public boolean isSchoolCategoryCodeEditable() {
        return schoolCategoryCode.isEnabled();
    }

    public boolean isSchoolCategoryCodeDisplayed() {
        return schoolCategoryCode.isDisplayed();
    }

    public boolean isLowestClassEditable() {
        return lowestClass.isEnabled();
    }

    public boolean isLowestClassDisplayed() {
        return lowestClass.isDisplayed();
    }

    public boolean isHighestClassEditable() {
        return highestClass.isEnabled();
    }

    public boolean isHighestClassDisplayed() {
        return highestClass.isDisplayed();
    }

    public boolean isPrePrimaryAttachedEditable() {
        return prePrimaryAttached.isEnabled();
    }

    public boolean isPrePrimaryAttachedDisplayed() {
        return prePrimaryAttached.isDisplayed();
    }

    public boolean isNumClassesPrePrimaryEditable() {
        return numClassesPrePrimary.isEnabled();
    }

    public boolean isNumClassesPrePrimaryDisplayed() {
        return numClassesPrePrimary.isDisplayed();
    }

    public boolean isTypeOfSchoolEditable() {
        return typeOfSchool.isEnabled();
    }

    public boolean isTypeOfSchoolDisplayed() {
        return typeOfSchool.isDisplayed();
    }

    public boolean isSchoolStatusEditable() {
        return schoolStatus.isEnabled();
    }

    public boolean isSchoolStatusDisplayed() {
        return schoolStatus.isDisplayed();
    }

    public boolean isSessionStartDateEditable() {
        return sessionStartDate.isEnabled();
    }

    public boolean isSessionStartDateDisplayed() {
        return sessionStartDate.isDisplayed();
    }

    public boolean isSessionEndDateEditable() {
        return sessionEndDate.isEnabled();
    }

    public boolean isSessionEndDateDisplayed() {
        return sessionEndDate.isDisplayed();
    }

    public boolean isStreamArtsEditable() {
        return streamArts.isEnabled();
    }

    public boolean isStreamArtsDisplayed() {
        return streamArts.isDisplayed();
    }

    public boolean isStreamVocationalEditable() {
        return streamVocational.isEnabled();
    }

    public boolean isStreamVocationalDisplayed() {
        return streamVocational.isDisplayed();
    }

    public boolean isStreamScienceEditable() {
        return streamScience.isEnabled();
    }

    public boolean isStreamScienceDisplayed() {
        return streamScience.isDisplayed();
    }

    public boolean isStreamCommerceEditable() {
        return streamCommerce.isEnabled();
    }

    public boolean isStreamCommerceDisplayed() {
        return streamCommerce.isDisplayed();
    }

    public boolean isStreamOthersEditable() {
        return streamOthers.isEnabled();
    }

    public boolean isStreamOthersDisplayed() {
        return streamOthers.isDisplayed();
    }

    public boolean areAllFieldsDisplayed() {
        return isUDISECodeDisplayed() &&
                isSchoolNameDisplayed() &&
                isDistrictNameDisplayed() &&
                isBlockNameDisplayed() &&
                isSchoolLocationTypeDisplayed() &&
                isClusterResourceCentreDisplayed() &&
                isAssemblyConstituencyCodeDisplayed() &&
                isParliamentaryConstituencyCodeDisplayed() &&
                isSchoolManagementCodeDisplayed() &&
                isNodalMinistryDisplayed() &&
                isSchoolCategoryCodeDisplayed() &&
                isLowestClassDisplayed() &&
                isHighestClassDisplayed() &&
                isPrePrimaryAttachedDisplayed() &&
                isNumClassesPrePrimaryDisplayed() &&
                isTypeOfSchoolDisplayed() &&
                isSchoolStatusDisplayed() &&
                isSessionStartDateDisplayed() &&
                isSessionEndDateDisplayed() &&
                isStreamArtsDisplayed() &&
                isStreamVocationalDisplayed() &&
                isStreamScienceDisplayed() &&
                isStreamCommerceDisplayed() &&
                isStreamOthersDisplayed();
    }


    public boolean areAllFieldsEditable() {
        return isUDISECodeEditable() &&
                isSchoolNameEditable() &&
                isDistrictNameEditable() &&
                isBlockNameEditable() &&
                isSchoolLocationTypeEditable() &&
                isClusterResourceCentreEditable() &&
                isAssemblyConstituencyCodeEditable() &&
                isParliamentaryConstituencyCodeEditable() &&
                isSchoolManagementCodeEditable() &&
                isNodalMinistryEditable() &&
                isSchoolCategoryCodeEditable() &&
                isLowestClassEditable() &&
                isHighestClassEditable() &&
                isPrePrimaryAttachedEditable() &&
                isNumClassesPrePrimaryEditable() &&
                isTypeOfSchoolEditable() &&
                isSchoolStatusEditable() &&
                isSessionStartDateEditable() &&
                isSessionEndDateEditable() &&
                isStreamArtsEditable() &&
                isStreamVocationalEditable() &&
                isStreamScienceEditable() &&
                isStreamCommerceEditable() &&
                isStreamOthersEditable();
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

