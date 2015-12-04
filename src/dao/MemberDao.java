package dao;

import dto.Member;

public interface MemberDao {
	Member SearchByMemNo(int no_mem);
}
