package com.example.CarAudioShop.selinium;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GUISeliniumTests {
	private WebDriver driver;

	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/media/chrupeq/Data/Ericsonn/workspecyIzadaniaMasterZEricson/a00160506webProject/CarAudioShop/src/main/resources/chromedriver");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
	}
	
	@After
	public void closeDown() {
		driver.close();
	}

	@Test
	public void testTitle() throws InterruptedException {
		driver.get("http://localhost:8080/CarAudioShop");
		assertEquals("Subwoofers Database", driver.getTitle());
	}

	@Test
	public void testWoofersTabClick() throws InterruptedException {
		driver.get("http://localhost:8080/CarAudioShop/");
		WebElement tabInv = driver.findElement(By.id("woofers"));
		tabInv.click();
		Thread.sleep(4000);
		WebElement table = driver.findElement(By.id("woofersTable"));
		assertEquals(true, table.isDisplayed());
	}
	
	@Test
	public void testSearchWorking() throws InterruptedException {
		driver.get("http://localhost:8080/CarAudioShop/");
		WebElement tabInv = driver.findElement(By.id("woofers"));
		tabInv.click();
		Thread.sleep(4000);
		WebElement inputDiv2 = driver.findElement(By.cssSelector("input[aria-controls='woofersTable']"));
		assertEquals(true, inputDiv2.isDisplayed());
		inputDiv2.sendKeys("xx");
		WebElement firstSearchElemnt = driver.findElement(By.className("sorting_1"));
		assertEquals("AR 12-WXX",firstSearchElemnt.getText());
	}
	@Test
	public void testAmountOfWoofersDisplayWork() throws InterruptedException {
		driver.get("http://localhost:8080/CarAudioShop/");
		WebElement tabInv = driver.findElement(By.id("woofers"));
		tabInv.click();
		Thread.sleep(4000);
		WebElement selectDiv2 = driver.findElement(By.cssSelector("select[aria-controls='woofersTable']"));
		assertEquals(true, selectDiv2.isDisplayed());
		Select dropdown = new Select(selectDiv2);
		dropdown.selectByVisibleText("100");
		List<WebElement> ls = driver.findElements(By.className("sorting_1"));
		assertEquals(100,ls.size());
		dropdown = new Select(selectDiv2);
		dropdown.selectByVisibleText("20");
		ls = driver.findElements(By.className("sorting_1"));
		assertEquals(20,ls.size());
	}
	@Test
	public void testBuyingAdviceTabClick() throws InterruptedException {
		driver.get("http://localhost:8080/CarAudioShop/");
		WebElement tabInv = driver.findElement(By.id("woofers"));
		tabInv.click();
		Thread.sleep(4000);
		List<WebElement> ls = driver.findElements(By.id("btnModal"));
		assertEquals(20,ls.size());
		WebElement firstModalBtn = ls.get(0);
		firstModalBtn.click();
		Thread.sleep(1000);
		WebElement modalElement = driver.findElement(By.className("modal-dialog"));
		assertEquals(true, modalElement.isDisplayed());
		WebElement closeModalElement = driver.findElement(By.className("close"));
		closeModalElement.click();
		Thread.sleep(1000);
		assertEquals(false, modalElement.isDisplayed());
	}
	
}