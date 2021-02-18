package com.autotrader.stepDefinitions;

import com.autotrader.pages.AdvanceSearchPage;
import com.autotrader.pages.AutotraderPage;
import com.autotrader.pages.Base;
import com.autotrader.utilities.MyDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class AutotraderSteps {

    AutotraderPage autotraderPage = new AutotraderPage();
    AdvanceSearchPage advanceSearchPage = new AdvanceSearchPage();

    @Given("User click Advance Search link on the home page")
    public void user_click_Advance_Search_link_on_the_home_page() throws InterruptedException {

        autotraderPage.advanceSearch.click();
        Base.clearCookies();
        Thread.sleep(3000);
    }

    @Then("User enter {string} in the zip code text box")
    public void user_enter_in_the_zip_code_text_box(String zipcode) throws InterruptedException {
      //  advanceSearchPage.enterZipCode.sendKeys("3004");
      Thread.sleep(5000);
        advanceSearchPage.enterZipCode.sendKeys(zipcode);
        Thread.sleep(3000);

    }
    @Then("user enter {int} in the zip code text box")
    public void user_enter_in_the_zip_code_text_box(Integer int1) {
        //advanceSearchPage.enterZipCode.sendKeys(int1);
    }


    @Then("User select {string} check box under {string}")
    public void user_select_check_box_under(String string, String string2) {
advanceSearchPage.selectCertified.click();
    }

    @Then("user update Year {string} to {string}")
    public void user_update_Year_to(String string, String string2) {

    }

    @Then("user select {string} car from Make,Model and Trim section")
    public void user_select_car_from_Make_Model_and_Trim_section(String string) {

    }

    @Then("User clicks Search button")
    public void user_clicks_Search_button() {

    }

    @Then("User verifies that he is in result page")
    public void user_verifies_that_he_is_in_result_page() {

    }

    @Then("User verifies that he sees only {string} cars in listing")
    public void user_verifies_that_he_sees_only_cars_in_listing(String string) {

    }

    @Then("Display in console, the number of cars listed in result page")
    public void display_in_console_the_number_of_cars_listed_in_result_page() {

    }

    @Given("User is in landing page")
    public void user_is_in_landing_page() {

        System.out.println("User is on landing Page");
        String actual = MyDriver.get().getTitle();
        String expected = "New Cars, Used Cars - Find Cars for Sale and Reviews at Autotrader";
        try {
            Assert.assertEquals(expected, actual);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Then("Verify that {string} are present")
    public void verify_that_are_present(String expected) {
        autotraderPage.verification(expected);
    }

    @Then("verify that search button is present.")
    public void verify_that_search_button_is_present() {
        autotraderPage.searchButton();
    }

    @Then("verify that {string} and {string} is visible")
    public void verify_that_and_is_visible(String make, String model) {
        autotraderPage.verifyMakeModel(make, model);
    }

    @Given("choose make as {string}")
    public void choose_make_as(String string) {

    }


}
