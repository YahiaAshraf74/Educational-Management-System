import java.util.ArrayList;

public class Student extends Person {
    public static ArrayList<Student> listOfAllStudent = new ArrayList<Student>() ;
    public Student(String name, String ID, String email, String password) {
        super(name, ID, email, password);
    }

    @Override
    public boolean addCourse(Course course) {
        if(!super.addCourse(course)){
            return false ;
        }
        super.addCourse(course) ;
        course.getStudents().add(getID()) ;
        return true ; // successful added
    }
    @Override
    public boolean removeCourse(Course course) {
        if(!super.removeCourse(course)){
            return false ;
        }
        super.removeCourse(course) ;
        course.getStudents().remove(getID()) ;
        return true ; // successful added
    }
    public void submitSolution(Assignment assignment , String solution){
        assignment.getSolutions().add(new Solution(solution , getID())) ;
    }
    public void listOfAssignment(Course course){
        for (int i = 0 ; i < course.getAssignments().size() ; i++){
            Assignment assignment = course.getAssignments().get(i) ;
            boolean solutionExist = false ;
            int solutionCorrected = -1;
            String commentForSolution ;
            System.out.print("Assignments " + i+1 + "have " + assignment.getGrade() + " -Grade,");
            for(Solution s : assignment.getSolutions()){
                if (s.getID().equals(this.getID())){
                    solutionExist = true ;
                    solutionCorrected = s.getGreadForSolution() ;
                    commentForSolution  = s.getCommentForSolution() ;
                }
            }
            if (!solutionExist){
                System.out.println("You not submit yet");
            }else if (solutionExist && solutionCorrected == -1){
                System.out.println("You submit but the solution not corrected yet");
            }else {
                System.out.println("You already submitted solution and get " + solutionCorrected + "/" + assignment.getGrade());
            }
        }
    }
    /*public void gradesReport(){
        for(Course c : getCourses()){
            c.printBasicDetails();
            c.getAssignments();
        }
    }*/
}
