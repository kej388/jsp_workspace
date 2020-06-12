package com.saeyan.controll.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eunjinkoh.dao.BoardDAO;
import com.eunjinkoh.dto.BoardVO;
import com.eunjinkoh.dto.ReplyVVO;

public class BoardCheckPassAction implements Action{

	@Override
	public void execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String url = null;
		
		String num = request.getParameter("num");
		String pass = request.getParameter("pass");
		String no = request.getParameter("no");
		
		System.out.println(no);
		
		BoardDAO bDao = BoardDAO.getInstance();
		BoardVO bVo = bDao.selectOneBoardByNum(num);
		ReplyVVO rVo = bDao.selectOneReplyByNum(no);
		
		System.out.println(num);
		
		if(rVo.getPassword().equals(pass)) {
			url = "/board/checkSuccess.jsp";
			request.setAttribute("no", rVo.getNo());
			request.setAttribute("pnum", rVo.getpNum());
		} else if(bVo.getPass().equals(pass)) {
			url = "/board/checkSuccess.jsp";
		} else {
			url = "/board/boardCheckPass.jsp";
			request.setAttribute("message", "비밀번호가 틀렸습니다.");
		} 
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
	
}
