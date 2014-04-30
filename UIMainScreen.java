import java.util.Scanner;

public class UIMainScreen extends UserInterface {
   private static final String notLogged = "\n\nOptions:\n1) Log in\n2) Register\n3) Navigate Catalog\n4) Shut down\n";
   private static final String logged = "Options:\n1) Navigate Catalog\n2) Reserve Computer Time\n" + 
   	"3) Reserve an Item\n4) Recall an Item\n5) Manage Account\n6) Shut down\n";
   private static final String adminS = "Options:\n1) Navigate Catalog\n2) Check Out\n3) Check In\n" +
   	"4) Catalog Report\n5) Order Inventory\n6) Process Fee\n7) Add Item\n8) Remove Item\n" +
   	"9) Modify Item\n10) Query Sister Libraries\n11) Member Report\n12) Modify Account\n13) Shut down\n";

   public UIMainScreen() {
   
   }
   public static void show(boolean loggedIn, boolean admin) {
      while(true) {
         boolean pass = false;
         int selection = 0;
         if(!loggedIn) {
            System.out.println(notLogged);
            Scanner sc = new Scanner(System.in);
            while(!pass) {
               selection = sc.nextInt();
               if(selection > 0 && selection < 5) {
                  pass = true;
               }
            }
            execute(selection, loggedIn, admin);
         }
         else if(loggedIn && !admin) {
            System.out.println(logged);
            Scanner sc = new Scanner(System.in);
            while(!pass) {
               selection = sc.nextInt();
               if(selection > 0 || selection < 6) {
                  pass = true;
               }
            }
            execute(selection, loggedIn, admin);
         }
         else if(loggedIn && admin) {
            System.out.println(adminS);
            Scanner sc = new Scanner(System.in);
            while(!pass) {
               selection = sc.nextInt();
               if(selection > 0 || selection < 14) {
                  pass = true;
               }
            }
            execute(selection, loggedIn, admin);
         }
         else {
            System.out.println("Error with login status.");
         }
      }
   }
   public static void execute(int input, boolean loggedIn, boolean admin) {
   	if(!loggedIn) {
         switch(input) {
            case 1:  UILogIn.show(loggedIn, admin);
               break;
            case 2:  UIRegister.show(loggedIn, admin);
               break;
            case 3: UINavigateCatalog.show(loggedIn, admin);
               break;
            case 4:
               MemberDatabase.writeToFile();
               TransactionDatabase.writeToFile();
               CatalogDatabase.writeToFile();
               System.exit(0);
            default: UIMainScreen.show(loggedIn, admin);
               break;
         }
      }
      else if(loggedIn && !admin) {
         switch(input) {
            case 1:  UINavigateCatalog.show(loggedIn, admin);
               break;
            case 2: UIReserveComp.show(loggedIn, admin);
               break;
            case 3: UIReserveItem.show(loggedIn, admin);
               break;
            case 4: UIRecallItem.show(loggedIn, admin);
               break;
            case 5: UIModifyAccount.show(loggedIn, admin);
               break;
            case 6:
               MemberDatabase.writeToFile();
               TransactionDatabase.writeToFile();
               CatalogDatabase.writeToFile();
               System.exit(0);
            default: UIMainScreen.show(loggedIn, admin);
               break;
         }
      }
      else if(loggedIn && admin) {
         switch(input) {
            case 1: UINavigateCatalog.show(loggedIn, admin);
               break;
            case 2: UICheckOut.show(loggedIn, admin);
               break;
            case 3: UICheckIn.show(loggedIn, admin);
               break;
            case 4: UICatalogReport.show(loggedIn, admin);
               break;
            case 5: UIOrderInventory.show(loggedIn, admin);
               break;
            case 6: UIPayFee.show(loggedIn, admin);
               break;
            case 7: UIAddItem.show(loggedIn, admin);
               break;
            case 8: UIRemoveItem.show(loggedIn, admin);
               break;
            case 9: UIModifyItem.show(loggedIn, admin);
               break;
            case 10: UIQuerySister.show(loggedIn, admin);
               break;
            case 11: UIMemberReport.show(loggedIn, admin);
               break;
            case 12: UIModifyAccount.show(loggedIn, admin);
               UIMainScreen.show(true, true);
               break;
            case 13:
               MemberDatabase.writeToFile();
               TransactionDatabase.writeToFile();
               CatalogDatabase.writeToFile();
               System.exit(0);
            default: UIMainScreen.show(loggedIn, admin);
               break;
         }
      }
      else {
         System.out.println("Error with login status.");
      }
   }
}