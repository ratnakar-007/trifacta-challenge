package com.trifacta.pages;

import com.trifacta.base.Base;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Login extends Base {

    @FindBy(css = "input[type='standard']")
    private WebElement email_field;

    @FindBy(css = "input[type='password']")
    private WebElement password_field;

    @FindBy(css = "div[data-id='primary-button']")
    private WebElement loginBtn;

    @FindBy(css = "div[data-id='error-container']")
    private WebElement errorNotify;

    @FindBy(css = "div[data-id='trifacta-logo']")
    private WebElement logo;

    public Login() {
        PageFactory.initElements(driver, this);
    }

    public void enterEmail() {
        try {
            email_field.sendKeys(prop.getProperty("email"));
        } catch (NoSuchElementException nsee) {
            nsee.printStackTrace();
        }
    }

    public void enterPassword() {
        try {
            password_field.sendKeys(prop.getProperty("password"));
        } catch (NoSuchElementException nsee) {
            nsee.printStackTrace();
        }
    }

    public Home clickLoginBtn() {
        try {
            loginBtn.click();
        } catch (NoSuchElementException nsee) {
            nsee.printStackTrace();
        }
        return new Home();
    }

    public boolean checkLogo() {
        return logo.isDisplayed();
    }

}
