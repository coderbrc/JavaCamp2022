package dataAccess.course;

import java.util.ArrayList;
import java.util.List;

import entities.Course;

public class JdbcCourseDao implements CourseDao {
	Course course1 = new Course(1, "C++", 5);
	Course course2 = new Course(2, "C#", 50);
	List<Course> courses = new ArrayList<Course>();

	public JdbcCourseDao() {
		courses.add(course1);
		courses.add(course2);
	}

	@Override
	public void add(Course course) {
		System.out.println("JDBC ile course veritabanına eklendi." + course.getCourseName());
	}

	@Override
	public List<Course> getallCourses() {
		return courses;
	}
}
