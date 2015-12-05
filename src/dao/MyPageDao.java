package dao;

import dto.Member;

/* MyPage 정보*/
public interface MyPageDao {
	//기본정보 
	Member SerchByNo(int no_mem);
	
	//비밀번호 수정
	Member  ConfirmPwd(String pwd_mem);
	void ResetPwd(int no_mem,String pwd_mem);
	
	//탈퇴
	void WithDraw(int no_mem);
}
