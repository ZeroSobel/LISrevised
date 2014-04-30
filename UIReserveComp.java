import java.util.Scanner;

public class UIReserveComp
{
   private static Scanner userInput = new Scanner(System.in);
   private int incCompID;
   
   public UIReserveComp()
   {
   }
   
   public static void timeHold(boolean loggedIn, boolean admin) //name in DCD, may need to be called execute
   {
      System.out.print("What computer would you like to reserve? ");
      int incCompID = userInput.nextInt();
      int userID = AcctFinder.getCurrentAcct().getAccountID();
      TransactionController.create(userID, incCompID);
      UIMainScreen.show(loggedIn, admin);
   }
   
   public static void show(boolean loggedIn, boolean admin) {
      System.out.print("What computer would you like to reserve? ");
      timeHold(loggedIn, admin);
   }
}