package Person;

import java.io.FileWriter;
import java.io.IOException;

public class HeroNeeds implements IHeroNeeds {
    public final static int MONEY_START = 2000;
    public final static int HUNGER_START = 100;
    public final static int BLADDER_START = 100;
    public final static int HYGIENE_START = 100;
    public final static int ENERGY_START = 100;
    public final static int MIN = 0;
    public final static int MAX = 100;

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

    public String show() {
        return ("Money: " + money + "\nHunger: " + hunger + "\nBladder: " + bladder + "\nHygiene: " + hygiene
                + "\nEnergy: " + energy);
    }

    @Override
    public void sleeping() {
        energy = change(energy, 100);
        hunger = change(hunger, -30);
        bladder = change(bladder, -20);
        hygiene = change(hygiene, -10);
    }

    @Override
    public void eating() {
        energy = change(energy, -5);
        hunger = change(hunger, 100);
        bladder = change(bladder, -20);
        hygiene = change(hygiene, -5);
    }

    @Override
    public void takingShower() {
        energy = change(energy, -5);
        hunger = change(hunger, -5);
        bladder = change(bladder, -5);
        hygiene = change(hygiene, 100);
    }

    @Override
    public void goToPee() {

        energy = change(energy, -5);
        hunger = change(hunger, -5);
        bladder = change(bladder, 100);
        hygiene = change(hygiene, -5);
    }

    public int change(int paramert, int delta) {
        paramert += delta;
        if (paramert > MAX)
            paramert = MAX;
        if (paramert < MIN)
            paramert = MIN;
        return paramert;
    }

    public void saveToFile(FileWriter writer) throws IOException {
            writer.write(String.format(";%s;%s;%s;%s;%s", money, hunger, bladder, hygiene, energy));
    }
}


