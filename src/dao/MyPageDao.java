package dao;

import dto.Member;

/* MyPage 정보*/
public interface MyPageDao {
	//기본 정보 
	Member SearchByNo(int no_mem);
	
	//기본 정보 수정
	void UpdateInfo(String email_mem, String intro_mem, int no_mem);
	
	//비밀번호 수정
	/*Member  ConfirmPwd(String pwd_mem);*/
	void ResetPwd(String pwd_mem, int no_mem);
	
	//계정삭제
	void WithDraw(int no_mem);
	
}
