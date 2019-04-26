import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static Person.HeroNeeds.*;

import Person.Hero;
import com.google.gson.Gson;

public class CharacterStorage {

    public static ArrayList<String> fullName = new ArrayList<>();

    public static Hero create_hero() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Calendar calendar = new GregorianCalendar(LocalDateTime.now().getYear(), LocalDateTime.now().getMonthValue(),
                LocalDateTime.now().getDayOfMonth());
        System.out.println("Please enter the name:");
        String name = reader.readLine();
        System.out.println("Please enter the last name:");
        String last_name = reader.readLine();
        System.out.println("Please enter the age:");
        int age = Integer.parseInt(reader.readLine());
        System.out.println("Please enter the sex:");
        String sex = reader.readLine();
        Hero result = new Hero(name, last_name, age, sex, calendar, false);
        result.newHeroNeeds(MONEY_START, HUNGER_START, BLADDER_START, HYGIENE_START, ENERGY_START);
        result.newSkills();
        return result;
    }

    public static Hero read_hero(File file, Gson GSON) throws IOException {
        String content = new String(Files.readAllBytes(Paths.get(file.getPath())));
        Hero result = GSON.fromJson(content, Hero.class);
        return result;
    }

    public void deleting() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < Main.heroes.size(); i++)
            System.out.println(i + Main.heroes.get(i).toString());
        int index = Integer.parseInt(reader.readLine());
        Hero selectedHero = Main.heroes.get(index);
        File file = new File("./Characters/" + selectedHero.toString() + ".txt");

        reader.close();
        file.delete();
    }

    public static ArrayList<String> heroesNames() {
        for (int i = 0; i < Main.heroes.size(); i++)
            fullName.add(Main.heroes.get(i).toString());
        return fullName;
    }


}
