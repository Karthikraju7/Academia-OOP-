package menu;

import course.Course;
import course.CourseManager;
import system.UniversitySystem;
import user.Teacher;

import java.util.Scanner;

public class TeacherMenu {
    Scanner sc = new Scanner(System.in);
    CourseManager courseManager;
    UniversitySystem us;

    public TeacherMenu(CourseManager courseManager, UniversitySystem us){
        this.courseManager = courseManager;
        this.us = us;
    }

    public void teacherMenu(Teacher teacher){
        while(true) {
            System.out.println("1. View Profile");
            System.out.println("2. View my Courses");
            System.out.println("3. Create Course");
            System.out.println("4. Delete Course");
            System.out.println("5. University Dashboard");
            System.out.println("6. Logout");

            System.out.println("Choose any no.: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    viewProfile(teacher);
                    break;
                case 2:
                    viewMyCourses(teacher);
                    break;
                case 3:
                    courseManager.createCourse(teacher);
                    break;
                case 4:
                    courseManager.deleteCourse(teacher);
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

    public void viewProfile(Teacher teacher){
        System.out.println(teacher);
    }

    public void viewMyCourses(Teacher teacher){
        for(Course course: teacher.getCourses()){
            System.out.println(course);
        }
    }
}
