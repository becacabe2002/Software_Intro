package testLogin;

public class User {
	private String id;
	private String email;
	private String dob;
	private String gen;
	private String lastName;
	private String firstName;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getGen() {
		return gen;
	}
	public void setGen(String gen) {
		this.gen = gen;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Override
	public String toString() {
		return "User<" + this.id + "-" + this.email +">:\n+FirstName: " + this.firstName 
				+ "\n+LastName: " + this.lastName + "\n+Date of Birth: " + this.dob
				+ "\n+Gender: " + this.gen;
	}
}
