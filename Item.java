public class Item {
	private String name;
	private int id;
   private int order;
   private int rid;  //reserver ID
   private int cid; //ID of person who checked it out

	public Item(String nameIn, int idIn, int orderIn, int ridIn, int cidIn) {
		name = nameIn;
		id = idIn;
      order = orderIn;
      rid = ridIn;
      cid = cidIn;
	}

	public String toString() {
		return name;
	}
	public String getName() {
		return name;
	}
	public int getID() {
		return id;
	}
   public int getOrder() {
      return order;
   }
   public int getRID() {
      return rid;
   }
   public int getCID() {
      return cid;
   }
   
	public void setName(String nameIn) {
		name = nameIn;
	}
	public void setID(int idIn) {
		id = idIn;
	}
   public void setOrder(int in) {
      order = in;
   }
   public void setRID(int id) {
      rid = id;
   }
   public void setCID(int id) {
      cid = id;
   }
}