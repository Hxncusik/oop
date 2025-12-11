package kz.yerkebulan;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write students number: ");
        int studentsNumber = scanner.nextInt();

        double[] grades = new double[studentsNumber];
        for (int i = 0; i < studentsNumber; i++) {
            System.out.println("Write " + (i+1) + " student name: ");
            String studentName = scanner.next();
            grades[i] = calculateGrade(scanner, studentName);
        }

        double gradesSum = 0;
        for (double grade : grades) {
            gradesSum += grade;
        }

        double averageGrade = gradesSum / studentsNumber;

        System.out.println("Average grade is: " + averageGrade);
    }

    public static double calculateGrade(Scanner scanner, String studentName) {
        System.out.println("Write " + studentName + "'s Midterm grade: ");
        int midtermGrade = scanner.nextInt();

        if (isGradeInvalid(midtermGrade, studentName)) {
            return 0;
        }

        System.out.println("Write " + studentName + "'s Endterm grade: ");
        int endtermGrade = scanner.nextInt();

        if (isGradeInvalid(endtermGrade, studentName)) {
            return 0;
        }

        double termGrade = (double) (midtermGrade + endtermGrade) / 2;

        if (termGrade < 50) {
            System.out.println(studentName + " failed the course.");
            return 0;
        }

        System.out.println("Write " + studentName + "'s Final grade: ");
        int finalGrade = scanner.nextInt();

        if (isGradeInvalid(finalGrade, studentName)) {
            return 0;
        }

        double totalGrade = (int) (termGrade * 0.6 +
                finalGrade * 0.4);

        System.out.println(studentName + "'s total grade is: " + totalGrade);
        return totalGrade;
    }

    public static boolean isGradeInvalid(int grade, String studentName) {
        if (grade < 0 || grade > 100) {
            System.out.println("Invalid grade");
            return true;
        }  else if (grade < 25) {
            System.out.println(studentName + " failed the course.");
            return true;
        }
        return false;
    }
}