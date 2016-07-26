/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.ssgupta.hackerrank.java.tutorial;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author ssgupta
 */
public class Day1DataTypes {
  
  public static void main(String[] args){
    int i=4;
    double d = 4.240;
    String s = "HackerRank";
    Scanner scan = new Scanner(System.in);
    int i1 = scan.nextInt();
    double d1 = scan.nextDouble();
    String temp = scan.nextLine(); // This is important this next line gives us a empty string.
    String s1 = scan.nextLine();
    
    System.out.println(i+i1);
    DecimalFormat df = new DecimalFormat("#.0");
    df.setRoundingMode(RoundingMode.FLOOR);
    System.out.println(df.format(d+d1));
    System.out.println(s+temp);
    System.out.println(s+s1);
  }
  
}
