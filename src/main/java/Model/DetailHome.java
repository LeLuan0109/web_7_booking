package Model;

public class DetailHome {
    private int id;
    private String title;
    private int numPerson;
    private String description;
    private double price;
    private int homeId;

    // Constructors
    public DetailHome() {
    }

    public DetailHome(int id, String title, int numPerson, String description, double price, int homeId) {
        this.id = id;
        this.title = title;
        this.numPerson = numPerson;
        this.description = description;
        this.price = price;
        this.homeId = homeId;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNumPerson() {
        return numPerson;
    }

    public void setNumPerson(int numPerson) {
        this.numPerson = numPerson;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getHomeId() {
        return homeId;
    }

    public void setHomeId(int homeId) {
        this.homeId = homeId;
    }
}
