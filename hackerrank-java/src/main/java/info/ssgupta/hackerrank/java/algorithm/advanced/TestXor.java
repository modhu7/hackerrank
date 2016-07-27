/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.ssgupta.hackerrank.java.algorithm.advanced;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ssgupta
 */
public class TestXor {

  public static void main(String args[]) {
    int MAX_NUM = 32768;
    int[] input = {10, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
    List[][] array = new List[2][16];
    int mask = MAX_NUM;
    int i = 15;
    while (mask != 0) {
      for (int j=0; j< input.length; j++) {
        if(mask == (mask & input[j])){
          if(array[1][i] == null){
            array[1][i] = new ArrayList<>();
          }
          array[1][i].add(j);
        } else {
          if(array[0][i] == null){
            array[0][i] = new ArrayList<>();
          }
          array[0][i].add(j);
        }
      }
      mask = mask >>> 1;
      i--;
    }
    System.out.println(array);
  }

}
