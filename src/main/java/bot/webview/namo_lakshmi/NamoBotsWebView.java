package bot.webview.namo_lakshmi;

import bot.base.BotBase;
import bot.webview.WebViewBase;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

public class NamoBotsWebView extends WebViewBase {


/*    @FindBy(xpath = "//div[@data-toggle='buttons']/span[1][text()='Update Student Details']/ancestor::div[contains(@class,'container')]/" +
            "following-sibling::form//div[contains(@class,'row')]//label[text()='Student Name']/following-sibling::select")
    WebElement studentNameField;


    @FindBy(xpath = "//select[@name='name']/preceding-sibling::label[@for='name']/ancestor::form/" +
            "preceding-sibling::div//span[text()='Update Student Details']")
    WebElement studentUIDAsPerCTSField;*/

    @FindBy(name = "name")
    WebElement nameField;

    @FindBy(id = "id")
    WebElement studentCTSIDField;

    @FindBy(id="grade")
    WebElement studentGradeField;

    @FindBy(id="section")
    WebElement studentSectionField;

    @FindBy(name = "student_providing_details")
    WebElement studentProvidingDetailsField;

    WebElement searchStudentIDField , searchButton;
    WebElement student_providing_details , want_scholarship , guardian_mobile_no ,aadhar_card_name , aadhar_no,
    aadhar_card_url_front,aadhar_card_url_back , mother_name,is_mother_details_available,mother_name_as_per_aadhar,
            mother_aadhar_no,mother_aadhar_card_url_front , mother_aadhar_card_url_back ,mother_reason, lcr_birth_certificate,
            mother_account_bank_ifsc_code,mother_account_bank_name,mother_account_branch_name ,mother_bank_account_no,mother_name_in_bank,mother_cc_passport_url,
            family_annual_income , income_certificate_url , flexCheckDefault , reset , submit,is_student_account_available , verify;



    public NamoBotsWebView(ChromeDriver chromeDriver) {
        super(chromeDriver);
        PageFactory.initElements(chromeDriver, this);
    }


    public void validateAllDefaultFieldsAreAvilalable(String tabName) {
        clickOnTab(tabName);
        if(tabName.equals("Update Student Details")) {
            SoftAssert softAssert = new SoftAssert();
            softAssert.assertTrue(nameField.isDisplayed(),
                    "Student Name field is not displayed");
            softAssert.assertTrue(studentCTSIDField.isDisplayed(),
                    "Student CTS ID field is not displayed");
            softAssert.assertTrue(studentGradeField.isDisplayed(),
                    "Student Grade field is not displayed");
            softAssert.assertTrue(studentSectionField.isDisplayed(),
                     "Student Section field is not displayed");
            softAssert.assertAll();
        }
        else if(tabName.equals("Search Student")){
            searchStudentIDField = chromeDriver.findElement(By.id("searchStudentId"));
            searchButton = chromeDriver.findElement(By.xpath("//button[text()='Search Student']"));

            SoftAssert softAssert = new SoftAssert();
            softAssert.assertTrue(searchStudentIDField.isDisplayed(),
                    "Search Student ID field is not displayed");
            softAssert.assertTrue(searchButton.isDisplayed(),
                    "Search Button is not displayed");
            softAssert.assertAll();

        }
        else {
            throw new IllegalArgumentException("Tab name not recognized: " + tabName);
        }


    }

    public void validateAllDefaultFieldsAreEditable(String tabName) {
        clickOnTab(tabName);
        if(tabName.equals("Update Student Details")) {
            SoftAssert softAssert = new SoftAssert();
            softAssert.assertTrue(nameField.isEnabled(),
                    "Student Name field is not enabled");
            softAssert.assertTrue(studentCTSIDField.isEnabled(),
                    "Student CTS ID field is not enabled");
            softAssert.assertTrue(studentGradeField.isEnabled(),
                    "Student Grade field is not enabled");
            softAssert.assertTrue(studentSectionField.isEnabled(),
                    "Student Section field is not enabled");
            softAssert.assertAll();
        }
        else if(tabName.equals("Search Student")){
            searchStudentIDField = chromeDriver.findElement(By.id("searchStudentId"));
            searchButton = chromeDriver.findElement(By.xpath("//button[text()='Search Student']"));

            SoftAssert softAssert = new SoftAssert();
            softAssert.assertTrue(searchStudentIDField.isEnabled(),
                    "Search Student ID field is not enabled");
            softAssert.assertFalse(searchButton.isEnabled(),
                    "Search Button is enabled");

            searchStudentIDField.sendKeys("199999999999999999");
            //searchButton.click(); // Temporary Solution to enable the button   : Defect Logged #789789

          /*  softAssert.assertTrue(searchButton.isEnabled(),
                    "Search Button is not enabled");*/

            softAssert.assertAll();

        }
        else {
            clickOnTab("Update Student Details");
            Assert.fail("Tab name not available: " + tabName);
        }
       clickOnTab("Update Student Details");
    }

    public void selectRandomStudentValue() throws InterruptedException {
        Thread.sleep(3000); // Wait for the page to load and elements to be available

        Select select = new Select(nameField);

        if(select.getOptions().isEmpty()){
            Assert.fail("Students are not available for selected grade/section.");
        }
        else {
            double randomValue = Math.random();
            System.out.println("Random Value: " + randomValue);
            System.out.println("Total Student : " + select.getOptions().size());
            System.out.println("Random Value with Multiply: " + randomValue* select.getOptions().size());
            System.out.println("Random Value with Multiply with Int casting: " + (int) (randomValue* select.getOptions().size()));


            int randomIndex = (int) (randomValue * select.getOptions().size());
            Thread.sleep(2000);
            select.selectByIndex(randomIndex);
            String selectedOption = select.getFirstSelectedOption().getText();
            System.out.println("Selected Student Name: " + selectedOption);
        }
    }


    /*public void validateAllFieldsAreDisplayedAfterSelectingStudent() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(nameField.isDisplayed(),
                "Student Name field is not displayed after selecting student");
        softAssert.assertTrue(studentCTSIDField.isDisplayed(),
                "Student CTS ID field is not displayed after selecting student");
        softAssert.assertTrue(studentGradeField.isDisplayed(),
                "Student Grade field is not displayed after selecting student");
        softAssert.assertTrue(studentSectionField.isDisplayed(),
                "Student Section field is not displayed after selecting student");
        softAssert.assertAll();
    }*/

    public void getLocators(){
        student_providing_details = chromeDriver.findElement(By.name("student_providing_details"));
        want_scholarship = chromeDriver.findElement(By.name("want_scholarship"));
        guardian_mobile_no = chromeDriver.findElement(By.name("guardian_mobile_no"));
        aadhar_card_name = chromeDriver.findElement(By.name("aadhar_card_name"));
        aadhar_no = chromeDriver.findElement(By.name("aadhar_no"));
        aadhar_card_url_front = chromeDriver.findElement(By.name("aadhar_card_url_front"));
        aadhar_card_url_back = chromeDriver.findElement(By.name("aadhar_card_url_back"));
        mother_name = chromeDriver.findElement(By.name("mother_name"));
        is_mother_details_available = chromeDriver.findElement(By.name("is_mother_details_available"));
        mother_name_as_per_aadhar = chromeDriver.findElement(By.name("mother_name_as_per_aadhar"));
        mother_aadhar_no = chromeDriver.findElement(By.name("mother_aadhar_no"));
        mother_aadhar_card_url_front = chromeDriver.findElement(By.name("mother_aadhar_card_url_front"));
        mother_aadhar_card_url_back = chromeDriver.findElement(By.name("mother_aadhar_card_url_back"));
        lcr_birth_certificate = chromeDriver.findElement(By.name("lcr_birth_certificate"));
        mother_account_bank_ifsc_code = chromeDriver.findElement(By.name("mother_account_bank_ifsc_code"));
        mother_account_bank_name = chromeDriver.findElement(By.name("mother_account_bank_name"));
        mother_account_branch_name = chromeDriver.findElement(By.name("mother_account_branch_name"));
        mother_bank_account_no = chromeDriver.findElement(By.name("mother_bank_account_no"));
        mother_name_in_bank = chromeDriver.findElement(By.name("mother_name_in_bank"));
        mother_cc_passport_url = chromeDriver.findElement(By.name("mother_cc_passport_url"));
        family_annual_income = chromeDriver.findElement(By.name("family_annual_income"));
        income_certificate_url = chromeDriver.findElement(By.name("income_certificate_url"));
        flexCheckDefault = chromeDriver.findElement(By.id("flexCheckDefault"));
        reset = chromeDriver.findElement(By.xpath("//button[text()='Reset']"));
        submit = chromeDriver.findElement(By.xpath("//button[text()='Save']"));
    }

