package com.gui.pom.LoginPage;

import org.openqa.selenium.By;

import com.gui.pom.HomePage.HomePage;
import com.shaft.driver.SHAFT;

public class LoginPage {

	/****************************************************************************
	*  >>	Variables
	*****************************************************************************/
	private static SHAFT.GUI.WebDriver  driver;

	
	/****************************************************************************
	*  >>	Constructor
	*****************************************************************************/
	public LoginPage (SHAFT.GUI.WebDriver  driver)
	{
		LoginPage.driver =driver;
	}
	
	/****************************************************************************
	*  >>	Locators
	*****************************************************************************/
    private final static By email_Textbox = By.id("Email");
    private final static By password_Textbox = By.id("inputPassword");
    private final static By login_Btn = By.id("btnLogin");
    
	/****************************************************************************
	*  >>	Keywords
	*****************************************************************************/
    public HomePage login(String username, String Password) {
	   driver.element()
	   .type(email_Textbox, username)
	   .type(password_Textbox, Password)
	   .click(login_Btn);
	   return new HomePage(driver);
   }
}
