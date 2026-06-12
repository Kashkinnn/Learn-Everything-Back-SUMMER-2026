package studentRegistry;

import java.util.Objects;

public class Student {
    private String name;
    private int age;
    private int id;
    private String course;

    public Student(){
        this.name = null;
        this.age = 0;
        this.id = 0;
        this.course = null;
    }

    public Student(String name, int age, int id, String course){
        this.name = name;
        this.age = age;
        this.id = id;
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public boolean equals(String name, String name1) {
        if(Objects.equals(name, name1)){
            return true;
        }

        return false;
    }
}
