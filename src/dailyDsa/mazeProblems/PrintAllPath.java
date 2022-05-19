package dailyDsa.mazeProblems;

import java.util.Arrays;

public class PrintAllPath {
    // Backtracking
    public static void main(String[] args) {
        boolean[][] maze = {
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };
        int[][] path = new int[maze.length][maze[0].length];
        allPath("", maze, 0,0);
        allPathWithMatrix("",maze,0,0,path,1);
    }

    // Here we have two problem
    // 1st allowing all path result in infinite recursion as one can move up down infinite no. of times
    // solution is that we mark the cell as visited.
    // But this will result in second problem the maze array will be modified and for another recursion call
    // it have to be in its initial state else all path will not be printed
    // So, we use backtracking here and restore the maze array to its initial state.
    static void allPath(String p, boolean[][] maze, int r, int c) {
        int rEnd = maze.length - 1;
        int cEnd = maze[0].length - 1;

        if (r == rEnd && c == cEnd) {
            System.out.println(p);
            return;
        }

        if (!maze[r][c]) {
            return;
        }

        maze[r][c] = false;

        if (r < rEnd) {         // D downward
            allPath(p+'D', maze, r+1,c);
        }
        if (c < cEnd) {         // R Right
            allPath(p+'R', maze, r, c+1);
        }
        if (r > 0) {
            allPath(p+'U', maze, r-1,c);
        }
        if (c > 0) {
            allPath(p+'L', maze, r, c-1);
        }

        maze[r][c] = true;
    }

    static void allPathWithMatrix(String p, boolean[][] maze, int r, int c, int[][] path, int step) {
        int rEnd = maze.length - 1;
        int cEnd = maze[0].length - 1;

        if (r == rEnd && c == cEnd) {
            System.out.println(p);
            path[r][c] = step;
            for (int[] arr: path) {
                System.out.println(Arrays.toString(arr));
            }
            System.out.println();
            return;
        }

        if (!maze[r][c]) {
            return;
        }

        maze[r][c] = false;
        path[r][c] = step;

        if (r < rEnd) {         // D downward
            allPathWithMatrix(p+'D', maze, r+1,c,path,step+1);
        }
        if (c < cEnd) {         // R Right
            allPathWithMatrix(p+'R', maze, r, c+1, path, step+1);
        }
        if (r > 0) {            // U Up
            allPathWithMatrix(p+'U', maze, r-1,c, path, step+1);
        }
        if (c > 0) {            // L left
            allPathWithMatrix(p+'L', maze, r, c-1,path, step+1);
        }

        maze[r][c] = true;
        path[r][c] = 0;

    }

}
