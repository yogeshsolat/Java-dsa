import java.util.Scanner;

public class FloodFill {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();

        int[][] arr = new int[r][c];

        for(int i = 0; i < arr.length ; i++){
            for(int j = 0; j < arr[i].length ;  j++){
                arr[i][j] = sc.nextInt();
            }
        }

        // for (int[] arr1 : arr) {
        //     for (int j = 0; j < arr1.length; j++) {
        //         arr1[j] = sc.nextInt();
        //     }
        // }

        boolean[][] visited = new boolean[r][c];

        System.out.println("your array");
        for(int i = 0; i < arr.length ; i++){
            for(int j = 0; j < arr[i].length;  j++){
                System.out.print(arr[i][j]); 
            }
            System.out.println();
        }

         System.out.println("your paths");
        floodFill(arr, 0, 0, "", visited);
    }

    public static void floodFill(int[][] maze, int row, int col, String ans, boolean[][] visited){

        if(row < 0 || col < 0 || row == maze.length || col == maze[0].length ||
            maze[row][col] == 1 || visited[row][col] == true
        ){
            return;
         }

        if(row == maze.length - 1 && col == maze[0].length - 1){
            System.out.println(ans);
            return;
        }

        // Mark this path during exploration, then undo the mark on return.
        visited[row][col] = true;
        floodFill(maze, row - 1, col, ans + "t", visited);
        floodFill(maze, row, col - 1, ans + "l", visited);
        floodFill(maze, row + 1, col, ans + "d", visited);
        floodFill(maze, row, col + 1, ans + "r", visited);
        visited[row][col] = false;

    }
}

