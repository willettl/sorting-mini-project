import java.util.Comparator;

/**
 * Sort through an array using merge sort.
 *
 * @author Lucas Willett, Sam R
 */

public class MergeSort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new MergeSort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  MergeSort() {
  } // MergeSort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    if(values.length != 0){
      mergesort(values, order, 0, values.length);
    }
  } // sort(T[], Comparator<? super T>

  <T> void mergesort(T[] values, Comparator<? super T> order, int lb, int ub){
    if((lb == ub) || (lb+1 == ub)){
      return;
    } else {
      int mid = (lb + ub)/2;
      mergesort(values, order, lb, mid);
      mergesort(values, order, mid+1, ub);
      merge(values, order, lb, ub, mid);
    }
  }

  <T> void merge(T[] values, Comparator<? super T> order, int lb, int ub, int mid){
    T[] dummy = java.util.Arrays.copyOf(values, values.length);
    int cur1 = lb;
    int cur2 = mid;
    int dum = lb;
    while((cur1 != mid) && (cur2 != ub)){
      if(order.compare(values[cur1], values[cur2]) < 0){
        dummy[dum] = values[cur1];
        dum++;
        cur1++;
      } else {
        dummy[dum] = values[cur2];
        dum++;
        //add cur2 to dummy array
        cur2++;
      }
    }
    while(cur1 != mid){
      dummy[dum] = values[cur1];
      dum++;
      //add cur1 to the dummy array
      cur1++;
    }
    while(cur2 != ub){
      dummy[dum] = values[cur2];
      dum++;
      //add cur2 to the dummy array
      cur2++;
    }
    values = dummy;
  }
} // class MergeSort