    public void validateAllFieldsAreDisplayed(){
        getLocators();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(student_providing_details.isDisplayed(),
                "Student Providing Details field is not displayed");
        softAssert.assertTrue(want_scholarship.isDisplayed(),
                "Want Scholarship field is not displayed");
        softAssert.assertTrue(guardian_mobile_no.isDisplayed(),
                "Guardian Mobile No field is not displayed");
        softAssert.assertTrue(aadhar_card_name.isDisplayed(),
                "Aadhar Card Name field is not displayed");
        softAssert.assertTrue(aadhar_no.isDisplayed(),
                "Aadhar No field is not displayed");
        softAssert.assertTrue(aadhar_card_url_front.isDisplayed(),
                "Aadhar Card URL Front field is not displayed");
        softAssert.assertTrue(aadhar_card_url_back.isDisplayed(),
                "Aadhar Card URL Back field is not displayed");
        softAssert.assertTrue(mother_name.isDisplayed(),
                "Mother Name field is not displayed");
        softAssert.assertTrue(is_mother_details_available.isDisplayed(),
                "Is Mother Details Available field is not displayed");
        softAssert.assertTrue(mother_name_as_per_aadhar.isDisplayed(),
                "Mother Name As Per Aadhar field is not displayed");
        softAssert.assertTrue(mother_aadhar_no.isDisplayed(),
                "Mother Aadhar No field is not displayed");
        softAssert.assertTrue(mother_aadhar_card_url_front.isDisplayed(),
                "Mother Aadhar Card URL Front field is not displayed");
        softAssert.assertTrue(mother_aadhar_card_url_back.isDisplayed(),
                "Mother Aadhar Card URL Back field is not displayed");
        softAssert.assertTrue(lcr_birth_certificate.isDisplayed(),
                "LCR Birth Certificate field is not displayed");
        softAssert.assertTrue(mother_account_bank_ifsc_code.isDisplayed(),
                "Mother Account Bank IFSC Code field is not displayed");
        softAssert.assertTrue(mother_account_bank_name.isDisplayed(),
                "Mother Account Bank Name field is not displayed");
        softAssert.assertTrue(mother_account_branch_name.isDisplayed(),
                "Mother Account Branch Name field is not displayed");
        softAssert.assertTrue(mother_bank_account_no.isDisplayed(),
                "Mother Bank Account No field is not displayed");

        softAssert.assertTrue(mother_name_in_bank.isDisplayed(),
                "Mother Name In Bank field is not displayed");
        softAssert.assertTrue(mother_cc_passport_url.isDisplayed(),
                "Mother CC Passbook URL field is not displayed");
        softAssert.assertTrue(family_annual_income.isDisplayed(),
                "Family Annual Income field is not displayed");
        softAssert.assertTrue(income_certificate_url.isDisplayed(),
                "Income Certificate URL field is not displayed");
        softAssert.assertTrue(flexCheckDefault.isDisplayed(),
                "Flex Check Default field is not displayed");
        softAssert.assertTrue(reset.isDisplayed(),
                "Reset button is not displayed");
        softAssert.assertTrue(submit.isDisplayed(),
                "Submit button is not displayed");

        softAssert.assertAll();

    }

    public void validateAllFieldsAreEditable(){
        getLocators();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(student_providing_details.isEnabled(),
                "Student Providing Details field is not enabled");
        softAssert.assertTrue(want_scholarship.isEnabled(),
                "Want Scholarship field is not enabled");
        softAssert.assertTrue(guardian_mobile_no.isEnabled(),
                "Guardian Mobile No field is not enabled");
        softAssert.assertTrue(aadhar_card_name.isEnabled(),
                "Aadhar Card Name field is not enabled");
        softAssert.assertTrue(aadhar_no.isEnabled(),
                "Aadhar No field is not enabled");
        softAssert.assertTrue(aadhar_card_url_front.isEnabled(),
                "Aadhar Card URL Front field is not enabled");
        softAssert.assertTrue(aadhar_card_url_back.isEnabled(),
                "Aadhar Card URL Back field is not enabled");
        softAssert.assertFalse(mother_name.isEnabled(),
                "Mother Name field is enabled");
        softAssert.assertTrue(is_mother_details_available.isEnabled(),
                "Is Mother Details Available field is not enabled");
        softAssert.assertTrue(mother_name_as_per_aadhar.isEnabled(),
                "Mother Name As Per Aadhar field is not enabled");
        softAssert.assertTrue(mother_aadhar_no.isEnabled(),
                "Mother Aadhar No field is not enabled");
        softAssert.assertTrue(mother_aadhar_card_url_front.isEnabled(),
                "Mother Aadhar Card URL Front field is not enabled");
        softAssert.assertTrue(mother_aadhar_card_url_back.isEnabled(),
                "Mother Aadhar Card URL Back field is not enabled");
        softAssert.assertTrue(lcr_birth_certificate.isEnabled(),
                "LCR Birth Certificate field is not enabled");
        softAssert.assertTrue(mother_account_bank_ifsc_code.isEnabled(),
                "Mother Account Bank IFSC Code field is not enabled");
        softAssert.assertFalse(mother_account_bank_name.isEnabled(),
                "Mother Bank Name field is enabled");
        softAssert.assertFalse(mother_account_branch_name.isEnabled(),
                "Mother Account Branch Name field is enabled");
        softAssert.assertTrue(mother_bank_account_no.isEnabled(),
                "Mother Bank Account No field is not enabled");

        softAssert.assertTrue(mother_name_in_bank.isEnabled(),
                "Mother Name In Bank field is not enabled");
        softAssert.assertTrue(mother_cc_passport_url.isEnabled(),
                "Mother CC Passbook URL field is not enabled");
        softAssert.assertTrue(family_annual_income.isEnabled(),
                "Family Annual Income field is not enabled");
        softAssert.assertTrue(income_certificate_url.isEnabled(),
                "Income Certificate URL field is not enabled");
        softAssert.assertTrue(flexCheckDefault.isEnabled(),
                "Flex Check Default field is not enabled");
        softAssert.assertTrue(reset.isEnabled(),
                "Reset button is not enabled");
        softAssert.assertTrue(submit.isEnabled(),
                "Submit button is not enabled");

        softAssert.assertTrue(isElementVisible(flexCheckDefault),
                "Flex Check Default field is not visible");
        softAssert.assertTrue(isElementVisible(reset),
                "Reset button is not visible");
        softAssert.assertTrue(isElementVisible(submit),
                "Submit button is not visible");
        softAssert.assertAll();
    }

    private boolean isElementVisible(WebElement locator) {
        try {
            return locator.isDisplayed();
        } catch (NoSuchElementException | StaleElementReferenceException e) {
            return false;
        }
    }

