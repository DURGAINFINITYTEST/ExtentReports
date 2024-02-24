import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstClassExtent {
	ExtentReports rp;

	@BeforeTest
	public void config() {

		String path = System.getProperty("user.dir") + "\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web automation results");
		reporter.config().setDocumentTitle("Test results");

		rp = new ExtentReports();
		rp.attachReporter(reporter);
		rp.setSystemInfo("tester", "durga prasad katakatala");

	}

	@Test
	public void getExtent() {
		rp.createTest("getExtent");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		System.out.println(driver.getTitle());
		rp.flush();

	}

}
