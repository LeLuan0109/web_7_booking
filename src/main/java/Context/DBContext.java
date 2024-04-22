package Context;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBContext {
    private static DBContext instance;

    public static DBContext getInstance() {
        if (instance == null)
            instance = new DBContext();
        return instance;
    }

    /*USE BELOW METHOD FOR YOUR DATABASE CONNECTION FOR BOTH SINGLE AND MULTILPE SQL SERVER INSTANCE(s)*/
    /*DO NOT EDIT THE BELOW METHOD, YOU MUST USE ONLY THIS ONE FOR YOUR DATABASE CONNECTION*/
    public Connection getConnection() throws Exception {
    	  Class.forName("com.mysql.cj.jdbc.Driver");
          String dburl="jdbc:mysql://localhost:3306/booking_tool";
        return DriverManager.getConnection(dburl, username, password);
    }

    /*Insert your other code right after this comment*/

    /*Change/update information of your database connection, DO NOT change name of instance variables in this class*/
    private final String serverName = "localhost";
    private final String dbName = "booking_tool";
    private final String portNumber = "3306"; // MySQL port is usually 3306
    private final String username = "root"; // Change this to your MySQL username
    private final String password = "0986737453"; // Change this to your MySQL password

}
