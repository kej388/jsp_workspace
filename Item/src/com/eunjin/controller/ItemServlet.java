package com.eunjin.controller;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.eunjin.dao.ItemDAO;
import com.eunjin.dto.ItemVO;

/**
 * Servlet implementation class itemServlet
 */
@WebServlet("/itemInfo.do")
public class ItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		//정보수집
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		String description = request.getParameter("description");
		
		//vo
		ItemVO iVo = new ItemVO();
		iVo.setName(name);
		iVo.setPrice(Integer.parseInt(price));
		iVo.setDescription(description);
		
		//dao
		ItemDAO iDo = ItemDAO.getInstance();
		int result = iDo.insertItemInfo(iVo);
		
		HttpSession session= request.getSession();
		
		if(result == 1) {
			session.setAttribute("name", iVo.getName());
			request.setAttribute("message", "등록되었습니다.");
		} else {
			request.setAttribute("message", "실패했습니다.");
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("itemWriteResult.jsp");
		dispatcher.forward(request, response);
	}

}
