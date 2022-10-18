package dataAccess.category;

import java.util.ArrayList;
import java.util.List;

import entities.Category;

public class JdbcCategoryDao implements CategoryDao {
	private List<Category> categories = new ArrayList<Category>();
	Category category1 = new Category(1, 1, "Yazýlým");
	Category category2 = new Category(2, 1, "Veritabaný");
	Category category3 = new Category(3, 1, "Görüntü Ýþleme");

	public JdbcCategoryDao() {
		categories.add(category1);
		categories.add(category2);
		categories.add(category3);
	}

	@Override
	public void add(Category category) {
		System.out.println("JDBC ile category veritabanýna eklendi." + category.getCategoryName());
	}

	@Override
	public List<Category> getallCategories() {
		return categories;
	}
}
