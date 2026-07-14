package user;

import course.Course;

import java.util.ArrayList;

public class Teacher extends User{

    ArrayList<Course> courses = new ArrayList<>();
    public ArrayList<Course> getCourses() {
        return courses;
    }

    public Teacher(String id, String name, String email, String password, int age){
        super(id, name, email, password, age, Role.TEACHER);
    }

    public void addCourse(Course course){
        courses.add(course);
    }
}
