package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.util.Set;

public class BrowserUtils {

  // BrowserUtils is a selector location for reusable method
  // Advantage :
  //        1- You DO NOT NEED to repeat yourself
  //        2- Less amount of code
  //        3- Less amount of time !!!!!


    public static void selectBy (WebElement element, String value, String methodName) {

        Select select = new Select(element);

        switch (methodName) {

            case "text" :
                select.selectByVisibleText(value);
                break;
            case "value" :
                select.selectByValue(value);
                break;
            case "index" :
                select.selectByIndex(Integer.parseInt(value));
                break;
            default:
                System.out.println("Method name is not available, use text, value, or index for the method name");

        }



    }

    public static String getText (WebElement element) {
        return element.getText().trim();
    }

    public static String getTitleWithJS (WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return  js.executeScript("return document.title").toString();

    }

    public static void clickWithJS (WebDriver driver , WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()" , element);

    }

    public static void scrollWithJS (WebDriver driver , WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)" , element);
    }

    public static void switchByID (WebDriver driver, String mainWindowID) {
        Set<String> allPgesIDs = driver.getWindowHandles();

        for (String pageID : allPgesIDs) {
            System.out.println(pageID);
            if(!pageID.equals(mainWindowID)) {
                driver.switchTo().window(pageID);
            }
        }
    }



    public static void switchByTitle (WebDriver driver, String title) { //in real work this will help you a lot once you test different tabs or windows.
        Set<String> allPagesID = driver.getWindowHandles();
        for (String mainID : allPagesID) {//internet-->new Window
            driver.switchTo().window(mainID);
            if (driver.getTitle().contains(title)) {
                break;
            }
        }
    }

    public static void getScreenshot(WebDriver driver,String packageName){

        File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String location=System.getProperty("user.dir")+"/src/java/screenshot"+packageName;

        try {
            FileUtils.copyFile(file,new File(location+System.currentTimeMillis()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
