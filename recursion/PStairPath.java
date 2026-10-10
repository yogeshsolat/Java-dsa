public class PStairPath {

    public static void main(String[] args) {
        System.out.println("here ");
        printSP(4, "");
    }

    public static void printSP(int n, String path) {

        // Zero completes a path; the negative remainder case rejects overshooting.
        if (n == 0) {
            System.out.println(path);
            return;
        } else if (n < 0) {
            return;
        }

        printSP(n - 1, path + "1");
        printSP(n - 2, path + "2");
        printSP(n - 3, path + "3");

    }

    // similar as above just written better 
    public static void psp(int n, String path) {

        if (n == 0) {
            System.out.println(path);
            return;
        } else if (n < 0) {
            return;
        }

        for (int i = 1; i <= 3; i++) {
            psp(n - i, path + i);
        }
    }
}
