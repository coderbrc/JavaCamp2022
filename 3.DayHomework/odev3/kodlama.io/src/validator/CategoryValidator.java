package validator;

import java.util.List;

import entities.Category;

public class CategoryValidator {
	public static boolean isValidCategory(Category category, List<Category> categories) {
		for (Category _category : categories) {
			if (_category.getCategoryName().equals(category.getCategoryName())) {
				return false;
			}
		}
		return true;
	}
}
