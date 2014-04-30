import java.io.File;

public class LIS {
	public static void main(String[] args) {
		TransactionDatabase.readStart(new File("Transactions"));
      System.out.println("T complete");
      CatalogDatabase.readStart(new File("Catalog"));
      System.out.println("C complete");
      MemberDatabase.readStart(new File("Accounts"));
      System.out.println("M complete");
      UIMainScreen.show(false, false);
	}
}