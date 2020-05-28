package com.apiautomation.util;

import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * singleton class to read config.properties file
 * 
 * @author santosh.pardeshi
 *
 */
public class ConfigurationReader {

	/** Logger instance. */
	final static Logger logger = Logger.getLogger(ConfigurationReader.class);

	/** The ConfigurationReader instance. */
	private static ConfigurationReader configurationReader = null;

	/** The properties. */
	private Properties properties = null;

	/**
	 * Instantiates a new configuration reader object.
	 */
	private ConfigurationReader() {
		properties = new Properties();
		try {
			InputStream inputStream = getClass().getClassLoader().getResourceAsStream("config.properties");
			if (inputStream != null) {
				properties.load(inputStream);
			}

		} catch (Exception exception) {
			logger.error("Configuration file issue : " + exception.getMessage());
			new CustomeException("Issue with configuration file: " + exception.getMessage(), exception.getCause());
		}
	}

	/**
	 * Gets the single instance of Configuration Reader
	 * 
	 * @return object of ConfigurationReader class
	 */
	public static ConfigurationReader getInstance() {
		if (configurationReader == null)
			configurationReader = new ConfigurationReader();
		return configurationReader;
	}

	/**
	 * Gets the property.
	 *
	 * @param key the property name
	 * @return the property
	 */
	public String getProperty(String key) {
		if (properties.containsKey(key)) {
			return (String) properties.get(key);
		}
		logger.error("Property value with key: " + key + " not found.");
		return null;
	}
}
