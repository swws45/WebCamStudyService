package dto;

public class MyStudyList {
	int no_study; 
	String name_study;
	int manager_no_study;
	String manager_id_study;
	String category_study;
	
	int point_list;
	int acc_time_list;
	int latness;
	int absence;
	
	String date_start_study;
	String date_end_study;
	int time_start_study;
	int time_end_study;
	int d_day;
	
	public int getNo_study() {
		return no_study;
	}
	public void setNo_study(int no_study) {
		this.no_study = no_study;
	}
	public String getName_study() {
		return name_study;
	}
	public void setName_study(String name_study) {
		this.name_study = name_study;
	}
	public int getManager_no_study() {
		return manager_no_study;
	}
	public void setManager_no_study(int manager_no_study) {
		this.manager_no_study = manager_no_study;
	}
	public String getManager_id_study() {
		return manager_id_study;
	}
	public void setManager_id_study(String manager_id_study) {
		this.manager_id_study = manager_id_study;
	}
	public String getCategory_study() {
		return category_study;
	}
	public void setCategory_study(String category_study) {
		this.category_study = category_study;
	}
	public int getPoint_list() {
		return point_list;
	}
	public void setPoint_list(int point_list) {
		this.point_list = point_list;
	}
	public int getAcc_time_list() {
		return acc_time_list;
	}
	public void setAcc_time_list(int acc_time_list) {
		this.acc_time_list = acc_time_list;
	}
	public int getLatness() {
		return latness;
	}
	public void setLatness(int latness) {
		this.latness = latness;
	}
	public int getAbsence() {
		return absence;
	}
	public void setAbsence(int absence) {
		this.absence = absence;
	}
	public String getDate_start_study() {
		return date_start_study;
	}
	public void setDate_start_study(String date_start_study) {
		this.date_start_study = date_start_study;
	}
	public String getDate_end_study() {
		return date_end_study;
	}
	public void setDate_end_study(String date_end_study) {
		this.date_end_study = date_end_study;
	}
	public int getTime_start_study() {
		return time_start_study;
	}
	public void setTime_start_study(int time_start_study) {
		this.time_start_study = time_start_study;
	}
	public int getTime_end_study() {
		return time_end_study;
	}
	public void setTime_end_study(int time_end_study) {
		this.time_end_study = time_end_study;
	}
	public int getD_day() {
		return d_day;
	}
	public void setD_day(int d_day) {
		this.d_day = d_day;
	}
	@Override
	public String toString() {
		return "MyStudyList [no_study=" + no_study + ", name_study=" + name_study + ", manager_no_study="
				+ manager_no_study + ", manager_id_study=" + manager_id_study + ", category_study=" + category_study
				+ ", point_list=" + point_list + ", acc_time_list=" + acc_time_list + ", latness=" + latness
				+ ", absence=" + absence + ", date_start_study=" + date_start_study + ", date_end_study="
				+ date_end_study + ", time_start_study=" + time_start_study + ", time_end_study=" + time_end_study
				+ ", d_day=" + d_day + "]";
	}
	
}
