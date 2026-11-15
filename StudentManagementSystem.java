import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private int studentId;
    private String name;
    private int age;
    private String course;

    public Student(int studentId, String name, int age, String course) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.course = course;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void displayStudent() {
        System.out.println("ID      : " + studentId);
        System.out.println("Name    : " + name);
        System.out.println("Age     : " + age);
        System.out.println("Course  : " + course);
        System.out.println("-------------------------");
    }
}

public class StudentManagementSystem {

    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    // Helper: find a student by ID, returns null if not found
    public static Student findStudent(int id) {
        for (Student s : students) {
            if (s.getStudentId() == id) {
                return s;
            }
        }
        return null;
    }

    public static void addStudent() {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        // Check: Student ID must be unique
        if (findStudent(id) != null) {
            System.out.println("A student with this ID already exists!");
            return;
        }

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        // Check: Name cannot be empty
        if (name.trim().isEmpty()) {
            System.out.println("Name cannot be empty!");
            return;
        }

        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        // Check: Age must be positive
        if (age <= 0) {
            System.out.println("Age must be a positive number!");
            return;
        }

        System.out.print("Enter Course: ");
        String course = sc.nextLine();

        // Check: Course cannot be empty
        if (course.trim().isEmpty()) {
            System.out.println("Course cannot be empty!");
            return;
        }

        students.add(new Student(id, name, age, course));
        System.out.println("Student added successfully!");
    }

    public static void searchStudent() {
        System.out.print("Enter Student ID to search: ");
        int id = sc.nextInt();

        Student s = findStudent(id);

        if (s != null) {
            System.out.println("\nStudent Found:");
            s.displayStudent();
        } else {
            System.out.println("Student not found!");
        }
    }

    public static void updateStudent() {
        System.out.print("Enter Student ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        Student s = findStudent(id);

        // Check: Student must exist before updating
        if (s == null) {
            System.out.println("Student not found!");
            return;
        }

        System.out.println("\nCurrent Details:");
        s.displayStudent();

        System.out.print("Enter New Name: ");
        String name = sc.nextLine();

        if (name.trim().isEmpty()) {
            System.out.println("Name cannot be empty!");
            return;
        }

        System.out.print("Enter New Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        if (age <= 0) {
            System.out.println("Age must be a positive number!");
            return;
        }

        System.out.print("Enter New Course: ");
        String course = sc.nextLine();

        if (course.trim().isEmpty()) {
            System.out.println("Course cannot be empty!");
            return;
        }

        s.setName(name);
        s.setAge(age);
        s.setCourse(course);

        System.out.println("Student updated successfully!");
    }

    public static void deleteStudent() {
        System.out.print("Enter Student ID to delete: ");
        int id = sc.nextInt();

        Student s = findStudent(id);

        if (s != null) {
            students.remove(s);
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("Student not found!");
        }
    }

    public static void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No student records available.");
            return;
        }

        System.out.println("\n----- Student Records -----");
        for (Student s : students) {
            s.displayStudent();
        }
    }

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. Search Student");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Display All Students");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    searchStudent();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    displayStudents();
                    break;
                case 6:
                    System.out.println("Thank you for using the system.");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 6);

        sc.close();
    }
}
