package oxfordDirTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class pageLocators {
	
	WebDriver driver;
	
	By continueBtn=By.xpath("//button[contains(text(), 'Continue')]");
	By wordId=By.xpath("//div[@id='Dictionary32entries_get_entries_source_lang_word_id_content']/form/table/tbody/tr[2]/td[2]/input");
	By expandOpps=By.xpath("//p[contains(text(), 'Retrieve dictionary information for a given word')]");
	By btnTryIt=By.xpath("//*[@id='Dictionary32entries_get_entries_source_lang_word_id_content']/form/div[3]/input");
	By elementWord=By.id("//*[@id='Dictionary32entries_get_entries_source_lang_word_id_content']/form/table[1]/tbody/tr[2]/td[1]/label");
	By statusResponse200=By.xpath("//*[@id='Dictionary32entries_get_entries_source_lang_word_id_content']/div[3]/div[5]/pre");
	By statusResponse404=By.xpath("//*[@id='Dictionary32entries_get_entries_source_lang_word_id_content']/div[3]/div[5]/pre");
	
	public pageLocators(WebDriver driver){
		
		this.driver=driver;	
	}
	
	public void clickCokies(){
		
		driver.findElement(continueBtn).click();
	}
	
	public void clickExpandOpps() throws InterruptedException{
		
		driver.findElement(expandOpps).click();
		Thread.sleep(400);
	}
	
	public void typeValidWord() throws InterruptedException{
	
	JavascriptExecutor jsx = (JavascriptExecutor)driver;
	jsx.executeScript("window.scrollBy(0,1150)", "");
	driver.findElement(wordId).clear();
	driver.findElement(wordId).sendKeys("ace");
	Thread.sleep(1000);
	
	}
	public void typeInvalidWord() throws InterruptedException{
	
	JavascriptExecutor jsx = (JavascriptExecutor)driver;
	jsx.executeScript("window.scrollBy(0,1150)", "");
	driver.findElement(wordId).clear();
	driver.findElement(wordId).sendKeys("FFF12233");
	Thread.sleep(2000);
	}
	public void clickTryItBtn() throws InterruptedException{
		
		driver.findElement(btnTryIt).click();
		Thread.sleep(2000);
	
	}
	public void verify200StatusResponse() throws InterruptedException{
		JavascriptExecutor jsx = (JavascriptExecutor)driver;
		jsx.executeScript("window.scrollBy(0,1350)", "");
		System.out.println(driver.findElement(statusResponse200).getText());
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(statusResponse200).getText(), "200");
		
	}
	public void verify404StatusResponse() throws InterruptedException{
		JavascriptExecutor jsx = (JavascriptExecutor)driver;
		jsx.executeScript("window.scrollBy(0,800)", "");
		System.out.println(driver.findElement(statusResponse404).getText());
		Thread.sleep(2000);
		Assert.assertEquals(driver.findElement(statusResponse404).getText(), "404");
	
	}

}
