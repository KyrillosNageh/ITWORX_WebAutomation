package com.gui.pom.HomePage;

import com.gui.pom.allCoursesPage.AllCoursesPage;
import com.gui.pom.shared.SideMenu;
import com.shaft.driver.SHAFT;

public class HomePage {
	/****************************************************************************
	*  >>	Variables
	*****************************************************************************/
	private static SHAFT.GUI.WebDriver  driver;
	private static SideMenu sideMenu;
	
	/****************************************************************************
	*  >>	Constructor
	*****************************************************************************/
	public HomePage (SHAFT.GUI.WebDriver  driver)
	{
		HomePage.driver =driver;
		HomePage.sideMenu = new SideMenu(driver);
	}
	
	/****************************************************************************
	*  >>	Locators
	*****************************************************************************/

    
	/****************************************************************************
	*  >>	Keywords
	*****************************************************************************/
    public AllCoursesPage navigateToCourses() {
    	sideMenu.openCoursesPage();   	
    	return new AllCoursesPage(driver);
    }
    
	/****************************************************************************
	*  >>	Assertions & Verifications
	*****************************************************************************/
    public HomePage verifyPageUrl(String url) {
    	driver.browser()
    	.assertThat()
    	.url()
    	.contains(url)
    	.perform();
    	return this;
    }

	public HomePage verifyUsername(String name) {


		return this;
	}


}
