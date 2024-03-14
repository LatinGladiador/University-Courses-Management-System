import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

//Main class that manages the university course system
public class Main {
    //Map data structures for current courses, students and professors
    private static Map<Integer, Course> courses;
    private static Map<Integer, Student> students;
    private static Map<Integer, Professor> professors;
    private static final Scanner SCANNER = new Scanner(System.in);
    //Constants for types and ids
    private static final int STUDENT_TYPE = 1;
    private static final int COURSE_TYPE = 0;
    //Constants for specific course ids
    private static final int PYTHON_BASICS_COURSE_ID = 3;
    private static final int ALGORITHMS_COURSE_ID = 4;
    private static final int ADVANCED_PROGRAMMING_COURSE_ID = 5;
    private static final int MATH_ANALYSIS_COURSE_ID = 6;
    private static final int COMPUTER_VISION_COURSE_ID = 7;
    private static final int STUDENT_ALEX_ID = 3;
    private static final int PROFESSOR_ALI_ID = 4;
    private static final int PROFESSOR_AHMED_ID = 5;
    private static final int PROFESSOR_ANDREY_ID = 6;

    //Constructor for the main class
    public Main() {
        this.courses = new HashMap<>();
        this.students = new HashMap<>();
        this.professors = new HashMap<>();
    }

    //Method to get the next line of input
    private String getNextLine() {
        String input;
        if (!SCANNER.hasNextLine()) {
            System.out.println("Wrong inputs");
            System.exit(0);
        }
        input = SCANNER.nextLine().toLowerCase();
        return input;
    }

