import java.util.Scanner;

public class UIModifyItem extends UserInterface {

   public static void show(boolean loggedIn, boolean admin) {
      System.out.println("Please input the desired item ID, the field to modify, and the new value: ");
      makeChange();
   }
   
   private static void makeChange() {
      Scanner sc = new Scanner(System.in);
      int toMod = sc.nextInt();
      String field = sc.nextLine();
      String newData = sc.nextLine();
      
      CatalogController.modifyItem(toMod, field, newData);
      UIMainScreen.show(true, true);
   }
}