public abstract class Controller {
	
	abstract void retrieveInfo(int id);

	abstract void remove(int id);

	abstract String search(String field, String param);
}