import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AdventMain {
    public static void main(String [] args){
        AdventMain advent = new AdventMain();
        // DAY 1
        System.out.println("Answer day 1 : " + advent.getAnswwerday1());
        // DAY 1 part 2
        System.out.println("Answer day 1 part 2: "+ advent.getAnswwerday1Part2());

    }
    // TODO - Improve!!
    private String getAnswwerday1(){
        //
        int count = 0;
        Integer currentNumber = null;
        Integer lastNumber = null;
        try {
            File myObj = new File("dia1.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                try{
                    currentNumber = Integer.valueOf(line);
                    if(lastNumber != null && currentNumber > lastNumber){
                        count++;
                    }
                    lastNumber = currentNumber;
                }
                catch (NumberFormatException ex){
                    ex.printStackTrace();
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return "" + count;
    }
    private String getAnswwerday1Part2(){
        return "";
    }
}
