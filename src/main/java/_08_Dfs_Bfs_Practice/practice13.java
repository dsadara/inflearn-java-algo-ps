package _08_Dfs_Bfs_Practice;

import java.util.Scanner;

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

public class practice13 {
    static int N;
    static int[][] board;
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static int answer = 0;

    public static void DFS(int x, int y) {
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (0 <= nx && nx < N && 0 <= ny && ny < N && board[nx][ny] == 1) {
                board[nx][ny] = 0;
                DFS(nx, ny);
            }
        }
    }

    public static void findIsland() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 1) {
                    board[i][j] = 0;
                    DFS(i, j);
                    answer++;
                }
            }
        }
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        N = in.nextInt();
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = in.nextInt();
            }
        }
        findIsland();
        System.out.println(answer);
    }
}
