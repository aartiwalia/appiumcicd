package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestUtils {
	public static final long WAIT=20;
	public Logger log()
	{
		return LogManager.getLogger(Thread.currentThread().getStackTrace()[2].getClassName()); //initializes log4j2 using getlogger method and thread is used to print cl;ass name along with log4j logs
	}

}
