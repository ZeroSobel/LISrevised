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

	public static void modifyItem(int id, String field, String newData) {
		CatalogDatabase.modify(id, field, newData);
	}

	public static void create(String name, String author, String genre, String publisher, 
		int isbn, int date) {

		CatalogDatabase.add(new Book(name, itemCounter, author, genre, publisher, isbn, date));
		itemCounter++;
	}

	public static void createAudio(String name, String artist, String genre, String composer,
		int time, int date) {

		CatalogDatabase.add(new Audio(name, itemCounter, artist, genre, composer, time, date));
		itemCounter++;
	}

	public static void createMagazine(String name, int datePub, int issue, String publisher, String topic) {

		CatalogDatabase.add(new Magazine(name, itemCounter, datePub, issue, publisher, topic));
		itemCounter++;
	}

	public static void createJournal(String name, int datePub, int issue, String publisher,
		String topic, int issn) {

		CatalogDatabase.add(new Journal(name, itemCounter, datePub, issue, publisher, topic, issn));
		itemCounter++;
	}

	public static void createNewspaper(String name, int datePub, int issue, String publisher, String topic) {

		CatalogDatabase.add(new Newspaper(name, itemCounter, datePub, issue, publisher, topic));
		itemCounter++;
	}

	public static void createVideo(String name, int length, int date) {

		CatalogDatabase.add(new Video(name, itemCounter, length, date));
		itemCounter++;
	}

	public static void remove(int id) {
		CatalogDatabase.remove(id);
	}

	public static void retrieveInfo(int id) {

	}

	public static String search(String field, String param) {
      String value = "";
      return value;
	}
}