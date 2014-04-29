import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.String;

public class CatalogDatabase extends ArrayList {
   
	private void readStart(final File folder) {
		File file = new File();
		
		for(final File fileEntry : folder.listFiles()) {
			file = File((fileEntry.getName() + ".txt"));
			try {
				Scanner sc = new Scanner(file);
				String format = sc.nextLine();
				if (format.compareTo("book") == 0) {
					
				}
				else if(format.compareTo("audio") == 0) {
					
				}
				else if(format.compareTo("newspaper") == 0) {
					
				}
				else if(format.compareTo("journal") == 0) {
					
				}
				else if(format.compareTo("magazine") == 0) {
					
				}
				else if(format.compareTo("video") == 0) {
					
				}
				else {
					System.out.print("Unrecognized item type");
				}
				while(sc.hasNextLine()) {
					String line = sc.nextLine();
					if
				}
			}
			catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	private void writeToFile() {
		
	}
}