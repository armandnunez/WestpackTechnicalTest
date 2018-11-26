package oxfordDirTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class VerifyValidInput {
	@Test
	public void Test_Input() throws InterruptedException{
			
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ArmandoArmandNunez\\EclipseWorkspace\\WestpacTechnicalTest\\lib\\chromedriver.exe");
	
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.get("https://developer.oxforddictionaries.com/documentation#/");
			
			pageLocators searchOxfordDir = new pageLocators(driver);
			searchOxfordDir.clickCokies();
			searchOxfordDir.clickExpandOpps();
			searchOxfordDir.typeValidWord();
			searchOxfordDir.clickTryItBtn();
			searchOxfordDir.verify200StatusResponse();
			
			Thread.sleep(3000);
			driver.quit();
			//driver.close();			
			
	}	

}
