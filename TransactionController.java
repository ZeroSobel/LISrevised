import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.lang.Integer;

public class TransactionController extends Controller {
	private static int transCounter = 0;

	public TransactionController() {

	}

	public static void setCounter(int count) {
		transCounter = count;
	}

	public static void modifyTrans(int id, String field, String newData) {
		TransactionDatabase.modify(id, field, newData);
	}

	// Create and add a Rental
	public static void create(int memberIDIn, int dueDateIn, int returnDateIn, 
		int itemIDIn, double feeIn) {

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		int dateIn = Integer.parseInt(dateFormat.format(date));

		TransactionDatabase.add(new Rental(transCounter, memberIDIn, dateIn, dueDateIn, 
			returnDateIn, itemIDIn, feeIn));
		transCounter++;
	}

	// Create and add a Fee
	public static void create(int memberIDIn, double feeIn) {

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		int dateIn = Integer.parseInt(dateFormat.format(date));
		TransactionDatabase.add(new Fee(transCounter, memberIDIn, dateIn, feeIn));
		transCounter++;
	}

	// Create and add a ReserveCompTime
	public static void create(int idIn, int memberIDIn, int compIDI) {

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		int dateIn = Integer.parseInt(dateFormat.format(date));
		TransactionDatabase.add(new ReserveCompTime(transCounter, memberIDIn, dateIn, compIDIn));
		transCounter++;
	}

	public static void remove(int id) {
		TransactionDatabase.remove(id);
	}

	public static void retrieveInfo(int id) {

	}

	public static String search(String field, String param) {

	}
}