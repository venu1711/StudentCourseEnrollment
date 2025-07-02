package controller;

import model.Enrollment;
import service.EnrollmentService;

import java.util.ArrayList;

public class EnrollmentController {
    EnrollmentService service = new EnrollmentService();

    public void add(int id,String name,String course){
        Enrollment e = service.findId(id);

        if(e != null){
            if(e.getCourses().contains(course)){
                System.out.println("Already enrolled to " + course);
            }else{
                e.getCourses().add(course);
                System.out.println("Course added to existing student");
                service.saveToFile();
            }
        }else{
            ArrayList<String> newEnrollment = new ArrayList<>();
            newEnrollment.add(course);
            service.add(new Enrollment(id,name,newEnrollment));
        }
    }

    public boolean remove(int id){
        return service.remove(id);
    }

    public boolean removeCourse(int id, String course){
        return service.removeCourse(id,course);
    }

    public ArrayList<String> getCourses(int id){
        return service.getAllCoursesByStudent(id);
    }
}
