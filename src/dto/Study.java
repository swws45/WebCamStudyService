package dto;

public class Study {
	int no_study; /* no_study */
	String name_study;/* name_study */
	int manager_no_study;/* manager_study */
	String manager_id_study;
	String category_study; /* category_study */
	int numberofmem_study;/* num_mem_study  NUMBEROFMEM_STUDY*/
	int maxmember_study; /*MAXMEMBER_STUDY*/
	String Date_start_study; /* Date_start_study */
	String Date_end_study; /* Date_end_study */
	int time_start_study; /* time_start_study */
	int time_end_study; /* time_end_study */
	int lateness_panalty_study; /* lateness_panalty_study */
	int latness_time_study; /* latness_time_study */
	int absence_panalty_study; /* absence_panalty_study */
	String notice_study; /* notice_study */
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
	public int getNumberofmem_study() {
		return numberofmem_study;
	}
	public void setNumberofmem_study(int numberofmem_study) {
		this.numberofmem_study = numberofmem_study;
	}
	public int getMaxmember_study() {
		return maxmember_study;
	}
	public void setMaxmember_study(int maxmember_study) {
		this.maxmember_study = maxmember_study;
	}
	public String getDate_start_study() {
		return Date_start_study;
	}
	public void setDate_start_study(String date_start_study) {
		Date_start_study = date_start_study;
	}
	public String getDate_end_study() {
		return Date_end_study;
	}
	public void setDate_end_study(String date_end_study) {
		Date_end_study = date_end_study;
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
	public int getLateness_panalty_study() {
		return lateness_panalty_study;
	}
	public void setLateness_panalty_study(int lateness_panalty_study) {
		this.lateness_panalty_study = lateness_panalty_study;
	}
	public int getLatness_time_study() {
		return latness_time_study;
	}
	public void setLatness_time_study(int latness_time_study) {
		this.latness_time_study = latness_time_study;
	}
	public int getAbsence_panalty_study() {
		return absence_panalty_study;
	}
	public void setAbsence_panalty_study(int absence_panalty_study) {
		this.absence_panalty_study = absence_panalty_study;
	}
	public String getNotice_study() {
		return notice_study;
	}
	public void setNotice_study(String notice_study) {
		this.notice_study = notice_study;
	}
	@Override
	public String toString() {
		return "Study [no_study=" + no_study + ", name_study=" + name_study + ", manager_no_study=" + manager_no_study
				+ ", manager_id_study=" + manager_id_study + ", category_study=" + category_study
				+ ", numberofmem_study=" + numberofmem_study + ", maxmember_study=" + maxmember_study
				+ ", Date_start_study=" + Date_start_study + ", Date_end_study=" + Date_end_study
				+ ", time_start_study=" + time_start_study + ", time_end_study=" + time_end_study
				+ ", lateness_panalty_study=" + lateness_panalty_study + ", latness_time_study=" + latness_time_study
				+ ", absence_panalty_study=" + absence_panalty_study + ", notice_study=" + notice_study + "]";
	}
}
