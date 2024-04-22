package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.PayDao;
import Model.User;

/**
 * Servlet implementation class PayController
 */
@WebServlet("/PayController")
public class PayController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PayController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		 String referer = request.getParameter("origin");
		 String startDate = request.getParameter("start_date");
		 String endDate = request.getParameter("end_date");
		 String idDetail = request.getParameter("id_detail");
		    HttpSession session = request.getSession();
		    
		    // Lấy thông tin người dùng từ session attribute
		    User user = (User) session.getAttribute("user");
			 System.out.println(idDetail);
			 System.out.println(user.getId());

//
			 PayDao pd = new PayDao();
			 
		 if(idDetail == null || user == null) {
			 
		 }
		 else {
			 boolean success = pd.insertDateRangePay(Integer.parseInt(idDetail), user.getId());
	            if (success) {
	                // Nếu hành động insert thành công, gửi thông báo thành công ngay trong response
	                response.setContentType("text/html;charset=UTF-8");
	                response.getWriter().write("<div style=\"position: fixed; top: 20px; right: 20px; padding: 10px; background-color: #4CAF50; color: white; border-radius: 5px;\">Đặt hàng thành công! <span style=\"float: right; cursor: pointer;\" onclick=\"this.parentElement.style.display='none';\">&times;</span></div>");
	                return;
	            } else {
	                // Xử lý trường hợp insert không thành công
	            }		 }
		 
		 }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
