package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class htmlReport {
	public static ExtentReports report;
	static ExtentSparkReporter spark;
	
	public static ExtentReports getReport() {
		if (report == null) {
			String reportName = DateUtils.getTimeStamp() + ".html";

			spark = new ExtentSparkReporter("ExReport/" + reportName + "ExtendReport.html");
			//spark = new ExtentSparkReporter(".\\ExReport");  // (System.setProperties("user.dir")+//test-output

			//.\\ExReport
			//(.//export//hsdj.html)
			report = new ExtentReports();
			report.attachReporter(spark);

			report.setSystemInfo("OS", "Windows 10");
			report.setSystemInfo("processor", "intel core i3");
			report.setSystemInfo("Build Path", "18363.1916");
			report.setSystemInfo("RAM", "8GB");

		}
		return report;

	}

}

