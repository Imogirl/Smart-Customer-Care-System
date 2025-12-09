package studentacc;

public class useracc {
	
	private int id;
	private String name;
	private String address;
	private String phone;
	private String stream;
	private String username;
	private String password;
	
	public useracc(int id, String name, String address, String phone, String stream, String username, String password) 
	{
		this.id = id;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.stream = stream;
		this.username = username;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getPhone() {
		return phone;
	}

	public String getStream() {
		return stream;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
	
	
	
	

}

