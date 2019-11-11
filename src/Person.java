import java.util.ArrayList;

public class Person {
    private String name ;
    private String ID ; 
    private String email ;
    private String password;
    private ArrayList<Course> courses = new ArrayList<Course>() ;

    public Person(String name, String ID, String email, String password) {
        this.name = name;
        this.ID = ID;
        this.email = email;
        this.password = password;
    }
    public void listOfCourseRegistered(){
        int count = 1 ;
        for (Course c :courses) {
            System.out.println(count++ + ") ");
            c.printBasicDetails() ;
        }
    }
    public void listOfCourseNotRegistered(){
        int count = 1 ;
        for(Course c : Course.listOfAllCourses){
            if (!courses.contains(c)){
                System.out.print(count++ + ") ");
                c.printBasicDetails();
            }
        }
    }
    public void viewCourse(Course course){
        course.printAllDetails();
    }
    public boolean showSlide(Course course, int num){
        if (num < 1 || num > course.getSlides().size()) {
            return false;
        }
        System.out.println(course.getSlides().get(num-1));
        return true;
    }
    public boolean addCourse(Course course){
        if(!Course.listOfAllCourses.contains(course) ){
            return false ;
        }
        courses.add(course) ;
        return true ;
    }
    public boolean removeCourse(Course course) {
        if (!courses.contains(course) || !Course.listOfAllCourses.contains(course)){
            return false ; // you already not register in this course || the course was not exist
        }
        courses.remove(course) ;
        return true; // successful removed
    }

    public String getName() {
        return name;
    }

    public String getID() {
        return ID;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }
}
