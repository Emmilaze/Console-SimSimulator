import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import Person.Character;

public class Writing {
    public static Character create_hero() throws IOException {
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
        Character result = new Character(name, last_name, age, sex, birth);
        writer.write(name + ";" + last_name + ";" + age + ";" + sex + ";" + birth);

        writer.close();
        return result;
    }
}
