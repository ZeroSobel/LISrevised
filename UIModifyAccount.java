import java.util.Scanner;

public class UIModifyAccount extends UserInterface {
   private static final String adminString = "Input ID of account you would like to modify.";
   private static final String memberString = 
   		"Input field you would like to modify." +
    	" Options are \"name\", \"phone\", \"address\", and \"password\"." +
    	"\nEnter \"goback\" to return to the main menu.";
    private static final String newValue = "Please enter new value: ";
      
   public UIModifyAccount() {
   
   }
   
   public static void show(boolean loggedIn, boolean admin) {
   		Scanner sc = new Scanner(System.in);
   		String input = "";
   		// User editing themself
   		if(loggedIn && !admin) {
   			System.out.println(memberString);
   				input = sc.nextLine();
   				if(input.compareToIgnoreCase("name") == 0) {
   					int me = AcctFinder.getCurrentAcct().getAccountID();
   					System.out.println(newValue);
   					input = sc.nextLine();
   					AcctFinder.modifyMember(me, "name", input);
   				}
   				else if(input.compareToIgnoreCase("phone") == 0) {
   					int me = AcctFinder.getCurrentAcct().getAccountID();
   					System.out.println(newValue);
   					input = sc.nextLine();
   					AcctFinder.modifyMember(me, "phone", input);
   				}
   				else if(input.compareToIgnoreCase("address") == 0) {
   					int me = AcctFinder.getCurrentAcct().getAccountID();
   					System.out.println(newValue);
   					input = sc.nextLine();
   					AcctFinder.modifyMember(me, "address", input);
   				}
   				else if(input.compareToIgnoreCase("password") == 0) {
   					int me = AcctFinder.getCurrentAcct().getAccountID();
   					System.out.println(newValue);
   					input = sc.nextLine();
   					AcctFinder.modifyMember(me, "password", input);
   				}
   				else if(input.compareToIgnoreCase("goback") == 0) {
   					UIMainScreen.show(loggedIn, admin);
   				}
   				else {
   					System.out.println("Not a valid input.");
   				}
   		}
   		// Employee editing a user
   		else if(loggedIn && admin) {
   			System.out.println(adminString);
   			int toMod = sc.nextInt();
            input = sc.nextLine();
   			Account holder = AcctFinder.retrieveInfo(toMod);
   			if(holder == null) {
   				System.out.println("No such account.");
   				UIMainScreen.show(loggedIn, admin);
   			}
   			else {
   				System.out.println(memberString);
   					input = sc.nextLine();
   					if(input.compareToIgnoreCase("name") == 0) {
   						System.out.println(newValue);
   						input = sc.nextLine();
   						AcctFinder.modifyMember(toMod, "name", input);
   					}
   					else if(input.compareToIgnoreCase("phone") == 0) {
   						System.out.println(newValue);
   						input = sc.nextLine();
   						AcctFinder.modifyMember(toMod, "phone", input);
   					}
   					else if(input.compareToIgnoreCase("address") == 0) {
   						System.out.println(newValue);
   						input = sc.nextLine();
   						AcctFinder.modifyMember(toMod, "address", input);
   					}
   					else if(input.compareToIgnoreCase("password") == 0) {
   						System.out.println(newValue);
   						input = sc.nextLine();
   						AcctFinder.modifyMember(toMod, "password", input);
   					}
   					else if(input.compareToIgnoreCase("goback") == 0) {
                     UIMainScreen.show(loggedIn, admin);
   					}
   					else {
   						System.out.println("Not a valid input.");
   					}
   			}
   		}
   		else {
   			System.out.println("Boolean error");
   		}
   }

   public static void execute() {

   }
}