package _09_Greedy_Algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Time2 implements Comparable<Time2> {
    int time;
    char state;
    Time2(int time, char state) {
        this.time = time;
        this.state = state;
    }
    @Override
    public int compareTo(Time2 o) {
        if (this.time == o.time) {
            return this.state - o.state;
        }
        return this.time - o.time;
    }
}

public class Main3 {
    static int n;

    public static int solution(List<Time2> arr) {
        int answer = Integer.MIN_VALUE;
        int cnt = 0;
        Collections.sort(arr);
        for (Time2 t : arr) {
            if (t.state == 's') cnt++;
            else cnt--;
            answer = Math.max(answer, cnt);
        }
        return answer;
    }

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        n = in.nextInt();
        ArrayList<Time2> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int st = in.nextInt();
            int et = in.nextInt();
            arr.add(new Time2(st, 's'));
            arr.add(new Time2(et, 'e'));
        }
        System.out.println(solution(arr));
    }
}
