package com.revature.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionUtil {
        private static ConnectionUtil cu = null;
        private static Properties prop;
/*
        private ConnectionUtil() {
                prop = new Properties();
                try {
                        //FileReader file = new FileReader("src/main/resources/database.properties");
                        InputStream dbProps = ConnectionUtil.class.getClassLoader().getResourceAsStream("database.properties");
                        prop.load(dbProps);
                } catch(Exception e) {
                        LogUtil.logException(e, ConnectionUtil.class);
                }
        }
        public static synchronized ConnectionUtil getInstance() {
                if(cu == null) {
                        cu = new ConnectionUtil();
                }
                return cu;
        }

        public Connection getConnection() {
                Connection conn = null;

                try {
                        //We have to register the driver class or we won't be able to find it.
                        Class.forName(prop.getProperty("dvr"));
                        conn = DriverManager.getConnection(prop.getProperty("url"),
                                        prop.getProperty("usr"), prop.getProperty("psw"));
                } catch(Exception e) {
                        LogUtil.logException(e, ConnectionUtil.class);
                }

                return conn;
        }
        */
}