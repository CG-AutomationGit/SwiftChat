package bot.botChat;

import bot.base.BotBase;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.lang.reflect.InvocationTargetException;

public class BotList extends BotBase {
    public BotList(ChromeDriver chromeDriver) {
        super(chromeDriver);
    }


    public Chat selectBotFromList(String botName) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        // Locate the bot element from the list based on its name
        By botElementLocator = By.xpath("//div[contains(@class, 'bot-list-item') and text()='" + botName + "']");
        chromeDriver.findElement(botElementLocator).click();

        // Return an instance of Chat for the selected bot
        return createBotPageForChrome(Chat.class);
    }
}
