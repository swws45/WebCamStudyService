package controllers;

import java.text.ParseException;
import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import util.Util;
import dto.MyStudyList;

@Controller
@RequestMapping("/mystudy/")
public class MystudyController {
	
	@Autowired
	private SqlSession sqlsession;
	
	@Autowired
	Util util;
	
	@RequestMapping("webstudy.do")
	public String webstudy(Model model) throws ParseException{
		ArrayList<MyStudyList> mystudylist=util.GetMyStudyList(sqlsession,0);
		String table="";
		int i=1;
		
		while(true) {
			MyStudyList temp=null;
			for(MyStudyList array:mystudylist){
				if(array.getTime_start_study() == i) temp=array;
			}
			if(temp != null){
				while(true){
					if(i==temp.getTime_start_study()){
					table+="<tr>";
					table+="<td>"+i+"시 </td>";
					table+="<td rowspan="+"'"+(temp.getTime_end_study()-temp.getTime_start_study()+1)+"' >";
					table+=temp.getName_study();
					table+="</td>";
					table+="<td rowspan="+"'"+(temp.getTime_end_study()-temp.getTime_start_study()+1)+"' >";
					table+="시작";
					table+="</td>";
					}
					else if(i<= temp.getTime_end_study()) table+="<tr><td>"+i+"시 </td></tr>";
					else break;
					i++;
				}
			} 
			else {
				table+="<tr><td>"+i+"시 </td><td></td><td></td></tr>";
				i++;
			}
			if(i>24) break;
		}
		model.addAttribute("table",table);
		return "user.mystudy.webstudy";
	}
	
	@RequestMapping("studyinfo.do")
	public String studyinfo(Model model) throws ParseException{
		int time_total=0;
		ArrayList<MyStudyList> mystudylist=util.GetMyStudyList(sqlsession,0);
		
		for(MyStudyList array : mystudylist)
			time_total += array.getAcc_time_list();
		
		model.addAttribute("time_total",time_total);
		model.addAttribute("list",mystudylist);
		return "user.mystudy.studyinfo";
	}
	
	@RequestMapping("testresult.do")
	public String testresult(){
		return "user.mystudy.testresult";
	}
	
}
