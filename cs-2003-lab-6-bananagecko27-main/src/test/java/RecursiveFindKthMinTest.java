package test.java;

/**
 * DO NOT DISTRIBUTE.
 *
 * This code is intended to support the education of students associated with the Tandy School of
 * Computer Science at the University of Tulsa. It is not intended for distribution and should
 * remain within private repositories that belong to Tandy faculty, students, and/or alumni.
 */
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import main.java.RecursiveFindKthMin;
import org.junit.After;
import org.junit.Test;
import test.java.TUGrader.DisplayName;
import test.java.TUGrader.TestGroup;

/**
 * This class provides a set of unit tests for the {@code RecursiveFindKthMin} class
 * using the JUnit testing framework and the Java Reflection API.
 */
public class RecursiveFindKthMinTest {

  private static List<Integer> randomUniqueIntegers(int n) {
    Random rng = new Random();
    Set<Integer> set = rng.ints(n, -10_000, 10_000).boxed().collect(Collectors.toSet());
    while (set.size() < n) {
      set.add(rng.nextInt(20_000) - 10_000);
    }
    return new ArrayList<Integer>(set);
  }

  @After
  public void resetSTDIO() {
    TUGrader.resetStdIO();
  }

  @Test
  @TestGroup("findKthMin")
  @DisplayName(
      "findKthMin(List, int) should return the smallest integer in the input list for k == 1")
  public void testFindKthMinShouldReturnMinInteger() {
    List<Integer> list = RecursiveFindKthMinTest.randomUniqueIntegers(100);
    assertThat(RecursiveFindKthMin.findKthMin(list, 1), is(equalTo(Collections.min(list))));
  }

  @Test
  @TestGroup("findKthMin")
  @DisplayName("findKthMin(List, int) should return the kth min for all 1 <= k <= n")
  public void testFindKthMinShouldReturnKthMin() {
    int size = 10;
    List<Integer> list = RecursiveFindKthMinTest.randomUniqueIntegers(size);
    for (int k = 1; k < size; k++) {
      Integer min = RecursiveFindKthMin.findKthMin(list, k);
      Collections.sort(list);
      assertThat(min, is(equalTo(list.get(k - 1))));
      list = RecursiveFindKthMinTest.randomUniqueIntegers(size);
    }
    assertThat(
        RecursiveFindKthMin.findKthMin(list, list.size()), is(equalTo(Collections.max(list))));
  }

  @Test
  @TestGroup("findKthMin")
  @DisplayName("findKthMin(List, int) should be recursive")
  public void testFindKthMinShouldBeRecursive() {
    List<PeskyComparable> list = new ArrayList<>();
    for (int i = 0; i < 9; i++) {
      list.add(new PeskyComparable(i, -1));
    }
    list.add(new PeskyComparable(9, 10));
    try {
      RecursiveFindKthMin.findKthMin(list, 10);
    } catch (UnsupportedOperationException e) {
      throw e;
    } catch (RuntimeException e) {
      int calls = 0;
      while (calls < e.getStackTrace().length
          && !e.getStackTrace()[calls].getMethodName().contains("findKthMin")) {
        calls++;
      }
      while (calls < e.getStackTrace().length
          && e.getStackTrace()[calls].getMethodName().contains("findKthMin")) {
        calls++;
      }
      assertThat(calls, is(greaterThanOrEqualTo(4)));
    }
  }

  @Test
  @TestGroup("exceptions")
  @DisplayName("findKthMin(List, int) should return null if the input list is empty")
  public void testFindKthMinShouldReturnNullWhenListIsEmpty() {
    assertThat(
        RecursiveFindKthMin.findKthMin(Collections.<Integer>emptyList(), 1), is(nullValue()));
  }

  @Test
  @TestGroup("exceptions")
  @DisplayName(
      "findKthMin(List, int) should return null if the kth min is undefined because the list"
          + " contains duplicates")
  public void testFindKthMinShouldReturnNullWhenListHasDuplicates() {
    List<Integer> list = RecursiveFindKthMinTest.randomUniqueIntegers(10);
    list.addAll(List.copyOf(list));
    for (int i = 0; i < list.size(); i++) {
      assertThat(RecursiveFindKthMin.findKthMin(list, list.size() + i + 1), is(nullValue()));
    }
  }

  @Test
  @TestGroup("exceptions")
  @DisplayName("findKthMin(List, int) should not modify the input list")
  public void testFindKthMinShouldNotModifyTheList() {
    List<Integer> list =
        Collections.unmodifiableList(RecursiveFindKthMinTest.randomUniqueIntegers(100));
    assertThat(
        RecursiveFindKthMin.findKthMin(list, list.size()), is(equalTo(Collections.max(list))));
  }

  @Test
  @TestGroup("main")
  @DisplayName("main() should print the min and max from each row in the input file")
  public void testMainShouldPrintKthMinOfInput() {
    int q = 10;
    StringBuilder input = new StringBuilder();
    input.append(String.format("%d\n", q));
    List<Integer> expected = new ArrayList<>();
    for (int k = 1; k <= q; k++) {
      input.append(String.format("%d %d\n", q, k));
      List<Integer> list = RecursiveFindKthMinTest.randomUniqueIntegers(q);
      input.append(list.stream().map(Object::toString).collect(Collectors.joining(" ")));
      input.append("\n");
      Collections.sort(list);
      expected.add(list.get(k - 1));
    }
    System.setIn(new ByteArrayInputStream(input.toString().getBytes()));
    ByteArrayOutputStream stdoutCapture = new ByteArrayOutputStream();
    System.setOut(new PrintStream(stdoutCapture));
    RecursiveFindKthMin.main(new String[0]);
    List<Integer> output =
        Arrays.stream(stdoutCapture.toString().trim().split("\n"))
            .map(s -> s.trim())
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    assertThat(output, is(equalTo(expected)));
  }

  private static class PeskyComparable implements Comparable<PeskyComparable> {

    private int crash;
    private int val;

    public PeskyComparable(int val, int crash) {
      this.val = val;
      this.crash = crash;
    }

    public int compareTo(PeskyComparable pc) {
      if (this.crash == 0) {
        throw new RuntimeException("stop comparing me!!!");
      }
      if (this.crash > 0) {
        this.crash--;
      }
      return this.val - pc.val;
    }
  }
}
