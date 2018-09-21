package pages;

import static com.liferay.gs.testFramework.SeleniumReadPropertyKeys.DRIVER;
import static utils.CommonMethods.input;
import static utils.CommonMethods.waitElement;

import org.openqa.selenium.By;

public class LoginPage {
	

	public void clickOnSignIn() {
		waitElement(_signInLocator);
		DRIVER.findElement(_signInLocator).click();
	}

	public void clickOnSignInOfTheModal() {
		waitElement(_signInButtonOnModalLocator);
		DRIVER.findElement(_signInButtonOnModalLocator).click();
	}

	public void fillEmailAddressField(String userLogin) {
		input(_emailAddressLocator, userLogin);
	}

	public void fillPasswordField(String userPassword) {
		input(_passwordLocator, userPassword);
	}

	public void signInOnPortal(String emailAddress, String password) {
		fillEmailAddressField(emailAddress);
		fillPasswordField(password);
		clickOnSignInOfTheModal();
	}

	private final By _emailAddressLocator = By.xpath(
			".//*[@id='_com_liferay_login_web_portlet_LoginPortlet_login']");
	private final By _passwordLocator = By.xpath(
		".//*[@id='_com_liferay_login_web_portlet_LoginPortlet_password']");
	private final By _signInButtonOnModalLocator = By.xpath(
		".//*[contains(" +
			"@id, '_com_liferay_login_web_portlet_LoginPortlet') and " +
				"contains(@type,'submit')]");
	private final By _signInLocator = By.xpath(
		".//*[@id='p_p_id_com_liferay_product_" +
			"navigation_user_personal_bar_web_portlet_" +
				"ProductNavigationUserPersonalBarPortlet_']");

}
