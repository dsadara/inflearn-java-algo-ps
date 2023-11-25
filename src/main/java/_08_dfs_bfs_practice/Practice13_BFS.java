package _08_dfs_bfs_practice;

/**
 * 13. 섬나라 아일랜드
 * 설명
 *
 * N*N의 섬나라 아일랜드의 지도가 격자판의 정보로 주어집니다.
 *
 * 각 섬은 1로 표시되어 상하좌우와 대각선으로 연결되어 있으며, 0은 바다입니다.
 *
 * 섬나라 아일랜드에 몇 개의 섬이 있는지 구하는 프로그램을 작성하세요.
 *
 * Image1.jpg
 *
 * 만약 위와 같다면 섬의 개수는 5개입니다.
 *
 *
 * 입력
 * 첫 번째 줄에 자연수 N(3<=N<=20)이 주어집니다.
 *
 * 두 번째 줄부터 격자판 정보가 주어진다.
 *
 *
 * 출력
 * 첫 번째 줄에 섬의 개수를 출력한다.
 *
 *
 * 예시 입력 1
 *
 * 7
 * 1 1 0 0 0 1 0
 * 0 1 1 0 1 1 0
 * 0 1 0 0 0 0 0
 * 0 0 0 1 0 1 1
 * 1 1 0 1 1 0 0
 * 1 0 0 0 1 0 0
 * 1 0 1 0 1 0 0
 * 예시 출력 1
 *
 * 5
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Practice13_BFS {
    class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int N;
    static int[][] board;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static int answer = 0;

    public void BFS(int x, int y) {
        Queue<Point> Q = new LinkedList<>();
        Q.add(new Point(x, y));
        
        while(!Q.isEmpty()) {
            Point p = Q.poll();
            for (int i = 0; i < 8; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (0 <= nx && nx < N && 0 <= ny && ny < N && board[nx][ny] == 1) {
                    board[nx][ny] = 0;
                    Q.offer(new Point(nx, ny));
                }
            }
        }
    }

    public void findIsland() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 1) {
                    board[i][j] = 0;
                    BFS(i, j);
                    answer++;
                }
            }
        }
    }

    public static void main(String[] args) {
        Practice13_BFS p13 = new Practice13_BFS();
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = in.nextInt();
            }
        }
        p13.findIsland();
        System.out.println(answer);
    }
}
