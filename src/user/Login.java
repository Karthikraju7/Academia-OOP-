package user;

import menu.StudentMenu;
import menu.TeacherMenu;

import java.util.ArrayList;
import java.util.Scanner;

public class Login {
    ArrayList<Student> students;
    ArrayList<Teacher> teachers;

    public Login(ArrayList<Student> students, ArrayList<Teacher> teachers){
        this.students = students;
        this.teachers = teachers;
    }

    Scanner sc = new Scanner(System.in);

    public User chooseRole(){
        System.out.println("Choose Role:");
        System.out.println("Student");
        System.out.println("Teacher");

        String role = sc.nextLine();
        User loggedinUser = null;
        if(role.equals("Student")){
            loggedinUser = login("Student");
            return loggedinUser;
        }else if(role.equals("Teacher")) {
            loggedinUser = login("Teacher");
            return loggedinUser;
        }else{
            System.out.println("Invalid Choice!");
            return null;
        }
    }

    public User login(String role){
        System.out.println("Enter email: ");
        String email = sc.nextLine();
        System.out.println("Enter Password: ");
        String password = sc.nextLine();
        if (role.equalsIgnoreCase("Student")) {
            for (Student student : students) {
                if (student.getEmail().equals(email)) {
                    if (student.getPassword().equals(password)) {
                        System.out.println("Login Successful");
                        return student;
                    }else{
                        System.out.println("Wrong Password");
                    }
                    return null;
                }
            }
            System.out.println("Invalid email");
        }else{
            for(Teacher teacher: teachers){
                if(teacher.getEmail().equals(email)){
                    if(teacher.getPassword().equals(password)){
                        System.out.println("Login Successful");
                        return teacher;
                    }else{
                        System.out.println("Wrong Password");
                    }
                    return null;
                }
            }
            System.out.println("Invalid email");
        }
        return null;
    }
}