    public void validateHiddenFieldsBusinessRules() throws InterruptedException {
        // Assert that the mother's details fields are not visible initially
        getLocators();
        Select studentprovidingdetails = new Select(student_providing_details);
        System.out.println("Select Yes option");
        studentprovidingdetails.selectByVisibleText("Yes");
        System.out.println("Selected Yes option");

        SoftAssert softAssert = new SoftAssert();

        System.out.println("Validating fields visibility after selecting 'Yes' for Student Providing Details");
        softAssert.assertTrue(isElementVisible(want_scholarship),
                "Want Scholarship field should be visible when 'Yes' is selected.");

        softAssert.assertTrue(isElementVisible(guardian_mobile_no),
                "Guardian Mobile No field should be visible when 'Yes' is selected.");
        softAssert.assertTrue(isElementVisible(aadhar_card_name),
                "Aadhar Card Name field should be visible when 'Yes' is selected.");
        softAssert.assertTrue(isElementVisible(aadhar_no),
                "Aadhar No field should be visible when 'Yes' is selected.");
        softAssert.assertTrue(isElementVisible(aadhar_card_url_front),
                "Aadhar Card URL Front field should be visible when 'Yes' is selected.");
        softAssert.assertTrue(isElementVisible(aadhar_card_url_back),
                "Aadhar Card URL Back field should be visible when 'Yes' is selected.");
        softAssert.assertTrue(isElementVisible(mother_name),
                "Mother Name field should be visible when 'Yes' is selected.");
        softAssert.assertTrue(isElementVisible(is_mother_details_available),
                "Is Mother Details Available field should be visible when 'Yes' is selected.");
        softAssert.assertTrue(isElementVisible(mother_name_as_per_aadhar),
                "Mother Name As Per Aadhar field should be visible when 'Yes' is selected.");
        softAssert.assertTrue(isElementVisible(mother_aadhar_no),
                "Mother Aadhar No field should be visible when 'Yes' is selected.");
        softAssert.assertTrue(isElementVisible(mother_aadhar_card_url_front),
                "Mother Aadhar Card URL Front field should be visible when 'Yes' is selected.");
        softAssert.assertTrue(isElementVisible(mother_aadhar_card_url_back),
                "Mother Aadhar Card URL Back field should be visible when 'Yes' is selected.");
        softAssert.assertTrue(isElementVisible(lcr_birth_certificate),
                "LCR Birth Certificate field should be visible when 'Yes' is selected.");
        softAssert.assertTrue(isElementVisible(mother_account_bank_ifsc_code),
                "Mother Account Bank IFSC Code field should be visible when 'Yes' is selected.");
        softAssert.assertTrue(isElementVisible(mother_account_bank_name),
                "Mother Bank Name field should be visible when 'Yes' is selected.");
        softAssert.assertTrue(isElementVisible(mother_account_branch_name),
                "Mother Account Branch Name field should be visible when 'Yes' is selected.");
        softAssert.assertTrue(isElementVisible(mother_bank_account_no),
                "Mother Bank Account No field should be visible when 'Yes' is selected.");
        softAssert.assertTrue(isElementVisible(mother_name_in_bank),
                "Mother Name In Bank field should be visible when 'Yes' is selected.");
        softAssert.assertTrue(isElementVisible(mother_cc_passport_url),
                "Mother CC Passbook URL field should be visible when 'Yes' is selected.");
        softAssert.assertTrue(isElementVisible(family_annual_income),
                "Family Annual Income field should be visible when 'Yes' is selected.");
        softAssert.assertTrue(isElementVisible(income_certificate_url),
                "Income Certificate URL field should be visible when 'Yes' is selected.");

        softAssert.assertAll();
        System.out.println("Validation passed for all mentioned fields visibility after selecting 'No' for Student Providing Details");

        studentprovidingdetails.selectByVisibleText("No");
        Thread.sleep(2000); // Wait for the dropdown to update
        // Click the "No" option from dropdown or toggle (depends on your real DOM)

        SoftAssert softAssert1 = new SoftAssert();

        softAssert1.assertFalse(isElementVisible(want_scholarship),
                "Want Scholarship field should not be visible when 'Yes' is selected.");
        softAssert1.assertFalse(isElementVisible(guardian_mobile_no),
                "Guardian Mobile No field should not be visible when 'Yes' is selected.");
        softAssert1.assertFalse(isElementVisible(aadhar_card_name),
                "Aadhar Card Name field should not be visible when 'Yes' is selected.");
        softAssert1.assertFalse(isElementVisible(aadhar_no),
                "Aadhar No field should not be visible when 'Yes' is selected.");
        softAssert1.assertFalse(isElementVisible(aadhar_card_url_front),
                "Aadhar Card URL Front field should not be visible when 'Yes' is selected.");
        softAssert1.assertFalse(isElementVisible(aadhar_card_url_back),
                "Aadhar Card URL Back field should not be visible when 'Yes' is selected.");
        softAssert1.assertFalse(isElementVisible(mother_name),
                "Mother Name field should not be visible when 'Yes' is selected.");
        softAssert1.assertFalse(isElementVisible(is_mother_details_available),
                "Is Mother Details Available field should not be visible when 'Yes' is selected.");
        softAssert1.assertFalse(isElementVisible(mother_name_as_per_aadhar),
                "Mother Name As Per Aadhar field should not be visible when 'Yes' is selected.");
        softAssert1.assertFalse(isElementVisible(mother_aadhar_no),
                "Mother Aadhar No field should not be visible when 'Yes' is selected.");
        softAssert1.assertFalse(isElementVisible(mother_aadhar_card_url_front),
                "Mother Aadhar Card URL Front field should not be visible when 'Yes' is selected.");
        softAssert1.assertFalse(isElementVisible(mother_aadhar_card_url_back),
                "Mother Aadhar Card URL Back field should not be visible when 'Yes' is selected.");
        softAssert1.assertFalse(isElementVisible(lcr_birth_certificate),
                "LCR Birth Certificate field should not be visible when 'Yes' is selected.");
        softAssert1.assertFalse(isElementVisible(mother_account_bank_ifsc_code),
                "Mother Account Bank IFSC Code field should not be visible when 'Yes' is selected.");
        softAssert1.assertFalse(isElementVisible(mother_account_bank_name),
                "Mother Bank Name field should not be visible when 'Yes' is selected.");
        softAssert1.assertFalse(isElementVisible(mother_account_branch_name),
                "Mother Account Branch Name field should not be visible when 'Yes' is selected.");
        softAssert1.assertFalse(isElementVisible(mother_bank_account_no),
                "Mother Bank Account No field should not be visible when 'Yes' is selected.");
        softAssert1.assertFalse(isElementVisible(mother_name_in_bank),
                "Mother Name In Bank field should not be visible when 'Yes' is selected.");
        softAssert1.assertFalse(isElementVisible(mother_cc_passport_url),
                "Mother CC Passbook URL field should not be visible when 'Yes' is selected.");
        softAssert1.assertFalse(isElementVisible(family_annual_income),
                "Family Annual Income field should not be visible when 'Yes' is selected.");
        softAssert1.assertFalse(isElementVisible(income_certificate_url),
                "Income Certificate URL field should not be visible when 'Yes' is selected.");

        softAssert1.assertAll();

        studentprovidingdetails.selectByVisibleText("Yes");
        Thread.sleep(2000); // Wait for the dropdown to update

        want_scholarship = chromeDriver.findElement(By.name("want_scholarship"));

        Select wantScholarshipSelect = new Select(want_scholarship);
        wantScholarshipSelect.selectByVisibleText("No");
        Thread.sleep(2000); // Wait for the dropdown to update

        SoftAssert softAssert2 = new SoftAssert();
        softAssert2.assertFalse(isElementVisible(guardian_mobile_no),
                "Guardian Mobile No field should not be visible when 'Yes' is selected.");
        softAssert2.assertFalse(isElementVisible(aadhar_card_name),
                "Aadhar Card Name field should not be visible when 'Yes' is selected.");
        softAssert2.assertFalse(isElementVisible(aadhar_no),
                "Aadhar No field should not be visible when 'Yes' is selected.");
        softAssert2.assertFalse(isElementVisible(aadhar_card_url_front),
                "Aadhar Card URL Front field should not be visible when 'Yes' is selected.");
        softAssert2.assertFalse(isElementVisible(aadhar_card_url_back),
                "Aadhar Card URL Back field should not be visible when 'Yes' is selected.");
        softAssert2.assertFalse(isElementVisible(mother_name),
                "Mother Name field should not be visible when 'Yes' is selected.");
        softAssert2.assertFalse(isElementVisible(is_mother_details_available),
                "Is Mother Details Available field should not be visible when 'Yes' is selected.");
        softAssert2.assertFalse(isElementVisible(mother_name_as_per_aadhar),
                "Mother Name As Per Aadhar field should not be visible when 'Yes' is selected.");
        softAssert2.assertFalse(isElementVisible(mother_aadhar_no),
                "Mother Aadhar No field should not be visible when 'Yes' is selected.");
        softAssert2.assertFalse(isElementVisible(mother_aadhar_card_url_front),
                "Mother Aadhar Card URL Front field should not be visible when 'Yes' is selected.");
        softAssert2.assertFalse(isElementVisible(mother_aadhar_card_url_back),
                "Mother Aadhar Card URL Back field should not be visible when 'Yes' is selected.");
        softAssert2.assertFalse(isElementVisible(lcr_birth_certificate),
                "LCR Birth Certificate field should not be visible when 'Yes' is selected.");
        softAssert2.assertFalse(isElementVisible(mother_account_bank_ifsc_code),
                "Mother Account Bank IFSC Code field should not be visible when 'Yes' is selected.");
        softAssert2.assertFalse(isElementVisible(mother_account_bank_name),
                "Mother Bank Name field should not be visible when 'Yes' is selected.");
        softAssert2.assertFalse(isElementVisible(mother_account_branch_name),
                "Mother Account Branch Name field should not be visible when 'Yes' is selected.");
        softAssert2.assertFalse(isElementVisible(mother_bank_account_no),
                "Mother Bank Account No field should not be visible when 'Yes' is selected.");
        softAssert2.assertFalse(isElementVisible(mother_name_in_bank),
                "Mother Name In Bank field should not be visible when 'Yes' is selected.");
        softAssert2.assertFalse(isElementVisible(mother_cc_passport_url),
                "Mother CC Passbook URL field should not be visible when 'Yes' is selected.");
        softAssert2.assertFalse(isElementVisible(family_annual_income),
                "Family Annual Income field should not be visible when 'Yes' is selected.");
        softAssert2.assertFalse(isElementVisible(income_certificate_url),
                "Income Certificate URL field should not be visible when 'Yes' is selected.");

        softAssert2.assertAll();

        wantScholarshipSelect.selectByVisibleText("Yes");
        Thread.sleep(2000); // Wait for the dropdown to update

        getLocators();

        SoftAssert softAssert3 = new SoftAssert();
        softAssert3.assertTrue(isElementVisible(guardian_mobile_no),
                "Guardian Mobile No field should be visible when 'Yes' is selected.");
        softAssert3.assertTrue(isElementVisible(aadhar_card_name),
                "Aadhar Card Name field should be visible when 'Yes' is selected.");
        softAssert3.assertTrue(isElementVisible(aadhar_no),
                "Aadhar No field should be visible when 'Yes' is selected.");
        softAssert3.assertTrue(isElementVisible(aadhar_card_url_front),
                "Aadhar Card URL Front field should be visible when 'Yes' is selected.");
        softAssert3.assertTrue(isElementVisible(aadhar_card_url_back),
                "Aadhar Card URL Back field should be visible when 'Yes' is selected.");
        softAssert3.assertTrue(isElementVisible(mother_name),
                "Mother Name field should be visible when 'Yes' is selected.");
        softAssert3.assertTrue(isElementVisible(is_mother_details_available),
                "Is Mother Details Available field should be visible when 'Yes' is selected.");
        softAssert3.assertTrue(isElementVisible(mother_name_as_per_aadhar),
                "Mother Name As Per Aadhar field should be visible when 'Yes' is selected.");
        softAssert3.assertTrue(isElementVisible(mother_aadhar_no),
                "Mother Aadhar No field should be visible when 'Yes' is selected.");
        softAssert3.assertTrue(isElementVisible(mother_aadhar_card_url_front),
                "Mother Aadhar Card URL Front field should be visible when 'Yes' is selected.");
        softAssert3.assertTrue(isElementVisible(mother_aadhar_card_url_back),
                "Mother Aadhar Card URL Back field should be visible when 'Yes' is selected.");
        softAssert3.assertTrue(isElementVisible(lcr_birth_certificate),
                "LCR Birth Certificate field should be visible when 'Yes' is selected.");
        softAssert3.assertTrue(isElementVisible(mother_account_bank_ifsc_code),
                "Mother Account Bank IFSC Code field should be visible when 'Yes' is selected.");
        softAssert3.assertTrue(isElementVisible(mother_account_bank_name),
                "Mother Bank Name field should be visible when 'Yes' is selected.");
        softAssert3.assertTrue(isElementVisible(mother_account_branch_name),
                "Mother Account Branch Name field should be visible when 'Yes' is selected.");
        softAssert3.assertTrue(isElementVisible(mother_bank_account_no),
                "Mother Bank Account No field should be visible when 'Yes' is selected.");
        softAssert3.assertTrue(isElementVisible(mother_name_in_bank),
                "Mother Name In Bank field should be visible when 'Yes' is selected.");
        softAssert3.assertTrue(isElementVisible(mother_cc_passport_url),
                "Mother CC Passbook URL field should be visible when 'Yes' is selected.");
        softAssert3.assertTrue(isElementVisible(family_annual_income),
                "Family Annual Income field should be visible when 'Yes' is selected.");
        softAssert3.assertTrue(isElementVisible(income_certificate_url),
                "Income Certificate URL field should be visible when 'Yes' is selected.");

        softAssert3.assertAll();

        // Select Yes option
        Select isMotherDetailsAvailableSelect = new Select(is_mother_details_available);
        isMotherDetailsAvailableSelect.selectByVisibleText("Yes");
        Thread.sleep(2000); // Wait for the dropdown to update

        SoftAssert motherDetailsSoftAssert = new SoftAssert();
        // Assert all fields are visible
        motherDetailsSoftAssert.assertTrue(mother_name_as_per_aadhar.isDisplayed(),
                "Mother's name as per Aadhaar Card field should be visible when 'Yes' is selected.");
        motherDetailsSoftAssert.assertTrue(mother_aadhar_no.isDisplayed(),
                "Mother's Aadhaar Card number field should be visible when 'Yes' is selected.");

        motherDetailsSoftAssert.assertTrue(mother_aadhar_card_url_front.isDisplayed(),
                "Mother's Aadhaar Card front side upload button should be visible when 'Yes' is selected.");
        motherDetailsSoftAssert.assertTrue(mother_aadhar_card_url_back.isDisplayed(),
                "Mother's Aadhaar Card back side upload button should be visible when 'Yes' is selected.");

        isMotherDetailsAvailableSelect.selectByVisibleText("No");
        Thread.sleep(2000); // Wait for the dropdown to update

        mother_reason = chromeDriver.findElement(By.name("reason"));


        motherDetailsSoftAssert.assertTrue(mother_reason.isDisplayed(),
                "Mother's reason field should be visible when 'No' is selected.");


        // Assert fields are not visible
        motherDetailsSoftAssert.assertFalse(isElementVisible(mother_name_as_per_aadhar),
                "Mother's Aadhaar Card number field should not be visible when 'No' is selected.");
        motherDetailsSoftAssert.assertFalse(isElementVisible(mother_aadhar_no),
                "Mother's Aadhaar Card number field should not be visible when 'No' is selected.");
        motherDetailsSoftAssert.assertFalse(isElementVisible(mother_aadhar_card_url_front),
                "Mother's Aadhaar Card front side upload button should not be visible when 'No' is selected.");
        motherDetailsSoftAssert.assertFalse(isElementVisible(mother_aadhar_card_url_back),
                "Mother's Aadhaar Card back side upload button should not be visible when 'No' is selected.");
        motherDetailsSoftAssert.assertAll();


        is_student_account_available = chromeDriver.findElement(By.name("is_student_account_available"));

        motherDetailsSoftAssert.assertTrue(is_student_account_available.isDisplayed(),
                "Is Student Account Available field should be visible when 'No' is selected.");

        Select isStudentAccountAvailableSelect = new Select(is_student_account_available);
        isStudentAccountAvailableSelect.selectByVisibleText("No");

        Thread.sleep(2000); // Wait for the dropdown to update

        motherDetailsSoftAssert.assertFalse(isElementVisible(mother_account_bank_ifsc_code),
                "Mother's Bank IFSC Code field should not be visible when 'No' is selected.");
        motherDetailsSoftAssert.assertFalse(isElementVisible(mother_account_bank_name),
                "Mother's Bank Name field should not be visible when 'No' is selected.");
        motherDetailsSoftAssert.assertFalse(isElementVisible(mother_account_branch_name),
                "Mother's Bank Branch Name field should not be visible when 'No' is selected.");
        motherDetailsSoftAssert.assertFalse(isElementVisible(mother_bank_account_no),
                "Mother's Bank Account No field should not be visible when 'No' is selected.");
        motherDetailsSoftAssert.assertFalse(isElementVisible(mother_name_in_bank),
                "Mother's Name in Bank field should not be visible when 'No' is selected.");
        motherDetailsSoftAssert.assertFalse(isElementVisible(mother_cc_passport_url),
                "Mother's CC Passbook URL field should not be visible when 'No' is selected.");

        isStudentAccountAvailableSelect.selectByVisibleText("Yes");

        mother_account_bank_ifsc_code = chromeDriver.findElement(By.name("student_account_bank_ifsc_code"));
        mother_account_bank_name = chromeDriver.findElement(By.name("student_account_bank_name"));
        mother_account_branch_name = chromeDriver.findElement(By.name("student_account_branch_name"));
        mother_bank_account_no = chromeDriver.findElement(By.name("student_bank_account_no"));
        mother_name_in_bank = chromeDriver.findElement(By.name("student_name_in_bank"));
        mother_cc_passport_url = chromeDriver.findElement(By.name("student_cc_passport_url"));

        Thread.sleep(2000); // Wait for the dropdown to update
        motherDetailsSoftAssert.assertTrue(isElementVisible(mother_account_bank_ifsc_code),
                "Mother's Bank IFSC Code field should be visible when 'Yes' is selected.");
        motherDetailsSoftAssert.assertTrue(isElementVisible(mother_account_bank_name),
                "Mother's Bank Name field should be visible when 'Yes' is selected.");

        motherDetailsSoftAssert.assertTrue(isElementVisible(mother_account_branch_name),
                "Mother's Bank Branch Name field should be visible when 'Yes' is selected.");
        motherDetailsSoftAssert.assertTrue(isElementVisible(mother_bank_account_no),
                "Mother's Bank Account No field should be visible when 'Yes' is selected.");
        motherDetailsSoftAssert.assertTrue(isElementVisible(mother_name_in_bank),
                "Mother's Name in Bank field should be visible when 'Yes' is selected.");
        motherDetailsSoftAssert.assertTrue(isElementVisible(mother_cc_passport_url),
                "Mother's CC Passbook URL field should be visible when 'Yes' is selected.");
        isMotherDetailsAvailableSelect.selectByVisibleText("Yes");

        motherDetailsSoftAssert.assertAll();

    }

