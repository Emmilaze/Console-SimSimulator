package Person;

public class HeroNeeds {
    public final static int MONEY_START = 2000;
    public final static int HUNGER_START = 100;
    public final static int BLADDER_START = 100;
    public final static int HYGIENE_START = 100;
    public final static int ENERGY_START = 100;

    public int money;

    public int hunger;
    public int bladder;
    public int hygiene;
    public int energy;

    public HeroNeeds(int money, int hunger, int bladder, int hygiene, int energy) {
        this.money = money;
        this.hunger = hunger;
        this.bladder = bladder;
        this.hygiene = hygiene;
        this.energy = energy;
    }

    @Override
    public String toString() {
        return ("Money: " + money + "\nHunger: " + hunger + "\nBludder: " + bladder + "\nHygiene: " + hygiene
                + "\nEnergy: " + energy);
    }


}


