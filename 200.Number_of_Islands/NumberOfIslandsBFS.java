//1.BFS
import java.awt.Point;
public class NumberOfIslandsBFS{
    public int numIslands(char[][] grid) {

        if(grid.length==0){
            return 0;
        }

        //是否被访问
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        int islandNum = 0;

        //遍历所有节点
        for(int i = 0; i < visited.length; i++){
            for(int j = 0; j < visited[i].length; j++){
                if(!visited[i][j]&&grid[i][j]=='1'){
                    islandNum++;
                    visited[i][j] = true;
                    bfs(j,i,grid,visited);
                }
                else visited[i][j] = true;
            }
        }
        return islandNum;
    }

    private void bfs(int a, int b, char[][] grid, boolean[][] visited){
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(a,b));
        while(queue.size()>0){
            int length = queue.size();
            for(int i=0;i<length;i++){
                Point point = queue.poll();
                int x = (int)point.getX();
                int y = (int)point.getY();
                visited[y][x] = true;
                if(y-1>=0&&!visited[y-1][x]&&grid[y-1][x]=='1'){
                    Point p = new Point(x,y-1);
                    queue.offer(p);
                    visited[y-1][x]=true;
                }
                if(x+1<grid[y].length&&!visited[y][x+1]&&grid[y][x+1]=='1'){
                    Point p = new Point(x+1,y);
                    queue.offer(p);
                    visited[y][x+1]=true;
                }
                if(y+1<grid.length&&!visited[y+1][x]&&grid[y+1][x]=='1'){
                    Point p = new Point(x,y+1);
                    queue.offer(p);
                    visited[y+1][x]=true;
                }
                if(x-1>=0&&!visited[y][x-1]&&grid[y][x-1]=='1'){
                    Point p = new Point(x-1,y);
                    queue.offer(p);
                    visited[y][x-1]=true;
                }
            }
        }
    }
}