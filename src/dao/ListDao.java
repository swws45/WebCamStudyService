package dao;

import java.util.List;

public interface ListDao {
	List<dto.List> GetListByMember(int no_mem);
	List<dto.List> GetListByStudy(int no_study);
}
