package com.eunjinkoh.controll.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eunjinkoh.dao.BoardDAO;
import com.eunjinkoh.dto.ReplyVVO;

public class ReplyListAction implements Action{

	@Override
	public void execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int pNum = Integer.parseInt(request.getParameter("pNum"));
		
		BoardDAO bDao = BoardDAO.getInstance();
		List<ReplyVVO> list =  new ArrayList<ReplyVVO>();
		list = bDao.selectAllReply(pNum);
		
		String url = "/board/boardView.jsp";
		request.setAttribute("replyList", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
	
}
