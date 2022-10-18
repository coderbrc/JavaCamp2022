package dataAccess.course;

import java.util.List;

import entities.Course;

public interface CourseDao {
	void add(Course course);
	List<Course> getallCourses();
}
