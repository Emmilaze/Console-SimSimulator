import Person.Hero;
import Person.RandomCharacter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainMenu {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int menu;

    public void mainMenu() {
        if (!(Main.heroes.isEmpty())) {
            System.out.println(ANSI_BLUE + "\nContinue - enter 1" + ANSI_RESET);
            System.out.println(ANSI_YELLOW + "New game - enter 2" + ANSI_RESET);
            System.out.println(ANSI_RED + "Exit - enter 3" + ANSI_RESET);
            try {
                menu = Integer.parseInt(reader.readLine());
                if (menu == 1) {
                    for (int i = 0; i < Main.heroes.size(); i++) {
                        String str = Main.heroes.get(i).toString();
                        if(i%5==0)
                        System.out.println(ANSI_CYAN + str + ANSI_RESET);
                        if(i%5==1)
                            System.out.println(ANSI_RED + str + ANSI_RESET);
                        if(i%5==2)
                            System.out.println(ANSI_YELLOW + str + ANSI_RESET);
                        if(i%5==3)
                            System.out.println(ANSI_BLUE + str + ANSI_RESET);
                        if(i%5==4)
                            System.out.println(ANSI_PURPLE + str + ANSI_RESET);
                    }
                    mainMenu();
                }
                if (menu == 2)
                    newGame();
                if (menu == 3) {
                    reader.close();
                    return;
                }
                if (menu == 4)
                    new CharacterStorage().deleting();
            } catch (NumberFormatException a) {
                System.out.println("Please enter the number from 1 to 3");
                mainMenu();
            } catch (IOException e) {
                System.out.println("Error");
            }

        } else {
            System.out.println(ANSI_YELLOW + "\nNew game - enter 1" + ANSI_RESET);
            System.out.println(ANSI_RED + "Exit - enter 2" + ANSI_RESET);
            try {
                menu = Integer.parseInt(reader.readLine());
                if (menu == 1)
                    newGame();
                if (menu == 2) {
                    reader.close();
                    return;
                }
            } catch (NumberFormatException a) {
                System.out.println("Please enter the number from 1 to 2");
                mainMenu();
            } catch (IOException e) {
                System.out.println("Error");
            }
        }
    }


    public void newGame() {
        if (Main.heroes.size() >= 1) {
            System.out.println(ANSI_YELLOW + "\nCreate new character - enter 1" + ANSI_RESET);
            System.out.println(ANSI_BLUE + "Choose one from previously created - enter 2" + ANSI_RESET);
            System.out.println(ANSI_RED + "Back to main menu - enter 3" + ANSI_RESET);
            try {
                menu = Integer.parseInt(reader.readLine());
                if (menu == 1) {
                    System.out.println(ANSI_YELLOW + "\nCreate by yourself - enter 1" + ANSI_RESET);
                    System.out.println(ANSI_YELLOW + "Create random character - enter 2" + ANSI_RESET);
                    try {
                        menu = Integer.parseInt(reader.readLine());
                        if (menu == 1) {
                            Hero hero1 = CharacterStorage.create_hero();
                            Main.heroes.add(hero1);
                            System.out.println(ANSI_RED + hero1.toString() + " was added" + ANSI_RESET);
                            GameMenu gameMenu = new GameMenu();
                            gameMenu.game(hero1);
                        }
                        if (menu == 2) {
                            Hero hero2 = RandomCharacter.randomCreate();
                            Main.heroes.add(hero2);
                            System.out.println(ANSI_RED + hero2.toString() + " was added" + ANSI_RESET);
                        }
                    } catch (NumberFormatException a) {
                        System.out.println("Please enter the number from 1 to 3");
                        newGame();
                    } catch (IOException e) {
                        System.out.println("Error");
                        newGame();
                    }
                }
                if (menu == 2) {
                    for (int i = 0; i < Main.heroes.size(); i++)
                        System.out.println(Main.heroes.get(i).toString());
                    mainMenu();
                }
                if (menu == 3)
                    mainMenu();
            } catch (NumberFormatException a) {
                System.out.println("Please enter the number from 1 to 3");
                newGame();
            } catch (IOException e) {
                System.out.println("Error");
                newGame();
            }
        } else {
            System.out.println(ANSI_YELLOW + "\nCreate by yourself - enter 1" + ANSI_RESET);
            System.out.println(ANSI_PURPLE + "Create random character - enter 2" + ANSI_RESET);
            System.out.println(ANSI_RED + "Back to main menu - enter 3" + ANSI_RESET);
            try {
                menu = Integer.parseInt(reader.readLine());
                if (menu == 1) {
                    Hero hero3 = CharacterStorage.create_hero();
                    Main.heroes.add(hero3);
                    System.out.println(ANSI_RED + hero3.toString() + " was added" + ANSI_RESET);
                    mainMenu();
                }
                if(menu==2){
                    Hero hero4 = RandomCharacter.randomCreate();
                    Main.heroes.add(hero4);
                    System.out.println(ANSI_RED + hero4.toString() + " was added" + ANSI_RESET);
                }
                if (menu == 3)
                    mainMenu();
            } catch (NumberFormatException a) {
                System.out.println("Please enter the number from 1 to 2");
                newGame();
            } catch (IOException e) {
                System.out.println("Error");
                newGame();
            }
        }
    }
}
