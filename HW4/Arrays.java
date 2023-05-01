package HW4;

import java.util.Scanner;

public class Arrays {

    // CONVERT THE SUMS METHOD FROM HW3 TO ADD EACH VALUE TO AN ARRAY AND THEN OUTPUT THE 
    // ARRAY AND THE TOTAL.
    // SEE HW3 FOR SUMS METHOD
    // If you want to use an ArrayList for the inputs to be dynamic that is okay
    // Otherwise if you are using a regular array, assume the size is 10 total. 
    // EXAMPLE 
    // I will add up the numbers you give me....
    // Number: 12
    // The total so far is 12.
    // Number: 2
    // The total so far is 14.
    // Number: 3
    // The total so far is 17.
    // Number: 4
    // The total so far is 21.
    // Number: 1
    // The total so far is 22.
    // Number: 0
    // Total: 22
    // Array: {12,2,3,4,1,0}
    public static void Arraysums(){
        try(Scanner scanner = new Scanner(System.in)){
            int[] inputs = new int[10];
            int index = 0;
            int total = 0;

            System.out.println("I will add up the numbers you give me....");

            while(index < inputs.length){
                System.out.print("Number: ");
                int num = scanner.nextInt();

                if (num == 0){
                    break;
                }

                total += num;
                System.out.printf("The total so far is %d.\n", total);

                inputs[index] = num;
                index++;
            }
            System.out.printf("Total: %d\n", total);
            System.out.print("Array: {");
            for (int i = 0; i < index; i++){
                System.out.printf("%d", inputs[i]);
                if (i != index - 1){
                    System.out.print(",");
                }
            }
            System.out.println("}");
        }
    }

    // Create a method that will brute force a password EX.
    // bruteForce("ZZZZ")
    // The program should then guess each char of the string and compare it to see if it is equal
    // to the index of the alphabet char array below
    // Output Example:
    // Z
    // ZZ
    // ZZZ
    // ZZZZ

    // Hint 1: using a char array for the password is helpful here 
    // Hint 2: using the method .toCharArray is a way to convert the password parameter to a char array as well
    // From there creating for and while loops to compare the values is trivial

public static void bruteForce(String password) {
    char[] alphabet = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            '!', '@', '#', '$', '%', '^', '&', '*', '(', ')','<','>','/','?'};
    char[] guess = new char[password.length()]; // Initialize guess array with password length
    for (int i = 0; i < guess.length; i++){
        guess[i] = 'a'; // Initialize guess array with 'a'
    }
    while (true){
        for (int i = 0; i < guess.length; i++){
            if (guess[i] == password.charAt(i)){
                System.out.print(guess[i]);
            }
            else{
                for (int j = 0; j < alphabet.length; j++){
                    if (guess[i] == alphabet[j]){
                        guess[i] = alphabet[j+1];
                        break;
                    }
                }
                System.out.print(guess[i]);
            }
        }
        System.out.println();
        if (String.valueOf(guess).equals(password)){
            break;
        }
    }
 }

    // Create a method that will sort an Array of integers from smallest to greatest.
    // NOTE: You CANNOT use the built in Arrays.sort method
    // Ex. 
    // sorter([9,10,2,5,3,4,7,8]) -> [2,3,4,5,7,8,9,10]

    // Hint 1: a temp Array is a helpful way to store variables for comparing 
    // Hint 2: 2 nested For loops should be all thats needed for the swapping logic
 
public static int[] sorter(int[] nums){
        int n = nums.length;
        int [] sortedArray = new int[n];
        for (int i = 0; i < n; i++){
            sortedArray[i] = nums[i];
        }
        for (int i = 0; i < n-1; i++){
            for (int j = 0; j < n-i-1; j++){
                if (sortedArray[j] > sortedArray[j+1]){
                    int temp = sortedArray[j];
                    sortedArray[j] = sortedArray[j+1];
                    sortedArray[j+1] = temp;
                }
            }
        }
        return sortedArray;
    }


    public static void main(String[] args) {
        // Tester main method for your methods
        System.out.println("Hello World!");
        Arraysums();
        String password = "ZZZZ";
        bruteForce(password);
        int[] nums = {9,10,2,5,3,4,7,8};
        int[] sortedArray = sorter(nums);
        System.out.print("[");
        for (int i = 0; i < sortedArray.length; i++){
            if (i != sortedArray.length - 1){
                System.out.printf("%d,", sortedArray[i]);
            }
            else{
                System.out.printf("%d", sortedArray[i]);
            }
        }
    }
}