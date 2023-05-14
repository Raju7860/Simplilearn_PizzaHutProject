package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class PizzaHutWebPage {

	WebDriver driver;

	// Constructor
	public PizzaHutWebPage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//div[@class='notification-container notification-container__basket']//div")
	WebElement blackPopup;

	@FindBy(xpath = "(//div[@class='home-localise-product-box-overlap flex justify-start items-center flex-col'])[1]")
	WebElement popuplocation;

	@FindBy(xpath = "//input[@placeholder='Enter your location for delivery']")
	WebElement enterLocation;

	@FindBy(xpath = "//div[normalize-space()='Bhupendra Bose Avenue, Hati Bagan, Shyam Bazar, Kolkata, West Bengal, India']")
	WebElement selectLocation;

	@FindBy(xpath = "//a[contains(@class,'capitalize lg:border-r text-red lg:text-white side-menu__link--active')]//span[contains(text(),'Deals')]")
	WebElement dealstxt;

	@FindBy(xpath = "//div[@class='md:flex md:flex-col lg:flex-row container lg:justify-start lg:pl-15']//span[@class='rounded-full bg-white']")
	WebElement radioBtn;

	@FindBy(xpath = "//a[contains(@data-synth,'link--pizzas--side')]")
	WebElement pizzaOption;

	@FindBy(xpath = "//body/div[contains(@data-test,'app-container')]/div/div/div/div/div/div/span[contains(@data-testid,'pizzas')]/div/a[contains(@role,'button')]/div/div/button[contains(@data-synth,'button--mazedar-makhni-paneer-recommended-pan-medium--one-tap')]/span[1]")
	WebElement addBtn;

	@FindBy(xpath = "//div[@id='basket']")
	WebElement basket;

	@FindBy(xpath = "//span[@class='subtotal']")
	WebElement subtotal;

	@FindBy(xpath = "//div[@class='display-supplement-value']")
	WebElement restaurantCharge;

	@FindBy(xpath = "//span[contains(text(),'₹32.20')]")
	WebElement taxCharge;

	@FindBy(xpath = "//span[@class='amountdue']")
	WebElement payableAmount;
	
	@FindBy(xpath = "//span[contains(@class,'mr-auto text-left')]")
	WebElement itemUndercheckoutBtn;

	@FindBy(xpath = "//span[@data-synth='basket-value'][contains(text(),'₹676.20')]")
	WebElement priceUndercheckout;
	
	@FindBy(xpath = "//span[contains(@class,'bg-green-dark pl-5 pr-5 rounded')]")
	WebElement item2UndercheckoutBtn;

	@FindBy(xpath = "//span[@data-synth='basket-value'][contains(text(),'₹736.06')]")
	WebElement price2Undercheckout;


	@FindBy(xpath = "//a[contains(@data-synth,'link--drinks--side')]")
	WebElement drinkbtn;

	@FindBy(css = "button[data-synth='button--pepsi-600ml--one-tap']")
	WebElement addPespiBtn;

	@FindBy(xpath = "//button[@data-synth='basket-item-remove--mazedar-makhni-paneer-recommended-pan-medium']")
	WebElement removePizzaItem;

	@FindBy(xpath = "//button[@data-synth='link--checkout']//span[@class='absolute inset-0 flex-center']")
	WebElement checkoutButton;
	
	@FindBy(xpath = "//span[contains(text(),'Checkout')]")
	WebElement checkoutBtn;

	@FindBy(xpath = "//h3[contains(@class,'typography-2 mt-30')]//span[contains(text(),'You')]")
	WebElement minOrder;

	public void CloseBlackPopupScreen() {

		blackPopup.click();
	}

	public void PopUpScreenLocation() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		popuplocation.isDisplayed();
	}

	public void EnterDeliveryLocation(String Location)  {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		enterLocation.sendKeys(Location);

	}

	public void SelectFirstDropdownOption() {

		selectLocation.click();
	}

	public void navigateToDealPage() {

		dealstxt.click();
		String url = driver.getCurrentUrl();
		if (url.contains("deals")) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
	}

	public void RadioBtnFlag() {
		boolean RadioBtn = radioBtn.isSelected();
		if (RadioBtn) {

			System.out.println("radio button flag is on");

		} else {
			System.out.println("radio button flag is off");
		}

	}

	public void PizzaMenuBar() {
		pizzaOption.click();
	}

	public void AddMazedarMakhaniPizza() {
		addBtn.click();
	}

	public void YourBasket() {
		basket.isDisplayed();
		String Basket = basket.getText();
		System.out.println("Price added in Basket :" + Basket);
	}

	public void CheckoutPrice() {

		Float onlyPizzaPrice = Float.valueOf(subtotal.getText().replaceAll("₹", ""));
		System.out.println(onlyPizzaPrice);

		Float RetaurantCharge = Float.valueOf(restaurantCharge.getText().replaceAll("₹", ""));
		System.out.println(RetaurantCharge);

		Float TaxCharge = Float.valueOf(taxCharge.getText().replaceAll("₹", ""));
		System.out.println(TaxCharge);

		Float PayableAmount = Float.valueOf(payableAmount.getText().replaceAll("₹", ""));
		System.out.println(PayableAmount);
		
		if(onlyPizzaPrice+RetaurantCharge+TaxCharge==PayableAmount) {
			System.out.println("Pizza Price + Restaurant Charge + Tax Charge = Total Payable Amount as Expected");
		}else {
			System.out.println("Pizza Price + Restaurant Charge + Tax Charge != Total Payable Amount.....Failed");
		}
			

	}

	public void itemOptionUnderCheckoutBtn() {
		String ItemUndercheckoutBtn = itemUndercheckoutBtn.getText();
		System.out.println(ItemUndercheckoutBtn);
		boolean IemUndercheckoutBtn2 = itemUndercheckoutBtn.isDisplayed();
		Assert.assertTrue(IemUndercheckoutBtn2);

	}

	public void priceUnderCheckoutBtn() {
		
		String PriceUndercheckout = priceUndercheckout.getText();
		System.out.println(PriceUndercheckout);
		boolean PriceUndercheckout2 = priceUndercheckout.isDisplayed();
		Assert.assertTrue(PriceUndercheckout2);
	}

	public void ClickDrinkBtn() {
		drinkbtn.click();
	}

	public void ClickAddPepsiBtn() {
		addPespiBtn.click();
	}

	public void NowTotalItemCheckoutBtn() {
//		boolean Totalitem = checkoutBtn.isDisplayed();
//		Assert.assertTrue(Totalitem);
//		String totalItem2 = checkoutBtn.getText();
//		System.out.println(totalItem2);
		Assert.assertTrue(item2UndercheckoutBtn.getText().contains(String.valueOf(2)));
	}

	public void NowPriceUnderCheckoutBtn() {
		boolean TotaPrice = price2Undercheckout.isDisplayed();
		Assert.assertTrue(TotaPrice);
		String TotaPrice2 = price2Undercheckout.getText();
		System.out.println(TotaPrice2);
		
	
	}

	public void RemovePizzaItemFromYourBasket() {
		removePizzaItem.click();
	}

	public void NotDisplayingPriceInCheckoutBtn() {
		String CheckOutbtn = checkoutButton.getText();
		System.out.println(CheckOutbtn);

		boolean CheckOutbtn2 = checkoutButton.isDisplayed();
		Assert.assertTrue(CheckOutbtn2);

	}

	public void ClickOnCheckoutBtn() {
		checkoutBtn.click();
	}

	public void MinOrderShowing() {
		boolean MinOrder = minOrder.isDisplayed();
		Assert.assertTrue(MinOrder);

		String minOrder2 = minOrder.getText();
		System.out.println(minOrder2);

	}
}
