package mis.base;

import base.PageObjectModel;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.lang.reflect.InvocationTargetException;

public class MIS_Base extends PageObjectModel {

    public MIS_Base(ChromeDriver chromeDriver){
        super(chromeDriver);
    }

    public void waitFor() throws InterruptedException {
        Thread.sleep(2000);
    }

}
