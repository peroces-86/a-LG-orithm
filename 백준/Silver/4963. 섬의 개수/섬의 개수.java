import java.util.Scanner;

public class Main {
    static int w, h;
    static int[][] map;
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            w = sc.nextInt();
            h = sc.nextInt();
            if (w == 0 && h == 0) break;
            
            map = new int[h][w];
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    map[i][j] = sc.nextInt();
                }
            }
            
            int count = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == 1) {
                        dfs(i, j);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
        sc.close();
    }
    
    // DFS
    static void dfs(int x, int y) {
        if (x < 0 || y < 0 || x >= h || y >= w) return;
        if (map[x][y] == 0) return;
        
        map[x][y] = 0;
        
        for (int i = 0; i < 8; i++) {
            dfs(x + dx[i], y + dy[i]);
        }
    }
}
