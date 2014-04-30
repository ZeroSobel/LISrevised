import java.util.Scanner;
import java.lang.String;

public class UINavigateCatalog extends UserInterface {
   public static final String prompt = "Enter a search query, or type \"goback\" to return to the main menu: ";
   public static final String sagain = "\nWould you like to search again? y/n";
   
   
   public UINavigateCatalog() {
   
   }
   
   
   public static void show(boolean loggedIn, boolean admin) {
      boolean repeat = true;
      String selection = "";
      Scanner sc = new Scanner(System.in);
      System.out.println(prompt);
      selection = sc.nextLine();
      execute(selection, loggedIn, admin);
   }
   
   public static void execute(String input, boolean loggedIn, boolean admin) {
      Scanner sc = new Scanner(System.in);
      String selection = ""; 
      if(input.compareTo("goback") == 0) {
         UIMainScreen.show(loggedIn, admin);
      }
      else {
         System.out.println("\n" + CatalogController.search(input));
         System.out.println(sagain);
         selection = sc.nextLine();
         if(selection.compareToIgnoreCase("y") == 0) {
            UINavigateCatalog.show(loggedIn, admin);
         }
         else {
            UIMainScreen.show(loggedIn, admin);
         }
      }
   }
}