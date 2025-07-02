import controller.EnrollmentController;

import java.util.Scanner;

public class ConsoleInputOutput {
    EnrollmentController controller = new EnrollmentController();
    Scanner sc = new Scanner(System.in);

    public void start(){
        while(true){
            System.out.println("--------- Enrollment Management System --------");
            System.out.println("1. Enroll for new course");
            System.out.println("2. Remove a student");
            System.out.println("3. Remove course");
            System.out.println("4. Get all enrolled courses by a student.");
            System.out.println("5. Exit");
            System.out.print("Choice: ");
            int choice = sc.nextInt();

            switch(choice){
                case 1 -> addEnrollment();
                case 2 -> removeEnrollment();
                case 3 -> removeCourse();
                case 4 -> getEnrolled();
                case 5 -> {
                    System.out.println("Exit");
                    return;
                }
                default -> System.out.println("Choose properly");
            }
        }
    }

    private void addEnrollment(){
        sc.nextLine();
        System.out.print("Enter ID: ");
        int id = Integer.parseInt(sc.nextLine());

        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter course: ");
        String course = sc.nextLine();

        controller.add(id,name,course);
    }

    private void removeEnrollment(){
        sc.nextLine();
        System.out.print("Enter ID: ");
        int id = Integer.parseInt(sc.nextLine());
        boolean cond = controller.remove(id);
        if(cond) System.out.println("Removed id");
        else System.out.println("Not possible");
    }

    private void removeCourse(){
        sc.nextLine();
        System.out.print("Enter ID: ");
        int id = Integer.parseInt(sc.nextLine());

        System.out.print("Enter course: ");
        String course = sc.nextLine();
        boolean cond = controller.removeCourse(id,course);
        if(cond) System.out.println("Removed enrolled course");
        else System.out.println("Not possible");
    }

    private void getEnrolled(){
        sc.nextLine();
        System.out.print("Enter ID: ");
        int id = Integer.parseInt(sc.nextLine());
        var list = controller.getCourses(id);
        if(list.isEmpty()){
            System.out.println("No courses");
        }else{
            list.forEach(System.out::println);
        }
    }
}