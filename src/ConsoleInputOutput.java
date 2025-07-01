import controller.EnrollmentController;

import java.util.Scanner;

public class ConsoleInputOutput {
    EnrollmentController controller = new EnrollmentController();
    Scanner sc = new Scanner(System.in);

    public void start(){
        while(true){
            System.out.println("--------- Enrollment Management System --------");
            System.out.println("1. Enroll for new course");
            System.out.println("2. Remove a course");
            System.out.println("3. Get all enrolled courses by a student.");
            System.out.print("Choice: ");
            int choice = sc.nextInt();

            switch(choice){
                case 1 -> addEnrollment();
                case 2 -> removeEnrollment();
                case 3 -> getEnrolled();
                case 4 -> {
                    System.out.println("Choose properly");
                    return;
                }
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
}