import java.util.*;
public class NumberGame { // Time Complexity : ~O(n^2)
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Pls enter the total no. of rounds to be played: ");
        int rounds = sc.nextInt();

        int totalRoundsTaken = 0;
        int attemptsTaken = 0;
        boolean result = false;
        int points = (rounds*3);
        for(int i=1;i<=rounds;i++) {
            int randomNo = (int)(Math.random()*100);
            for(int j=1;j<=3;j++){
                System.out.print("Please Guess a number: ");
                int guessNo = sc.nextInt();
                attemptsTaken++;
                if(guessNo == randomNo) {
                    result = true;
                    break;
                } else {
                    if(i-1 == rounds) {
                        System.out.println("No More Chance Soory.");
                    }else {
                        System.out.println("Try Again.");
                    }
                    points--;
                }
            }
            totalRoundsTaken++;
            if(result) {
                break;
            }
        }

        double score = ((double)points/(rounds*3))*100.00;

        if(result) {
            System.out.println("Winner Yeh.");
            System.out.println("Total rounds taken: " + totalRoundsTaken);
            System.out.println("Total attempts taken: " + attemptsTaken);
            System.out.println("Score : " + Math.round(score) + "%");
        } else {
            System.out.println("Failed Soory.");
            System.out.println("Total rounds taken: " + totalRoundsTaken);
            System.out.println("Total attempts taken: " + attemptsTaken);
            System.out.println("Score: " + Math.round(score) + "%");
        }

        sc.close();
    }
}