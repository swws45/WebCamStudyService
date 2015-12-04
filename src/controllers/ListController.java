package controllers;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/list/")
public class ListController {
	
	@Autowired
	private SqlSession sqlsession; 
	
	@RequestMapping("memberlist.do")
	public String memberlist(){
		return "admin.list.memberlist";
	}
	
	@RequestMapping("instantroomlist.do")
	public String instantroomlist(){
		return "admin.list.instantroomlist";
	}
	
	@RequestMapping("examlist.do")
	public String examlist(){
		return "admin.list.examlist";
	}
	
	@RequestMapping("studylist.do")
	public String studylist(){
		return "admin.list.studylist";
	}
	
	
}
