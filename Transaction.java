import java.util.*;
import java.text.SimpleDateFormat;

public class Transaction {
	private int id;
	private int memberID;
	private int date;

	public Transaction(int idIn, int memberIDIn, int dateIn) {
		id = idIn;
		memberID = memberIDIn;
		date = dateIn;
	}

	public int getID() {
		return id;
	}
	public int getMemberID() {
		return memberID;
	}
	public int getDate() {
		return date;
	}

	public void setID(int idIn) {
		id = idIn;
	}
	public void setMemberID(int idIn) {
		memberID = idIn;
	}
	public void setDate(int dateIn) {
		date = dateIn;
	}
}