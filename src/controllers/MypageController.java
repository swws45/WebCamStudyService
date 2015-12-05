package controllers;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;

import dao.MyPageDao;
import dto.Member;

@Controller
@RequestMapping("/mypage/")
public class MypageController {
	
	@Autowired
	private View jsonv;
	
	@Autowired
	private SqlSession sqlsession; 
	
	@RequestMapping("myprofile.do") 
	//내정보
	public String myprofile(int no_mem) {
		MyPageDao dao = sqlsession.getMapper(MyPageDao.class);
		Member mypofile = dao.SerchByNo(no_mem);
		
		return "user.mypage.myprofile";
	}
	
	@RequestMapping("modifypassword.do")
	//비밀번호 수정
	public View modifypassword(int no_mem, String pwd_mem,ModelMap map){
		boolean result=false;
		MyPageDao dao = sqlsession.getMapper(MyPageDao.class);
		
		Member member = dao.SerchByNo(no_mem);
		if( member.getPwd_mem().equals(pwd_mem)){
			dao.ResetPwd(no_mem, pwd_mem);
			result=true;
		}
		else {
			result=false;
		}
		
		map.addAttribute("result",result);
		
		return jsonv;
	}
	
	@RequestMapping("widthdrawal.do")
	//삭제
	public String widthdrawal(int no_mem){
		MyPageDao dao = sqlsession.getMapper(MyPageDao.class);
		dao.WithDraw(no_mem);
		return "user.mypage.widthdrawal";
	}
}
