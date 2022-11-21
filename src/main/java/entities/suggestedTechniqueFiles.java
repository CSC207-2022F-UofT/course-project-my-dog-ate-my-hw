package entities;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class suggestedTechniqueFiles {

    File file = new File("/Users/rajeshwarisingh/Desktop/studytechnqiueexam.txt");
    Scanner scan = new Scanner(file);

    while(scan.hasNextLine()) {

    }
    System.out.println(scan.nextLine());
    File file2 = new File();
    FileWriter filewriter = new FileWriter(file2);
    PrintWriter pw = new PrintWriter(filewriter);

    public suggestedTechniqueFiles() throws IOException {
    }

}
