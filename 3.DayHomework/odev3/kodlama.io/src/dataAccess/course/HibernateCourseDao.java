package dataAccess.course;

import java.util.List;

import entities.Course;

public class HibernateCourseDao implements CourseDao {

	@Override
	public void add(Course course) {
		System.out.println("Hibernate ile course veritabanýna eklendi." + course.getCourseName());
	}

	@Override
	public List<Course> getallCourses() {
		// TODO Auto-generated method stub
		return null;
	}
}
