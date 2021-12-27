/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simple_calculator;
import java.io.*;
import java.lang.*;
import java.lang.Math;
import java.util.Scanner;
/**
 *
 * @author NoteBook
 */
public class Simple_calculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
 /*   double num1, num2;
  
        // Take input from the user
        Scanner sc = new Scanner(System.in);
  
        System.out.println("Enter the numbers");
  
        // take the inputs
        num1 = sc.nextDouble();
  
        num2 = sc.nextDouble();
  
        System.out.println("Enter the operator (+,-,*,/)");
  
        char op = sc.next().charAt(0);
  
        double o = 0;
  
        switch (op) {
  
        // case to add two numbers
        case '+':
  
            o = num1 + num2;
  
            break;
  
        // case to subtract two numbers
        case '-':
  
            o = num1 - num2;
  
            break;
  
        // case to multiply two numbers
        case '*':
  
            o = num1 * num2;
  
            break;
  
        // case to divide two numbers
        case '/':
  
            o = num1 / num2;
  
            break;
  
        default:
  
            System.out.println("You enter wrong input");
  
            break;
        }
  
        System.out.println("The final result:");
  
        System.out.println();
  
        // print the final result
        System.out.println(num1 + " " + op + " " + num2
                           + " = " + o);
        
        */
        int dec = 18;
      // converting to binary and representing it in a string
      String bin = Integer.toBinaryString(dec);
      System.out.println(bin);
    }


    }
    

