package controllers;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board/")
public class BoardController {
	
	@Autowired
	private SqlSession sqlsession; 
	
	@RequestMapping("recruitstudy.do")
	public String recruitstudy(){
		return "user.board.recruitstudy";
	}
	
	@RequestMapping("freeboard.do")
	public String freeboard(){
		return "user.board.freeboard";
	}
	
	@RequestMapping("qnaboard.do")
	public String qnaboard(){
		return "user.board.qnaboard";
	}
	
	
}
