package runners;

import org.apache.logging.log4j.ThreadContext;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import utils.DriverManager;
import utils.GlobalParams;
import utils.ServerManager;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;

@RunWith(Cucumber.class)
@CucumberOptions(plugin= {"pretty","html:target/cucumber/cucumber.html","summary"},
features= {"src/test/resources"},
glue= {"stepdef"},
snippets = CAMELCASE ,
dryRun=false,
monochrome=true,
 tags="@test"
)
public class MyRunnerTest {

	@BeforeClass //created this to initialize and quit just once instead of every scenario
	public static void initialize() throws Exception
	{
		GlobalParams params=new GlobalParams();
		params.initializeGlobalParams();
		ThreadContext.put("ROUTING_KEY", params.getPlatformName()+"_"+ params.getDeviceName()); //folder to create log4j2 logs
		new ServerManager().startServer();
		new DriverManager().initializeDriver();
	}
	
	@AfterClass
	public static void quit()
	{
		DriverManager driverManager=new DriverManager();
		if (driverManager.getDriver()!=null)
		{
			driverManager.getDriver().quit();
			driverManager.setDriver(null);
		}
		ServerManager serverManager=new ServerManager();
		if(serverManager.getServer()!=null)
		{
			serverManager.getServer().stop();
		}
		
	}
	
}
