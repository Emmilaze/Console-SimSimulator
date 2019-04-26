package Person;

import Person.Skills.*;
import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

public class Hero {

    private String name;
    private String last_name;
    private int age;
    private String sex;

    private Pet pet;
    private Work work;
    private Appearance appearance;
    private Relationship relationship;
    private HeroNeeds heroNeeds;
    private Calendar calendar;

    private Skills skills;
    private boolean haveJob;
    private boolean married;

    public Hero(String name, String last_name, int age, String sex, Calendar calendar, boolean haveJob) {
        this.name = name;
        this.last_name = last_name;
        this.age = age;
        this.sex = sex;
        this.calendar = calendar;
        this.haveJob = haveJob;
    }

    public void newWork(String position, int salary, String workingDays) {
        this.work = new Work(position, salary, workingDays);
    }

    public void newPet(String name) {
        this.pet = new Pet(name);
    }

    public void newAppearance(String color, String fav_color, float weight, String temper, String eyes_color,
                              String skin_color) {
        this.appearance = new Appearance(color, fav_color, weight, temper, eyes_color, skin_color);
    }

    public void newSkills(){
        this.skills = new Skills();
        skills.addSkills();
    }

    public void newHeroNeeds(int money, int hunger, int bladder, int hygiene, int energy){
        this.heroNeeds = new HeroNeeds(money, hunger, bladder, hygiene, energy);
    }

    @Override
    public String toString() {
        return (name + " " + last_name);
    }

    public String showNeeds(){
        return this.heroNeeds.show();
    }

    public IHeroNeeds needs(){
        return this.heroNeeds;
    }

    public Skills getSkill() {
        return skills;
    }

    public void setSkill(Skills skill) {
        this.skills = skills;
    }

    public void save(Hero hero, FileWriter writer, Gson GSON){

        String json = GSON.toJson(hero);
        try {
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Calendar getCalendar() {
        return calendar;
    }

}
