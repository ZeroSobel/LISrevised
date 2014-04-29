import java.lang.String;

public class Account {
	private String name;
	private String phone;
	private String address;
	private int accountID;
	private String accountPassword;

	public Account(String nameIn, String phoneIn, String addressIn, int accountIDIn, String accountPasswordIn) {
		name = nameIn;
		phone = phoneIn;
		address = addressIn;
		accountID = accountIDIn;
		accountPassword = accountPasswordIn;
	}

	public String getName() {
		return name;
	}
	public String getPhone() {
		return phone;
	}
	public String getAddress() {
		return address;
	}
	public int getAccountID() {
		return accountID;
	}
	public String getAccountPassword() {
		return accountPassword;
	}

	public void setName(String nameIn) {
		name = nameIn;
	}
	public void setPhone(String phoneIn) {
		phone = phoneIn;
	}
	public void setAddress(String addressIn) {
		address = addressIn;
	}
	public void setAccountID(int idIn) {
		accountID = idIn;
	}
	public void setAccountPassword(String passIn) {
		accountPassword = passIn;
	}
}