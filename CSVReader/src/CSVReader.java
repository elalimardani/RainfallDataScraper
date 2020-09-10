import javax.swing.*;
import java.io.*;
import java.util.Scanner;
import java.util.function.Supplier;

public class CSVReader {
    private static Scanner x;

    public static void main(String[] args) {
        String path = "RainfallReport.csv";
        //121
        System.out.println("Enter which date you would to search for. Format: 0/0/0000(M/D/YYYY) Range: 10/1/1953-7/20/2020");
        Scanner userReader = new Scanner(System.in); //Allows user to input and store it as searchTerm
        String searchTerm = userReader.next();
        userReader.close(); //Closes the scanner.
        readRecord(searchTerm,path);
    }

    public static void readRecord(String searchTerm, String path){
        boolean found = false;
        String date = ""; String dailySum = "";
        try {
            x = new Scanner(new File(path)); //Creates scanner to go through .csv file column-by-column, row-by-row.
            x.useDelimiter("[,\n]");

            while(x.hasNext() && !found){ //Continues to search .csv file until date is found, or end of file is reached.
                date = x.next();
                if(date.equals(searchTerm)){
                    found = true;
                }
            }

            if (found){
                System.out.println(found);
                for (int i = 0; i < 122; i++) //Set moves to the sum value in the .csv file and set dailySum to it.
                {
                    dailySum = x.next();
                }
                double doubleSum = Double.parseDouble(dailySum); //Converts the dailySum string to a double to allow it  to be divided by 100.
                x.close();
                JOptionPane.showMessageDialog( //Opens dialogue box showing results
                        ((Supplier<JDialog>) () -> {final JDialog dialog = new JDialog(); dialog.setAlwaysOnTop(true); return dialog;}).get()
                        , "Date: "+ date + " Daily Rainfall: " + (doubleSum/100) + " inches.");
                System.exit(0);
            }
            else{
                x.close();
                JOptionPane.showMessageDialog( //Opens dialogue box showing results
                        ((Supplier<JDialog>) () -> {final JDialog dialog = new JDialog(); dialog.setAlwaysOnTop(true); return dialog;}).get()
                        , "Record Not Found");
                System.exit(0);
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
