package Person;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

public class Character {
    private String name;
    private String last_name;
    private int age;
    private String sex;
    private String birth;

    private Pet pet;
    private Work work;
    private Appearance appearance;
    private Relationship relationship;


    public Character(String name, String last_name, int age, String sex, String birth) {
        this.name = name;
        this.last_name = last_name;
        this.age = age;
        this.sex = sex;
        this.birth = birth;
    }

    public void newWork(String firstDay, String position, int salary, String workingDays) {
        this.work = new Work(firstDay, position, salary, workingDays);
    }

    public void newPet(String name) {
        this.pet = new Pet(name);
    }

    public void newAppearance(String color, String fav_color, float weight, String temper, String eyes_color,
                              String skin_color) {
        this.appearance = new Appearance(color, fav_color, weight, temper, eyes_color, skin_color);
    }

    @Override
    public String toString() {
        return (name + " " + last_name);
    }

    public static Character randomCreate() throws IOException {
        String name;
        String last_name = randomLastName();
        int age = (int) (Math.random() * 100);
        String sex;
        if (Math.random() > 0.5) {

            sex = "Male";
            name = randomNameMale();
        } else {
            sex = "Female";
            name = randomNameFemale();
        }
        String birth = randomBirth();
        FileWriter writer = new FileWriter("./Characters/" + name + " " + last_name + ".txt");
        Character result = new Character(name, last_name, age, sex, birth);
        writer.write(name + ";" + last_name + ";" + age + ";" + sex + ";" + birth);
        writer.close();
        return result;
    }

    public static String randomNameMale() throws IOException {
        ArrayList<String> names = new ArrayList<String>();
        Stream<String> stream = Files.lines(Paths.get("./Random/MaleNames.txt"));

        stream.forEach(line -> names.add(line));
        return names.get((int) (Math.random() * 500));
    }

    public static String randomNameFemale() throws IOException {
        ArrayList<String> names = new ArrayList<String>();
        Stream<String> stream = Files.lines(Paths.get("./Random/FemaleNames.txt"));
        stream.forEach(line -> names.add(line));
        return names.get((int) (Math.random() * 500));
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
