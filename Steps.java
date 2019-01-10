package StepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.IOException;

import java.util.concurrent.TimeUnit;

import java.io.File;

import org.apache.commons.io.FileUtils;

import org.junit.Test;

import org.openqa.selenium.By;

import org.openqa.selenium.OutputType;

import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.apache.poi.ss.usermodel.Row;

import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Workbook;

import org.openqa.selenium.By;

import org.openqa.selenium.Keys;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.FileNotFoundException;

import java.io.FileOutputStream;

import java.io.IOException;

import java.text.DateFormat;

import java.text.SimpleDateFormat;

import java.util.Calendar;

import java.util.Date;

import java.util.Iterator;

import java.util.Set;

import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import org.apache.poi.ss.usermodel.Cell;

import org.apache.poi.ss.usermodel.CreationHelper;

import cucumber.api.java.en.Given;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Steps {

	@Given("^user is on moneycontrol homepage$")
	public void user_is_on_moneycontrol_homepage() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shikh\\Downloads\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		
		//Opening money control URL
		driver.get("https://www.moneycontrol.com/");

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println(driver.getTitle());
		
		//Closing the browser
		driver.quit();
	}

	@Then("^save nifty sensex numbers and export in excel$")
	public void save_nifty_sensex_numbers_and_export_in_excel() throws Throwable {

		
		Workbook workbook = null;

		workbook = new HSSFWorkbook();
		
		//Creating excel sheet
		
		Sheet sheet = workbook.createSheet("Nifty 50");

		String[] myArray = new String[6];

		myArray[0] = "Sr#";

		myArray[1] = "DateTime";

		myArray[2] = "Stock";

		myArray[3] = "Value";

		myArray[4] = "Deviation";

		myArray[5] = "Percentage";

		int rowIndex = 0;

		Row row = sheet.createRow(rowIndex);

		Cell cell0;

		for (int l = 0; l < 6; l++) {

			cell0 = row.createCell(l);

			cell0.setCellValue(myArray[l]);

		}

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shikh\\Downloads\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		
		//Opening Money Control URL
		driver.get("https://www.moneycontrol.com/");

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println(driver.getTitle());


		String aa = Keys.chord(Keys.CONTROL, Keys.ENTER);

		WebDriverWait wait = new WebDriverWait(driver, 40);

		WebElement element = wait

				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='S&P BSE SENSEX']")));

		element.sendKeys(aa);

		element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='NIFTY 50']")));

		element.sendKeys(aa);

		Set<String> ids = driver.getWindowHandles();

		int i = ids.size();

		String windowid;

		Iterator<String> it = ids.iterator();

		it.next();

		rowIndex++;

		for (int j = 0; j < i - 1; j++) {

			row = sheet.createRow(rowIndex);

			System.out.println(j);

			windowid = it.next();

			driver.switchTo().window(windowid);


			cell0 = row.createCell(0);

			cell0.setCellValue(j + 1);
			

			System.out.println("Fecthing "

					+ driver.findElement(By.xpath("//*[@id='mc_mainWrapper']/div[3]/div[1]/div[3]/div[1]/h1")).getText()

					+ " Values");

			String StockName = driver.findElement(By.xpath("//*[@id='mc_mainWrapper']/div[3]/div[1]/div[3]/div[1]/h1"))
					.getText();

			cell0 = row.createCell(2);
			cell0.setCellValue(StockName);

			System.out.println(driver

					.findElement(By.xpath("//*[@id='mc_mainWrapper']/div[3]/div[1]/div[4]/div[1]/strong")).getText());

			String StockValue = driver

					.findElement(By.xpath("//*[@id='mc_mainWrapper']/div[3]/div[1]/div[4]/div[1]/strong")).getText();

			cell0 = row.createCell(3);

			cell0.setCellValue(StockValue);

			String Deviation = driver

					.findElement(By.xpath("//*[@id='mc_mainWrapper']/div[3]/div[1]/div[4]/div[3]/strong")).getText();

			cell0 = row.createCell(4);

			cell0.setCellValue(Deviation);

			System.out.println(driver

					.findElement(By.xpath("//*[@id='mc_mainWrapper']/div[3]/div[1]/div[4]/div[3]/strong")).getText());

			System.out.println(

					driver.findElement(By.xpath("//*[@id='mc_mainWrapper']/div[3]/div[1]/div[4]/div[4]")).getText());

			String Percentage = driver.findElement(By.xpath("//*[@id='mc_mainWrapper']/div[3]/div[1]/div[4]/div[4]"))

					.getText();

			cell0 = row.createCell(5);

			cell0.setCellValue(Percentage);
			
			Calendar cal = Calendar.getInstance();

			Date date = cal.getTime();
			
			// Getting current time
			
			DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

			String formattedDate = dateFormat.format(date);

			System.out.println("Current time of the day using Calendar - 24 hour format: " + formattedDate);

			cell0 = row.createCell(1);

			cell0.setCellValue(formattedDate);

			rowIndex++;

		}

		FileOutputStream fos = new FileOutputStream("C:\\Users\\shikh\\SAMPLE.xls");

		workbook.write(fos);

		fos.close();
		
		//Closing the browser
		driver.quit();

	}

	@Then("^user clicks on moneycontrol page and capture screenshot$")
	public void user_clicks_on_moneycontrol_page_and_capture_screenshot() throws Throwable {

		

		WebDriver driver;
		
		// Opening Money Control URL

		String url = "https://www.moneycontrol.com/ ";

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shikh\\Downloads\\chromedriver.exe");
		
		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get(url);

		driver.findElement(By.cssSelector("a[class='icon']")).click();

		WebElement QuickView = driver.findElement(By.cssSelector("div[class='whtBx']"));

		// Taking snapshot of the page
		File src1 = ((TakesScreenshot) QuickView).getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(src1, new File("D:\\Assignment1.png"));

		WebElement FirstStock = driver.findElement(By.xpath("//div[@id='lastStock']/div"));

		System.out.println(FirstStock.findElement(By.xpath("//div[@id='lastStock']/div/div/p/a/strong")).getText());

		System.out.println(FirstStock
				.findElement(By.xpath("//div[@id='lastStock']/div/div/p/following-sibling::p/span/strong")).getText());

		System.out.println(FirstStock
				.findElement(By
						.xpath("(//div[@id='lastStock']/div/div/p/following-sibling::p/span[2]/following-sibling::span/strong)[1]"))
				.getText());

		System.out.println(FirstStock
				.findElement(By
						.xpath("(//div[@id='lastStock']/div/div/p/following-sibling::p/span[3]/following-sibling::span)[1]"))
				.getText());

		System.out.println(FirstStock
				.findElement(By.xpath("(//div[@id='lastStock']/div/div/p/following-sibling::p/span[5])[1]")).getText());

		System.out.println(FirstStock.findElement(By.xpath("//div[@id='lastStock']/div[1]/div[3]/div")).getText());
		
		//Closing the browser
		driver.quit();

	}

}
