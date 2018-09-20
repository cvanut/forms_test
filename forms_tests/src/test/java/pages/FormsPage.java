package pages;

import static com.liferay.gs.testFramework.SeleniumReadPropertyKeys.DRIVER;
import static utils.CommonMethods.waitElement;
import static utils.CommonMethods.waitElementAppearOnScreen;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class FormsPage {
	
	// command + option + R = rename all variables at the same time 

	public void clickOnContent() {
		waitElement(_contentLinkLocator);
		DRIVER.findElement(_contentLinkLocator).click();
	}

	public void clickOnForms() {
		waitElement(_formsLinkLocator);
		DRIVER.findElement(_formsLinkLocator).click();
	}

	public void clickOnAddButton() {
		waitElementAppearOnScreen(_addFormButttonLocator);
		waitElement(_addFormButttonLocator);
		DRIVER.findElement(_addFormButttonLocator).click();
	}

	public void fillFormTitle(String text) {
		waitElement(_formTitleLocator);
		DRIVER.findElement(_formTitleLocator).sendKeys(text);
	}

	public void fillFormDescription(String text) {
		waitElement(_formDescriptionLocator);
		DRIVER.findElement(_formDescriptionLocator).sendKeys(text);
	}

	public void fillFormPageTitle(String text) {
		waitElement(_formDescriptionLocator);
		DRIVER.findElement(_formPageTitleLocator).sendKeys(text);
	}

	public void clickFieldToAddOnForm() {

		Actions builder = new Actions(DRIVER);
		Action dragAndDrop = builder.clickAndHold(DRIVER.findElement(_dragTextFieldLocator))

				.moveToElement(DRIVER.findElement(_dropContainerLocator))
				.release(DRIVER.findElement(_dropContainerLocator)).build();
		dragAndDrop.perform();
	}
	
	public void fillTextLabelInput(String text) {
		waitElement(_textFieldLabelInputLocator);
		DRIVER.findElement(_textFieldLabelInputLocator).sendKeys(text);
	}
	
	public void fillHelpTextInput(String text) {
		waitElement(_textFieldHelpLocator);
		DRIVER.findElement(_textFieldHelpLocator).sendKeys(text);
	}
	
	private final By _formsLinkLocator = By.xpath(
			// how to use: //*[contains(@id,'')q]
			".//*[@id='_com_liferay_product_navigation_product_"
				+ "menu_web_portlet_ProductMenuPortlet_portlet_com_"
					+ "liferay_dynamic_data_mapping_form_web_portlet_"
						+ "DDMFormAdminPortlet']");

	private final By _contentLinkLocator = By.xpath(
			".//*[@id='_com_liferay_product_navigation_product_menu_web_portlet_ProductMenuPortlet_site_administrationCollapse']/div/div[2]/a[2]");

	private final By _addFormButttonLocator = By.xpath(".//a[@class='btn btn-primary nav-btn nav-btn-monospaced']");

	private final By _formTitleLocator = By.xpath(".//div[@class='alloy-editor-container']//div");

	private final By _formDescriptionLocator = By.xpath(".//h5//div[@class='alloy-editor-container']//div");

	private final By _formPageTitleLocator = By
			.xpath(".//*[@class='form-builder-page-header form-inline']//textarea[1]");

	private final By _dragTextFieldLocator = By
			.xpath(".//*[contains(@class,'list-group-title') and contains(text(),'Text Field')]");
	
	private final By _dropContainerLocator = By.xpath(".//*[@id='lfr-initial-col-message']");
	
	private final By _textFieldLabelInputLocator = By
			.xpath(".//input[@placeholder='Enter a field label.']");
	
	private final By _textFieldHelpLocator = By
			.xpath(".//input[@placeholder='Enter help text.']");
	
	private final By _publishFormLocator = By
			.xpath(".//*[@class='lfr-btn-label']");
	
	public void clickOnPublishFormButton() {
		waitElement(_publishFormLocator);
		DRIVER.findElement(_publishFormLocator).click();
	}
}
