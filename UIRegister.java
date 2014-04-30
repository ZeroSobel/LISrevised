import java.util.Scanner;

public class UIRegister extends UserInterface {
   
   private static final String prompt = "\nPlease enter your name: ";
   private static final String phoneprompt = "\nPlease enter your phone number: ";
   private static final String addressprompt = "\nPlease enter your address: ";
   private static final String passprompt = "\nPlease enter your password: ";
   
   public static void show(boolean loggedIn, boolean admin) {
      register(loggedIn, admin);
   }
   
   public static void register(boolean loggedIn, boolean admin) {
      Scanner sc = new Scanner(System.in);
      System.out.print(prompt);
      String name = sc.nextLine();
      System.out.print(phoneprompt);
      String phone = sc.nextLine();
      System.out.print(addressprompt);
      String address = sc.nextLine();
      System.out.print(passprompt);
      String password = sc.nextLine();
      
      AcctFinder.create(name, phone, address, password);
      UIMainScreen.show(true, false);
   }
   
}