package Person;

public class Hero {


    private String name;
    private String last_name;
    private int age;
    private String sex;
    private String birth;

    private Pet pet;
    private Work work;
    private Appearance appearance;
    private Relationship relationship;
    private HeroNeeds heroNeeds;

    public Hero(String name, String last_name, int age, String sex, String birth) {
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

    public void newHeroNeeds(int money, int hunger, int bladder, int hygiene, int energy){
        this.heroNeeds = new HeroNeeds(money, hunger, bladder, hygiene, energy);
    }

    @Override
    public String toString() {
        return (name + " " + last_name);
    }

}
