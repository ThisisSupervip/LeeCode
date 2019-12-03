/**
 * DFS递归方式
 */
public class NumberOfIslandsDFS {
    public static void main(String[] args) {
        char[][] grid = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        Solution solution = new Solution();
        int i = solution.numIslands(grid);
        System.out.println(i);
    }
}
class Solution {
    public int numIslands(char[][] grid) {

        if (grid.length==0) {
            return 0;
        }
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        //记录岛屿数
        int res = 0;
        //遍历岛屿位置
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(!visited[i][j]){
                    if(grid[i][j]=='1'){
                        res += 1;
                        dfs(grid, visited, i, j);
                    } else{
                        visited[i][j]=true;
                    }
                }
            }
        }
        return res;
    }
    private void dfs(char[][] grid, boolean[][] visited, int i, int j) {
        //设置当前位置为已查看
        visited[i][j]=true;
        //上
        if(i-1>=0&&!visited[i-1][j]&&grid[i-1][j]=='1'){
            dfs(grid, visited, i-1, j);
        }
        //右
        if(j+1<visited[0].length&&!visited[i][j+1]&&grid[i][j+1]=='1'){
            dfs(grid, visited, i, j+1);
        }
        //下
        if(i+1<visited.length&&!visited[i+1][j]&&grid[i+1][j]=='1'){
            dfs(grid, visited, i+1, j);
        }
        //左
        if(j-1>=0&&!visited[i][j-1]&&grid[i][j-1]=='1'){
            dfs(grid, visited, i, j-1);
        }
    }
}