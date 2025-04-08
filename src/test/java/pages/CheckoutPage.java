package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
	
	@FindBy(id="first-name")
	WebElement firstName;
	
	@FindBy(id="last-name")
	WebElement lastName;
	
	@FindBy(id="postal-code")
	WebElement zip;
	
	@FindBy(id="cancel")
	WebElement cancelBtn;
	
	@FindBy(id="continue")
	WebElement continueBtn;
	
	public CheckoutPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}	
	
	public void enterCustomerDetails(String fName, String lName, String zCode)
	{
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		zip.sendKeys(zCode);		
		continueBtn.click();
	}
	
	public void clickCancelBtn()
	{
		cancelBtn.clear();
	}
}
