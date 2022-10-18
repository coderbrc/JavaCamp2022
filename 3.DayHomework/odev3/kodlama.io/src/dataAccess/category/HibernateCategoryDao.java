package dataAccess.category;

import java.util.List;

import entities.Category;

public class HibernateCategoryDao implements CategoryDao {

	@Override
	public void add(Category category) {
		System.out.println("Hibernate ile category veritabanýna eklendi."+category.getCategoryName());
	}

	@Override
	public List<Category> getallCategories() {
		return null;
	}

}
