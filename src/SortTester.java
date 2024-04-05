import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import java.math.BigInteger;
import org.junit.jupiter.api.Test;

/**
 * Tests of Sorter objects.
 *
 * @author Lucas Willet and Sam R
 */
public class SortTester {

  // +---------+-----------------------------------------------------
  // | Globals |
  // +---------+

  Sorter sorter;

  // +-------+-------------------------------------------------------
  // | Tests |
  // +-------+

  @Test
  public void fakeTest() {
    assertTrue(true);
  } // fakeTest()

  @Test
  public void orderedStringTest() {
    String[] original = { "alpha", "bravo", "charlie", "delta", "foxtrot" };
    String[] expected = original.clone();
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(expected, original);
  } // orderedStringTest

  @Test
  public void reverseOrderedStringTest() {
    String[] original = { "foxtrot", "delta", "charlie", "bravo", "alpha" };
    String[] expected = { "alpha", "bravo", "charlie", "delta", "foxtrot" };
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(expected, original);
  } // orderedStringTest

  @Test //self made test 1
  public void randomOrderedStringTest() {
    String[] original = {"delta" , "hippo", "alpha", "charlie", "bravo", "george", "foxtrot", "jingle"};
    String[] expected = { "alpha", "bravo", "charlie", "delta", "foxtrot", "george", "hippo", "jingle"};
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(expected, original);
  } // randomOrderedStringTest

  @Test //self made test 2
  public void randomOrderedIntTest() {
    Integer[] original = {4, 7, 1, 3, 2, 6, 5, 8};
    Integer[] expected = {1, 2, 3, 4, 5, 6, 7, 8};
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(expected, original);
  } // randomOrderedIntTest

  @Test //self made test 3
  public void emptyOrderedIntTest() {
    Integer[] original = {};
    Integer[] expected = {};
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(expected, original);
  } // emptyOrderedIntTest

  @Test //self made test 4
  public void singleOrderedIntTest() {
    Integer[] original = {4};
    Integer[] expected = {4};
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(expected, original);
  } // singleOrderedIntTest

  @Test //self made test 5
  public void repeatedOrderedStringTest() {
    String[] original = {"A", "C", "A", "B", "A"};
    String[] expected = {"A", "A", "A", "B", "C"};
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(expected, original);
  } // repeatedOrderedStringTest

} // class SortTester
