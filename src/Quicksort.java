import java.util.Comparator;

/**
 * Sort through an array using Quicksort.
 *
 * @author Lucas Willett, David Rhoades, Nye Tenerelli
 */

public class Quicksort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new Quicksort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  Quicksort() {
  } // Quicksort()

 // +----------------+----------------------------------------------
  // | Public methods |
  // +----------------+

  /**
   * Sort an array in place.
   *
   * @param vals, an array to sort.
   * @param order, the order by which to sort the values.
   * @return
   *    The same array, now sorted.
   * @pre
   *    order can be applied to any two values in vals.
   * @pre
   *    VALS = vals.
   * @post
   *    vals is a permutation of VALS.
   * @post
   *    For all i, 0 < i < vals.length,
   *      order.compare(vals[i-1], vals[i]) <= 0
   */
  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    if(values.length != 0){
      quicksort(values, order, 0, values.length-1);
    }
  } //  sort(T[], Comparator<? super T>)

  /**
   * Partition an array.
   */
  //public <T> void partition(T[] values, Comparator<? super T> order) {
  //  partition(values, order, 0, values.length);
  //} // partition(T[], Comparator<? super T>)

  // +----------------------+----------------------------------------
  // | Semi-private methods |
  // +----------------------+

  /**
   * Sort the subarray of T given by [lb..ub) in place using
   * the Quicksort algorithm.
   */
  <T> void quicksort(T[] values, Comparator<? super T> order, int lb, int ub) {
    if (lb == ub){
      return;
    } else if(lb + 1 == ub){
      if(order.compare(values[lb], values[ub]) > 0){
        T temp = values[lb];
        values[lb] = values[ub];
        values[ub] = temp;
        return;
      }
      return;
    }  else {
      int mid = partition(values, order, lb, ub);
      quicksort(values, order, lb, mid-1);
      quicksort(values, order, mid+1, ub);
    }
  } // quicksort(T[], Comparator<? super T>, lb, ub)

  /**
   * Select a pivot and partition the subarray from [lb .. ub) into 
   * the following form.
   *
   * <pre>
   * ---+-----------------+-+----------------+---
   *    | values <= pivot |p| values > pivot |
   * ---+-----------------+-+----------------+---
   *    |                 |                  |
   *    lb                pivotLoc           ub
   * </pre>
   *
   * @return pivotLoc.
   */
  public static <T> int partition(T[] arr, Comparator<? super T> order, int lb, int ub) {
    int pivotLoc = (lb + ub) / 2; //picks pivot
    T pivot = arr[pivotLoc];
    arr[pivotLoc] = arr[lb];
    arr[lb] = pivot; //pivot swapped to front
    int s = lb + 1;
    int l = ub + 1;
    while(s != l){
      if(order.compare(arr[s], pivot) <= 0){
        s++;
      } else {
        T temp = arr[l-1];
        arr[l-1] = arr[s];
        arr[s] = temp;
        l--;
      }
    } //sorted between lower and higher than pivot
    pivotLoc = s -1;
    arr[lb] = arr[s-1];
    arr[s-1] = pivot; //swaps pivot from front to real place

    return pivotLoc;//remember to update pivotLoc
  } // partition(T[], Comparator<? super T>, lb, ub)
} // class Quicksort
