

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class outputform
 */
@WebServlet("/outputform")
public class Outputform extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Outputform() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String pw = request.getParameter("pw");
		String email = request.getParameter("email");
		String chk_mail = request.getParameter("emailYN");
		String hobbys[] = request.getParameterValues("hobby1");
		String job = request.getParameter("job");
		String content = request.getParameter("introduce");
		String picture = request.getParameter("picture");
		
		PrintWriter out = response.getWriter();
		out.print("<h1>회원정보</h1>");
		out.print("id : " + id + "<br>");
		out.print("name : " + name + "<br>");
		out.print("pw : " + pw + "<br>");
		out.print("email : " + email + "<br>");
		out.print("메일 수신여부 : " + chk_mail + "<br>");
		out.print("취미 : ");
		if(hobbys == null) {
			out.print("취미가 없습니다. <br>");
		} else {
			for(String hobby : hobbys) {
				out.print(hobby + ", ");
			}
		}
		out.print("<br> 직업 : " + job);
		out.print("<hr> 자기소개 : " + content + "<br>");
		out.print("사진: <img src='" + picture + "'/>");
		
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
