package com.flipkart;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MobilePurchase {
	static WebDriver driver;
	static long start;
	@BeforeClass
	public static void browserLaunch() throws Exception  {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\srither\\Desktop\\ajii\\FrameWork\\Driver\\chromedriver.exe");
	    driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("browser Launch");
		

	}
	@AfterClass
	public static void browserQuit() throws Exception {
		Thread.sleep(900000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.quit();
		System.out.println("browser Quit");
		

	}
	
	@Before
	public void startingTime() {
		 start = System.currentTimeMillis();
		System.out.println("Before");
		

	}
	@After
	public void endTiming() {
		long end = System.currentTimeMillis();
		System.out.println("After Time is taken :"+(end - start));

	}
	@Test
	
	public void method1()  {
		  WebElement closebtn = driver.findElement(By.xpath("//button[text()='✕']"));
		  closebtn.click();
		System.out.println(" method 1 popup window");
	}
	@Test
	public void method2() {
		driver.findElement(By.name("q")).sendKeys("Redmi");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("mobile search");
	}
	@Test
	public void method3() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement redmi = driver.findElement(By.xpath("(//div[@class='_4rR01T'])[1]"));
		String s = redmi.getText();
		System.out.println(s);
		redmi.click();
		System.out.println("mobile click");
		File f = new File("C:\\Users\\srither\\Desktop\\ajii\\FrameWork\\target\\Sample.xlsx");
		Workbook w = new XSSFWorkbook();
		Sheet sheet= w.createSheet("Flipkart");
		Row r = sheet.createRow(0);
	    Cell c = r.createCell(0);
	    FileOutputStream f1 = new FileOutputStream(f);
	    w.write(f1);
	}
	@Test
	public void method4() throws Exception {
		String pwn = driver.getWindowHandle();
		Set<String> allwn = driver.getWindowHandles();
		for (String x: allwn) {
			if(!x.equals(pwn)) {
				driver.switchTo().window(pwn);
			}
		}
		System.out.println("windows handling");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement redmi = driver.findElement(By.xpath("(//div[@class='_4rR01T'])[1]"));
		 String s1 =redmi.getText();
		 System.out.println(s1);
		 File f = new File("C:\\Users\\srither\\Desktop\\ajii\\FrameWork\\Driver\\chromedriver.exe");
		Workbook w1 = new XSSFWorkbook();
		 Sheet sh = w1.createSheet("Flipkart");
		Row r1 = sh.createRow(4);
		 Cell c =r1.createCell(1);
		 c.setCellValue(s1);
		 FileOutputStream f2 = new FileOutputStream(f);
		 w1.write(f2);
		 System.out.println("method xl write");
	}
	@Test
	public void method5() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		TakesScreenshot tk = (TakesScreenshot)driver;
		File source = tk.getScreenshotAs(OutputType.FILE);
		File target = new File("C:\\Users\\srither\\Desktop\\ajii\\FrameWork\\ScreenShot\\flipkart.png");
		FileUtils.copyFile(source, target);
		System.out.println(" method 5 screenshot");

		

	}
	
  
   
	

}



