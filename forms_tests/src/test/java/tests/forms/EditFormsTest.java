package tests.forms;

import static com.liferay.gs.testFramework.SeleniumReadPropertyKeys.DRIVER;
import static com.liferay.gs.testFramework.SeleniumReadPropertyKeys.getDefaultPassword;
import static com.liferay.gs.testFramework.SeleniumReadPropertyKeys.getDefaultUsername;
import static com.liferay.gs.testFramework.SeleniumReadPropertyKeys.getLinkToLogOut;
import static com.liferay.gs.testFramework.SeleniumReadPropertyKeys.getUrlToHome;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import pages.FormsPage;
import pages.LoginPage;

public class EditFormsTest {
	
	@AfterClass
	public static void afterTestClass() throws Exception {
		DRIVER.get(getLinkToLogOut());
	}

	@BeforeClass
	public static void beforeTestClass() throws Exception {
		DRIVER.get(getUrlToHome());
		_loginPage.clickOnSignIn();
		_loginPage.signInOnPortal(_liferayPortalUser, _liferayPortalPassword);
	}

	@Test	
	public void createNewForm() {
		_formPage.clickOnContent();
	}
	
	FormsPage _formPage = new FormsPage();
	private static final String _liferayPortalPassword = getDefaultPassword();
	private static final String _liferayPortalUser = getDefaultUsername();
	private static final LoginPage _loginPage = new LoginPage();

}
