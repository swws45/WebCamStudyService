package controllers;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam/")
public class ExamController {
	
	@Autowired
	private SqlSession sqlsession; 
	
	@RequestMapping("searchexam.do")
	public String searchexam(){
		return "user.exam.searchexam";
	}
	
	@RequestMapping("makeexam.do")
	public String makeexam(){
		return "user.exam.makeexam";
	}
	
	@RequestMapping("examqna.do")
	public String examqna(){
		return "user.exam.examqna";
	}
	
	
}
