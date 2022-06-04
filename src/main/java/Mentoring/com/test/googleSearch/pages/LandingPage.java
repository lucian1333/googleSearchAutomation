package Mentoring.com.test.googleSearch.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

    public LandingPage(WebDriver driver) {

        PageFactory.initElements(driver , this);

    }

    @FindBy (xpath = "//input[@name='q']")
    WebElement searchFiled;

    @FindBy (xpath = "//input[@name='btnK']")
    WebElement searchButton;

    @FindBy (xpath = "//a[@aria-label='Sign in']//../button")
    WebElement signInPopUpNoThanksButton;

    public void signInNoThanks () {
        this.signInPopUpNoThanksButton.click();
    }

    public void searchOnGoogle(String text) throws InterruptedException {
        this.searchFiled.sendKeys(text , Keys.ENTER);
    }



}
