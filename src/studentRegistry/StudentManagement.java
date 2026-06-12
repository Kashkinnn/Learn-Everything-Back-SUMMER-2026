package studentRegistry;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import java.util.Scanner;

public class StudentManagement {
    ArrayList<Student> students = new ArrayList<>();

    public StudentManagement(){
        students = new ArrayList<>();
    }

    // create
    public void addStudent(String name, int age, int id, String course){
        Student student = new Student(name,age,id,course);
        students.add(student);
        System.out.println("Successfully added an student!");
    }

    //remove
    public void removeStudent(String name){
        Iterator<Student> iterator = students.iterator();

        while(iterator.hasNext()){
            Student s = iterator.next();
            if(s.getName().equals(name)){
                iterator.remove();
            }
        }

        System.out.println("No student removed!");

    }

    // update
    public void updateStudent(int id){
        // find by id
        for(Student s : students){
            if(s.getId() == id){
                System.out.println("Edit " + s.getName() + " - ID:" + s.getId());
                System.out.println("Edit name: ");
                Scanner sc = new Scanner(System.in);
                String name = sc.nextLine();
                System.out.println("Edit age: ");
                int age = sc.nextInt();
                System.out.println("Edit ID: ");
                int newId = sc.nextInt();
                sc.nextLine();
                System.out.println("Edit Course: ");
                String course = sc.nextLine();

                s.setName(name);
                s.setAge(age);
                s.setId(newId);
                s.setCourse(course);

                System.out.println("Student updated!");
                return;
            }
        }

        System.out.println("Student not found!");
    }


    // display
    public void getAllStudent(){
        for(Student s : students){
            System.out.println(s.getName() + " - Age:" + s.getAge() + " - ID:" + s.getId() + " - Course:" + s.getCourse());
        }
    }



}
