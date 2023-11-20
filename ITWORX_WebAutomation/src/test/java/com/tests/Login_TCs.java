package com.tests;

import com.gui.pom.LoginPage.LoginPage;
import com.shaft.driver.SHAFT;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login_TCs {
    SHAFT.GUI.WebDriver  driver ;
    SHAFT.TestData.JSON testData;

    @Test
    public void VerifyLoginWithValidData(){
        new LoginPage(driver).login(testData.getTestData("email"),
                testData.getTestData("password"))
                .verifyPageUrl("/Org#!/Reporting/");
    }

    @BeforeMethod
    public void beforeMethod() {
        driver = new SHAFT.GUI.WebDriver();
        driver.browser().navigateToURL(SHAFT.Properties.web.baseURL());
        testData = new SHAFT.TestData.JSON("testRegister.json");
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(){
        driver.quit();
    }
}
