package _03_two_pointers_and_sliding_window;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main6_Answer {

    public int solution(int n, int k, List<Integer> numbers) {
        int answer = 0;
        int count = 0;
        int lt = 0;
        for (int rt = 0; rt < n; rt++) {
            if (numbers.get(rt) == 0) {
                count++;
            }

            while (count > k) {
                if (numbers.get(lt) == 0) {
                    count--;
                }
                lt++;
            }

            answer = Math.max(answer, rt - lt + 1);
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            numbers.add(sc.nextInt());
        }
        Main6_Answer main = new Main6_Answer();
        System.out.println(main.solution(n, k, numbers));
    }
}
