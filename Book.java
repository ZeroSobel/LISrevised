public class Book extends Item {
	private String author;
	private String genre;
	private String publisher;
	private int isbn;
	private int date;

	public Book(String nameIn, int idIn, int orderIn, int ridIn, int cidIn, String authorIn, String genreIn, 
		String publisherIn, int isbnIn, int dateIn) {

		super(nameIn, idIn, orderIn, ridIn, cidIn);
		author = authorIn;
		genre = genreIn;
		publisher = publisherIn;
		isbn = isbnIn;
		date = dateIn;
	}

	public String toString() {
		return this.getName()+"    "+author+"    "+genre+"    "+publisher+"    "+isbn+"    "+this.getID();
	}
	public String getAuthor() {
		return author;
	}
	public String getGenre() {
		return genre;
	}
	public String getPublisher() {
		return publisher;
	}
	public int getISBN() {
		return isbn;
	}
	public int getDate() {
		return date;
	}

	//Setters
	public void setAuthor(String authorIn) {
		author = authorIn;
	}
	public void setGenre(String genreIn) {
		genre = genreIn;
	}
	public void setPublisher(String publisherIn) {
		publisher = publisherIn;
	}
	public void setISBN(int isbnIn) {
		isbn = isbnIn;
	}
	public void setDate(int dateIn) {
		date = dateIn;
	}
}