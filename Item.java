public class Item {
	private String name;
	private int id;

	public Item(String nameIn, int idIn) {
		name = nameIn;
		id = idIn;
	}

	public String toString() {
		return name;
	}
	public String getName() {
		return name;
	}
	public int getID() {
		return id;
	}
	public void setName(String nameIn) {
		name = nameIn;
	}
	public void setID(int idIn) {
		id = idIn;
	}
}