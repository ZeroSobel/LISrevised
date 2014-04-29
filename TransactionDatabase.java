import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.String;
import java.text.Format;
import java.lang.Integer;
import java.lang.Double;
import java.lang.Boolean;

public class TransactionDatabase {
	private ArrayList<Transaction> transList = new ArrayList<Transaction>;

	private void readStart(final File folder) {
    	File file = new File();
    	String header;
   	
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
            	}
            	else if(header.compareTo("fee") == 0) {
            		int tid = Integer.parseInt(sc.nextLine());
            		int mid = Integer.parseInt(sc.nextLine());
            		int date = Integer.parseInt(sc.nextLine());
            		double fee = Double.parseDouble(sc.nextLine());

            		transList.add(new Fee(tid, mid, date, fee));
            	}
            	else if(header.compareTo("reservecomp") == 0) {
            		int tid = Integer.parseInt(sc.nextLine());
            		int mid = Integer.parseInt(sc.nextLine());
            		int date = Integer.parseInt(sc.nextLine());
            		int cid = Integer.parseInt(sc.nextLine());

            		transList.add(new ReserveCompTime(tid, mid, date, cid));
            	}
            	else {
            		System.out.print("Unknown transaction type");
            	}
            }
            catch (FileNotFoundException e) {
            	e.printStackTrace();
            }
        }
    }


    private void writeToFile() {
   	
	}

    private void add(Transaction in) {
        transList.add(in);
    }

   public void remove(int id) {
    	Iterator it = transList.iterator();
    	int i = 0;
    	while(it.hasNext()) {
        	if(it.next().getID() == id) {
            	transList.remove(i);
        	}
        	else {
            	i++;
        	}
    	}
	}

   public void modify(int id) {

   }
}