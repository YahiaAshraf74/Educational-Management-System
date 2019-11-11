import java.util.ArrayList;

public class TeacherAssistant extends Person {
    public static ArrayList<TeacherAssistant> listOfAllTeacherAssistant = new ArrayList<TeacherAssistant>() ;
    public TeacherAssistant(String name, String ID, String email, String password) {
        super(name, ID, email, password);
    }
    public boolean addSlide(Course course , String slide){
        if (course.getSlides().contains(slide)){
            return false ;  // The Slide is already exists
        }
        course.getSlides().add(slide);
        return true;     // successful added
    }
    public boolean removeSlide(Course course ,String slide){
        if (!course.getSlides().contains(slide)){
            return false ;  // The Slide is already not exists
        }
        course.getSlides().remove(slide);
        return true;    // successful removed
    }
    public boolean addAssignment(Course course , Assignment assignment){
        if (course.getAssignments().contains(assignment)){
            return false ;  // The Assignment is already exists
        }
        course.getAssignments().add(assignment);
        return true;    // successful added
    }
    public boolean removeAssignment(Course course, Assignment assignment){
        if (!course.getAssignments().contains(assignment)){
            return false ;  // The Assignment is already not exists
        }
        course.getAssignments().add(assignment);
        return true;    // successful removed
    }
    @Override
    public boolean addCourse(Course course) {
        if(!super.addCourse(course)){
            return false ;
        }
        //super.addCourse(course) ;
        course.getTeacherAssistants().add(getID()) ;
        return true ; // successful added
    }
    @Override
    public boolean removeCourse(Course course) {
        if(!super.removeCourse(course)){
            return false ;
        }
        super.removeCourse(course) ;
        course.getTeacherAssistants().remove(getID()) ;
        return true ; // successful added
    }

}