    public void clickOnSubmitForValidation() throws InterruptedException {
        submit= chromeDriver.findElement(By.xpath("//button[text()='Save']"));
        scrollToBottom();
        Thread.sleep(2000);
        submit.click();
        Thread.sleep(2000);
        //scrollToText("Enter Student/Mother/guardian Phone Number");
        scrollToTopByUpKey();
    }

    public void clickSaveButtonAndPrepareForValidation() throws InterruptedException {
        submit = chromeDriver.findElement(By.xpath("//button[text()='Save']"));
        scrollToBottom();
        Thread.sleep(2000);
        submit.click();
        Thread.sleep(2000);
        scrollToTopByUpKey();
    }


    public void validateMessagesForGuardianMobileNo() throws InterruptedException {
        guardian_mobile_no = chromeDriver.findElement(By.name("guardian_mobile_no"));
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(guardian_mobile_no.getText(),"",
                "Guardian Mobile No field should be empty initially.");

        softAssert.assertTrue(isValidationMessageDisplayedForOnlyRequiredField("guardian_mobile_no"),
                "Validation message for Guardian Mobile No field should be displayed when invalid input is provided.");

        guardian_mobile_no.sendKeys("hello");
        softAssert.assertEquals(getValidationMessage("guardian_mobile_no"),"Invalid mobile number",
                "Validation message for Guardian Mobile No field should be displayed when invalid input is provided.");


        guardian_mobile_no.click();
        guardian_mobile_no.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        guardian_mobile_no.sendKeys(Keys.BACK_SPACE);

        guardian_mobile_no.sendKeys("999999999");
        softAssert.assertEquals(getValidationMessage("guardian_mobile_no"),"Invalid mobile number",
                "Validation message for Guardian Mobile No field should be displayed when invalid input is provided.");


        guardian_mobile_no.click();

        guardian_mobile_no.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        guardian_mobile_no.sendKeys(Keys.BACK_SPACE);

        guardian_mobile_no.sendKeys("99999999933");
        softAssert.assertEquals(getValidationMessage("guardian_mobile_no"),"Invalid mobile number",
                "Validation message for Guardian Mobile No field should be displayed when invalid input is provided.");


        guardian_mobile_no.click();

        guardian_mobile_no.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        guardian_mobile_no.sendKeys(Keys.BACK_SPACE);

        guardian_mobile_no.sendKeys("+917777777777");
        softAssert.assertEquals(getValidationMessage("guardian_mobile_no"),"Invalid mobile number",
                    "Validation message for Guardian Mobile No field should be displayed when invalid input is provided.");

        guardian_mobile_no.click();

        guardian_mobile_no.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        guardian_mobile_no.sendKeys(Keys.BACK_SPACE);

        guardian_mobile_no.sendKeys("9999999999");
        softAssert.assertFalse(isValidationMessageDisplayed("guardian_mobile_no"),
                "Validation message for Guardian Mobile No field should not be displayed when valid input is provided.");

        softAssert.assertAll();
    }

