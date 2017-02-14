package selectionSort;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

/**
 * RandomSelectionSort class generates a random number 
 * of integers in an ArrayList and then passes that 
 * ArrayList into a selection sort algorithm. This class 
 * calls upon a CodeTimer object to keep track of the 
 * timing needed for sort calls. 
 * The main method generates random integers in the range 
 * of 0..99 and also controls the total number of integers
 * to be created.
 * @author David Thompson
 * @date February 11, 2017
 */

public final class RandomSelectionSort {

  //CodeTimer object to keep track of timing
  static CodeTimer timer = new CodeTimer();

  /**
   * main method creates a output statement showing the size of 
   * array being created. Method also has a for loop that 
   * controls the amount of times the sorting needs to occur, 
   * in this case it is set to 10. numbersGenerate is called
   * upon with the number of values to create. Print statement 
   * to output elapsed time for each sort. 
   * @param aArgs
   */
  public static final void main(String... aArgs){
    //Declaration print statement. Change numbers as needed.
    toString("Generating 500 random integers in range 0..99.");

    // for loop controlling amount of times sort needs to be ran.
    for(int i = 1; i<=10; i++){
      //method call of how many random elements to create in array.
      numberGenerate(50);

      //Print with decimal formatting from nanoTime into seconds.
      toString("Total Sort Time : " + 
          new DecimalFormat("#.############").
          format(timer.getExecutionTime()/ 1000000000.0 ) 
          + " Seconds");
    }
    toString("Done.");
  }

  /**
   * toString method accepts string values and prints them to console.
   * @param msg String to print on console.
   */
  private static void toString(String msg){
    System.out.println(msg);
  }


  /**
   * numberGenerate method creates an ArrayList object when called upon
   * and inserts random integers using a Random object. 
   * @param howMany
   * @return 
   * @return
   */
  public static void numberGenerate(int howMany){

    //ArrayList object to hold number values.
    ArrayList<Integer> numbers = new ArrayList<Integer>();  

    //Note a single Random object is reused here in each iteration.
    Random randomGenerator = new Random();

    // for loop that creates random integers and places them into
    // our numbers array.
    for (int idx = 1; idx <= howMany; ++idx){
      int randomInt = randomGenerator.nextInt(100);
      numbers.add(randomInt); 
    }

    //Timer is reset and called to start.
    timer.resetTimer();
    timer.startTimer();
    //selectionSort method is called with a newly created ArrayList.
    selectionSort(numbers);
    //timber object is called to stop and calculate total time taken.
    timer.stopTimer();
  }

  /**
   * selectionSort method accepts an ArrayList containing randomly generated
   * numbers and sorts them using selection sort.  
   * @param numbers list of randomly generated values
   */
  public static void selectionSort(ArrayList<Integer> numbers) {

    int minIndex, //placeholder for lowest value in array.
        tmp; //temporary value used as a index placeholder.

    //Creates a new array of integers using the array passed as argument
    //to be used in the sorting.
    Integer[] bar = numbers.toArray(new Integer[numbers.size()]);
    
    //captures the size of array for correct computation.
    int n = numbers.size();

    /**
     * for loop that cycles through the array selecting the lowest element
     * by scanning all elements (n-1 comparisons) and swapping to the 
     * first index. Loop continues through in this manner moving up the index
     * value from beginning to end swapping with lowest value in array.
     */
    for (int i = 0; i < n - 1; i++) {
      minIndex = i;
      for (int j = i + 1; j < n; j++)
        if (bar[j] < bar[minIndex])
          minIndex = j;
      if (minIndex != i) {
        tmp = bar[i];
        bar[i] = bar[minIndex];
        bar[minIndex] = tmp;
      }
    }
  }  
}