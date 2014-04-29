public class ReserveCompTime extends Transaction {
	private int compID;

	public ReserveCompTime(int idIn, int memberIDIn, int dateIn, int compIDIn) {
		super(idIn, memberIDIn, dateIn);
		compID = compIDIn;
	}
	public double getCompID() {
		return compID;
	}
	public void setCompID(int idIn) {
		compID = idIn;
	}
}