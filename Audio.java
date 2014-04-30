public class Audio extends Item {
	private String artist;
	private String genre;
	private String composer;
	private int time;
	private int date;

	public Audio(String nameIn, int idIn, int orderIn, int ridIn, int cidIn, String artistIn, String genreIn, 
		String composerIn, int timeIn, int dateIn) {
		
		super(nameIn, idIn, orderIn, ridIn, cidIn);
		artist = artistIn;
		genre = genreIn;
		composer = composerIn;
		time = timeIn;
		date = dateIn;
	}

	public String toString() {
		return this.getName()+"    "+artist+"    "+genre+"    "+composer+"    "+this.getID();
	}
	public String getArtist() {
		return artist;
	}
	public String getGenre() {
		return genre;
	}
	public String getComposer() {
		return composer;
	}
	public int getTime() {
		return time;
	}
	public int getDate() {
		return date;
	}

	public void setArtist(String artistIn) {
		artist = artistIn;
	}
	public void setGenre(String genreIn) {
		genre = genreIn;
	}
	public void setComposer(String composerIn) {
		composer = composerIn;
	}
	public void setTime(int timeIn) {
		time = timeIn;
	}
	public void setDate(int dateIn) {
		date = dateIn;
	}
}