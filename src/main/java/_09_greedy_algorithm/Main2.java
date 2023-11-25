package _09_greedy_algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 2. 회의실 배정
 * 설명
 *
 * 한 개의 회의실이 있는데 이를 사용하고자 하는 n개의 회의들에 대하여 회의실 사용표를 만들려고 한다.
 *
 * 각 회의에 대해 시작시간과 끝나는 시간이 주어져 있고, 각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 최대수의 회의를 찾아라.
 *
 * 단, 회의는 한번 시작하면 중간에 중단될 수 없으며 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다.
 *
 *
 * 입력
 * 첫째 줄에 회의의 수 n(1<=n<=100,000)이 주어진다. 둘째 줄부터 n+1 줄까지 각 회의의 정보가 주어지는데
 *
 * 이것은 공백을 사이에 두고 회의의 시작시간과 끝나는 시간이 주어진다. 회의시간은 0시부터 시작한다.
 *
 * 회의의 시작시간과 끝나는 시간의 조건은 (시작시간 <= 끝나는 시간)입니다.
 *
 *
 * 출력
 * 첫째 줄에 최대 사용할 수 있는 회의 수를 출력하여라.
 *
 *
 * 예시 입력 1
 *
 * 5
 * 1 4
 * 2 3
 * 3 5
 * 4 6
 * 5 7
 *
 * 예시 출력 1
 *
 * 3
 *
 * 예시 입력 2
 *
 * 3
 * 3 3
 * 1 3
 * 2 3
 *
 * 예시 출력 2
 *
 * 2
 */

class Time implements Comparable<Time> {
    int s;
    int e;

    Time(int s, int e) {
        this.s = s;
        this.e = e;
    }

    @Override
    public int compareTo(Time o) {
        if (o.e == this.e) {
            return this.s - o.s;
        }
        return this.e - o.e;
    }
}

public class Main2 {
    static int n;

    public static int solution(List<Time> m) {
        int result = 0;
        int e = 0;
        for (Time time : m) {
            if (e <= time.s) {
               result++;
               e = time.e;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Time> m = new ArrayList<>();
        n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int s = in.nextInt();
            int e = in.nextInt();
            m.add(new Time(s, e));
        }
        Collections.sort(m);
        System.out.println(solution(m));
    }
}
