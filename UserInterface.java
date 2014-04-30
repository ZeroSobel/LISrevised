public class UserInterface {
	private Controller controller;
<<<<<<< HEAD
	protected static String inputBuffer;
	private boolean login;
=======
	private String inputBuffer;
	private static boolean login;
   private static boolean admin;
>>>>>>> 776b17dd679bfd1d6c2918d0d677c4b74e3a58cb

	public UserInterface() {
		controller = new Controller();
		login = false;
		inputBuffer = "";
	}

	public static void show() {

	}
	public static void execute(String input) {
		
	}
<<<<<<< HEAD
}
=======
   
   public static void setLogin(boolean in) {
      login = in;
   }
   public static boolean getLogin() {
      return login;
   }
   public static void setAdmin(boolean in) {
      admin = in;
   }
   public static boolean getAdmin() {
      return admin;
   }
}
>>>>>>> 776b17dd679bfd1d6c2918d0d677c4b74e3a58cb
