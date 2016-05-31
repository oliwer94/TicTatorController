package com.jofa.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.jofa.controller.TicTatorController;

public class PropertiesUtil
{
	
	   private static final Logger logger = Logger.getLogger(PropertiesUtil.class.getName());
	    
	    private static PropertiesUtil instance = null;

	    private Properties props = new Properties();

	    private PropertiesUtil() {
	    	
	    	ClassLoader loader = PropertiesUtil.class.getClassLoader();
	        InputStream input = null;
	        try {
	            String filename = "properties/services.properties";
	            input = loader.getResourceAsStream(filename);
	            if (input == null) {
	                logger.log(Level.WARNING, "Sorry, unable to find {0}", filename);
	                return;
	            }
	            props.load(input);

	        } catch (IOException ex) {
	            ex.printStackTrace();
	        } finally {
	            if (input != null) {
	                try {
	                    input.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	        }

	    }
	
	public static synchronized PropertiesUtil getInstance() {
        if (instance == null) {
            instance = new PropertiesUtil();
        }
        return instance;
    }
	
	 public String getValue(String propKey) {
	        return this.props.getProperty(propKey);
	    }
	 
}
