public class UICatalogReport extends UserInterface {
   public static final String intro = "Catalog: \n\n";
   
   public static void show(boolean loggedIn, boolean admin) {
      System.out.print(intro);
      generateReport();
      UIMainScreen.show(loggedIn, admin);
   }
   public static void generateReport() {
      System.out.println(CatalogController.catalogDump());
      
   }
}