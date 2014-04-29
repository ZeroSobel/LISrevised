public class Member extends Account {
	private double fee;

	public Member(String nameIn, String phoneIn, String addressIn, 
		int accountIDIn, String accountPasswordIn, double feeIn) {
		super(nameIn, phoneIn, addressIn, accountIDIn, accountPasswordIn);
		fee = feeIn;
	}

	public double getFee() {
		return fee;
	}
	public void setFee(double feeIn) {
		fee = feeIn;
	}
}