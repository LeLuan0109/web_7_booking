package Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.HomeDao;
import Dao.HomeDetailDao;
import Model.DetailHome;
import Model.Homes;

/**
 * Servlet implementation class HomeStayController
 */
@WebServlet("/HomeStayController/*")
public class HomeStayController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeStayController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idHome = request.getParameter("id");
		
		HomeDao hd = new HomeDao();
		HomeDetailDao hdd = new HomeDetailDao();
		
		try {
			Homes data = hd.getHomeById(Integer.parseInt(idHome));
			ArrayList<DetailHome> detailHomes = hdd.getDetailHomesByHomeId(Integer.parseInt(idHome));
//				System.out.print(detailHomes +  "danh sahc san pham ");
				request.setAttribute("listDataDetail", detailHomes);
			
				request.setAttribute("homeById", data);
				if(detailHomes.size()  > 1) {
					System.out.print("cps data ");
					for (DetailHome detailHome : detailHomes) {
						System.out.print(detailHome.getId());
					}
				}
	            request.getRequestDispatcher("/views/home/home-detail.jsp").forward(request, response);
	
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	 private void forward(HttpServletRequest request, HttpServletResponse response, String path) throws ServletException, IOException {
	        RequestDispatcher rd = request.getRequestDispatcher(path);
	        rd.forward(request, response);
	    }
	 
}
