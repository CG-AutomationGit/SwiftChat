package mis.stateAdmin.pages;

import mis.base.MIS_Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class SA_CreateNewPage extends MIS_Base {

    public SA_CreateNewPage(ChromeDriver chromeDriver){
        super(chromeDriver);
        PageFactory.initElements(chromeDriver , this);
    }

    @FindBy(className = "ant-select-item-option-content")
    List<WebElement> selectOption;

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

    String getUDISECode;

    public SA_UserManagementPage createNewUser(String dist , String block , String cluster , String school , String email) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException, InterruptedException {



        districtField.click();
        for (WebElement webElement : selectOption) {
            if (webElement.getText().equals(dist)) {
                webElement.click();
                break;
            }
        }
        waitFor();
        blockField.click();

        for (WebElement webElement : selectOption) {
            if (webElement.getText().equals(block)) {
                webElement.click();
                break;
            }
        }
        waitFor();

        clusterField.click();

        for (WebElement webElement : selectOption) {
            if (webElement.getText().equals(cluster)) {
                webElement.click();
                break;
            }
        }
        waitFor();

        schoolField.click();

        for (WebElement webElement : selectOption) {
            if (webElement.getText().equals(school)) {
                webElement.click();
                break;
            }
        }
        waitFor();

        getUDISECode = UDISEField.getText();
        System.out.println(getUDISECode);
        emailField.sendKeys(email);
        createButton.click();
        return createMISPageForChrome(SA_UserManagementPage.class);
    }
}
