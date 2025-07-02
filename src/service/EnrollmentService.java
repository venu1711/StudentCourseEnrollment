package service;

import model.Enrollment;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class EnrollmentService {
    public ArrayList<Enrollment> enrolled= new ArrayList<>();
    private static String fileName = "courses.txt";

    public EnrollmentService(){
        loadFromFile();
    }

    public void add(Enrollment e){
        enrolled.add(e);
        saveToFile();
    }

    public boolean remove(int id){
        Iterator<Enrollment> itr = enrolled.iterator();
        while(itr.hasNext()){
            Enrollment e =itr.next();
            if(e.getStudentId() == id){
                itr.remove();
                saveToFile();
                return true;
            }
        }
        return false;
    }

//  ****************CHECK WITH CHATGPT FIRST************
    public boolean removeCourse(int id, String course){
        Enrollment e = findId(id);
        if(e != null){
            if(e.getCourses().contains(course)){
                e.getCourses().remove(course);

                if(e.getCourses().isEmpty()){
                    remove(id);
                }else{
                    saveToFile();
                }
            }
            return true;
        }
        return false;
    }

    public ArrayList<String> getAllCoursesByStudent(int id){
        Iterator<Enrollment> itr = enrolled.iterator();
        while(itr.hasNext()){
            Enrollment e =itr.next();
            if(e.getStudentId() == id){
                return e.getCourses();
            }
        }
        return new ArrayList<>();
    }

    private void loadFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            enrolled.clear();
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 3) {
                    int id = Integer.parseInt(parts[0].trim());
                    String name = parts[1].trim();
                    ArrayList<String> courses = new ArrayList<>();
                    if (!parts[2].trim().isEmpty()) {
                        String[] courseArray = parts[2].split(",");
                        for (String course : courseArray) {
                            courses.add(course.trim());
                        }
                    }
                    enrolled.add(new Enrollment(id, name, courses));
                }
            }
        } catch (IOException e) {
            System.out.println("File loading error: " + e.getMessage());
        }
    }


    public void saveToFile(){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (Enrollment s : enrolled) {
                bw.write(s.toFileFormat());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Failed to save to file.");
        }
    }

    public Enrollment findId(int id){
        for(Enrollment e : enrolled){
            if(e.getStudentId() == id){
                return e;
            }
        }
        return null;
    }
}