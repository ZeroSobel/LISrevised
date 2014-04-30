import java.util.Scanner;

public class UICheckOut extends UserInterface {
   public static final String prompt = "Input member ID, item ID, then due date (YYYYMMDD): ";
   public static final String reserve = "That item cannot be checked out. It is reserved.";
   
   public static void show(boolean loggedIn, boolean admin) {
      System.out.println(prompt);
      take();
   }
   
   private static void take() {
      Scanner sc = new Scanner(System.in);
      int mid = sc.nextInt();
      int iid = sc.nextInt();
      int dueDate = sc.nextInt();
      if((CatalogController.getReserve(iid) == 0 || CatalogController.getReserve(iid) == mid) && CatalogController.getCheck(iid) == 0) {
         TransactionController.create(mid, dueDate, 00000000, iid, 0);
         CatalogController.placeCheck(iid, mid);
      }
      else {
         System.out.println(reserve);
      }
      UIMainScreen.show(true, true);
   }
}