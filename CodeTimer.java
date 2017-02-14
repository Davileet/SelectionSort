package selectionSort;
/**
 * CodeTimer class is called upon to get time various algorithms
 * and executions take to process. 
 * @author David Thompson
 * @date February 11, 2017
 */
public class CodeTimer
{
  //Long variable to hold the time value of execution.
  private long executionTime;
  
  /**
   * Class constructor initiates execution time to 0.
   */
  public CodeTimer() {
    this.executionTime = 0;
  }
  
  /**
   * startTimer method is called when the timer is to be 
   * initiated and captures the current JVM clock time upon start.
   */
  public void startTimer() {
    this.executionTime = System.nanoTime();
  }
  
  /**
   * stopTimer method is called when the timer needs to stop and 
   * the total time taken is returned. This method overwrites the 
   * class variable with a current nanoTime minus the starting time. 
   */
  public void stopTimer() {
    this.executionTime = System.nanoTime() - executionTime;
  }
  
  /**
   * resetTimer resets the value of executionTime to allow for 
   * it to be called again with a fresh starting value of 0.
   */
  public void resetTimer() {
    this.executionTime = 0;
  }

  /**
   * getExecutionTime is called when the value of executionTime is 
   * needed. 
   * @return executionTime, the time value currently stored in the class 
   * variable used for capturing times. 
   */
  public long getExecutionTime()
  {
    return executionTime;
  }

  /**
   * toString method outputs the value of the variable with text, 
   * but is not currently called upon in my RandomSelectionSort class. 
   */
  public String toString() {
    String timerDescription = "Current execution time: "
        + this.executionTime + " in nanoseconds.";
    
    return timerDescription;
  }
}
