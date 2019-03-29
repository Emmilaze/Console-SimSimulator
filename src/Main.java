import java.io.*;
import java.util.ArrayList;
import Person.Character;

public class Main {

    public static ArrayList<Character> characters = new ArrayList<Character>();

    public static void main(String[] args) throws IOException {
        characters.addAll(readAllCharacters());

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int symb;
        while (true) {
            System.out.println("Do you want to create new character or download old? Choose 3 to exit. 1/2/3");

            symb = Integer.parseInt(reader.readLine());

            if (symb == 1) {
                System.out.println("Do you want to create character by youself or create random? 1/2");
                int random = Integer.parseInt(reader.readLine());
                if (random == 1) {
                    Character character1 = Writing.create_hero();
                    characters.add(character1);
                } else {
                    Character character2 = Character.randomCreate();
                    characters.add(character2);
                }
            }
            if (symb == 2)
                for (int i = 0; i < characters.size(); i++)
                    System.out.println(characters.get(i).toString());
            if (symb == 3)
                break;
        }
        reader.close();
    }

    public static ArrayList<Character> readAllCharacters() throws IOException {
        File folder = new File("./Characters");
        ArrayList<Character> allCharacter = new ArrayList<Character>();
        for (File file : folder.listFiles()) {
            if (file.getName().contains(".txt")) {
                Character person = Reading.read_hero(file);
                allCharacter.add(person);
            }
        }
        return allCharacter;
    }
}
