
import java.util.ArrayList;
import java.util.List;

public class GetMazePathJumps {

    public static void main(String[] args) {

        List<String> ans = getMazePathsJumps(1, 1, 3, 3);
        System.out.println(ans);
    }

    public static List<String> getMazePathsJumps(int sr, int sc, int dr, int dc) {

        if(sr == dr && sc == dc){
            List<String> emptylist = new ArrayList<>();
            emptylist.add("");
            return emptylist;
        }else if(sr > dr || sc > dc){
            List<String> emptylist = new ArrayList<>();
            return emptylist;
        }

        List<String> mlist = new ArrayList<>();

        for (int i = 1; i <= 3; i++) {
            List<String> vpaths = getMazePathsJumps(sr + i, sc, dr, dc);
            
            for(String path : vpaths ){
                mlist.add("v" + i + path);
            }
        }

        for (int i = 1; i <= 3; i++) {
            List<String> vpaths = getMazePathsJumps(sr, sc + i, dr, dc);
            
            for(String path : vpaths ){
                mlist.add("h" + i + path);
            }
        }

        for (int i = 1; i <= 3; i++) {
            List<String> vpaths = getMazePathsJumps(sr + i, sc + i, dr, dc);
            
            for(String path : vpaths ){
                mlist.add("d" + i + path);
            }
        }

        return mlist;
    }

}
