import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.lang.Integer;
import java.lang.Double;

public class TransactionController extends Controller {
	private static int transCounter = 0;

	public TransactionController() {

	}

	public static void setCounter(int count) {
		transCounter = count;
	}

	private static void incCounter() {
		transCounter = transCounter + 1;
	}

	public static void modifyTrans(int id, String field, String newData) {
		TransactionDatabase.modify(id, field, newData);
	}

	// Create and add a Rental
	public static void create(int memberIDIn, int dueDateIn, int returnDateIn, int itemIDIn, double feeIn) {

		incCounter();
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		Date date = new Date();
		int dateIn = Integer.parseInt(dateFormat.format(date));

		TransactionDatabase.add(new Rental(transCounter, memberIDIn, dateIn, dueDateIn, 
			returnDateIn, itemIDIn, feeIn));
	}

	public static void closeRental(int iid) {
        Rental holder = null;
		holder = (Rental) TransactionController.retrieveUnreturnedByID(iid);
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		Date date = new Date();
		int dateIn = Integer.parseInt(dateFormat.format(date));
		TransactionController.modifyTrans(holder.getID(), "returnDate",  Integer.toString(dateIn));
		CatalogController.placeReserve(holder.getID(), 0);
		int dateDifference = holder.getReturnDate() - holder.getDueDate();
		if(dateDifference > 0) {
        	double fee = dateDifference * .5;
        	// Assign fee to transaction
			TransactionController.modifyTrans(holder.getID(), "fee", Double.toString(fee));
        	// Assign fee to Member
        	AcctFinder.modifyMember(holder.getMemberID(), "fee", Double.toString(fee));
		}
	}

	public static void recallRental(int iid) {
		Rental holder = null;
		holder = (Rental) TransactionController.retrieveUnreturnedByID(iid);
			
		// get the date of a week into the future
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.DATE, 7);
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		String outDate = dateFormat.format(c.getTime());

		TransactionController.modifyTrans(holder.getID(), "dueDate", outDate);
	}

	// Create and add a Fee
	public static void create(int memberIDIn, double feeIn) {

		incCounter();
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		Date date = new Date();
		int dateIn = Integer.parseInt(dateFormat.format(date));
      
      Calendar c = Calendar.getInstance();
      c.setTime(new Date());
      DateFormat df = new SimpleDateFormat("yyyymmdd");
      String outDate = df.format(c.getTime());
      dateIn = Integer.parseInt(outDate);
      
		TransactionDatabase.add(new Fee(transCounter, memberIDIn, dateIn, feeIn));
	}

	// Create and add a ReserveCompTime
	public static void create(int idIn, int memberIDIn, int compIDIn) {

		incCounter();
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		Date date = new Date();
		int dateIn = Integer.parseInt(dateFormat.format(date));
		TransactionDatabase.add(new ReserveCompTime(transCounter, memberIDIn, dateIn, compIDIn));
	}

	public static boolean remove(int id) {
		return TransactionDatabase.remove(id);
	}

	public static void retrieveInfo(int id) {

	}

	public static String retrieveInfoByItem(int id) {
      return "";
	}

	public static Transaction retrieveUnreturnedByID(int id) {
		return TransactionDatabase.findUnreturnedByID(id);
	}

	public static String search(String field, String param) {
      String value = "";
      return value;
	}

	public static int countTrans() {
		int output = TransactionDatabase.getSize();
      return output;
	}
}