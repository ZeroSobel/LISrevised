import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.io.PrintWriter;
import java.io.*;
import java.lang.String;
import java.text.Format;
import java.lang.Integer;

public class CatalogDatabase extends Database {
   private static ArrayList<Item> catalog = new ArrayList<Item>();
   
   public static void readStart(final File folder) {
      String format;
      int highestID = 0;
   	
      for(final File fileEntry : folder.listFiles()) {
         File file = new File("Catalog/" + fileEntry.getName());
         try {
            Scanner sc = new Scanner(file);
            format = sc.nextLine();
            if (format.compareTo("book") == 0) {
            	// Extracting book's data fields
               String name = sc.nextLine();
               int id = Integer.parseInt(sc.nextLine());
               int order = Integer.parseInt(sc.nextLine());
               int rid = Integer.parseInt(sc.nextLine());
               int cid = Integer.parseInt(sc.nextLine());
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
               catalog.add(new Book(name, id, order, rid, cid, author, genre, publisher, isbn, date));
               if(id > highestID) {
                  highestID = id;
               }
            }
            else if(format.compareTo("audio") == 0) {
            	// Extracting audio datafields
               String name = sc.nextLine();
               int id = Integer.parseInt(sc.nextLine());
               int order = Integer.parseInt(sc.nextLine());
               int rid = Integer.parseInt(sc.nextLine());
               int cid = Integer.parseInt(sc.nextLine());
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
               Audio putme = new Audio(name, id, order, rid, cid, artist, genre, composer, time, date);
               catalog.add(putme);
               if(id > highestID) {
                  highestID = id;
               }
            }
            else if(format.compareTo("newspaper") == 0) {
               String name = sc.nextLine();
               int id = Integer.parseInt(sc.nextLine());
               int order = Integer.parseInt(sc.nextLine());
               int rid = Integer.parseInt(sc.nextLine());
               int cid = Integer.parseInt(sc.nextLine());
               String stringDate = sc.nextLine();
               while(stringDate.length() < 8) {
                  stringDate = stringDate + "0";
               }
               int datePub = Integer.parseInt(stringDate);
               int issue = Integer.parseInt(sc.nextLine());
               String publisher = sc.nextLine();
               String topic = sc.nextLine();
            	// Add new item
               catalog.add(new Newspaper(name, id, order, rid, cid, datePub, issue, publisher, topic));
               if(id > highestID) {
                  highestID = id;
               }
            }
            else if(format.compareTo("journal") == 0) {
               String name = sc.nextLine();
               int id = Integer.parseInt(sc.nextLine());
               int order = Integer.parseInt(sc.nextLine());
               int rid = Integer.parseInt(sc.nextLine());
               int cid = Integer.parseInt(sc.nextLine());
               String stringDate = sc.nextLine();
               while(stringDate.length() < 8) {
                  stringDate = stringDate + "0";
               }
               int datePub = Integer.parseInt(stringDate);
               int issue = Integer.parseInt(sc.nextLine());
               String publisher = sc.nextLine();
               String topic = sc.nextLine();
               int issn = Integer.parseInt(sc.nextLine());
            	// Add new
               catalog.add(new Journal(name, id, order, rid, cid, datePub, issue, publisher, topic, issn));
               if(id > highestID) {
                  highestID = id;
               }
            }
            else if(format.compareTo("magazine") == 0) {
               String name = sc.nextLine();
               int id = Integer.parseInt(sc.nextLine());
               int order = Integer.parseInt(sc.nextLine());
               int rid = Integer.parseInt(sc.nextLine());
               int cid = Integer.parseInt(sc.nextLine());
               String stringDate = sc.nextLine();
               while(stringDate.length() < 8) {
                  stringDate = stringDate + "0";
               }
               int datePub = Integer.parseInt(stringDate);
               int issue = Integer.parseInt(sc.nextLine());
               String publisher = sc.nextLine();
               String topic = sc.nextLine();
            	// Add new item
               catalog.add(new Magazine(name, id, order, rid, cid, datePub, issue, publisher, topic));
               if(id > highestID) {
                  highestID = id;
               }
            }
            else if(format.compareTo("video") == 0) {
               String name = sc.nextLine();
               int id = Integer.parseInt(sc.nextLine());
               int order = Integer.parseInt(sc.nextLine());
               int rid = Integer.parseInt(sc.nextLine());
               int cid = Integer.parseInt(sc.nextLine());
               int length = Integer.parseInt(sc.nextLine());
               String stringDate = sc.nextLine();
               while(stringDate.length() < 8) {
                  stringDate = stringDate + "0";
               }
               int date = Integer.parseInt(stringDate);
            	// Add new item
               catalog.add(new Video(name, id, order, rid, cid,length, date));
               if(id > highestID) {
                  highestID = id;
               }
            }
            else {
               System.out.println("Unrecognized item type");
            }
         }
         catch (FileNotFoundException e) {
            e.printStackTrace();
         }
      }
      CatalogController.setCounter(highestID);
   }

