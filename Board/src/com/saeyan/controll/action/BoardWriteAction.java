package com.saeyan.controll.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eunjinkoh.dao.BoardDAO;
import com.eunjinkoh.dto.BoardVO;

public class BoardWriteAction implements Action{

	@Override
	public void execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		BoardVO bVo = new BoardVO();
		
		bVo.setName(request.getParameter("name"));
		bVo.setPass(request.getParameter("pass"));
		bVo.setEmail(request.getParameter("email"));
		bVo.setTitle(request.getParameter("title"));
		bVo.setContent(request.getParameter("content"));
		
		BoardDAO bDao = BoardDAO.getInstance();
		bDao.insertBoard(bVo);
		
		// 목록으로 이동 -> 체이닝.. 제일 먼저 실행
//		new BoardListAction().execute(request, response);
		response.sendRedirect("/Board/BoardServlet?command=board_list");
	}
	
}
