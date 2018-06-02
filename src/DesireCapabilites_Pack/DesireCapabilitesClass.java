package DesireCapabilites_Pack;

import org.openqa.selenium.Platform;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DesireCapabilitesClass {

	public static void main(String[] args) {
		DesiredCapabilities Cap = new DesiredCapabilities();
		Cap.setBrowserName("firefox");
		Cap.setJavascriptEnabled(true);
		Cap.setCapability(CapabilityType.BROWSER_NAME, "firefox");
		Cap.setCapability(CapabilityType.PLATFORM, Platform.WINDOWS);
	    FirefoxDriver fd = new FirefoxDriver(Cap);
	    fd.get("");
	    
	}

}
