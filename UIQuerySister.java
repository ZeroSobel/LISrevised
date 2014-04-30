import java.util.Scanner;

public class UIQuerySister extends UserInterface {
   private static final String prompt = "Enter the name of the desired item: ";
   private static final String yes = "Library B has your item! Go get it!";
   private static final String no = "I'm sorry, no nearby institutions have that item.";
   
   public static void show(boolean loggedIn, boolean admin) {
      System.out.print(prompt);
      getFrom(loggedIn, admin);
   }
   
   public static void getFrom(boolean loggedIn, boolean admin) {
      //We have no sister libraries so RNG will tell you if Library B has it or not
      double chance = Math.random();
      if(chance > 0.5) {
         System.out.println(yes);
      }
      else {
         System.out.println(no);
      }
      UIMainScreen.show(loggedIn, admin);
   }
}