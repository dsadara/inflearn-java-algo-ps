package _08_dfs_bfs_practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Point2 {
    int x;
    int y;
    Point2(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Practice14_Answer {
    static int n, m, len, answer = Integer.MAX_VALUE;
    static List<Point2> hs, pz;
    static int[] combi;

    public void DFS(int l, int s) {
        if (l == m) {
            int sum = 0;
            for (Point2 h : hs) {
                int dis = Integer.MAX_VALUE;
                for (int i : combi) {
                    dis = Math.min(dis, Math.abs(h.x - pz.get(i).x) + Math.abs(h.y - pz.get(i).y));
                }
                sum += dis;
            }
            answer = Math.min(answer, sum);
        } else {
            for (int i = s; i < len; i++) {
                combi[l] = i;
                DFS(l+1, i+1);
            }
        }
    }


    public static void main(String[] args) {
        Practice14_Answer p14 = new Practice14_Answer();
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        hs = new ArrayList<>();
        pz = new ArrayList<>();
        for (int x = 1; x <= n; x++) {
            for (int y = 1; y <= n; y++) {
                int tmp = in.nextInt();
                if (tmp == 2) pz.add(new Point2(x, y));
                if (tmp == 1) hs.add(new Point2(x, y));
            }
        }
        len = pz.size();
        combi = new int[m];
        p14.DFS(0, 0);
        System.out.println(answer);
    }
}
