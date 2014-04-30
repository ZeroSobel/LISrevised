import java.util.Scanner;

public class UILogIn extends UserInterface {
	public static final String prompt = "Fill out form or enter \"goback\" to return to the main menu.";
	public static final String userID = "User ID: ";
	public static final String userPass = "\nPassword: ";
	public static final String logFail = "Incorrect credentials.";
	public static final String logSuc = "Logged in!";

	public UILogIn() {

	}

	public static void show(boolean loggedIn, boolean admin) {
		System.out.println(prompt);
		System.out.print(userID);
		execute(loggedIn, admin);
		

	}

	public static void execute(boolean loggedIn, boolean admin) {
		String input = "";
		String userID = "";
		String password = "";
		boolean valid = false;
		Scanner sc = new Scanner(System.in);

			input = sc.nextLine();
			userID = input;
			if(userID.compareToIgnoreCase("goback") == 0) {
				UIMainScreen.show(loggedIn, admin);
			}
			else if(userID.matches("[0-9]")) {
				System.out.println(userPass);
				input = sc.nextLine();
				password = input;
				int success = AcctFinder.tryLogin(Integer.parseInt(userID), password);
				switch(success) {
					case 0:	System.out.println(logFail);
						UIMainScreen.show(false, false);
						break;
					case 1:	System.out.println(logSuc);
						UIMainScreen.show(true, false);
						break;
					case 2: System.out.println(logSuc);
						UIMainScreen.show(true, true);
						break;
				}

		}
	}
}