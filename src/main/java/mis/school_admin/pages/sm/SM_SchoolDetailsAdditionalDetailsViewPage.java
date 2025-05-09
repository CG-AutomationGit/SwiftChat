package mis.school_admin.pages.sm;

import mis.base.MIS_Base;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.lang.reflect.InvocationTargetException;


public class SM_SchoolDetailsAdditionalDetailsViewPage extends MIS_Base {

    WebElement cancelButton , editButton , firstSection , secondSection , thirdSection , forthSection;

    @FindBy(xpath = "//label[text()=' 1). UDISE Code']/following-sibling::nz-input-group/input")
    WebElement UDISECode;

    @FindBy(xpath = "//label[text()=' 2). School Name (In capital letters)']/following-sibling::nz-input-group/input")
    WebElement schoolName;

    @FindBy(xpath = "//label[text()=' 3). District Name']/following-sibling::nz-input-group/input")
    WebElement districtName;

    @FindBy(xpath = "//label[text()=' 4). Block Name']/following-sibling::nz-input-group/input")
    WebElement blockName;

    @FindBy(xpath = "//label[text()=' 5). School Location Type']/following-sibling::nz-input-group//input")
    WebElement locationType;

    @FindBy(xpath = "//label[text()=' 6). Cluster Resource Centre (CRC)']/following-sibling::nz-input-group//input")
    WebElement crc;

    @FindBy(xpath = "//label[text()=' 7). Assembly Constituency Code']/following-sibling::nz-input-group//input")
    WebElement assemblyConstituencyCode;

    @FindBy(xpath = "//label[text()=' 8). Parliamentary Constituency Code']/following-sibling::nz-input-group//input")
    WebElement parliamentaryConstituencyCode;

    @FindBy(xpath = "//label[text()=' 9). School Management Code']/following-sibling::nz-input-group//input")
    WebElement schoolManagementCode;

    @FindBy(xpath = "//label[text()=' 10). For Management Code 101 mention Nodal Ministry/Dept.']/following-sibling::nz-input-group//input")
    WebElement nodalMinistryDept;

    @FindBy(xpath = "//label[text()=' 11). School Category Code']/following-sibling::nz-input-group//input")
    WebElement schoolCategoryCode;

    @FindBy(xpath = "//label[text()=' 12). Lowest Class']/following-sibling::nz-input-group//input")
    WebElement lowestClass;

    @FindBy(xpath = "//label[text()=' 13). Highest Class']/following-sibling::nz-input-group//input")
    WebElement highestClass;

    @FindBy(xpath = "//label[text()=' 14). Whether pre-primary section (other than Anganwadi) attached to school?']/following-sibling::nz-input-group//input")
    WebElement prePrimarySection;

    @FindBy(xpath = "//label[text()=' 15). Number of Classes/Grades in Pre-Primary Section']/following-sibling::nz-input-group//input")
    WebElement gradesInPrePrimarySection;

    @FindBy(xpath = "//label[text()=' 16). Type of School']/following-sibling::nz-input-group//input")
    WebElement typeOfSchool;

    @FindBy(xpath = "//label[text()=' 17). School Status']/following-sibling::nz-input-group//input")
    WebElement schoolStatus;

    @FindBy(xpath = "//label[text()=' 18). Session Start Date']/following-sibling::nz-input-group//input")
    WebElement sessionStartDate;

    @FindBy(xpath = "//label[text()=' 19). Session End Date']/following-sibling::nz-input-group//input")
    WebElement sessionEndDate;

    @FindBy(xpath = "//label[text()=' 20). Stream Arts']/following-sibling::nz-input-group//input")
    WebElement streamArts;

    @FindBy(xpath = "//label[text()=' 21). Stream Vocational']/following-sibling::nz-input-group//input")
    WebElement streamVocational;

    @FindBy(xpath = "//label[text()=' 22). Stream Science']/following-sibling::nz-input-group//input")
    WebElement streamScience;

    @FindBy(xpath = "//label[text()=' 23). Stream Commerce']/following-sibling::nz-input-group//input")
    WebElement streamCommerce;

    @FindBy(xpath = "//label[text()=' 24). Stream Others']/following-sibling::nz-input-group//input")
    WebElement streamOthers;

    public SM_SchoolDetailsAdditionalDetailsViewPage(ChromeDriver chromeDriver) {
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



}
