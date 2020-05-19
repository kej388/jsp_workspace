

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ParamServlet
 */
@WebServlet("/ParamServlet")
public class ParamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ParamServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		String id = request.getParameter("id");
		int age = Integer.parseInt(request.getParameter("age"));
		String items[] = request.getParameterValues("item");
		String interests[] = request.getParameterValues("interest");
		
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.print("아이디 : ");
		out.print(id);
		out.print("<br> 나이 : ");
		out.print(age);
		out.print("<br>");
	
		if(items == null) {
			out.print("선택한 항목이 없습니다.");
		} else {
			out.println("당신이 선택한 항목입니다. <hr>");
			for(String item : items) {
				out.print(item + " ");
			}
		}
		
		if(interests == null) {
			out.print("선택한 항목이 없습니다.");
		} else {
			out.println("당신이 선택한 항목입니다. <hr>");
			for(String interest : interests) {
				out.print(interest + " ");
			}
		}
		out.println("<br><a href='javascript:history.go(-1)'>다시</a>");
		out.print("<body></html>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
