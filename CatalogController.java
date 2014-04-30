import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.lang.Integer;

public class CatalogController extends Controller {
	private static int itemCounter = 0;

	public CatalogController() {

	}

	public static void setCounter(int count) {
		itemCounter = count;
	}
	private static void incCounter() {
		itemCounter = itemCounter + 1;
	}

	public static void modifyItem(int id, String field, String newData) {
		CatalogDatabase.modify(id, field, newData);
	}

	public static void orderMore(int id, int amount) {
		CatalogDatabase.changeOrder(id, amount);
	}

	public static boolean placeReserve(int id, int mid) {
		if(getReserve(id) == 0) {
			return CatalogDatabase.placeReserve(id, mid);	
		}
		else {
			return false;
		}
	}

	public static int getReserve(int id) {
		return CatalogDatabase.getReserve(id);
	}

	public static void placeCheck(int id, int mid) {
		CatalogDatabase.placeCheck(id, mid);
	}

	public static int getCheck(int id) {
		return CatalogDatabase.getCheck(id);
	}

	public static void create(String name, String author, String genre, String publisher, 
		int isbn, int date) {

		incCounter();
		CatalogDatabase.add(new Book(name, itemCounter, 0, 0, 0, author, genre, publisher, isbn, date));
	}

	public static void createAudio(String name, String artist, String genre, String composer,
		int time, int date) {

		incCounter();
		CatalogDatabase.add(new Audio(name, itemCounter, 0, 0, 0, artist, genre, composer, time, date));
	}

	public static void createMagazine(String name, int datePub, int issue, String publisher, String topic) {

		incCounter();
		CatalogDatabase.add(new Magazine(name, itemCounter, 0, 0, 0, datePub, issue, publisher, topic));
	}

	public static void createJournal(String name, int datePub, int issue, String publisher,
		String topic, int issn) {

		incCounter();
		CatalogDatabase.add(new Journal(name, itemCounter, 0, 0, 0, datePub, issue, publisher, topic, issn));
	}

	public static void createNewspaper(String name, int datePub, int issue, String publisher, String topic) {

		incCounter();
		CatalogDatabase.add(new Newspaper(name, itemCounter, 0, 0, 0, datePub, issue, publisher, topic));
	}

	public static void createVideo(String name, int length, int date) {

		incCounter();
		CatalogDatabase.add(new Video(name, itemCounter, 0, 0, 0, length, date));
	}

	public static boolean remove(int id) {
		return CatalogDatabase.remove(id);
	}

	public static void retrieveInfo(int id) {

	}

	public static String catalogDump() {
		return CatalogDatabase.dump();
	}

	public static String search(String param) {
      
      String value = CatalogDatabase.find(param);
      return value;
	}
}