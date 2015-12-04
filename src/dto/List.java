package dto;

public class List {
	int no_study;
	int no_mem;
	int latness;
	int absence;
	int point_list;
	int acc_time_list;
	public int getNo_study() {
		return no_study;
	}
	public void setNo_study(int no_study) {
		this.no_study = no_study;
	}
	public int getNo_mem() {
		return no_mem;
	}
	public void setNo_mem(int no_mem) {
		this.no_mem = no_mem;
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
	@Override
	public String toString() {
		return "List [no_study=" + no_study + ", no_mem=" + no_mem + ", latness=" + latness + ", absence=" + absence
				+ ", point_list=" + point_list + ", acc_time_list=" + acc_time_list + "]";
	}
	
	
}
