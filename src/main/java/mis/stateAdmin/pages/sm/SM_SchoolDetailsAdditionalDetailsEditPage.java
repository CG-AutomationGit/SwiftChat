package mis.stateAdmin.pages.sm;

import mis.base.MIS_Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import java.lang.reflect.InvocationTargetException;

public class SM_SchoolDetailsAdditionalDetailsEditPage extends MIS_Base {
    public SM_SchoolDetailsAdditionalDetailsEditPage(ChromeDriver chromeDriver) {
        super(chromeDriver);
    }

    @FindBy(xpath = "//label[contains(text(), '42). Affiliation Board for Secondary Sections')]/following-sibling::nz-select")
    WebElement affiliationBoardSecondary;

    @FindBy(xpath = "//label[contains(text(), '43). Affiliation Number for Secondary Sections')]/following-sibling::nz-input-group//input")
    WebElement affiliationNumberSecondary;

    @FindBy(xpath = "//label[contains(text(), '44). If affiliation_board_sec')]/following-sibling::nz-input-group//input")
    WebElement boardNameSecondary;

    @FindBy(xpath = "//label[contains(text(), '45). Affiliation Board for Higher Secondary Sections')]/following-sibling::nz-select")
    WebElement affiliationBoardHigherSecondary;

    @FindBy(xpath = "//label[contains(text(), '46). Affiliation Number for Higher Secondary Sections')]/following-sibling::nz-input-group//input")
    WebElement affiliationNumberHigherSecondary;

    @FindBy(xpath = "//label[contains(text(), '47). If affiliation_board_hsec')]/following-sibling::nz-input-group//input")
    WebElement boardNameHigherSecondary;

    @FindBy(xpath = "//label[contains(text(), '48). Year of Establishment of school')]/following-sibling::nz-input-group//input")
    WebElement yearEstablishment;

    @FindBy(xpath = "//label[contains(text(), '49). Year of recognition of primary')]/following-sibling::nz-input-group//input")
    WebElement recognitionPrimary;

    @FindBy(xpath = "//label[contains(text(), '50). Year of recognition of Upper primary')]/following-sibling::nz-input-group//input")
    WebElement recognitionUpperPrimary;

    @FindBy(xpath = "//label[contains(text(), '51). Year of recognition of secondry')]/following-sibling::nz-input-group//input")
    WebElement recognitionSecondary;

    @FindBy(xpath = "//label[contains(text(), '52). Year of recognition of high secondry')]/following-sibling::nz-input-group//input")
    WebElement recognitionHigherSecondary;

    @FindBy(xpath = "//label[contains(text(), '53). Year of upgradation of elementary')]/following-sibling::nz-input-group//input")
    WebElement upgradationToUpperPrimary;

    @FindBy(xpath = "//label[contains(text(), '54). Year of upgradation of secondary')]/following-sibling::nz-input-group//input")
    WebElement upgradationToSecondary;

    @FindBy(xpath = "//label[contains(text(), '55). Year of upgradation of higher secondary')]/following-sibling::nz-input-group//input")
    WebElement upgradationToHigherSecondary;

    @FindBy(xpath = "//label[contains(text(), '56). Medium of instruction in the school -1')]/following-sibling::nz-select")
    WebElement mediumInstruction1;

    @FindBy(xpath = "//label[contains(text(), '57). Medium of instruction in the school -2')]/following-sibling::nz-select")
    WebElement mediumInstruction2;

    @FindBy(xpath = "//label[contains(text(), '58). Medium of instruction in the school -3')]/following-sibling::nz-select")
    WebElement mediumInstruction3;

    @FindBy(xpath = "//label[contains(text(), '59). Medium of instruction in the school -4')]/following-sibling::nz-select")
    WebElement mediumInstruction4;

    public boolean areAllAdditionalDetailFieldsDisplayed() {
        return affiliationBoardSecondary.isDisplayed()
                && affiliationNumberSecondary.isDisplayed()
                && boardNameSecondary.isDisplayed()
                && affiliationBoardHigherSecondary.isDisplayed()
                && affiliationNumberHigherSecondary.isDisplayed()
                && boardNameHigherSecondary.isDisplayed()
                && yearEstablishment.isDisplayed()
                && recognitionPrimary.isDisplayed()
                && recognitionUpperPrimary.isDisplayed()
                && recognitionSecondary.isDisplayed()
                && recognitionHigherSecondary.isDisplayed()
                && upgradationToUpperPrimary.isDisplayed()
                && upgradationToSecondary.isDisplayed()
                && upgradationToHigherSecondary.isDisplayed()
                && mediumInstruction1.isDisplayed()
                && mediumInstruction2.isDisplayed()
                && mediumInstruction3.isDisplayed()
                && mediumInstruction4.isDisplayed();
    }

