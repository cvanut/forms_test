package tests.forms;

import static com.liferay.gs.testFramework.SeleniumReadPropertyKeys.DRIVER;
import static com.liferay.gs.testFramework.SeleniumReadPropertyKeys.getDefaultPassword;
import static com.liferay.gs.testFramework.SeleniumReadPropertyKeys.getDefaultUsername;
import static com.liferay.gs.testFramework.SeleniumReadPropertyKeys.getLinkToLogOut;
import static com.liferay.gs.testFramework.SeleniumReadPropertyKeys.getUrlToHome;
import static com.liferay.gs.testFramework.SeleniumWaitMethods.waitMediumTime;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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
	
	@Before
	public void setup() {
		_formPage.clickOnContent();
		_formPage.clickOnForms();

	}

	@Test	
	public void deleteFirstForm() {
		_formPage.clickOnForms();
		_formPage.waitAddButtonAppear();

		By listElements = By.xpath(
				".//*[@id='_com_liferay_dynamic_data_mapping_form_web_portlet_DDMFormAdminPortlet_formInstanceSearchContainer']");
		
		do {
			_formPage.clickOnFormOptionMenu();
			_formPage.clickOnDeleteForm();
			_formPage.closeSuccessMessageAppear();
		} while (!DRIVER.findElement(listElements).getText().isEmpty());
		
		assertTrue(DRIVER.findElement(listElements).getText().isEmpty());
		
	}
	
	
	
	FormsPage _formPage = new FormsPage();
	private static final String _liferayPortalPassword = getDefaultPassword();
	private static final String _liferayPortalUser = getDefaultUsername();
	private static final LoginPage _loginPage = new LoginPage();

}
