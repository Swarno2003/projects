import java.util.*;
public class Grade {
    String name;
    double physics,maths,chemistry,computer,english;
    void getNameAndMarks() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter User Name: ");
        name = sc.nextLine();
        System.out.print("Enter marks in Physics: ");
        physics = sc.nextInt();
        System.out.print("Enter marks in Maths: ");
        maths = sc.nextInt();
        System.out.print("Enter marks in chemistry: ");
        chemistry = sc.nextInt();
        System.out.print("Enter marks in computer: ");
        computer = sc.nextInt();
        System.out.print("Enter marks in english: ");
        english = sc.nextInt();

        sc.close();
    }
    double getAveragePercentage() {
        double avg = (physics+maths+chemistry+computer+english)/5.0;
        return avg;
    }
    char getGrade(double avg) {
        if(avg > 90 && avg <= 100) {
            return 'A';
        }
        else if(avg > 80 && avg <=90) {
            return 'B';
        } else if(avg > 70 && avg <= 80) {
            return 'C';
        } else if(avg > 60 && avg <= 70) {
            return 'D';
        } else if(avg > 40 && avg <= 60) {
            return 'E';
        } else {
            return 'F';
        }
    }
    String getComment(char grade) {
        if(grade == 'A') {
            return "Excellent";
        } else if(grade == 'B') {
            return "Very Good";
        } else if(grade == 'C') {
            return "Good";
        } else if(grade == 'D') {
            return "Satisfactory";
        } else if(grade == 'E') {
            return "Just Pass";
        } else {
            return "Soory Failed";
        }
    }
    void display(double avg,char grade,String comment) {
        System.out.println("Name: " + name);
        System.out.println("Average Percentage: " + avg);
        System.out.println("Grade: " + grade);
        System.out.println("Comment: " + comment);
    }
    public static void main(String args[]) {
        Grade obj = new Grade();
        obj.getNameAndMarks();
        double avg = obj.getAveragePercentage();
        char grade = obj.getGrade(avg);
        String comment = obj.getComment(grade);
        obj.display(avg, grade, comment);
    }
}
