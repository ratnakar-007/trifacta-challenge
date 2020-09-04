package com.trifacta.pages;

import com.trifacta.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Home extends Base {

    WebDriverWait wait;

    @FindBy(xpath = "//div[contains(text(), 'Welcome')]")
    private WebElement welcomeMsg;

    @FindBy(css = ".m-icon.help.tricon")
    private WebElement helpIcon;

    @FindBy(xpath = "//div[text()='About Trifacta Wrangler']")
    private WebElement aboutLink;

    @FindBy(xpath = "//h4[text()='Version']/following-sibling::p[1]")
    private WebElement versionText;

    @FindBy(css = ".close.tricon")
    private WebElement closeAboutBtn;

    @FindBy(css = "div[data-id='user-avatar']")
    private WebElement userAvatar;

    @FindBy(xpath = "//div[text()='Log out']")
    private WebElement logOutlnk;

    public Home() {
        wait = new WebDriverWait(driver, 20);
        PageFactory.initElements(driver, this);
    }

    public boolean checkUsername() {
        try {
            return welcomeMsg.getText().contains(prop.getProperty("name"));
        } catch (NoSuchElementException nsee) {
            nsee.printStackTrace();
            return false;
        }
    }

    public void clickHelpIcon() {
        try {
            helpIcon.click();
        } catch (NoSuchElementException nsee) {
            nsee.printStackTrace();
        }
    }

    public void clickAboutLink() {
        try {
            aboutLink.click();
        } catch (NoSuchElementException nsee) {
            nsee.printStackTrace();
        }
    }

    public String getVersionNumber() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//h4[text()='Version']/following-sibling::p[1]")));
            return versionText.getText();
        } catch (NoSuchElementException nsee) {
            return null;
        }
    }

    public void clickCloseAboutBtn() {
        try {
            closeAboutBtn.click();
        } catch (NoSuchElementException nsee) {
            nsee.printStackTrace();
        }
    }

    public void clickUserAvatar() {
        try {
            userAvatar.click();
        } catch (NoSuchElementException nsee) {
            nsee.printStackTrace();
        }
    }

    public void clickLogOutLink() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//div[text()='Log out']"))).click();
        } catch (NoSuchElementException nsee) {
            nsee.printStackTrace();
        }
    }
}
