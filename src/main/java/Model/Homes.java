package Model;

public class Homes {
	private int id , status ;
	private float numPrice;
	private String title , description , img ;
	
	
	
	public Homes() {
		super();
	}



	public Homes(int id, int status, float numPrice, String title, String description, String img) {
		super();
		this.id = id;
		this.status = status;
		this.numPrice = numPrice;
		this.title = title;
		this.description = description;
		this.img = img;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public int getStatus() {
		return status;
	}



	public void setStatus(int status) {
		this.status = status;
	}



	public float getNumPrice() {
		return numPrice;
	}



	public void setNumPrice(float numPrice) {
		this.numPrice = numPrice;
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getImg() {
		return img;
	}



	public void setImg(String img) {
		this.img = img;
	}
	
	
}
