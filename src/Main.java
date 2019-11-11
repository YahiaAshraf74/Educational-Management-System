import java.util.Scanner;

public class Main {
    private static Scanner cin = new Scanner(System.in) ;
    public static void main(String[] args) {
        System.out.println("Welcome to Faculty Of Computers And Information Kafr El Sheikh University");
        majorMenu() ;

    }
    private static void majorMenu(){
        while(1!=0){
            String[] choices = {"Login" , "Sign Up" , "Shutdown system"}  ;
            int choice = -1;
            choice = printMenu(choices , choice);
            switch (choice){
                case 1:
                    login();
                    break ;
                case 2:
                    signUp();
                    break ;
                case 3:
                    shutDown() ;
                    break;
            }
        }
    }
    private static void login(){
        boolean valid = false ;
        while(!valid) {
            System.out.println("ID: ");
            String ID = cin.nextLine();
            System.out.println("Password: ");
            String password = cin.nextLine();
            for (Student s : Student.listOfAllStudent) {
                if (s.getID().equals(ID) && s.getPassword().equals(password)) {
                    System.out.println("Hi " + s.getName() + ". You are logged in");
                    studentMenu(s);
                    valid = true;
                    continue ;
                }
            }
            for (TeacherAssistant t : TeacherAssistant.listOfAllTeacherAssistant) {
                if (t.getID().equals(ID) && t.getPassword().equals(password)) {
                    System.out.println("Hi ENG." + t.getName() + ". You are logged in");
                    TeacherAssistantMenu(t);
                    valid = true;
                    continue ;
                }
            }
            for (Doctor d : Doctor.listOfAllDoctors) {
                if (d.getID().equals(ID) && d.getPassword().equals(password)) {
                    System.out.println("Hi Prof." + d.getName() + ". You are logged in");
                    DoctorMenu(d);
                    valid = true;
                    continue ;
                }
            }
            System.out.println("Incorrect ID or Password !!!!\n" +
                    "Enter: \n\t1) Retry ID and Password \n\t" +
                    "2) Back to Major Menu");
            int retry = cin.nextInt();
            cin.nextLine();
            if (retry == 2){
                majorMenu() ;
                valid = true ;
            }
        }
    }
    private static void studentMenu(Student student){
        boolean valid = false ;
        while(!valid) {
            String[] choices = {"List My Courses" , "View Course" , "Grades Report" , "Register in Course" , "Unregister in Course" , "Log Out"};
            int choice = -1;
            choice = printMenu(choices , choice);
            switch (choice) {
                case 1:
                    listOfCourses(student) ;
                    break;
                case 2:
                    viewCourseForStudent(student) ;
                    break ;
                case 3:
                    gradeReport(student) ;
                    break ;
                case 4:
                    registerCourse(student) ;
                    break ;
                case 5:
                    unRegisterCourse(student) ;
                case 6:
                    valid = true;
                    majorMenu() ;
                    break ;
            }
        }
    }
    private static void TeacherAssistantMenu(TeacherAssistant teacherAssistant){
        boolean valid = false ;
        while(!valid) {
            String[] choices = {"List My Courses" , "View Course" , "Register in Course" , "Unregister in Course" , "Log Out"}  ;
            int choice = -1;
            choice = printMenu(choices , choice);
            switch (choice) {
                case 1:
                    listOfCourses(teacherAssistant) ;
                    break;
                case 2:
                    viewCourseForTeacherAssistant(teacherAssistant) ;
                    break ;
                case 3:
                    registerCourse(teacherAssistant);
                    break ;
                case 4:
                    unRegisterCourse(teacherAssistant) ;
                    break ;
                case 5:
                    majorMenu() ;
                    valid = true;
                    break ;
            }
        }
    }
    private static void DoctorMenu(Doctor doctor){
        boolean valid = false ;
        while(!valid) {
            String[] choices = {"List My Courses" , "View Course" , "Register in Course" , "Unregister in Course" , "Create New Course" , "Log Out"}  ;
            int choice = -1;
            choice = printMenu(choices , choice);
            switch (choice) {
                case 1:
                    listOfCourses(doctor) ;
                    break;
                case 2:
                    viewCourseForDoctor(doctor) ;
                    break ;
                case 3:
                    registerCourse(doctor);
                    break ;
                case 4:
                    unRegisterCourse(doctor) ;
                    break ;
                case 5:
                    System.out.println("Enter name for course: ");
                    String name = cin.nextLine() ;
                    System.out.println("Enter code for course: ");
                    String code = cin.nextLine() ;
                    Course newCourse = new Course(name , code , doctor) ;
                    doctor.CreatNewCourse(newCourse) ;
                    System.out.println("Course successful Created \n" +
                            "Go to view Course to add Slides , TAs and Assignments");
                    break ;
                case 6:
                    majorMenu() ;
                    valid = true;
                    break ;
            }
        }
    }
    private static int printMenu(String[] choices , int choice){
        System.out.println("\n\nEnter your choice: ") ;
        for(int i = 0 ; i < choices.length ; i++){
            System.out.println("\t" + (i+1) + ") " + choices[i]);
        }
        choice = cin.nextInt();
        cin.nextLine();
        while(choice < 1 || choice > choices.length){
            System.out.println("Please Enter a valid choice: ");
            choice = cin.nextInt() ;
        }
        return choice ;
    }
    private static void viewCourseForStudent(Student student){
        student.listOfCourseRegistered();
        System.out.println("Enter The number of the course: ");
        int numberOfCourse = cin.nextInt();
        Course course = student.getCourses().get(numberOfCourse-1) ;
        course.printAllDetails();
        boolean valid2 = false ;
        while(!valid2) {
            String[] choices2 = {"Show Slide", "List Assignments" , "Submit Solution" , "Back" };
            int choice2 = -1;
            choice2 = printMenu(choices2 , choice2);
            switch (choice2) {
                case 1:
                    System.out.println("There are " + course.getSlides().size() + "Slides")  ;
                    System.out.println("Enter The Slide number: ");
                    int slideNumber = cin.nextInt() ;
                    System.out.println(student.showSlide(course , slideNumber));
                    break ;
                case 2:
                    student.listOfAssignment(course);
                    break;
                case 3:
                    int count = 1;
                    for (Assignment a : course.getAssignments()) {
                        System.out.println("Assignment " + count++ + ")");
                        System.out.println(a.getTextOfAssignments() + "\t(" + a.getGrade() + ")");
                    }
                    System.out.println("Enter the Assignment number: ");
                    int choice3 = cin.nextInt();
                    while (choice3 > course.getAssignments().size() || choice3 < 1){
                        System.out.println("Please Enter a valid choice: ");
                        choice3 = cin.nextInt();
                    }
                    System.out.println("Enter your solution (without space):");
                    String sol = cin.nextLine();
                    student.submitSolution(course.getAssignments().get(choice3-1) , sol);
                    System.out.println("You successful submitted");
                    break;
                case 4:
                    valid2 = true ;
                    break;
            }
        }
    }
    private static void viewCourseForTeacherAssistant(TeacherAssistant teacherAssistant){
        teacherAssistant.listOfCourseRegistered();
        System.out.println("Enter The number of the course: ");
        int numberOfCourse = cin.nextInt();
        Course course = teacherAssistant.getCourses().get(numberOfCourse-1) ;
        course.printAllDetails();
        boolean valid2 = false ;
        while(!valid2) {
            String[] choices2 = {"Show Slide", "Add Slide" ,"Remove Slide" , "Add Assignment" , "Remove Assignment" , "List Assignments" , "Correct Assignment", "Back" };
            int choice2 = -1;
            choice2 = printMenu(choices2 , choice2);
            switch (choice2) {
                case 1:
                    System.out.println("There are " + course.getSlides().size() + "Slides")  ;
                    System.out.println("Enter The Slide number: ");
                    int slideNumber = cin.nextInt() ;
                    System.out.println(teacherAssistant.showSlide(course , slideNumber));
                    break ;
                case 2:
                    System.out.println("Enter the Slide: ");
                    String slide = cin.nextLine();
                    teacherAssistant.addSlide(course,slide) ;
                    System.out.println("Your Successful Add the Slide");
                    break;
                case 3:
                    System.out.println("There are " + course.getSlides().size() + "Slides")  ;
                    System.out.println("Enter The Slide number: ");
                    int slide2 = cin.nextInt();
                    teacherAssistant.removeSlide(course,course.getSlides().get(slide2-1)) ;
                    System.out.println("Your Successful Remove the Slide");
                    break;
                case 4:
                    System.out.println("Enter the Assignment: ");
                    String assignment = cin.nextLine() ;
                    System.out.println("Enter the Grade for Assignment: ");
                    int grade = cin.nextInt();
                    teacherAssistant.addAssignment(course , new Assignment(grade,assignment )) ;
                    break;
                case 5:
                    int count2 = 1;
                    for (Assignment a : course.getAssignments()) {
                        System.out.println("Assignment " + count2++ + ")");
                        System.out.println(a.getTextOfAssignments() + "\t(" + a.getGrade() + ")");
                    }
                    System.out.println("Enter the Assignment Number You want to remove: ");
                    int assignmentNumber = cin.nextInt() ;
                    teacherAssistant.removeAssignment(course , course.getAssignments().get(assignmentNumber-1)) ;
                    break;
                case 6:
                    int count = 1;
                    for (Assignment a : course.getAssignments()) {
                        System.out.println("Assignment " + count++ + ")");
                        System.out.println(a.getTextOfAssignments() + "\t(" + a.getGrade() + ")");
                    }
                    break;
                case 7:
                    int count3 = 1;
                    for (Assignment a : course.getAssignments()) {
                        System.out.println("Assignment " + count3++ + ")");
                        System.out.println(a.getTextOfAssignments() + "\t(" + a.getGrade() + ")");
                    }
                    System.out.println("Enter the Assignment Number You want to Correct: ");
                    int assignmentNumber2 = cin.nextInt() ;
                    Assignment assignment1 = course.getAssignments().get(assignmentNumber2-1) ;
                    assignment1.listOfSolution() ;
                    System.out.println("Enter the number of Solutions you Want to Correct: ");
                    int correctSolution = cin.nextInt() ;
                    Solution studentSolution = assignment1.getSolutions().get(correctSolution-1) ;
                    System.out.println(studentSolution.getTextForSolution());
                    System.out.print("Enter the Grade For this Solution: ");
                    int greedForSolution = cin.nextInt();
                    System.out.print("Enter Comment For this Solution: ");
                    String comment = cin.nextLine();
                    studentSolution.setGradeForSolution(greedForSolution);
                    studentSolution.setCommentForSolution(comment);
                    break;
                case 8:
                    valid2 = true ;
                    break;
            }
        }
    }
    private static void viewCourseForDoctor(Doctor doctor){
        viewCourseForTeacherAssistant(doctor);
    }
    private static void gradeReport(Student student){
        System.out.println("You are register in " + student.getCourses().size() + ": ");
        for(Course c : student.getCourses()){
            c.printAllDetails();
            student.listOfAssignment(c);
        }
    }
    private static void listOfCourses(Person person){
        System.out.println("Your Courses are " + person.getCourses().size() + ": ");
        person.listOfCourseRegistered();
    }
    private static void registerCourse(Person person){
        person.listOfCourseNotRegistered();
        System.out.println("Enter the number of course: ");
        boolean done =false ;
        while(!done) {
            int choice2 = cin.nextInt();
            for (Course c : Course.listOfAllCourses) {
                if (!person.getCourses().contains(c)) {
                    if (--choice2 == 0) {
                        person.removeCourse(c);
                        done = true ;
                        break;
                    }
                }
            }
            if (done){
                System.out.println("You successful Register the course");
                break ;
            }else {
                System.out.println("Please Enter a valid choice: ");
            }
        }
    }
    private static void unRegisterCourse(Person person){
        person.listOfCourseRegistered();
        System.out.println("Enter the number of course: ");
        int choice3 = cin.nextInt();
        while (choice3 > person.getCourses().size() || choice3 < 1 ){
            System.out.println("Please Enter a valid choice: ");
            choice3 = cin.nextInt();
        }
        person.removeCourse(person.getCourses().get(choice3-1)) ;
        System.out.println("You successful Unregister the course");
    }
    private static void signUp(){
        String[] choices = {"Student" , "Teacher Assistant" , "Doctor"}  ;
        int choice = -1;
        choice = printMenu(choices , choice);
        String[] data = {"Full Name" , "ID" , "E-mail" , "Password"} ;
        for(int i = 0 ; i < data.length ; i++){
            System.out.println("Enter Your " + data[i] + ": ");
            data[i] = cin.nextLine() ;
        }
        switch (choice){
            case 1:
                Student.listOfAllStudent.add(new Student(data[0],data[1],data[2],data[3]));
                break ;
            case 2:
                TeacherAssistant.listOfAllTeacherAssistant.add(new TeacherAssistant(data[0],data[1],data[2],data[3]) );
                break ;
            case 3:
                Doctor.listOfAllDoctors.add(new Doctor(data[0],data[1],data[2],data[3]));
                break ;
        }
        System.out.println("Your successful Registered :) :)\n" +
                "Please check your E-mail to confirm");
    }
    private static void shutDown(){
        System.out.println("Thank you and have a great day :) :)");
        System.exit(0);
    }
}
