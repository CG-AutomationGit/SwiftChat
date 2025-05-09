package pfms;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import pfms.base.PFMSBase;

import java.lang.reflect.InvocationTargetException;

public class PFMS_LoginPage extends PFMSBase {

    public PFMS_LoginPage(ChromeDriver chromeDriver){
      super(chromeDriver);
    }

    String userName , password;

    public <Page extends PFMSBase> Page login(String userName , String password , Class<Page> type) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        chromeDriver.findElement(By.xpath("//input[@id='email']")).sendKeys(userName);
        chromeDriver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
        chromeDriver.findElement(By.xpath("//button[text()='Login']")).click();

        return createPFMSPageForChrome(type);
    }
}
