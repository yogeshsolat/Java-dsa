public class PMazePath {
    
    public static void main(String[] args) {
        
        printMazePaths(1, 1, 3, 3,"");
    }

    public static void printMazePaths(int sr, int sc, int dr, int dc, String ans) {
        
        if(sr == dr && sc == dc){
            System.out.println(ans);
            return;
        }else if(sr > dr || sc > dc){
            return;
        }

        // This printer passes the partial path forward with each recursive call.
        printMazePaths(sr + 1, sc, dr, dc, ans +"v" );
        printMazePaths(sr, sc + 1, dr, dc, ans +"h" );



    }
}

