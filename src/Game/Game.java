package Game;

import Core.Menu;
import Person.Hero;
import Person.IHeroNeeds;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Game {
    public final static Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    public void play(Hero hero){
        System.out.println(hero.showNeeds());
        System.out.println(hero.getCalendar().getTime());

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
                    needs.eating(hero.getCalendar());
                    play(hero);
                    break;

                case "To go shower":
                    needs.takingShower(hero.getCalendar());
                    play(hero);
                    break;

                case "Go to sleep":
                    needs.sleeping(hero.getCalendar());
                    play(hero);
                    break;

                case "Go to pee":
                    needs.goToPee(hero.getCalendar());
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
                    hero.getSkill().printSkills();
                    new Menu("Up skills", new ArrayList<>(Arrays.asList("Painting", "Playing the guitar", "Writing",
                            "Programming", "Gardening", "Logic", "Photography", "Dancing")),
                            x -> selected(x, hero)).show();
                    break;

                case "Back":
                    play(hero);
                    play(hero);
                    break;

                case "Painting":
                    hero.getSkill().getPainting().upLevel();
                    play(hero);
                    break;

                case "Playing the guitar":
                    hero.getSkill().getPlayingTheGuitar().upLevel();
                    play(hero);
                    break;

                case "Writing":
                    hero.getSkill().getWriting().upLevel();
                    play(hero);
                    break;

                case "Gardening":
                    hero.getSkill().getGardening().upLevel();
                    play(hero);
                    break;

                case "Logic":
                    hero.getSkill().getLogic().upLevel();
                    play(hero);
                    break;

                case "Photography":
                    hero.getSkill().getPhotography().upLevel();
                    play(hero);
                    break;

                case "Dancing":
                    hero.getSkill().getDancing().upLevel();
                    play(hero);
                    break;

                case "Programming":
                    hero.getSkill().getProgramming().upLevel();
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
//                hero.saveToFile(writer);
                hero.save(hero, writer, GSON);
            }
        }
}
