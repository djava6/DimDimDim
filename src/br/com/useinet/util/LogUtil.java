package br.com.useinet.util;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class LogUtil {
	
	private static Logger logger;
	
	public static Logger getLogger() {
		if (logger == null) {
			logger = Logger.getLogger("br.com.useinet.Log");
			logger.setLevel(Level.WARN);			
		}
		return logger;
	}
	
}
