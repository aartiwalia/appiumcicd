package utils;

import java.io.File;
import java.time.Duration;

import com.google.common.io.ByteStreams;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class ServerManager {
	private static ThreadLocal<AppiumDriverLocalService> server=new ThreadLocal<>();
	TestUtils utils=new TestUtils(); //need for logging purpose
	//create getter and setter for server object
	
	public AppiumDriverLocalService getServer()
	{
		return server.get();
	}
	
public void startServer() {
	utils.log().info("Starting Appium server");
	AppiumDriverLocalService server=WindowsGetAppiumService(); //create local variable for this method
	server.start();
	if(server==null || !server.isRunning())
	{utils.log().fatal("Appium server not started.ABORT!");
		throw new AppiumServerHasNotBeenStartedLocallyException("Appium server not started.ABORT!!");
		
	}
	server.clearOutPutStreams(); // to clear server logs from console
	this.server.set(server); // to set class level object 
	utils.log().info("Appium server started");
}
	 public AppiumDriverLocalService getAppiumServerDefault() {
	        return AppiumDriverLocalService.buildDefaultService();
	    }

	    public AppiumDriverLocalService WindowsGetAppiumService() {
	        GlobalParams params = new GlobalParams();
	        return AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
	                .usingAnyFreePort()
	                .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
	                .withTimeout(Duration.ofSeconds(20))
	                .withLogOutput(ByteStreams.nullOutputStream())
	                .withLogFile(new File(params.getPlatformName() + "_"
	                        + params.getDeviceName() + File.separator + "Server.log")));
	    }

}
