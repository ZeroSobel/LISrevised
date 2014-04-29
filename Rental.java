public class Rental extends Transaction {
	private int dueDate;
	private int returnDate;
	private int itemID;
	private double fee;

	public Rental(int idIn, int memberIDIn, int dateIn, int dueDateIn, 
		int returnDateIn, int itemIDIn, double feeIn) {
		super(idIn, memberIDIn, dateIn);
		dueDate = dueDateIn;
		returnDate = returnDateIn;
		itemID = itemIDIn;
		fee = feeIn;
	}
	public int getDueDate() {
		return dueDate;
	}
	public int getReturnDate() {
		return returnDate;
	}
	public int getItemID() {
		return itemID;
	}
	public double getFee() {
		return fee;
	}
	public void setDueDate(int dateIn) {
		dueDate = dateIn;
	}
	public void setReturnDate(int dateIn) {
		returnDate = dateIn;
	}
	public void setItemID(int id) {
		itemID = id;
	}
	public void setFee(double feeIn) {
		fee = feeIn;
	}
}