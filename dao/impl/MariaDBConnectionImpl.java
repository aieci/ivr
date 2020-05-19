package impl;

import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.log4j.Logger;

import interfase.IDBConnection;

public class MariaDBConnectionImpl implements IDBConnection {
	
	
	private Connection mdbcon = null;
	
	private static final String DB_URL = "jdbc:mariadb://192.168.193.181:3306/asterisk";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "temporal01";
	private final static Logger log = Logger.getLogger(MariaDBConnectionImpl.class.getName());

	
	public Connection getDBConnection() {
	    	try {
	    		
	    		if( mdbcon == null) {
	    			mdbcon = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
	    	    	
	    	    	log.info("Conectado a la BBDD");
	    	    	
	    		}
	    	} 
	    	catch (Exception e) {
	    		log.error("No ha sido posible conectar a la BBDD.");
	    	}
	    	
	    	return mdbcon;
	    }
}
