/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.ssgupta.hackerrank.java.tutorial;

import java.util.Scanner;

/**
 *
 * @author ssgupta
 */
public class Day2Operators {

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    double mealCost = scan.nextDouble(); // original meal price
    int tipPercent = scan.nextInt(); // tip percentage
    int taxPercent = scan.nextInt(); // tax percentage
    scan.close();

    // Write your calculation code here.
    double doubleTipPercent = (double) tipPercent;
    double doubleTaxPercent = (double) taxPercent;
    // cast the result of the rounding operation to an int and save it as totalCost 
    int totalCost = (int) Math.round(mealCost*(doubleTipPercent/100) + mealCost*(doubleTaxPercent/100) + mealCost);
    System.out.println("The total cost of meal is " + totalCost + " dollars.s");

    // Print your result
  }

}
