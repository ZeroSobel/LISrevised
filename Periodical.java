public class Periodical extends Item {
	private int datePub;
	private int issue;
	private String publisher;
	private String topic;

	public Periodical(String nameIn, int idIn, int orderIn, int ridIn, int cidIn, int datePubIn, int issueIn, 
		String publisherIn, String topicIn) {
		super(nameIn, idIn, orderIn, ridIn, cidIn);
		datePub = datePubIn;
		issue = issueIn;
		publisher = publisherIn;
		topic = topicIn;
	}

	public String toString() {
		return this.getName()+"    "+publisher+"    "+topic;
	}
	public int getDatePub() {
		return datePub;
	}
	public int getIssue() {
		return issue;
	}
	public String getPublisher() {
		return publisher;
	}
	public String getTopic() {
		return topic;
	}

	public void setDatePub(int datePubIn) {
		datePub = datePubIn;
	}
	public void setIssue(int issueIn) {
		issue = issueIn;
	}
	public void setPublisher(String publisherIn) {
		publisher = publisherIn;
	}
	public void setTopic(String topicIn) {
		topic = topicIn;
	}	
}