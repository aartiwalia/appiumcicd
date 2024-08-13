package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class DriverManager {
	private static ThreadLocal< AppiumDriver >driver= new ThreadLocal<>();
	
	TestUtils utils=new TestUtils();
	
	public AppiumDriver getDriver()
	{
		return driver.get();
	}

	public void setDriver(AppiumDriver driver2)
	{
		driver.set(driver2);
	}
	public void initializeDriver() throws Exception
	{
		AppiumDriver driver = null;
		GlobalParams params=new GlobalParams();
		PropertyManager props=new PropertyManager();
		if(driver==null)
		{
			try {
				utils.log().info("Initializing driver");
				switch(params.getPlatformName())
				{
				case "Android":
					driver=new AndroidDriver(new ServerManager().getServer().getUrl(),new CapabilitiesManager().getCaps()); //(as we dont know which free port it is running on, set it to caps)
					break;
				case "iOS":
					break;
					default:
				}
				if(driver==null) {
					throw new Exception("Driver is null");
				}
				utils.log().info("Driver is initialized");
				this.driver.set(driver);
			}
				catch(Exception e) {
					e.printStackTrace();
					utils.log().fatal("Driver not initialised" +e.toString());
					throw e;
			}
				
				}
			}
		
}
