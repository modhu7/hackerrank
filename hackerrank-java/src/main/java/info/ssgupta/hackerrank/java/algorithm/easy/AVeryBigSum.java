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
public class AVeryBigSum {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int arr[] = new int[n];
    long sum = 0;
    for (int arr_i = 0; arr_i < n; arr_i++) {
      arr[arr_i] = in.nextInt();
      sum = sum + (long) arr[arr_i];
    }
    System.out.println(sum);
  }
}
