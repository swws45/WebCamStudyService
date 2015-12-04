package controllers;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/search/")
public class SearchController {
	
	@Autowired
	private SqlSession sqlsession; 
	
	@RequestMapping("searchmember.do")
	public String searchmember(){
		return "admin.search.searchmember";
	}
	
	@RequestMapping("searchinstantroom.do")
	public String searchinstantroom(){
		return "admin.search.searchinstantroom";
	}
	
	@RequestMapping("searchexam.do")
	public String searchexam(){
		return "admin.search.searchexam";
	}
	
	@RequestMapping("searchstudy.do")
	public String searchstudy(){
		return "admin.search.searchstudy";
	}
	
	
}
