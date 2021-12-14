import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdventMain {
    public static void main(String [] args){
        AdventMain advent = new AdventMain();
        // DAY 1
        //System.out.println("Answer day 1 : " + advent.getAnswwerday1());
        // DAY 1 part 2
        System.out.println("Answer day 1 part 2: "+ advent.getAnswerday1Part2());

    }
    // TODO - Improve!!
    private String getAnswwerday1(){
        //
        int count = 0;
        Integer currentNumber;
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
    private boolean currentNumberIsGreaterThanLastNumber(int[] current , int [] last){
     return current[0] + current[1] + current[2] > last[0] + last[1] +last[2];   // TODO hacerlo mejor
    }
    private String getAnswerday1Part2(){
        //
        int count = 0;
        int[] currentThreeNumbers = new int[3];
        int[] lastThreeNumbers = new int[3];

        try {
            File myObj = new File("dia1.txt");
            Scanner myReader = new Scanner(myObj);
            // Fist special case
            currentThreeNumbers[0] = myReader.hasNextLine() ? Integer.valueOf(myReader.nextLine()) : 0;
            currentThreeNumbers[1] = myReader.hasNextLine() ? Integer.valueOf(myReader.nextLine()) : 0;
            currentThreeNumbers[2] = myReader.hasNextLine() ? Integer.valueOf(myReader.nextLine()) : 0;
            boolean firstTime = true;
            //Next cases
            while (myReader.hasNextLine()) {
                try{
                    if(!firstTime){
                        String line = myReader.nextLine();
                        currentThreeNumbers[0] = currentThreeNumbers[1];
                        currentThreeNumbers[1] = currentThreeNumbers[2];
                        currentThreeNumbers[2] = Integer.valueOf(line);
                        if(currentNumberIsGreaterThanLastNumber(currentThreeNumbers, lastThreeNumbers)){
                            count++;
                        }
                    }
                    else{
                        firstTime = false;
                    }
                    lastThreeNumbers[0] = currentThreeNumbers[0];
                    lastThreeNumbers[1] = currentThreeNumbers[1];
                    lastThreeNumbers[2] = currentThreeNumbers[2];
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


    private String getAnswerday1Part2InOtherWay(){
        // TODO - do better
        return "";
    }
}
