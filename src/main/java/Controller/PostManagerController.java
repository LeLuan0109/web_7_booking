package Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.HomeDao;
import Model.Homes;

/**
 * Servlet implementation class PostManafer
 */
@WebServlet("/PostManagerController")
public class PostManagerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int value = 0;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostManagerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		System.out.println("vhao ");
//		Dao
		HomeDao hd = new HomeDao();
//		
		String action  = request.getParameter("action") != null ? request.getParameter("action") : "action";	
		String pageIndexString = request.getParameter("xpage");
		String idPost =  request.getParameter("idPost");
		ArrayList<Homes> listPost;
		Homes post1 = null;
		try {
			
			int pageSize = 1;
			listPost = hd.getHomes();
			Integer pageIdex = pageIndexString == null ? 0 : Integer.parseInt(pageIndexString) - 1;
			Integer startPage = pageIdex * pageSize;
			Integer	endPage = Math.min(listPost.size() , startPage + pageSize);
			Integer totalPage =  (listPost.size() % pageSize == 0) ? (listPost.size() / pageSize ) : (listPost.size() / pageSize + 1);
			System.out.println("số trang" + totalPage);
			 request.setAttribute("xpage", pageIdex +1);
             request.setAttribute("numPage", totalPage);
//             request.setAttribute("books", listpage);
//             "btn-primary" : 
	        switch (action) {
	        case "add" :
	        	Homes	add = new Homes();
                request.setAttribute("controlActive", "add");
                request.setAttribute("s", add);

	            request.getRequestDispatcher("/ADMIN/editPost.jsp").forward(request, response);
	        	break;
	        case "update":
	        	Homes	up = hd.getHomeById(Integer.parseInt(idPost));
                request.setAttribute("controlActive", "update");
                request.setAttribute("s", up);

	            request.getRequestDispatcher("/ADMIN/editPost.jsp").forward(request, response);

	        	break;
	        case "delete":
	        	break;
	        default:
	        	
	    		ArrayList<Homes> listToPage = getByPage(listPost, startPage, endPage);
	             request.setAttribute("posts", listToPage);

	            request.getRequestDispatcher("/ADMIN/postManager.jsp").forward(request, response);

	        	break;
	        }
			

			
		} catch (SQLException e) {
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
	

    public ArrayList<Homes> getByPage(ArrayList<Homes> list, int start, int end) {
        ArrayList<Homes> listpage = new ArrayList<>();

        for (int i = start; i < end; i++) {
            listpage.add(list.get(i));
        }
        return listpage;
    }


}