    //Method to check if a name is valid for a given type
    private boolean isValidName(String name, int type) {
        if (
                name.equals("course")
                        || name.equals("student")
                        || name.equals("professor")
                        || name.equals("enroll")
                        || name.equals("drop")
                        || name.equals("exempt")
                        || name.equals("teach")
        ) {
            return false;
        }
        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            if (!(c >= 'a' && c <= 'z')) {
                if (type == 0 && c == '_') {
                    if (i == 0 || i == name.length() - 1) {
                        return false;
                    }
                    if (name.charAt(i + 1) == '_' || name.charAt(i - 1) == '_') {
                        return false;
                    }
                    continue;
                }
                return false;
            }
        }
        return true;
    }

    //Method to read course name from input
    private String readCourseName() {
        String courseName = getNextLine().toLowerCase();
        if (!isValidName(courseName, 0)) {
            System.out.println("Wrong inputs");
            System.exit(0);
        }
        return courseName;
    }

    //Method to read the member name from input
    private String readMemberName() {
        String memberName = getNextLine().toLowerCase();
        if (!isValidName(memberName, 1)) {
            System.out.println("Wrong inputs");
            System.exit(0);
        }
        return memberName;
    }

    //Method to read the course level fron input
    private CourseLevel readCourseLevel() {
        String courseLevelName = getNextLine().toLowerCase();
        CourseLevel courseLevel;
        switch (courseLevelName) {
            case "bachelor":
                courseLevel = CourseLevel.BACHELOR;
                break;
            case "master":
                courseLevel = CourseLevel.MASTER;
                break;
            default:
                System.out.println("Wrong inputs");
                System.exit(0);
                return null; // Added return statement to handle compilation error
        }
        return courseLevel;
    }

    //Method to read and id from input
    private int readId() {
        String idString = getNextLine();
        int id = 0;
        try {
            id = Integer.parseInt(idString);
        } catch (Exception e) {
            System.out.println("Wrong inputs");
            System.exit(0);
        }
        return id;
    }

    //Method to add a new course to the system
    private void addCourse() {
        String courseName = readCourseName();
        for (Course course : courses.values()) {
            if (courseName.equals(course.getCourseName())) {
                System.out.println("Course exists");
                System.exit(0);
            }
        }
        CourseLevel courseLevel = readCourseLevel();
        Course course = new Course(courseName, courseLevel);
        courses.put(course.getCourseId(), course);
        System.out.println("Added successfully");
    }

    //Method to add a new student to the system
    private void addStudent() {
        String memberName = readMemberName();
        Student student = new Student(memberName);
        students.put(student.getMemberId(), student);
        System.out.println("Added successfully");
    }

    //Method to add a new professor to the system
    private void addProfessor() {
        String memberName = readMemberName();
        Professor professor = new Professor(memberName);
        professors.put(professor.getMemberId(), professor);
        System.out.println("Added successfully");
    }

    //method to enroll a student in a course
    private void enrollStudent() {
        int studentId = readId();

        Enrollable student = students.get(studentId);
        if (student == null) {
            System.out.println("Wrong inputs");
            System.exit(0);
        }
        int courseId = readId();
        Course course = courses.get(courseId);

        if (course == null) {
            System.out.println("Wrong inputs");
            System.exit(0);
        }

        if (student.enroll(course)) {
            System.out.println("Enrolled successfully");
        } else {
            System.exit(0);
        }
    }

    //Method to drop a student from a course
    public final void dropStudent() {
        int studentId = readId();

        Enrollable student = students.get(studentId);
        if (student == null) {
            System.out.println("Wrong inputs");
            System.exit(0);
        }
        int courseId = readId();
        Course course = courses.get(courseId);

        if (course == null) {
            System.out.println("Wrong inputs");
            System.exit(0);
        }

        if (student.drop(course)) {
            System.out.println("Dropped successfully");
        } else {
            System.exit(0);
        }
    }

    //Method to assign a professor to teach a course
    public final void assignProfessor() {
        int professorId = readId();

        Professor professor = professors.get(professorId);
        if (professor == null) {
            System.out.println("Wrong inputs");
            System.exit(0);
        }
        int courseId = readId();
        Course course = courses.get(courseId);

        if (course == null) {
            System.out.println("Wrong inputs");
            System.exit(0);
        }

        if (professor.teach(course)) {
            System.out.println("Professor is successfully assigned to teach this course");
        } else {
            System.exit(0);
        }
    }

    //Method to exempt a professor from teaching a course
    public final void exemptProfessor() {
        int professorId = readId();

        Professor professor = professors.get(professorId);
        if (professor == null) {
            System.out.println("Wrong inputs");
            System.exit(0);
        }
        int courseId = readId();
        Course course = courses.get(courseId);

        if (course == null) {
            System.out.println("Wrong inputs");
            System.exit(0);
        }

        if (professor.exempt(course)) {
            System.out.println("Professor is exempted");
        } else {
            System.exit(0);
        }
    }

    //Main method to run the program
    public static final void main(String[] args) {
        Main cms = new Main();
        fillInitialData();

        String line;
        while (SCANNER.hasNextLine()) {
            line = SCANNER.nextLine();
            if (line.isEmpty()) {
                break; // Stop execution on an empty line
            }

            String command = line.toLowerCase();

            switch (command) {
                case "course":
                    cms.addCourse();
                    break;
                case "student":
                    cms.addStudent();
                    break;
                case "professor":
                    cms.addProfessor();
                    break;
                case "enroll":
                    cms.enrollStudent();
                    break;
                case "drop":
                    cms.dropStudent();
                    break;
                case "teach":
                    cms.assignProfessor();
                    break;
                case "exempt":
                    cms.exemptProfessor();
                    break;
                default:
                    System.out.println("Wrong inputs");
                    System.exit(0);
            }
        }
        SCANNER.close();
    }

    //Method to fill initial data for testing
    public static void fillInitialData() {
        courses.put(1, new Course("java_beginner", CourseLevel.BACHELOR));
        courses.put(2, new Course("java_intermediate", CourseLevel.BACHELOR));
        courses.put(PYTHON_BASICS_COURSE_ID, new Course("python_basics", CourseLevel.BACHELOR));
        courses.put(ALGORITHMS_COURSE_ID, new Course("algorithms", CourseLevel.MASTER));
        courses.put(ADVANCED_PROGRAMMING_COURSE_ID, new Course("advanced_programming", CourseLevel.MASTER));
        courses.put(MATH_ANALYSIS_COURSE_ID, new Course("mathematical_analysis", CourseLevel.MASTER));
        courses.put(COMPUTER_VISION_COURSE_ID, new Course("computer_vision", CourseLevel.MASTER));

        Student student = new Student("Alice");
        students.put(1, student);
        Enrollable enrollable = student;
        enrollable.enroll(courses.get(1));
        enrollable.enroll(courses.get(2));
        enrollable.enroll(courses.get(PYTHON_BASICS_COURSE_ID));

        student = new Student("Bob");
        students.put(2, student);
        enrollable = student;
        enrollable.enroll(courses.get(1));
        enrollable.enroll(courses.get(ALGORITHMS_COURSE_ID));

        student = new Student("Alex");
        enrollable = student;
        students.put(STUDENT_ALEX_ID, student);
        enrollable.enroll(courses.get(ADVANCED_PROGRAMMING_COURSE_ID));

        Professor professor = new Professor("Ali");
        professors.put(PROFESSOR_ALI_ID, professor);
        professor.teach(courses.get(1));
        professor.teach(courses.get(2));

        professor = new Professor("Ahmed");
        professors.put(PROFESSOR_AHMED_ID, professor);
        professor.teach(courses.get(PYTHON_BASICS_COURSE_ID));
        professor.teach(courses.get(ADVANCED_PROGRAMMING_COURSE_ID));

        professor = new Professor("Andrey");
        professors.put(PROFESSOR_ANDREY_ID, professor);
        professor.teach(courses.get(MATH_ANALYSIS_COURSE_ID));
    }
}

