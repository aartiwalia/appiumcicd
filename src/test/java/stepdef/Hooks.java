package stepdef;

import java.io.IOException;

import org.apache.logging.log4j.ThreadContext;
import org.openqa.selenium.OutputType;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.DriverManager;
import utils.GlobalParams;
import utils.ServerManager;
import utils.VideoManager;

public class Hooks {
	// before and after are executed after every sceanrio
	@Before 
	public void initialize() throws Exception
	{
		/*
		 * GlobalParams params=new GlobalParams(); params.initializeGlobalParams();
		 * ThreadContext.put("ROUTING_KEY", params.getPlatformName()+"_"+
		 * params.getDeviceName()); //folder to create log4j2 logs new
		 * ServerManager().startServer(); new DriverManager().initializeDriver();
		 */
		new VideoManager().startRecording();
		
	}
	
	@After
	public void quit(Scenario scenario) throws IOException
	{
		
		if(scenario.isFailed())
		{
			byte[] screenshot=new DriverManager().getDriver().getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName());
		}
		new VideoManager().stopRecording(scenario.getName());
		/*
		 * DriverManager driverManager=new DriverManager(); if
		 * (driverManager.getDriver()!=null) { driverManager.getDriver().quit();
		 * driverManager.setDriver(null); } ServerManager serverManager=new
		 * ServerManager(); if(serverManager.getServer()!=null) {
		 * serverManager.getServer().stop(); }
		 */
	}

}
