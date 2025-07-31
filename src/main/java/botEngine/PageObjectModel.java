package botEngine;

import bot.base.BotBase;
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


    public PageObjectModel(ChromeDriver chromeDriver){
        this.chromeDriver = chromeDriver;
    }
    public PageObjectModel(){
        super();
    }

    public  <Page extends BotBase > Page createBotPageForChrome(Class<Page> type) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Page ret = null;
        ret = type.getDeclaredConstructor(ChromeDriver.class).newInstance(this.chromeDriver);
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

    public void waitFixTime() throws InterruptedException {
        Thread.sleep(7000);
    }

    public void waitFixTimeForUploadImage() throws InterruptedException {
        Thread.sleep(20000);
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

    public void scrollToBottom() {
        System.out.println("Scrolling down to the bottom of the page...");
        ((org.openqa.selenium.JavascriptExecutor) chromeDriver)
                .executeScript("window.scrollTo(0, document.body.scrollHeight);");
        System.out.println("Scroll down completed.");
    }

    // Java
    public void scrollToTop() throws InterruptedException {
        System.out.println("Scrolling up to the top of the page...");
        Thread.sleep(1000);
        ((org.openqa.selenium.JavascriptExecutor) chromeDriver)
                .executeScript("window.scrollBy(0, 0);");
        Thread.sleep(1000);
        System.out.println("Scroll up completed..");
    }

    // Java
    public void scrollToTopByUpKey() throws InterruptedException {
        System.out.println("Scrolling up to the top of the page using UP key...");
        Actions actions = new Actions(chromeDriver);
        for (int i = 0; i < 50; i++) { // Adjust the number as needed
            actions.sendKeys(Keys.ARROW_UP).perform();
            Thread.sleep(100); // Small delay between key presses
        }
        System.out.println("Scroll up completed.");
    }

    public void scrollToDownByDownKey(int step) throws InterruptedException {
        System.out.println("Scrolling up to the top of the page using UP key...");
        Actions actions = new Actions(chromeDriver);
        for (int i = 0; i < step; i++) { // Adjust the number as needed
            actions.sendKeys(Keys.ARROW_DOWN).perform();
            Thread.sleep(100); // Small delay between key presses
        }
        System.out.println("Scroll up completed.");
    }

    // Java
    public void scrollToText(String text) {
        System.out.println("Scrolling to the element containing text: " + text);
        try {
            By locator = By.xpath("//*[text()='" + text + "']");
            org.openqa.selenium.WebElement element = chromeDriver.findElement(locator);
            ((org.openqa.selenium.JavascriptExecutor) chromeDriver)
                    .executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
            System.out.println("Scrolled to the element containing text: " + text);
        } catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println("Element with text '" + text + "' not found.");
        }
    }
}
