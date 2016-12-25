/* Sean Lachhander
 * Linked List Random Java Integers
 * This is the class definition for a java integer. It has a constructor that initializes
 * both fields to argument values sent to it.
 * It has two separate get methods for the two integer fields.
 * It "is a" Comparable and overrides the abstract method, and compares java integers by the value in the random integer field.
 * I will write a program that will insert random java integers into a LinkedList
 * and perform some calculations using methods in the LinkedList class.
 * */

import java.util.*;
import java.io.*;

public class LLRJI implements Comparable
{
  private int number;
  private int randomNumber;
  
  public LLRJI(int n, int r) // Overloaded constructor
  {
    number = n;
    randomNumber = r;
  }
  
  public int getnumber()   // getnumber method
  {
    return number;
  }
  
  public int getrandomNumber()   // get random number method
  {
    return randomNumber;
  }
  
  public int compareTo(Object o)     // compareTo needed to sort numbers.
  {
    LLRJI LLJavaInteger = (LLRJI)o;
    if (randomNumber > LLJavaInteger.randomNumber)
      return 1;
    else if (randomNumber == LLJavaInteger.randomNumber)
      return 0;
    else
      return -1;
  }
}
