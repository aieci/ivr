package impl;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import bean.AtributosNumeracion;


public class CallsImpl extends MariaDBConnectionImpl {

	
	
	
	public Boolean insertData(String numero, List<AtributosNumeracion> lista) throws SQLException {
	
		String insertCalls = " INSERT INTO call_center.calls VALUES (null,1, '"+numero+"', null, null, null, null, null, 0,"
				+ "  null, null, null, null, null, 0, null, null, null, null, null, null, null, null, null, 0 )";
		
		String getID = "SELECT id FROM call_center.calls where phone = '"+numero+"'";
		
		int idCall = 0;
		
		
		Connection mdbcon = getDBConnection();
		
		Statement s = mdbcon.createStatement();
		s.executeQuery(insertCalls);
		
		
		idCall = s.executeQuery(getID).getInt(0);
		
		for(AtributosNumeracion a : lista) {
			
			String insertCallAttribute = " INSERT INTO call_center.call_attribute VALUES (null, "+idCall+", "
					+ "'"+a.getColumna()+"', '"+a.getValor()+"',"+lista.indexOf(a);
			
			s.executeQuery(insertCallAttribute);
			
		}
		
		
		return true;
	}
	
	
	
	public String getCampaingContacts() throws SQLException {
		String sql = " select a.phone as telefono, b.value as nombre " + 
				" from call_center.calls a " + 
				" left join call_center.call_attribute b " + 
				" on a.id = b.id " + 
				" WHERE b.columna = 'nombre'";
		
		Connection mdbcon = getDBConnection();
		
		Statement s = mdbcon.createStatement();
		
		ResultSet rs = s.executeQuery(sql);
		
		String phone = null;
		String name = null;
		
		while (rs.next() ) {
			phone = rs.getString("telefono");
			name = rs.getString("nombre");
			
		}
		
		return name + ";" + phone;
	}
}
