import java.io.*;
import java.util.ArrayList;

import Person.Hero;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    public final static Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    public static ArrayList<Hero> heroes = new ArrayList<Hero>();
    public static void main(String[] args) throws IOException {
        heroes.addAll(readAllCharacters());

        MainMenu menu = new MainMenu();
        menu.mainMenu();
    }

    public static ArrayList<Hero> readAllCharacters() throws IOException {
        File folder = new File("./Characters");
        ArrayList<Hero> allHeroes = new ArrayList<Hero>();
        for (File file : folder.listFiles()) {
            if (file.getName().contains(".txt")) {
                Hero person = CharacterStorage.read_hero(file, GSON);
                allHeroes.add(person);
            }
        }
        return allHeroes;
    }
}
