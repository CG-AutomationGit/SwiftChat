package mis.base;

import botEngine.PageObjectModel;
import org.openqa.selenium.chrome.ChromeDriver;

public class MIS_Base extends PageObjectModel {

    public MIS_Base(ChromeDriver chromeDriver){
        super(chromeDriver);
    }

    public void waitFor() throws InterruptedException {
        Thread.sleep(2000);
    }

}
