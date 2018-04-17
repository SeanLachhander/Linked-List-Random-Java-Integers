/* Sean Lachhander
 * Assignment - Linked List Random Java Integers
 * This is the main method.
 * I will prompt the user to ask them the number of java integer nodes in the linked list.
 * I will use a loop to get (for each node) a random number between 1 and 150, create a java integer object,
 * and put it in the linked list.
 * I will write a program that will insert random java integers into a LinkedList
 * and perform some calculations using methods in the LinkedList class.
 * */

import java.util.Scanner;
import java.util.Random;
import java.util.*;
import java.io.*;

public class mainLLRJI {
    public static void main(String[] args) throws IOException {
        Random rand = new Random();


        int rAns;
        int[] Node = new int[50];
        Scanner keyboard = new Scanner(System.in);

        System.out.println("How many Java Integer Nodes in your Linked List?");
        int temp = keyboard.nextInt();

        Random randSpot = new Random();

        LLRJI p;
        LinkedList < LLRJI > Llist = new LinkedList < LLRJI > ();

        LinkedList < Integer > IntegerList = new LinkedList < Integer > (); // Integer List

        ListIterator li;

        for (int x = 0; x < temp; x++) {
            Node[x] = rand.nextInt(150) + 1; // Puts values into array of Node of 1-150
            Llist.add(new LLRJI(x, Node[x])); // Adds to Llist - LinkedList
        }

        li = Llist.listIterator();

        while (li.hasNext()) {
            p = (LLRJI) li.next();
        }

        Collections.sort(Llist); // Calls compareTo
        System.out.printf("%40s", "Sorted List:\n");
        li = Llist.listIterator(); // Reposition at beginning
        System.out.printf("%10s %30s %20s", "Index Number", "Original Index Number", "Random Number\n");
        System.out.println("------------------------------------------------------------------");
        while (li.hasNext()) // while the listIterator "li" has more values, it will run until there is no more.
        {
            for (int e = 0; e < temp; e++) // print out index number, original index number, and random numbers.
            {
                p = (LLRJI) li.next();
                System.out.printf("%6d", e);
                System.out.printf("%28d", p.getnumber());
                System.out.printf("%24d", p.getrandomNumber());
                System.out.printf("\n");
            }

            // Repeat the traversing with the list iterator, but this time sum up the random integer field.

            li = Llist.listIterator(); // reposition at beginning
            int sum = 0; // Temporary value
            double temporary = (((temp + 1.00) / 2.00) - 1.00); // What node it is 
            double trying = 0.00; // Temporary value

            System.out.println("------------------------------------------------------------------"); // Used as a line separator, median, sum, mean, range, original index number, and random number of java integer from a random spot will be located under.

            for (int i = 0; i < temp; i++) {
                p = (LLRJI) li.next();

                sum += p.getrandomNumber(); // will acquire the sum
                IntegerList.add(p.getrandomNumber()); // will put all the numbers that are sorted into the list.

                if (temporary == i) // when the node is equal to "i" this will run
                {
                    System.out.println("The Median of the random numbers is: " + (double) p.getrandomNumber()); // will find the median of the numbers
                } else if ((temporary % 1 != 0)) // however, if the number has two numbers for the median, it will take both numbers, add them, and divide by 2 to get the median. 
                {
                    double median1 = temporary + .5;
                    double median2 = temporary - .5;
                    if (median1 == i || median2 == i) // when it finds 1st median, it will add it into the variable trying, then when it finds the 2nd it'll add it again.
                    {
                        trying += p.getrandomNumber(); // median is a double in the case that two medians add and divide and have ".5" at the end since they are integers.
                    }
                }
            }

            if (trying > 0) // If trying is changed from its original state of 0, than this statement will be displayed
            {
                System.out.println("The Median of the random numbers is " + (trying / 2));
            }

            double average = (sum / temp); // finding the average of the random numbers
            int range = (Collections.max(IntegerList) - Collections.min(IntegerList)); // the max value of the integer in the list, and the minimum, and subtract.

            System.out.println("The Sum of the random numbers is: " + sum); // printing the sum
            System.out.printf("%s %.2f", "The Mean of the random numbers is:", average); // printing the average
            System.out.println("\nThe Range of the random numbers is: " + range); // printing the range
            int randomstuff = randSpot.nextInt(temp); // 
            int random3 = randSpot.nextInt(temp); // pick a random spot within the amount of nodes asked.
            System.out.println("Random Index Number picked is: " + random3 + " \nRandom Number of Java Integer from a Random Spot (Spot #" + (random3) + "): " + Node[random3]);
        }
    }
}
