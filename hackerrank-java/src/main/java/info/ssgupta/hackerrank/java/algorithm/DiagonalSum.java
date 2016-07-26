/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.ssgupta.hackerrank.java.algorithm;

import java.util.Scanner;

/**
 *
 * @author ssgupta
 */

/*
Given a square matrix of size , calculate the absolute difference between the sums of its diagonals.

Input Format

The first line contains a single integer, . The next  lines denote the matrix's rows, with each line containing space-separated integers describing the columns.

Output Format

Print the absolute difference between the two sums of the matrix's diagonals as a single integer.


 */
public class DiagonalSum {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int sum1 = 0;
    int sum2 = 0;
    int a[][] = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        a[i][j] = in.nextInt();
        if (i == j) {
          sum1 += a[i][j];
        }
        if (j == (n - 1 - i)) {
          sum2 += a[i][j];
        }
      }
    }
  }
}

