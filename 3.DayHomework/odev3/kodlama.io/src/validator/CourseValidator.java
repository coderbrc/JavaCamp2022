package validator;

import java.util.List;
import entities.Course;

public class CourseValidator {
	public static boolean isValidCourse(Course course, List<Course> courses) {
		for (Course _course : courses) {
			if (_course.getCourseName().equals(course.getCourseName())) {
				return false;
			}
		}
		return true;
	}

	public static boolean isValidCoursePrice(Course course) {
		if (course.getCoursePrice() == 0) {
			return false;
		}
		return true;
	}
}
