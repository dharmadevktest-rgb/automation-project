package Utility;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
	private static Properties properties;

	static {
		try {
			FileInputStream fis = new FileInputStream(
					"C:\\Users\\arunj\\Downloads\\Sahaj_GAIL\\Sahaj_GAIL\\Configuration\\config.properties");
			properties = new Properties();
			properties.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getProperty(String key) {
		return properties.getProperty(key);
	}

}
