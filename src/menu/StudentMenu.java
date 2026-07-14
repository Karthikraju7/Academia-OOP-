package menu;

import course.Course;
import course.CourseManager;
import system.UniversitySystem;
import user.Student;

import java.util.Scanner;

public class StudentMenu {

    Scanner sc = new Scanner(System.in);

    CourseManager courseManager;
    UniversitySystem us;

    public StudentMenu(CourseManager courseManager, UniversitySystem us){
        this.courseManager = courseManager;
        this.us = us;
    }

    public void studentMenu(Student student){
        while(true) {
            System.out.println("1. View Profile");
            System.out.println("2. View my Courses");
            System.out.println("3. Join Course");
            System.out.println("4. Drop Course");
            System.out.println("5. University Dashboard");
            System.out.println("6. Logout");

            System.out.println("Choose any no.: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    viewProfile(student);
                    break;
                case 2:
                    viewMyCourses(student);
                    break;
                case 3:
                    courseManager.joinCourse(student);
                    break;
                case 4:
                    courseManager.dropCourse(student);
                    break;
                case 5:
                    us.showDashboard();
                    break;
                case 6:
                    us.logout();
                    return;
                default:
                    System.out.println("Invalid");
            }
        }
    }

    public void viewProfile(Student student){
        System.out.println(student);
    }

    public void viewMyCourses(Student student){
        for (Course course : student.getEnrolledCourses()) {
            System.out.println(course);
        }
    }
}
