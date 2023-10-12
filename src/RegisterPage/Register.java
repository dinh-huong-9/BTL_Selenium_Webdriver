package RegisterPage;

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

public class Register {
	String driverPath = "C:\\Program Files\\ChromiumTemp1316_1452253484/chromedriver";
	  WebDriver driver;
	  private String  firstName, lastName, validEmail, validPassword, invalidPassword ,invalidConfirmPassword,validConfirmPassword,invalidEmail;
	  //pt nay se duoc thuc thi moi khi chay test
	  @BeforeTest
	  public void setUp(){
		  System.setProperty("webdriver.chorme.driver", driverPath);
		  //Mo browser
		  driver = new ChromeDriver();

	  }
	  // pt nay thuc thi truoc moi testcase
	  
	  @BeforeMethod
	  public void openRegisterPage() {
	        firstName = "demo";
	        lastName = "nopcommerce";
	        validEmail = "demonopcommerce2@gmail.com";  
	        invalidEmail = "demo";
	        validPassword = "123456demo";
	        invalidPassword = "12345";
	        validConfirmPassword = "123456demo";
	        invalidConfirmPassword = "1234";
		  
		  driver.get("https://demo.nopcommerce.com/");
		  driver.findElement(By.xpath("//a[@class='ico-register']")).click();

	  }
	  //empty data
	  @Test
	  public void testRegister1_EmptyData() throws InterruptedException
	  {
		  driver.findElement(By.xpath("//*[@id=\"register-button\"]")).click();
		  //firstname
		    String actual_FirstName_error =  driver.findElement(By.xpath("//*[@id=\"FirstName-error\"]")).getText();
			 
			String expected_FirstName_error = "First name is required.";
			
			Assert.assertEquals(actual_FirstName_error, expected_FirstName_error);
			//lastname
			
			String actual_LastName_error =  driver.findElement(By.xpath("//*[@id=\"LastName-error\"]")).getText();
			 
			String expected_LastName_error = "Last name is required.";
				
			Assert.assertEquals(actual_LastName_error, expected_LastName_error);
			//email
			
			String actual_Email_error =  driver.findElement(By.xpath("//*[@id=\"Email-error\"]")).getText();
			 
			String expected_Email_error = "Email is required.";
			Assert.assertEquals(actual_Email_error, expected_Email_error);
				// pass
			String actual_Pass_error =  driver.findElement(By.xpath("//*[@id=\"Password-error\"]")).getText();
			 
			String expected_Pass_error = "Password is required.";
			Assert.assertEquals(actual_Pass_error, expected_Pass_error);
			
			//confirmpass
			String actual_Conpass_error =  driver.findElement(By.xpath("//*[@id=\"ConfirmPassword-error\"]")).getText();
			 
			String expected_Conpass_error = "Password is required.";
			Assert.assertEquals(actual_Conpass_error, expected_Conpass_error);
			
			Thread.sleep(2000);
		 
	  }
	 
	//invalid email
	  @Test
	  public void testRegister2_InvalidEmail() throws InterruptedException
	  {
		     driver.findElement(By.name("FirstName")).sendKeys(firstName );
		     driver.findElement(By.name("LastName")).sendKeys(lastName );
		     driver.findElement(By.name("Email")).sendKeys(invalidEmail);
		     driver.findElement(By.name("Password")).sendKeys(validPassword );
		     driver.findElement(By.name("ConfirmPassword")).sendKeys(validConfirmPassword);
		     
		     driver.findElement(By.xpath("//*[@id=\"register-button\"]")).click();
			 //ktra duong dan
			 
			 String actual_email_erorr =  driver.findElement(By.xpath("//*[@id='Email-error']")).getText();
			 
			String expected_email_error = "Wrong email";
			//type 1
			Assert.assertEquals(actual_email_erorr, expected_email_error);		
			Thread.sleep(2000);
	  }
	  
	//nhap dung thong tin
	  @Test
	  public void testRegister3_CorrectInformation() throws InterruptedException
	  {
		     driver.findElement(By.name("FirstName")).sendKeys(firstName );
		     driver.findElement(By.name("LastName")).sendKeys(lastName );
		     driver.findElement(By.name("Email")).sendKeys(validEmail);
		     driver.findElement(By.name("Password")).sendKeys(validPassword );
		     driver.findElement(By.name("ConfirmPassword")).sendKeys(validConfirmPassword);
		     
		     driver.findElement(By.xpath("//*[@id=\"register-button\"]")).click();
			 //ktra duong dan
			 
			 String actual_e =  driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]")).getText();
			 String expected_e ="Your registration completed";
			//type 1
				Assert.assertEquals(actual_e, expected_e);
			Thread.sleep(2000);
	  }
	//dang ky email da ton tai
	  @Test
	  public void testRegister4_Email_already_exists() throws InterruptedException
	  {
		  
		     driver.findElement(By.name("FirstName")).sendKeys(firstName );
		     driver.findElement(By.name("LastName")).sendKeys(lastName );
		     driver.findElement(By.name("Email")).sendKeys(validEmail);
		     driver.findElement(By.name("Password")).sendKeys(validPassword );
		     driver.findElement(By.name("ConfirmPassword")).sendKeys(validConfirmPassword);
		     
		     driver.findElement(By.xpath("//*[@id=\"register-button\"]")).click();
		    
			 //ktra duong dan
		   
			 String actual_e =  driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[1]/ul/li")).getText();
			 
			 String expected_e = "The specified email already exists";
			//type 1
			Assert.assertEquals(actual_e, expected_e);
			Thread.sleep(2000);
	  }
	//pass nho hon 6 ki tu
	  @Test
	  public void testRegister5_Password_is_less_than_6_characters() throws InterruptedException
	  {
		     
		     driver.findElement(By.name("Password")).sendKeys(invalidPassword);
		     
		     driver.findElement(By.xpath("//*[@id=\"register-button\"]")).click();
			 //ktra duong dan
			 
			 String actual_p =  driver.findElement(By.xpath("//*[@id=\"Password-error\"]")).getText();
			 
			 String expected_p = "Password must meet the following rules:\n" + "must have at least 6 characters";
			//type 1
			Assert.assertEquals(actual_p, expected_p);
			Thread.sleep(2000);
	  }
	//pass khac confirmpass
	  @Test
	  public void testRegister6_Password_different_ConfirmPass() throws InterruptedException
	  {
		     
		     driver.findElement(By.name("Password")).sendKeys(invalidPassword);
		     driver.findElement(By.name("ConfirmPassword")).sendKeys(invalidConfirmPassword);
		     
		     driver.findElement(By.xpath("//*[@id=\"register-button\"]")).click();
			 //ktra duong dan
			 
			 String actual_cp =  driver.findElement(By.xpath("//*[@id=\"ConfirmPassword-error\"]")).getText();
			 
			 String expected_cp = "The password and confirmation password do not match.";
			//type 1
			Assert.assertEquals(actual_cp, expected_cp);
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
