public class UserInterface {
    private Controller controller;
    protected static String inputBuffer;
    private static boolean login;
    private static boolean admin;

    public UserInterface() {
	controller = new Controller();
	login = false;
	inputBuffer = "";
    }

    public static void show() {

    }
    public static void execute(String input) {
		
    }

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
