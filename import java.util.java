import java.util.ArrayList;
import java.util.Scanner;


public class StudentGradeTracker {

    // Lists to store student names and grades
    private static ArrayList<String> studentNames = new ArrayList<>();
    private static ArrayList<Integer> studentGrades = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("Welcome Student Grade Tracker!");

        // Main program loop
        do {
            displayMenu();
            while (!scanner.hasNextInt()) {
                System.out.println("Please enter a number from 1 to 5.");
                scanner.next(); // Clear invalid input
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    addStudent(scanner);
                    break;
                case 2:
                    displayStudents();
                    break;
                case 3:
                    calculateAverage();
                    break;
                case 4:
                    searchStudent(scanner);
                    break;
                case 5:
                    System.out.println("Exiting. Thank you!");
                    break;
                default:
                    System.out.println("Please select between 1 and 5.");
            }
        } while (choice != 5);

        scanner.close();
    }

    // Display menu options
    private static void displayMenu() {
        System.out.println("\nWhat would you like to do?");
        System.out.println("1. Add new student and grade");
        System.out.println("2. Display students and their grades");
        System.out.println("3. Calculate average grade for the subject");
        System.out.println("4. Search for a student and grade");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    // Add a new student and grade
    private static void addStudent(Scanner scanner) {
        System.out.print("Enter student's name: ");
        String name = scanner.nextLine();

        int grade;
        while (true) {
            System.out.print("Enter " + name + "'s grade: ");
            if (scanner.hasNextInt()) {
                grade = scanner.nextInt();
                if (grade >= 0 && grade <= 100) {
                    break;
                } else {
                    System.out.println("Grade must be between 0 and 100.");
                }
            } else {
                System.out.println("Please enter a number.");
            }
            scanner.nextLine(); // Clear invalid input
        }
        scanner.nextLine(); // Clear newline

        studentNames.add(name);
        studentGrades.add(grade);
        System.out.println(name + "'s grade has been added successfully.");
    }

    // Display all students and their grades
    private static void displayStudents() {
        if (studentNames.isEmpty()) {
            System.out.println("No students have been added yet.");
            return;
        }

        System.out.println("List of students and grades:");
        for (int i = 0; i < studentNames.size(); i++) {
            System.out.println((i + 1) + ". " + studentNames.get(i) + " - " + studentGrades.get(i));
        }
    }

    // Calculate and display the average grade
    private static void calculateAverage() {
        if (studentGrades.isEmpty()) {
            System.out.println("No grades available to calculate average.");
            return;
        }

        int sum = 0;
        for (int grade : studentGrades) {
            sum += grade;
        }
        double average = (double) sum / studentGrades.size();
        System.out.printf("Average grade for the subject: %.2f%n", average);
    }

    // Search for a student and display their grade
    private static void searchStudent(Scanner scanner) {
        System.out.print("Enter student's name to search: ");
        String nameToSearch = scanner.nextLine();

        boolean found = false;
        for (int i = 0; i < studentNames.size(); i++) {
            if (studentNames.get(i).equalsIgnoreCase(nameToSearch)) {
                System.out.println(studentNames.get(i) + "'s grade: " + studentGrades.get(i));
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student not found.");
        }
    }
}
