package com.autotrader.pages;

import com.autotrader.utilities.MyDriver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AutotraderPage extends Base {
    public AutotraderPage() {
        PageFactory.initElements(MyDriver.get(), this);
    }

    @FindBy(xpath = "//span[contains(@title,'Browse by Make')]")
    public WebElement browseByMake;
    @FindBy(xpath = "//span[contains(@title,'Browse by Style')]")
    public WebElement browseByStyle;
    @FindBy(xpath = "//a[contains(text(),'Advanced Search')]")
    public WebElement advanceSearch;
    @FindBy(xpath = "//button[@id='search']")
    public WebElement searchButton;


    @FindBy(xpath = "//select[@id='makeCodeListPlaceHolder']")
    public WebElement makeElement;
    @FindBy(xpath = "//select[@id='modelCodeListPlaceHolder']")
    public WebElement modelElement;


    public void verification(String expected) {
        String actual;
        switch (expected) {
            case "Browse By Make":
                actual= browseByMake.getText();
                Assert.assertEquals(expected, actual);
                break;
            case "Browse By Style":
                actual = browseByStyle.getText();
                Assert.assertEquals(expected, actual);
                break;
            case "Advance Search":
               actual = advanceSearch.getText();
                Assert.assertEquals(expected, actual);
                break;
            default:
                // Assert.fail --> just fails the test
             //   Assert.fail("Wrong expected provided");
        }


    }
// verify the Search Button is enabled
public void searchButton (){
                Assert.assertTrue(searchButton.isEnabled());
}

//Verifying the Make and Model dropdowns are visible.
public void verifyMakeModel (String make, String model){

        Assert.assertTrue(makeElement.isEnabled());
        Assert.assertTrue(modelElement.isEnabled());
}


}
