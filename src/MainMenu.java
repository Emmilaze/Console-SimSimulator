import Core.Menu;
import Game.Game;
import Person.Hero;
import Person.RandomCharacter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class MainMenu {
    public Void selected(String element) {
        switch(element) {
            case "New Game":
                newGame();
                break;

            case "Continue":
                oldHeroes();
                break;

            case "Exit":
                break;

            case "Back to Main Menu":
                mainMenu();
                break;

            case "Open CAS":
            {
                try {
                    Hero hero1 = CharacterStorage.create_hero();
                    Main.heroes.add(hero1);
                    Game game1 = new Game();
                    game1.play(hero1);

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            case "Random hero":
            {
                try {
                    Hero hero2 = RandomCharacter.randomCreate();
                    Main.heroes.add(hero2);

                    Game game1 = new Game();
                    game1.play(hero2);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    public void mainMenu() {
        if (!(Main.heroes.isEmpty()))
            new Menu("Main menu", new ArrayList<>(Arrays.asList("Continue", "New Game", "Exit")),
                    x -> selected(x)).show();
        else
            new Menu("Main menu", new ArrayList<>(Arrays.asList("New Game", "Exit")), x -> selected(x)).show();
    }

    public void newGame(){
        new Menu("New Game", new ArrayList<>(Arrays.asList("Open CAS", "Random hero", "Back to Main Menu")),
                x -> selected(x)).show();
    }

    public void oldHeroes() {
        CharacterStorage.heroesNames();
        new Menu("Choose hero", CharacterStorage.fullName, x -> selectedHero(x)).show();
    }

    public Void selectedHero(String element) {
        for(int i=0; i<Main.heroes.size(); i++)
            if(Main.heroes.get(i).toString().equals(element))
            {
                Game game3 = new Game();
                game3.play(Main.heroes.get(i));
            }
        return null;
    }

}
