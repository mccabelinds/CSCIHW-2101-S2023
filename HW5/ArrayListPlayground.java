package HW5;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;


public class ArrayListPlayground {
    public static void main(String[] args) {
    // Question 1
    // Write Java statements that do the following:
    // a) Declare an arrayList nums of 15 elements of type int.
        ArrayList<Integer> nums = new ArrayList<Integer>(15);
        for (int i = 0; i < 15; i++) {
            nums.add(i);
        }
    // b) Output the value of the tenth element of the array nums.
        System.out.println(nums.get(9));
    // c) Set the value of the 5th element of the array nums to 99.
        nums.set(4, 99);
    // d) set the value of the 13th element to 15
        nums.set(12, 15);
    // d) set the value of the 2nd element to 6
        nums.set(1, 6);
    // d) Set the value of the 9th element of the array nums to the sum of the 13th and 2nd elements of the array nums.
        nums.set(8, nums.get(12) + nums.get(1));
         
    // Question 2
    // a) create an arrayList of Strings that contain each day of the week.(starting on monday)
        ArrayList<String> days = new ArrayList<String>(Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"));
    // b) output each of the days of the week
        System.out.println(days);
    // c) output the days of the week that we have class 
        System.out.println(days.get(0) + " " + days.get(2) + " " + days.get(4));
    // d) change the arrayList to start on Sunday
        days.set(0, "Sunday");


    // Question 3 
    // a) create an ArrayList and prompt the user for numbers to add to it until the number 0 is selected
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        Scanner input = new Scanner(System.in);
        int num = 1;
        while (num != 0) {
            System.out.println("Enter a number to add to the list (0 to stop): ");
            num = input.nextInt();
            if (num != 0) {
                numbers.add(num);
            }
        }
    // b) return the largest and smallest number
        int largest = numbers.get(0);
        int smallest = numbers.get(0);
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) > largest) {
                largest = numbers.get(i);
            }
            if (numbers.get(i) < smallest) {
                smallest = numbers.get(i);
            }
        }
        System.out.println("Largest: " + largest + " Smallest: " + smallest);
    // c) return the ArrayList sorted smallest to largest
        Collections.sort(numbers);
        System.out.println(numbers);
    // d) take that ArrayList see if its size is divisable by 3 and then output the ArrayList in a matrix format

    while (num != 0) {
        System.out.println("Enter a number to add to the list (0 to stop): ");
        num = input.nextInt();
        if (num != 0) {
            numbers.add(num);
        }
    }
    
    // check if the ArrayList size is divisible by 3, if not, ask user for more numbers
    while (numbers.size() % 3 != 0) {
        System.out.println("ArrayList size is not divisible by 3. Please enter " + (3 - numbers.size() % 3) + " more number(s) to create the matrix: ");
        num = input.nextInt();
        numbers.add(num);
    }
    
    // sort the ArrayList
    Collections.sort(numbers);
    
    // print the ArrayList in matrix format
    for (int i = 0; i < numbers.size(); i++) {
        System.out.print(numbers.get(i) + " ");
        if ((i + 1) % 3 == 0) {
            System.out.println();
        }
    }

    // NOTE: make the matrix n X 3 so it can be n rows by 3 columns 
    // EX. ArrayList [1,2,3,4,5,6,7,8,9]
    // 1 2 3
    // 4 5 6
    // 7 8 9
    // NOTE: If the ArrayList is NOT divisable by 3 ask the user for more numbers and add them until it is
    // ArrayList Size: 7
    // Please enter 2 more numbers to create the matrix...
    // 
    // Hint 1: use collections sort to sort the numbers 
    // Hint 2: you can see if the size of the array list is divisible by 3 by running:
    //  numbers.size()%3==0
    // Hint 3: You can use this logic to print the array list in a 3x3 pattern once its created:
    // for(int i=0;i<numbers.size();i++)
    //     {
    //         System.out.print(numbers.get(i)+" ");
    //         if((i+1)%3==0)
    //         {
    //             System.out.println();
    //         }
    //     }
        
   }
}





   

