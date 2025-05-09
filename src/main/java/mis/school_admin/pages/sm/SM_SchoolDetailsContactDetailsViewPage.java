package mis.school_admin.pages.sm;

import mis.base.MIS_Base;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
 * This class represents the School Details Contact Details View page in the application.
 * It interacts with various web elements on the page for accessing, verifying, and interacting with the form fields
 * and performing operations such as searching and verifying records in the grid.
 *
 * The page is designed to capture and validate contact details of a school and provides functionality
 * to verify the visibility and editability of form fields as well as search for school records.
 *
 * The class extends the MIS_Base class, inheriting its base functionality and page interactions.
 */
public class SM_SchoolDetailsContactDetailsViewPage extends MIS_Base {

    WebElement cancelButton, editButton, firstSection, secondSection, thirdSection, forthSection;


    public SM_SchoolDetailsContactDetailsViewPage(ChromeDriver chromeDriver) {
        super(chromeDriver);
    }


    @FindBy(xpath = "//input[@placeholder='UDISE Code']")
    WebElement udiseCode;

    @FindBy(xpath = "//input[contains(@placeholder, 'School Name')]")
    WebElement schoolName;

    @FindBy(xpath = "//input[contains(@placeholder, 'District Name')]")
    WebElement districtName;

    @FindBy(xpath = "//input[contains(@placeholder, 'Block Name')]")
    WebElement blockName;

    @FindBy(xpath = "//select[@formcontrolname='schoolLocationType']")
    WebElement schoolLocationType;

    @FindBy(xpath = "//input[contains(@placeholder, 'Cluster Resource Centre')]")
    WebElement clusterResourceCentre;

    @FindBy(xpath = "//input[@formcontrolname='assemblyConstituencyCode']")
    WebElement assemblyConstituencyCode;

    @FindBy(xpath = "//input[@formcontrolname='parliamentaryConstituencyCode']")
    WebElement parliamentaryConstituencyCode;

    @FindBy(xpath = "//select[@formcontrolname='schoolManagementCode']")
    WebElement schoolManagementCode;

    @FindBy(xpath = "//select[@formcontrolname='nodalMinistryCode']")
    WebElement managementCode101;

    @FindBy(xpath = "//select[@formcontrolname='schoolCategoryCode']")
    WebElement schoolCategoryCode;

    @FindBy(xpath = "//input[@formcontrolname='lowestClass']")
    WebElement lowestClass;

    @FindBy(xpath = "//input[@formcontrolname='highestClass']")
    WebElement highestClass;

    @FindBy(xpath = "//select[@formcontrolname='prePrimaryAttached']")
    WebElement prePrimaryAttached;

    @FindBy(xpath = "//select[@formcontrolname='noOfClassesInPrePrimary']")
    WebElement numClassesPrePrimary;

    @FindBy(xpath = "//select[@formcontrolname='schoolType']")
    WebElement typeOfSchool;

    @FindBy(xpath = "//input[@formcontrolname='schoolStatus']")
    WebElement schoolStatus;

    @FindBy(xpath = "//input[@formcontrolname='sessionStartDate']")
    WebElement sessionStartDate;

    @FindBy(xpath = "//input[@formcontrolname='sessionEndDate']")
    WebElement sessionEndDate;

    @FindBy(xpath = "//select[@formcontrolname='streamArts']")
    WebElement streamArts;

    @FindBy(xpath = "//select[@formcontrolname='streamVocational']")
    WebElement streamVocational;

    @FindBy(xpath = "//select[@formcontrolname='streamScience']")
    WebElement streamScience;

    @FindBy(xpath = "//select[@formcontrolname='streamCommerce']")
    WebElement streamCommerce;

    @FindBy(xpath = "//select[@formcontrolname='streamOthers']")
    WebElement streamOthers;

    // === Methods to verify if elements are displayed ===

    public boolean isUdiseCodeDisplayed() {
        return udiseCode.isDisplayed();
    }

    public boolean isSchoolNameDisplayed() {
        return schoolName.isDisplayed();
    }

    public boolean isDistrictNameDisplayed() {
        return districtName.isDisplayed();
    }

    public boolean isBlockNameDisplayed() {
        return blockName.isDisplayed();
    }

    public boolean isSchoolLocationTypeDisplayed() {
        return schoolLocationType.isDisplayed();
    }

    public boolean isClusterResourceCentreDisplayed() {
        return clusterResourceCentre.isDisplayed();
    }

    public boolean isAssemblyConstituencyCodeDisplayed() {
        return assemblyConstituencyCode.isDisplayed();
    }

    public boolean isParliamentaryConstituencyCodeDisplayed() {
        return parliamentaryConstituencyCode.isDisplayed();
    }

    public boolean isSchoolManagementCodeDisplayed() {
        return schoolManagementCode.isDisplayed();
    }

    public boolean isManagementCode101Displayed() {
        return managementCode101.isDisplayed();
    }

    public boolean isSchoolCategoryCodeDisplayed() {
        return schoolCategoryCode.isDisplayed();
    }

    public boolean isLowestClassDisplayed() {
        return lowestClass.isDisplayed();
    }

    public boolean isHighestClassDisplayed() {
        return highestClass.isDisplayed();
    }

