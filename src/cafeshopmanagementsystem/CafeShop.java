package cafeshopmanagementsystem;

public class CafeShop {
    private String name;
    private String address;
    private int votes;
    private int rating;

    public CafeShop(String name, String address, int votes, int rating) {
        this.name = name;
        this.address = address;
        this.votes = votes;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getVotes() {
        return votes;
    }

    public int getRating() {
        return rating;
    }
}