    public boolean areAllAdditionalDetailFieldsEnabled() {
        return affiliationBoardSecondary.isEnabled()
                && affiliationNumberSecondary.isEnabled()
                && boardNameSecondary.isEnabled()
                && affiliationBoardHigherSecondary.isEnabled()
                && affiliationNumberHigherSecondary.isEnabled()
                && boardNameHigherSecondary.isEnabled()
                && yearEstablishment.isEnabled()
                && recognitionPrimary.isEnabled()
                && recognitionUpperPrimary.isEnabled()
                && recognitionSecondary.isEnabled()
                && recognitionHigherSecondary.isEnabled()
                && upgradationToUpperPrimary.isEnabled()
                && upgradationToSecondary.isEnabled()
                && upgradationToHigherSecondary.isEnabled()
                && mediumInstruction1.isEnabled()
                && mediumInstruction2.isEnabled()
                && mediumInstruction3.isEnabled()
                && mediumInstruction4.isEnabled();
    }

    public boolean isAffiliationBoardSecondaryDisplayed() {
        return affiliationBoardSecondary.isDisplayed();
    }

    public boolean isAffiliationBoardSecondaryEnabled() {
        return affiliationBoardSecondary.isEnabled();
    }

    public void setAffiliationBoardSecondary(String value) {
        affiliationBoardSecondary.click();
        chromeDriver.findElement(By.xpath("//nz-option-item//div[contains(text(),'" + value + "')]")).click();
    }


    public boolean isAffiliationNumberSecondaryDisplayed() {
        return affiliationNumberSecondary.isDisplayed();
    }

    public boolean isAffiliationNumberSecondaryEnabled() {
        return affiliationNumberSecondary.isEnabled();
    }

    public void setAffiliationNumberSecondary(String value) {
        affiliationNumberSecondary.clear();
        affiliationNumberSecondary.sendKeys(value);
    }

    public boolean isBoardNameSecondaryDisplayed() {
        return boardNameSecondary.isDisplayed();
    }

    public boolean isBoardNameSecondaryEnabled() {
        return boardNameSecondary.isEnabled();
    }

    public void setBoardNameSecondary(String value) {
        boardNameSecondary.clear();
        boardNameSecondary.sendKeys(value);
    }


    public boolean isAffiliationBoardHigherSecondaryDisplayed() {
        return affiliationBoardHigherSecondary.isDisplayed();
    }

    public boolean isAffiliationBoardHigherSecondaryEnabled() {
        return affiliationBoardHigherSecondary.isEnabled();
    }

    public void setAffiliationBoardHigherSecondary(String value) {
        affiliationBoardHigherSecondary.click();
        chromeDriver.findElement(By.xpath("//nz-option-item//div[contains(text(),'" + value + "')]")).click();
    }


    public boolean isAffiliationNumberHigherSecondaryDisplayed() {
        return affiliationNumberHigherSecondary.isDisplayed();
    }

    public boolean isAffiliationNumberHigherSecondaryEnabled() {
        return affiliationNumberHigherSecondary.isEnabled();
    }

    public void setAffiliationNumberHigherSecondary(String value) {
        affiliationNumberHigherSecondary.clear();
        affiliationNumberHigherSecondary.sendKeys(value);
    }


    public boolean isBoardNameHigherSecondaryDisplayed() {
        return boardNameHigherSecondary.isDisplayed();
    }

    public boolean isBoardNameHigherSecondaryEnabled() {
        return boardNameHigherSecondary.isEnabled();
    }

    public void setBoardNameHigherSecondary(String value) {
        boardNameHigherSecondary.clear();
        boardNameHigherSecondary.sendKeys(value);
    }


    public boolean isYearEstablishmentDisplayed() {
        return yearEstablishment.isDisplayed();
    }

    public boolean isYearEstablishmentEnabled() {
        return yearEstablishment.isEnabled();
    }

