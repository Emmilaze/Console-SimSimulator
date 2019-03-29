import java.io.*;
import java.util.ArrayList;

import Person.Hero;

public class Main {

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
                Hero person = CharacterStorage.read_hero(file);
                allHeroes.add(person);
            }
        }
        return allHeroes;
    }
}
