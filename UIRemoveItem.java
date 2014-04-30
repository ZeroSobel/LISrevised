import java.util.Scanner;

public class UIRemoveItem extends UserInterface
{

   public UIRemoveItem()
   {
   }
   
   public static void show(boolean loggedIn, boolean admin) {
      System.out.print("Input the ID of the item you wish to remove: ");
      getRidOf();
   }
   
   public static void getRidOf()
   {
      String name;
      int id;
      Scanner userInput = new Scanner(System.in);
      id = userInput.nextInt();
      boolean success = CatalogController.remove(id);
      if(success) {
         System.out.print("Removal Confirmed\n"); 
      }
      else {
         System.out.print("Unable to remove\n");
      }
      UIMainScreen.show(true, true);
   }
}