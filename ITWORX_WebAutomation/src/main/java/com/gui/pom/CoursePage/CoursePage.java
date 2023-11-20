package com.gui.pom.CoursePage;

import org.openqa.selenium.By;

import com.gui.pom.shared.SideMenu;
import com.shaft.driver.SHAFT;

public class CoursePage {
	/****************************************************************************
	*  >>	Variables
	*****************************************************************************/
	private static SHAFT.GUI.WebDriver  driver;
	private static SideMenu sideMenu;
	
	/****************************************************************************
	*  >>	Constructor
	*****************************************************************************/
	public CoursePage (SHAFT.GUI.WebDriver  driver)
	{
		this.driver =driver;
		this.sideMenu = new SideMenu(driver);
	}
	
	/****************************************************************************
	*  >>	Locators
	*****************************************************************************/
    private final static By courseName_Label = By.id("courseNameView");
    private final static By alert_Msg = By.className("toast-message");
    private final static By courseTeacher_Selector = By.xpath("(//input[@placeholder='Course Teacher'])");
    private final static By save_Btn = By.id("btnSaveCourse");
    
	/****************************************************************************
	*  >>	Keywords
	*****************************************************************************/
    
    
    /****************************************************************************
	*  >>	Assertions & Verifications
	*****************************************************************************/
    public CoursePage verifyCreatedCourseName(String courseName ) {
    	driver.assertThat()
    	.element(courseName_Label)
    	.text()
    	.contains(courseName);
    	return new CoursePage(driver);
    }
    
    //Course is added successfully.
    public CoursePage verifyAlerMsg(String message ) {
		driver.element()
				.waitToBeReady(alert_Msg);

		driver.assertThat()
    	.element(alert_Msg)
    	.text()
    	.contains(message);
    	return new CoursePage(driver);
    }
    
}
