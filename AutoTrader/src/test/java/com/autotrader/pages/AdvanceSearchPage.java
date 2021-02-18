package com.autotrader.pages;

import com.autotrader.utilities.MyDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AdvanceSearchPage extends Base {


    @FindBy(xpath = "//a[contains(text(),'Advanced Search')]")
    public WebElement clickAdvanceSearch;

    @FindBy(xpath = "//input[contains(@name,'zip')]")
    public WebElement enterZipCode;

    @FindBy(xpath = "//div[contains(text(),'Certified')]")
    public WebElement selectCertified;

    @FindBy(xpath = "//div[contains(text(),'Convertible')]")
    public WebElement selectConvertible;

    @FindBy(xpath = "//select[contains(@name,'startYear')]")
    public WebElement selectFrom;

    @FindBy(xpath = "//select[contains(@name,'endYear')]")
    public WebElement selectTo;

    @FindBy(xpath = "//select[contains(@name,'makeFilter0')]")
    public WebElement selectBMW;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-block ae-button']")
    public WebElement clickSearchButton;

    @FindBy(xpath = "//title[contains(text(),'Certified BMW Convertibles for Sale')]")
    public WebElement userInPage;

    @FindBy(xpath = "//h2[contains(@data-cmp,'subheading')]")
    public WebElement onlyBMW;

    @FindBy(xpath = "//div[contains(@data-cmp,'inventoryListing')]")
    public WebElement numberOfBMW;


    public void zipCode(String zip) throws InterruptedException {
        MyDriver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        enterZipCode.sendKeys("30004");

    }

    public void clickSearchButton() {
        WebElement link = clickSearchButton;
        scrollDown(link);
        clickSearchButton.click();
    }

    public void verifyBMWCarListing(String car) {

        List<WebElement> list = MyDriver.get().findElements(By.xpath("//h2[contains(@data-cap,'subheading"));
        int count = 0;

        for (WebElement each : list) {
            if (!each.getText().contains(car)) {
                System.out.println(("we found non BMW listing" + car));
            }
            count++;
        }
        System.out.println(("we found " +count+"BMW listing and there is non BMW listing"));

    }


}




