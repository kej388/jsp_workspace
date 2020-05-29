package com.eunjinkoh.controll.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eunjinkoh.dao.BoardDAO;
import com.eunjinkoh.dto.ReplyVVO;

public class ReplyCheckPassAction implements Action{

	@Override
	public void execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String url = null;
		
		String num = request.getParameter("no");
		String pass= request.getParameter("pass");
		BoardDAO bDo = BoardDAO.getInstance();
		
		System.out.println(num);
		System.out.println(pass);
		
		ReplyVVO rVo = bDo.selectOneReplyByNum(num);
		
		
		if(rVo.getPassword().equals(pass)) {
			url = "/board/replyUpdate.jsp";
			request.setAttribute("reply", rVo);
		} else {
			url = "/board/boardCheckPass.jsp";
			request.setAttribute("message", "비밀번호가 틀렸습니다.");
		} 
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
