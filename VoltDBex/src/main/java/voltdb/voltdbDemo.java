package voltdb;

import java.sql.*;

public class voltdbDemo {
	 public static void main(String[] args) {
		 
	        String driver = "org.voltdb.jdbc.Driver";
	        String voltdb = "jdbc:voltdb://localhost:21212";
	       
	        
	        String sql = "SELECT * FROM SUBSCRIBER";
	        try {
	               
	            Class.forName(driver);
	            Connection conn = DriverManager.getConnection(voltdb);
	                    
	            Statement query = conn.createStatement();
	            ResultSet resultSet = query.executeQuery(sql);
	            while (resultSet.next()) {
	                int subsc_id = resultSet.getInt("SUBSC_ID");
	                String subsc_name = resultSet.getString("SUBSC_NAME");
	                String subsc_surname = resultSet.getString("SUBSC_SURNAME");
	                String msisdn = resultSet.getString("MSISDN");
	                int tariff_id = resultSet.getInt("TRAIFF_ID");
	                Date start_date = resultSet.getDate("START_DATE");

	                System.out.println("SUBSC_ID: " + subsc_id + 
	                				   " |  SUBSC_NAME: " + subsc_name +
	                                   " | SUBSC_SURNAME: " + subsc_surname +
	                                   " | MSISDN: " + msisdn +
	                                   " | TRAIFF_ID: " + tariff_id +
	                                   " | START_DATE: " + start_date);
	            }	        
	            resultSet.close();
	            query.close();
	            conn.close();
	        } catch (Exception e) {
	           e.printStackTrace();
	        }
	    }
	}



