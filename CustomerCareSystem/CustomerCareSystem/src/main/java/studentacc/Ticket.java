package studentacc;

public class Ticket {
	
	private int id;
	private String userid;
	private String subject;
	private String description;
	private String status;
	
	public Ticket(int id, String userid, String subject, String description, String status) {
		
		this.id = id;
		this.userid = userid;
		this.subject = subject;
		this.description = description;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public String getUserid() {
		return userid;
	}

	public String getSubject() {
		return subject;
	}

	public String getDescription() {
		return description;
	}

	public String getStatus() {
		return status;
	}
	
	
	

}
