package com.eunjinkoh.controll.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eunjinkoh.dao.BoardDAO;

public class ReplyDeleteAction implements Action{

	@Override
	public void execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String no = request.getParameter("no");
		
		BoardDAO bDao = BoardDAO.getInstance();
		bDao.deleteReply(no);
		
		new BoardViewAction().execute(request, response);
		
	}

}
