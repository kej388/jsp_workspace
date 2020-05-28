package com.eunjinkoh.controll.action;

import java.io.IOException;
import java.sql.Timestamp;

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
		
		rVo.setName(request.getParameter("name"));
		rVo.setPassword(request.getParameter("password"));
		rVo.setContent(request.getParameter("content"));
		
		BoardDAO bDao = BoardDAO.getInstance();
		bDao.updateReply(rVo);
		
		new BoardViewAction().execute(request, response);
	}

}
