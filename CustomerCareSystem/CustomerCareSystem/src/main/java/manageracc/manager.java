package manageracc;

public class manager {

	private int id;
	private String name;
	private String email;
    private String role;
	private String status;
	private String username;
	private String password;
	
	public manager(int id, String name, String email, String role, String status, String username, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.role = role;
		this.status = status;
		this.username = username;
		this.password = password;
	
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getrole() {
		return role;
	}
	
	public String getstatus() {
		return status;
	}
}
