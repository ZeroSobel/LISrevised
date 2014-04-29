public class Journal extends Periodical {
	/*
	private String name;
	private int id;
	private int datePub;
	private int issue;
	private String publisher;
	private String topic;
	*/
	private int issn;

	public Journal(String nameIn, int idIn, int datePubIn, int issueIn, 
		String publisherIn, String topicIn, int issnIn) {
		super(nameIn, idIn, datePubIn, issueIn, publisherIn, topicIn);
		/*
		name = nameIn;
		id = idIn;
		datePub = datePubIn;
		issue = issueIn;
		publisher = publisherIn;
		topic = topicIn;
		*/
		issn = issnIn;
	}

	public String toString() {
		return this.getName()+this.getPublisher()+this.getTopic()+issn;
	}
	/*
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
	*/
	public int getISSN() {
		return issn;
	}
	/*
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
	*/
	public void setISSN(int issnIn) {
		issn = issnIn;
	}

}