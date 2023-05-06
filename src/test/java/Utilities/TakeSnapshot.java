package Utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.Scenario;

public class TakeSnapshot {

	public TakeSnapshot(WebDriver driver, Scenario sc) {
		if(sc.isFailed()) {
			TakesScreenshot ts = (TakesScreenshot)driver;
			byte[] src=ts.getScreenshotAs(OutputType.BYTES);
			sc.attach(src, "image/png", "Failed Screenshot");
		}
		
		
		
	}
}
