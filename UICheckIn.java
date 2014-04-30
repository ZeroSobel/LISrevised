import java.util.Scanner;

public class UICheckIn extends UserInterface {
   public static final String prompt = "Input item ID to return:";
   
   public static void show(boolean loggedIn, boolean admin) {
      System.out.println(prompt);
      returnBook();
   }
   private static void returnBook() {
      Scanner sc = new Scanner(System.in);
      int iid = sc.nextInt();
      // Verify it was checked out
      if(CatalogController.getCheck(iid) != 0) {
         TransactionController.closeRental(iid);
      }
      CatalogController.placeCheck(iid, 0);
      UIMainScreen.show(true, true);
   }
}