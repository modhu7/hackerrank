/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.ssgupta.hackerrank.java.algorithm.easy;

import java.util.Scanner;

/**
 *
 * @author ssgupta
 */
public class CircularArrayRotation {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int k = in.nextInt();
    int q = in.nextInt();
    int[] array = new int[n];
    for (int i = 0; i < n; i++) {
      array[i] = in.nextInt();
    }
    for (int i = 0; i < q; i++) {
      int newindex = in.nextInt();
      int oldindex = newindex - k;
      while (oldindex < 0) {
        oldindex = n + oldindex;
      }
      System.out.println(array[oldindex]);
    }

  }
}
