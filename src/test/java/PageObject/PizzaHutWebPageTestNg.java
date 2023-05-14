package PageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class PizzaHutWebPageTestNg {
	
	WebDriver driver;
	Actions actions;

	public PizzaHutWebPageTestNg(WebDriver driver) {
		
	
		this.driver = driver;

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@placeholder='Enter your location for delivery']")
	WebElement enterLocation;

	@FindBy(xpath = "//div[normalize-space()='Bhupendra Bose Ave']")
	WebElement select;

	@FindBy(xpath = "//a[contains(@class,'capitalize lg:border-r text-red lg:text-white side-menu__link--active')]//span[contains(text(),'Deals')]")
	WebElement dealstxt;

	@FindBy(xpath = "//a[contains(@data-synth,'link--sides--side')]")
	WebElement sides;

	@FindBy(xpath = "//body/div[contains(@data-test,'app-container')]/div/div/div/div/div/div/span[contains(@data-testid,'sides')]/div/a[contains(@role,'button')]/div/div/button[contains(@data-synth,'button--sprinkled-fries-single--one-tap')]/span[1]")
	WebElement sprinkledfries;

	@FindBy(xpath = "//div[@id='basket']")
	WebElement yourBasket;

	@FindBy(xpath = "//div[contains(@class,'p-15 pt-10')]")
	WebElement checkoutBtn;

	@FindBy(xpath = "//a[contains(@data-synth,'link--drinks--side')]")
	WebElement drinks;

	@FindBy(css = "button[data-synth='button--pepsi-600ml--one-tap']")
	WebElement pepsi;

	@FindBy(css = "button[data-synth='button--mirinda-600ml--one-tap']")
	WebElement mirinda;

	@FindBy(xpath = "//label[@for='payment-method--razorpay']")
	WebElement radioBtnOnlinePayment;

	@FindBy(xpath = "//label[@for='payment-method--cash']")
	WebElement cash;
	
	@FindBy(xpath = "//span[normalize-space()='I agree to receive promotional communication.']")
	WebElement checkbox;
	
	@FindBy(xpath = "//input[@id='checkout__name']")
	WebElement nameField;
	
	@FindBy(xpath = "//input[@id='checkout__phone']")
	WebElement mobileField;
	
	@FindBy(xpath = "//input[@id='checkout__email']")
	WebElement emailField;
	
	@FindBy(xpath = "//div[@class='sc-fzqMdD eohbfP']")
	WebElement giftCard;
	
	@FindBy(xpath="//div[contains(@class,'sc-fznMnq gdZumo')]")
	WebElement voucher;
	
	@FindBy(xpath="//input[@placeholder='e.g. ABC1234']")
	WebElement voucherCodeField;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement redeemBtn;
	
	@FindBy(xpath="//span[contains(text(),'Sorry, we don’t currently support that voucher cod')]")
	WebElement errorMessage;
	
	@FindBy(xpath="//button[contains(@class,'icon-remove-3 absolute top-0 right-0 mr-20 mt-20')]")
	WebElement removeIcon;

	public void enterDeliveryLocation() {
		enterLocation.sendKeys("BHUPENDRA BOSE AVE, SHYAM BAZAR");

	}

	public void selectFirstDropdown() {
		select.click();
	}

	public void validateUrlContainDealTxt() {

		dealstxt.click();
		String url = driver.getCurrentUrl();
		if (url.contains("deals")) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}

	}

	public void clickOnSides() {
		sides.click();
	}

	public void clickOnAddBtn() {
		sprinkledfries.click();

	}

	public void validatePriceAddedUnderYourBasket() {
		String YourBasket = yourBasket.getText();

		Assert.assertTrue(YourBasket.contains("Sprinkled Fries"));

	}

	public void validatePriceNotShowingInCheckoutBtn() {
		String CheckoutBtn = checkoutBtn.getText();
		Assert.assertFalse(CheckoutBtn.contains("price"));
	}

	public void navigateToDrinksPage() {
		drinks.click();
	}

	public void addPepsiAndMirindaInYourBasket() {

		pepsi.click();
		mirinda.click();
	}

	public void clickOnCheckoutBtn() {
try {
	Thread.sleep(0);
} catch (InterruptedException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
		checkoutBtn.click();

	}

	public void validateOnlinePaymentRadioBtnSelectedByDefault() {

		Assert.assertTrue(radioBtnOnlinePayment.isEnabled());
	}

	public void selectCashPaymentMode() {
		cash.click();
		
	}
	
	public void validateCheckboxSelectedByDefault() {
		if(checkbox.isEnabled()) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}

	}
	
	
	public void enterName() {
//		actions= new Actions(driver);
//		Action name=actions
//				.moveToElement(nameField)
//				.click()
//				.sendKeys("Raju Sharma").build();
//		
//			name.perform();	
		nameField.sendKeys("Raju sharma",Keys.TAB);

	}
	
	public void enterMobileNum() {
//		Action mobile=actions
//				.moveToElement(mobileField)
//				.click()
//				.sendKeys("8285345678").build();
//		mobile.perform();
		mobileField.sendKeys("8285345678",Keys.TAB);
	}
	
	public void enterEmailAddress() {
//		Action email=actions
//				.moveToElement(emailField)
//				.click()
//				.sendKeys("raju123@gmail.com").build();
//		email.perform();
		emailField.sendKeys("raju123@gmail.com",Keys.TAB);
	}
	
	public void clickOnApplyGiftCard() {

			giftCard.click();
				
	}
	
	public void clickOnVoucher() {
	
		voucher.click();
		
	}
	
	public void enterVoucherCode() {
		voucherCodeField.sendKeys("1234567");
	}

	public void clickOnRedeemBtn() {
		redeemBtn.click();
	}
	
	public void validateErrorMessage() {
		boolean ErrorMessage = errorMessage.isDisplayed();
		Assert.assertTrue(ErrorMessage);
	}

	public void clickOnRemoveIconOnPopupWindow() {
		removeIcon.click();
	}
	
	
	
	
}