    public void validateMessagesForStudentNameAsPerAadhar() throws InterruptedException {
        aadhar_card_name = chromeDriver.findElement(By.name("aadhar_card_name"));
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(aadhar_card_name.getText(),"",
                "Aadhar Card Name field should be empty initially.");

        softAssert.assertTrue(isValidationMessageDisplayedForOnlyRequiredField("aadhar_card_name"),
                "Validation message for Aadhar Card Name field should be displayed when invalid input is provided.");

        aadhar_card_name.sendKeys("12345");
        softAssert.assertEquals(getValidationMessage("aadhar_card_name"),"Name must be alphabet",
                "Validation message for Aadhar Card Name field should be displayed when invalid input is provided.");

        aadhar_card_name.click();
        aadhar_card_name.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        aadhar_card_name.sendKeys(Keys.BACK_SPACE);

        aadhar_card_name.sendKeys("!@#$%");
        softAssert.assertEquals(getValidationMessage("aadhar_card_name"),"Name must be alphabet",
                "Validation message for Aadhar Card Name field should be displayed when invalid input is provided.");

        aadhar_card_name.click();
        aadhar_card_name.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        aadhar_card_name.sendKeys(Keys.BACK_SPACE);

        aadhar_card_name.sendKeys("John Doe");
        softAssert.assertFalse(isValidationMessageDisplayed("aadhar_card_name"),
                "Validation message for Aadhar Card Name field should not be displayed when valid input is provided.");

        softAssert.assertAll();
    }

