package com.eunjinkoh.controller;

import com.eunjinkoh.controll.action.Action;
import com.eunjinkoh.controll.action.BoardCheckPassAction;
import com.eunjinkoh.controll.action.BoardCheckPassFormAction;
import com.eunjinkoh.controll.action.BoardDeleteAction;
import com.eunjinkoh.controll.action.BoardListAction;
import com.eunjinkoh.controll.action.BoardUpdateAction;
import com.eunjinkoh.controll.action.BoardUpdateFormAction;
import com.eunjinkoh.controll.action.BoardViewAction;
import com.eunjinkoh.controll.action.BoardWriteAction;
import com.eunjinkoh.controll.action.BoardWriteFormAction;
import com.eunjinkoh.controll.action.ReplyCheckFromAction;
import com.eunjinkoh.controll.action.ReplyCheckPassAction;
import com.eunjinkoh.controll.action.ReplyCheckPassFormAction;
import com.eunjinkoh.controll.action.ReplyDeleteAction;
import com.eunjinkoh.controll.action.ReplyUpdateAction;
import com.eunjinkoh.controll.action.ReplyUpdateFormAction;
import com.eunjinkoh.controll.action.ReplyWriteAction;

public class ActionFactory {
	private static ActionFactory instance = new ActionFactory();
	
	private ActionFactory() {
		super();
	}
	
	public static ActionFactory getInstance() {
		return instance;
	}
	
	public Action getAction(String command) {
		Action action = null;
		System.out.println("ActionFactory : " + command);
		/* 추가된 부분 */
		if(command.equals("board_list")) {
			action = new BoardListAction();
		} else if(command.equals("board_write")) {
			action = new BoardWriteAction();
		} else if(command.equals("board_write_form")) {
			action = new BoardWriteFormAction();
		} else if(command.equals("board_view")) {
			action = new BoardViewAction();
		} else if(command.equals("board_check_pass_form")) {
			action = new BoardCheckPassFormAction();
		} else if(command.equals("board_check_pass")) {
			action = new BoardCheckPassAction();
		} else if(command.equals("board_update_form")) {
			action = new BoardUpdateFormAction();
		} else if(command.equals("board_update")) {
			action = new BoardUpdateAction();
		} else if(command.contentEquals("board_delete")) {
			action = new BoardDeleteAction();
		} else if(command.equals("reply_write")) {
			action = new ReplyWriteAction();
		} else if(command.equals("reply_update")) {
			action = new ReplyUpdateAction();
		} else if(command.equals("reply_update_form")) {
			action = new ReplyUpdateFormAction();
		} else if(command.equals("reply_check_form")) {
			action= new ReplyCheckFromAction();
		} else if(command.equals("reply_check_pass_form")) {
			action = new ReplyCheckPassFormAction();
		} else if(command.equals("reply_check_pass")) {
			action = new ReplyCheckPassAction();
		} else if(command.equals("reply_delete")) {
			action = new ReplyDeleteAction();
		}

		return action;
	}
}
