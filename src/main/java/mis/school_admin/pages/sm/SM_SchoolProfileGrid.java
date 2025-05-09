package mis.school_admin.pages.sm;

import mis.base.MIS_Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class SM_SchoolProfileGrid extends MIS_Base {
    public SM_SchoolProfileGrid(ChromeDriver chromeDriver) {
        super(chromeDriver);
    }

    WebElement dictColumn , blockColumn , schCodeColumn , schNameColumn , schCategoryColumn ,schManagementColumn ;

    public boolean isRecordAvailableOnGrid(String dict , String block , String schCode , String schName , String schCategory ,
                                           String schManagement){
        dictColumn = chromeDriver.findElement(By.xpath("//div[2]/table/tbody/tr[2]/td[1][text()='"+dict+"']"));
        blockColumn = chromeDriver.findElement(By.xpath("//div[2]/table/tbody/tr[2]/td[2][text()='"+block+"']"));
        schCodeColumn = chromeDriver.findElement(By.xpath("//div[2]/table/tbody/tr[2]/td[3][text()='"+schCode+"']"));
        schNameColumn = chromeDriver.findElement(By.xpath("//div[2]/table/tbody/tr[2]/td[4][text()='"+schName+"']"));
        schCategoryColumn = chromeDriver.findElement(By.xpath("//div[2]/table/tbody/tr[2]/td[5][text()='"+schCategory+"']"));
        schManagementColumn = chromeDriver.findElement(By.xpath("//div[2]/table/tbody/tr[2]/td[6][text()='"+schManagement+"']"));

        return dictColumn != null && blockColumn != null && schCodeColumn != null && schNameColumn != null && schCategoryColumn != null
                && schManagementColumn != null;
    }

    public boolean isRecordActive(String schCode){
        List<WebElement> elements = chromeDriver.findElements(
                By.xpath("//div[2]/table/tbody/tr/td[3][text()='" + schCode + "']/following-sibling::td[4][text()='Active']")
        );
        return !elements.isEmpty();
    }

    public SM_SchoolDetailsGeneralProfileViewPage openRecord(String schCode) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        List<WebElement> elements = chromeDriver.findElements(
                By.xpath("//div[2]/table/tbody/tr/td[3][text()='"+schCode+"']" +
                        "/following-sibling::td[5]/button/i[@nztype='eye']"));
        elements.getFirst().click();
        return createMISPageForChrome(SM_SchoolDetailsGeneralProfileViewPage.class);
    }

    public SM_SchoolDetailsGeneralProfileViewPage openRecordForEdit(String schCode) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        List<WebElement> elements = chromeDriver.findElements(
                By.xpath("//div[2]/table/tbody/tr/td[3][text()='"+schCode+"']" +
                        "/following-sibling::td[5]/button/i[@nztype='edit']"));
        elements.getFirst().click();
        return createMISPageForChrome(SM_SchoolDetailsGeneralProfileViewPage.class);
    }

    public boolean isAllColumnDisplayed(){
        List<String> elements = null;
        String value="";
        for (int i=0;i<7;i++){
            value = chromeDriver.findElement(By.xpath("//th["+i+"]")).getText();
            elements.add(value);
            value=null;
        }

        return elements.get(0).equals("District") && elements.get(1).equals("Block") && elements.get(2).equals("School Code")
                && elements.get(3).equals("School Name") && elements.get(4).equals("School Category")  && elements.get(5).equals("School Management")
                && elements.get(6).equals("Status") && elements.get(7).equals("Action");
    }

}