    public void validateMessagesForStudentAddharNumber() throws InterruptedException {
        aadhar_no = chromeDriver.findElement(By.name("aadhar_no"));
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(aadhar_no.getText(),"",
                "Aadhar No field should be empty initially.");
        softAssert.assertTrue(isValidationMessageDisplayedForOnlyRequiredField("aadhar_no"),
                "Validation message for Aadhar No field should be displayed when invalid input is provided.");

        aadhar_no.sendKeys("Test Test Test Test ");
        softAssert.assertEquals(getValidationMessage("aadhar_no"),"Aadhar number must be 12 digits",
                "Validation message for Aadhar No field should be displayed when invalid input is provided.");

        aadhar_no.click();
        aadhar_no.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        aadhar_no.sendKeys(Keys.BACK_SPACE);
        aadhar_no.sendKeys("1234567890");
        softAssert.assertEquals(getValidationMessage("aadhar_no"),"Aadhar number must be 12 digits",
                "Validation message for Aadhar No field should be displayed when invalid input is provided.");

        aadhar_no.click();
        aadhar_no.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        aadhar_no.sendKeys(Keys.BACK_SPACE);
        aadhar_no.sendKeys("12345678901");
        softAssert.assertEquals(getValidationMessage("aadhar_no"),"Aadhar number must be 12 digits",
                "Validation message for Aadhar No field should be displayed when invalid input is provided.");

        aadhar_no.click();
        aadhar_no.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        aadhar_no.sendKeys(Keys.BACK_SPACE);
        aadhar_no.sendKeys("1234567890123");
        softAssert.assertEquals(getValidationMessage("aadhar_no"),"Aadhar number must be 12 digits",
                "Validation message for Aadhar No field should be displayed when invalid input is provided.");

        aadhar_no.click();
        aadhar_no.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        aadhar_no.sendKeys(Keys.BACK_SPACE);
        aadhar_no.sendKeys("1234 5678 9012");
        softAssert.assertEquals(getValidationMessage("aadhar_no"),"Aadhar number must be 12 digits",
                "Validation message for Aadhar No field should be displayed when invalid input is provided.");


        aadhar_no.click();
        aadhar_no.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        aadhar_no.sendKeys(Keys.BACK_SPACE);
        aadhar_no.sendKeys("123456789012");
        softAssert.assertFalse(isValidationMessageDisplayed("aadhar_no"),
                "Validation message for Aadhar No field should not be displayed when valid input is provided.");
        softAssert.assertAll();
           }


    public void validateMessagesForStudentAddharFrontPage() throws InterruptedException {
        waitFor(15);
        //scrollToDownByDownKey(30);
        aadhar_card_url_front = chromeDriver.findElement(By.name("aadhar_card_url_front"));

        assertRequiredFieldValidationMessageDisplayed("aadhar_card_url_front");
        assertValidFileNoValidationMessage(aadhar_card_url_front,"C://Users//ishan//Downloads//JPG_LESSTHAN_5MB.jpg","aadhar_card_url_front");
        assertFileSizeExceededMessage(aadhar_card_url_front,"C://Users//ishan//Downloads//JPG_MORETHAN_5MB_.jpg","aadhar_card_url_front");
        assertFileSizeExceededMessage(aadhar_card_url_front,"C://Users//ishan//Downloads//JPEG_MORETHAN_5MB.jpeg","aadhar_card_url_front");
        assertValidFileNoValidationMessage(aadhar_card_url_front,"C://Users//ishan//Downloads//JPEG_LESSTHAN_5MB.jpeg","aadhar_card_url_front");
        assertFileSizeExceededMessage(aadhar_card_url_front,"C://Users//ishan//Downloads//PNG_MORETHAN_5MB.png","aadhar_card_url_front");
        assertValidFileNoValidationMessage(aadhar_card_url_front,"C://Users//ishan//Downloads//PNG_LESSTHAN_5MB.png","aadhar_card_url_front");
        assertInvalidFileTypeMessage(aadhar_card_url_front,"C://Users//ishan//Downloads//PDF_INVALID_FILE.pdf","aadhar_card_url_front");
        assertInvalidFileTypeMessage(aadhar_card_url_front,"C://Users//ishan//Downloads//INVALID_FILE.test","aadhar_card_url_front");
        assertValidFileNoValidationMessage(aadhar_card_url_front,"C://Users//ishan//Downloads//PNG_LESSTHAN_5MB.png","aadhar_card_url_front");

    }

    public void validateMessagesForStudentAddharBackPage() throws InterruptedException {
        waitFor(15);
        //scrollToDownByDownKey(30);
        aadhar_card_url_back = chromeDriver.findElement(By.name("aadhar_card_url_back"));

        assertRequiredFieldValidationMessageDisplayed("aadhar_card_url_back");
        assertValidFileNoValidationMessage(aadhar_card_url_back,"C://Users//ishan//Downloads//JPG_LESSTHAN_5MB.jpg","aadhar_card_url_back");
        assertFileSizeExceededMessage(aadhar_card_url_back,"C://Users//ishan//Downloads//JPG_MORETHAN_5MB_.jpg","aadhar_card_url_back");
        assertFileSizeExceededMessage(aadhar_card_url_back,"C://Users//ishan//Downloads//JPEG_MORETHAN_5MB.jpeg","aadhar_card_url_back");
        assertValidFileNoValidationMessage(aadhar_card_url_back,"C://Users//ishan//Downloads//JPEG_LESSTHAN_5MB.jpeg","aadhar_card_url_back");
        assertFileSizeExceededMessage(aadhar_card_url_back,"C://Users//ishan//Downloads//PNG_MORETHAN_5MB.png","aadhar_card_url_back");
        assertValidFileNoValidationMessage(aadhar_card_url_back,"C://Users//ishan//Downloads//PNG_LESSTHAN_5MB.png","aadhar_card_url_back");
        assertInvalidFileTypeMessage(aadhar_card_url_back,"C://Users//ishan//Downloads//PDF_INVALID_FILE.pdf","aadhar_card_url_back");
        assertInvalidFileTypeMessage(aadhar_card_url_back,"C://Users//ishan//Downloads//INVALID_FILE.test","aadhar_card_url_back");
        assertValidFileNoValidationMessage(aadhar_card_url_back,"C://Users//ishan//Downloads//PNG_LESSTHAN_5MB.png","aadhar_card_url_back");

    }

    public void validateMessagesForMotherAddharFrontPage() throws InterruptedException {
        waitFor(15);
        //scrollToDownByDownKey(30);
        mother_aadhar_card_url_front = chromeDriver.findElement(By.name("mother_aadhar_card_url_front"));

        assertRequiredFieldValidationMessageDisplayed("mother_aadhar_card_url_front");
        assertValidFileNoValidationMessage(mother_aadhar_card_url_front,"C://Users//ishan//Downloads//JPG_LESSTHAN_5MB.jpg","mother_aadhar_card_url_front");
        assertFileSizeExceededMessage(mother_aadhar_card_url_front,"C://Users//ishan//Downloads//JPG_MORETHAN_5MB_.jpg","mother_aadhar_card_url_front");
        assertFileSizeExceededMessage(mother_aadhar_card_url_front,"C://Users//ishan//Downloads//JPEG_MORETHAN_5MB.jpeg","mother_aadhar_card_url_front");
        assertValidFileNoValidationMessage(mother_aadhar_card_url_front,"C://Users//ishan//Downloads//JPEG_LESSTHAN_5MB.jpeg","mother_aadhar_card_url_front");
        assertFileSizeExceededMessage(mother_aadhar_card_url_front,"C://Users//ishan//Downloads//PNG_MORETHAN_5MB.png","mother_aadhar_card_url_front");
        assertValidFileNoValidationMessage(mother_aadhar_card_url_front,"C://Users//ishan//Downloads//PNG_LESSTHAN_5MB.png","mother_aadhar_card_url_front");
        assertInvalidFileTypeMessage(mother_aadhar_card_url_front,"C://Users//ishan//Downloads//PDF_INVALID_FILE.pdf","mother_aadhar_card_url_front");
        assertInvalidFileTypeMessage(mother_aadhar_card_url_front,"C://Users//ishan//Downloads//INVALID_FILE.test","mother_aadhar_card_url_front");
        assertValidFileNoValidationMessage(mother_aadhar_card_url_front,"C://Users//ishan//Downloads//PNG_LESSTHAN_5MB.png","mother_aadhar_card_url_front");

    }

