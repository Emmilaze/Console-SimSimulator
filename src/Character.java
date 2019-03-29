public class Character {
    private String name;
    private String last_name;
    private int age;
    private String sex;
    private String birth;
    private String color;

    public Character() {
    }

    public Character(String name, String last_name, int age, String sex, String birth, String color) {
        this.name = name;
        this.last_name = last_name;
        this.age = age;
        this.sex = sex;
        this.birth = birth;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
