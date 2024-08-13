package utils;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import io.appium.java_client.android.options.UiAutomator2Options;

public class CapabilitiesManager {
	TestUtils utils=new TestUtils();
	public UiAutomator2Options getCaps() throws IOException
	{
		GlobalParams params=new GlobalParams();
		Properties props=new PropertyManager().getProps();
		
		
		try {
			utils.log().info("Getting capabilities");
			UiAutomator2Options options=new UiAutomator2Options();
			options.setPlatformName(params.getPlatformName());
			options.setUdid(params.getUdid());
			options.setDeviceName(params.getDeviceName());
			switch(params.getPlatformName())
			{
			case "Android":
				String appUrl=System.getProperty("user.dir")+ File.separator+"src"+File.separator+"test"+ File.separator+"resources"+ File.separator+"apps"+File.separator+"Android.SauceLabs.Mobile.Sample.app.2.7.1.apk";
				options.setAutomationName(props.getProperty("androidAutomationName"));

				options.setAppPackage(props.getProperty("androidAppPackage"));
				options.setAppActivity(props.getProperty("androidAppActivity"));
				options.setApp(appUrl); 
				//options.setSystemPort(params.getSystemPort());
				//options.setChromedriverPort(params.getChromeDriverPort());
				break;
				default: 
			
			}
			return options;
			
	
			
		}
		catch(Exception e) {
			e.printStackTrace();
			utils.log().fatal("Failed to load"+e.toString());
			throw e;
		}
	
		
	}

}
