package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Context.DBContext;
import Model.DetailHome;
import Model.Homes;

public class HomeDetailDao {
	
	public HomeDetailDao() {
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
	
	public ArrayList<DetailHome> getDetailHomesByHomeId(Integer homeId) throws SQLException {
	    ArrayList<DetailHome> detailHomes = new ArrayList<>();
	    try {
	        String query = "SELECT * FROM booking_tool.detail_home WHERE home_id = ?";
	        PreparedStatement statement = cnn.prepareStatement(query);
	        statement.setInt(1, homeId);
	        ResultSet resultSet = statement.executeQuery();
	        while (resultSet.next()) {
	            int id = resultSet.getInt("id");
	            String title = resultSet.getString("title");
	            int numPerson = resultSet.getInt("numpersion");
	            String description = resultSet.getString("description");
	            double price = resultSet.getDouble("price");
	            
	            // Tạo đối tượng DetailHome và thêm vào danh sách
	            detailHomes.add(new DetailHome(id, title, numPerson, description, price, homeId));
	        }
	        resultSet.close();
	        statement.close();
	    } catch (SQLException e) {
	        System.out.println("getDetailHomesByHomeId Error: " + e.getMessage());
	        throw e;
	    }
	    return detailHomes;
	}

		
}
