package HW3;
import java.util.Scanner;

public class Loops {

    //NOTE: DO NOT change anything in the boiler plate
    //If I added default code it is meant to be there
    //and should not be adjusted unless otherwise noted
    //(return statments are usually changed)

    //Make a method that will return true if a given 
    //String contains between 1 and 3 'e' chars.
    //Ex.
    //loopE("eat") -> true
    //eeat -> true
    //eeeat -> true
    //eeeeat -> false

    public static boolean loopE(String str){
        int count = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == 'e'){
                count++;
                if (count > 3){
                    return false;
                }
            }
        } 
        return count >= 1 && count <= 3;
    }

    //Given a String str and int n return a larger string
    //that is n copies of the original string 
    //Ex.
    //stringTimes("Code",2) ->"CodeCode"
    //stringTimes("Code",4) ->"CodeCodeCodeCode"
    public static String stringTimes(String str, int n) {
        String result = "";
        for (int i = 0; i < n; i++) {
            result += str;
        }
        return result;
    } 

    //Create a method Given a string, return the string where all of the "z"
    //Have been removed. Except do not remove a z at the start
    //or end
    //Ex.
    //stringZ("zHelloz") -> "zHelloz"
    //stringZ("nozthaznks") -> "nothanks"
    //stringZ("xksiazdjaasldzsajzasdz") -> "xksiadjaasldsajasdz"
    public static String stringZ(String str){
        if (str.length() <= 2) {
            return str;
        } else {
            String middle = str.substring(1, str.length() - 1).replaceAll("z","");
            return str.charAt(0) + middle + str.charAt(str.length() - 1);
        }
    }

    //Create a method that contains a while loop that allows for
    //The user to input numbers until the number 0 is entered. Each time a number is 
    //entered the total will be summed and then prompted for a second number. 
    //NOTE: I require the use of scanner here to get each integer from the user
    //Assume the numbers entered are integers
    //Also note that the method is void meaning you will not need to return anything
    //It will need to sysout the numbers however
    //Below is a sample output what I would like
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
    // Number: 2
    // The total so far is 24.
    // Number: 3
    // The total so far is 27.
    // Number: 0
    // TOTAL ENDED --- The total is 27.
    public static void sums(){
        try (Scanner scanner = new Scanner(System.in)) {
            int total = 0;
            int num = 0;

            System.out.println("I will add up the numbers you give me....");

            while(true){
                System.out.print("Number: ");
                num = scanner.nextInt();

                if (num == 0){
                    break;
                }
                total += num;
                System.out.println("The total so far is " + total + ".");
            }
            System.out.println("TOTAL ENDED --- The total is " + total + ".");
        }
    }

    public static void main(String[] args) {
    System.out.println(loopE("eat"));
    System.out.println(loopE("eeat"));
    System.out.println(loopE("eeeat"));

    System.out.println(stringTimes("Code", 2));
    System.out.println(stringTimes("Code", 4));

    System.out.println(stringZ("zHelloz"));
    System.out.println(stringZ("nozthaznks")); 
    System.out.println(stringZ("xksiazdjaasldzsajzasdz"));

    sums();
    }
    
}
