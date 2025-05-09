package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewArticelTest 
{
	
	@FindBy(linkText = "New Article")
	WebElement newArticleLnk;
	
	@FindBy(name = "title")
	WebElement articleTitle;
	
	@FindBy(xpath =  "//input[@name = 'description']")
	WebElement articleDesc;
	
	@FindBy(name = "body")
	WebElement articleBody;
	
	@FindBy(name = "tags")
	WebElement articleTags;
	
	@FindBy(css = "button.btn.btn-lg.pull-xs-right.btn-primary")
	WebElement publishArticleBtn;
	
	
	public NewArticelTest(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void publishArticle(String titleTxt, String descriptionTxt, String bodyTxt, String tagsText)
	{
		newArticleLnk.click();
		articleTitle.sendKeys(titleTxt);
		articleDesc.sendKeys(descriptionTxt);
		articleBody.sendKeys(bodyTxt);
		articleTags.sendKeys(tagsText);
		publishArticleBtn.click();
	}

}
