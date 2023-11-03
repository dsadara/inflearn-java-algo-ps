package _09_Greedy_Algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 7. 원더랜드(최소스패닝트리) -> 크루스칼: Union&Find 사용
 * 설명
 *
 * 원더랜드에 문제가 생겼다. 원더랜드의 각 도로를 유지보수하는 재정이 바닥난 것이다.
 *
 * 원더랜드는 모든 도시를 서로 연결하면서 최소의 유지비용이 들도록 도로를 선택하고 나머지 도로는 폐쇄하려고 한다.
 *
 * 아래의 그림은 그 한 예를 설명하는 그림이다.
 *
 * Image1.jpg
 *
 * 위의 지도는 각 도시가 1부터 9로 표현되었고, 지도의 오른쪽은 최소비용 196으로 모든 도시를 연결하는 방법을 찾아낸 것이다.
 *
 *
 * 입력
 * 첫째 줄에 도시의 개수 V(1≤V≤100)와 도로의 개수 E(1≤E≤1,000)가 주어진다.
 *
 * 다음 E개의 줄에는 각 도로에 대한 정보를 나타내는 세 정수 A, B, C가 주어진다.
 *
 * 이는 A번 도시와 B번 도시가 유지비용이 C인 도로로 연결되어 있다는 의미이다.
 *
 *
 * 출력
 * 모든 도시를 연결하면서 드는 최소비용을 출려한다.
 *
 *
 * 예시 입력 1
 *
 * 9 12
 * 1 2 12
 * 1 9 25
 * 2 3 10
 * 2 8 17
 * 2 9 8
 * 3 4 18
 * 3 7 55
 * 4 5 44
 * 5 6 60
 * 5 7 38
 * 7 8 35
 * 8 9 15
 * 예시 출력 1
 *
 * 196
 */

class Edge2 implements Comparable<Edge2> {
    int a;
    int b;
    int c;

    public Edge2(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    @Override
    public int compareTo(Edge2 o) {
        return this.c - o.c;
    }
}

public class Main7 {
    static int[] unf;
    public static int find(int v) {
        if (unf[v] == v) return v;
        else return unf[v] = find(unf[v]);
    }
    public static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if (fa != fb) unf[fa] = fb;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        unf = new int[n + 1];
        for (int i = 1; i <= n; i++) unf[i] = i;
        ArrayList<Edge2> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            list.add(new Edge2(a, b, c));
        }
        Collections.sort(list);
        int answer = 0;
        for (Edge2 e : list) {
            int fa = find(e.a);
            int fb = find(e.b);
            if (fa != fb) {
                answer += e.c;
                union(e.a, e.b);
            }
        }
        System.out.println(answer);
    }
}
