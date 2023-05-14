package TestNg;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ExtentReports.ExtentTestReport;
import PageObject.PizzaHutWebPageTestNg;
import Utilities.GetDataFromExcel;
import io.github.bonigarcia.wdm.WebDriverManager;

public class pizzahut001 extends ExtentTestReport {

	

	public static WebDriver driver=new ChromeDriver();

	GetDataFromExcel obj;
	
	
	
	@BeforeTest
	public void openBrowser() {
		WebDriverManager.chromedriver().setup();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		try {
			driver.get(GetDataFromExcel.getURL());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		obj = new GetDataFromExcel();
		
	}
		

	@Test
	public void testExecutionPizzaHutWebPage() {
		ConfigReport();
		CreateTest();
		
		PizzaHutWebPageTestNg pizzahut = new PizzaHutWebPageTestNg(driver);
		
		pizzahut.enterDeliveryLocation();
		
		pizzahut.selectFirstDropdown();
		pizzahut.validateUrlContainDealTxt();
		pizzahut.clickOnSides();
		pizzahut.clickOnAddBtn();
		pizzahut.validatePriceAddedUnderYourBasket();
		pizzahut.validatePriceNotShowingInCheckoutBtn();
		pizzahut.navigateToDrinksPage();
		pizzahut.addPepsiAndMirindaInYourBasket();
		pizzahut.clickOnCheckoutBtn();
		pizzahut.validateOnlinePaymentRadioBtnSelectedByDefault();
		pizzahut.selectCashPaymentMode();
		pizzahut.validateCheckboxSelectedByDefault();
		pizzahut.enterName();
		pizzahut.enterMobileNum();
		pizzahut.enterEmailAddress();
		pizzahut.clickOnApplyGiftCard();
		pizzahut.clickOnVoucher();
		pizzahut.enterVoucherCode();
		pizzahut.clickOnRedeemBtn();
		pizzahut.validateErrorMessage();
		pizzahut.clickOnRemoveIconOnPopupWindow();
		
		
	}
	
	@AfterTest
	public void testCompleted() {
		
		FlushTest();
	}

}
