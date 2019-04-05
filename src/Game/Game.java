package Game;

import Core.Menu;
import Person.Hero;
import Person.IHeroNeeds;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Game {
    public void play(Hero hero){
        System.out.println(hero.showNeeds());
        new Menu("Game menu", new ArrayList<>(Arrays.asList("Satisfy needs", "Open shopping mode", "Up skills",
                "Exit")),
                x -> selected(x, hero)).show();
        }

        public Void selected(String element, Hero hero){
            IHeroNeeds needs = hero.needs();
            switch (element){
                case "Satisfy needs":
                    chooseNeed(hero);
                    break;

                case "Eat smth":
                    needs.eating();
                    play(hero);
                    break;

                case "To go shower":
                    needs.takingShower();
                    play(hero);
                    break;

                case "Go to sleep":
                    needs.sleeping();
                    play(hero);
                    break;
                case "Go to pee":
                    needs.goToPee();
                    play(hero);
                    break;

                case "Exit":
                    try {
                        saveGame(hero);
                    } catch (IOException e) {
                        System.out.println("Error " + e);
                    }
                    break;

                case "Open shopping mode":
                    System.out.println("Shopping mode");
                    play(hero);
                    break;
                case "Up skills":
                    System.out.println("Up skills");
                    play(hero);
                    break;
                case "Back":
                    play(hero);
                    break;
            }
        return null;
        }

        public void chooseNeed(Hero hero) {
            new Menu("Satisfy needs", new ArrayList<>(Arrays.asList("Eat smth",
                    "Go to pee", "To go shower", "Go to sleep", "Back")),
                    x -> selected(x, hero)).show();
        }

        public void saveGame(Hero hero) throws IOException {
            try (FileWriter writer = new FileWriter("./Characters/" + hero.toString() + ".txt")) {
                hero.saveToFile(writer);
            }
        }
}
