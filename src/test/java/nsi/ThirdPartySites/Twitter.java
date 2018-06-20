package nsi.ThirdPartySites;

import static com.codeborne.selenide.Selenide.$;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.codeborne.selenide.SelenideElement;

import cucumber.api.java.en.Given;
import nsi.BaseClass;

public class Twitter extends BaseClass
{

    TwitterElements ele = new TwitterElements();

    // OBJECTS
    private static class TwitterElements
    {
        SelenideElement continer = $(By.id("page-container"));

    }

    @Given("^Twitter browser back button$")
    public void twitter_browser_back_button() throws Throwable
    {
        ele.continer.sendKeys(Keys.LEFT_ALT);
    }

}
