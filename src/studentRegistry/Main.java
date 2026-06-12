package studentRegistry;

public class Main{

    public void main(){
        StudentManagement sm = new StudentManagement();
        sm.addStudent("Joel", 20, 01,"BS");
        sm.addStudent("Test", 21, 02, "BS");
        sm.getAllStudent();
        sm.removeStudent("Joel");
        sm.getAllStudent();
    }

}