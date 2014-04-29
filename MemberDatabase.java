import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.String;
import java.text.Format;
import java.lang.Integer;
import java.lang.Double;
import java.lang.Boolean;

public class MemberDatabase {
	private static ArrayList<Account> members = new ArrayList<Account>();

	private static void readStart(final File folder) {
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

	private static void writeToFile() {
   	
	}

    private static void add(Account in) {
        members.add(in);
    }

   public static void remove(int id) {
    	Iterator it = members.iterator();
    	int i = 0;
    	while(it.hasNext()) {
        	if(it.next().getAccountID() == id) {
            	members.remove(i);
            	break;
        	}
        	else {
            	i++;
        	}
    	}
	}

	public static void modify(int id, String field, String newData) {
   		Iterator it = members.iterator();
    	int i = 0;
    	while(it.hasNext()) {
    		if(it.next().getAccountID == id) {
    			if(members.get(i) instanceof Employee) {
    				if(field.compareTo("name") == 0) {
    					members.get(i).setName(newData);
    				}
    				else if(field.compareTo("phone") == 0) {
    					members.get(i).setPhone(newData);
    				}
    				else if(field.compareTo("address") == 0) {
    					members.get(i).setAddress(newData);
    				}
    				else if(field.compareTo("accountPassowrd") == 0) {
    					members.get(i).setAccountPassword(newData);
    				}
    				else if(field.compareTo("priv") == 0) {
    					boolean newBool = Boolean.parseBoolean(newData);
    					members.get(i).setPriv(newBool);
    				}
    				else {
    					System.out.print("Error parsing field.");
    				}
    			}
    			else if(members.get(i) instanceof Member) {
    				if(field.compareTo("name") == 0) {
    					members.get(i).setName(newData);
    				}
    				else if(field.compareTo("phone") == 0) {
    					members.get(i).setPhone(newData);
    				}
    				else if(field.compareTo("address") == 0) {
    					members.get(i).setAddress(newData);
    				}
    				else if(field.compareTo("accountPassowrd") == 0) {
    					members.get(i).setAccountPassword(newData);
    				}
    				else if(field.compareTo("fee") == 0) {
    					Double newDo = Double.parseDouble(newData);
    					members.get(i).setFee(newDo);
    				}
    				else {
    					System.out.print("Error parsing field.");
    				}
    			}
    			else {
    				System.out.print("Error parsing account type.");
    			}
    		}
    		else {
    			i++;
    		}
    	}
	}
}