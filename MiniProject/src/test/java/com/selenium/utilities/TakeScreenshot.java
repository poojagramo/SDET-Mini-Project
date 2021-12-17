package com.selenium.utilities;


import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class TakeScreenshot extends BrowserSetup{
	public void screenshot() throws IOException {		
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDateTime now = LocalDateTime.now();

		UUID uuid = UUID.randomUUID(); // Generates random UUID
		String stamp = dtf.format(now);

		String IMGName = "IMG_" + stamp + "_" + uuid;
		FileUtils.copyFile(scrFile, new File("files\\Screenshots\\" + IMGName + ".png"));

	}

}
