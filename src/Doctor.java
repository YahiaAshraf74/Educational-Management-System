import java.util.ArrayList;

public class Doctor extends TeacherAssistant  {
    public static ArrayList<Doctor> listOfAllDoctors = new ArrayList<Doctor>() ;
    public Doctor(String name, String ID, String email, String password) {
        super(name, ID, email, password);
    }
    public boolean CreatNewCourse(Course course) {
        Course.listOfAllCourses.add(course) ;
        return true ;
    }

    public boolean addTeacherAssistant(Course course , String ID) {
        if (course.getTeacherAssistants().contains(ID)){
            return false ;  // The teacher assistant is already exits in the course
        }
        for(TeacherAssistant t : listOfAllTeacherAssistant){
            if (t.getID().equals(ID)){
                course.getTeacherAssistants().add(ID);
                t.getCourses().add(course) ;
                return true ;
            }
        }
        return false;  // The ID was not exits in the list of teacher assistant
    }
    public boolean removeTeacherAssistant(Course course , String ID){
        if (!course.getTeacherAssistants().contains(ID)){
            return false ;  // The teacher assistant is already not exits in the course
        }
        for(TeacherAssistant t : listOfAllTeacherAssistant){
            if (t.getID().equals(ID)){
                course.getTeacherAssistants().remove(ID);
                t.getCourses().remove(course) ;
                return true ;
            }
        }
        return false;  // The ID was not exits in the list of teacher assistant
    }
}
