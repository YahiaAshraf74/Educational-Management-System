public class Solution{
    private String ID;
    private String textForSolution ;
    private String commentForSolution ;
    private int gradeForSolution;

    public Solution(String textForSolution, String ID) {
        this.textForSolution = textForSolution;
        this.ID = ID;
        this.commentForSolution = null ;
        this.gradeForSolution = -1 ;
    }
    public void viewSolution(){
        System.out.println("The student with ID : " + ID);
        if(gradeForSolution != -1){
            System.out.println("Grade is :" + gradeForSolution);
        }else{
            System.out.println("Solution not correct yet");
        }
    }
    public void setCommentForSolution(String commentForSolution) {
        this.commentForSolution = commentForSolution;
    }

    public void setGradeForSolution(int greadForSolution) {
        this.gradeForSolution = greadForSolution;
    }

    public String getCommentForSolution() {
        return commentForSolution;
    }

    public int getGreadForSolution() {
        return gradeForSolution;
    }

    public String getID() {
        return ID;
    }

    public String getTextForSolution() {
        return textForSolution;
    }

    public int getGradeForSolution() {
        return gradeForSolution;
    }
}