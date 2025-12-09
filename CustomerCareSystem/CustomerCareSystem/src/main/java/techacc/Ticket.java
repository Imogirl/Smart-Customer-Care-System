package techacc;

public class Ticket {
	
	private int id;
	private String uid;
	private String subject;
	private String description;
	private String reply;
	
	
	
	public Ticket(int id, String uid, String subject, String description, String reply) {
		this.id = id;
		this.uid = uid;
		this.subject = subject;
		this.description = description;
		this.reply = reply;
	}



	public int getId() {
		return id;
	}



	public String getUid() {
		return uid;
	}



	public String getSubject() {
		return subject;
	}



	public String getDescription() {
		return description;
	}



	public String getReply() {
		return reply;
	}

}
