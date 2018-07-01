package com.revature.utils;

import java.sql.Connection;

import org.apache.log4j.Logger;

public class LogUtil {
	private LogUtil() {}; // SonarQube says utility classes should not have public constructors.
    public static void logException(Exception e, @SuppressWarnings("rawtypes") Class c) { // ignoring warnings here, this is richard's code.
    	Logger log = Logger.getLogger(c);
    	log.error(e.getClass()+": "+e.getMessage());
    	for(StackTraceElement s : e.getStackTrace()) {
    		log.warn(s.getLineNumber()+": "+s.getClassName());
    	}
    }
    public static void rollback(Exception e, Connection conn, @SuppressWarnings("rawtypes") Class c) {
    	logException(e, c);
    	try {
    		conn.rollback();
    	} catch (Exception e1) {
    		logException(e1, c);
    	}
    }
}
