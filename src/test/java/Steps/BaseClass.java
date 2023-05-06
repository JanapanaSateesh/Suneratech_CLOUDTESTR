package Steps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import Utilities.TakeSnapshot;
import io.cucumber.java.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	TakeSnapshot takescreenshot ;
	
	public static WebDriver getDriver() {
		return driver;
	}
	
	@Before
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		//options.addArguments("headless");
		driver= new ChromeDriver(options);	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
	}
	
	@After
	public void tearDown(Scenario sc) {
		takescreenshot= new TakeSnapshot(driver, sc);	
		driver.quit();
	}
}
