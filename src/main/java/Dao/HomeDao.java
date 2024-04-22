package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Context.DBContext;
import Model.Homes;
import Model.User;

public class HomeDao {
	public HomeDao() {
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
	
//	lấy ra all
	public ArrayList<Homes> getHomes() throws SQLException {
		ArrayList<Homes> listHomes = new ArrayList<>();
	    try {
	        String query = "SELECT * FROM booking_tool.homes";
	        PreparedStatement statement = cnn.prepareStatement(query);
	        ResultSet resultSet = statement.executeQuery();
	        while (resultSet.next()) {
	            int id = resultSet.getInt("id");
	            int status = resultSet.getInt("status");
	            float numPrice = resultSet.getFloat("numPrice");
	            String title = resultSet.getString("title");
	            String description = resultSet.getString("description");
	            String img = resultSet.getString("img");
	            // Tạo đối tượng Homes và thêm vào danh sách
	            Homes home = new Homes(id, status, numPrice, title, description, img);
	            listHomes.add(home);
	        }
	        System.out.printf("goi dnah sahc " , listHomes);
	        resultSet.close();
	        statement.close();
	    } catch (SQLException e) {
	        System.out.println("getHomes Error: " + e.getMessage());
	        throw e;
	    }
	    return listHomes;
	}
// lấy ra theo page 
	
	
//lấy ra homeStay thep id
	public Homes getHomeById( Integer id) throws SQLException{
		try {
	        Homes  home = null;
	        String query = "SELECT * FROM booking_tool.homes WHERE id = ?";
	        PreparedStatement statement = cnn.prepareStatement(query);
	        statement.setInt(1, id);
	        ResultSet resultSet = statement.executeQuery();
	        if (resultSet.next()) {
	        	 int idHome = resultSet.getInt("id");
		            int status = resultSet.getInt("status");
		            float numPrice = resultSet.getFloat("numPrice");
		            String title = resultSet.getString("title");
		            String description = resultSet.getString("description");
		            String img = resultSet.getString("img");
		            // Tạo đối tượng Homes và thêm vào danh sách
	            home =  new Homes(idHome, status, numPrice, title, description, img);
	        }
	        resultSet.close();
	        statement.close();
	        return home;
	    } catch (SQLException e) {
	        System.out.println("getUser Error: " + e.getMessage());
	        throw e;
	    }
	}
}
