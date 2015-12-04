package controllers;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mypage/")
public class MypageController {
	
	@Autowired
	private SqlSession sqlsession; 
	
	@RequestMapping("myprofile.do")
	public String myprofile(){
		return "user.mypage.myprofile";
	}
	
	@RequestMapping("modifypassword.do")
	public String modifypassword(){
		return "user.mypage.modifypassword";
	}
	
	@RequestMapping("widthdrawal.do")
	public String widthdrawal(){
		return "user.mypage.widthdrawal";
	}
	
	
}
