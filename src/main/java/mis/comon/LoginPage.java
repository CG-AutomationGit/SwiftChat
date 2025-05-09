package mis.comon;

import mis.base.MIS_Base;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.lang.reflect.InvocationTargetException;

public class LoginPage extends MIS_Base {

    public LoginPage(ChromeDriver chromeDriver){
        super(chromeDriver);
    }

   public SM_SideMenuPage stateLogin() throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
       chromeDriver.findElement(By.id("username")).sendKeys("state_admin");
           chromeDriver.findElement(By.id("password")).sendKeys("Mis@123456");
       chromeDriver.findElement(By.xpath("//button[text()='Login']")).click();
       return createMISPageForChrome(SM_SideMenuPage.class);
   }

}
