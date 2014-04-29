import java.io.File;

public class LIS {
	public static void main(String[] args) {
		TransactionDatabase.readStart(new File("Transactions"));
      CatalogDatabase.readStart(new File("Catalog"));
      MemberDatabase.readStart(new File("Accounts"));
      System.out.println("hold");
	}
}