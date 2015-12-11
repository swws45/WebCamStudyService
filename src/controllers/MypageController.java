package controllers;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	//기본정보//
	@RequestMapping(value="myprofile.do", method=RequestMethod.GET ) 
	public String myprofile(Model model) {
		MyPageDao dao = sqlsession.getMapper(MyPageDao.class);
		Member mypofile = dao.SearchByNo(0);
		model.addAttribute("profile", mypofile);
		return "user.mypage.myprofile";
	}
	//이메일, 자기소개 수정//
	@RequestMapping(value="myprofile.do", method=RequestMethod.POST)
	public View myprofileupdate(String email_mem,String intro_mem, ModelMap map){
		System.out.println("post 컨트롤러 입장");
		String check="0";
		MyPageDao dao = sqlsession.getMapper(MyPageDao.class);
		if(dao.SearchByNo(0).getEmail_mem().equals(email_mem)&&dao.SearchByNo(0).getIntro_mem().equals(intro_mem)){
			check="0";
		}else{
			dao.UpdateInfo(email_mem, intro_mem, 0);
			check="1";
		}
		map.addAttribute("result",check);
		return jsonv;
	}
	//비밀번호 바꾸기 기본노출//
	@RequestMapping(value="modifypassword.do", method=RequestMethod.GET)
	public String modifypassword(Model model) {
		MyPageDao dao = sqlsession.getMapper(MyPageDao.class);
		Member pwd = dao.SearchByNo(0);
		model.addAttribute("pwd",pwd);
		return "user.mypage.modifypassword";
	}
	//기존 비밀번호 체크//
	@RequestMapping(value="modifypassword.do", method=RequestMethod.POST)
	public View checkpassword(String pwd_mem, ModelMap map) {
		MyPageDao dao = sqlsession.getMapper(MyPageDao.class);
		Member pwd = dao.SearchByNo(0);
		String check="0";
		
		if(!pwd.getPwd_mem().equals(pwd_mem)){
			check = "0";
		}else{
			check = "1";
		}
		
		map.addAttribute("result",check);
		return  jsonv;
	}
	//비밀번호 수정//
	@RequestMapping(value="updatepassword.do", method=RequestMethod.POST)
	public View updatepassword(String pwd_mem, Model map) {
		Member pwd = new Member();
		pwd.setPwd_mem(pwd_mem);
		MyPageDao dao = sqlsession.getMapper(MyPageDao.class);
		
		String check="0";
		System.out.println(dao.SearchByNo(0).getPwd_mem().equals(pwd_mem));
		if(dao.SearchByNo(0).getPwd_mem().equals(pwd_mem) == true ){
			check = "0";
		}else{
			dao.ResetPwd(pwd.getPwd_mem(), 0);
		
			check="1";
		}
		map.addAttribute("result",check);
		System.out.println(check);
		return jsonv;
	}
	//계정삭제 기본 페이지
	@RequestMapping(value="withdrawal.do", method=RequestMethod.GET)
	public String widthdrawal(Model model){
		MyPageDao dao = sqlsession.getMapper(MyPageDao.class);
		Member check = dao.SearchByNo(0);
		model.addAttribute("id", check);
		return "user.mypage.withdrawal";
	}
	//계정삭제 아이디 비번 체크
	@RequestMapping(value="withdrawal.do", method=RequestMethod.POST)
	public View checkwidthdrawal(String id_mem, String pwd_mem, ModelMap map){
		MyPageDao dao = sqlsession.getMapper(MyPageDao.class);
		Member idpwd = dao.SearchByNo(0);
		String check="0";
		
		if(idpwd.getId_mem().equals(id_mem) && idpwd.getPwd_mem().equals(pwd_mem)){
			check = "1";
		}else{
			check = "0";
		}
		
		map.addAttribute("result",check);
		return  jsonv;
	}
	//계정삭제 처리
		@RequestMapping(value="withdrawal_fin.do", method=RequestMethod.POST)
		public View delete(String id_mem, String pwd_mem, ModelMap map){
			MyPageDao dao = sqlsession.getMapper(MyPageDao.class);
			Member idpwd = dao.SearchByNo(0);
			String check="0";
			
			if(idpwd.getId_mem().equals(id_mem) && idpwd.getPwd_mem().equals(pwd_mem)){
				check = "1";
			}else{
				check = "0";
			}
			
			map.addAttribute("result",check);
			return  jsonv;
		}
}
