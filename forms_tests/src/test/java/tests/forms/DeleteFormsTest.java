package tests.forms;

import static com.liferay.gs.testFramework.SeleniumReadPropertyKeys.DRIVER;
import static com.liferay.gs.testFramework.SeleniumReadPropertyKeys.getDefaultPassword;
import static com.liferay.gs.testFramework.SeleniumReadPropertyKeys.getDefaultUsername;
import static com.liferay.gs.testFramework.SeleniumReadPropertyKeys.getLinkToLogOut;
import static com.liferay.gs.testFramework.SeleniumReadPropertyKeys.getUrlToHome;
import static com.liferay.gs.testFramework.SeleniumWaitMethods.waitMediumTime;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pages.FormsPage;
import pages.LoginPage;

public class DeleteFormsTest {
	
	@AfterClass
	public static void afterTestClass() throws Exception {
		DRIVER.get(getUrlToHome() + getLinkToLogOut());
		DRIVER.close();
		waitMediumTime();
		waitMediumTime();
		waitMediumTime();
		DRIVER.quit();
	}

	@BeforeClass
	public static void beforeTestClass() throws Exception {
		DRIVER.get(getUrlToHome());
		_loginPage.clickOnSignIn();
		_loginPage.signInOnPortal(_liferayPortalUser, _liferayPortalPassword);
	}

	@Test	
	public void deleteFirstForm() {
		_formPage.clickOnContent();
		_formPage.clickOnForms();
		_formPage.clickOnFormOptionMenu();
		_formPage.clickOnDeleteForm();
		
	}
	
	
	
	FormsPage _formPage = new FormsPage();
	private static final String _liferayPortalPassword = getDefaultPassword();
	private static final String _liferayPortalUser = getDefaultUsername();
	private static final LoginPage _loginPage = new LoginPage();

}
