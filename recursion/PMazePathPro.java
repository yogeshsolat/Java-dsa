public class PMazePathPro {
    public static void main(String[] args) {
        
        printMazePaths(1, 1, 3, 3, "");
    }

    public static void printMazePaths(int sr, int sc, int dr, int dc, String ans){

        if(sr == dr && sc == dc){
            System.out.println(ans);
            return;
        }
        // else if(sr > dr || sc > dc){  // We don't need the out-of-bound check because the loop limits (dr - sr and dc - sc) already prevent invalid moves.
        //     return;
        // }

        // The loop limit keeps each jump within the destination.
        for(int i = 1 ; i <= dr - sr ; i++){
            printMazePaths(sr + i, sc, dr, dc, ans+"v"+i);
        }

        for(int i = 1 ; i <= dc - sc ; i++){
            printMazePaths(sr , sc + i, dr, dc, ans+"h"+i);
        }

        for(int i = 1 ; i <= dr - sr  && i <= dc - sc; i++){
            printMazePaths(sr + i, sc + i, dr, dc, ans+"d"+i);
        }
    }
}

