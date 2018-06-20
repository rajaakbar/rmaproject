package nsi.NSI.pages;

import static com.codeborne.selenide.Selenide.$;
import static org.hamcrest.MatcherAssert.assertThat;

import org.openqa.selenium.By;

import com.codeborne.selenide.SelenideElement;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import nsi.BaseClass;

public class Products extends BaseClass
{

    OurProductsElements ele = new OurProductsElements();

    private static class OurProductsElements
    {

        SelenideElement productsGridSwitch = $(By.xpath("//*[@id='products-grid-switch']"));

        SelenideElement productsListSwitch = $(By.xpath("//*[@id='products-list-switch']"));

        SelenideElement notCurrentlyonSale = $(By.xpath(".//*[text()='Not currently on sale']"));

        SelenideElement noLongerOnSale = $(By.xpath(".//*[text()='No longer on sale']"));

        SelenideElement onSaleblock1 = $(
                By.xpath("//*[@class='container product-container']/div[1]/ul[1]/li[1]/div[1]"));

        SelenideElement onSaleblock2 = $(
                By.xpath("//*[@class='container product-container']/div[1]/ul[1]/li[2]/div[1]"));

        SelenideElement onSaleblock3 = $(
                By.xpath("//*[@class='container product-container']/div[1]/ul[1]/li[3]/div[1]"));

        SelenideElement onSaleblock4 = $(
                By.xpath("//*[@class='container product-container']/div[1]/ul[1]/li[4]/div[1]"));

    }

    // *************** CURRENTLY ON SALE
    @Given("^NSI Products verify grid product text and colour currently on sale \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void nsi_Products_verify_grid_product_text_and_colour_currently_on_sale(String position, String product,
            String colour, String text) throws Throwable
    {

        String path = "//*[@class='container product-container']/div[1]/ul[1]/li[" + position + "]/div[1]";
        String actualcolour = "#" + colour;
        $(By.xpath(path)).getText().contains(product);
        $(By.xpath(path)).getText().contains(text);
        isElementBackgroundColour($(By.xpath(path)), actualcolour);

    }

    @Given("^NSI Products click the product link in grid product position \"([^\"]*)\"$")
    public void nsi_Products_click_the_product_link_in_grid_product_position(String position) throws Throwable
    {
        String path = "//*[@class='container product-container']/div[1]/ul[1]/li[" + position + "]/div[1]/a";
        $(By.xpath(path)).click();
    }

    // *********** NO LONGER ON SALE
    @Given("^NSI Products verify product text and colour no longer on sale \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void nsi_Products_verify_product_text_and_colour_no_longer_on_sale(String position, String product,
            String colour, String text) throws Throwable
    {
        String path = "//*[@class='container product-container']/div[1]/ul[3]/li/div/div/ul/li[" + position
                + "]/div[1]";
        String actualcolour = "#" + colour;
        $(By.xpath(path)).getText().contains(product);
        $(By.xpath(path)).getText().contains(text);
        isElementBackgroundColour($(By.xpath(path)), actualcolour);
    }

    @Given("^NSI Products click the product link within no longer on sale at position \"([^\"]*)\"$")
    public void nsi_Products_click_the_product_link_within_no_longer_on_sale_at_position(String position)
            throws Throwable
    {
        String path = "//*[@class='container product-container']/div[1]/ul[3]/li/div/div/ul/li[" + position
                + "]/div[1]/a";
        $(By.xpath(path)).click();
    }

    // ******** NOT CURRENTLY ON SALE

    @Given("^NSI Products verify product text and colour not currently on sale \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void nsi_Products_verify_product_text_and_colour_not_currently_on_sale(String position, String product,
            String colour, String text) throws Throwable
    {
        // *[@class='container product-container']/div[1]/ul[2]/li/div/div/ul/li[1]/div[1]

        String path = "//*[@class='container product-container']/div[1]/ul[2]/li/div/div/ul/li[" + position
                + "]/div[1]";
        String actualcolour = "#" + colour;
        $(By.xpath(path)).getText().contains(product);
        $(By.xpath(path)).getText().contains(text);
        isElementBackgroundColour($(By.xpath(path)), actualcolour);
    }

