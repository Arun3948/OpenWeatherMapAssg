package utility;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * Below Class for Log, by using Log4J capability.
 */
public class TestLogs {

	static String logConfigFilename = "src\\main\\resources\\log4j.properties";

	public static final Logger logger = Logger.getLogger(TestLogs.class.getName());

	public static void getlogger() {
		System.out.println(logConfigFilename);
		PropertyConfigurator.configure(logConfigFilename);
	}
}
