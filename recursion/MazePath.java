
import java.util.ArrayList;

public class MazePath{

    public static void main(String[] args) {

        System.out.println(getMazePath(1,1,3,3));
        
    }

    /*
        my version
     */
    // public static ArrayList<String> getMazePath(int sr, int sc, int dr, int dc){
        
    //     if(sr == dr && sc == dc){
    //         ArrayList<String> init = new ArrayList<>();
    //         init.add("");
    //         return init;
    //     }else if(sr > dr || sc > dc){
    //         ArrayList<String> init = new ArrayList<>();
    //         return init;
    //     }

    //     ArrayList<String> vpaths = getMazePath(sr + 1, sc, dr, dc);
    //     ArrayList<String> hpaths = getMazePath(sr, sc + 1, dr, dc);

    //     ArrayList<String> myPath = new ArrayList<>();

    //     for(String str : vpaths){
    //         myPath.add("v" + str);
    //     }

    //     for(String str : hpaths){
    //         myPath.add("h" + str);
    //     }

    //     return myPath;
    // }

    /*
        Sumit sir version
    */
    public static ArrayList<String> getMazePath(int sr, int sc, int dr, int dc){
        
        if(sr == dr && sc == dc){
            ArrayList<String> init = new ArrayList<>();
            init.add("");
            return init;
        }

        ArrayList<String> vpaths =  new ArrayList<>();
        ArrayList<String> hpaths =  new ArrayList<>();

        if(sr < dr){
            vpaths = getMazePath(sr + 1, sc, dr, dc);
        }

        if(sc < dc){
            hpaths = getMazePath(sr, sc + 1, dr, dc);
        }

        ArrayList<String> myPath = new ArrayList<>();

        for(String str : vpaths){
            myPath.add("v" + str);
        }

        for(String str : hpaths){
            myPath.add("h" + str);
        }

        return myPath;
    }
}