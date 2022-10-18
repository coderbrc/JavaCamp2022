package entities;

public class Educator {
	private int id;
	private int courseId;
	private String firstName;
	private String lastName;

	public Educator(int id, String firstName, String lastName, int courseId) {
		super();
		this.id = id;
		this.courseId = courseId;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Educator() {

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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
