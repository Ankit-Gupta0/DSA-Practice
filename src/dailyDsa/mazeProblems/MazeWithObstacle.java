package dailyDsa.mazeProblems;

public class MazeWithObstacle {
    public static void main(String[] args) {
        boolean[][] maze = {
                {true, true, true},
                {true, false, true},
                {true, true, true}
        };
        pathRestriction("",maze,0,0);
    }
    static void pathRestriction(String p, boolean[][] maze, int r, int c) {
        int rEnd = maze.length - 1;
        int cEnd = maze[0].length - 1;
        if (r == rEnd && c == cEnd) {
            System.out.println(p);
            return;
        }

        if (!maze[r][c]) {
            return;
        }

        if (r < rEnd) {
            pathRestriction(p+'D', maze, r+1,c);
        }
        if (c < cEnd) {
            pathRestriction(p+'R', maze, r, c+1);
        }
    }
}
