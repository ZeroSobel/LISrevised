import java.util.Scanner;

public class UIAddItem extends UserInterface {
   public static final String first = "What would you like to add? (book, audio, newspaper, journal, magazine, video)";
   
   public static void show(boolean loggedIn, boolean admin) {
      System.out.println(first);
      
      newItem(loggedIn, admin);
   }
   
   public static void newItem(boolean loggedIn, boolean admin) {
      Scanner sc = new Scanner(System.in);
      String type = sc.nextLine();
      if(type.compareTo("book") == 0) {
         System.out.print("Please entire the title: ");
         String title = sc.nextLine();
         System.out.print("\nPlease enter the author: ");
         String author = sc.nextLine();
         System.out.print("\nPlease enter the genre: ");
         String genre = sc.nextLine();
         System.out.print("\nPlease enter the publisher: ");
         String publisher = sc.nextLine();
         System.out.print("\nPlease enter the ISBN: ");
         String isbn = sc.nextLine();
         System.out.print("\nPlease enter the date of publish: ");
         String date = sc.nextLine();
         
         CatalogController.create(title, author, genre, publisher, Integer.parseInt(isbn), Integer.parseInt(date));
      }
      else if(type.compareToIgnoreCase("audio") == 0) {
         System.out.print("Please entire the title: ");
         String title = sc.nextLine();
         System.out.print("\nPlease enter the artist: ");
         String artist = sc.nextLine();
         System.out.print("\nPlease enter the genre: ");
         String genre = sc.nextLine();
         System.out.print("\nPlease enter the composer: ");
         String composer = sc.nextLine();
         System.out.print("\nPlease enter the duration (seconds): ");
         String time = sc.nextLine();
         System.out.print("\nPlease enter the date of publish: ");
         String date = sc.nextLine();
         
         CatalogController.createAudio(title, artist, genre, composer, Integer.parseInt(time), Integer.parseInt(date));
      }
      else if(type.compareToIgnoreCase("newspaper") == 0) {
         System.out.print("Please entire the title: ");
         String title = sc.nextLine();
         System.out.print("\nPlease enter the date of publish: ");
         String date = sc.nextLine();
         System.out.print("Please entire the issue: ");
         String issue = sc.nextLine();
         System.out.print("\nPlease enter the publisher: ");
         String publisher = sc.nextLine();
         System.out.print("\nPlease enter the topic: ");
         String topic = sc.nextLine();
         
         CatalogController.createNewspaper(title, Integer.parseInt(date), Integer.parseInt(issue), publisher, topic);
      }
      else if(type.compareToIgnoreCase("journal") == 0) {
         System.out.print("Please entire the title: ");
         String title = sc.nextLine();
         System.out.print("\nPlease enter the date of publish: ");
         String date = sc.nextLine();
         System.out.print("Please entire the issue: ");
         String issue = sc.nextLine();
         System.out.print("\nPlease enter the publisher: ");
         String publisher = sc.nextLine();
         System.out.print("\nPlease enter the tpoic: ");
         String topic = sc.nextLine();
         System.out.print("\nPlease enter the ISSN: ");
         String issn = sc.nextLine();
         
         CatalogController.createJournal(title, Integer.parseInt(date), Integer.parseInt(issue), publisher, topic, Integer.parseInt(issn));
      }
      else if(type.compareToIgnoreCase("magazine") == 0) {
         System.out.print("Please entire the title: ");
         String title = sc.nextLine();
         System.out.print("\nPlease enter the date of publish: ");
         String date = sc.nextLine();
         System.out.print("Please entire the issue: ");
         String issue = sc.nextLine();
         System.out.print("\nPlease enter the publisher: ");
         String publisher = sc.nextLine();
         System.out.print("\nPlease enter the tpoic: ");
         String topic = sc.nextLine();
         
         CatalogController.createMagazine(title, Integer.parseInt(date), Integer.parseInt(issue), publisher, topic);
      }
      else if(type.compareToIgnoreCase("video") == 0) {
         System.out.print("Please entire the title: ");
         String title = sc.nextLine();
         System.out.print("\nPlease enter the duration (minutes): ");
         String time = sc.nextLine();
         System.out.print("\nPlease enter the date of publish: ");
         String date = sc.nextLine();
         
         CatalogController.createVideo(title, Integer.parseInt(time), Integer.parseInt(date));
      }
      else {
         System.out.println("Invalid type.");
         
      }
      UIMainScreen.show(loggedIn, admin);
   }
}