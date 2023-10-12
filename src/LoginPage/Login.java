package LoginPage;

import static org.testng.Assert.assertEquals;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Login {
	String driverPath = "C:\\Program Files\\ChromiumTemp1316_1452253484/chromedriver";
	  WebDriver driver;
	  private String invalidEmail, invalidPassword, RegisteredEmail, ValidPassword;
	  //pt nay se duoc thuc thi moi khi chay test
	  @BeforeTest
	  public void setUp(){
		  System.setProperty("webdriver.chorme.driver", driverPath);
		  //Mo browser
		  driver = new ChromeDriver();

	  }
	  // pt nay thuc thi truoc moi testcase
	  
	  @BeforeMethod
	  public void openLogin() {
		  
		  invalidEmail = "demonopcommerce";
		  invalidPassword = "12345";
		  ValidPassword = "123456demo";
		  RegisteredEmail = "demonopcommerce5@gmail.com";
		  
		  driver.get("https://demo.nopcommerce.com/");
		  driver.findElement(By.xpath("//a[@class='ico-login']")).click();

	  }
	  @Test
	  public void testLogin1_EmptyData() throws InterruptedException
	  {
	
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
		 //ktra duong dan
		 
		String actual_error =  driver.findElement(By.xpath("//*[@id=\"Email-error\"]")).getText();
		 
		String expected_error = "Please enter your email";
		//type 1
		Assert.assertEquals(actual_error, expected_error);
		//type 2
		Assert.assertTrue(actual_error.contains("Please enter your email"));
		Thread.sleep(2000);
	  }
	  @Test
	  public void testLogin2_InvalidEmail() throws InterruptedException
	  {
		 driver.findElement(By.name("Email")).sendKeys(invalidEmail);
		 driver.findElement(By.xpath("//button[text()='Log in']")).click();
		 //ktra duong dan
		 
		 String actual_erorr =  driver.findElement(By.xpath("//*[@id=\"Email-error\"]")).getText();
		 
		String expected_error = "Wrong email";
		//type 1
		Assert.assertEquals(actual_erorr, expected_error);
		//type 2
		Assert.assertTrue(actual_erorr.contains("Wrong email"));
	  Thread.sleep(2000);
	  }
	  
	  @Test
	  public void testLogin3_Unregistered_Email() throws InterruptedException
	  {
		   
		     driver.findElement(By.name("Email")).sendKeys(invalidEmail);
			 driver.findElement(By.xpath("//button[text()='Log in']")).click();
			 //ktra duong dan
			 
			 String actual_erorr =  driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[1]")).getText();
			 
			String expected_error = "Login was unsuccessful. Please correct the errors and try again.\n"+"No customer account found";
			Assert.assertEquals(actual_erorr, expected_error);
			Thread.sleep(2000);
	  }
	  
	  @Test
	  public void testLogin4_RegisteredEmail_And_EmptyPass() throws InterruptedException
	  {
		     
		     driver.findElement(By.name("Email")).sendKeys(RegisteredEmail);
			 driver.findElement(By.xpath("//button[text()='Log in']")).click();
			 String actual_erorr =  driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[1]")).getText();
			 
			 String expected_error = "Login was unsuccessful. Please correct the errors and try again.\n"+"The credentials provided are incorrect";
			 Assert.assertEquals(actual_erorr, expected_error);
			 Thread.sleep(2000);
	  }
	  @Test
	  public void testLogin5_RegisteredEmail_And_WrongPass() throws InterruptedException
	  {
		    
		     driver.findElement(By.name("Email")).sendKeys(RegisteredEmail);
		     driver.findElement(By.name("Password")).sendKeys(invalidPassword);
			 driver.findElement(By.xpath("//button[text()='Log in']")).click();
			 String actual_erorr =  driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[1]")).getText();
			 
			 String expected_error = "Login was unsuccessful. Please correct the errors and try again.\n" +"The credentials provided are incorrect";
			 Assert.assertEquals(actual_erorr, expected_error);
			 Thread.sleep(2000);
	  }
	  
	  @Test
	  public void testLogin6_CorrectInformation() throws InterruptedException
	  {
		     driver.findElement(By.name("Email")).sendKeys(RegisteredEmail);
		     driver.findElement(By.name("Password")).sendKeys(ValidPassword);
			 driver.findElement(By.xpath("//button[text()='Log in']")).click();
			 //ktra duong dan
			 
			 String expectedUrl ="https://demo.nopcommerce.com/";
			 String actualUrl = driver.getCurrentUrl(); //lay add hien tai url
			 assertEquals(actualUrl,expectedUrl);
			 Thread.sleep(2000);
	  }
	  //pt nay duoc thi sau khi KT moi testcase
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
	  
	  public int generateFakeNumber() {
		  Random rand = new Random();
		  return rand.nextInt(9999);
	  }
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
}
