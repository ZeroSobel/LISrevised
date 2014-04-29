public class Fee extends Transaction {
	private double fee;

	public Fee(int idIn, int memberIDIn, int dateIn, double feeIn) {
		super(idIn, memberIDIn, dateIn);
		fee = feeIn;
	}
	public double getFee() {
		return fee;
	}
	public void setFee(double feeIn) {
		fee = feeIn;
	}
}