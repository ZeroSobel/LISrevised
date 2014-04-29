import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.io.PrintWriter;
import java.lang.String;
import java.text.Format;
import java.lang.Integer;
import java.lang.Double;
import java.lang.Boolean;


public class MemberDatabase extends Database {
	private static ArrayList<Account> members = new ArrayList<Account>();

	public static void readStart(final File folder) {
    	String header;
    	int highestAcct = 0;
   	
    	for(final File fileEntry : folder.listFiles()) {
        	File file = new File("Accounts/" + fileEntry.getName());
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
            		if(accountID > highestAcct) {
            			highestAcct = accountID;
            		}
            	}
            	else if(header.compareTo("member") == 0) {
            		String name = sc.nextLine();
            		String phone = sc.nextLine();
            		String address = sc.nextLine();
            		int accountID = Integer.parseInt(sc.nextLine());
            		String accountPassword = sc.nextLine();
            		double fee = Double.parseDouble(sc.nextLine());

            		members.add(new Member(name, phone, address, accountID, accountPassword, fee));
            		if(accountID > highestAcct) {
            			highestAcct = accountID;
            		}
            	}
            	else {
            		System.out.println("Malformed account");
            	}
            }
            catch (FileNotFoundException e) {
            	e.printStackTrace();
        	}
    	}
    	AcctFinder.setCounter(highestAcct);
    }

	public static void writeToFile() {
   		for(Account account : members) {
        try {
          PrintWriter writer = new PrintWriter(Integer.toString(account.getAccountID()), "UTF-8");
          if(account instanceof Employee) {
            Employee eAccount = (Employee) account;
            writer.println("employee");
            writer.println(eAccount.getName());
            writer.println(eAccount.getPhone());
            writer.println(eAccount.getAddress());
            writer.println(eAccount.getAccountPassword());
            writer.println(Boolean.toString(eAccount.getPriv()));
            writer.close();
          }
          else if(account instanceof Member) {
            Member mAccount = (Member) account;
            writer.println("member");
            writer.println(mAccount.getName());
            writer.println(mAccount.getPhone());
            writer.println(mAccount.getAddress());
            writer.println(mAccount.getAccountPassword());
            writer.println(Double.toString(mAccount.getFee()));
            writer.close();
          }
          else {
            System.out.println("Error writing account due to type.");
          }
          } catch (FileNotFoundException | UnsupportedEncodingException e) {
            System.out.println(e.getMessage());
          }
   		}
	}

    public static void add(Account in) {
        members.add(in);
    }

    public static void remove(int id) {
    	Iterator it = members.iterator();
    	int i = 0;
    	while(it.hasNext()) {
        	if(((Account)it.next()).getAccountID() == id) {
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
    		if(((Account)it.next()).getAccountID() == id) {
    			if(members.get(i) instanceof Employee) {
    				if(field.compareTo("name") == 0) {
    					((Employee)members.get(i)).setName(newData);
    				}
    				else if(field.compareTo("phone") == 0) {
    					((Employee)members.get(i)).setPhone(newData);
    				}
    				else if(field.compareTo("address") == 0) {
    					((Employee)members.get(i)).setAddress(newData);
    				}
    				else if(field.compareTo("accountPassword") == 0) {
    					((Employee)members.get(i)).setAccountPassword(newData);
    				}
    				else if(field.compareTo("priv") == 0) {
    					boolean newBool = Boolean.parseBoolean(newData);
    					((Employee)members.get(i)).setPriv(newBool);
    				}
    				else {
    					System.out.println("Error parsing field.");
    				}
    			}
    			else if(members.get(i) instanceof Member) {
    				if(field.compareTo("name") == 0) {
    					((Member)members.get(i)).setName(newData);
    				}
    				else if(field.compareTo("phone") == 0) {
    					((Member)members.get(i)).setPhone(newData);
    				}
    				else if(field.compareTo("address") == 0) {
    					((Member)members.get(i)).setAddress(newData);
    				}
    				else if(field.compareTo("accountPassowrd") == 0) {
    					((Member)members.get(i)).setAccountPassword(newData);
    				}
    				else if(field.compareTo("fee") == 0) {
    					Double newDo = Double.parseDouble(newData);
    					((Member)members.get(i)).setFee(newDo);
    				}
    				else {
    					System.out.println("Error parsing field.");
    				}
    			}
    			else {
    				System.out.println("Error parsing account type.");
    			}
    		}
    		else {
    			i++;
    		}
    	}
	}
}