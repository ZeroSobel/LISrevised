import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Writer;
import java.lang.String;
import java.text.Format;
import java.lang.Integer;
import java.lang.Double;
import java.lang.Boolean;

public class TransactionDatabase {
	private static ArrayList<Transaction> transList = new ArrayList<Transaction>();

	private static void readStart(final File folder) {
    	File file = new File();
    	String header;
    	int highestTrans = 0;
   	
    	for(final File fileEntry : folder.listFiles()) {
        	file = File((fileEntry.getName() + ".txt"));
        	try {
            	Scanner sc = new Scanner(file);
            	header = sc.nextLine();
            	if(header.compareTo("rental") == 0) {
            		int tid = Integer.parseInt(sc.nextLine());
            		int mid = Integer.parseInt(sc.nextLine());
            		int date = Integer.parseInt(sc.nextLine());
            		int dueDate = Integer.parseInt(sc.nextLine());
            		int returnDate = Integer.parseInt(sc.nextLine());
            		int iid = Integer.parseInt(sc.nextLine());
            		double fee = Double.parseDouble(sc.nextLine());

            		transList.add(new Rental(tid, mid, date, dueDate, returnDate, iid, fee));
            		if(tid > highestTrans) {
            			highestTrans = tid;
            		}
            	}
            	else if(header.compareTo("fee") == 0) {
            		int tid = Integer.parseInt(sc.nextLine());
            		int mid = Integer.parseInt(sc.nextLine());
            		int date = Integer.parseInt(sc.nextLine());
            		double fee = Double.parseDouble(sc.nextLine());

            		transList.add(new Fee(tid, mid, date, fee));
            		if(tid > highestTrans) {
            			highestTrans = tid;
            		}
            	}
            	else if(header.compareTo("reservecomp") == 0) {
            		int tid = Integer.parseInt(sc.nextLine());
            		int mid = Integer.parseInt(sc.nextLine());
            		int date = Integer.parseInt(sc.nextLine());
            		int cid = Integer.parseInt(sc.nextLine());

            		transList.add(new ReserveCompTime(tid, mid, date, cid));
            		if(tid > highestTrans) {
            			highestTrans = tid;
            		}
            	}
            	else {
            		System.out.println("Unknown transaction type");
            	}
            }
            catch (FileNotFoundException e) {
            	e.printStackTrace();
            }
        }
        TransactionConroller.setCounter(highestTrans);
    }


    private static void writeToFile() {
   		for(Transaction trans : transList) {
   			PrintWriter writer = new PrintWriter(Integer.toString(trans.getID()), "UTF-8");
   			if(trans instanceof Rental) {
   				Rental rTrans = (Rental) trans;
   				writer.println(rTrans.getID());
   				writer.println(rTrans.getMemberID());
   				writer.println(rTrans.getDate());
   				writer.println(rTrans.getDueDate());
   				writer.println(rTrans.getReturnDate());
   				writer.println(rTrans.getItemID());
   				writer.println(rTrans.getFee());
   				writer.close();
   			}
   			else if(trans instanceof Fee) {
   				Fee fTrans = (Fee) trans;
   				writer.println(fTrans.getID());
   				writer.println(fTrans.getMemberID());
   				writer.println(fTrans.getDate());
   				writer.println(fTrans.getFee());
   				writer.close();
   			}
   			else if(trans instanceof ReserveCompTime) {
   				ReserveCompTime rTrans = (ReserveCompTime) trans;
   				writer.println(rTrans.getID());
   				writer.println(rTrans.getMemberID());
   				writer.println(rTrans.getDate());
   				writer.println(rTrans.getCompID());
   				writer.close();
   			}
   			else {
   				System.out.println("Error writing transaction due to type.");
   			}
   		}
	}

    private static void add(Transaction in) {
        transList.add(in);
    }

   public static void remove(int id) {
    	Iterator it = transList.iterator();
    	int i = 0;
    	while(it.hasNext()) {
        	if(it.next().getID() == id) {
            	transList.remove(i);
            	break;
        	}
        	else {
            	i++;
        	}
    	}
	}

	public static void modify(int id, String field, String newData) {
		Iterator it = transList.iterator();
    	int i = 0;
    	while(it.hasNext()) {
    		if(it.next().getID() == id) {
    			if(transList.get(i) instanceof Rental) {
    				if(field.compareTo("memberID") == 0) {
    					int newInt = Integer.parseInt(newData);
    					transList.get(i).setMemberID(newInt);
    				}
    				else if(field.compareTo("date") == 0) {
    					int newInt = Integer.parseInt(newData);
    					transList.get(i).setDate(newInt);
    				}
    				else if(field.compareTo("dueDate") == 0) {
    					int newInt = Integer.parseInt(newData);
    					transList.get(i).setDueDate(newInt);
    				}
    				else if(field.compareTo("returnDate") == 0) {
    					int newInt = Integer.parseInt(newData);
    					transList.get(i).setReturnDate(newInt);
    				}
    				else if(field.compareTo("itemID") == 0) {
    					int newInt = Integer.parseInt(newData);
    					transList.get(i).setItemID(newInt);
    				}
    				else if(field.compareTo("fee") == 0) {
    					double newDouble = Double.parseDouble(newData);
    					transList.get(i).setFee(newDouble);
    				}
    				else {
    					System.out.println("Error parsing field.");
    				}
    			}
    			else if(transList.get(i) instanceof Fee) {
    				if(field.compareTo("memberID") == 0) {
    					int newInt = Integer.parseInt(newData);
    					transList.get(i).setMemberID(newInt);
    				}
    				else if(field.compareTo("date") == 0) {
    					int newInt = Integer.parseInt(newData);
    					transList.get(i).setDate(newInt);
    				}
    				else if(field.compareTo("fee") == 0) {
    					double newDouble = Double.parseDouble(newData);
    					transList.get(i).setFee(newDouble);
    				}
    				else {
    					System.out.println("Error parsing field.");
    				}
    			}
    			else if(transList.get(i) instanceof ReserveCompTime) {
    				if(field.compareTo("memberID") == 0) {
    					int newInt = Integer.parseInt(newData);
    					transList.get(i).setMemberID(newInt);
    				}
    				else if(field.compareTo("date") == 0) {
    					int newInt = Integer.parseInt(newData);
    					transList.get(i).setDate(newInt);
    				}
    				else if(field.compareTo("compID") == 0) {
    					int newInt = Integer.parseInt(newData);
    					transList.get(i).setCompID(newInt);
    				}
    				else {
    					System.out.println("Error parsing field.");
    				}
    			}
    			else {
    				System.out.println("Error identifying object type.");
    			}
    		}
    		else {
    			i++;
    		}
    	}
	}
}