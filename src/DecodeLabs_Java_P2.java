import java.util.Scanner;

public class DecodeLabs_Java_P2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numberOfSubjects;
        int totalMarks = 0;
        double averagePercentage;
        char grade;

        System.out.println("=== Student Grade Calculator ===");

        // Input number of subjects
        while (true) {
            try {
                System.out.print("Enter number of subjects: ");
                numberOfSubjects = Integer.parseInt(sc.nextLine());

                if (numberOfSubjects <= 0) {
                    System.out.println("Number of subjects must be greater than 0.");
                    continue;
                }
                break;

            } catch (Exception e) {
                System.out.println("Invalid input! Enter a valid number.");
            }
        }

        // Input marks for each subject
        for (int i = 1; i <= numberOfSubjects; i++) {
            while (true) {
                try {
                    System.out.print("Enter marks for subject " + i + " (0-100): ");
                    int marks = Integer.parseInt(sc.nextLine());

                    if (marks < 0 || marks > 100) {
                        System.out.println("Marks must be between 0 and 100.");
                        continue;
                    }

                    totalMarks += marks;
                    break;

                } catch (Exception e) {
                    System.out.println("Invalid input! Please enter numeric marks.");
                }
            }
        }

        // Calculate percentage
        averagePercentage = (double) totalMarks / numberOfSubjects;

        // Grade calculation
        if (averagePercentage >= 90) {
            grade = 'A';
        } else if (averagePercentage >= 75) {
            grade = 'B';
        } else if (averagePercentage >= 60) {
            grade = 'C';
        } else if (averagePercentage >= 40) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        // Output result
        System.out.println("\n=== Result ===");
        System.out.println("Total Marks: " + totalMarks);
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("Grade: " + grade);

        // Pass/Fail
        if (averagePercentage >= 40) {
            System.out.println("Status: PASS");
        } else {
            System.out.println("Status: FAIL");
        }

        sc.close();
    }
}