public class Employee extends Account {
	private boolean priv;

	public Employee(String nameIn, String phoneIn, String addressIn, 
		int accountIDIn, String accountPasswordIn, boolean privIn) {
		super(nameIn, phoneIn, addressIn, accountIDIn, accountPasswordIn);
		priv = privIn;
	}

	public boolean getPriv() {
		return priv;
	}
	public void setPriv(boolean tf) {
		priv = tf;
	}
}