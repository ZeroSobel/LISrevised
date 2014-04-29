public class Video extends Item {
	//private String name;
	//private int id;
	private int length;
	private int date;

	public Video(String nameIn, int idIn, int lengthIn, int dateIn) {
		super(nameIn, idIn);
		//name = nameIn;
		//id = idIn;
		length = lengthIn;
		date = dateIn;
	}

	public String toString() {
		return this.getName()+"    "+this.getID();
	}
	public int getLength() {
		return length;
	}
	public int getDate() {
		return date;
	}

	public void setLength(int lengthIn) {
		length = lengthIn;
	}
	public void setDate(int dateIn) {
		date = dateIn;
	}
}