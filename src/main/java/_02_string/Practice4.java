package _02_string;

import java.util.ArrayList;
import java.util.Scanner;

public class Practice4 {
    public static ArrayList<String> solution(int n, String[] str) {
        ArrayList<String> answer = new ArrayList<>();
        StringBuilder sb;

        for (String s : str) {
            sb = new StringBuilder();
            sb.append(s);
            sb.reverse();
            answer.add(sb.toString());
        }

        return answer;
    }

    public static ArrayList<String> solution2(int n, String[] str) {
        ArrayList<String> answer = new ArrayList<>();

        for (String word : str) {
            char[] wordArr = word.toCharArray();
            int lt = 0;
            int rt = wordArr.length - 1;
            while (lt < rt) {
                char tmp = wordArr[lt];
                wordArr[lt] = wordArr[rt];
                wordArr[rt] = tmp;
                lt++;
                rt--;
            }
            answer.add(new String(wordArr));
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        String[] str = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = kb.next();
        }
        for (String x : solution(n, str)) {
            System.out.println(x);
        }
        for (String x : solution2(n, str)) {
            System.out.println(x);
        }
    }
}
