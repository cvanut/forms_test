package pages;

import static com.liferay.gs.testFramework.SeleniumReadPropertyKeys.DRIVER;
import static org.junit.Assert.assertTrue;
import static utils.CommonMethods.input;
import static utils.CommonMethods.waitElement;
import static utils.CommonMethods.waitElementAppearOnScreen;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import com.liferay.gs.testFramework.SeleniumWaitMethods;

import org.openqa.selenium.By;

public class FormsPage {
	
	public void clickOnContent () {
		waitElement(_contentLocator);
		DRIVER.findElement(_contentLocator).click();
	}
	
	public void clickOnForms (){
		waitElement(_formsLinkLocator);
		DRIVER.findElement(_formsLinkLocator).click();
	}
	
	public void clickOnAddButton (){
		waitElementAppearOnScreen(_addFormButttonLocator);
		waitElement(_addFormButttonLocator);
		DRIVER.findElement(_addFormButttonLocator).click();
	}
	
	public void fillFormTitle (String text) {
		waitElement(_formTitleLocator);
		DRIVER.findElement(_formTitleLocator).sendKeys(text);
	}
	
	public void fillFormDescription (String text) {
		waitElement(_formDescriptionLocator);
		DRIVER.findElement(_formDescriptionLocator).sendKeys(text);
	}
	
	public void fillFormPageTitle (String text) {
		waitElement(_formDescriptionLocator);
		DRIVER.findElement(_formPageTitleLocator).sendKeys(text);
	}
	
	
	public void clickFieldToAddOnForm() {
		
		Actions builder = new Actions(DRIVER);
	    Action dragAndDrop = builder.clickAndHold(DRIVER.findElement(fieldLocator))

		.moveToElement(DRIVER.findElement(To))
		.release(DRIVER.findElement(To))	
		.build();
	      dragAndDrop.perform();
	
	}
	
	/*
	public void clickFieldToAddOnForm(String fieldToAddOnForm) {
		waitElement(addFieldLocator);
		DRIVER.findElement(addFieldLocator).click();

		By fieldToAddOnFormLocator = By
				.xpath(".//*[contains(@class, 'form-builder-field-types-list')]//*[contains(text(), '"
						+ fieldToAddOnForm + "')]");

		waitElement(fieldToAddOnFormLocator);
		DRIVER.findElement(fieldToAddOnFormLocator).click();
		
		SeleniumWaitMethods.waitLongTime();
		By loaderLocator = By.xpath(".//*[contains(@class,'loading-icon')]");
		DRIVER.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
		try {
			while (DRIVER.findElement(loaderLocator).isDisplayed()) {
				SeleniumWaitMethods.waitShortTime();
			}
		} catch (Exception e) {
			System.out.println("The loader is not appear anymore");
		}

		By fieldOnScreen = By.cssSelector(".form-builder-field-content-target");

		assertTrue(DRIVER.findElement(fieldOnScreen).isDisplayed());
		
	}
	*/
	
	private final By _formsLinkLocator = By.xpath(
			//how to use: //*[contains(@id,'')q]
			"//*[@id=\"_com_liferay_product_navigation_product_menu_web_portlet_ProductMenuPortlet_portlet_com_liferay_dynamic_data_mapping_form_web_portlet_DDMFormAdminPortlet\"]"
			);
	
	private final By _contentLocator = By.xpath(
			"//*[@id=\"_com_liferay_product_navigation_product_menu_web_portlet_ProductMenuPortlet_site_administrationCollapse\"]/div/div[2]/a[2]"
			);
	
	private final By _addFormButttonLocator = By.xpath(
			"//a[@class='btn btn-primary nav-btn nav-btn-monospaced']"
	);
	
	private final By _formTitleLocator = By.xpath(
			"//div[@class='alloy-editor-container']//div"
	);
	
	private final By _formDescriptionLocator = By.xpath(
			"//h5//div[@class='alloy-editor-container']//div"
			);
	
	private final By _formPageTitleLocator = By.xpath(
			"//*[@class='form-builder-page-header form-inline']//textarea[1]"
			);
	
	private final By fieldLocator = By.xpath(
			".//*[contains(@class,'list-group-title') and contains(text(),'Text Field')]");

	private final By To = By.xpath(
			".//*[@id='lfr-initial-col-message']");

}
