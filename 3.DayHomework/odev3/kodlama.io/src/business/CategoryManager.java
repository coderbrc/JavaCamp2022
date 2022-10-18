package business;

import java.util.List;

import core.logging.Logger;
import dataAccess.category.CategoryDao;
import entities.Category;
import validator.CategoryValidator;

public class CategoryManager {
	private CategoryDao categoryDao;
	private List<Logger> loggers;

	public CategoryManager(CategoryDao categoryDao, List<Logger> loggers) {
		this.categoryDao = categoryDao;
		this.loggers = loggers;
	}

	public void add(Category category) throws Exception {
		if (!CategoryValidator.isValidCategory(category, categoryDao.getallCategories())) {
			throw new Exception("Category name is not valid.");
		} else {
			categoryDao.add(category);
		}
		for (Logger logger : loggers) {
			logger.log(category.getCategoryName());
		}
	}
}
