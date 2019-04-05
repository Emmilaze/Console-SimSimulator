import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import static Person.HeroNeeds.*;
import Person.Hero;

public class CharacterStorage {

    public static ArrayList<String> fullName = new ArrayList<>();

    public static Hero create_hero() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter the name:");
        String name = reader.readLine();
        System.out.println("Please enter the last name:");
        String last_name = reader.readLine();
        System.out.println("Please enter the age:");
        int age = Integer.parseInt(reader.readLine());
        System.out.println("Please enter the sex:");
        String sex = reader.readLine();
        System.out.println("Please enter the date of birth:");
        String birth = reader.readLine();

        FileWriter writer = new FileWriter("./Characters/" + name + " " + last_name + ".txt");
        Hero result = new Hero(name, last_name, age, sex, birth);
        result.newHeroNeeds(MONEY_START, HUNGER_START, BLADDER_START,
                HYGIENE_START, ENERGY_START);
        writer.write(name + ";" + last_name + ";" + age + ";" + sex + ";" + birth + ";" + MONEY_START
                + ";" + HUNGER_START + ";" + BLADDER_START + ";" + HYGIENE_START + ";" + ENERGY_START);
        reader.close();
        writer.close();
        return result;
    }

    public static Hero read_hero(File file) throws IOException {
        String content = Files.lines(Paths.get(file.getPath())).reduce("", String::concat);
        String[] subStr;

        subStr = content.split(";");
        String name = subStr[0];
        String last_name = subStr[1];
        int age = Integer.parseInt(subStr[2]);
        String sex = subStr[3];
        String birth = subStr[4];

        int money=Integer.parseInt(subStr[5]);
        int hunger=Integer.parseInt(subStr[6]);
        int bladder=Integer.parseInt(subStr[7]);
        int hygiene=Integer.parseInt(subStr[8]);
        int energy=Integer.parseInt(subStr[9]);

        Hero result = new Hero(name, last_name, age, sex, birth);
        result.newHeroNeeds(money, hunger, bladder, hygiene, energy);
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

    public static ArrayList<String> heroesNames(){
        for(int i=0; i<Main.heroes.size(); i++)
        fullName.add(Main.heroes.get(i).toString());
        return fullName;
    }


}
