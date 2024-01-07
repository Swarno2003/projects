import java.util.ArrayList;
import java.util.List;

class Course {
    private String courseCode;
    private String title;
    private String description;
    private int capacity;
    private String schedule;
    private int availableSlots;

    public Course(String courseCode, String title, String description, int capacity, String schedule) {
        this.courseCode = courseCode;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
        this.availableSlots = capacity;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getSchedule() {
        return schedule;
    }

    public int getAvailableSlots() {
        return availableSlots;
    }

    public void decreaseAvailableSlots() {
        if (availableSlots > 0) {
            availableSlots--;
        }
    }
    public void increaseAvailableSlots() {
        if (availableSlots < capacity) {
            availableSlots++;
        }
    }
}

class Student {
    private int studentId;
    private String name;
    private List<Course> registeredCourses;

    public Student(int studentId, String name) {
        this.studentId = studentId;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public int getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public List<Course> getRegisteredCourses() {
        return registeredCourses;
    }

    public void registerCourse(Course course) {
        if (course.getAvailableSlots() > 0) {
            registeredCourses.add(course);
            course.decreaseAvailableSlots();
            System.out.println(name + " has successfully registered for the course: " + course.getTitle());
        } else {
            System.out.println("Sorry, " + name + ". The course " + course.getTitle() + " is full.");
        }
    }

    public void dropCourse(Course course) {
        if (registeredCourses.contains(course)) {
            registeredCourses.remove(course);
            course.increaseAvailableSlots();
            System.out.println(name + " has dropped the course: " + course.getTitle());
        } else {
            System.out.println(name + " is not registered for the course: " + course.getTitle());
        }
    }
}

class CourseRegistrationSystem {
    private List<Course> courseDatabase;
    private List<Student> studentDatabase;

    public CourseRegistrationSystem() {
        this.courseDatabase = new ArrayList<>();
        this.studentDatabase = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courseDatabase.add(course);
    }

    public void addStudent(Student student) {
        studentDatabase.add(student);
    }

    public void displayAvailableCourses() {
        System.out.println("Available Courses:");
        for (Course course : courseDatabase) {
            System.out.println("Course Code: " + course.getCourseCode());
            System.out.println("Title: " + course.getTitle());
            System.out.println("Description: " + course.getDescription());
            System.out.println("Capacity: " + course.getCapacity());
            System.out.println("Schedule: " + course.getSchedule());
            System.out.println("Available Slots: " + course.getAvailableSlots());
            System.out.println("-------------------------");
        }
    }
}

public class CourseAllocation {
    public static void main(String[] args) {
        CourseRegistrationSystem registrationSystem = new CourseRegistrationSystem();

        Course course1 = new Course("CSE101", "Introduction to Computer Science", "Basic concepts of programming", 30, "Mon/Wed/Fri 10:00 AM");
        Course course2 = new Course("MATH201", "Calculus I", "Limits, derivatives, and integrals", 25, "Tue/Thu 2:00 PM");
        registrationSystem.addCourse(course1);
        registrationSystem.addCourse(course2);

        Student student1 = new Student(1, "AMAN KUMAR SINGH");
        Student student2 = new Student(2, "JITENDRA SINGH");
        registrationSystem.addStudent(student1);
        registrationSystem.addStudent(student2);

        registrationSystem.displayAvailableCourses();

        student1.registerCourse(course1);
        student2.registerCourse(course2);

        registrationSystem.displayAvailableCourses();

        student1.dropCourse(course1);

        registrationSystem.displayAvailableCourses();
    }
}
