public class UIMainScreen extends UserInterface {
	private static final String notLogged = "Options:\n1) Log in\n2) Register\n3) Navigate Catalog";
	private static final String logged = "Options:\n1) Navigate Catalog\n2) Reserve Computer Time\n" + 
		"3) Reserve an Item\n4) Recall an Item\n5) Manage Account\n";
	private static final String admin = "Options:\n1) Navigate Catalog\n2) Check Out\n3) Check In\n" +
		"4) Catalog Report\n5) Order Inventory\n6) Process Fee\n7) Add Item\n8) Remove Item\n" +
		"9) Modify Item\n10) Query Sister Libraries\n11) Member Report\n12) Modify Account";

	public UIMainScreen() {

	}
	public static void show(boolean loggedIn, boolean admin) {
		if(!loggedIn) {
			System.out.println(notLogged);
		}
		if(loggedIn && !admin) {
			System.out.println(logged);
		}
		if(loggedIn && admin) {
			System.out.println(admin);
		}


	}
	public static void execute(String input) {
		
	}
}