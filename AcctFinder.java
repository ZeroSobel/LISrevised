import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.lang.Integer;

public class AcctFinder extends Controller {
	private static int acctCounter = 0;

	public AcctFinder() {

	}

	public static void setCounter(int count) {
		acctCounter = count;
	}

	public static void modifyMember(int id, String field, String newData) {
		MemberDatabase.modify(id, field, newData);
	}

	public static void create(String name, String phone, String address, 
		String accountPassword, boolean priv) {

		MemberDatabase.add(new Employee(name, phone, address, acctCounter, accountPassword, priv));
		acctCounter++;
	}

	public static void create(String name, String phone, String address, 
		String accountPassword) {

		MemberDatabase.add(new Member(name, phone, address, acctCounter, accountPassword, 0.0));
		acctCounter++;
	}


	public static void retrieveInfo(int id) {

	}

	public static void remove(int id) {
		MemberDatabase.remove(id);
	}

	public static String search(String field, String param) {
      String value = "";
      return value;
	}
}