package dataAccess.educator;

import entities.Educator;

public class HibernateEducatorDao implements EducatorDao {

	@Override
	public void add(Educator educator) {
		System.out.println(
				"Hibernate ile educator veritaban�na eklendi." + educator.getFirstName() + educator.getLastName());
	}
}
