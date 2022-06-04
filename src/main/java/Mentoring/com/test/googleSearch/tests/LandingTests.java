package Mentoring.com.test.googleSearch.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Mentoring.com.test.googleSearch.pages.LandingPage;

public class LandingTests {

    WebDriver driver = null;

    @BeforeMethod

    public void setup () {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");
    }

    @Test

    public void validateHappyPath () throws InterruptedException {

        LandingPage landingPage = new LandingPage(driver);
    // searchField.sendKeys("SeleniumSelenium", Keys.ENTER);
        Thread.sleep(3000);
        landingPage.signInNoThanks();
        Thread.sleep(3000);
        landingPage.searchOnGoogle("automation step by step");
        Thread.sleep(2500);
        Assert.assertTrue(driver.getCurrentUrl().equals("automation step by step - Google Search"));
    }


}
