package mis.comon.sidebar;

import mis.base.MIS_Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SM_Sidebar extends MIS_Base {
    private ChromeDriver chromeDriver;

    @FindBy(xpath = "//ul[@class='sidebar-menu']//li")
    private List<WebElement> sidebarMenus;

    public SM_Sidebar(ChromeDriver chromeDriver) {
        super(chromeDriver);
    }

    /**
     * Clicks on a sidebar menu item by its visible text.
     *
     * @param menuText Visible text of the menu to click.
     */
    public void clickSidebarMenuByText(String menuText) {
        WebElement menuItem = chromeDriver.findElement(
                By.xpath("//ul[@class='sidebar-menu']//li[.//span[text()='" + menuText + "']]"));
        if (menuItem.isDisplayed() && menuItem.isEnabled()) {
            menuItem.click();
        }
    }

    /**
     * Checks if all sidebar menus are displayed.
     *
     * @return true if all sidebar menus are displayed, false otherwise.
     */
    public boolean areAllSidebarMenusDisplayed() {
        if (sidebarMenus == null || sidebarMenus.isEmpty()) {
            return false;
        }
        for (WebElement menu : sidebarMenus) {
            if (!menu.isDisplayed()) {
                return false;
            }
        }
        return true;
    }


    /**
     * Gets the count of available sidebar menus.
     *
     * @return The number of sidebar menus.
     */
    public int getSidebarMenuCount() {
        return sidebarMenus.size();
    }
}