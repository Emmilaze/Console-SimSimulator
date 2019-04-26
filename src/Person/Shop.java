package Person;

public class Shop {
    protected String thingName;
    protected int price;

    public Shop(String thingName, int price) {
        this.thingName = thingName;
        this.price = price;
    }

    public String getThingName() {
        return thingName;
    }

    public void setThingName(String thingName) {
        this.thingName = thingName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
