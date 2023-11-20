package com.tests;

import com.gui.pom.allCoursesPage.AllCoursesPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gui.pom.HomePage.HomePage;
import com.gui.pom.LoginPage.LoginPage;
import com.shaft.driver.SHAFT;

public class E2E_TCs {
	SHAFT.GUI.WebDriver  driver ;
	SHAFT.TestData.JSON testData;


	@Test
	public void E2E() {
		new LoginPage(driver).login(testData.getTestData("email"),
						testData.getTestData("password"))
		.navigateToCourses()
		.addCourse()
		.fillBasicInfo(testData.getTestData("basicInfo.courseName"),
				testData.getTestData("basicInfo.grade"),
				Integer.parseInt(testData.getTestData("basicInfo.courseTeacherIndex")))
		.verifyAlerMsg("Course is added successfully")
		.verifyCreatedCourseName(testData.getTestData("basicInfo.courseName"));
		
		new HomePage(driver).navigateToCourses()
		.orderCourse(AllCoursesPage.CourseOrder.CREATION_DATE_DESCENDING.getOrderValue())
		.verifyFristCourseName(testData.getTestData("basicInfo.courseName"));
		
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
