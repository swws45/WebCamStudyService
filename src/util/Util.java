package util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import dao.ListDao;
import dao.StudyDao;
import dto.MyStudyList;
import dto.Study;

public class Util {

	public ArrayList<MyStudyList> GetMyStudyList(SqlSession sqlsession,int no_mem) throws ParseException{
		ListDao listdao=sqlsession.getMapper(ListDao.class);
		StudyDao studydao=sqlsession.getMapper(StudyDao.class);
		
		List<dto.List> list=listdao.GetListByMember(no_mem);
		ArrayList<MyStudyList> mystudylist =new ArrayList<MyStudyList>();
		
		for(dto.List array:list){
			MyStudyList temp1 = new MyStudyList();
			Study temp2 = studydao.SearchByNo(array.getNo_study());
			
			temp1.setNo_study(array.getNo_study());
			temp1.setName_study(temp2.getName_study());
			temp1.setCategory_study(temp2.getCategory_study());
			temp1.setManager_no_study(temp2.getManager_no_study());
			temp1.setManager_id_study(temp2.getManager_id_study());

			temp1.setPoint_list(array.getPoint_list());
			temp1.setLatness(array.getLatness());
			temp1.setAbsence(array.getAbsence());
			temp1.setAcc_time_list(array.getAcc_time_list());
			
			temp1.setDate_start_study(temp2.getDate_start_study());
			temp1.setDate_end_study(temp2.getDate_end_study());
			temp1.setTime_start_study(temp2.getTime_start_study());
			temp1.setTime_end_study(temp2.getTime_end_study());
			temp1.setD_day(GetdDay(temp2.getDate_end_study()));

			mystudylist.add(temp1);
		}
		
		return mystudylist;
	}
	
	public int GetdDay(String end) throws ParseException{
				int dday=0;
				Calendar today = Calendar.getInstance();
				Calendar endday = Calendar.getInstance();
				DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				
				today.setTime(new Date());
			    Date enddate = df.parse(end);
		        endday.setTime(enddate);
		        
		   while(true){
		        	today.add(Calendar.DATE, 1);
		        	dday++;
		        	if(today.compareTo(endday)==1) break;
		        }
		return dday;
	}
}
