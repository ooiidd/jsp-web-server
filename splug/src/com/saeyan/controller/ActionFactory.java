package com.saeyan.controller;

import com.board.action.ikBoardDeleteAction;
import com.board.action.ikBoardListAction;
import com.board.action.ikBoardUpdateAction;
import com.board.action.ikBoardUpdateFormAction;
import com.board.action.ikBoardWriteAction;
import com.board.action.ikBoardWriteFormAction;
import com.board.action.ikSearchAction;
import com.board.action.ikShowBoardAction;
import com.dat.action.freeDatWriteAction;
import com.dat.action.ikDatWriteAction;
import com.dat.action.noticeDatWriteAction;
import com.dat.action.suggestDatWriteAction;
import com.free.action.freeBoardDeleteAction;
import com.free.action.freeBoardListAction;
import com.free.action.freeBoardUpdateAction;
import com.free.action.freeBoardUpdateFormAction;
import com.free.action.freeBoardWriteAction;
import com.free.action.freeBoardWriteFormAction;
import com.free.action.freeSearchAction;
import com.free.action.freeShowBoardAction;
import com.history.action.history;
import com.jokbo.action.jokboBoardDeleteAction;
import com.jokbo.action.jokboBoardDownAction;
import com.jokbo.action.jokboBoardListAction;
import com.jokbo.action.jokboBoardUpdateAction;
import com.jokbo.action.jokboBoardUpdateFormAction;
import com.jokbo.action.jokboBoardWriteFormAction;
import com.jokbo.action.jokboSearchAction;
import com.jokbo.action.jokboShowBoardAction;
import com.manage.action.memberManage;
import com.manage.action.memberSelfUpdate;
import com.manage.action.memberSelfUpdateForm;
import com.manage.action.memberUpdate;
import com.meeting.action.meetingBoardDeleteAction;
import com.meeting.action.meetingBoardListAction;
import com.meeting.action.meetingBoardUpdateAction;
import com.meeting.action.meetingBoardUpdateFormAction;
import com.meeting.action.meetingBoardWriteAction;
import com.meeting.action.meetingBoardWriteFormAction;
import com.meeting.action.meetingSearchAction;
import com.meeting.action.meetingShowBoardAction;
import com.notice.action.noticeBoardDeleteAction;
import com.notice.action.noticeBoardListAction;
import com.notice.action.noticeBoardUpdateAction;
import com.notice.action.noticeBoardUpdateFormAction;
import com.notice.action.noticeBoardWriteAction;
import com.notice.action.noticeBoardWriteFormAction;
import com.notice.action.noticeSearchAction;
import com.notice.action.noticeShowBoardAction;
import com.photo.action.photoListAction;
import com.photo.action.photoShowAction;
import com.photo.action.photoWriteFormAction;
import com.qna.action.qnaBoardDeleteAction;
import com.qna.action.qnaBoardListAction;
import com.qna.action.qnaBoardUpdateAction;
import com.qna.action.qnaBoardUpdateFormAction;
import com.qna.action.qnaBoardWriteAction;
import com.qna.action.qnaBoardWriteFormAction;
import com.qna.action.qnaSearchAction;
import com.qna.action.qnaShowBoardAction;
import com.saeyan.controller.action.Action;
import com.saeyan.controller.action.HomeAction;
import com.saeyan.controller.action.IdAction;
import com.saeyan.controller.action.JoinAction;
import com.saeyan.controller.action.LoginHomeAction;
import com.saeyan.controller.action.LogoutAction;
import com.schedule.action.scheduleAddAction;
import com.schedule.action.scheduleAddDB;
import com.schedule.action.scheduleShowAction;
import com.suggest.action.suggestBoardDeleteAction;
import com.suggest.action.suggestBoardListAction;
import com.suggest.action.suggestBoardUpdateAction;
import com.suggest.action.suggestBoardUpdateFormAction;
import com.suggest.action.suggestBoardWriteAction;
import com.suggest.action.suggestBoardWriteFormAction;
import com.suggest.action.suggestSearchAction;
import com.suggest.action.suggestShowBoardAction;


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
		System.out.println("ActionFactory :" + command);
		/* 추가된 부분 */
		if (command.equals("home")) {
			action = new HomeAction();
		}else if(command.equals("freedat_write")){
			action = new freeDatWriteAction();
		}else if(command.equals("join")) {
			action = new JoinAction();
		}else if(command.equals("idcheck")){
			action = new IdAction();
		}else if(command.equals("logout")){
			action = new LogoutAction();
		}else if(command.equals("loginhome")){
			action = new LoginHomeAction();
		}else if(command.equals("ikboardList")){
			action = new ikBoardListAction();
		}else if(command.equals("ik_write")){
			action = new ikBoardWriteAction();
		}else if(command.equals("ik_writeForm")){
			action = new ikBoardWriteFormAction();
		}else if(command.equals("ik_search")){
			action = new ikSearchAction();
		}else if(command.equals("ik_show")){
			action = new ikShowBoardAction();
		}else if(command.equals("ikboard_delete")){
			action = new ikBoardDeleteAction();
		}else if(command.equals("ikboard_update")){
			action = new ikBoardUpdateAction();
		}else if(command.equals("ikboard_update_form")){
			action = new ikBoardUpdateFormAction();
		}else if(command.equals("photo")){
			action = new photoListAction();
		}else if(command.equals("photo_write_form")){
			action = new photoWriteFormAction();
		}else if(command.equals("photo_show")){
			action = new photoShowAction();
		}else if(command.equals("freeboardList")){
			action = new freeBoardListAction();
		}else if(command.equals("free_write")){
			action = new freeBoardWriteAction();
		}else if(command.equals("free_writeForm")){
			action = new freeBoardWriteFormAction();
		}else if(command.equals("free_search")){
			action = new freeSearchAction();
		}else if(command.equals("free_show")){
			action = new freeShowBoardAction();
		}else if(command.equals("freeboard_delete")){
			action = new freeBoardDeleteAction();
		}else if(command.equals("freeboard_update")){
			action = new freeBoardUpdateAction();
		}else if(command.equals("freeboard_update_form")){
			action = new freeBoardUpdateFormAction();
		}else if(command.equals("noticeboardList")){
			action = new noticeBoardListAction();
		}else if(command.equals("notice_write")){
			action = new noticeBoardWriteAction();
		}else if(command.equals("notice_writeForm")){
			action = new noticeBoardWriteFormAction();
		}else if(command.equals("notice_search")){
			action = new noticeSearchAction();
		}else if(command.equals("notice_show")){
			action = new noticeShowBoardAction();
		}else if(command.equals("noticeboard_delete")){
			action = new noticeBoardDeleteAction();
		}else if(command.equals("noticeboard_update")){
			action = new noticeBoardUpdateAction();
		}else if(command.equals("noticeboard_update_form")){
			action = new noticeBoardUpdateFormAction();
		}else if(command.equals("meetingboardList")){
			action = new meetingBoardListAction();
		}else if(command.equals("meeting_write")){
			action = new meetingBoardWriteAction();
		}else if(command.equals("meeting_writeForm")){
			action = new meetingBoardWriteFormAction();
		}else if(command.equals("meeting_search")){
			action = new meetingSearchAction();
		}else if(command.equals("meeting_show")){
			action = new meetingShowBoardAction();
		}else if(command.equals("meetingboard_delete")){
			action = new meetingBoardDeleteAction();
		}else if(command.equals("meetingboard_update")){
			action = new meetingBoardUpdateAction();
		}else if(command.equals("meetingboard_update_form")){
			action = new meetingBoardUpdateFormAction();
		}else if(command.equals("qnaboardList")){
			action = new qnaBoardListAction();
		}else if(command.equals("qna_write")){
			action = new qnaBoardWriteAction();
		}else if(command.equals("qna_writeForm")){
			action = new qnaBoardWriteFormAction();
		}else if(command.equals("qna_search")){
			action = new qnaSearchAction();
		}else if(command.equals("qna_show")){
			action = new qnaShowBoardAction();
		}else if(command.equals("qnaboard_delete")){
			action = new qnaBoardDeleteAction();
		}else if(command.equals("qnaboard_update")){
			action = new qnaBoardUpdateAction();
		}else if(command.equals("qnaboard_update_form")){
			action = new qnaBoardUpdateFormAction();
		}else if(command.equals("suggestboardList")){
			action = new suggestBoardListAction();
		}else if(command.equals("suggest_write")){
			action = new suggestBoardWriteAction();
		}else if(command.equals("suggest_writeForm")){
			action = new suggestBoardWriteFormAction();
		}else if(command.equals("suggest_search")){
			action = new suggestSearchAction();
		}else if(command.equals("suggest_show")){
			action = new suggestShowBoardAction();
		}else if(command.equals("suggestboard_delete")){
			action = new suggestBoardDeleteAction();
		}else if(command.equals("suggestboard_update")){
			action = new suggestBoardUpdateAction();
		}else if(command.equals("suggestboard_update_form")){
			action = new suggestBoardUpdateFormAction();
		}else if(command.equals("jokboboard_down")){
			action = new jokboBoardDownAction();
		}else if(command.equals("jokboboardList")){
			action = new jokboBoardListAction();
		}else if(command.equals("jokbo_writeForm")){
			action = new jokboBoardWriteFormAction();
		}else if(command.equals("jokbo_search")){
			action = new jokboSearchAction();
		}else if(command.equals("jokbo_show")){
			action = new jokboShowBoardAction();
		}else if(command.equals("jokboboard_delete")){
			action = new jokboBoardDeleteAction();
		}else if(command.equals("jokboboard_update")){
			action = new jokboBoardUpdateAction();
		}else if(command.equals("jokboboard_update_form")){
			action = new jokboBoardUpdateFormAction();
		}else if(command.equals("member")){
			action = new memberManage();
		}else if(command.equals("manage_update")){
			action = new memberUpdate();
		}else if(command.equals("self_update_form")){
			action = new memberSelfUpdateForm();
		}else if(command.equals("member_update")){
			action = new memberSelfUpdate();
		}else if(command.equals("schedule_add")){
			action = new scheduleAddAction();
		}else if(command.equals("schedule_show")){
			action = new scheduleShowAction();
		}else if(command.equals("schedule_add_db")){
			action = new scheduleAddDB();
		}else if(command.equals("history")){
			action = new history();
		}else if(command.equals("ikdat_write")){
			action = new ikDatWriteAction();
		}else if(command.equals("noticedat_write")){
			action = new noticeDatWriteAction();
		}else if(command.equals("suggestdat_write")){
			action = new suggestDatWriteAction();
		}
		return action;
	}
}
