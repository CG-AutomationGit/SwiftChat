package MIS.stateAdmin;

import mis.base.MIS_Base;
import mis.comon.LoginPage;
import mis.stateAdmin.pages.SA_CreateNewPage;
import mis.stateAdmin.pages.SA_UserManagementPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.security.InvalidKeyException;

public class MIS_SA_CreateNewUserTest extends MIS_Base {

    public MIS_SA_CreateNewUserTest(){
        super(null);
    }

    Sidebar sidebar;
    LoginPage loginPage;
    SA_UserManagementPage saUserManagementPage;
    SA_CreateNewPage saCreateNewPage;

    @BeforeTest(alwaysRun = true)
    public void step1_openChrome() throws MalformedURLException, InvalidKeyException, InterruptedException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        loginPage = launchChromeForMIS(LoginPage.class);
    }

    @Test( priority = 1)
    public void step1_loginByBlock() throws MalformedURLException, InvalidKeyException, InterruptedException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        sidebar = loginPage.stateLogin();
    }

    @Test( priority = 2)
    public void step2_selectUserManagement() throws MalformedURLException, InvalidKeyException, InterruptedException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        saUserManagementPage = sidebar.selectUserManagementSidebar();
    }

    @Test( priority = 3)
    public void step3_addNewUser() throws MalformedURLException, InvalidKeyException, InterruptedException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {

        if(saUserManagementPage.isRecordAvailableBySearch("MANDI" , "DRANG-1" , "GCPS BHARARU")){
            saUserManagementPage.deleteRecord("");
        }
        saCreateNewPage = saUserManagementPage.clickOnNewUserButton();
        saCreateNewPage.createNewUser("MANDI" , "DRANG-1" , "GCPS BHARARU", "GPS DIGLI", "test@Email.com");
    }
}
