import java.util.Comparator;

/**
 * Sort through an array using insertion sort.
 *
 * @author Lucas Willett, Sam R
 */

public class InsertionSort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new InsertionSort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  InsertionSort() {
  } // InsertionSort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    if(values.length != 0){
      int end = values.length -1;
      int cur = 1;
      int border = 1; //first unsorted item
      while(border != end + 1){
        while((cur != 0) && (order.compare(values[cur], values[cur-1]) < 0)){
          T temp = values[cur];
          values[cur] = values[cur-1];
          values[cur-1] = temp;
          cur--;
        }
        border++;
        cur = border;
      }
    } // sort(T[], Comparator<? super T>
  }
} // class InsertionSort
