package system;

import course.Course;
import course.CourseManager;
import menu.StudentMenu;
import menu.TeacherMenu;
import user.*;

import java.util.ArrayList;
import java.util.Scanner;

public class UniversitySystem {

    Scanner sc = new Scanner(System.in);

    ArrayList<Student> students = new ArrayList<>();
    ArrayList<Teacher> teachers = new ArrayList<>();
    ArrayList<Course> courses = new ArrayList<>();

    Register register = new Register(students, teachers);
    Login login = new Login(students, teachers);
    CourseManager courseManager = new CourseManager(courses);
    StudentMenu studentMenu = new StudentMenu(courseManager, this);
    TeacherMenu teacherMenu = new TeacherMenu(courseManager, this);

    public void welcome(){
        while(true) {
            System.out.println("Welcome");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("Choose 1 or 2: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    register.chooseRole();
                    break;
                case 2:
                    User user = login.chooseRole();
                    if (user instanceof Student) {
                        studentMenu.studentMenu((Student) user);
                    } else if (user instanceof Teacher) {
                        teacherMenu.teacherMenu((Teacher) user);
                    }
                    break;
                default:
                    System.out.println("Invalid Choice");
            }
        }
    }

    public void showDashboard(){
        System.out.println("===Students===");
        for(Student student: students){
            System.out.println(student.getId() + "-" + student.getName());
        }
        System.out.println("===Teachers===");
        for(Teacher teacher: teachers){
            System.out.println(teacher.getId() + "-" + teacher.getName());
        }
        System.out.println("===Courses===");
        for(Course course: courses){
            System.out.println(course.getId() + "-" + course.getName());
        }
    }

    public void logout(){
        System.out.println("Logged out successfully!");
    }
}
