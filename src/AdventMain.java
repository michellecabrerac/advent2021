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
        // System.out.println("Answer day 1 part 2: "+ advent.getAnswerday1Part2());
        // DAY 2
        // System.out.println("Answer day  : " + advent.getAnswwerday2());
        // DAY 2 part 2
        System.out.println("Answer day  : " + advent.getAnswwerday2Part2());

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


    // DAY 2

    private int getAnswwerday2(){
        int coordinateX = 0; //forward
        int coordinateY = 0; // down up
        try {
            File myObj = new File("dia2.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                int units = getUnits (line);
                try{
                    if (line.contains("forward")){
                        coordinateX = coordinateX + units;
                    }
                    else{
                        if(line.contains("down")){
                            coordinateY = coordinateY + units;

                        }
                        else{
                            if(line.contains("up")){
                                coordinateY = coordinateY - units;

                            }
                        }

                    }
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
        return coordinateX * coordinateY;
    }

    private int getAnswwerday2Part2(){
        int coordinateX = 0; //forward
        int coordinateY = 0; // down up
        int aims = 0;
        try {
            File myObj = new File("dia2.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                int units = getUnits (line);
                try{
                    if (line.contains("forward")){
                        coordinateX = coordinateX + units;
                        coordinateY = coordinateY + aims * units;
                    }
                    else{
                        if(line.contains("down")){
                            aims = aims + units;

                        }
                        else{
                            if(line.contains("up")){
                                aims = aims - units;

                            }
                        }

                    }
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
        return coordinateX * coordinateY;
    }

    private int getUnits(String line) {
        String [] units = line.split(" ");
        int value = 0;
        if(units.length > 1){
            value = Integer.valueOf(units[1]); // maybe a try/catch it is necessary to avoid NumberFormatException
        }
        return value;
    }
}
