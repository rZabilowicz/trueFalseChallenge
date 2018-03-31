import java.util.Random;

public class Main{

    /**
     *
     * @author Roza Zabilowicz
     *
     */

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";

    public static void main(String[] args) {

        boolean[] booleanArray = genarate();

        System.out.println("Your array on start: ");
        showItemsFromBooleanArray(booleanArray);

        System.out.println("Number of true values:" + findSolution(booleanArray));

    }

    /**
     * Method implements count to check how many "true" is after the test
     * @param booleanArray Array with boolean values
     * @return number of true values
     */
    private static int findSolution(boolean[] booleanArray){

        int count = 0;

        if( booleanArray.length == 1 && booleanArray[0] ==true ) count++;

        boolean[] exampleTable = booleanArray;
        boolean[] exampleTable2 = new boolean[booleanArray.length-1];

        System.out.println("Tree:");

        showItemsFromBooleanArray(exampleTable);

        for( int x=0; x < booleanArray.length-1; x++ ){

            count = count + countHowManyValuesAreTrue(exampleTable);


            for( int z=0; z < exampleTable.length-1; z++ ){

                if(!exampleTable[z]&& !exampleTable[z+1]) {
                    exampleTable2[z] = false;
                }
                else{
                    exampleTable2[z] = true;
                }
            }

            if( x == booleanArray.length-2 ) count = count + countHowManyValuesAreTrue(exampleTable2);

            showItemsFromBooleanArray(exampleTable2,x);

            exampleTable = exampleTable2;
            exampleTable2 = new boolean[exampleTable2.length-1];

        }

        return count;
    }

    /**
     * Showing values in boolean array
     * @param exampleTable boolean array
     */
    private static void showItemsFromBooleanArray(boolean[] exampleTable) {

        System.out.print(" | ");

        for (boolean items: exampleTable) {

            if(items) System.out.print(ANSI_GREEN  + items + " "  + ANSI_RESET + " | " );
            else System.out.print(ANSI_RED + items  + ANSI_RESET + "  | " );

        }

        System.out.println();
    }

    /**
     * Showing values in the form of tree
     * @param exampleTable boolean array
     * @param paragraph number of iteration
     */
    private static void showItemsFromBooleanArray(boolean[] exampleTable, int paragraph) {

        while(paragraph >= 0){
            System.out.print("    ");
            paragraph--;
        }

        System.out.print(" | ");

        for (boolean items: exampleTable) {

            if(items) System.out.print(ANSI_GREEN  + items + " "  + ANSI_RESET + " | " );
            else System.out.print(ANSI_RED + items  + ANSI_RESET + "  | " );


        }

        System.out.println();

    }

    /**
     * Counting the number of true values
     * @param tableToCounting boolean array
     * @return number of true values in one array
     */
    private static int countHowManyValuesAreTrue( boolean[] tableToCounting ){

        int count = 0;

        for( int y=0; y<tableToCounting.length; y++ ){

            if(tableToCounting[y])count++;;

        }

        return count;
    }

    /**
     * Generate new example boolean array
     * (random array length and values)
     * @return random array with true or false values
     */
    private static boolean[] genarate(){

        Random generator = new Random();

        int numberOfValues = generator.nextInt(20)+1;

        boolean[] valuesToCheck = new  boolean[numberOfValues];

        for (int i = 0; i < valuesToCheck.length; i++ ) {

            valuesToCheck[i] = generator.nextBoolean();

        }

        return valuesToCheck;
    }
}
