package entities;
import java.io.*;
import java.util.Scanner;

public class suggestedTechniques {
    enum assignmentType {
        EXAM,
        QUIZ,
        RESEARCH_PAPER,
        PRESENTATION,
        ESSAY,
        LAB_REPORT
    }

    public void getStudyTechnique(enum assignmentType) throws FileNotFoundException {
        if (assignmentType.contentEquals("EXAM")) {


            File file = new File("/Users/rajeshwarisingh/Desktop/studytechnqiueexam.txt");
            Scanner scan = new Scanner(file);

            while (scan.hasNextLine()) {

            }
            System.out.println(scan.nextLine());
        }
        elif(assignmentType.contentEquals("QUIZ")) {


            File file2 = new File("/Users/rajeshwarisingh/Desktop/studytechnqiuequiz.txt");
            Scanner scan2 = new Scanner(file2);

            while (scan2.hasNextLine()) {

            }
            System.out.println(scan2.nextLine());
        }
        elif(assignmentType.contentEquals("RESEARCH_PAPER")) {


            File file3 = new File("/Users/rajeshwarisingh/Desktop/studytechnqiueresearchpaper.txt");
            Scanner scan3 = new Scanner(file3);

            while (scan3.hasNextLine()) {

            }
            System.out.println(scan3.nextLine());
        }
        elif(assignmentType.contentEquals("PRESENTATION")) {


            File file4 = new File("/Users/rajeshwarisingh/Desktop/studytechnqiuepresentation.txt");
            Scanner scan4 = new Scanner(file4);

            while (scan4.hasNextLine()) {

            }
            System.out.println(scan4.nextLine());

        } elif(assignmentType.contentEquals("ESSAY")) {


            File file5 = new File("/Users/rajeshwarisingh/Desktop/studytechnqiueessay.txt");
            Scanner scan5 = new Scanner(file5);

            while (scan5.hasNextLine()) {

            }
            System.out.println(scan5.nextLine());

        }
        elif(assignmentType.contentEquals("LAB_REPORT")) {


            File file6 = new File("/Users/rajeshwarisingh/Desktop/studytechnqiuelabreport.txt");
            Scanner scan6 = new Scanner(file6);

            while (scan6.hasNextLine()) {

            }
            System.out.println(scan6.nextLine());

        } else{
            pass
        }
    }
}