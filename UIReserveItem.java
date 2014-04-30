import java.util.Scanner;

public class UIReserveItem extends UserInterface {
   public static final String prompt = "Input the ID of the item you would like to reserve: ";
   public static final String yes = "You have reserved the item.";
   public static final String no= "The item could not be reserved.";
   
   public static void show(boolean loggedIn, boolean admin) {
      System.out.println(prompt);
      Scanner sc = new Scanner(System.in);
      int toReserve = sc.nextInt();
      int currentID = AcctFinder.getCurrentAcct().getAccountID();
      boolean success = CatalogController.placeReserve(toReserve, currentID);
      if(success) {
         System.out.println(yes);
      }
      else {
         System.out.println(no);
      }
      UIMainScreen.show(loggedIn, admin);
      
      //holdForMem(loggedIn, admin);
   }
   /*
   public static void holdForMem(boolean loggedIn, boolean admin) {
      
   }*/
}