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
      int mid = Integer.parseInt(sc.nextLine());
      int iid = Integer.parseInt(sc.nextLine());
      int dueDate = sc.nextInt();
      boolean notReserved = (CatalogController.getReserve(iid) == 0);
      boolean meReserved = (CatalogController.getReserve(iid) == mid);
      boolean notChecked = (CatalogController.getCheck(iid) == 0);
      if((notReserved || meReserved) && notChecked) {
         TransactionController.create(mid, dueDate, 00000000, iid, 0);
         CatalogController.placeCheck(iid, mid);
      }
      else {
         System.out.println(reserve);
      }
      UIMainScreen.show(true, true);
   }
}