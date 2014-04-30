import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.lang.Integer;

public class AcctFinder extends Controller {
	private static int acctCounter = 0;
	private static Account currentAcct;

	public AcctFinder() {

	}

	public static void setCounter(int count) {
		acctCounter = count;
	}
	private static void incCounter() {
		acctCounter = acctCounter + 1;
	}

	// returns 0 if fail, 1 for member, 2 for employee
	public static int tryLogin(int id, String password) {
		int success = 0;
		boolean admin = false;
		String realPass = MemberDatabase.getPassByID(id);
		if(realPass.compareTo(password) == 0) {			
			if(MemberDatabase.find(id) instanceof Employee) {
				success = 2;
			}
			else {
				success = 1;
			}
			setCurrentAcct(MemberDatabase.find(id));
		}
		return success;
	}

	public static void setCurrentAcct(Account in) {
		currentAcct = in;
	}

	public static Account getCurrentAcct() {
		return currentAcct;
	}

	public static void modifyMember(int id, String field, String newData) {
		MemberDatabase.modify(id, field, newData);
	}

	public static void create(String name, String phone, String address, 
		String accountPassword, boolean priv) {

		incCounter();
		MemberDatabase.add(new Employee(name, phone, address, acctCounter, accountPassword, priv));
	}

	public static void create(String name, String phone, String address, 
		String accountPassword) {

		incCounter();
		MemberDatabase.add(new Member(name, phone, address, acctCounter, accountPassword, 0.0));
	}


	public static Account retrieveInfo(int id) {
      Account output = MemberDatabase.find(id);
		return output;
	}

	public static boolean remove(int id) {
		return MemberDatabase.remove(id);
	}

	public static String search(String field, String param) {
      String value = "";
      return value;
	}

}