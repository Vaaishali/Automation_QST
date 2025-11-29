package com.log4j2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Demo {

	public static void main(String[] args) 
	{
		Logger log = LogManager.getFormatterLogger();
		log.fatal("This is an Fatal message");
		log.error("This is an Error message");
		log.warn("This is an Warning message");
	}
}
