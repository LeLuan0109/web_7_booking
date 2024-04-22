package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Context.DBContext;

public class PayDao {

	
	public PayDao() {
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
	
	 public boolean insertDateRangePay( int detailHomeId, int userId) {
	        try {
	            String sql = "INSERT INTO date_range_pay (startDate, endDate, detail_home_id, user_id) VALUES (?, ?, ?, ?)";
	            PreparedStatement statement = cnn.prepareStatement(sql);
	            statement.setDate(1, null);
	            statement.setDate(2, null);
	            statement.setInt(3, detailHomeId);
	            statement.setInt(4, userId);
	            statement.executeUpdate();
	            statement.close();
	            System.out.println("Data inserted successfully!");
	            return true;
	        } catch (SQLException e) {
	            System.out.println("Insertion error: " + e.getMessage());
	        }
	        return false;
	    }

	
	
}
