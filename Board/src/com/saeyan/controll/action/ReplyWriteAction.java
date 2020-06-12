package com.saeyan.controll.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eunjinkoh.dao.BoardDAO;
import com.eunjinkoh.dto.ReplyVVO;

public class ReplyWriteAction implements Action{

	@Override
	public void execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ReplyVVO rVo = new ReplyVVO();
		
		rVo.setName(request.getParameter("name"));
		rVo.setPassword(request.getParameter("password"));
		rVo.setContent(request.getParameter("content"));
		rVo.setpNum(Integer.parseInt(request.getParameter("pNum")));
		
		BoardDAO bDo = BoardDAO.getInstance();
		bDo.insertReply(rVo);
	
		//부모글의 번호를 전달
		request.setAttribute("num", request.getParameter("pNum"));
		
		new BoardViewAction().execute(request, response);
	}

}
