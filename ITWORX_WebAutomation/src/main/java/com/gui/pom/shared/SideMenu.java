package com.gui.pom.shared;

import org.openqa.selenium.By;

import com.shaft.driver.SHAFT;

public class SideMenu {
	/****************************************************************************
	*  >>	Variables
	*****************************************************************************/
	private static SHAFT.GUI.WebDriver  driver;

	
	/****************************************************************************
	*  >>	Constructor
	*****************************************************************************/
	public SideMenu (SHAFT.GUI.WebDriver  driver)
	{
		this.driver =driver;
	}
	
	/****************************************************************************
	*  >>	Locators
	*****************************************************************************/
    private final static By courses_Btn = By.id("btnMyCoursesList");
	private final static By user_Icon = By.xpath("(//*[@class='lms-user-profile-img lms-cursor-pointer'])");
	private final static By username_Label = By.xpath("(//h4[@class='lms-font-larger lms-margin-bottom-0 user-name'])[1]");


	/****************************************************************************
	*  >>	Keywords
	*****************************************************************************/
    public void openCoursesPage() {
    	driver.element()
    	.click(courses_Btn);
    }

}
