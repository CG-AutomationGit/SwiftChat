package base;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.time.Duration;
import java.util.Properties;

public class Engine {

    public AndroidDriver androidDriver ;
    public WebDriver chromeDriver;

    /*public Engine(ChromeDriver chromeDriver){
       this.chromeDriver = chromeDriver;
    }
    public Engine(AndroidDriver androidDriver){
        this.androidDriver = androidDriver;
    }*/
    public void loadProperties(String prop_path , Properties properties){
        try {
            InputStream inputStream = Files.newInputStream(Paths.get(prop_path));
            properties.load(inputStream);
            properties.getProperty("","");
        }
        catch (Exception e){
            System.out.println(e.getMessage());;
        }
    }

    public <Page extends PageObjectModel> Page LaunchAndroidApp(Class<Page> type) throws MalformedURLException, InterruptedException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        File app;
        app = new File("");
        DesiredCapabilities capability = new DesiredCapabilities();
        capability.setCapability("platformName", "Android");
        capability.setCapability("app", app.getAbsolutePath());
        capability.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));
        capability.setCapability("unexpectedAlertBehaviour", UnexpectedAlertBehaviour.ACCEPT);
        capability.setCapability("autoGrantPermissions", true);
        capability.setCapability("deviceName", "");
        capability.setCapability("udid", "");
        capability.setCapability("automationName", "UiAutomator2");
        /*capability.setCapability("appPackage" , "");
        capability.setCapability("appActivity" , "");*/
        androidDriver = new AndroidDriver(new URL("http://127.0.0.1:4700/wd/hub"), capability);
        Thread.sleep(5000);
        Page ret = null;
        ret = type.getDeclaredConstructor(AndroidDriver.class).newInstance(this.androidDriver);
        return ret;
    }

    public <Page extends PageObjectModel> Page launchChrome(Class<Page> type ) throws MalformedURLException, InterruptedException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, InvalidKeyException {
        String path="C:\\chromeDriver\\131 \\chromedriver.exe";
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver",path);
        chromeDriver = new ChromeDriver(options);
        chromeDriver.get("https://pfms-test.gujaratvsk.org/");
        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        chromeDriver.manage().window().maximize();
        Thread.sleep(5000);
        Page ret = null;
        ret = type.getDeclaredConstructor(ChromeDriver.class).newInstance(this.chromeDriver);
        return ret;
    }

    public <Page extends PageObjectModel> Page launchChromeForMIS(Class<Page> type ) throws MalformedURLException, InterruptedException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, InvalidKeyException {
        String path="C:\\chromeDriver\\135\\chromedriver\\chromedriver\\chromedriver.exe";
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--force-device-scale-factor=0.80");
        System.setProperty("webdriver.chrome.driver",path);
        chromeDriver = new ChromeDriver(options);
        chromeDriver.get("http://rms-qa.convegenius.live.s3-website.ap-south-1.amazonaws.com/login");
        chromeDriver.manage().window().maximize();
      /*  ((JavascriptExecutor) chromeDriver).executeScript("document.body.style.zoom='67%';");
        chromeDriver.navigate().refresh();*/
        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(5000);
        Page ret = null;
        ret = type.getDeclaredConstructor(ChromeDriver.class).newInstance(this.chromeDriver);
        return ret;
    }


}
