package model;
import java.util.ArrayList;

public class Enrollment {
    // Student with name and id enrolls to a course with name
    private ArrayList<String> courses;
    private String studentName;
    private int studentId;

    public Enrollment(int studentId,String studentName, ArrayList<String> course){
        this.studentId = studentId;
        this.studentName = studentName;
        this.courses = courses;
    }

    public String getStudentName(){return studentName;}
    public int getStudentId(){return studentId;}
    public ArrayList<String> getCourses(){return courses;}

    @Override
    public String toString(){
        return "ID: " + studentId + "Name: " + studentName + "Courses enrolled: " + courses;
    }

    public String toFileFormat(){
        return studentId + "|" + studentName + "|" + String.join(",",courses);
    }
}