    public void setYearEstablishment(String value) {
        yearEstablishment.clear();
        yearEstablishment.sendKeys(value);
    }


    public boolean isRecognitionPrimaryDisplayed() {
        return recognitionPrimary.isDisplayed();
    }

    public boolean isRecognitionPrimaryEnabled() {
        return recognitionPrimary.isEnabled();
    }

    public void setRecognitionPrimary(String value) {
        recognitionPrimary.clear();
        recognitionPrimary.sendKeys(value);
    }


    public boolean isRecognitionUpperPrimaryDisplayed() {
        return recognitionUpperPrimary.isDisplayed();
    }

    public boolean isRecognitionUpperPrimaryEnabled() {
        return recognitionUpperPrimary.isEnabled();
    }

    public void setRecognitionUpperPrimary(String value) {
        recognitionUpperPrimary.clear();
        recognitionUpperPrimary.sendKeys(value);
    }


    public boolean isRecognitionSecondaryDisplayed() {
        return recognitionSecondary.isDisplayed();
    }

    public boolean isRecognitionSecondaryEnabled() {
        return recognitionSecondary.isEnabled();
    }

    public void setRecognitionSecondary(String value) {
        recognitionSecondary.clear();
        recognitionSecondary.sendKeys(value);
    }


    public boolean isRecognitionHigherSecondaryDisplayed() {
        return recognitionHigherSecondary.isDisplayed();
    }

    public boolean isRecognitionHigherSecondaryEnabled() {
        return recognitionHigherSecondary.isEnabled();
    }

    public void setRecognitionHigherSecondary(String value) {
        recognitionHigherSecondary.clear();
        recognitionHigherSecondary.sendKeys(value);
    }


    public boolean isUpgradationToUpperPrimaryDisplayed() {
        return upgradationToUpperPrimary.isDisplayed();
    }

    public boolean isUpgradationToUpperPrimaryEnabled() {
        return upgradationToUpperPrimary.isEnabled();
    }

    public void setUpgradationToUpperPrimary(String value) {
        upgradationToUpperPrimary.clear();
        upgradationToUpperPrimary.sendKeys(value);
    }


    public boolean isUpgradationToSecondaryDisplayed() {
        return upgradationToSecondary.isDisplayed();
    }

    public boolean isUpgradationToSecondaryEnabled() {
        return upgradationToSecondary.isEnabled();
    }

    public void setUpgradationToSecondary(String value) {
        upgradationToSecondary.clear();
        upgradationToSecondary.sendKeys(value);
    }


    public boolean isUpgradationToHigherSecondaryDisplayed() {
        return upgradationToHigherSecondary.isDisplayed();
    }

    public boolean isUpgradationToHigherSecondaryEnabled() {
        return upgradationToHigherSecondary.isEnabled();
    }

    public void setUpgradationToHigherSecondary(String value) {
        upgradationToHigherSecondary.clear();
        upgradationToHigherSecondary.sendKeys(value);
    }


    public boolean isMediumInstruction1Displayed() {
        return mediumInstruction1.isDisplayed();
    }

    public boolean isMediumInstruction1Enabled() {
        return mediumInstruction1.isEnabled();
    }

    public void setMediumInstruction1(String value) {
        mediumInstruction1.click();
        chromeDriver.findElement(By.xpath("//nz-option-item//div[contains(text(),'" + value + "')]")).click();
    }

    @FindBy(xpath = "//button[@class='edit-button']")
    WebElement editButton;

    @FindBy(xpath = "//button[@class='cancel-button']")
    WebElement cancelButton;

    public boolean areEditAndCancelButtonsDisplayed() {
        return editButton != null && cancelButton != null && editButton.isDisplayed() && cancelButton.isDisplayed();
    }


    public boolean areEditAndCancelButtonsEnabled() {
        return editButton != null && cancelButton != null && editButton.isEnabled() && cancelButton.isEnabled();
    }


    public void clickEditButton() {
        if (editButton != null && editButton.isEnabled()) {
            editButton.click();
        }
    }
    
    public SM_SchoolProfileGrid clickCancelButton() throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        if (cancelButton != null && cancelButton.isEnabled()) {
            cancelButton.click();
        }
        return createMISPageForChrome(SM_SchoolProfileGrid.class);
    }

}
