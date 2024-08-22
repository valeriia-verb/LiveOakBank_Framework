package com.live_oak.pages;

import com.live_oak.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public abstract class MainPage {

    public MainPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
