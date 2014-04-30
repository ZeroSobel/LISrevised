import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.io.*;
import java.lang.String;
import java.text.Format;
import java.lang.Integer;
import java.lang.Double;
import java.lang.Boolean;

public class TransactionDatabase extends Database {
   private static ArrayList<Transaction> transList = new ArrayList<Transaction>();

   public static int getSize() {
      return transList.size();
   }

   public static void readStart(File folder) {
      String header;
      int highestTrans = 0;
   	
      for(final File fileEntry : folder.listFiles()) {
         File file = new File("Transactions/" + fileEntry.getName());
         try {
            Scanner sc = new Scanner(file);
            header = sc.nextLine();
            if(header.compareTo("rental") == 0) {
               int tid = Integer.parseInt(sc.nextLine());
               int mid = Integer.parseInt(sc.nextLine());
               int date = Integer.parseInt(sc.nextLine());
               int dueDate = Integer.parseInt(sc.nextLine());
               int returnDate = Integer.parseInt(sc.nextLine());
               int iid = Integer.parseInt(sc.nextLine());
               double fee = Double.parseDouble(sc.nextLine());
            
               transList.add(new Rental(tid, mid, date, dueDate, returnDate, iid, fee));
               if(tid > highestTrans) {
                  highestTrans = tid;
               }
            }
            else if(header.compareTo("fee") == 0) {
               int tid = Integer.parseInt(sc.nextLine());
               int mid = Integer.parseInt(sc.nextLine());
               int date = Integer.parseInt(sc.nextLine());
               double fee = Double.parseDouble(sc.nextLine());
            
               transList.add(new Fee(tid, mid, date, fee));
               if(tid > highestTrans) {
                  highestTrans = tid;
               }
            }
            else if(header.compareTo("reservecomp") == 0) {
               int tid = Integer.parseInt(sc.nextLine());
               int mid = Integer.parseInt(sc.nextLine());
               int date = Integer.parseInt(sc.nextLine());
               int cid = Integer.parseInt(sc.nextLine());
            
               transList.add(new ReserveCompTime(tid, mid, date, cid));
               if(tid > highestTrans) {
                  highestTrans = tid;
               }
            }
            else {
               System.out.println("Unknown transaction type");
            }
         }
         catch (FileNotFoundException e) {
            e.printStackTrace();
         }
      }
      TransactionController.setCounter(highestTrans);
   }


   public static void writeToFile() {
      for(Transaction trans : transList) {
         try {
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream("Transactions/" + Integer.toString(trans.getID()) + ".txt"), "UTF-8"));
            if(trans instanceof Rental) {
               Rental rTrans = (Rental) trans;
               writer.println("rental");
               writer.println(rTrans.getID());
               writer.println(rTrans.getMemberID());
               writer.println(rTrans.getDate());
               writer.println(rTrans.getDueDate());
               writer.println(rTrans.getReturnDate());
               writer.println(rTrans.getItemID());
               writer.println(rTrans.getFee());
               writer.close();
            }
            else if(trans instanceof Fee) {
               writer.println("fee");
               Fee fTrans = (Fee) trans;
               writer.println(fTrans.getID());
               writer.println(fTrans.getMemberID());
               writer.println(fTrans.getDate());
               writer.println(fTrans.getFee());
               writer.close();
            }
            else if(trans instanceof ReserveCompTime) {
               ReserveCompTime rTrans = (ReserveCompTime) trans;
               writer.println("reservecomp");
               writer.println(rTrans.getID());
               writer.println(rTrans.getMemberID());
               writer.println(rTrans.getDate());
               writer.println((int)rTrans.getCompID());
               writer.close();
            }
            else {
               System.out.println("Error writing transaction due to type.");
            }
         } 
         catch (FileNotFoundException | UnsupportedEncodingException e) {
            System.out.println(e.getMessage());
         }
      		
      }
   }

   public static void add(Transaction in) {
      transList.add(in);
   }

   public static boolean remove(int id) {
      Iterator it = transList.iterator();
      boolean out = false;
      int i = 0;
      while(it.hasNext()) {
         if(((Transaction) it.next()).getID() == id) {
            transList.remove(i);
            out = true;
         }
         else {
            i++;
         }
      }
      return out;
   }

   public static Transaction findUnreturnedByID(int id) {
      Iterator it = transList.iterator();
      int i = 0;
      Transaction output = null;
      
      for(Transaction t : transList) {
         if(t instanceof Rental) {
            Rental holder = (Rental) t;
            if(holder.getItemID() == id && holder.getReturnDate() == 0) {
               output = holder;
            }
         }
      }
      return output;
   }


   public static void modify(int id, String field, String newData) {
      Iterator it = transList.iterator();
      int i = 0;


      while(it.hasNext()) {
         if(((Transaction) it.next()).getID() == id) {
            if(transList.get(i) instanceof Rental) {
               Rental rTrans = (Rental) transList.get(i);
               if(field.compareTo("memberID") == 0) {
                  int newInt = Integer.parseInt(newData);
                  rTrans.setMemberID(newInt);
               }
               else if(field.compareTo("date") == 0) {
                  int newInt = Integer.parseInt(newData);
                  rTrans.setDate(newInt);
               }
               else if(field.compareTo("dueDate") == 0) {
                  int newInt = Integer.parseInt(newData);
                  rTrans.setDueDate(newInt);
               }
               else if(field.compareTo("returnDate") == 0) {
                  int newInt = Integer.parseInt(newData);
                  rTrans.setReturnDate(newInt);
               }
               else if(field.compareTo("itemID") == 0) {
                  int newInt = Integer.parseInt(newData);
                  rTrans.setItemID(newInt);
               }
               else if(field.compareTo("fee") == 0) {
                  double newDouble = Double.parseDouble(newData);
                  rTrans.setFee(newDouble);
               }
               else {
                  System.out.println("Error parsing field.");
               }
            }
            else if(transList.get(i) instanceof Fee) {
               Fee fTrans = (Fee) transList.get(i);
               if(field.compareTo("memberID") == 0) {
                  int newInt = Integer.parseInt(newData);
                  fTrans.setMemberID(newInt);
               }
               else if(field.compareTo("date") == 0) {
                  int newInt = Integer.parseInt(newData);
                  fTrans.setDate(newInt);
               }
               else if(field.compareTo("fee") == 0) {
                  double newDouble = Double.parseDouble(newData);
                  fTrans.setFee(newDouble);
               }
               else {
                  System.out.println("Error parsing field.");
               }
            }
            else if(transList.get(i) instanceof ReserveCompTime) {
               ReserveCompTime rTrans = (ReserveCompTime) transList.get(i);
               if(field.compareTo("memberID") == 0) {
                  int newInt = Integer.parseInt(newData);
                  rTrans.setMemberID(newInt);
               }
               else if(field.compareTo("date") == 0) {
                  int newInt = Integer.parseInt(newData);
                  rTrans.setDate(newInt);
               }
               else if(field.compareTo("compID") == 0) {
                  int newInt = Integer.parseInt(newData);
                  rTrans.setCompID(newInt);
               }
               else {
                  System.out.println("Error parsing field.");
               }
            }
            else {
               System.out.println("Error identifying object type.");
            }
         }
         else {
            i++;
         }
      }
   }
}