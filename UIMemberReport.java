import java.util.Scanner;

public class UIMemberReport extends UserInterface {
   public static final String prompt = "Input ID of member to fetch report.";
   
   
   public static void show(boolean loggedIn, boolean admin) {
      System.out.println(prompt);
      Scanner sc = new Scanner(System.in);
      int id = sc.nextInt();
      genReportMem(id);
   }
   
   private static void genReportMem(int id) {
      Account holder = AcctFinder.retrieveInfo(id);
      if(holder == null) {
         System.out.println("No such account.");
         UIMainScreen.show(true, true);
      }
      else {
         System.out.println(holder.toString());
      }
      UIMainScreen.show(true, true);
   }
}