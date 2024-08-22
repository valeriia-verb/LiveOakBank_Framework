package com.live_oak.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OpenAccountFormPage extends MainPage{

    @FindBy(id = "pendo-button-c8d6a9be")
    public WebElement popupButton;

    @FindBy(id = "firstName")
    public WebElement fNameField;

    @FindBy(id = "lastName")
    public WebElement lNameField;

    @FindBy(id = "address1")
    public WebElement currentAddressField;

    @FindBy(id = "city")
    public WebElement cityField;

    @FindBy(id = "region")
    public WebElement stateDropdown;

    @FindBy(id = "yearsAtAddress")
    public WebElement yearsAtAddressDropdown;

    @FindBy(id = "postalCode")
    public WebElement postalCodeField;

    @FindBy(id = "taxId")
    public WebElement ssnField;

    @FindBy(id = "birthdate")
    public WebElement birthdateField;

    @FindBy(id = "citizen")
    public WebElement citizenDropdown;

    @FindBy(id = "primaryPhone")
    public WebElement phoneField;

    @FindBy(id = "email")
    public WebElement emailField;

    @FindBy(id = "employmentStatus")
    public WebElement employmentStatusDropdown;

    @FindBy(id = "foreignPoliticalFigure-false")
    public WebElement foreignPoliticianRadioBtn;

    @FindBy(id = "familyOfPoliticalFigure-false")
    public WebElement familyPoliticianRadioBtn;

    @FindBy(id = "certify")
    public WebElement certifyCheckbox;

    @FindBy(id = "nextButton")
    public WebElement nextButton;

    @FindBy(id = "error")
    public WebElement errorMessage;

}
