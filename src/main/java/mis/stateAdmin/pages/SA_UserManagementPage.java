package mis.stateAdmin.pages;

import mis.base.MIS_Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class SA_UserManagementPage extends MIS_Base {

    public SA_UserManagementPage(ChromeDriver chromeDriver){
        super(chromeDriver);
        PageFactory.initElements(chromeDriver , this);
    }


    @FindBy(xpath = "//label/following-sibling::nz-select[@nzplaceholder='District']")
    WebElement districtField;

    @FindBy(xpath = "//label/following-sibling::nz-select[@nzplaceholder='Block ']")
    WebElement blockField;

    @FindBy(xpath = "//label/following-sibling::nz-select[@nzplaceholder='Cluster']")
    WebElement clusterField;

    @FindBy(xpath = "//label/following-sibling::nz-select[@nzplaceholder='School']")
    WebElement schoolField;

    @FindBy(xpath = "//label[text()='User Name (UDISE Code)']/following-sibling::nz-input-group/input")
    WebElement UDISEField;

    @FindBy(xpath = "//label[text()='E-mail']/following-sibling::nz-input-group/input")
    WebElement emailField;

    @FindBy(xpath = "//span[text()=' Create ']")
    WebElement createButton;

    @FindBy(xpath = "//i[@nztype='delete']")
    List<WebElement> deleteIconFor;

    String getUDISECode;
    @FindBy(className = "ant-select-item-option-content")
    List<WebElement> selectOption;

    public boolean isRecordAvailableBySearch(String dist , String block , String schoolName){
        setDistrictSearch(dist);
        setBlockSearch(block);
        setSchoolSearch(schoolName);

        WebElement school = chromeDriver.findElement(By.xpath("" +
                "//tbody/tr[2]/td[2]"));
        return school.getText().equals(schoolName);
    }

    public boolean isRecordAvailableBySchoolIdSearch(String schoolID){
        WebElement school = chromeDriver.findElement(By.xpath(
                "//input[@placeholder='Search with Username']"));
        WebElement searchButton = chromeDriver.findElement(By.xpath(
                "//span[text()=' Search ']"));

        school.sendKeys(schoolID);
        searchButton.click();
        WebElement schoolInGrid = chromeDriver.findElement(By.xpath("" +
                "//tbody/tr[2]/td[3]"));
        return schoolInGrid.getText().equals(schoolID);
    }

    public boolean isRecordAvailableSearchedBySchoolName(String dist , String block , String schoolName){
        setDistrictSearch(dist);
        setBlockSearch(block);
        setSchoolSearch(schoolName);
        WebElement schoolInGrid = chromeDriver.findElement(By.xpath("" +
                "//tbody/tr[2]/td[2]"));
        return schoolInGrid.getText().equals(schoolName);
    }

    public void setDistrictSearch(String dist){
        districtField.click();
        for (WebElement webElement : selectOption) {
            if (webElement.getText().equals(dist)) {
                webElement.click();
                break;
            }
        }
    }

    public void setBlockSearch(String block){
        blockField.click();

        for (WebElement webElement : selectOption) {
            if (webElement.getText().equals(block)) {
                webElement.click();
                break;
            }
        }
    }

    public void setSchoolSearch(String school){
        schoolField.click();

        for (WebElement webElement : selectOption) {
            if (webElement.getText().equals(school)) {
                webElement.click();
                break;
            }
        }
    }

    @FindBy(xpath = "//span[text()=' Create New User']")
    WebElement createNewUser;


    public SA_CreateNewPage clickOnNewUserButton() throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        createNewUser.click();
        return createMISPageForChrome(SA_CreateNewPage.class);
    }


    public void deleteRecord(String SchoolID){
        if(isRecordAvailableBySchoolIdSearch(SchoolID)){
            deleteIconFor.get(0).click();
            chromeDriver.findElement(By.xpath("//button/span[text()='Yes']")).click();
        }
        WebElement deleteSuccessMessage = chromeDriver.findElement(By.xpath(
                "//h4[text()='User Deleted!']/following-sibling::div[text()=" +
                        "'User successfully deleted']/following-sibling::button"));
        Assert.assertTrue(deleteSuccessMessage.isDisplayed());
        deleteSuccessMessage.click();
        Assert.assertFalse(isRecordAvailableBySchoolIdSearch(SchoolID),
                "Still Record is displayed in grid after deleted.");
    }

}
