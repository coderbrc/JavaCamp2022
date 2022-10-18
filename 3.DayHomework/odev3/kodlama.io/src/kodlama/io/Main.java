package kodlama.io;

import java.util.List;

import business.CategoryManager;
import business.CourseManager;
import business.EducatorManager;
import core.logging.DatabaseLogger;
import core.logging.FileLogger;
import core.logging.Logger;
import core.logging.MailLogger;
import dataAccess.category.JdbcCategoryDao;
import dataAccess.course.JdbcCourseDao;
import dataAccess.educator.JdbcEducatorDao;
import entities.Category;
import entities.Course;
import entities.Educator;

public class Main {

	public static void main(String[] args) throws Exception {

		List<Logger> loggers = List.of(new DatabaseLogger(), new FileLogger(), new MailLogger());

		Course course1 = new Course(1, "C# Kursu", 0);
		CourseManager courseManager = new CourseManager(new JdbcCourseDao(), loggers);
		courseManager.add(course1);

		Educator educator = new Educator(1, "Engin", "Demirog", 1);
		EducatorManager educatorManager = new EducatorManager(new JdbcEducatorDao(), loggers);
		educatorManager.add(educator);

		Category category = new Category(4, 1, "Donaným");
		CategoryManager categoryManager = new CategoryManager(new JdbcCategoryDao(), loggers);
		categoryManager.add(category);
	}
}
