package tests;

import java.time.Duration;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)	//it is used to run methods in alphabetical orders
public class Login {

	WebDriver driver;
	
	@BeforeClass
	public static void beforeClass() {
		
		System.out.println("Execution started");
	}
	
	@AfterClass
	public static void afterClass() {
		
		System.out.println("Execution completed");
	}
	
	@Before
	public void setUp() {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.linkText("Login")).click();
	}
	
	@After
	public void tearDown() {
		
		driver.close();
	}
	
	@Test
	public void test_a_loginWithValidCredentials() {	//also you can rename your test in alphabetical order
		
		driver.findElement(By.id("input-email")).sendKeys("bokde.leelesh4@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("12345");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		System.out.println("Login with valid credentials successfully");
	}

	//@Ignore 	//ignore this test case
	@Test
	public void test_b_loginWithInvalidCredentials() {

		driver.findElement(By.id("input-email")).sendKeys("abc@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("012345");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		//Assume.assumeTrue(false);	//also used to ignore this test case
		System.out.println("Login with invalid credentials successfully");
	}

	@Test
	public void test_c_loginWithValidEmailAndInvalidPassword() {

		driver.findElement(By.id("input-email")).sendKeys("bokde.leelesh4@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("012345");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		System.out.println("Login with valid email successfully");
	}

	@Test
	public void test_d_loginWithInvalidEmailAndValidPassword() {

		driver.findElement(By.id("input-email")).sendKeys("abc@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("12345");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		System.out.println("Login with invalid email successfully");
	}

	@Test
	public void test_e_loginWithoutCredentials() {

		driver.findElement(By.id("input-email")).sendKeys("");
		driver.findElement(By.id("input-password")).sendKeys("");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		System.out.println("Login without credentials successfully");
	}

}
