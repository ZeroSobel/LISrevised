public class Periodical extends Item {
	private int datePub;
	private int issue;
	private String publisher;
	private String topic;

	public Periodical(String nameIn, int idIn, int datePubIn, int issueIn, 
		String publisherIn, String topicIn) {
		super(nameIn, idIn);
		datePub = datePubIn;
		issue = issueIn;
		publisher = publisherIn;
		topic = topicIn;
	}

	public String toString() {
		return name+publisher+topic;
	}
	private int getDatePub() {
		return datePub;
	}
	private int getIssue() {
		return issue;
	}
	private String getPublisher() {
		return publisher;
	}
	private String getTopic() {
		return topic;
	}

	private void setDatePub(int datePubIn) {
		datePub = datePubIn;
	}
	private void setIssue(int issueIn) {
		issue = issueIn;
	}
	private void setPublisher(String publisherIn) {
		publisher = publisherIn;
	}
	private void setTopic(String topicIn) {
		topic = topicIn;
	}	
}