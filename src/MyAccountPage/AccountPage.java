package MyAccountPage;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class AccountPage {
	String driverPath = "C:\\Program Files\\ChromiumTemp1316_1452253484/chromedriver";
	  WebDriver driver;
	  private String ValidPassword, RegisteredEmail;
	  private String firstName, lastName, email, companyName, emailAddress;
	  private String name, phoneNumber, faxNumber, addressCompany, address1, addressCity, country, addressZipPostalCode, addressFirstName, addressLastName;
	  private String oldPassword, newPassword, confirmPassword;
	  private String day, month, year;
	  //pt nay se duoc thuc thi moi khi chay test
	  @BeforeTest
	  public void setUp(){
		  System.setProperty("webdriver.chorme.driver", driverPath);
		  //Mo browser
		  driver = new ChromeDriver();
	  }
	  @BeforeMethod
	  public void openMyAcc() throws InterruptedException {
		  ValidPassword = "123456demo";
		  RegisteredEmail = "demonopcommerce5@gmail.com";
		  
		  firstName = "demo";
		  lastName = "nopcommerce";
	        email = "demonopcommerce1@gmail.com";
	        emailAddress = "demonopcommerce2@gmail.com";
	        companyName = "nopcommerce company";

	        addressFirstName = "demo";
	        addressLastName ="nopcommerce";
	        name = addressFirstName + " " + addressLastName;
	        phoneNumber = "0123456789";
	        faxNumber = "0987654321";
	        addressCompany = "demonopcommerce company";
	        address1 = "60 Duong Cau Giay, Cau Giay";
	        addressCity = "Ha Noi";
	        addressZipPostalCode = "580000";
	        country = "Viet Nam";

	        oldPassword = "123456demo";
	        newPassword = "123456nopcommerce";
	        confirmPassword = "123456nopcommerce";

	        day = "21";
	        month = "June";
	        year = "2001";
		  
		  driver.get("https://demo.nopcommerce.com/");
		  driver.findElement(By.xpath("//a[@class='ico-login']")).click();
		  driver.findElement(By.name("Email")).sendKeys(RegisteredEmail);
		  driver.findElement(By.name("Password")).sendKeys(ValidPassword);
		  driver.findElement(By.xpath("//button[text()='Log in']")).click();
		  
		  driver.findElement(By.xpath("//a[@class='ico-account']")).click();
		  Thread.sleep(2000);
	  }
	  
	  @Test
	  public void testMyAcc1_Update_Information_Cus() throws InterruptedException
	  {
		
		driver.findElement(By.xpath("//label[@class=\"forcheckbox\"]")).click();
		driver.findElement(By.name("FirstName")).sendKeys(firstName);
		driver.findElement(By.xpath("//button[text()='Save']")).click();
		 //ktra duong dan
		 
		String actual_error =  driver.findElement(By.xpath("//*[@id=\"bar-notification\"]/div/p")).getText();
		 
		String expected_error = "The customer info has been updated successfully.";
		//type 1
		Assert.assertEquals(actual_error, expected_error);
		Thread.sleep(2000);
	  }
	  
//	  @Test
//	  public void testMyAcc2_Add_Addresses_Cus() throws InterruptedException
//	  {
//		driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[1]/div/div[2]/ul/li[2]/a")).click();
//	    driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div[2]/button")).click(); // click button add
//		driver.findElement(By.name("Address_FirstName")).sendKeys( addressFirstName);
//		driver.findElement(By.name("Address_LastName")).sendKeys(addressLastName);
//		driver.findElement(By.name("Address_Email")).sendKeys(emailAddress);
//		driver.findElement(By.name("Address_Company")).sendKeys(addressCompany);
//		driver.findElement(By.name("Address.CountryId")).sendKeys(country);
//		driver.findElement(By.name("Address_City")).sendKeys(addressCity);
//		driver.findElement(By.name("Address_Address1")).sendKeys(address1);
//		driver.findElement(By.name("Address_ZipPostalCode")).sendKeys(addressZipPostalCode);
//		driver.findElement(By.name("Address_PhoneNumber")).sendKeys(phoneNumber);
//		driver.findElement(By.name("Address_FaxNumber")).sendKeys(faxNumber);
//		driver.findElement(By.name("Address_ZipPostalCode")).sendKeys(addressZipPostalCode);
//		driver.findElement(By.xpath("//button[text()='Save']")).click();
//		 //ktra duong dan
//		 
//		String actual_error =  driver.findElement(By.xpath("//*[@id=\"bar-notification\"]/div/p")).getText();
//		 
//		String expected_error = "The customer info has been updated successfully.";
//		//type 1
//		Assert.assertEquals(actual_error, expected_error);
//		Thread.sleep(2000);
//	  }
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
