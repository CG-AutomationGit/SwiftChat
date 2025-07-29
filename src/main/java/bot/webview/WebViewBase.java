package bot.webview;

import bot.base.BotBase;
import bot.botChat.Chat;
import botEngine.PageObjectModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.NoSuchElementException;

public class WebViewBase extends Chat {

    WebElement tabNameActual;
    public WebViewBase(ChromeDriver chromeDriver){
        super(chromeDriver);
    }

    public void validateTabName(String tabName) {
        try {
            tabNameActual = chromeDriver.findElement(
                    By.xpath("//div[@data-toggle='buttons']/span[text()='" + tabName + "']"));
            if(tabNameActual == null) {
                Assert.fail("Tab with name '" + tabName + "' not found..");
            }
        } catch (NoSuchElementException e) {
            Assert.fail("Tab with name '" + tabName + "' not found. Please check manually");
        }

    }

    public void validateTabName(String tabName1 , String tabName2) {
        try {
            tabNameActual = chromeDriver.findElement(
                    By.xpath("//div[@data-toggle='buttons']/span[text()='" + tabName1 + "' and text()='" + tabName2 + "']"));
            if(tabNameActual == null) {
                Assert.fail("Tab with name '" + tabName1 + "' and "+tabName2+" not found.");
            }
        } catch (NoSuchElementException e) {
            Assert.fail("Tab with name '" + tabName1 + "' and "+tabName2+"  not found. Please check manually");
        }
        }

    public void validateSelectedTab(String tabName) {
        clickOnTab(tabName);

        try {
            tabNameActual = chromeDriver.findElement(
                    By.xpath("//div[@data-toggle='buttons']/span[@class='btn border  btn-primary " +
                            "border-primary active' and text()='" + tabName + "']"));
            if (tabNameActual == null) {
                Assert.fail("Tab with name '" + tabName + "' is not selected with blue colour or default.");
            }
        } catch (NoSuchElementException e) {
            Assert.fail("Tab with name '" + tabName + "' is not selected. Please check manually");
        }
    }

    public void switchToWebview() {
        try {
            chromeDriver.switchTo().frame(0);
        } catch (NoSuchElementException e) {
            Assert.fail("Web view frame not found. Please check manually.");
        }
    }

    public void clickOnTab(String tabName) {
        try {

            waitFor(5);
            Thread.sleep(3000);
            waitForUpdateStudentDetails();
            WebElement tab = chromeDriver.findElement(
                    By.xpath("//div[@data-toggle='buttons']/span[text()='" + tabName + "']"));
            Thread.sleep(3000);
            tab.click();
        } catch (NoSuchElementException | InterruptedException e) {
            Assert.fail("Tab with name '" + tabName + "' not found. Please check manually");
        }
    }
    // Java
    public WebElement waitForUpdateStudentDetails() {
        WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(20));
        By locator = By.xpath("//div[@data-toggle='buttons']/span[text()='Update Student Details']");
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void closeWebView() {
        try {
            chromeDriver.close();
            chromeDriver.switchTo().defaultContent();
        } catch (Exception e) {
            Assert.fail("Failed to close the web view. Please check manually.");
        }
    }


}
