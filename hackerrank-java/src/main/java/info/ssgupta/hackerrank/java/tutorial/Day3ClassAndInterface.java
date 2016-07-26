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

/*
Write a Person class with an instance variable, , and a constructor that takes an integer, , as a parameter. The constructor must assign  to  after confirming the argument passed as is not negative; if a negative argument is passed as , the constructor should set  to  and print Age is not valid, setting age to 0.. In addition, you must write the following instance methods:

yearPasses() should increase the  instance variable by .
amIOld() should perform the following conditional actions:
If , print You are young..
If  and , print You are a teenager..
Otherwise, print You are old..
*/
public class Day3ClassAndInterface {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    for (int i = 0; i < T; i++) {
      int age = sc.nextInt();
      Person p = new Person(age);
      p.amIOld();
      for (int j = 0; j < 3; j++) {
        p.yearPasses();
      }
      p.amIOld();
      System.out.println();
    }
    sc.close();
  }
}

class Person {

  private int age;

  public Person(int initialAge) {
    if (initialAge < 0) {
      System.out.println("Age is not valid, setting age to 0.");
    }
    age = initialAge;
  }

  public void amIOld() {
    if (age < 13) {
      System.out.println("You are young.");
    } else if (age >= 13 && age < 18) {
      System.out.println("You are teenager.");
    } else if (age >= 18) {
      System.out.println("You are old.");
    }
  }

  public void yearPasses() {
    age++;
  }
}
