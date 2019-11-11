import java.util.ArrayList;

public class Course {
    private String name ;
    private String code ;
    private Doctor doctor ;
    private ArrayList<String> teacherAssistants = new ArrayList<String>() ;
    private ArrayList<String> students = new ArrayList<String>() ;
    private ArrayList<String> slides = new ArrayList<String>() ;
    private ArrayList<Assignment> assignments = new ArrayList<Assignment>() ;
    public static ArrayList<Course> listOfAllCourses = new ArrayList<Course>() ;

    public Course(String name, String code ,Doctor doctor ) {
        this.name = name;
        this.code = code;
        this.doctor  = doctor ;
        doctor.getCourses().add(this);
    }
    public ArrayList<String> getTeacherAssistants() {
        return teacherAssistants;
    }
    public ArrayList<String> getSlides() {
        return slides;
    }
    public ArrayList<Assignment> getAssignments() {
        return assignments;
    }
    public ArrayList<String> getStudents() {
        return students;
    }
    public void printBasicDetails(){
        System.out.print("Course Name: " + name + "\tCode: " + code);
    }
    public void printAllDetails(){
        printBasicDetails();
        System.out.println("This course teaches by Dr."+ doctor.getName() + "\nTeacher Assistants:");
        for(String name : teacherAssistants){
            System.out.print("\tEng." + name);
        }
        System.out.println("This course have " + assignments.size() + " Assignments");
    }
}
