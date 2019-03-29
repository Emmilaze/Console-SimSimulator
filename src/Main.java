import java.io.*;


public class Main {

    public static void main(String[] args) throws IOException {
        int symb;
        char symbol;
        String line;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileWriter writer = new FileWriter("character.txt");
        File f = new File("character.txt");
        BufferedReader fin = new BufferedReader(new FileReader(f));
            while(true) {
                System.out.println("Do you want to create new character or download old? Choose 3 to exit. 1/2/3");
                //symbol = reader.readLine().charAt(0);
                symb = Integer.parseInt(reader.readLine());

                if (symb == 1) {
                    Character character1 = new Character();

                    System.out.println("Enter the name of character");
                    character1.setName(reader.readLine());
                    writer.write("\nName: " + character1.getName() + ". ");

                    System.out.println("Enter the last name of character");
                    character1.setLast_name(reader.readLine());
                    writer.write("\nLast name: " + character1.getLast_name() + ". ");

                    System.out.println("Enter age of the character");
                    character1.setAge(Integer.parseInt(reader.readLine()));
                    writer.write("\nAge: " + character1.getAge() + ". ");

                    System.out.println("Enter sex of the character:");
                    character1.setSex(reader.readLine());
                    writer.write("\nSex: " + character1.getSex() + ". ");

                    System.out.println("Enter the date of birth: ");
                    character1.setBirth(reader.readLine());
                    writer.write("\nDate of birth: " + character1.getBirth() + ". ");

                    System.out.println("Enter the color of hair: ");
                    character1.setColor(reader.readLine());
                    writer.write("\nColor of hair: " + character1.getColor() + ". ");

                }

                if (symb == 2) {
                    writer.close();
                    while ((line = fin.readLine()) != null) System.out.println(line);
                }

                if (symb == 3)
                    break;
            }

            writer.close();
            reader.close();
            fin.close();
    }
}
