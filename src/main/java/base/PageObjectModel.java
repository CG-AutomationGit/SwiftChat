package base;

import bot.base.BotBase;
import io.appium.java_client.android.AndroidDriver;
import mis.base.MIS_Base;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pfms.base.PFMSBase;

import java.lang.reflect.InvocationTargetException;
import java.time.Duration;
import java.util.Calendar;

public class PageObjectModel extends Engine{

    public PageObjectModel(AndroidDriver driver){
        this.androidDriver = driver;
    }
    public PageObjectModel(ChromeDriver chromeDriver){
        this.chromeDriver = chromeDriver;
    }
    public PageObjectModel(){
        super();
    }
    public  <Page extends BotBase> Page createBotPageForAndroid(Class<Page> type) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Page ret = null;
        ret = type.getDeclaredConstructor(AndroidDriver.class).newInstance(this.androidDriver);
        return ret;
    }
    public  <Page extends BotBase> Page createBotPageForChrome(Class<Page> type) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Page ret = null;
        ret = type.getDeclaredConstructor(ChromeDriver.class).newInstance(this.chromeDriver);
        return ret;
    }
    public  <Page extends PFMSBase> Page createPFMSPageForAndroid(Class<Page> type) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Page ret = null;
        ret = type.getDeclaredConstructor(AndroidDriver.class).newInstance(this.androidDriver);
        return ret;
    }

    public void myState(){

        int x= 10;
        myState();





    }

    public  <Page extends PFMSBase> Page createPFMSPageForChrome(Class<Page> type) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Page ret = null;
        ret = type.getDeclaredConstructor(ChromeDriver.class).newInstance(this.chromeDriver);
        return ret;
    }

    public  <Page extends PageObjectModel> Page createMISPageForChrome(Class<Page> type) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Page ret = null;
        ret = type.getDeclaredConstructor(ChromeDriver.class).newInstance(this.chromeDriver);
        return ret;
    }


    public void log(String log){
        System.err.println(Calendar.getInstance().getTime()+" : "+log);
    }

    public void waitFor(int second){
        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(second));
    }
    public void waitForLoading(int min) throws InterruptedException {
        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(chromeDriver,Duration.ofMinutes(min));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li/button[text()='First Time Verification']"))).isEnabled();
    }

    public void zoomOut(){
        JavascriptExecutor js = (JavascriptExecutor) chromeDriver;
        js.executeScript("document.body.style.zoom = '70%'");
    }
}
