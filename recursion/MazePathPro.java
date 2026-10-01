import java.util.ArrayList;

class MazePathPro{


    public static void main(String[] args) {
        ArrayList<String> ans =getMazePaths(1,1,3,3);
        System.out.println(ans);
    }

    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc){
        
        if(sr == dr && sc == dc){
            ArrayList<String> init = new ArrayList<>();
            init.add("");
            return init;
        }else if(sr > dr || sc > dc){
            ArrayList<String> init = new ArrayList<>();
            return init;
        }

        ArrayList<String> myPath = new ArrayList<>();

        // Try every vertical jump length that stays within the destination.
        for(int ms = 1 ; ms <= dr -sr; ms++ ){

            ArrayList<String> vpaths = getMazePaths(sr + ms, sc, dr, dc);

             for(String str : vpaths){
                myPath.add("v" + ms + str);
            }
        }

        for(int ms = 1 ; ms <= dc -sc; ms++ ){

            ArrayList<String> hpaths = getMazePaths(sr , sc + ms, dr, dc);

             for(String str : hpaths){
                myPath.add("h" + ms + str);
            }
        }

        for(int ms = 1 ; ms <= dr -sr && ms <= dc - sc; ms++ ){

            ArrayList<String> dpaths = getMazePaths(sr + ms, sc + ms, dr, dc);

             for(String str : dpaths){
                myPath.add("d" + ms + str);
            }
        }


        return myPath;
    }

}
