package controllers;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.View;

import dao.Test;
import dto.Admin;

@Controller
public class IndexController {

	@Autowired
	private View jsonv; // 주입.	
	
	@Autowired
	private SqlSession sqlsession; 
	
	@RequestMapping("main.do")
	public String main(){
		return "home.main";
	}
	
	@RequestMapping("admin.do")
	public String admin(){
		return "home.admin";
	}
	
	@RequestMapping("test.do")
	public View add(ModelMap map) throws UnsupportedEncodingException {
		
		Test testdao = sqlsession.getMapper(Test.class);
		List<Admin> list=testdao.test();
		
		map.addAttribute("data",list);
		return jsonv;
	}
	
	@RequestMapping("input.do")
	public String test(String[] input,ModelMap map) throws UnsupportedEncodingException {
		for (int i = 0; i < input.length; i++) System.out.println(i+" / "+input[i]);
		return "home.main";
	}
	
}
