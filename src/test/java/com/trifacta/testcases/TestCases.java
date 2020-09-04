package com.trifacta.testcases;

import com.aventstack.extentreports.Status;
import com.trifacta.base.Base;
import com.trifacta.pages.Home;
import com.trifacta.pages.Login;
import com.trifacta.report.ExtentListeners;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestCases extends Base {
    boolean ui = true;
    Login loginPage;
    Home homePage;
    ExtentListeners extentListeners;

    public TestCases() {
        super();
    }

    @BeforeMethod
    public void setup() {
        if (ui) {
            init();
            ui = false;
        }
        loginPage = new Login();
        homePage = new Home();
        extentListeners = new ExtentListeners();
    }

    @Test
    public void testCase1() {
        loginPage.checkLogo();
        loginPage.enterEmail();
        test.log(Status.INFO, "email entered");
        extentListeners.takeScreenShot();
        loginPage.enterPassword();
        test.log(Status.INFO, "password entered");
        extentListeners.takeScreenShot();
        homePage = loginPage.clickLoginBtn();

        if (!homePage.checkUsername()) {
            Assert.fail("Wrong username displayed.");
        }
        test.log(Status.INFO, "Home Page");
        extentListeners.takeScreenShot();
        homePage.clickHelpIcon();
        homePage.clickAboutLink();
        String versionNumber = homePage.getVersionNumber();
        test.log(Status.INFO, "Product version: " + versionNumber);
        extentListeners.takeScreenShot();
        Assert.assertTrue(versionNumber.length()>0, "Product Version: " +versionNumber);
        System.out.println(versionNumber);
        homePage.clickCloseAboutBtn();

        //logout from application
        homePage.clickUserAvatar();
        homePage.clickLogOutLink();
        test.log(Status.INFO, "Logged Out");
        extentListeners.takeScreenShot();
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
