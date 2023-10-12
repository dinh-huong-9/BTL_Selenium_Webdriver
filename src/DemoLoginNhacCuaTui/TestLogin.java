package DemoLoginNhacCuaTui;
import org.testng.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import org.openqa.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestLogin {
  String driverPath = "C:\\Program Files\\ChromiumTemp1316_1452253484/chromedriver";
  WebDriver driver;
  String[][] arrAcc = new String[2][2];
  //pt nay se duoc thuc thi moi khi chay test
  @BeforeTest
  public void setUp()
  {
	  System.setProperty("webdriver.chorme.driver", driverPath);
	  //Mo browser
	  driver = new ChromeDriver();
	  //tao 1 mang 2*2 chua acc
	  //acc Sai Tc1
	  arrAcc[0][0] = "";
	  arrAcc[0][1] = "huong912";
	  
	  
	  //acc dung Tc2
	  arrAcc[1][0] = "dinhthihonghue206@gmail.com";
	  arrAcc[1][1] = "huong912";
  }
  // pt nay thuc thi truoc moi testcase
  
  @BeforeMethod
  public void openLogin()
  {
	  driver.get("https://www.facebook.com/login/");
  }
  @Test
  public void testLogin1()
  {
	
	 driver.findElement(By.name("email")).sendKeys(arrAcc[0][0]);
	 driver.findElement(By.name("pass")).sendKeys(arrAcc[0][1]);
	 driver.findElement(By.xpath("//*[@id=\"loginbutton\"]")).click();
	 //ktra duong dan
	 String expectedUrl ="https://www.facebook.com/";
	 String actualUrl = driver.getCurrentUrl(); //lay add hien tai url
	 // so sanh
	 assertEquals(actualUrl,expectedUrl);
	 //dong browser
	//driver.close();
  }
  
  @Test
  public void testLogin2()
  {
	
	 driver.findElement(By.name("email")).sendKeys(arrAcc[1][0]);
	 driver.findElement(By.name("pass")).sendKeys(arrAcc[1][1]);
	 driver.findElement(By.xpath("//*[@id=\"loginbutton\"]")).click();
	 //ktra duong dan
	 String expectedUrl ="https://www.facebook.com/";
	 String actualUrl = driver.getCurrentUrl(); //lay add hien tai url
	 // so sanh
	 assertEquals(actualUrl,expectedUrl);
	 //dong browser
	//driver.close();
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
}
