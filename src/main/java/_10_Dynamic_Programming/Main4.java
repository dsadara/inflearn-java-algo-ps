package _10_Dynamic_Programming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Brick implements Comparable<Brick> {
    int s;
    int h;
    int w;
    public Brick(int s, int h, int w) {
        this.s = s;
        this.h = h;
        this.w = w;
    }
    @Override
    public int compareTo(Brick o) {
        return o.s - this.s;
    }
}

public class Main4 {
    static int[] dy;
    static ArrayList<Brick> list;

    public static int solution(int n) {
        int answer = 0;
        dy[0] = list.get(0).h;
        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (list.get(i).w < list.get(j).w && max < dy[j]) max = dy[j];
            }
            dy[i] = max + list.get(i).h;
            answer = Math.max(dy[i], answer);
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dy = new int[n+1];
        list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int h = sc.nextInt();
            int w = sc.nextInt();
            list.add(new Brick(s, h ,w));
        }
        Collections.sort(list);
        System.out.println(solution(n));
    }
}
