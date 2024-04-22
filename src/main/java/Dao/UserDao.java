package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Context.DBContext;
import Model.User;

public class UserDao {

	public UserDao() {
		connectDB();
	}

	Connection cnn; // ket noi db
	Statement stm; // thuc thi cac cau lenh sql
	ResultSet rs; // luu tru va xu ly du lieu

	private void connectDB() {
		try {
			cnn = (Connection) (new DBContext().getConnection());
			System.out.println("Connect successfully!");
		} catch (Exception e) {
			System.out.println("Connect error:" + e.getMessage());
		}
	}

	public User getUser(String username, String pass) throws SQLException {
	    try {
	        User loginUser = null;
	        String query = "SELECT * FROM booking_tool.users WHERE username = ? AND pass = ?";
	        PreparedStatement statement = cnn.prepareStatement(query);
	        statement.setString(1, username);
	        statement.setString(2, pass);
	        ResultSet resultSet = statement.executeQuery();
	        if (resultSet.next()) {
	            int id = resultSet.getInt("id");
	            int isAdmin = resultSet.getInt("is_admin");
	            int isSell = resultSet.getInt("is_sell");
	            String fullname = resultSet.getString("fullname");
	            String gender = resultSet.getString("gender");
	            String address = resultSet.getString("address");
	            String email = resultSet.getString("email");
	            String phone = resultSet.getString("phone");
	            loginUser = new User(id, isAdmin, isSell, username, pass, fullname, gender, address, email, phone);
	        }
	        resultSet.close();
	        statement.close();
	        return loginUser;
	    } catch (SQLException e) {
	        System.out.println("getUser Error: " + e.getMessage());
	        throw e;
	    }
	}

}
