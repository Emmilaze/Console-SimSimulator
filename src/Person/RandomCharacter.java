package Person;

import static Person.HeroNeeds.*;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

public class RandomCharacter {

    public static Hero randomCreate() throws IOException {
        String name;
        String last_name = randomLastName();
        String sex;
        if (Math.random() > 0.5) {

            sex = "Male";
            name = randomNameMale();
        } else {
            sex = "Female";
            name = randomNameFemale();
        }
        String birth = randomBirth();
        int age = (int) (Math.random() * 100);

        FileWriter writer = new FileWriter("./Characters/" + name + " " + last_name + ".txt");
        Hero result = new Hero(name, last_name, age, sex, birth);
        result.newHeroNeeds(MONEY_START, HUNGER_START, BLADDER_START,
                HYGIENE_START, ENERGY_START);
        writer.write(name + ";" + last_name + ";" + age + ";" + sex + ";" + birth + ";" + MONEY_START
                + ";" + HUNGER_START + ";" + BLADDER_START + ";" + HYGIENE_START + ";" + ENERGY_START);
        writer.close();
        return result;
    }

    public static String randomNameMale() throws IOException {
        ArrayList<String> names = new ArrayList<String>();
        Stream<String> stream = Files.lines(Paths.get("./Random/MaleNames.txt"));

        stream.forEach(line -> names.add(line));
        return names.get((int) (Math.random() * 2943));
    }

    public static String randomNameFemale() throws IOException {
        ArrayList<String> names = new ArrayList<String>();
        Stream<String> stream = Files.lines(Paths.get("./Random/FemaleNames.txt"));
        stream.forEach(line -> names.add(line));
        return names.get((int) (Math.random() * 4341));
    }

    public static String randomLastName() throws IOException {

        ArrayList<String> last_names = new ArrayList<String>();
        Stream<String> stream = Files.lines(Paths.get("./Random/Last names.txt"));
        stream.forEach(line -> last_names.add(line));
        String surname = last_names.get((int) (Math.random() * 500));
        surname = surname.toLowerCase();
        surname = surname.substring(0, 1).toUpperCase() + surname.substring(1);
        return surname;
    }

    public static String randomBirth() {
        int day = (int) (1 + Math.random() * 31);
        int month = (int) (1 + Math.random() * 12);
        if (month == 2 && day > 29) {
            while (day > 29)
                day = (int) (Math.random() * 28);
        }
        if ((month == 4 || month == 6 || month == 9 || month == 11) && day > 30)
            day = (int) (Math.random() * 30);
        int year = (int) (Math.random() * 2019);
        if (year <= 1950) {
            while (year <= 1950)
                year = (int) (Math.random() * 2019);
        }
        return (day + "." + month + "." + year);
    }
}
