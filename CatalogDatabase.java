//import java.util.ArrayList;
//import java.util.Scanner;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.String;
import java.text.Format;
import java.lang.Integer;

public class CatalogDatabase {
   private ArrayList<Item> catalog = new ArrayList<Item>();
   
   private void readStart(final File folder) {
      File file = new File();
      String format;
   	
      for(final File fileEntry : folder.listFiles()) {
         file = File((fileEntry.getName() + ".txt"));
         try {
            Scanner sc = new Scanner(file);
            format = sc.nextLine();
            if (format.compareTo("book") == 0) {
            	// Extracting book's data fields
               String name = sc.nextLine();
               int id = Integer.parseInt(sc.nextLine());
               String author = sc.nextLine();
               String genre = sc.nextLine();
               String publisher = sc.nextLine();
               int isbn = Integer.parseInt(sc.nextLine());
               String stringDate = sc.nextLine();
               while(stringDate.length() < 8) {
                  stringDate = stringDate + "0";
               }
               int date = Integer.parseInt(stringDate);
            	// Add new item to database
               catalog.add(new Book(name, id, author, genre, publisher, isbn, date));
            }
            else if(format.compareTo("audio") == 0) {
            	// Extracting audio datafields
               String name = sc.nextLine();
               int id = Integer.parseInt(sc.nextLine());
               String artist = sc.nextLine();
               String genre = sc.nextLine();
               String composer = sc.nextLine();
               int time = Integer.parseInt(sc.nextLine());
               String stringDate = sc.nextLine();
               while(stringDate.length() < 8) {
                  stringDate = stringDate + "0";
               }
               int date = Integer.parseInt(stringDate);
            	// Add new item to database
               catalog.add(new Audio(format, name, id, artist, genre, composer, time, date));
            }
            else if(format.compareTo("newspaper") == 0) {
               String name = sc.nextLine();
               int id = Integer.parseInt(sc.nextLine());
               while(stringDate.length() < 8) {
                  stringDate = stringDate + "0";
               }
               int datePub = Integer.parseInt(stringDate);
               int issue = Integer.parseInt(sc.nextLine());
               String publisher = sc.nextLine();
               String topic = sc.nextLine();
            	// Add new item
               catalog.add(new Newspaper(name, id, datePub, issue, publisher, topic));
            }
            else if(format.compareTo("journal") == 0) {
               String name = sc.nextLine();
               int id = Integer.parseInt(sc.nextLine());
               while(stringDate.length() < 8) {
                  stringDate = stringDate + "0";
               }
               int datePub = Integer.parseInt(stringDate);
               int issue = Integer.parseInt(sc.nextLine());
               String publisher = sc.nextLine();
               String topic = sc.nextLine();
               int issn = Integer.parseInt(sc.nextLine());
            	// Add new
               catalog.add(new Journal(name, id, datePub, issue, publisher, topic, issn));
            }
            else if(format.compareTo("magazine") == 0) {
               String name = sc.nextLine();
               int id = Integer.parseInt(sc.nextLine());
               while(stringDate.length() < 8) {
                  stringDate = stringDate + "0";
               }
               int datePub = Integer.parseInt(stringDate);
               int issue = Integer.parseInt(sc.nextLine());
               String publisher = sc.nextLine();
               String topic = sc.nextLine();
            	// Add new item
               catalog.add(new Magazine(name, id, datePub, issue, publisher, topic));
            }
            else if(format.compareTo("video") == 0) {
               String name = sc.nextLine();
               int id = Integer.parseInt(sc.nextLine());
               int length = Integer.parseInt(sc.nextLine());
               String stringDate = sc.nextLine();
               while(stringDate.length() < 8) {
                  stringDate = stringDate + "0";
               }
               int date = Integer.parseInt(stringDate);
            	// Add new item
               catalog.add(new Video(name, id, length, date));
            }
            else {
               System.out.print("Unrecognized item type");
            }
         }
         catch (FileNotFoundException e) {
            e.printStackTrace();
         }
      }
   	
   	
   }

   private void writeToFile() {
   	
   }

   private void add(Item itemIn) {
      catalog.add(itemIn);
   }

   public void remove(int id) {
      Iterator it = catalog.iterator();
      int i = 0;
      while(it.hasNext()) {
         if(it.next().getID() == id) {
            catalog.remove(i);
         }
         else {
            i++;
         }
      }
   }

   public void modify(int id) {

   }
}