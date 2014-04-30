import java.util.Scanner;

public class UIRecallItem extends UserInterface {
   public static final String prompt = "Input the ID of the item to recal: ";
   
   public static void show(boolean loggedIn, boolean admin) {
      System.out.println(prompt);
      flagItem();
   }
   
   // Slightly misleading, actually sets the item's due date to a week from today
   public static void flagItem() {
      Rental holder = null;
      Scanner sc = new Scanner(System.in);
      int toRecall = sc.nextInt();
      TransactionController.recallRental(toRecall);
      UIMainScreen.show(true, false);
   }
}