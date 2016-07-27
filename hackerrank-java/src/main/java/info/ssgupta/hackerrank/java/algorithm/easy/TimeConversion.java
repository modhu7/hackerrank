/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.ssgupta.hackerrank.java.algorithm.easy;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author ssgupta
 */
public class TimeConversion {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String time = in.next();
    String nMinSec = time.substring(2, 8);
    String nHour = time.substring(0, 2);
    Integer hourInt = new Integer(nHour);
    DecimalFormat df = new DecimalFormat("00");
    if (time.endsWith("PM")) {
      hourInt += 12;
      if (hourInt == 24) {
        hourInt = 12;
      }
      System.out.println(df.format(hourInt) + nMinSec);
    } else {
      if(hourInt==12){
        hourInt=0;
      }
      System.out.println(df.format(hourInt) + nMinSec);
    }
  }
}
