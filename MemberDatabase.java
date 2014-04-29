import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.String;
import java.text.Format;
import java.lang.Integer;
import java.lang.Double;
import java.lang.Boolean;

public class MemberDatabase {
	private ArrayList<Account> members = new ArrayList<Account>;

	private void readStart(final File folder) {
    	File file = new File();
    	String header;
   	
    	for(final File fileEntry : folder.listFiles()) {
        	file = File((fileEntry.getName() + ".txt"));
        	try {
            	Scanner sc = new Scanner(file);
            	header = sc.nextLine();
            	if(header.compareTo("employee") == 0) {
            		String name = sc.nextLine();
            		String phone = sc.nextLine();
            		String address = sc.nextLine();
            		int accountID = Integer.parseInt(sc.nextLine());
            		String accountPassword = sc.nextLine();
            		boolean priv = Boolean.parseBoolean(sc.nextLine());

            		members.add(new Employee(name, phone, address, accountID, accountPassword, priv));
            	}
            	else if(header.compareTo("member") == 0) {
            		String name = sc.nextLine();
            		String phone = sc.nextLine();
            		String address = sc.nextLine();
            		int accountID = Integer.parseInt(sc.nextLine());
            		String accountPassword = sc.nextLine();
            		double fee = Double.parseDouble(sc.nextLine());

            		members.add(new Member(name, phone, address, accountID, accountPassword, fee));
            	}
            	else {
            		System.out.print("Malformed account");
            	}
            }
            catch (FileNotFoundException e) {
            	e.printStackTrace();
        	}
    	}
    }

	private void writeToFile() {
   	
	}

    private void add(Account in) {
        members.add(in);
    }

   public void remove(int id) {
    	Iterator it = members.iterator();
    	int i = 0;
    	while(it.hasNext()) {
        	if(it.next().getAccountID() == id) {
            	members.remove(i);
        	}
        	else {
            	i++;
        	}
    	}
	}

   public void modify(int id) {

   }
}