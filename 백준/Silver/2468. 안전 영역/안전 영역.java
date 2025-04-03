import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] grid;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        grid = new int[N][N];
        int maxHeight = 0;
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, grid[i][j]);
            }
        }
        
        int maxSafeArea = 0;
        for (int water = 0; water <= maxHeight; water++) {
            visited = new boolean[N][N];
            int safeCount = 0;
            
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && grid[i][j] > water) {
                        dfs(i, j, water);
                        safeCount++;
                    }
                }
            }
            maxSafeArea = Math.max(maxSafeArea, safeCount);
        }
        
        System.out.println(maxSafeArea);
    }
    
    static void dfs(int x, int y, int water) {
        visited[x][y] = true;
        
        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            
            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                if (!visited[nx][ny] && grid[nx][ny] > water) {
                    dfs(nx, ny, water);
                }
            }
        }
    }
}
