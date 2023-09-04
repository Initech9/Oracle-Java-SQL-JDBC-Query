package solution;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.jdbc.OracleDriver;

public class Demo {
 
    public static void main(String[] args) {
         // TODO Auto-generated method stub
  
  try {
   DriverManager.registerDriver(new OracleDriver());    //This is for loading the odbc driver
   System.out.println("Driver loaded Successfully");  
   Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE","sys as sysdba","aa"); //connecting to the database
   System.out.println("Connection Successful");
   
 //JDBC Obj fro Statement
   
   Statement st=con.createStatement();
   String query = "select * from Persons";
   ResultSet rs = st.executeQuery(query);
   ResultSetMetaData rsmd = rs.getMetaData();
   System.out.println("querying SELECT * FROM PERSONS");
   int columnsNumber = rsmd.getColumnCount();
   while (rs.next()) {
       for (int i = 1; i <= columnsNumber; i++) {
           if (i > 1) System.out.print(",  ");
           String columnValue = rs.getString(i);
           System.out.print(columnValue + " " + rsmd.getColumnName(i));
       }
       System.out.println("");
   }
// 	Statement st = con.createStatement();
//
// 	//write the query
//
// 	String query = "select * from Persons";
//
// 	//create JDBC ResultSet obj
//
// 	
// 	ResultSet rs = st.executeQuery(query);
// 	//System.out.println(  "HAHHA" );
// 	
// 	
// 	
// 	//Statement st=cn.createStatement();
// 	//ResultSet rs=st.executeQuery(sql);
// 	while(rs.next())
// 	{
// 	    rs.getInt(1); //or rs.getString("column name");
// 	    System.out.println("HERE" + rs);
// 	}
// 	
//	rs.close();
//	st.close();
//	con.close();

   
  } catch (SQLException e) {
   System.out.println("Some problem in connection");
   
   
   // TODO Auto-generated catch block
   e.printStackTrace();
  }
  
  

  
  

 }

}
