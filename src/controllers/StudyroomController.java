package controllers;

import java.text.ParseException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.View;

import dao.CategoryDao;
import dao.StudyDao;
import dto.Category;
import dto.Study;

@Controller
@RequestMapping("/studyroom/")
public class StudyroomController {
	
	@Autowired
	private View jsonv;
	
	@Autowired
	private SqlSession sqlsession; 
	
	@RequestMapping(value ="searchstudy.do", method = RequestMethod.GET)
	public String searchstudyget(Model model){
		
		StudyDao dao = sqlsession.getMapper(StudyDao.class);
		List<Study> studylist= dao.SearchAllStudy();    
		
		model.addAttribute("studylist", studylist);
		return "user.studyroom.searchstudy";
	}
	
	@RequestMapping("searchstudyjson.do")
	public View searchstudyjson(String column,String keyword,ModelMap map){

		StudyDao dao = sqlsession.getMapper(StudyDao.class);
		List<Study> list=dao.SearchStudy(column, keyword);
		
		map.addAttribute("list",list);
		return jsonv;
	}
	
	@RequestMapping(value ="makestudy.do", method = RequestMethod.GET)
	public synchronized String makestudyget(Model model){
		CategoryDao dao = sqlsession.getMapper(CategoryDao.class);
		List<Category> categorylist=dao.GetCategory();
		
		
		model.addAttribute("categorylist", categorylist);
		return "user.studyroom.makestudy";
	}
	
	@RequestMapping(value ="makestudy.do", method = RequestMethod.POST)
	public String makestudypost(
			String name_study,
			String category_study,
			String num_mem_max_study,
			String date_start_study,
			String date_end_study,
			String time_start_study,
			String time_end_study,
			String latness_time_study,
			String lateness_panalty_study,
			String absence_panalty_study,
			String notice_study
			) throws ParseException{
		
		StudyDao dao = sqlsession.getMapper(StudyDao.class);
		Study study=new Study();
		
		int no_study=dao.GetNextStudyNo();
		
		study.setNo_study(no_study);
		study.setName_study(name_study);
		study.setManager_no_study(0);
		study.setManager_id_study("camtudy");
		study.setCategory_study(category_study);
		study.setMaxmember_study(Integer.parseInt(num_mem_max_study));
		study.setNumberofmem_study(1);
		study.setDate_start_study(date_start_study);
		study.setDate_end_study(date_end_study);
		study.setTime_start_study(Integer.parseInt(time_start_study));
		study.setTime_end_study(Integer.parseInt(time_end_study));
		study.setLateness_panalty_study(Integer.parseInt(lateness_panalty_study));
		study.setLatness_time_study(Integer.parseInt(latness_time_study));
		study.setAbsence_panalty_study(Integer.parseInt(absence_panalty_study));
		study.setNotice_study(notice_study);
		
		dao.InsertStudy(study);
		dao.InsertMemberToList(no_study,0);
		
		return "user.studyroom.searchstudy";
	}
	
	@RequestMapping("instantroom.do")
	public String instantroom(){
		return "user.studyroom.instantroom";
	}
	
	
}