import java.util.*;

public class FllodFill{
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
        int[][] ints = solution.floodFill(image, 1, 1, 2);
        System.out.println(ints);
    }
}

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        boolean[][] flag = new boolean[image.length][image[0].length];
        int color = image[sr][sc];
        Coordinate.borderX = image.length - 1;
        Coordinate.borderY = image[0].length - 1;
        Coordinate[] stack = new Coordinate[image.length * image[0].length];
        stack[0] = new Coordinate(sr, sc);
        int head = 0;
        while (head > -1) {
            Coordinate cur = stack[head--];
            //替换颜色
            if (image[cur.x][cur.y] == color) {
                image[cur.x][cur.y] = newColor;
            }
            flag[cur.x][cur.y] = true;
            List<Coordinate> neighbors = cur.getNeighbors();
            for (Coordinate neighbor : neighbors) {
                if (image[neighbor.x][neighbor.y]==color&&!flag[neighbor.x][neighbor.y]) {
                    stack[++head] = neighbor;
                }
            }
        }
        return image;
    }

    static class Coordinate {
        int x;
        int y;
        static int borderX;
        static int borderY;

        Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        List<Coordinate> getNeighbors() {
            List<Coordinate> res = new ArrayList<>();
            //上
            if (this.x - 1 > -1) {
                res.add(new Coordinate(x - 1, y));
            }
            //右
            if (this.y + 1 <= borderY) {
                res.add(new Coordinate(x, y + 1));
            }
            //下
            if (this.x + 1 <= borderX) {
                res.add(new Coordinate(x + 1, y));
            }
            //左
            if (this.y - 1 > -1) {
                res.add(new Coordinate(x, y - 1));
            }
            return res;
        }
    }
}