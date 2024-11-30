package main.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/** A recursive solution to the kth min problem. */
public class RecursiveFindKthMin {

  
  /**
   * Returns the kth minimum element from the specified list using a recursive implementation.
   * @param list the list of input elements
   * @param k the kth minimum to select where {@code k == 1} is the smallest element and
   *     {@code k == n} is the largest element
   * @return the kth minimum in the specified list or {@code null} if the kth min is undefined
   */
  public static <E extends Comparable<E>> E findKthMin(List<E> list, int k) {
    // TODO: implement findKthMin(List, int)
    if(list.isEmpty() || k>list.size()){
      return null;
    }
    
    return findKthMin(list, (E)(Integer)Integer.MIN_VALUE, k);
  }

  private static <E extends Comparable<E>> E findKthMin(List<E> list, E lastMin, int K) {
    if(K==0){
      return lastMin;
    }

    lastMin = findMin(list, lastMin);
    return findKthMin(list, lastMin, K-1);
    }

    private static <E extends Comparable<E>> E findMin(List<E> list, E lastMin) {
      E min = (E)(Integer)Integer.MAX_VALUE;

      for(E elt: list){
      if (elt.compareTo(min)<0 && elt.compareTo(lastMin)>0){
        min = elt;
      }
    }

    return min;
  }
   
  public static void main(String[] args){
    // implement main(String[])
    Scanner file = new Scanner(System.in);
    int numLines = file.nextInt();
    file.nextLine();
    
     for(int i=0; i<numLines; i++){
     // ArrayList<Integer> list1  = new ArrayList<>();
      ArrayList<Integer> list2  = new ArrayList<>();
      String input1 = file.nextLine();
      Scanner scan1 = new Scanner(input1);
      String input2 = file.nextLine();
      Scanner scan2 = new Scanner(input2);
      
      int lengthOfList = scan1.nextInt();
      int kthIndex = scan1.nextInt();
      
      //int k=0;

      for(int j=0; j<lengthOfList; j++){
        int num = scan2.nextInt();
        list2.add(num);
      }

      /*while(scan1.hasNext()){
         int num = scan1.nextInt();//Integer.parseInt(scan1.next());
        list1.add(num);
      } */
      
      //k = list1.get(1);

      /*while(scan2.hasNext()){
        int num = scan2.nextInt();//Integer.parseInt(scan2.next());
        list2.add(num);
      } */
      
      
      System.out.println(findKthMin(list2, kthIndex));
      
    }
  } 
}