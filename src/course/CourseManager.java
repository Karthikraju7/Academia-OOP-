package course;

import user.Student;
import user.Teacher;

import java.util.ArrayList;
import java.util.Scanner;

public class CourseManager {
    static int courseCount = 0;
    Scanner sc = new Scanner(System.in);
    ArrayList<Course> courses;

    public CourseManager(ArrayList<Course> courses){
        this.courses = courses;
    }

    public void createCourse(Teacher assignedTeacher){
        int id = courseCount;
        courseCount++;

        System.out.println("Enter Course Name: ");
        String name = sc.nextLine();
        System.out.println("Enter Max. Capacity: ");
        int capacity = sc.nextInt();
        sc.nextLine();

        Course course = new Course(id, name, assignedTeacher, capacity);
        courses.add(course);
        assignedTeacher.addCourse(course);
    }

    public void joinCourse(Student student) {

        System.out.println("Enter Course id: ");
        int id = sc.nextInt();
        sc.nextLine();
        for(Course c: courses){
            if(c.getId() == id){
                c.addStudent(student);
                student.addCourse(c);
                break;
            }
        }
    }

    public void deleteCourse(Teacher teacher) {

        System.out.println("===== Your Courses =====");
        for (Course course : teacher.getCourses()) {
            System.out.println("ID: " + course.getId() +
                    "  Name: " + course.getName());
        }
        System.out.print("Enter Course ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        Course course = null;
        for (Course c : teacher.getCourses()) {
            if (c.getId() == id) {
                course = c;
                break;
            }
        }
        if (course == null) {
            System.out.println("Course not found!");
            return;
        }
        courses.remove(course);
        teacher.getCourses().remove(course);
        for (Student student : course.getEnrolledStudents()) {
            student.getEnrolledCourses().remove(course);
        }
        System.out.println("Course deleted successfully!");
    }

    public void dropCourse(Student student) {
        System.out.println("===== Your Enrolled Courses =====");
        for (Course course : student.getEnrolledCourses()) {
            System.out.println("ID: " + course.getId() +
                    "  Name: " + course.getName());
        }
        System.out.print("Enter Course ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        Course course = null;
        for (Course c : student.getEnrolledCourses()) {
            if (c.getId() == id) {
                course = c;
                break;
            }
        }
        if (course == null) {
            System.out.println("Course not found!");
            return;
        }
        student.getEnrolledCourses().remove(course);
        course.getEnrolledStudents().remove(student);

        System.out.println("Course dropped successfully!");
    }
}