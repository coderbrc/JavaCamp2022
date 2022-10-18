package dataAccess.educator;

import entities.Educator;

public class JdbcEducatorDao implements EducatorDao {

	@Override
	public void add(Educator educator) {
		System.out.println("JDBC ile educator veritabanýna eklendi.");		
	}
}
