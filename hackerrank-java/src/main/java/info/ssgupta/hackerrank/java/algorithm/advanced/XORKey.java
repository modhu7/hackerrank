/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.ssgupta.hackerrank.java.algorithm.advanced;

import java.util.Scanner;

/**
 *
 * @author ssgupta
 */
public class XORKey {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int T = in.nextInt();
    for (int i = 0; i < T; i++) {
      int N = in.nextInt();
      int Q = in.nextInt();
      int[] array = new int[N];
      for (int j = 0; j < N; j++) {
        array[j] = in.nextInt();
      }
      for (int j = 0; j < Q; j++) {
        int a = in.nextInt();
        int p = in.nextInt();
        int q = in.nextInt();
        int max = 0;
        for(int k=p-1;k<q;k++){
          int xorValue = a^array[k];
          if(xorValue>max){
            max = xorValue;
          }
        }
        System.out.println(max);
      }
    }
  }

}
