package entities;

public class Category {

	private int id;
	private int courseId;
	private String categoryName;

	public Category(int id, int courseId, String categoryName) {
		super();
		this.id = id;
		this.courseId = courseId;
		this.categoryName = categoryName;
	}

	public Category() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
}
