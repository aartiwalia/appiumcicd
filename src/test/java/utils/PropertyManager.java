package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyManager {
	private static Properties props=new Properties();
	TestUtils utils=new TestUtils(); // to log results
	
	public Properties getProps() throws IOException  //method to return property object
	{
		InputStream is=null; // to load properties
		String propsFileName="config.properties";
		if(props.isEmpty())
		{
						try {
							utils.log().info("loading config file");
				is=getClass().getClassLoader().getResourceAsStream(propsFileName); // to get the file from classpath
				props.load(is);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				utils.log().fatal("Failed to load config file" + e.toString());
				throw e;  // to discontinue after exception
			}
						finally //to close inputstream
						{
							if(is!=null)
							{
								is.close();
							}
								
						}
		}
		return props;
	}
	 

}
