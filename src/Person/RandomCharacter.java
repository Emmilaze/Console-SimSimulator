package Person;

import static Person.HeroNeeds.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.stream.Stream;

public class RandomCharacter {

    public static Hero randomCreate() throws IOException {
        String name;
        String last_name = randomLastName();
        String sex;
        Calendar calendar = new GregorianCalendar(LocalDateTime.now().getYear(),
                LocalDateTime.now().getMonthValue(), LocalDateTime.now().getDayOfMonth(), LocalDateTime.now().getHour(),
                LocalDateTime.now().getMinute());

        if (Math.random() > 0.5) {
            sex = "Male";
            name = randomNameMale();
        } else {
            sex = "Female";
            name = randomNameFemale();
        }

        int age = (int) (Math.random() * 90);
        Hero result = new Hero(name, last_name, age, sex, calendar, false);
        result.newHeroNeeds(MONEY_START, HUNGER_START, BLADDER_START,
                HYGIENE_START, ENERGY_START);
        result.newSkills();
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
}
