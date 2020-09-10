import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class CSVReader {
    private static Scanner x;

    public static void main(String[] args) {
        String path = "C:/Users/ravel/IdeaProjects/CSV/RainfallReport.csv";
        //121
        System.out.println("Enter which date you would to search for. Format: 0/0/0000(M/D/YYYY) Range: 10/1/1953-7/20/2020");
        Scanner userReader = new Scanner(System.in);
        //String searchTerm = userReader.next();
        //userReader.close();

        readRecord("10/23/1954",path);
    }

    public static void readRecord(String searchTerm, String path){
        boolean found = false;
        String date = ""; String dailySum = "";

        try {
            x = new Scanner(new File(path));
            x.useDelimiter("[,\n]");

            while(x.hasNext() && !found){
                date = x.next();
                System.out.println(date);
                System.out.println(found);

                if(date.equals(searchTerm)){
                    found = true;
                    System.out.println("I just turned true.");
                }
            }

            if (found){
                System.out.println(found);
                JOptionPane.showMessageDialog(null,"Date: "+ date + " Daily Rainfall : " + dailySum);
            }
            else{
                JOptionPane.showMessageDialog(null,"Record Not Found");
            }
        }
        catch (Exception e){

        }
    }
}
