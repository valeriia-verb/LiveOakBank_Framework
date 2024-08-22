package com.live_oak.step_definitions;

import com.github.javafaker.Faker;
import com.live_oak.pages.OpenAccountFormPage;
import com.live_oak.utilities.ConfigurationReader;
import com.live_oak.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class OpenAccountForm_StepDefs {

    OpenAccountFormPage page;
    Faker faker;
    Select selectYearsAtAddress;
    Select selectState;
    Select selectCitizenStatus;
    Select selectEmploymentStatus;

    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));


    @Given("the user is on the Open a New Personal Savings Account page")
    public void the_user_is_on_the_open_a_new_personal_savings_account_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));

    }
    @And("user closes the pop-up")
    public void user_closes_the_pop_up() {
        page = new OpenAccountFormPage();
        wait.until(ExpectedConditions.elementToBeClickable(page.popupButton));
        page.popupButton.click();
    }

    @When("the user enters random test data for the form missing a field")
    public void the_user_enters_random_test_data_for_the_form_missing_a_field() {
        faker = new Faker();

        selectState = new Select(page.stateDropdown);
        selectYearsAtAddress = new Select(page.yearsAtAddressDropdown);
        selectCitizenStatus = new Select(page.citizenDropdown);
        selectEmploymentStatus = new Select(page.employmentStatusDropdown);

        wait.until(ExpectedConditions.elementToBeClickable(page.fNameField));
        page.fNameField.sendKeys(faker.name().firstName());

        wait.until(ExpectedConditions.elementToBeClickable(page.lNameField));
        page.lNameField.sendKeys(faker.name().lastName());

        wait.until(ExpectedConditions.elementToBeClickable(page.currentAddressField));
        page.currentAddressField.sendKeys(faker.address().streetAddress());

        wait.until(ExpectedConditions.elementToBeClickable(page.cityField));
        page.cityField.sendKeys(faker.address().cityName());

        wait.until(ExpectedConditions.elementToBeClickable(page.stateDropdown));
        selectState.selectByVisibleText("IL");

        wait.until(ExpectedConditions.elementToBeClickable(page.postalCodeField));
        page.postalCodeField.sendKeys(faker.address().zipCode());

        wait.until(ExpectedConditions.elementToBeClickable(page.yearsAtAddressDropdown));
        selectYearsAtAddress.selectByVisibleText("4+");

        wait.until(ExpectedConditions.elementToBeClickable(page.ssnField));
        page.ssnField.sendKeys(faker.number().digits(9));


        JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
        LocalDate bday = LocalDate.of(1990, 5, 5);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String formattedDate = bday.format(formatter);

        page.birthdateField.clear();

        executor.executeScript("arguments[0].value='"+formattedDate+"';", page.birthdateField);
// Trigger any change or input events
        executor.executeScript("arguments[0].dispatchEvent(new Event('change'));", page.birthdateField);
        executor.executeScript("arguments[0].dispatchEvent(new Event('input'));", page.birthdateField);


        wait.until(ExpectedConditions.elementToBeClickable(page.citizenDropdown));
        selectCitizenStatus.selectByVisibleText("Permanent US Resident");

        wait.until(ExpectedConditions.elementToBeClickable(page.phoneField));
        page.phoneField.sendKeys(faker.phoneNumber().cellPhone());

        wait.until(ExpectedConditions.elementToBeClickable(page.emailField));
        page.emailField.sendKeys(faker.internet().emailAddress());

        wait.until(ExpectedConditions.elementToBeClickable(page.employmentStatusDropdown));
        selectEmploymentStatus.selectByVisibleText("Full Time");

        page.foreignPoliticianRadioBtn.click();

        page.familyPoliticianRadioBtn.click();

        page.certifyCheckbox.click();

    }
    @When("the user presses the {string} button")
    public void the_user_presses_the_button(String buttonName) {
        wait.until(ExpectedConditions.elementToBeClickable(page.nextButton));
        //request.requestDemoButton.click();
        JavascriptExecutor executor = (JavascriptExecutor) Driver.getDriver();
        executor.executeScript("arguments[0].click();", page.nextButton);
    }
    @Then("the user should see missing field highlighted")
    public void the_user_should_see_missing_field_highlighted() {
        Assert.assertTrue(page.errorMessage.isDisplayed());
        Driver.closeDriver();
    }
}
