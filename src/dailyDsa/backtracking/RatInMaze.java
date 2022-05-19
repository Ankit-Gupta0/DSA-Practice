package dailyDsa.backtracking;

import java.util.ArrayList;


public class RatInMaze {

//    https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/1

//    Consider a rat placed at (0, 0) in a square matrix of order N * N.
//    It has to reach the destination at (N - 1, N - 1). Find all possible paths that the rat can take to reach from
//    source to destination. The directions in which the rat can move are 'U'(up), 'D'(down), 'L' (left), 'R' (right).
//    Value 0 at a cell in the matrix represents that it is blocked and rat cannot move to
//        it while value 1 at a cell in the matrix represents that rat can be travel through it.
//    Note: In a path, no cell can be visited more than one time.
//    If the source cell is 0, the rat cannot move to any other cell.
    public static void main(String[] args) {
        int[][] m = {
                {1,0,1},
                {1,1,1},
                {1,1,1}
        };
        int n = 3;
        System.out.println(findPath(m, n));
    }

    public static ArrayList<String> findPath(int[][] m, int n) {
        return helper("",m,0,0,n);
    }

    private static ArrayList<String> helper(String p, int[][] m, int r, int c, int n) {
        if (r == (n - 1) && c == (n - 1)) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> list = new ArrayList<>();
        if (m[r][c] == 0) {
            return list;
        }
        m[r][c] = 0;
        if (r < (n-1) && m[r+1][c] != 0) {
            list.addAll(helper(p+'D', m, r+1,c,n));
        }
        if (c < (n-1) && m[r][c+1] != 0 ) {
            list.addAll(helper(p+'R', m, r,c+1,n));
        }
        if (r > 0 ) {
            list.addAll(helper(p+'U', m, r-1,c, n));
        }
        if (c > 0 ) {
            list.addAll(helper(p+'L', m, r, c-1, n));
        }
        m[r][c] = 1;

        return list;
    }
}

