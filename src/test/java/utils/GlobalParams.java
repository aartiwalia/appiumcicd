package utils;

public class GlobalParams {
	private static ThreadLocal<String> platformName=new ThreadLocal<String>();
	private static ThreadLocal<String> udid=new ThreadLocal<String>();
	private static ThreadLocal<String> deviceName=new ThreadLocal<String>();
	private static ThreadLocal<Integer> chromedriverPort=new ThreadLocal<Integer>();
	private static ThreadLocal<Integer> systemPort=new ThreadLocal<Integer>();
	public void setPlatformName(String platformName1)
	{
		platformName.set(platformName1);
	}
	
	public String getPlatformName()
	{
		return platformName.get();
	}
	
	public void setUdid(String udid1)
	
	{
		udid.set(udid1);
	}
	public String getUdid()
	{return udid.get();
		
	}
	public void setDeviceName(String deviceName1)
	{
		deviceName.set(deviceName1);
	}
	public String getDeviceName()
	{
		return deviceName.get();
	}
	
	  public void setSystemPort(Integer systemPort1) { systemPort.set(systemPort1);
	  }
	  
	  public int getSystemPort() { return systemPort.get(); }
	  
	  
	  public void setChromeDriverPort(Integer chromeDriverPort1) 
	  {
	  systemPort.set(chromeDriverPort1); }
	  
	  public Integer getChromeDriverPort() { return chromedriverPort.get(); }
	 
	
	public void initializeGlobalParams()
	{
		GlobalParams params=new GlobalParams();
		params.setPlatformName(System.getProperty("platformName","Android"));
		params.setUdid(System.getProperty("udid","emulator-5554"));
		params.setDeviceName(System.getProperty("deviceName","pixel_8_pro"));
		
		switch(params.getPlatformName()) {
		case "Android":
			params.setSystemPort(10000);
			params.setChromeDriverPort(11000);
			break;
		case "iOS":
			break;
			default:
				throw new IllegalStateException("Inavlid platformname");
		}
		
		

	}
	
	
}
