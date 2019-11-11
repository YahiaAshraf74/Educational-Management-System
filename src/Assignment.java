import java.util.ArrayList;

public class Assignment {
    private int grade;
    private String textOfAssignments ;
    private ArrayList<Solution> solutions = new ArrayList<Solution>() ;
    public Assignment(int grade, String textOfAssignments) {
        this.grade = grade;
        this.textOfAssignments = "\"" + textOfAssignments + "\"" ;
    }
    public int getGrade() {
        return grade;
    }
    public String getTextOfAssignments() {
        return textOfAssignments;
    }

    public ArrayList<Solution> getSolutions() {
        return solutions;
    }
    public void listOfSolution(){
        int count = 1 ;
        for (Solution s : solutions){
            System.out.println(count++ + ") ") ;
            s.viewSolution() ;
        }
    }
    public void correctSolution(Solution solution , int gradeForSolution , String commentForSolution){
        solution.setCommentForSolution(commentForSolution);
        solution.setGradeForSolution(gradeForSolution);
    }
    public void viewAssignment(){
        System.out.println(this.textOfAssignments );
        System.out.println(this.grade + "- Grades");
    }
}
