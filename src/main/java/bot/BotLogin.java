package bot;

import bot.base.BotBase;
import bot.botChat.BotList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.lang.reflect.InvocationTargetException;
import java.time.Duration;

public class BotLogin extends BotBase {
    public BotLogin(ChromeDriver chromeDriver) {
        super(chromeDriver);
        PageFactory.initElements(chromeDriver, this);
    }


    @FindBy(id = "mui-1")
    WebElement mobileNumberInput;
    @FindBy(xpath = "//button/p[text()='Send OTP']")
    WebElement sendOTPButton;
//button//p/p[text()='Continue']

    public BotList loginWithMobileNumber(String mobileNumber) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        try {
            // Enter the mobile number
            mobileNumberInput.clear(); // Clear the input field in case it contains default text.
            mobileNumberInput.sendKeys(mobileNumber);

            // Click the "Send OTP" button
            sendOTPButton.click();

            System.out.println("Login successful: OTP has been sent to " + mobileNumber);
        } catch (Exception e) {
            Assert.fail("Failed to login using mobile number: " + e.getMessage());
        }
        return createBotPageForChrome(BotList.class);
    }
}
