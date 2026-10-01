
import java.util.Scanner;

public class KnightsTour {
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int arrSize = sc.nextInt();
        int row = sc.nextInt();
        int col = sc.nextInt();

        int[][] chess = new int[arrSize][arrSize];
        moveKnight(chess, row, col, 1);
        
    }


    public static void moveKnight(int chess[][], int row, int col, int move) {

        if(row < 0 || col < 0 || row >= chess.length || col >= chess.length || chess[row][col] > 0){
            return;
        }else if (move  ==  chess.length * chess.length) {
            // Explore from this square, then clear it so other move choices can try it.
        chess[row][col] = move;
            printBoard(chess);
            chess[row][col] = 0;
            return;
        }


        // Explore from this square, then clear it so other move choices can try it.
        chess[row][col] = move;
        moveKnight(chess, row - 2, col + 1, move + 1);
        moveKnight(chess, row - 1, col + 2, move + 1);
        moveKnight(chess, row + 1, col + 2, move + 1);
        moveKnight(chess, row + 2, col + 1, move + 1);
        moveKnight(chess, row + 2, col - 1, move + 1);
        moveKnight(chess, row + 1, col - 2, move + 1);
        moveKnight(chess, row - 1, col - 2, move + 1);
        moveKnight(chess, row - 2, col - 1, move + 1);
        chess[row][col] = 0;

    }

    public static void printBoard(int[][] chess){

        for (int[] arr : chess ) {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " " );
            }
            System.out.println();
        }

        System.out.println("--------------------------------------");
    }
}