   public static void writeToFile() {
      for(Item item : catalog) {
         try {
            //PrintWriter writer = new PrintWriter("Catalog/" + Integer.toString(item.getID()), "UTF-8");
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream("Catalog/" + Integer.toString(item.getID()) + ".txt"), "UTF-8"));
            if(item instanceof Book) {
               Book bItem = (Book) item;
               writer.println("book");
               writer.println(bItem.getName());
               writer.println(bItem.getID());
               writer.println(bItem.getOrder());
               writer.println(bItem.getRID());
               writer.println(bItem.getCID());
               writer.println(bItem.getAuthor());
               writer.println(bItem.getGenre());
               writer.println(bItem.getPublisher());
               writer.println(bItem.getISBN());
               writer.println(bItem.getDate());
               writer.close();
            }
            else if(item instanceof Audio) {
               Audio aItem = (Audio) item;
               writer.println("audio");
               writer.println(aItem.getName());
               writer.println(aItem.getID());
               writer.println(aItem.getOrder());
               writer.println(aItem.getRID());
               writer.println(aItem.getCID());
               writer.println(aItem.getArtist());
               writer.println(aItem.getGenre());
               writer.println(aItem.getComposer());
               writer.println(aItem.getTime());
               writer.println(aItem.getDate());
               writer.close();
            }
            else if(item instanceof Newspaper) {
               Newspaper nItem = (Newspaper) item;
               writer.println("newspaper");
               writer.println(nItem.getName());
               writer.println(nItem.getID());
               writer.println(nItem.getOrder());
               writer.println(nItem.getRID());
               writer.println(nItem.getCID());
               writer.println(nItem.getDatePub());
               writer.println(nItem.getIssue());
               writer.println(nItem.getPublisher());
               writer.println(nItem.getTopic());
               writer.close();
            }
            else if(item instanceof Journal) {
               Journal jItem = (Journal) item;
               writer.println("journal");
               writer.println(jItem.getName());
               writer.println(jItem.getID());
               writer.println(jItem.getOrder());
               writer.println(jItem.getRID());
               writer.println(jItem.getCID());
               writer.println(jItem.getDatePub());
               writer.println(jItem.getIssue());
               writer.println(jItem.getPublisher());
               writer.println(jItem.getTopic());
               writer.println(jItem.getISSN());
               writer.close();
            }
            else if(item instanceof Magazine) {
               Magazine mItem = (Magazine) item;
               writer.println("magazine");
               writer.println(mItem.getName());
               writer.println(mItem.getID());
               writer.println(mItem.getOrder());
               writer.println(mItem.getRID());
               writer.println(mItem.getCID());
               writer.println(mItem.getDatePub());
               writer.println(mItem.getIssue());
               writer.println(mItem.getPublisher());
               writer.println(mItem.getTopic());
               writer.close();
            }
            else if(item instanceof Video) {
               Video vItem = (Video) item;
               writer.println("video");
               writer.println(vItem.getName());
               writer.println(vItem.getID());
               writer.println(vItem.getOrder());
               writer.println(vItem.getRID());
               writer.println(vItem.getCID());
               writer.println(vItem.getLength());
               writer.println(vItem.getDate());
               writer.close();
            }
            else {
               System.out.println("Error writing due to item type.");
            }
         } catch (FileNotFoundException | UnsupportedEncodingException e) {
            System.out.println(e.getMessage());
         }
         
      }
   }

   public static String dump() {
      String output = "";
      for(Item i : catalog) {
         output = output + i.toString() + "\n";
      }
      return output;
   }

   public static void add(Item itemIn) {
      catalog.add(itemIn);
   }

   public static boolean remove(int id) {
      boolean out = false;
      Iterator it = catalog.iterator();
      int i = 0;
      while(it.hasNext()) {
         if(((Item) it.next()).getID() == id) {
            catalog.remove(i);
            out = true;
         }
         else {
            i++;
         }
      }
      try {
         File file = new File("Catalog\\" + id + ".txt");
         boolean success = file.delete();
      } catch (Exception e){
         e.printStackTrace();
      }
      
      return out;
   }

   public static String find(String input) {
      Iterator it = catalog.iterator();
      String output = "";
      while(it.hasNext()) {
         String buffer = it.next().toString();
         if(buffer.contains(input)) {
            output = output + buffer + "\n";
         }
      }
      if(output.compareTo("") == 0) {
         output = "\nThere were no matches to your query.";
      }
      return output;
   }
   
   public static void changeOrder(int id, int amount) {
      Iterator it = catalog.iterator();
      id--;
      int i = 0;
      while(it.hasNext()) {
         Item holder = (Item) it.next();
         if(holder.getID() == id) {
            holder.setOrder(amount);
            break;
         }
         else {
            i++;
         }
      }
   }

   public static boolean placeReserve(int id, int mid) {
      boolean out = false;
      Iterator it = catalog.iterator();
      int i = 0;
      while(it.hasNext()) {
         if(((Item) it.next()).getID() == (id-1)) {
            ((Item) it.next()).setRID(mid);
            out = true;
            break;
         }
         else {
            i++;
         }
      }
      return out;
   }

   public static int getReserve(int id) {
      Iterator it = catalog.iterator();
      id--;
      int i = 0;
      int value = 0;
      while(it.hasNext()) {
         if(((Item) it.next()).getID() == (id-1)) {
            value = ((Item) it.next()).getRID();
            break;
         }
         else {
            i++;
         }
      }
      return value;
   }

   public static void placeCheck(int id, int mid) {
      Iterator it = catalog.iterator();
      int i = 0;
      while(it.hasNext()) {
         if(((Item) it.next()).getID() == (id-1)) {
            ((Item) it.next()).setCID(mid);
            break;
         }
         else {
            i++;
         }
      }
   }

   public static int getCheck(int id) {
      Iterator it = catalog.iterator();
      int i = 0;
      int value = 0;
      while(it.hasNext()) {
         if(((Item) it.next()).getID() == (id-1)) {
            value = ((Item) it.next()).getCID();
            break;
         }
         else {
            i++;
         }
      }
      return value;
   }

   public static void modify(int id, String field, String newData) {
      Iterator it = catalog.iterator();
      int i = 0;
      while(it.hasNext()) {
         if(((Item) it.next()).getID() == (id-1)) {
            if(catalog.get(i) instanceof Book) {
               if(field.compareTo("name") == 0) {
                  catalog.get(i).setName(newData);
               }
               else if(field.compareTo("author") == 0) {
                  ((Book) catalog.get(i)).setAuthor(newData);
               }
               else if(field.compareTo("genre") == 0) {
                  ((Book) catalog.get(i)).setGenre(newData);
               }
               else if(field.compareTo("publisher") == 0) {
                  ((Book) catalog.get(i)).setPublisher(newData);
               }
               else if(field.compareTo("isbn") == 0) {
                  int newInt = Integer.parseInt(newData);
                  ((Book) catalog.get(i)).setISBN(newInt);
               }
               else if(field.compareTo("date") == 0) {
                  int newInt = Integer.parseInt(newData);
                  ((Book) catalog.get(i)).setDate(newInt);
               }
               else {
                  System.out.println("Error parsing field.");
               }
            } 
            else if(catalog.get(i) instanceof Audio) {
               if(field.compareTo("name") == 0) {
                  ((Audio) catalog.get(i)).setName(newData);
               }
               else if(field.compareTo("artist") == 0) {
                  ((Audio) catalog.get(i)).setArtist(newData); 
               }
               else if(field.compareTo("genre") == 0) {
                  ((Audio) catalog.get(i)).setGenre(newData);
               }
               else if(field.compareTo("composer") == 0) {
                  ((Audio) catalog.get(i)).setComposer(newData);
               }
               else if(field.compareTo("time") == 0) {
                  int newInt = Integer.parseInt(newData);
                  ((Audio) catalog.get(i)).setTime(newInt);
               }
               else if(field.compareTo("date") == 0) {
                  int newInt = Integer.parseInt(newData);
                  ((Audio) catalog.get(i)).setDate(newInt);
               }
               else {
                  System.out.println("Error parsing field");
               }
            }
            else if(catalog.get(i) instanceof Newspaper || catalog.get(i) instanceof Magazine) {
               if(field.compareTo("name") == 0) {
                  ((Periodical) catalog.get(i)).setName(newData);
               }
               else if(field.compareTo("datePub") == 0) {
                  int newInt = Integer.parseInt(newData);
                  ((Periodical) catalog.get(i)).setDatePub(newInt);
               }
               else if(field.compareTo("issue") == 0) {
                  int newInt = Integer.parseInt(newData);
                  ((Periodical) catalog.get(i)).setIssue(newInt);
               }
               else if(field.compareTo("publisher") == 0) {
                  ((Periodical) catalog.get(i)).setPublisher(newData);
               }
               else if(field.compareTo("topic") == 0) {
                  ((Periodical) catalog.get(i)).setTopic(newData);
               }
               else {
                  System.out.println("Error parsing field");
               }
            }
            else if(catalog.get(i) instanceof Journal) {
               if(field.compareTo("name") == 0) {
                  ((Journal) catalog.get(i)).setName(newData);
               }
               else if(field.compareTo("datePub") == 0) {
                  int newInt = Integer.parseInt(newData);
                  ((Journal) catalog.get(i)).setDatePub(newInt);
               }
               else if(field.compareTo("issue") == 0) {
                  int newInt = Integer.parseInt(newData);
                  ((Journal) catalog.get(i)).setIssue(newInt);
               }
               else if(field.compareTo("publisher") == 0) {
                  ((Journal) catalog.get(i)).setPublisher(newData);
               }
               else if(field.compareTo("topic") == 0) {
                  ((Journal) catalog.get(i)).setTopic(newData);
               }
               else if(field.compareTo("issn") == 0) {
                  int newInt = Integer.parseInt(newData);
                  ((Journal) catalog.get(i)).setISSN(newInt);
               }
               else {
                  System.out.println("Error parsing field.");
               }
            }
            else if(catalog.get(i) instanceof Video) {
               if(field.compareTo("name") == 0) {
                  ((Video) catalog.get(i)).setName(newData);
               }
               else if(field.compareTo("length") == 0) {
                  int newInt = Integer.parseInt(newData);
                  ((Video) catalog.get(i)).setLength(newInt);
               }
               else if(field.compareTo("date") == 0) {
                  int newInt = Integer.parseInt(newData);
                  ((Video) catalog.get(i)).setDate(newInt);
               }
               else {
                  System.out.println("Error parsing field.");
               }
            }
            else {
               System.out.println("Error parsing item type.");
            }
         }
         else {
            i++;
         }
     }
   }
}