package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditArticlePage {
	
	@FindBy(xpath="(//a[contains(text(),' Edit Article')])[1]")
	WebElement editArticleLnk;
	
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
	
	public EditArticlePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void editArticle(String articleTitleTxt, String descriptionTxt, String bodyTxt, String tagsText)
	{
		editArticleLnk.click();
		articleTitle.clear();
		articleTitle.sendKeys(articleTitleTxt);
		articleDesc.sendKeys(descriptionTxt);
		articleBody.sendKeys(bodyTxt);
		articleTags.sendKeys(tagsText);
		publishArticleBtn.click();
	}
}
