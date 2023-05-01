package Project3;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class LadderGame {
    
    private int[][] ladder;
    private ArrayList<Integer> userSelections;
    private static int lives;
    
    public LadderGame(int panels, int lives) {
        this.ladder = new int[panels][2];
        this.userSelections = new ArrayList<>();
        LadderGame.lives = lives;
        generateLadder();
    }
    
    // Method to get total lives
    public int getLives() {
        return lives;
    }
    
    // Method to subtract 1 from total lives
    public void death() {
        lives--;
    }
    
    // Method to generate the ladder with random placement of tempered glass
    private void generateLadder() {
        Random rand = new Random();
        for (int i = 0; i < ladder.length; i++) {
            for (int j = 0; j < ladder[i].length; j++) {
                ladder[i][j] = rand.nextInt(2); // 0 represents regular glass, 1 represents tempered glass
            }
        }
    }
    
    // Method to print a ladder row
    private void printRow(int row) {
        System.out.print("|");
        for (int j = 0; j < ladder[row].length; j++) {
            if (ladder[row][j] == 0) {
                System.out.print("0");
            } else {
                System.out.print("1");
            }
            System.out.print("|");
        }
    }
    
    // Method to print the current ladder
    public void printCurrentLadder(int currentRow) {
        System.out.println("Current Ladder:");
        for (int i = 0; i < ladder.length; i++) {
            if (i == currentRow) {
                System.out.print(">");
            } else {
                System.out.print(" ");
            }
            printRow(i);
            System.out.println();
        }
    }
    
    // Method to print the answer ladder
    public void printAnswerLadder() {
        System.out.println("Answer Ladder:");
        for (int i = 0; i < ladder.length; i++) {
            printRow(i);
            System.out.println();
        }
    }
    
    // Method to print a blank ladder
    public void printBlankLadder() {
        System.out.println("Blank Ladder:");
        for (int i = 0; i < ladder.length; i++) {
            System.out.println("| |");
        }
    }
    
    // Method to get the current user selection
    public void getUserSelection() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a panel number: ");
        int userSelection = input.nextInt();
        userSelections.add(userSelection);
    }

    // Method to play the game
    public void play() {
        int currentRow = 0;
        while (currentRow < ladder.length) {
            printCurrentLadder(currentRow);
            getUserSelection();
            if (userSelections.get(userSelections.size() - 1) == ladder[currentRow][0]) {
                currentRow++;
            } else {
                death();
                if (lives == 0) {
                    System.out.println("You have lost all your lives. Game over.");
                    System.exit(0);
                }
            }
        }
        System.out.println("Congratulations! You have reached the top of the ladder!");
    }
    public static void main(String[] args) {
        LadderGame game = new LadderGame(5, 3);
        game.printAnswerLadder();
        game.printBlankLadder();
        int currentRow = 0;
        while (currentRow < game.ladder.length) {
            game.printCurrentLadder(currentRow);
            game.getUserSelection();
            int userSelection = game.userSelections.get(game.userSelections.size() - 1);
            int answer = game.ladder[currentRow][userSelection];
            if (answer == 0) {
                game.death();
                if (game.getLives() == 0) {
                    System.out.println("You Lost!");
                    System.out.println();
                    return;
                }
            } else {
                currentRow++;
            }
        }
        System.out.println("You Won!");
        System.out.println();
    }    
}