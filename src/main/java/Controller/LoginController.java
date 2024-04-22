package Controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.UserDao;
import Model.User;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController/*")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String referer = request.getParameter("origin");
	        request.setAttribute("origin", referer);
//		System.out.print("vao ligin ");
	        forward(request, response, "/views/auth/login.jsp");
	        }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		 String key = request.getParameter("username");
	     String pass = request.getParameter("password");
	     String ori = request.getParameter("origin");
         System.out.println("vao dang nhap " + ori );

//	     
	     UserDao dao = new UserDao();
	     try {
			User user = dao.getUser(key, pass);
			if(user != null) {
	            System.out.println("Đăng nhập thành công! User: " + user.getUsername());
//	            save session
	            HttpSession session = request.getSession();
	            session.setAttribute("user", user);
	            if(user.getIs_admin() == 1) {
//	                response.sendRedirect("./Dashboard");
	                response.sendRedirect("/booking/DashBoardAdmin");


	            }
	            else if(user.getIs_sell() == 1) {
	                response.sendRedirect("/booking/DashBoardSell");

	            }
	            else {
	                response.sendRedirect(request.getParameter("origin"));

	            }
			}else {
	            System.out.println("Tên đăng nhập hoặc mật khẩu không đúng!");

			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	        
	}
	 private void forward(HttpServletRequest request, HttpServletResponse response, String path) throws ServletException, IOException {
	        RequestDispatcher rd = request.getRequestDispatcher(path);
	        rd.forward(request, response);
	    }
}
