package com.eunjinkoh.controll.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eunjinkoh.dao.BoardDAO;
import com.eunjinkoh.dto.BoardVO;
import com.eunjinkoh.dto.ReplyVVO;

public class BoardViewAction implements Action{

	@Override
	public void execute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String url = "/board/boardView.jsp";
		
		// 글번호를 받음. 글목록에서 글제목을 클릭했을 때
		String num = null;
		
		
		if(request.getParameter("num") != null) {
			num = request.getParameter("num"); // 리턴값 String
		}
		
		// 댓글을 등록한 후 상세보기로 넘어갈 때
		if(request.getAttribute("num") != null) {
			num = (String) request.getAttribute("num"); // 리턴값 object
		}
		
		BoardDAO bDao = BoardDAO.getInstance();
		
		bDao.updateReadCount(num);
		
		BoardVO bVo = bDao.selectOneBoardByNum(num);
		
		request.setAttribute("board", bVo);
		
		int pNum = Integer.parseInt(num);
		
		List<ReplyVVO> list = bDao.selectAllReply(pNum);
		request.setAttribute("replyList", list);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
