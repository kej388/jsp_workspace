package com.eunjinkoh.controll.action;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eunjinkoh.dao.BoardDAO;
import com.eunjinkoh.dto.ReplyVVO;

public class ReplyUpdateAction implements Action{

	@Override
	public void execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ReplyVVO rVo = new ReplyVVO();
		
		rVo.setNo(Integer.parseInt(request.getParameter("num")));
		rVo.setpNum(Integer.parseInt(request.getParameter("pnum")));
		rVo.setName(request.getParameter("name"));
		rVo.setPassword(request.getParameter("pass"));
		rVo.setContent(request.getParameter("content"));
		
		BoardDAO bDao = BoardDAO.getInstance();
		bDao.updateReply(rVo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/board/checkSuccess.jsp");
//		response.sendRedirect("/board/checkSuccess.jsp");
		dispatcher.forward(request, response);
	}

}
