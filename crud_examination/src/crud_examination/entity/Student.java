package crud_examination.entity;

public class Student {
//	private int id;
//	private String first_name;
//	private String last_name;
//	private String email;
//	public Student() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//	public Student(int id, String first_name, String last_name, String email) {
//		super();
//		this.id = id;
//		this.first_name = first_name;
//		this.last_name = last_name;
//		this.email = email;
//	}
//	public Student(String first_name, String last_name, String email) {
//		super();
//		this.first_name = first_name;
//		this.last_name = last_name;
//		this.email = email;
//	}
//	@Override
//	public String toString() {
//		return "Student [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", email=" + email
//				+ "]";
//	}
//	public int getId() {
//		return id;
//	}
//	public void setId(int id) {
//		this.id = id;
//	}
//	public String getFirst_name() {
//		return first_name;
//	}
//	public void setFirst_name(String first_name) {
//		this.first_name = first_name;
//	}
//	public String getLast_name() {
//		return last_name;
//	}
//	public void setLast_name(String last_name) {
//		this.last_name = last_name;
//	}
//	public String getEmail() {
//		return email;
//	}
//	public void setEmail(String email) {
//		this.email = email;
//	}
//	
//	
	
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Student(int id, String firstName, String lastName, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	public Student() {
		super();
	}
	public Student(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	
}
