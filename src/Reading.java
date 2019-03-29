import Person.Character;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Reading {
    public static Character read_hero(File file) throws IOException {
        String content = Files.lines(Paths.get(file.getPath())).reduce("", String::concat);
        String[] subStr;

        subStr = content.split(";");
        String name = subStr[0];
        String last_name = subStr[1];
        int age = Integer.parseInt(subStr[2]);
        String sex = subStr[3];
        String birth = subStr[4];

        Character result = new Character(name, last_name, age, sex, birth);
        return result;
    }
}
