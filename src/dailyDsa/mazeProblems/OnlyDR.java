package dailyDsa.mazeProblems;

import java.util.ArrayList;

public class OnlyDR {
    public static void main(String[] args) {
        path("",3,3);
        System.out.println(pathL("",3,3));
        System.out.println(pathD("",3,3));
        int[][] arr = {
                {0,0,0},
                {0,0,0},
                {0,0,0}
        };
        System.out.println("This start from (0,0)");
        System.out.println(pathDo("",0,0,arr));

    }
    // only for down and right movement to reach principle diagonal
    // starting from 3, 3 and diagonal end is 1,1
    static void path(String p, int r, int c) {
        if (r == 1 && c == 1) {
            System.out.println(p);
            return;
        }
        if (r > 1) {
            path(p+'D', r-1,c);
        }
        if (c > 1) {
            path(p+'R', r, c -1);
        }
    }

    static ArrayList<String> pathL(String p, int r, int c) {
        if (r == 1 && c == 1) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> list = new ArrayList<>();
        if (r > 1) {
            list.addAll(pathL(p + 'D', r - 1, c));
        }
        if (c > 1) {
            list.addAll(pathL(p + 'R', r, c - 1));
        }
        return list;
    }

        // Including diagonal path too
        // H horizontal V Vertical D Diagonal
        static ArrayList<String> pathD(String p, int r, int c) {
            if (r == 1 && c == 1) {
                ArrayList<String> list = new ArrayList<>();
                list.add(p);
                return list;
            }
            ArrayList<String> list = new ArrayList<>();
            if (r > 1) {
                list.addAll(pathD(p+'V', r-1,c));
            }
            if (c > 1) {
                list.addAll(pathD(p+'H', r, c -1));
            }
            if (r > 1 && c > 1) {
                list.addAll(pathD(p+'D', r-1, c-1));
            }
            return list;
        }


    // starting from 0,0 and diagonal end at
    static ArrayList<String> pathDo(String p, int r, int c, int[][] arr) {
        int rEnd = arr.length - 1;
        int cEnd = arr[0].length - 1;
        if (r == rEnd && c == cEnd) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> list = new ArrayList<>();
        if (r < rEnd) {
            list.addAll(pathDo(p+'V', r+1,c, arr));
        }
        if (c < cEnd) {
            list.addAll(pathDo(p+'H', r, c+1,arr));
        }
        if (r < rEnd && c < cEnd) {
            list.addAll(pathDo(p+'D', r+1, c+1,arr));
        }
        return list;
    }


}
