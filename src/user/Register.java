package user;

import java.util.ArrayList;
import java.util.Scanner;

public class Register {
    static int studentCount = 0;
    static int teacherCount = 0;
    ArrayList<Student> students;
    ArrayList<Teacher> teachers;
    Scanner sc = new Scanner(System.in);

    public Register(ArrayList<Student> students, ArrayList<Teacher> teachers){
        this.students = students;
        this.teachers = teachers;
    }

    public void chooseRole(){
        System.out.println("Choose Role:");
        System.out.println("Student");
        System.out.println("Teacher");

        String role = sc.nextLine();

        if(role.equalsIgnoreCase("Student")){
            registerStudent();
        }else if(role.equalsIgnoreCase("Teacher")) {
            registerTeacher();
        }else{
            System.out.println("Invalid Choice!");
        }
    }

    public void registerStudent(){
        studentCount++;
        String id = "S" + studentCount;

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.println("Enter Email: ");
        String email = sc.nextLine();

        System.out.println("Enter Password: ");
        String password = sc.nextLine();

        System.out.println("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        Student student = new Student(id, name, email, password, age);
        students.add(student);
        System.out.println("Student Registered Successfully!");
    }

    public void registerTeacher(){
        teacherCount++;
        String id = "T" + teacherCount;

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.println("Enter Email: ");
        String email = sc.nextLine();

        System.out.println("Enter Password: ");
        String password = sc.nextLine();

        System.out.println("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        Teacher teacher = new Teacher(id, name, email, password, age);
        teachers.add(teacher);
        System.out.println("Teacher Registered Successfully!");
    }
}
