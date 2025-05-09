package MIS.commontest;

import mis.base.MIS_Base;
import mis.comon.LoginPage;
import mis.comon.sidebar.SM_Sidebar;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.security.InvalidKeyException;

public class SideBarTest extends MIS_Base {

    LoginPage loginPage;
    SM_Sidebar sidebar;
    public SideBarTest() {
        super(null);
    }

    @BeforeTest
    public void openChrome() throws MalformedURLException, InvalidKeyException, InterruptedException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        sidebar = launchChrome(SM_Sidebar.class);
    }

    // Adding test methods using @Test annotation
    @Test
    public void testAllSidebarDisplayed() {
        Assert.assertTrue(sidebar.areAllSidebarMenusDisplayed(),
                "All Menus are not displayed");
    }

    @Test
    public void testByClickingSchoolProfile() {
        sidebar.clickSidebarMenuByText("School Profile");
    }
    @Test
    public void testByClickingInfrastructureManagement() {
        sidebar.clickSidebarMenuByText("Infrastructure Management");
    }
    @Test
    public void testByClickingBlockManag() {
        sidebar.clickSidebarMenuByText("Block Management");
    }
    @Test
    public void testByClickingDistrictManagement() {
        sidebar.clickSidebarMenuByText("District Management");
    }
    @Test
    public void testByClickingStudentManagement() {
        sidebar.clickSidebarMenuByText("Student Management");
    }

    
    

}
