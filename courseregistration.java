package assignments;
import java.util.ArrayList;
import java.util.Scanner;

class courseregistration {
    String studentName;
    ArrayList<String> courses = new ArrayList<>();

    void setStudentName(String name) {
        studentName = name;
    }

    void registerCourse(String course) {
        courses.add(course);
    }

    void showCourses() {
        System.out.println("Student: " + studentName);
        System.out.println("Registered Courses:");
        for (String c : courses) {
            System.out.println("- " + c);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        courseregistration cr = new courseregistration();

        System.out.print("Enter student name: ");
        String name = sc.nextLine();
        cr.setStudentName(name);

        while (true) {
            System.out.print("Enter course to register (or type 'done' to finish): ");
            String course = sc.nextLine();
            if (course.equalsIgnoreCase("done")) {
                break;
            }
            cr.registerCourse(course);
        }

        cr.showCourses();
        System.out.println("sakthisudar p");
    }
}