    public boolean isPrePrimaryAttachedDisplayed() {
        return prePrimaryAttached.isDisplayed();
    }

    public boolean isNumClassesPrePrimaryDisplayed() {
        return numClassesPrePrimary.isDisplayed();
    }

    public boolean isTypeOfSchoolDisplayed() {
        return typeOfSchool.isDisplayed();
    }

    public boolean isSchoolStatusDisplayed() {
        return schoolStatus.isDisplayed();
    }

    public boolean isSessionStartDateDisplayed() {
        return sessionStartDate.isDisplayed();
    }

    public boolean isSessionEndDateDisplayed() {
        return sessionEndDate.isDisplayed();
    }

    public boolean isStreamArtsDisplayed() {
        return streamArts.isDisplayed();
    }

    public boolean isStreamVocationalDisplayed() {
        return streamVocational.isDisplayed();
    }

    public boolean isStreamScienceDisplayed() {
        return streamScience.isDisplayed();
    }

    public boolean isStreamCommerceDisplayed() {
        return streamCommerce.isDisplayed();
    }

    public boolean isStreamOthersDisplayed() {
        return streamOthers.isDisplayed();
    }

    // === Methods to verify if elements are editable ===

    public boolean isUdiseCodeEditable() {
        return udiseCode.isEnabled();
    }

    public boolean isSchoolNameEditable() {
        return schoolName.isEnabled();
    }

    public boolean isDistrictNameEditable() {
        return districtName.isEnabled();
    }

    public boolean isBlockNameEditable() {
        return blockName.isEnabled();
    }

    public boolean isSchoolLocationTypeEditable() {
        return schoolLocationType.isEnabled();
    }

    public boolean isClusterResourceCentreEditable() {
        return clusterResourceCentre.isEnabled();
    }

    public boolean isAssemblyConstituencyCodeEditable() {
        return assemblyConstituencyCode.isEnabled();
    }

    public boolean isParliamentaryConstituencyCodeEditable() {
        return parliamentaryConstituencyCode.isEnabled();
    }

    public boolean isSchoolManagementCodeEditable() {
        return schoolManagementCode.isEnabled();
    }

    public boolean isManagementCode101Editable() {
        return managementCode101.isEnabled();
    }

    public boolean isSchoolCategoryCodeEditable() {
        return schoolCategoryCode.isEnabled();
    }

    public boolean isLowestClassEditable() {
        return lowestClass.isEnabled();
    }

    public boolean isHighestClassEditable() {
        return highestClass.isEnabled();
    }

    public boolean isPrePrimaryAttachedEditable() {
        return prePrimaryAttached.isEnabled();
    }

    public boolean isNumClassesPrePrimaryEditable() {
        return numClassesPrePrimary.isEnabled();
    }

    public boolean isTypeOfSchoolEditable() {
        return typeOfSchool.isEnabled();
    }

    public boolean isSchoolStatusEditable() {
        return schoolStatus.isEnabled();
    }

    public boolean isSessionStartDateEditable() {
        return sessionStartDate.isEnabled();
    }

    public boolean isSessionEndDateEditable() {
        return sessionEndDate.isEnabled();
    }

    public boolean isStreamArtsEditable() {
        return streamArts.isEnabled();
    }

    public boolean isStreamVocationalEditable() {
        return streamVocational.isEnabled();
    }

    public boolean isStreamScienceEditable() {
        return streamScience.isEnabled();
    }

    public boolean isStreamCommerceEditable() {
        return streamCommerce.isEnabled();
    }

    public boolean isStreamOthersEditable() {
        return streamOthers.isEnabled();
    }


    @FindBy(xpath = "//input[@id='yourSearchInputId']")
    WebElement searchInput;
    @FindBy(xpath = "//button[@id='yourSearchButtonId']")
    WebElement searchButton;

    public void searchBySchoolNameOrCode(String searchQuery) {
        if (searchInput == null || searchButton == null) {
            throw new NoSuchElementException("Search input or button WebElements are not initialized. Please check @FindBy locators.");
        }
        searchInput.clear();
        searchInput.sendKeys(searchQuery);
        searchButton.click();
    }


    /**
     * Method to verify if the searched record is found in the grid.
     *
     * @param schoolCode the school code to search for
     * @param schoolName the school name to search for
     * @return true if the record is found, otherwise false
     */
    public boolean isSearchedRecordFoundInGrid(String schoolCode, String schoolName) {
        // XPath to locate rows in the grid
        List<WebElement> rows = chromeDriver.findElements(By.xpath("//table[@id='yourGridTableId']/tbody/tr"));

        for (WebElement row : rows) {
            // Extracting the School Code and School Name from the respective columns
            WebElement schoolCodeColumn = row.findElement(By.xpath("./td[2]")); // Second column
            WebElement schoolNameColumn = row.findElement(By.xpath("./td[3]")); // Third column

            // Check if both School Code and School Name match
            if (schoolCodeColumn.getText().trim().equalsIgnoreCase(schoolCode.trim()) &&
                    schoolNameColumn.getText().trim().equalsIgnoreCase(schoolName.trim())) {
                return true; // Record found
            }
        }
        return false; // Record not found
    }


    // Class for the side menu functionality

    
    
}