    @Given("^NSI Products click the product link within not currently on sale at position \"([^\"]*)\"$")
    public void nsi_Products_click_the_product_link_within_not_currently_on_sale_at_position(String position)
            throws Throwable
    {
        String path = "//*[@class='container product-container']/div[1]/ul[2]/li/div/div/ul/li[" + position
                + "]/div[1]/a";
        $(By.xpath(path)).click();
    }

    @Then("^NSI Products items no longer on sale are vertically alined$")
    public void nsi_Products_items_no_longer_on_sale_are_vertically_alined() throws Throwable
    {
        // areElementsVerticallyAligned(ele.sixtyfivePlusGGBonds, ele.childrensBonds);
    }

    @Given("^NSI Products click radio option two for positions \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void nsi_Products_click_radio_option_two_for_positions(String position1, String position2, String position3)
            throws Throwable
    {
        String position1path = "//*[@class='container product-container']/div[1]/ul[1]/li[" + position1
                + "]/ol/li[2]/a";
        String position2path = "//*[@class='container product-container']/div[1]/ul[1]/li[" + position2
                + "]/ol/li[2]/a";
        String position3path = "//*[@class='container product-container']/div[1]/ul[1]/li[" + position3
                + "]/ol/li[2]/a";
        $(By.xpath(position1path)).click();
        $(By.xpath(position2path)).click();
        $(By.xpath(position3path)).click();

    }

    @Given("^NSI Products verify product text for for radio option two \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void nsi_Products_verify_product_text_for_for_radio_option_two(String position1, String position2,
            String position3, String text1, String text2, String text3) throws Throwable
    {

        String position1path = "//*[@class='container product-container']/div[1]/ul[1]/li[" + position1 + "]/div[1]";
        String position2path = "//*[@class='container product-container']/div[1]/ul[1]/li[" + position2 + "]/div[1]";
        String position3path = "//*[@class='container product-container']/div[1]/ul[1]/li[" + position3 + "]/div[1]";

        $(By.xpath(position1path)).getText().contains(text1);
        $(By.xpath(position2path)).getText().contains(text2);
        $(By.xpath(position3path)).getText().contains(text3);
    }

    @Then("^NSI Products verify product text for radio option two horizontal alined \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void nsi_Products_verify_product_text_for_radio_option_two_horizontal_alined(String position1,
            String position2, String position3) throws Throwable
    {
        String position1path = "//*[@class='container product-container']/div[1]/ul[1]/li[" + position1 + "]/div[1]";
        String position2path = "//*[@class='container product-container']/div[1]/ul[1]/li[" + position2 + "]/div[1]";
        String position3path = "//*[@class='container product-container']/div[1]/ul[1]/li[" + position3 + "]/div[1]";

        mobile = isItMobileOrDesktopBrowser();
        if (mobile)
        {

            areElementsVerticallyAligned($(By.xpath(position1path)), $(By.xpath(position2path)));
            areElementsVerticallyAligned($(By.xpath(position2path)), $(By.xpath(position3path)));
            areElementsVerticallyAligned($(By.xpath(position1path)), $(By.xpath(position3path)));

        }
        else
        {
            areElementsHorizontallyAligned($(By.xpath(position1path)), $(By.xpath(position2path)));
            areElementsHorizontallyAligned($(By.xpath(position2path)), $(By.xpath(position3path)));
            areElementsHorizontallyAligned($(By.xpath(position1path)), $(By.xpath(position3path)));
        }

    }

    @Then("^NSI Products verify products text for radio option two is the same hight \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void nsi_Products_verify_products_text_for_radio_option_two_is_the_same_hight(String position1,
            String position2, String position3) throws Throwable
    {
        String position1path = "//*[@class='container product-container']/div[1]/ul[1]/li[" + position1 + "]/div[1]";
        String position2path = "//*[@class='container product-container']/div[1]/ul[1]/li[" + position2 + "]/div[1]";
        String position3path = "//*[@class='container product-container']/div[1]/ul[1]/li[" + position3 + "]/div[1]";

        areElementsTheSameHeight($(By.xpath(position1path)), $(By.xpath(position2path)));
        areElementsTheSameHeight($(By.xpath(position2path)), $(By.xpath(position3path)));
        areElementsTheSameHeight($(By.xpath(position1path)), $(By.xpath(position3path)));
    }

    @Then("^NSI Products verify product text for radio option two horizontal alined$")
    public void nsi_Products_verify_product_text_for_radio_option_two_horizontal_alined() throws Throwable
    {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^NSI Products verify products text for radio option two is the same hight$")
    public void nsi_Products_verify_products_text_for_radio_option_two_is_the_same_hight() throws Throwable
    {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^NSI Products items no longer on sale are horizontal alined$")
    public void nsi_Products_items_no_longer_on_sale_are_horizontal_alined() throws Throwable
    {
        mobile = isItMobileOrDesktopBrowser();
        if (mobile)
        {
            // areElementsVerticallyAligned(ele.sixtyfivePlusGGBonds, ele.childrensBonds);
        }
        else
        {
            // areElementsHorizontallyAligned(ele.sixtyfivePlusGGBonds, ele.childrensBonds);
        }

    }

    @Then("^NSI Products items not on sale are vertically alined$")
    public void nsi_Products_items_not_on_sale_are_vertically_alined() throws Throwable
    {
        mobile = isItMobileOrDesktopBrowser();
        if (mobile)
        {
            // areElementsVerticallyAligned(ele.indexLSCertificatesBlock, ele.FixedISCertificatesBlock);
            // areElementsTheSameWidth(ele.indexLSCertificatesBlock, ele.FixedISCertificatesBlock);
        }
        else
        {
            // areElementsVerticallyAligned(ele.indexLSCertificatesBlock, ele.FixedISCertificatesBlock);
            // areElementsTheSameHeight(ele.indexLSCertificatesBlock, ele.FixedISCertificatesBlock);
            // (ele.indexLSCertificatesBlock, ele.FixedISCertificatesBlock);
        }

    }

    @Then("^NSI Products items not on sale are horizontal alined$")
    public void nsi_Products_items_not_on_sale_are_horizontal_alined() throws Throwable
    {
        mobile = isItMobileOrDesktopBrowser();
        if (mobile)
        {
            // areElementsVerticallyAligned(ele.indexLSCertificatesBlock, ele.FixedISCertificatesBlock);
            // areElementsTheSameWidth(ele.indexLSCertificatesBlock, ele.FixedISCertificatesBlock);
        }
        else
        {
            // areElementsHorizontallyAligned(ele.indexLSCertificatesBlock, ele.FixedISCertificatesBlock);
            // areElementsTheSameHeight(ele.indexLSCertificatesBlock, ele.FixedISCertificatesBlock);
            // areElementsTheSameWidth(ele.indexLSCertificatesBlock, ele.FixedISCertificatesBlock);
        }

    }

    @Given("^NSI Products click radio option two for PremiumBonds InvestGGBonds GuaranteedIBonds$")
    public void nsi_Products_click_radio_option_two_for_PremiumBonds_InvestGGBonds_GuaranteedIBonds() throws Throwable
    {
        // ele.premiumBondsBlock.scrollTo();
        // ele.premiumBondsRadio2.click();
        // ele.investmentGGBondsRadio2.click();
        // ele.guaranteedIBondsRadio2.click();
    }

    @Given("^NSI Products verify product text for PremiumBonds InvestGGBonds GuaranteedIBonds$")
    public void nsi_Products_verify_product_text_for_PremiumBonds_InvestGGBonds_GuaranteedIBonds() throws Throwable
    {
        // ele.premiumBondsBlock.getText().contains("Variable");
        // ele.investmentGGBBlock.getText().contains("Issue 1");
        // ele.gibBlock.getText().contains("Issue 62");
    }

    @Then("^NSI Products text items are horizontal alined$")
    public void nsi_Products_text_items_are_horizontal_alined() throws Throwable
    {
        mobile = isItMobileOrDesktopBrowser();
        if (mobile)
        {
            // areElementsVerticallyAligned(ele.premiumBondsOptionTwoTextBlock, ele.investmentGGBOptionTwoTextBlock);
            // areElementsVerticallyAligned(ele.investmentGGBOptionTwoTextBlock, ele.gibOptionTwoTextBlock);
        }
        else
        {
            // areElementsHorizontallyAligned(ele.premiumBondsOptionTwoTextBlock, ele.investmentGGBOptionTwoTextBlock);
            // areElementsHorizontallyAligned(ele.investmentGGBOptionTwoTextBlock, ele.gibOptionTwoTextBlock);
        }

    }

    @Then("^NSI Products text is the same hight$")
    public void nsi_Products_text_is_the_same_hight() throws Throwable
    {
        // areElementsTheSameHeight(ele.premiumBondsOptionTwoTextBlock, ele.investmentGGBOptionTwoTextBlock);
        // areElementsTheSameHeight(ele.investmentGGBOptionTwoTextBlock, ele.gibOptionTwoTextBlock);
    }

    @Then("^NSI Products items are vertically alined$")
    public void nsi_Products_items_are_vertically_alined() throws Throwable
    {

        mobile = isItMobileOrDesktopBrowser();
        if (mobile)
        {
            areElementsVerticallyAligned(ele.onSaleblock1, ele.onSaleblock2);
            areElementsTheSameWidth(ele.onSaleblock1, ele.onSaleblock2);
        }
        else
        {
            areElementsVerticallyAligned(ele.onSaleblock1, ele.onSaleblock4);
            areElementsTheSameHeight(ele.onSaleblock1, ele.onSaleblock4);
            areElementsTheSameWidth(ele.onSaleblock1, ele.onSaleblock4);
        }

    }

    @Then("^NSI Products items are horizontal alined$")
    public void nsi_Products_items_are_horizontal_alined() throws Throwable
    {
        mobile = isItMobileOrDesktopBrowser();
        if (mobile)
        {
            areElementsVerticallyAligned(ele.onSaleblock1, ele.onSaleblock2);
            areElementsVerticallyAligned(ele.onSaleblock3, ele.onSaleblock4);
            areElementsTheSameHeight(ele.onSaleblock1, ele.onSaleblock2);
            areElementsTheSameWidth(ele.onSaleblock3, ele.onSaleblock4);
        }
        else
        {
            areElementsHorizontallyAligned(ele.onSaleblock1, ele.onSaleblock2);
            areElementsHorizontallyAligned(ele.onSaleblock2, ele.onSaleblock3);
            areElementsVerticallyAligned(ele.onSaleblock1, ele.onSaleblock4);
            areElementsTheSameHeight(ele.onSaleblock1, ele.onSaleblock2);
            areElementsTheSameWidth(ele.onSaleblock1, ele.onSaleblock2);
            areElementsTheSameHeight(ele.onSaleblock2, ele.onSaleblock3);
            areElementsTheSameWidth(ele.onSaleblock2, ele.onSaleblock3);
            areElementsTheSameHeight(ele.onSaleblock1, ele.onSaleblock4);
            areElementsTheSameWidth(ele.onSaleblock1, ele.onSaleblock4);
        }

    }

    @Given("^NSI Products submit grid or list \"([^\"]*)\"$")
    public void nsi_Products_submit_grid_or_list(String choice) throws Throwable
    {
        switch (choice.toLowerCase())
        {
        case "grid":
            ele.productsGridSwitch.scrollTo().click();
            break;
        case "list":
            ele.productsListSwitch.scrollTo().click();
            break;
        default:
            assertThat("***** could not find " + choice + "element to be able to click", false);
            break;
        }
    }

    @Given("^NSI Products submit \"([^\"]*)\" drop down$")
    public void nsi_Products_submit_drop_down(String choice) throws Throwable
    {
        switch (choice.toLowerCase())
        {
        case "no longer on sale":
            ele.noLongerOnSale.scrollTo().click();
            break;
        case "not currently on sale":
            ele.notCurrentlyonSale.scrollTo().click();
            break;
        default:
            assertThat("***** could not find " + choice + "element to be able to click", false);
            break;
        }
    }

}
