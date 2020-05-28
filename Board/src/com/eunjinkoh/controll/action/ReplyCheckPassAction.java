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
		
		String pNum = request.getParameter("num");
		String pass = request.getParameter("pass");
		
//		System.out.println(pNum);
//		System.out.println(pass);
		
		BoardDAO bDao = BoardDAO.getInstance();
		
		ReplyVVO rVo = bDao.selectOneReplyByNum(pNum);
		
		System.out.println(rVo.getPassword());
		
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