    public void validateMessagesForMotherAddharBackPage() throws InterruptedException {
        waitFor(15);
        //scrollToDownByDownKey(30);
        mother_aadhar_card_url_back = chromeDriver.findElement(By.name("mother_aadhar_card_url_back"));

        assertRequiredFieldValidationMessageDisplayed("mother_aadhar_card_url_back");
        assertValidFileNoValidationMessage(mother_aadhar_card_url_back,"C://Users//ishan//Downloads//JPG_LESSTHAN_5MB.jpg","mother_aadhar_card_url_back");
        assertFileSizeExceededMessage(mother_aadhar_card_url_back,"C://Users//ishan//Downloads//JPG_MORETHAN_5MB_.jpg","mother_aadhar_card_url_back");
        assertFileSizeExceededMessage(mother_aadhar_card_url_back,"C://Users//ishan//Downloads//JPEG_MORETHAN_5MB.jpeg","mother_aadhar_card_url_back");
        assertValidFileNoValidationMessage(mother_aadhar_card_url_back,"C://Users//ishan//Downloads//JPEG_LESSTHAN_5MB.jpeg","mother_aadhar_card_url_back");
        assertFileSizeExceededMessage(mother_aadhar_card_url_back,"C://Users//ishan//Downloads//PNG_MORETHAN_5MB.png","mother_aadhar_card_url_back");
        assertValidFileNoValidationMessage(mother_aadhar_card_url_back,"C://Users//ishan//Downloads//PNG_LESSTHAN_5MB.png","mother_aadhar_card_url_back");
        assertInvalidFileTypeMessage(mother_aadhar_card_url_back,"C://Users//ishan//Downloads//PDF_INVALID_FILE.pdf","mother_aadhar_card_url_back");
        assertInvalidFileTypeMessage(mother_aadhar_card_url_back,"C://Users//ishan//Downloads//INVALID_FILE.test","mother_aadhar_card_url_back");
        assertValidFileNoValidationMessage(mother_aadhar_card_url_back,"C://Users//ishan//Downloads//PNG_LESSTHAN_5MB.png","mother_aadhar_card_url_back");

    }


    public void validateMessagesForMotherNameAsPerAadhar() throws InterruptedException {
        mother_name_as_per_aadhar = chromeDriver.findElement(By.name("mother_name_as_per_aadhar"));
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(mother_name_as_per_aadhar.getText(),"",
                "Mother Aadhar Card Name field should be empty initially.");

        softAssert.assertTrue(isValidationMessageDisplayedForOnlyRequiredField("mother_name_as_per_aadhar"),
                "Validation message for Mother Aadhar Card Name field should be displayed when invalid input is provided.");

        mother_name_as_per_aadhar.sendKeys("12345");
        softAssert.assertEquals(getValidationMessage("mother_name_as_per_aadhar"),"Name must be alphabet",
                "Validation message for Mother Aadhar Card Name field should be displayed when invalid input is provided.");

        mother_name_as_per_aadhar.click();
        mother_name_as_per_aadhar.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        mother_name_as_per_aadhar.sendKeys(Keys.BACK_SPACE);

        mother_name_as_per_aadhar.sendKeys("!@#$%");
        softAssert.assertEquals(getValidationMessage("mother_name_as_per_aadhar"),"Name must be alphabet",
                "Validation message for Mother Aadhar Card Name field should be displayed when invalid input is provided.");

        mother_name_as_per_aadhar.click();
        mother_name_as_per_aadhar.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        mother_name_as_per_aadhar.sendKeys(Keys.BACK_SPACE);

        mother_name_as_per_aadhar.sendKeys("Mamta ben Patel");
        softAssert.assertFalse(isValidationMessageDisplayed("mother_name_as_per_aadhar"),
                "Validation message for Mother Aadhar Card Name field should not be displayed when valid input is provided.");

        softAssert.assertAll();
    }

    public void validateMessagesForMotherAddharNumber() throws InterruptedException {
        mother_aadhar_no = chromeDriver.findElement(By.name("mother_aadhar_no"));
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(aadhar_no.getText(),"",
                "Aadhar No field should be empty initially.");
        softAssert.assertTrue(isValidationMessageDisplayedForOnlyRequiredField("mother_aadhar_no"),
                "Validation message for Mother Aadhar No field should be displayed when invalid input is provided.");

        mother_aadhar_no.sendKeys("Test Test Test Test ");
        softAssert.assertEquals(getValidationMessage("mother_aadhar_no"),"Aadhar number must be 12 digits",
                "Validation message for Mother Aadhar No field should be displayed when invalid input is provided.");

        mother_aadhar_no.click();
        mother_aadhar_no.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        mother_aadhar_no.sendKeys(Keys.BACK_SPACE);
        mother_aadhar_no.sendKeys("1234567890");
        softAssert.assertEquals(getValidationMessage("mother_aadhar_no"),"Aadhar number must be 12 digits",
                "Validation message for Mother Aadhar No field should be displayed when invalid input is provided.");

        mother_aadhar_no.click();
        mother_aadhar_no.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        mother_aadhar_no.sendKeys(Keys.BACK_SPACE);
        mother_aadhar_no.sendKeys("12345678901");
        softAssert.assertEquals(getValidationMessage("mother_aadhar_no"),"Aadhar number must be 12 digits",
                "Validation message for Mother Aadhar No field should be displayed when invalid input is provided.");

        mother_aadhar_no.click();
        mother_aadhar_no.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        mother_aadhar_no.sendKeys(Keys.BACK_SPACE);
        mother_aadhar_no.sendKeys("1234567890123");
        softAssert.assertEquals(getValidationMessage("mother_aadhar_no"),"Aadhar number must be 12 digits",
                "Validation message for Mother Aadhar No field should be displayed when invalid input is provided.");

        mother_aadhar_no.click();
        mother_aadhar_no.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        mother_aadhar_no.sendKeys(Keys.BACK_SPACE);
        mother_aadhar_no.sendKeys("1234 5678 9012");
        softAssert.assertEquals(getValidationMessage("mother_aadhar_no"),"Aadhar number must be 12 digits",
                "Validation message for Mother Aadhar No field should be displayed when invalid input is provided.");


        mother_aadhar_no.click();
        mother_aadhar_no.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        mother_aadhar_no.sendKeys(Keys.BACK_SPACE);
        mother_aadhar_no.sendKeys("123456789012");
        softAssert.assertFalse(isValidationMessageDisplayed("mother_aadhar_no"),
                "Validation message for Mother Aadhar No field should not be displayed when valid input is provided.");
        softAssert.assertAll();
    }

    // Java
    private void assertRequiredFieldValidationMessageDisplayed(String fieldName) {
        Assert.assertTrue(isValidationMessageDisplayedForOnlyRequiredField(fieldName),
                "[REQUIRED FIELD] : Validation message for LC/birth Card URL Back field should be displayed when invalid input is provided.");
    }

    private void assertValidFileNoValidationMessage(WebElement element ,  String filePath , String fieldName) throws InterruptedException {
        element.sendKeys(filePath);
        waitFixTimeForUploadImage();
        Assert.assertFalse(isValidationMessageDisplayed(fieldName),
                "[" + filePath + "] Validation message for LC/birth Card URL Back field should not be displayed when valid input is provided.");
    }

    private void assertFileSizeExceededMessage(WebElement element ,  String filePath , String fieldName) throws InterruptedException {
        element.sendKeys(filePath);
        waitFixTimeForUploadImage();
        Assert.assertEquals(getValidationMessage(fieldName), "File size exceeds the maximum allowed size of 5MB.",
                "[" + fieldName + "] Validation message for LC/birth Card URL Back field should be displayed when invalid input is provided.");
    }

    private void assertInvalidFileTypeMessage(WebElement element ,  String filePath , String fieldName) throws InterruptedException {
        element.sendKeys(filePath);
        waitFixTimeForUploadImage();

        Assert.assertEquals(getValidationMessage(fieldName), "Invalid file type. Only JPG, JPEG, PNG files are allowed.",
                "[" + fieldName + "] Validation message for LC/birth Card URL Back field should be displayed when invalid input is provided.");
    }

