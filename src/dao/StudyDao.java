package dao;

import java.util.List;

import dto.Study;

public interface StudyDao {
	
	int GetNextStudyNo();
	void InsertStudy(Study study);
	void InsertMemberToList(int no_study,int no_mem);
	Study SearchByNo(int no_study);
	List<Study> SearchAllStudy();
	List<Study> SearchStudy(String column,String keyword);
	
}