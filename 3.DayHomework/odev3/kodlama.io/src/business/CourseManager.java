package business;

import java.util.List;

import core.logging.Logger;
import dataAccess.course.CourseDao;
import entities.Course;
import validator.CourseValidator;

public class CourseManager {
	private CourseDao courseDao;
	private List<Logger> loggers;

	public CourseManager(CourseDao courseDao, List<Logger> loggers) {
		this.courseDao = courseDao;
		this.loggers = loggers;
	}

	public void add(Course course) throws Exception {

		if (!CourseValidator.isValidCourse(course, courseDao.getallCourses())) {
			throw new Exception("Course name isn't valid");
		}
		if (!CourseValidator.isValidCoursePrice(course)) {
			System.out.println("Course price isn't valid");
		} else {
			courseDao.add(course);
		}

		for (Logger logger : loggers) {
			logger.log(course.getCourseName());
		}
	}
}
