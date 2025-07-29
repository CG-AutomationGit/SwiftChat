package bot.base;

import botEngine.PageObjectModel;
import bot.botChat.Chat;
import bot.botData.BotData;
import bot.botData.ThreadSafeTestContext;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BotBase extends PageObjectModel {

    public BotBase(ChromeDriver chromeDriver){
        super(chromeDriver);
    }


    public Chat clickOnContinueButton() throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        chromeDriver.findElement(By.xpath("//button//p/p[text()='Continue']")).click();
        return createBotPageForChrome(Chat.class);
    }

    public int getResponseCount(){
        List<WebElement> followingDivs = chromeDriver.findElements(By.xpath(
                "(//div[@style='transform-origin: left top; transform: none;'])[last()]/ancestor::div[2]/following-sibling::div"));
        return followingDivs.size();
    }

    public void validateResponseString(String filepath , String str1 , String str2) throws IOException {
        if(getResponseCount()==2){
            String expectedString1 = getCellValueFromExcel(filepath,"String Mapping for v1", str1, "English Strings");
            String expectedString2 = getCellValueFromExcel(filepath,"String Mapping for v1", str2, "English Strings");

            String safeExpected1 = processExpectedString(expectedString1);
            String safeExpected2 = processExpectedString(expectedString2);

            String actualString1 = getFirstStringAfterInput(str1);

            if(actualString1.equals(str1)){
                Assert.assertEquals(actualString1, str1, "String validation failed for first string.");

                List<String> ext =  extractBoldSegments(safeExpected2);
                String actualString2 = getSecondStringAfterInput(str2);

                validateBoldTextInUI(ThreadSafeTestContext.getStringLocator(), ext);

                Assert.assertTrue(areStringsEquivalent(actualString2, safeExpected2.replace("*","")),
                        "String validation failed \n" +
                                "Expected : ["+safeExpected2+"] \n" +
                                "Actual : ["+actualString2+"]");

            }
            else {
                String actualString2 = getSecondStringAfterInput(str2);

                List<String> ext =  extractBoldSegments(safeExpected2);
                validateBoldTextInUI(ThreadSafeTestContext.getStringLocator(), ext);

                Assert.assertTrue(areStringsEquivalent(actualString1, safeExpected1.replace("*","")),
                        "String validation failed \n" +
                                "Expected : ["+safeExpected1+"] \n" +
                                "Actual : ["+actualString1+"]");
                Assert.assertTrue(areStringsEquivalent(actualString2, safeExpected2.replace("*","")),
                        "String validation failed \n" +
                                "Expected : ["+safeExpected2+"] \n" +
                                "Actual : ["+actualString2+"]");
            }
        }
        else {
            Assert.assertEquals(getResponseCount(), 2, "Expected 2 responses but got " + getResponseCount());
        }
    }

    public String getCellValueFromExcel(String filepath , String SheetName, String StringID, String coumnName) throws IOException, IOException {
        //String filePath = "C:\\Users\\gandi\\Downloads\\SwiftChat (3)\\SwiftChat\\Testdata\\strings.xlsx";
        String langString="";
        FileInputStream fis = new FileInputStream(filepath);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet(SheetName);

        Cell stringIDCell =null; // Column B (index 1)
        Cell lanString  =null;

        for (Row row : sheet) {
            if (row.getRowNum() == 0)
                continue; // Skip header

                  switch (ThreadSafeTestContext.getBotName()) {
                      case "ATTENDANCE":
                           stringIDCell = row.getCell(0);
                           lanString = row.getCell(7);
                          break;
                      case "NL":
                      case "NS":
                           stringIDCell = row.getCell(0);
                           lanString = row.getCell(9);
                          break;
                  }

            if (stringIDCell != null && StringID.equalsIgnoreCase(stringIDCell.getStringCellValue().trim())){
                if (lanString != null) {
                    langString = lanString.getStringCellValue().trim();
                }
            }
        }
        return langString;
    }

    public void validateResponseString(String filepath , String str1 , String str2 , String str3) throws IOException, InterruptedException {
        if(getResponseCount()==3){
            String actual1 = str1;
            String actual2 = str2;
            String actual3 = str3;
            Thread.sleep(2000);


            String expectedString1="", expectedString2="", expectedString3="";


            if (containsDigit(str1)) {
                expectedString1 = getCellValueFromExcel(filepath, "String Mapping for v1", str1, "English Strings");
            }
            if (containsDigit(str2)) {
                expectedString2 = getCellValueFromExcel(filepath, "String Mapping for v1", str2.replace("_COMP",""), "English Strings");
            }
            if (containsDigit(str3)) {
                expectedString3 = getCellValueFromExcel(filepath, "String Mapping for v1", str3, "English Strings");
            }
            String safeExpected1 = processExpectedString(expectedString1);
            String safeExpected2 = processExpectedString(expectedString2);
            String safeExpected3 = processExpectedString(expectedString3);

            String actualString1 = getFirstStringAfterInput(actual1); // PDF
            Thread.sleep(2000);

            if(str1.equals("GIF") || str1.equals("PDF")) {
                Assert.assertEquals(actualString1, str1, "String validation failed for first string.");
            }
            else {
                List<String> ext =  extractBoldSegments(safeExpected1);
                validateBoldTextInUI(ThreadSafeTestContext.getStringLocator(), ext);
                Assert.assertTrue(areStringsEquivalent(actualString1, safeExpected1.replace("*","")), "String validation failed for first string.");
            }
            String actualString2 = getSecondStringAfterInput(actual2); // GIF
            Thread.sleep(2000);

            if(str2.equals("GIF") || str2.equals("PDF") || str2.equals("VIDEO")) {
                Assert.assertEquals(actualString2, str2, "String validation failed for first string.");
            }
            else {
                List<String> ext =  extractBoldSegments(safeExpected2);  // ext = 0
                validateBoldTextInUI(ThreadSafeTestContext.getStringLocator(), ext);
                Assert.assertTrue(areStringsEquivalent(actualString2, safeExpected2.replace("*","")), "String validation failed for first string.");
            }
            String actualString3 = getThirdStringAfterInput(actual3);   // STRING

            if(str3.equals("GIF") || str3.equals("PDF")) {
                Assert.assertEquals(actualString3, str3, "String validation failed for first string.");
            }
            else {
                List<String> ext =  extractBoldSegments(safeExpected3);
                validateBoldTextInUI(ThreadSafeTestContext.getStringLocator(), ext);
                Assert.assertTrue(areStringsEquivalent(actualString3, safeExpected3.replace("*","")), "String validation failed for first string.");
            }

        }
        else {
            Assert.assertEquals(getResponseCount(), 3, "Expected 3 responses but got " + getResponseCount());
        }
    }

    public static boolean areStringsEquivalent(String actual, String expected) {
        // Remove escaped periods and extra blank lines, trim each line
        String normActual = actual.replaceAll("\\\\.", ".").replaceAll("(?m)^[ \t]*\r?\n", "").trim();
        String normExpected = expected.replaceAll("\\\\.", ".").replaceAll("(?m)^[ \t]*\r?\n", "").trim();
        return normActual.equals(normExpected);
    }
    private boolean containsDigit(String s) {
        return s != null && s.matches(".*\\d.*");
    }

    private String processExpectedString(String expected) {
        if (expected == null) return null;
        String safeExpected = expected;


        if (safeExpected.contains("<teacherCode>"))
            safeExpected = safeExpected.replace("<teacherCode>", BotData.teacherID);
        if (safeExpected.contains("<schoolName>"))
            safeExpected = safeExpected.replace("<schoolName>", BotData.schoolName);
        if (safeExpected.contains("<classNo>"))
            safeExpected = safeExpected.replace("<classNo>", ThreadSafeTestContext.getGrade());
        if (safeExpected.contains("<section>"))
            safeExpected = safeExpected.replace("<section>",ThreadSafeTestContext.getSection());
        if (safeExpected.contains("<schoolCode>"))
            safeExpected = safeExpected.replace("<schoolCode>", BotData.schoolID);
        if (safeExpected.contains("<teacherName>"))
            safeExpected = safeExpected.replace("<teacherName>", BotData.teacherName);
        if (safeExpected.contains("<designation>"))
            safeExpected = safeExpected.replace("<designation>", BotData.teacherDesignation);
        if (safeExpected.contains("<blockName>"))
            safeExpected = safeExpected.replace("<blockName>", BotData.schoolBlock);
        if (safeExpected.contains("<districtName>"))
            safeExpected = safeExpected.replace("<districtName>", BotData.schoolDistrict);
        if (safeExpected.contains("<mediumName>"))
            safeExpected = safeExpected.replace("<mediumName>", ThreadSafeTestContext.getMedium());
        if (safeExpected.contains("<block>"))
            safeExpected = safeExpected.replace("<block>", BotData.schoolBlock);
        if (safeExpected.contains("<district>"))
            safeExpected = safeExpected.replace("<district>", BotData.schoolDistrict);
        return safeExpected;
    }


    public String getFirstStringAfterInput(String msgType) {
        String str = "";
        try {
            if (getResponseCount() == 3) {
                if (msgType.equalsIgnoreCase("GIF")) {
                    WebElement locator = chromeDriver.findElement(By.xpath(
                            "(//div[@style='transform-origin: left top; transform: none;'])[last()-2]" +
                                    "/ancestor::div[2]/following-sibling::div//img[not ( contains(@src,'https://test-kluster-public'))]"));


                   // WebElement imgElement = chromeDriver.findElement(By.cssSelector("img.asset__img"));

                    File actualImageFile = locator.getScreenshotAs(OutputType.FILE);
                    FileUtils.copyFile(actualImageFile, new File("actual.gif"));

                    if (locator != null) {
                        return "GIF";
                    }
                }
                if (msgType.equalsIgnoreCase("PDF")) {
                    WebElement locator = chromeDriver.findElement(By.xpath(
                            "(//div[@style='transform-origin: left top; transform: none;'])[last()-2]/ancestor::div[2]" +
                                    "/following-sibling::div//div[(contains(@class,'document__download'))]"));
                    if (locator != null) {
                        return "PDF";
                    }
                }
                if (containsDigit(msgType)) {

                    str = "";
                    List<WebElement> locator = chromeDriver.findElements(By.xpath(
                            "(//div[@style='transform-origin: left top; transform: none;'])[last()-1]/ancestor::div[2]" +
                                    "/following-sibling::div[last()-1]//div[contains(@style,'width: 100%')]/div[1]//p[@data-testid]"));

                    for (WebElement str1 : locator) {
                        str = str + str1.getText() + "\n";

                    }
                    ThreadSafeTestContext.clearLocator();
                    ThreadSafeTestContext.setStringLocator(locator);
                }
                return str;

            }
            //(//div[@style='transform-origin: left top; transform: none;'])[last()]/ancestor::div[2]/following-sibling::div//div[(contains(@class,'document__download'))]

            if (getResponseCount() == 2) {
                if (msgType.equalsIgnoreCase("GIF")) {
                    WebElement locator = chromeDriver.findElement(By.xpath(
                            "(//div[@style='transform-origin: left top; transform: none;'])[last()-1]" +
                                    "/ancestor::div[2]/following-sibling::div//img[not ( contains(@src,'https://test-kluster-public'))]"));
                    if (locator != null) {
                        return "GIF";
                    }
                }
                if (msgType.equalsIgnoreCase("PDF")) {
                    WebElement locator = chromeDriver.findElement(By.xpath(
                            "(//div[@style='transform-origin: left top; transform: none;'])[last()-1]/ancestor::div[2]" +
                                    "/following-sibling::div//div[(contains(@class,'document__download'))]"));
                    if (locator != null) {
                        return "PDF";
                    }
                }
                if (containsDigit(msgType)) {

                    List<WebElement> locator;
                    try{
                        str = "";
                        locator = chromeDriver.findElements(By.xpath(
                                "(//div[@style='transform-origin: left top; transform: none;'])[last()-1]/ancestor::div[2]" +
                                        "/following-sibling::div[last()-1]//div[contains(@style,'width: 100%')]/div[1]//p[@data-testid]"));


                    } catch (NoSuchElementException e) {
                        locator = chromeDriver.findElements(By.xpath(
                                "(//div[@style='transform-origin: left top; transform: none;'])[last()]/ancestor::div[2]/" +
                                        "following-sibling::div[last()-1]//div[@data-testid='article-body']//p[@data-testid]"));
                    }

                    for (WebElement str1 : locator) {
                        str = str + str1.getText() + "\n";
                    }
                    ThreadSafeTestContext.clearLocator();

                    ThreadSafeTestContext.setStringLocator(locator);
                }
                return str;
            }

            if (getResponseCount() == 1) {
                if (msgType.equalsIgnoreCase("GIF")) {
                    WebElement locator = chromeDriver.findElement(By.xpath(
                            "(//div[@style='transform-origin: left top; transform: none;'])[last()]" +
                                    "/ancestor::div[2]/following-sibling::div//img[not ( contains(@src,'https://test-kluster-public'))]"));
                    if (locator != null) {
                        return "GIF";
                    }
                }
                if (msgType.equalsIgnoreCase("PDF")) {
                    WebElement locator = chromeDriver.findElement(By.xpath(
                            "(//div[@style='transform-origin: left top; transform: none;'])[last()]/ancestor::div[2]" +
                                    "/following-sibling::div//div[(contains(@class,'document__download'))]"));
                    if (locator != null) {
                        return "DOCUMENT";
                    }
                }
                if (containsDigit(msgType)) {

                    str = "";
                    List<WebElement> locator = chromeDriver.findElements(By.xpath(
                            "(//div[@style='transform-origin: left top; transform: none;'])[last()-1]/ancestor::div[2]" +
                                    "/following-sibling::div[last()]//div[contains(@style,'width: 100%')]/div[1]//p[@data-testid]"));

                    for (WebElement str1 : locator) {
                        str = str + str1.getText() + "\n";
                    }
                    ThreadSafeTestContext.setStringLocator(locator);
                }
                return str;

            }

            // Check if the last message is a GIF
/*
        } catch (NoSuchElementException e) {
            Assert.fail("No GIF found in the last message.");
        }

        List<WebElement> name = null;

        if(getResponseCount()==2){
            name =  chromeDriver.findElements(By.xpath(
                    "//div[@class='chat-screen css-hiazq0']/div/div[last()-1]/div/div/div[1]//p[@data-testid]"));

        }
        else if (getResponseCount()==3) {
            name =  chromeDriver.findElements(By.xpath(
                    "//div[@class='chat-screen css-hiazq0']/div/div[last()-2]/div/div/div[1]//p[@data-testid]"));
        }
        else if (getResponseCount()==1) {
            name =  chromeDriver.findElements(By.xpath(
                    "//div[@class='chat-screen css-hiazq0']/div/div[last()]/div/div/div[1]//p[@data-testid]"));
        } else {
            Assert.fail("No response found after sending the message.");
        }

        for(WebElement str1:name)
        {
            str = str+str1.getText()+"\n";
        }

        */
            return "";
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

        public void startOrResumeComponent() {
            // Click on the "Start Form" or "Resume Form" button in the chat
            chromeDriver.findElement(By.xpath(
                    "(//div[@style='transform-origin: left top; transform: none;'])[last()]/ancestor::" +
                            "div[2]/following-sibling::div[last()-1]//div[@data-testid='article-header']/following-sibling::" +
                            "div[2]//button//p/p[contains(text(), 'Start Form') or contains(text(), 'Resume Form')]")).click();
            // Wait for the form to load
            try {
                Thread.sleep(2000); // Adjust the sleep time as needed
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    public void navigateSPA(String route) {
        String script = "window.history.pushState({}, '', '" + route + "');" +
                "window.dispatchEvent(new Event('popstate'));";
        ((JavascriptExecutor) chromeDriver).executeScript(script);
    }

    public void clickOnComponentButton(String buttonName) throws InterruptedException {
        // Click on the "Start Form" or "Resume Form" button in the chat

        Thread.sleep(3000);
        chromeDriver.findElement(By.xpath(
                "(//div[@style='transform-origin: left top; transform: none;'])[last()]/ancestor::" +
                        "div[2]/following-sibling::div[last()-1]//div[@data-testid='article-header']/following-sibling::" +
                        "div[2]//button//p/p[contains(text(), '"+buttonName+"')]")).click();

        // Wait for the form to load
        try {
            Thread.sleep(2000); // Adjust the sleep time as needed
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickOnComponentButton() {
        // Click on the "Start Form" or "Resume Form" button in the chat
        chromeDriver.findElement(By.xpath(
                "(//div[@style='transform-origin: left top; transform: none;'])" +
                        "[last()]/ancestor::div[2]/following-sibling::div[last()-1]//" +
                        "div[@data-testid='article-body']/parent::div/following-sibling::" +
                        "div/button//p/p[text()='Resume Form' or text()='Start Form' or text()='Re-Submit Form']")).click();
        // Wait for the form to load

        try {
            Thread.sleep(2000); // Adjust the sleep time as needed
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

        public String getSecondStringAfterInput(String msgType) {

            String str = "";
            try {
                if (getResponseCount() == 3) {
                    if (msgType.equalsIgnoreCase("GIF")) {
                        WebElement locator = chromeDriver.findElement(By.xpath(
                                "(//div[@style='transform-origin: left top; transform: none;'])[last()-1]" +
                                        "/ancestor::div[2]/following-sibling::div//img[not ( contains(@src,'https://test-kluster-public'))]"));
                        if (locator != null) {
                            return "GIF";
                        }
                    }
                    if (msgType.equalsIgnoreCase("PDF")) {
                        WebElement locator = chromeDriver.findElement(By.xpath(
                                "(//div[@style='transform-origin: left top; transform: none;'])[last()-1]/ancestor::div[2]" +
                                        "/following-sibling::div//div[(contains(@class,'document__download'))]"));
                        if (locator != null) {
                            return "DOCUMENT";
                        }
                    }

                    if (msgType.equalsIgnoreCase("VIDEO")) {
                        WebElement locator = chromeDriver.findElement(By.xpath(
                                "(//div[@style='transform-origin: left top; transform: none;'])[last()]/" +
                                        "ancestor::div[2]/following-sibling::div[last()-1]//div[contains(@class,'video-preview')]"));
                        if (locator != null) {
                            return "VIDEO";
                        }
                    }
                    Thread.sleep(2000);

                    if (containsDigit(msgType) && !msgType.contains("_COMP")) {
                        List<WebElement> locator;
                        System.out.println("Contains Digit: STRING" + msgType);
                            str = "";

                        locator = chromeDriver.findElements(By.xpath(
                                "(//div[@style='transform-origin: left top; transform: none;'])[last()-1]/ancestor::div[2]" +
                                        "/following-sibling::div[last()-1]//div[contains(@style,'width: 100%')]/div[1]//p[@data-testid]"));
                        ThreadSafeTestContext.setStringLocator(locator);

                        for (WebElement str1 : locator) {
                            str = str + str1.getText() + "\n";
                        }
                        ThreadSafeTestContext.clearLocator();
                        ThreadSafeTestContext.setStringLocator(locator);

                    }

                    if (msgType.contains("_COMP")) {
                        System.out.println("Contains _COMP: " + msgType);

                        str = "";
                        List<WebElement> locator = chromeDriver.findElements(By.xpath(
                                "(//div[@style='transform-origin: left top; transform: none;'])[last()]/" +
                                        "ancestor::div[2]/following-sibling::div[last()-1]//div[@data-testid='article-body']/div[2]//p/p[@data-testid]"));

                        if(locator.size()==0){
                            throw new NoSuchElementException("No elements found for the given XPath.");
                        }

                        for (WebElement str1 : locator) {
                            str = str + str1.getText() + "\n";

                        }
                        ThreadSafeTestContext.clearLocator();
                        ThreadSafeTestContext.setStringLocator(locator);

                    }

                }
                //(//div[@style='transform-origin: left top; transform: none;'])[last()]/ancestor::div[2]/following-sibling::div//div[(contains(@class,'document__download'))]

                if (getResponseCount() == 2) {
                    if (msgType.equalsIgnoreCase("GIF")) {
                        WebElement locator = chromeDriver.findElement(By.xpath(
                                "(//div[@style='transform-origin: left top; transform: none;'])[last()]" +
                                        "/ancestor::div[2]/following-sibling::div//img[not ( contains(@src,'https://test-kluster-public'))]"));
                        if (locator != null) {
                            return "GIF";
                        }
                    }
                    if (msgType.equalsIgnoreCase("PDF")) {
                        WebElement locator = chromeDriver.findElement(By.xpath(
                                "(//div[@style='transform-origin: left top; transform: none;'])[last()]/ancestor::div[2]" +
                                        "/following-sibling::div//div[(contains(@class,'document__download'))]"));
                        if (locator != null) {
                            return "DOCUMENT";
                        }
                    }

                    if (containsDigit(msgType) && !msgType.contains("_COMP")) {
                        System.out.println("Contains Digit: " + msgType);
                        str = "";
                        List<WebElement> locator = chromeDriver.findElements(By.xpath(
                                "(//div[@style='transform-origin: left top; transform: none;'])[last()-1]/ancestor::div[2]" +
                                        "/following-sibling::div[last()]//div[contains(@style,'width: 100%')]/div[1]//p[@data-testid]"));

                        if(locator.size()==0){
                            throw new NoSuchElementException("No elements found for the given XPath.");
                        }

                        for (WebElement str1 : locator) {
                            str = str + str1.getText() + "\n";

                        }
                        ThreadSafeTestContext.clearLocator();
                        ThreadSafeTestContext.setStringLocator(locator);

                    }

                    if (msgType.contains("_COMP")) {
                        System.out.println("Contains _COMP: " + msgType);

                        str = "";
                        List<WebElement> locator = chromeDriver.findElements(By.xpath(
                                "(//div[@style='transform-origin: left top; transform: none;'])[last()]/" +
                                        "ancestor::div[2]/following-sibling::div[last()-1]//div[@data-testid='article-body']/div[2]//p/p[@data-testid]"));

                        if(locator.size()==0){
                            throw new NoSuchElementException("No elements found for the given XPath.");
                        }

                        for (WebElement str1 : locator) {
                            str = str + str1.getText() + "\n";

                        }
                        ThreadSafeTestContext.clearLocator();
                        ThreadSafeTestContext.setStringLocator(locator);

                    }
                }
                return str;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
    }

    public void selectValueFromPicklist(String value) {
        // Click on the picklist to open the dropdown
        WebElement picklist = chromeDriver.findElement(By.xpath(
                "//button//p/p[text()='Select a response']"));
        picklist.click();

        // Select the desired value from the dropdown
        WebElement option = chromeDriver.findElement(By.xpath("//div[contains(@class,'modal-box__contents')]" +
                "//p/h1[text()='Select a response']/ancestor::div[2]/following-sibling::div[2]//p/p[text()='" + value + "']"));
        option.click();

    }
    public String getThirdStringAfterInput(String msgType) {
        String str = "";
        try {
            if (getResponseCount() == 3) {
                if (msgType.equalsIgnoreCase("GIF")) {
                    WebElement locator = chromeDriver.findElement(By.xpath(
                            "(//div[@style='transform-origin: left top; transform: none;'])[last()]" +
                                    "/ancestor::div[2]/following-sibling::div//img[not ( contains(@src,'https://test-kluster-public'))]"));
                    if (locator != null) {
                        return "GIF";
                    }
                }
                if (msgType.equalsIgnoreCase("PDF")) {
                    WebElement locator = chromeDriver.findElement(By.xpath(
                            "(//div[@style='transform-origin: left top; transform: none;'])[last()]/ancestor::div[2]" +
                                    "/following-sibling::div//div[(contains(@class,'document__download'))]"));
                    if (locator != null) {
                        return "DOCUMENT";
                    }
                }
                if (containsDigit(msgType)) {

                    str = "";
                    List<WebElement> locator = chromeDriver.findElements(By.xpath(
                            "(//div[@style='transform-origin: left top; transform: none;'])[last()-1]/ancestor::div[2]" +
                                    "/following-sibling::div[last()]//div[contains(@style,'width: 100%')]/div[1]//p[@data-testid]"));

                    for (WebElement str1 : locator) {
                        str = str + str1.getText() + "\n";
                    }
                    ThreadSafeTestContext.setStringLocator(locator);

                }
            }

            return str;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public void validateResponseString(String filepath , String str1) throws IOException {
        if(getResponseCount()==1){
            String string="";
            if(!str1.equals("GIF") || !str1.equals("PDF")) {

                string=str1;
            }
            //areStringsEquivalent(actualString, string);

            String expectedString = getCellValueFromExcel(filepath, "String Mapping for v1", str1, "English String");
            String safeExpected1 = processExpectedString(expectedString);
            List<String> ext =  extractBoldSegments(safeExpected1);
            String actualString = getFirstStringAfterInput(string);

            validateBoldTextInUI(ThreadSafeTestContext.getStringLocator(), ext);
            Assert.assertTrue(areStringsEquivalent(actualString, safeExpected1.replace("*","")), "String validation failed for first string.");
        }
        else {
            Assert.assertEquals(getResponseCount(), 1, "Expected 1 response but got " + getResponseCount());
        }
    }

    public boolean isButtonDisplayed(String buttonName){
        try {
            WebElement button = chromeDriver.findElement(By.xpath(
                    "(//div[@style='transform-origin: left top; transform: none;'])[last()]/ancestor::" +
                            "div[2]/following-sibling::div[last()]//button//p/p[text()='"+buttonName+"']"));
            return button.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public List<String> extractBoldSegments(String text) {
        List<String> boldTexts = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\*(.*?)\\*");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            boldTexts.add(matcher.group(1)); // e.g., "Pen"
        }
        return boldTexts;
    }

    public void validateBoldTextInUI(List<WebElement> actualBoldWords, List<String> expectedBoldWords) {
          int count = 0;
        for (WebElement container : actualBoldWords) {
            try {
                WebElement boldElement = container.findElement(By.xpath(".//strong"));
                if (boldElement.isDisplayed()) {
                    if(expectedBoldWords.isEmpty()) {
                        Assert.fail("More bold texts found in UI than expected. Expected: " + expectedBoldWords);
                    }

                    if (boldElement.getText().equals(expectedBoldWords.get(count))) {
                        count++;
                    }
                    else {
                        Assert.fail("Bold Style Text is displayed in BOT [" + boldElement.getText() + "] \n Total Expected [" + expectedBoldWords + "]" +
                                " OR Please check the Whole String Manually IF FAILED and LOG Defect.");
                    }
                }

            } catch (NoSuchElementException e) {
                System.out.println("Bold text not found in <strong> within container.");
            }
        }
        }

        public void setLanguage(String language) {
            // Click on the language selector
            if(language.equals("english")) {
                language = "English";
            }
            else if(language.equals("hindi")) {
                language = "हिन्दी";
            }
            else if(language.equals("urdu")) {
                language = "Urdu";
            }
            else if(language.equals("gujarati") ) {
                language = "ગુજરાતી";
            }
            else if(language.equals("telugu")) {
                language = "Telugu";
            }
            else if(language.equals("tamil")) {
                language = "Tamil";
            }
            else if(language.equals("kannada")) {
                language = "Kannada";
            }
            else if(language.equals("marathi")) {
                language = "मराठी";
            }
            else if(language.equals("punjabi"))
            {
                language = "ਪੰਜਾਬੀ";
            }
            ThreadSafeTestContext.setMedium(language);
        }
    }