//Enumeration for the course level
enum CourseLevel {
    BACHELOR("bachelor"),
    MASTER("master");
    private final String courseLevelName;

    CourseLevel(String courseLevelName) {
        this.courseLevelName = courseLevelName;
    }

    public String getCourseLevelName() {
        return courseLevelName;
    }
}

//Class representing a university course
class Course {
    private static int numberOfCourses = 0;
    private final int courseId;
    private final String courseName;
    private final CourseLevel courseLevel;
    private final List<Student> enrolledStudents;
    private static final int CAPACITY = 3;

    public Course(String courseName, CourseLevel courseLevel) {
        this.courseId = ++numberOfCourses;
        this.courseName = courseName;
        this.courseLevel = courseLevel;
        this.enrolledStudents = new ArrayList<>();
    }

    public int getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public CourseLevel getCourseLevel() {
        return courseLevel;
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public boolean isFull() {
        return enrolledStudents.size() >= CAPACITY;
    }
}

//Abstract class representing a university member
abstract class UniversityMember {
    private static int numberOfMembers = 0;
    private final int memberId;
    private final String memberName;

    public UniversityMember(String memberName) {
        this.memberId = ++numberOfMembers;
        this.memberName = memberName.toLowerCase();
    }

    public int getMemberId() {
        return memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public static int getNumberOfMembers() {
        return numberOfMembers;
    }
}

//interface for members that can be enrolled in courses
interface Enrollable {
    boolean drop(Course course);
    boolean enroll(Course course);
}

//Class representing a student
class Student extends UniversityMember implements Enrollable {
    private static final int MAX_ENROLLMENT = 3;
    private final List<Course> enrolledCourses;

    //Constructor for the Student class
    public Student(String memberName) {
        super(memberName);
        this.enrolledCourses = new ArrayList<>();
    }

    //Getter for the list enrolled courses
    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    //Method to enroll the student in a course
    public boolean enroll(Course course) {
        if (getEnrolledCourses().contains(course)) {
            System.out.println("Student is already enrolled in this course");
            return false;
        } else if (getEnrolledCourses().size() >= MAX_ENROLLMENT) {
            System.out.println("Maximum enrollment is reached for the student");
            return false;
        } else if (course.isFull()) {
            System.out.println("Course is full");
            return false;
        }
        enrolledCourses.add(course);
        course.getEnrolledStudents().add(this);
        return true;
    }

    //Method to drop the student from a course
    public boolean drop(Course course) {
        if (!getEnrolledCourses().contains(course)) {
            System.out.println("Student is not enrolled in this course");
            return false;
        }
        enrolledCourses.remove(course);
        course.getEnrolledStudents().remove(this);
        return true;
    }

    //Static method to get the maximum enrollment allowed for a student
    public static int getMaxEnrollment() {
        return MAX_ENROLLMENT;
    }
}

//Class representing a professor, extending UniversityMember
class Professor extends UniversityMember {
    private static final int MAX_LOAD = 2;
    private final List<Course> assignedCourses;

    //Constructor for the Professor class
    public Professor(String memberName) {
        super(memberName);
        this.assignedCourses = new ArrayList<>();
    }

    //Getter for the list of assigned courses
    public List<Course> getAssignedCourses() {
        return assignedCourses;
    }

    //Method to assign a course for the professor to teach
    public boolean teach(Course course) {
        if (getAssignedCourses().size() >= MAX_LOAD) {
            System.out.println("Professor's load is complete");
            return false;
        } else if (getAssignedCourses().contains(course)) {
            System.out.println("Professor is already teaching this course");
            return false;
        }
        assignedCourses.add(course);
        return true;
    }

    //Method to exempt a professor from teaching a course
    public boolean exempt(Course course) {
        if (!getAssignedCourses().contains(course)) {
            System.out.println("Professor is not teaching this course");
            return false;
        }
        assignedCourses.remove(course);
        return true;
    }

    //Static method to get the maximum course load allowed for a professor
    public static int getMaxLoad() {
        return MAX_LOAD;
    }
}
