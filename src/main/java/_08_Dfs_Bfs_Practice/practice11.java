package _08_Dfs_Bfs_Practice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 11. 미로의 최단거리 통로(BFS)
 * 설명
 *
 * 7*7 격자판 미로를 탈출하는 최단경로의 길이를 출력하는 프로그램을 작성하세요.
 *
 * 경로의 길이는 출발점에서 도착점까지 가는데 이동한 횟수를 의미한다.
 *
 * 출발점은 격자의 (1, 1) 좌표이고, 탈출 도착점은 (7, 7)좌표이다. 격자판의 1은 벽이고, 0은 도로이다.
 *
 * 격자판의 움직임은 상하좌우로만 움직인다. 미로가 다음과 같다면
 *
 * Image1.jpg
 *
 * 위와 같은 경로가 최단 경로의 길이는 12이다.
 *
 *
 * 입력
 * 첫 번째 줄부터 7*7 격자의 정보가 주어집니다.
 *
 *
 * 출력
 * 첫 번째 줄에 최단으로 움직인 칸의 수를 출력한다. 도착할 수 없으면 -1를 출력한다.
 *
 *
 * 예시 입력 1
 *
 * 0 0 0 0 0 0 0
 * 0 1 1 1 1 1 0
 * 0 0 0 1 0 0 0
 * 1 1 0 1 0 1 1
 * 1 1 0 1 0 0 0
 * 1 0 0 0 1 0 0
 * 1 0 1 0 0 0 0
 * 예시 출력 1
 *
 * 12
 */


public class practice11 {

    class Point {
        int x;
        int y;
        Point (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] board;
    static int[][] dis;
    static int answer = Integer.MAX_VALUE;

    public void BFS(int x, int y) {
        Queue<Point> Q = new LinkedList<>();
        Q.add(new Point(x, y));

        while(!Q.isEmpty()) {
            int size = Q.size();
            for (int i = 0; i < size; i++) {
                Point p = Q.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = p.x + dx[j];
                    int ny = p.y + dy[j];
                    if (1 <= nx && nx <= 7 && 1 <= ny && ny <= 7 && board[nx][ny] == 0) {
                        if (nx == 7 && ny == 7) {
                            dis[nx][ny] = dis[p.x][p.y] + 1;
                            return;
                        }
                        board[nx][ny] = 1;
                        Q.offer(new Point(nx, ny));
                        dis[nx][ny] = dis[p.x][p.y] + 1;
                    }
                }
            }
        }
    }

    public static void main(String[] args){
        practice11 p11 = new practice11();
        Scanner in = new Scanner(System.in);
        board = new int[8][8];
        dis = new int[8][8];
        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= 7; j++) {
                board[i][j] = in.nextInt();
            }
        }
        board[1][1] = 1;
        p11.BFS(1, 1);
        if (dis[7][7] == 0) {
            System.out.println(-1);
        } else {
            System.out.println(dis[7][7]);
        }
        return ;
    }
}