    public void validateMessagesForLCPage() throws InterruptedException {
        waitFor(15);
        scrollToDownByDownKey(30);
        lcr_birth_certificate = chromeDriver.findElement(By.name("lcr_birth_certificate"));

        assertRequiredFieldValidationMessageDisplayed("lcr_birth_certificate");
        assertValidFileNoValidationMessage(lcr_birth_certificate,"C://Users//ishan//Downloads//JPG_LESSTHAN_5MB.jpg","lcr_birth_certificate");
        assertFileSizeExceededMessage(lcr_birth_certificate,"C://Users//ishan//Downloads//JPG_MORETHAN_5MB_.jpg","lcr_birth_certificate");
        assertFileSizeExceededMessage(lcr_birth_certificate,"C://Users//ishan//Downloads//JPEG_MORETHAN_5MB.jpeg","lcr_birth_certificate");
        assertValidFileNoValidationMessage(lcr_birth_certificate,"C://Users//ishan//Downloads//JPEG_LESSTHAN_5MB.jpeg","lcr_birth_certificate");
        assertFileSizeExceededMessage(lcr_birth_certificate,"C://Users//ishan//Downloads//PNG_MORETHAN_5MB.png","lcr_birth_certificate");
        assertValidFileNoValidationMessage(lcr_birth_certificate,"C://Users//ishan//Downloads//PNG_LESSTHAN_5MB.png","lcr_birth_certificate");
        assertInvalidFileTypeMessage(lcr_birth_certificate,"C://Users//ishan//Downloads//PDF_INVALID_FILE.pdf","lcr_birth_certificate");
        assertInvalidFileTypeMessage(lcr_birth_certificate,"C://Users//ishan//Downloads//INVALID_FILE.test","lcr_birth_certificate");
        assertValidFileNoValidationMessage(lcr_birth_certificate,"C://Users//ishan//Downloads//PNG_LESSTHAN_5MB.png","lcr_birth_certificate");

    }




    private boolean isValidationMessageDisplayedForOnlyRequiredField(String fieldName){
        try {
            Thread.sleep(2000); // Wait for the file to be processed

            WebElement validationMessage = chromeDriver.findElement(By.xpath("//input[@name='"+fieldName+"']" +
                    "//following-sibling::div[@class='invalid-feedback'] | //div[@class='upload-section']/input[@name='"+fieldName+"']//parent::div" +
                    "//following-sibling::div[@class='error-text']/small"));
            String messageText = validationMessage.getText();
            return messageText.equals("Field is required");
        } catch (NoSuchElementException e) {
            return false;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private String getValidationMessage(String fieldName) throws InterruptedException {
        try {
            Thread.sleep(1000); // Wait for the validation message to appear
            WebElement validationMessage = chromeDriver.findElement(By.xpath("//input[@name='"+fieldName+"']" +
                    "//following-sibling::div[@class='invalid-feedback'] | //div[@class='upload-section']/input[@name='"+fieldName+"']//parent::div" +
                    "//following-sibling::div[@class='error-text']/small"));
            Thread.sleep(1000); // Wait for the validation message to appear

            String messageText = validationMessage.getText();
            return messageText;
        } catch (NoSuchElementException e) {
            Assert.fail("Validation message for field '" + fieldName + "' not found.");
        }
        return "";
    }

    private boolean isValidationMessageDisplayed(String fieldName){
        try {
            WebElement validationMessage = chromeDriver.findElement(By.xpath("//input[@name='"+fieldName+"']" +
                    "//following-sibling::div[@class='invalid-feedback'] | //div[@class='upload-section']/input[@name='"+fieldName+"']//parent::div" +
                    "//following-sibling::div[@class='error-text']/small"));
            String messageText = validationMessage.getText();
            return !messageText.isEmpty();
        } catch (NoSuchElementException e) {
            return false;
        }

    }

    // Java
    private void assertMotherBankIFSCFieldIsEmpty() {
        Assert.assertEquals(mother_account_bank_ifsc_code.getText(), "",
                "Mother Bank IFSC field should be empty initially.");
    }

    private void assertRequiredFieldValidationMessageDisplayedForIFSC() {
        Assert.assertTrue(isValidationMessageDisplayedForOnlyRequiredField("mother_account_bank_ifsc_code"),
                "[REQUIRED FIELD] : Validation message for Mother Bank IFSC field should be displayed when invalid input is provided.");
    }

    private void assertInvalidIFSCCode(String ifsc) throws InterruptedException {
        scrollToDownByDownKey(20);
        mother_account_bank_ifsc_code.click();
        mother_account_bank_ifsc_code.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        mother_account_bank_ifsc_code.sendKeys(Keys.BACK_SPACE);
        mother_account_bank_ifsc_code.sendKeys(ifsc);
        Thread.sleep(2000);
        Assert.assertEquals(getValidationMessage("mother_account_bank_ifsc_code"), "Invalid IFSC code",
                "Validation message for Mother Bank IFSC field is wrongly displayed when input [" + ifsc + "] is provided.");
    }

    private void assertValidIFSCCode(String ifsc) throws InterruptedException {
        mother_account_bank_ifsc_code.click();
        mother_account_bank_ifsc_code.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        mother_account_bank_ifsc_code.sendKeys(Keys.BACK_SPACE);
        mother_account_bank_ifsc_code.sendKeys(ifsc);
        Thread.sleep(2000);
        Assert.assertFalse(isValidationMessageDisplayed("mother_account_bank_ifsc_code"),
                "Validation message for Mother Bank IFSC field should not be displayed when valid input is provided.");
    }

    private void assertBankDetailsDialog() {
        try {
            WebElement dialog = chromeDriver.findElement(By.xpath("//dialog[@id='modal']/p[text()='No Bank Details found']"));
            if (dialog.isDisplayed()) {
                chromeDriver.findElement(By.xpath(".//button[@class='diglog-submit-btn'][text()='Ok']")).click();
            }
        } catch (NoSuchElementException e) {
            Assert.fail("Dialog with message 'No Bank Details found' not found.");
        }
    }

    private void assertBankNameAndBranch(String expectedBankName, String expectedBranchName) {
        mother_account_bank_name = chromeDriver.findElement(By.name("mother_account_bank_name"));
        Assert.assertEquals(mother_account_bank_name.getAttribute("value"), expectedBankName,
                "Mother Bank Name field should be [" + expectedBankName + "].");

        mother_account_branch_name = chromeDriver.findElement(By.name("mother_account_branch_name"));
        Assert.assertEquals(mother_account_branch_name.getAttribute("value"), expectedBranchName,
                "Mother Branch Name field should be [" + expectedBranchName + "].");
    }

    // Java
    public void validateMessagesForIFSCCode() throws InterruptedException {
        mother_account_bank_ifsc_code = chromeDriver.findElement(By.name("mother_account_bank_ifsc_code"));

        assertMotherBankIFSCFieldIsEmpty();
        assertRequiredFieldValidationMessageDisplayedForIFSC();

        assertInvalidIFSCCode("00000000000");
        assertInvalidIFSCCode("0000000000");
        assertInvalidIFSCCode("00000UUUUUU");
        assertInvalidIFSCCode("ICICIPPPPPP");
        assertInvalidIFSCCode("ICI0000000");
        assertInvalidIFSCCode("icic0yyyyyy");
        assertInvalidIFSCCode("ICIC0YHYTGTU");
        assertInvalidIFSCCode("ICIC0YYYYY");

        assertValidIFSCCode("ICIC0033777");

        verify = chromeDriver.findElement(By.xpath("//label[@for='mother_account_bank_ifsc_code']/following-sibling::small[text()='Verify']"));
        Thread.sleep(2000);
        verify.click();
        Thread.sleep(3000);

        assertBankDetailsDialog();

        assertValidIFSCCode("ICIC0003777");
        verify.click();
        Thread.sleep(2000);

        assertBankNameAndBranch("ICICI Bank", "NAGARKURNOOL");
    }

}
