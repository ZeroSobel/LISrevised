import java.util.Scanner;

public class UIOrderInventory extends UserInterface {
   
   public static void show(boolean loggedIn, boolean admin) {
      System.out.println("Please input the ID of the item to order and the quantity: ");
      getNew();
   }
   private static void getNew() {
      Scanner sc = new Scanner(System.in);
      int id = sc.nextInt();
      int amount = sc.nextInt();
      CatalogController.orderMore(id, amount);
      UIMainScreen.show(true, true);
   }
}