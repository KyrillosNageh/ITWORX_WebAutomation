package com.gui.pom.allCoursesPage;

import org.openqa.selenium.By;

import com.gui.pom.AddCoursePage.AddCousrePage;
import com.gui.pom.shared.SideMenu;
import com.shaft.driver.SHAFT;

public class AllCoursesPage {
	/****************************************************************************
	*  >>	Variables
	*****************************************************************************/
	private static SHAFT.GUI.WebDriver  driver;
	private static SideMenu sideMenu;


	public enum CourseOrder {
		NAME_ASCENDING(0),
		NAME_DESCENDING(1),
		CREATION_DATE_ASCENDING(2),
		CREATION_DATE_DESCENDING(3);

		private final int orderValue;

		CourseOrder(int orderValue) {
			this.orderValue = orderValue;
		}

		public int getOrderValue() {
			return orderValue;
		}
	}
	
	/****************************************************************************
	*  >>	Constructor
	*****************************************************************************/
	public AllCoursesPage (SHAFT.GUI.WebDriver  driver)
	{
		AllCoursesPage.driver =driver;
		AllCoursesPage.sideMenu = new SideMenu(driver);
	}
	
	/****************************************************************************
	*  >>	Locators
	*****************************************************************************/
    private final static By addCourse_Btn = By.id("btnListAddCourse");
    private final static By coursesOrder_Selector = By.id("CoursesOrderBy");
    private static By getCourseName(int index) {
    	return By.xpath("(//*[@id='lnkListCourseSelcted'])["+ index +"]");
    }

	/****************************************************************************
	*  >>	Keywords
	*****************************************************************************/
    public AddCousrePage addCourse() {
    	driver.element()
    	.click(addCourse_Btn);
    	return new AddCousrePage(driver);
    }
    
    public AllCoursesPage orderCourse(int order) {
    	driver.element()
    	.select(coursesOrder_Selector, String.valueOf(order));
    	return this;
    }
    
	/****************************************************************************
	*  >>	Assertions & Verifications
	*****************************************************************************/
    public AllCoursesPage verifyPageUrl(String url) {
    	driver.browser()
    	.assertThat()
    	.url()
    	.contains(url)
    	.perform();
    	return this;
    }
    
    public AllCoursesPage verifyFristCourseName(String courseName) {
    	driver.assertThat()
    	.element(getCourseName(1))
    	.text()
    	.contains(courseName)
    	.perform();
    	return this;
    }
    
}
