/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.ssgupta.hackerrank.java.algorithm.advanced;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author ssgupta
 */
public class XORKey {

  public static int MAX_NUM = 32768;

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int T = in.nextInt();
    for (int i = 0; i < T; i++) {
      int N = in.nextInt();
      int Q = in.nextInt();
      int[] arrayNumbers = new int[N];
      for (int j = 0; j < N; j++) {
        arrayNumbers[j] = in.nextInt();
      }

      List[][] arrayStore = new List[2][16];
      int mask = MAX_NUM;
      int store_i = 15;
      while (mask != 0) {
        for (int store_j = 0; store_j < arrayNumbers.length; store_j++) {
          if (mask == (mask & arrayNumbers[store_j])) {
            if (arrayStore[1][store_i] == null) {
              arrayStore[1][store_i] = new ArrayList<>();
            }
            arrayStore[1][store_i].add(store_j);
          } else {
            if (arrayStore[0][store_i] == null) {
              arrayStore[0][store_i] = new ArrayList<>();
            }
            arrayStore[0][store_i].add(store_j);
          }
        }
        mask = mask >>> 1;
        store_i--;
      }

      for (int j = 0; j < Q; j++) {
        int a = in.nextInt();
        int p = in.nextInt();
        int q = in.nextInt();

        Set<Integer> resultSet = new HashSet<Integer>();
        mask = MAX_NUM;
        int bitIndex = 15;
        int binaryIndexNeeded = 0;
        while (!resultSet.isEmpty()) {
          if ((a & mask) == mask) {
            binaryIndexNeeded = 0;
          } else {
            binaryIndexNeeded = 1;
          }
          for (int k = p - 1; k < q; k++) {
            if(arrayStore[binaryIndexNeeded][bitIndex].contains(k)){
              resultSet.add(k);
            }
          }
          bitIndex--;
          mask = mask >>> 1;
        }
        if(resultSet.size()==1){
          int result = (int)resultSet.toArray()[0];
          System.out.println(a^arrayNumbers[result]);
        }else{
          
        }
      }
    }
  }

}
