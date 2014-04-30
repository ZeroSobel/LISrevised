import java.util.Scanner;

public class UIPayFee extends UserInterface
{
   private static final String intro = "Enter the Member ID for payment: ";
   private static final String payprompt = "\nEnter the amount paid: ";
   private static final String update = "\nMember now owes: ";
   
   private double theFee;
   public UIPayFee()
   {
   
   }
   
   public static void show(boolean loggedIn, boolean admin) {
      System.out.print(intro);
      repay(loggedIn, admin);
   }
   
   public static void repay(boolean loggedIn, boolean admin)
   {
      Scanner sc = new Scanner(System.in);
      int id = sc.nextInt();
      Member debtor = (Member) AcctFinder.retrieveInfo(id);
      double owed = debtor.getFee();
      System.out.print(payprompt);
      double payment = sc.nextInt();
      TransactionController.create(id, payment);
      AcctFinder.modifyMember(id, "fee", Double.toString(owed-payment));
      System.out.println(update + Double.toString(owed-payment));

      UIMainScreen.show(loggedIn, admin);
   }
}