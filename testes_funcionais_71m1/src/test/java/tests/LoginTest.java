package tests;

import static com.liferay.gs.testFramework.SeleniumReadPropertyKeys.DRIVER;
import static com.liferay.gs.testFramework.SeleniumReadPropertyKeys.getDefaultPassword;
import static com.liferay.gs.testFramework.SeleniumReadPropertyKeys.getDefaultUsername;
import static com.liferay.gs.testFramework.SeleniumReadPropertyKeys.getLinkToLogOut;
import static com.liferay.gs.testFramework.SeleniumReadPropertyKeys.getUrlToHome;

import static org.junit.Assert.assertTrue;

import pages.LoginPage;
import pages.WelcomePage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Manoel Cyreno
 */

public class LoginTest {

	@After
	public void afterTestMethod() throws Exception {
		DRIVER.get(getLinkToLogOut());
	}

	@Before
	public void beforeTestMethod() throws Exception {
		DRIVER.get(getUrlToHome());
	}

	@Test
	public void testLoginWithSuccess_validateLoginCanBeMadeWithSuccess_returnTrue() {
		_loginPage.clickOnSignIn();
		_loginPage.signInOnPortal(_liferayPortalUser, _liferayPortalPassword);
		assertTrue(
			_welcomePage.usernameIsDisplayed(_liferayPortalUsernameAcronym));
	}
	

	private final String _liferayPortalPassword = getDefaultPassword();
	private final String _liferayPortalUser = getDefaultUsername();
	private final String _liferayPortalUsernameAcronym = "TT";
	private final LoginPage _loginPage = new LoginPage();
	private final WelcomePage _welcomePage = new WelcomePage();

}