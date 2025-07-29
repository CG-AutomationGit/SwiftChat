package bot.botChat;

import bot.base.BotBase;
import bot.botData.FilesPath;
import bot.botData.ThreadSafeTestContext;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import utility.LangMapper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class Chat extends BotBase implements FilesPath {
    public Chat(ChromeDriver chromeDriver) {
        super(chromeDriver);
    }

    public void sendMessage(String message) throws InterruptedException {
        chromeDriver.findElement(By.xpath("//textarea[@id='footer']")).sendKeys(message);
        chromeDriver.findElement(By.xpath("//button[@class='MuiButtonBase-root MuiIconButton-root " +
                "MuiIconButton-sizeMedium chat-footer__send-button css-1yxmbwk']")).click();
        Thread.sleep(2000);
        if (message.length() == 11 && message.matches("\\d+")) {
            ThreadSafeTestContext.setSchoolCode(message);

        }
    }

    public void sendFile() {

    }


   public void validateResponseStringForNamoLaxmi(String str1 , String str2) throws IOException, InterruptedException {
       validateResponseString(filePathForNL ,str1, str2);
       Thread.sleep(2000);

       Select select = new Select(chromeDriver.findElement(By.xpath("")));
       select.selectByVisibleText("8 AM");
       String selected = select.getFirstSelectedOption().getText();
   }
    public void validateResponseStringForNamoLaxmi(String str1 , String str2 , String str3) throws IOException, InterruptedException {
        validateResponseString(filePathForNL ,str1, str2, str3);
        Thread.sleep(2000);

    }
    public void validateResponseStringForNamoLaxmi(String str1) throws IOException, InterruptedException {
        validateResponseString(filePathForNL ,str1);
        Thread.sleep(2000);
    }

    public void validateResponseStringForNamoSaraswati(String str1 , String str2) throws IOException {
        validateResponseString(filePathForNS ,str1, str2);
    }
    public void validateResponseStringForNamoSaraswati(String str1 , String str2 , String str3) throws IOException, InterruptedException {
        validateResponseString(filePathForNS ,str1, str2, str3);
    }
    public void validateResponseStringForNamoSaraswati(String str1) throws IOException {
        validateResponseString(filePathForNS ,str1);
    }

    public void validateResponseStringForGSQAC(String str1 , String str2) throws IOException {
        validateResponseString(filePathForGSQAC ,str1, str2);
    }
    public void validateResponseStringForGSQAC(String str1 , String str2 , String str3) throws IOException, InterruptedException {
        validateResponseString(filePathForGSQAC ,str1, str2, str3);
    }
    public void validateResponseStringForGSQAC(String str1) throws IOException {
        validateResponseString(filePathForGSQAC ,str1);
    }
    public void validateResponseStringForFMB(String str1 , String str2) throws IOException {
        validateResponseString(filePathFMB ,str1, str2);
    }
    public void validateResponseStringForFMB(String str1 , String str2 , String str3) throws IOException, InterruptedException {
        validateResponseString(filePathFMB ,str1, str2, str3);
    }
    public void validateResponseStringForFMB(String str1) throws IOException {
        validateResponseString(filePathFMB ,str1);
    }
    public void validateResponseStringForORF(String str1 , String str2) throws IOException {
        validateResponseString(filePathForORF ,str1, str2);
    }
    public void validateResponseStringForORF(String str1 , String str2 , String str3) throws IOException, InterruptedException {
        validateResponseString(filePathForORF ,str1, str2, str3);
    }
    public void validateResponseStringForORF(String str1) throws IOException {
        validateResponseString(filePathForORF ,str1);
    }

    public void validateResponseStringForFBA(String str1 , String str2) throws IOException {
        validateResponseString(filePathForFMB ,str1, str2);
    }
    public void validateResponseStringForFBA(String str1 , String str2 , String str3) throws IOException, InterruptedException {
        validateResponseString(filePathForFMB ,str1, str2, str3);
    }
    public void validateResponseStringForFBA(String str1) throws IOException {
        validateResponseString(filePathForFMB ,str1);
    }

    public void ignoreHint() throws InterruptedException {

        try{
            chromeDriver.findElement(By.xpath("//p[text()='Got it']")).click();

        waitFor(3);
        chromeDriver.findElement(By.xpath("//p[text()='Got it']")).click();
        waitFor(3);
        chromeDriver.findElement(By.xpath("//p[text()='Got it']")).click();
        waitFor(3);
        Thread.sleep(3000);
        chromeDriver.findElement(By.xpath("//p[text()='Got it']")).click();
            Thread.sleep(2000);

        }catch (Exception e) {
            System.out.println("No hint to ignore");
        }
    }

    public void selectClassAndSectionForNamoBots() throws InterruptedException {
        List<WebElement> classes = chromeDriver.findElements(By.xpath(
                "//div/button[contains(@class,'MuiButton-outlinedSizeMedium')]//p/p[contains(text(),'Class')]"));
        List<WebElement> section ;
         if (classes.size() ==0) {
            Assert.fail("No classes found to select. Please ensure the chat is in the " +
                    "correct state to select class and section");
        }
         int y=0;
        if (classes.size() == 4) {
            for (int i = 0; i < classes.size(); i++) {
                Thread.sleep(2000);
                classes = chromeDriver.findElements(By.xpath("//div/button[contains(@class,'MuiButton-outlinedSizeMedium')]//p/p[contains(text(),'Class')]"));
                ignoreHint();
                 if (classes.get(i).getText().contains("(0")) {
                    System.out.println("Skipping class with 0 students: " + classes.get(i).getText());
                    continue;
                }
                else if (classes.get(i).getText().matches("Class \\d+ \\(\\d+/\\d+\\)")) {
                    Thread.sleep(2000);
                    String className = classes.get(i).getText().replaceAll("\\s*\\(.*?\\)", "").trim().replace("Class", "");
                     classes.get(i).click();
                    Thread.sleep(2000);
                    ThreadSafeTestContext.setGrade(className.trim());
                    ignoreHint();
                    if(isButtonDisplayed("Continue")) {
                        ThreadSafeTestContext.setSection("A");
                        break;
                    }


                 } else if (!classes.get(i).getText().contains("(")) {
                     Thread.sleep(2000);
                     ThreadSafeTestContext.setGrade(classes.get(i).getText().replace("Class", "").trim());
                     classes.get(i).click();
                     Thread.sleep(2000);
                     section = chromeDriver.findElements(By.xpath(
                             "//div/button[contains(@class,'MuiButton-outlinedSizeMedium')]//p/p[contains(text(),'(') or contains(text(),'/')]"));
                    int count = 0;
                    if (!section.isEmpty()) {
                        for (WebElement sectionElement : section) {
                            Thread.sleep(2000);
                            if (sectionElement.getText().contains("(0")) {
                                System.out.println("Skipping section with 0 students: " + sectionElement.getText());
                                count++;
                                continue;
                            }
                            if (sectionElement.getText().matches("[A-Z] \\(\\d+/\\d+\\)")) {
                                String sectionName = sectionElement.getText().replaceAll("\\s*\\(.*?\\)", "").trim().replace("Section", "");
                                sectionElement.click();
                                Thread.sleep(2000);
                                ThreadSafeTestContext.setSection(sectionName);
                                System.out.println("section: " + sectionName);
                                y=1;
                                break;

                            } else {
                                System.out.println("Skipping invalid section: " + sectionElement.getText());
                            }
                        }
                        if (y==1){
                            break;
                        }
                        if( count == section.size()) {
                            System.out.println("No valid sections found for selected class: ");
                            Thread.sleep(2000);
                            System.out.println("Clicking random button to retry class selection...");
                            ignoreHint();
                            clickRandomButton();
                            Thread.sleep(2000);
                            ignoreHint();
                            System.out.println("No valid sections found, retrying class selection...");
                            selectButtonOptionFromChat("Change Class");
                        }
                    } else {
                        System.out.println("No sections found for class: ");

                    }
                }
            }
        }
        int y1=0;
        if(ThreadSafeTestContext.getBotName().equals("NS")){
         if (classes.size() ==2) {
             for (int i = 0; i < classes.size(); i++) {
                 Thread.sleep(2000);
                 classes = chromeDriver.findElements(By.xpath("//div/button[contains(@class,'MuiButton-outlinedSizeMedium')]//p/p[contains(text(),'Class')]"));
                 ignoreHint();
                 if (classes.get(i).getText().contains("(0")) {
                     System.out.println("Skipping class with 0 students: " + classes.get(i).getText());
                     continue;
                 }
                 else if (classes.get(i).getText().matches("Class \\d+ \\(\\d+/\\d+\\)")) {
                     Thread.sleep(2000);
                     String className = classes.get(i).getText().replaceAll("\\s*\\(.*?\\)", "").trim().replace("Class", "");
                     classes.get(i).click();
                     Thread.sleep(2000);
                     ThreadSafeTestContext.setGrade(className.trim());
                     ignoreHint();
                     if(isButtonDisplayed("Continue")) {
                         ThreadSafeTestContext.setSection("A");
                         break;
                     }


                 } else if (!classes.get(i).getText().contains("(")) {
                     Thread.sleep(2000);
                        ThreadSafeTestContext.setGrade(classes.get(i).getText().replace("Class", "").trim());
                     classes.get(i).click();
                     Thread.sleep(2000);
                     section = chromeDriver.findElements(By.xpath(
                             "//div/button[contains(@class,'MuiButton-outlinedSizeMedium')]//p/p[contains(text(),'(') or contains(text(),'/')]"));
                     int count = 0;
                     if (!section.isEmpty()) {
                         for (WebElement sectionElement : section) {
                             Thread.sleep(2000);
                             if (sectionElement.getText().contains("(0")) {
                                 System.out.println("Skipping section with 0 students: " + sectionElement.getText());
                                 count++;
                                 continue;
                             }
                             if (sectionElement.getText().matches("[A-Z] \\(\\d+/\\d+\\)")) {
                                 String sectionName = sectionElement.getText().replaceAll("\\s*\\(.*?\\)", "").trim().replace("Section", "");
                                 ThreadSafeTestContext.setSection(sectionName);
                                 sectionElement.click();
                                 Thread.sleep(2000);
                                 System.out.println("section: " + sectionName);
                                 y1=1;
                                 break;


                             } else {
                                 System.out.println("Skipping invalid section: " + sectionElement.getText());
                             }
                         }
                         if (y1==1){
                                break;
                         }
                         if( count == section.size()) {
                             System.out.println("No valid sections found for selected class: ");
                             Thread.sleep(2000);
                             System.out.println("Clicking random button to retry class selection...");
                             ignoreHint();
                             clickRandomButton();
                             Thread.sleep(2000);
                             ignoreHint();
                             System.out.println("No valid sections found, retrying class selection...");
                             selectButtonOptionFromChat("Change Class");
                         }
                     } else {
                         System.out.println("No sections found for class: ");

                     }
                 }
             }
          }
         else {
            Assert.fail("For Namo Saraswati, there should be 2 classes to select. " +
                    "Please ensure the chat is in the correct state to select class and section");
         }
        }

    }


    public void selectClassAndSection() throws InterruptedException {
        List<WebElement> classes;
        int fool = 0;
        try {
            WebElement res = chromeDriver.findElement(By.xpath("//div[@class='chat-screen css-hiazq0']/div/div[last()]/div//button//p/p[text()='Select a response']"));
            if (res.isDisplayed()) {
                fool = 1;
                res.click();

                classes = chromeDriver.findElements(By.xpath("//div[@class='modal-box__contents MuiBox-root css-0']//p/p[text()]"));

                for (WebElement classElement : classes) {
                    if (classElement.getText().matches("Class \\d+") || classElement.getText().matches("Balvatika \\d+")) {
                        ThreadSafeTestContext.setGrade(classElement.getText().replace("Class", "").trim());
                        classElement.click();
                        Thread.sleep(2000);
                        ignoreHint();
                        break;
                    }
                }

                List<WebElement> section = chromeDriver.findElements(By.xpath(
                        "//div/button[contains(@class,'MuiButton-outlinedSizeMedium')]//p/p[contains(text(),'A') or contains(text(),'B') or contains(text(),'C') or contains(text(),'D') or contains(text(),'E') or contains(text(),'F') or contains(text(),'G') or contains(text(),'H') or contains(text(),'I') or contains(text(),'J') or contains(text(),'K') or contains(text(),'L')]"));
                if(section.isEmpty()) {
                }
                else {
                    for (WebElement sectionElement : section) {
                        Thread.sleep(2000);
                        if (sectionElement.getText().matches("[A-Z]")) {
                            String sectionName = sectionElement.getText().replaceAll("\\s*\\(.*?\\)", "").trim().replace("Section", "");
                            ThreadSafeTestContext.setSection(sectionName);
                            sectionElement.click();
                            Thread.sleep(2000);

                            System.out.println("section: " + sectionName);
                            break;
                        } else {
                            Assert.fail("No valid sections found for selected class: " + sectionElement.getText());
                        }
                    }
                }
            }

        } catch (NoSuchElementException e) {
                 Assert.fail("No response button found to select class and section. " +
                        "Please ensure the chat is in the correct state to select class and section.");
        }
        ignoreHint();

        if(fool == 0) {

        classes = chromeDriver.findElements(By.xpath(
                "(//div[@style='transform-origin: left top; transform: none;'])[last()]/ancestor::div[2]/" +
                        "following-sibling::div/div//button//p/p[contains(text(),'Class') or contains(text(),'Balvatika')]"));

        Thread.sleep(2000);

            for (WebElement classElement : classes) {
                if (classElement.getText().matches("Class \\d+") || classElement.getText().matches("Balvatika \\d+")) {
                    ThreadSafeTestContext.setGrade(classElement.getText().replace("Class", "").trim());
                    classElement.click();
                    Thread.sleep(2000);
                    ignoreHint();
                    break;
                }
            }

            List<WebElement> section = chromeDriver.findElements(By.xpath(
                    "//div/button[contains(@class,'MuiButton-outlinedSizeMedium')]//p/p[contains(text(),'A') or contains(text(),'B') or contains(text(),'C') or contains(text(),'D') or contains(text(),'E') or contains(text(),'F') or contains(text(),'G') or contains(text(),'H') or contains(text(),'I') or contains(text(),'J') or contains(text(),'K') or contains(text(),'L')]"));
            for (WebElement sectionElement : section) {
                Thread.sleep(2000);
                if (sectionElement.getText().matches("[A-Z] \\(\\d+/\\d+\\)")) {
                    String sectionName = sectionElement.getText().replaceAll("\\s*\\(.*?\\)", "").trim().replace("Section", "");
                    ThreadSafeTestContext.setSection(sectionName);
                    sectionElement.click();
                    Thread.sleep(2000);

                    System.out.println("section: " + sectionName);
                    break;
                } else {
                    Assert.fail("No valid sections found for selected class: " + sectionElement.getText());
                }
            }
        }
    }


    public void selectClassAndSectionRandomly() throws InterruptedException {
        List<WebElement> classes;
        int fool = 0;
        try {
            List<WebElement> res = chromeDriver.findElements(By.xpath("//div[@class='chat-screen css-hiazq0']/div/div[last()]/div//button//p/p[text()='Select a response']"));
            if (!res.isEmpty()) {
                fool = 1;
                res.getFirst().click();

                classes = chromeDriver.findElements(By.xpath("//div[@class='modal-box__contents MuiBox-root css-0']//p/p[text()]"));
                if (!classes.isEmpty()) {
                    int randomClassIndex = (int) (Math.random() * classes.size());
                    WebElement classElement = classes.get(randomClassIndex);
                    ThreadSafeTestContext.setGrade(classElement.getText().replace("Class", "").trim());
                    classElement.click();
                    Thread.sleep(2000);
                    ignoreHint();
                }

                List<WebElement> section = chromeDriver.findElements(By.xpath(
                        "//div/button[contains(@class,'MuiButton-outlinedSizeMedium')]//p/p"
                ));
                for (WebElement sectionElement : section) {
                    String text = sectionElement.getText().trim();
                    Thread.sleep(2000);

                    if (text.matches("[A-Z]")) {

                        ThreadSafeTestContext.setSection(text);
                        sectionElement.click();
                        Thread.sleep(2000);
                        System.out.println("section: " + text);
                        break; // Click only the first valid section
                    }

                }

            }
        } catch (NoSuchElementException e) {
            Assert.fail("No response button found to select class and section. " +
                    "Please ensure the chat is in the correct state to select class and section.");
        }
        ignoreHint();

        if (fool == 0) {
            classes = chromeDriver.findElements(By.xpath(
                    "(//div[@style='transform-origin: left top; transform: none;'])[last()]/ancestor::div[2]/" +
                            "following-sibling::div/div//button//p/p[contains(text(),'Class') or contains(text(),'Balvatika')]"));
            Thread.sleep(2000);

            if (!classes.isEmpty()) {
                int randomClassIndex = (int) (Math.random() * classes.size());
                WebElement classElement = classes.get(randomClassIndex);
                ThreadSafeTestContext.setGrade(classElement.getText().replace("Class", "").trim());
                classElement.click();
                Thread.sleep(2000);
                ignoreHint();
            }

            List<WebElement> section = chromeDriver.findElements(By.xpath(
                    "//div/button[contains(@class,'MuiButton-outlinedSizeMedium')]//p/p[contains(text(),'A') or contains(text(),'B') or contains(text(),'C') or contains(text(),'D') or contains(text(),'E') or contains(text(),'F') or contains(text(),'G') or contains(text(),'H') or contains(text(),'I') or contains(text(),'J') or contains(text(),'K') or contains(text(),'L')]"));
            if (!section.isEmpty()) {
                int randomSectionIndex = (int) (Math.random() * section.size());
                WebElement sectionElement = section.get(randomSectionIndex);
                String sectionName = sectionElement.getText().replaceAll("\\s*\\(.*?\\)", "").trim().replace("Section", "");
                ThreadSafeTestContext.setSection(sectionName);
                sectionElement.click();
                Thread.sleep(2000);
                System.out.println("section: " + sectionName);
            }
        }
    }


    // Java
    private void selectClassByName(String classText) throws InterruptedException {
        List<WebElement> classes;
        try {
            WebElement res = chromeDriver.findElement(By.xpath("//div[@class='chat-screen css-hiazq0']/div/div[last()]/div//button//p/p[text()='Select a response']"));
            if (res.isDisplayed()) {
                res.click();
                classes = chromeDriver.findElements(By.xpath("//div[@class='modal-box__contents MuiBox-root css-0']//p/p[text()]"));
            } else {
                classes = chromeDriver.findElements(By.xpath(
                        "(//div[@style='transform-origin: left top; transform: none;'])[last()]/ancestor::div[2]/" +
                                "following-sibling::div/div//button//p/p[contains(text(),'Class') or contains(text(),'Balvatika')]"));
            }
            Thread.sleep(2000);
            for (WebElement classElement : classes) {
                if (classElement.getText().trim().equals(classText)) {
                    String grade = classText.replace("Class", "").trim();
                    ThreadSafeTestContext.setGrade(grade);
                    classElement.click();
                    Thread.sleep(2000);
                    ignoreHint();
                    break;
                }
            }
        } catch (NoSuchElementException e) {
            Assert.fail("No response button found to select class. Please ensure the chat is in the correct state.");
        }
    }

    // Example usage for Class 1
    public void selectClass1() throws InterruptedException {
        selectClassByName("Class 1");
    }

    // Example usage for Class 2
    public void selectClass2() throws InterruptedException {
        selectClassByName("Class 2");
    }

    // Example usage for Class 3
    public void selectClass3() throws InterruptedException {
        selectClassByName("Class 3");
    }
    // Example usage for Class 4
    public void selectClass4() throws InterruptedException {
        selectClassByName("Class 4");
    }
    // Example usage for Class 5
    public void selectClass5() throws InterruptedException {
        selectClassByName("Class 5");
    }
    // Example usage for Class 6
    public void selectClass6() throws InterruptedException {
        selectClassByName("Class 6");
    }
    // Example usage for Class 7
    public void selectClass7() throws InterruptedException {
        selectClassByName("Class 7");
    }
    // Example usage for Class 8
    public void selectClass8() throws InterruptedException {
        selectClassByName("Class 8");
    }
    // Example usage for Class 9
    public void selectClass9() throws InterruptedException {
        selectClassByName("Class 9");
    }
    // Example usage for Class 10
    public void selectClass10() throws InterruptedException {
        selectClassByName("Class 10");
    }
    // Example usage for Class 11
    public void selectClass11() throws InterruptedException {
        selectClassByName("Class 11");
    }
    // Example usage for Class 12
    public void selectClass12() throws InterruptedException {
        selectClassByName("Class 12");
    }

    // Select randomly from Class 1 to Class 12 //
    public void selectRandomClassOrGrade() throws InterruptedException {
        int randomClassNumber = (int) (Math.random() * 12) + 1; // Random number between 1 and 12
        switch (randomClassNumber) {
            case 1:
                selectClass1();
                break;
            case 2:
                selectClass2();
                break;
            case 3:
                selectClass3();
                break;
            case 4:
                selectClass4();
                break;
            case 5:
                selectClass5();
                break;
            case 6:
                selectClass6();
                break;
            case 7:
                selectClass7();
                break;
            case 8:
                selectClass8();
                break;
            case 9:
                selectClass9();
                break;
            case 10:
                selectClass10();
                break;
            case 11:
                selectClass11();
                break;
            case 12:
                selectClass12();
                break;
        }
    }

    // Select randomly section from A to Z
    public void selectRandomSection() throws InterruptedException {
        String[] sections = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
                "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        int randomIndex = (int) (Math.random() * sections.length);
        String selectedSection = sections[randomIndex];
        ThreadSafeTestContext.setSection(selectedSection);
        System.out.println("Selected Section: " + selectedSection);
        // Click the section button in the chat
        WebElement sectionButton = chromeDriver.findElement(By.xpath(
                "//div/button//p/p[text(), '" + selectedSection + "']"));
        sectionButton.click();
        Thread.sleep(2000);
    }



// ...repeat for Class 3 to Class 12


    public void downloadDocument(){

        String downloadFilepath = "C:\\Downloads\\testdownloads";  // your custom path

        File downloadDir = new File(downloadFilepath);
        if (!downloadDir.exists()) {
            boolean created = downloadDir.mkdirs();
            if (created) {
                System.out.println("Download directory created: " + downloadFilepath);
            } else {
                throw new RuntimeException("Failed to create download directory: " + downloadFilepath);
            }
        }
        File[] existingFiles = downloadDir.listFiles();
        if (existingFiles != null) {
            for (File file : existingFiles) {
                file.delete();
            }
        }

        try {
            WebElement downloadButton;
            if(getResponseCount()==3){
                 downloadButton = chromeDriver.findElement(By.xpath("(//div[@style='transform-origin: left top; transform: none;'])[last()]/" +
                         "ancestor::div[2]/following-sibling::div[last()-2]/div//div[contains(@class,'document__download')]"));
                downloadButton.click();

            }
            if(getResponseCount()==2){
                downloadButton = chromeDriver.findElement(By.xpath("(//div[@style='transform-origin: left top; transform: none;'])[last()]/" +
                        "ancestor::div[2]/following-sibling::div[last()-1]/div//div[contains(@class,'document__download')]"));
                downloadButton.click();

            }

            boolean isDownloaded = false;
            int timeout = 20;  // seconds

            while (timeout > 0) {
                File[] pdfs = downloadDir.listFiles((dir, name) -> name.toLowerCase().endsWith(".pdf"));
                if (pdfs != null && pdfs.length > 0) {
                    System.out.println("Downloaded file: " + pdfs[0].getName());
                    isDownloaded = true;
                    break;
                }
                Thread.sleep(1000);
                timeout--;
            }

            if (!isDownloaded) {
                throw new RuntimeException("PDF was not downloaded in expected time");
            }

            Thread.sleep(2000);
        } catch (NoSuchElementException e) {
            System.out.println("Download button not found.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Thread interrupted while waiting for download.");
        }
    }

        public void clickRandomButton() throws InterruptedException {
            List<WebElement> buttons = chromeDriver.findElements(By.xpath("(//div[@style='transform-origin: " +
                    "left top; transform: none;'])[last()]/" +
                    "ancestor::div[2]/following-sibling::div/div//button"));
            if (buttons.isEmpty()) {
                System.out.println("No buttons found to click.");
                return;
            }
            int randomIndex = (int) (Math.random() * buttons.size());
            WebElement randomButton = buttons.get(randomIndex);
            randomButton.click();
            Thread.sleep(2000);
        }

    public void validateButtons(String button1 , String button2) throws InterruptedException {
        List<WebElement> buttons = chromeDriver.findElements(By.xpath(
                "(//div[@style='transform-origin: left top; transform: none;'])[last()]" +
                        "/ancestor::div[2]/following-sibling::div[last()]//div/following-sibling::div" +
                        "//button//p/p[contains(text(), '"+button1+"') or contains(text(), " +
                        "'"+button2+"')] "));
        Thread.sleep(2000);
        if(buttons==null && buttons.size() < 2) {
            Assert.fail("Buttons with text: " + button1 + " and " + button2 + " not found.");
        } else {
            System.out.println("Buttons with text: " + button1 + " and " + button2 + " found.");
        }

     }

    public void validateButtons(String button1 , String button2 , String button3) throws InterruptedException {
        List<WebElement> buttons = chromeDriver.findElements(By.xpath(
                "(//div[@style='transform-origin: left top; transform: none;'])[last()]" +
                        "/ancestor::div[2]/following-sibling::div[last()]//div/following-sibling::div" +
                        "//button//p/p[contains(text(), '"+button1+"') or contains(text(), " +
                        "'"+button2+"') or contains(text(),  "+button3+")]"));

        Thread.sleep(2000);
        if(buttons==null && buttons.size() < 3) {
            Assert.fail("Buttons with text: " + button1 + " and " + button2 + " and "+button3+" not found.");
        } else {
            System.out.println("Buttons with text: " + button1 + " and " + button2 + "and "+button3 + " found.");
        }

    }


    public void selectButtonOptionFromChat(String option) throws InterruptedException {
        //[starts-with(normalize-space(text()), '" + cleanClass + "')]")).click();

         // e.g., "Gujarati"
        String translatedLabel = LangMapper.getLocalized(option, ThreadSafeTestContext.getMedium());

        Thread.sleep(5000);
        chromeDriver.findElement(By.xpath(
                "//div/button//p/p[starts-with(normalize-space(text()), '" +
                        translatedLabel.replaceAll("\\s*\\(\\d+/\\d+\\)", "").trim() +
                        "')]")).click();
        //chromeDriver.findElement(By.xpath("//div/button//p/p[text()='"+option.replaceAll("\\s*\\(.*?\\)", "").trim()+"']")).click();
        Thread.sleep(2000);
    }

    String[] expectedPersistentMenuOptions = {"Home Menu","Edit Registration", "Change chat language"};

    public void allPersistentMenuOptions() {
        List<WebElement> persistentMenuOptions = chromeDriver.findElements(By.xpath(
                "//*[@id='footer-box']/div[3]/button/div/div/div/div/div/p/p"));
        if (persistentMenuOptions.isEmpty()) {
            Assert.fail("No persistent menu options found.");
        } else {
            System.out.println("Persistent Menu Options:");
            SoftAssert softAssert = new SoftAssert();
            for (int i = 0; i < persistentMenuOptions.size(); i++) {

                String actualOption = persistentMenuOptions.get(i).getText(); // LOOP1 - Home Menu, LOOP2 - Edit Registration, LOOP3 - Change chat language

                if(expectedPersistentMenuOptions[i].equals(actualOption)) { // LOOP1 - Home Menu, LOOP2 - Edit Registration, LOOP3 - Change chat language
                    System.out.println("Option " + i + ": " + actualOption + " - Matched");
                } else {
                    System.out.println("Option " + i + ": " + actualOption + " - Not Matched");
                    softAssert.fail("Persistent menu option mismatch: Expected: " +
                            expectedPersistentMenuOptions[i] + ", Actual: " + actualOption);
                }
            }
            softAssert.assertAll();
        }
    }
    public void selectPersistentMenuOption(String option) {

        try {
            WebElement pMenu;
            pMenu = chromeDriver.findElement(By.xpath("//button[@id='persistentMenu']"));
            if (pMenu.isEnabled()) {
                pMenu.click();
                waitFor(2);
            } else {
                Assert.fail("Persistent menu button is not enabled.");
            }

        } catch (NoSuchElementException e) {
            Assert.fail("Persistent menu button not found.");
        }
            try {
                WebElement optionsMenu;
                optionsMenu = chromeDriver.findElement(By.xpath("//*[@id='footer-box']/div[3]/button/div/div/di" +
                        "v/div/div/p/p[text()='" + option + "']"));
                if (optionsMenu.isEnabled()) {
                    optionsMenu.click();
                } else {
                    Assert.fail("Persistent menu option is not enabled: " + option);
                }
            } catch (NoSuchElementException e1) {
                Assert.fail("Persistent menu option not found: " + option);
            }

    }

    public void selectUserTypeFromPicklist(String userType) {
        chromeDriver.findElement(By.xpath(
                "//div[@class='chat-screen css-hiazq0']/div/div[last()]/div//button//p/p[text()='Select a response']")).click();
        waitFor(2);
        chromeDriver.findElement(By.xpath("//div[@class='modal-box__contents MuiBox-root css-0']//p/p[text()='"+userType+"']")).click();
    }

    /*public void getDataAndValidateString() throws IOException {
        readExcel(filePath, "sheetName","" , "Gujarati");
    }
*/

   public String getStringIDByDevID(String devID) throws IOException {
        String path  =  "C:\\Users\\ishan\\Downloads\\Automated Bot String ID.xlsx";
        FileInputStream fis = new FileInputStream(path);
        String getString="";
        Workbook workbook = new XSSFWorkbook(fis);
       Sheet sheet = workbook.getSheet("GSQAC");
       for (Row row : sheet) {
           if (row.getRowNum() == 0)
               continue; // Skip header

           Cell stringIDCell = row.getCell(0); // Column B (index 1)
           Cell devId = row.getCell(1);

           if (devId != null && devID.equalsIgnoreCase(devId.getStringCellValue().trim())){
               if (stringIDCell != null) {
                   getString = stringIDCell.getStringCellValue().trim();
               }
           }
       }
       return getString;
    }

    public String getDevIDByStringID(String stringID) throws IOException {
        String path  =  "C:\\Users\\ishan\\Downloads\\Automated Bot String ID.xlsx";
        FileInputStream fis = new FileInputStream(path);
        String getDevID="";
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheet("GSQAC");
        for (Row row : sheet) {
            if (row.getRowNum() == 0)
                continue; // Skip header

            Cell stringIDCell = row.getCell(0); // Column B (index 1)
            Cell devId = row.getCell(1);

            if (stringIDCell != null && stringID.equalsIgnoreCase(stringIDCell.getStringCellValue().trim())){
                if (devId != null) {
                    getDevID = devId.getStringCellValue().trim();
                }
            }
        }
        return getDevID;
    }


    public void validateResponseStringForAttendanceBot(String str1 , String str2) throws IOException, InterruptedException {
        validateResponseString(filePathForATTENDANCE ,str1, str2);
        Thread.sleep(2000);

    }
    public void validateResponseStringForAttendanceBot(String str1 , String str2 , String str3) throws IOException, InterruptedException {
        validateResponseString(filePathForATTENDANCE ,str1, str2, str3);
        Thread.sleep(2000);

    }
    public void validateResponseStringForAttendanceBot(String str1) throws IOException, InterruptedException {
        validateResponseString(filePathForATTENDANCE ,str1);
        Thread.sleep(2000);

    }

    // Java


}
