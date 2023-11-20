package com.gui.pom.AddCoursePage;

import org.openqa.selenium.By;

import com.gui.pom.CoursePage.CoursePage;
import com.gui.pom.allCoursesPage.AllCoursesPage;
import com.gui.pom.shared.SideMenu;
import com.shaft.driver.SHAFT;
import org.sikuli.script.Key;

public class AddCousrePage {
	/****************************************************************************
	*  >>	Variables
	*****************************************************************************/
	private static SHAFT.GUI.WebDriver  driver;
	private static SideMenu sideMenu;
	
	/****************************************************************************
	*  >>	Constructor
	*****************************************************************************/
	public AddCousrePage (SHAFT.GUI.WebDriver  driver)
	{
		this.driver =driver;
		this.sideMenu = new SideMenu(driver);
	}
	
	/****************************************************************************
	*  >>	Locators
	*****************************************************************************/
    private final static By courseName_Textbox = By.id("txtCourseName");
    private final static By grade_Selector = By.id("courseGrade");

	private final static By courseTeacher_label = By.xpath("(//*[@class='ui-select-placeholder text-muted'])");
    private final static By courseTeacher_Selector = By.xpath("(//input[@placeholder='Course Teacher'])");
    private final static By create_Btn = By.id("btnSaveAsDraftCourse");

	private final static By userRole_Textbox(int index) {
		return By.xpath("(//*[@id='UserRole'])["+ index +"]");
	}

    
	/****************************************************************************
	*  >>	Keywords
	*****************************************************************************/
    public CoursePage fillBasicInfo(String courseName, String grade, int CourseTeacherIndex ) {
    	driver.element()
				.type(courseName_Textbox, courseName)
				.select(grade_Selector, grade)
				.click(courseTeacher_label)
				.click(userRole_Textbox(CourseTeacherIndex))
    			//.type(courseTeacher_Selector, CourseTeacher)
				//.type(courseTeacher_Selector, Key.ENTER)
    			.click(create_Btn);
    	
    	return new CoursePage(driver);
    }
    
	/****************************************************************************
	*  >>	Assertions & Verifications
	*****************************************************************************/
}
