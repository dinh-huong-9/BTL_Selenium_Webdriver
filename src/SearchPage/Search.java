package SearchPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.Alert;

public class Search {
	  String driverPath = "C:\\Program Files\\ChromiumTemp1316_1452253484/chromedriver";
	  WebDriver driver;
	  String RegisteredEmail, ValidPassword, invalidData, ProName;
	  @BeforeTest
 public void setUp(){
		  System.setProperty("webdriver.chorme.driver", driverPath);
		  //Mo browser
		  driver = new ChromeDriver();
		  driver.get("https://demo.nopcommerce.com/");
		  RegisteredEmail ="demonopcommerce2@gmail.com";
		  ValidPassword = "123456demo";
		  invalidData = "Macbook Pro 2050";
		  ProName ="Thinkpad X1 Carbon";
	  }
	  public void openMyAccount() throws InterruptedException {
		  
		  driver.findElement(By.xpath("//a[@class='ico-login']")).click();
		  driver.findElement(By.name("Email")).sendKeys(RegisteredEmail);
		  driver.findElement(By.name("Password")).sendKeys(ValidPassword);
		  driver.findElement(By.xpath("//button[text()='Log in']")).click();
		  
		  Thread.sleep(2000);
	  }
	  
	  @Test
	  public void testSearch1_With_EmptyData() throws InterruptedException
	  {
		
		driver.findElement(By.xpath("//button[text()= 'Search']")).click();
		 //ktra duong dan
		 
		String actual_error =  driver.switchTo().alert().getText();
		 
		String expected_error = "Please enter some search keyword";
		//type 1
		Assert.assertEquals(actual_error, expected_error);
		driver.switchTo().alert().accept();
		Thread.sleep(2000);
	  }
	  
	  @Test
	  public void testSearch2_Data_Not_Exist() throws InterruptedException
	  {
		driver.findElement(By.xpath("//input[@id='small-searchterms']")).sendKeys(invalidData);
		driver.findElement(By.xpath("//button[text()= 'Search']")).click();
		 //ktra duong dan
		
		String actual_error =  driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div[2]/div/div[2]/div")).getText();
		 
		String expected_error = "No products were found that matched your criteria.";
		//type 1
		Assert.assertEquals(actual_error, expected_error);
		Thread.sleep(2000);
	  }
	  
	  @Test
	  public void testSearch3_ProductName_Absolute() throws InterruptedException
	  {
		driver.findElement(By.xpath("//input[@id='small-searchterms']")).sendKeys(ProName);
		driver.findElement(By.xpath("//button[text()= 'Search']")).click();
		 //ktra duong dan
		
		String actual_error =  driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div/div/div[2]/h2/a")).getText();
		 
		String expected_error = "Lenovo Thinkpad X1 Carbon Laptop";
		//type 1
		Assert.assertEquals(actual_error, expected_error);
		Thread.sleep(2000);
	  }
	  @AfterMethod
	  public void mess() {
		  System.out.println("Xong Mot Testcase!");
	  }
	  // pt nay duoc thuc thi sau khi KT test
	  @AfterTest
	  public void closeTest()
	  {
		  driver.close();
		  System.out.println("Ket Thuc Test!");
	  }
}
