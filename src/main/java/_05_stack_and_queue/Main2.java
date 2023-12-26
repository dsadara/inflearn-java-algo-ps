package _05_stack_and_queue;

import java.util.Scanner;
import java.util.Stack;

/**
 * 2. 괄호문자제거
 * 설명
 *
 * 입력된 문자열에서 소괄호 ( ) 사이에 존재하는 모든 문자를 제거하고 남은 문자만 출력하는 프로그램을 작성하세요.
 *
 *
 * 입력
 * 첫 줄에 문자열이 주어진다. 문자열의 길이는 100을 넘지 않는다.
 *
 *
 * 출력
 * 남은 문자만 출력한다.
 *
 *
 * 예시 입력 1
 *
 * (A(BC)D)EF(G(H)(IJ)K)LM(N)
 * 예시 출력 1
 *
 * EFLM
 */

public class Main2 {

    public String solution(String input) {
        String answer = "";
        Stack<Character> stack = new Stack<>();
        for (char c : input.toCharArray()) {
            if (c == ')') {
                while (stack.pop() != '(');
            } else {
                stack.push(c);
            }
        }

        for (int i = 0; i < stack.size(); i++) {
           answer += stack.get(i);  // 이렇게 스택도 인덱스로 접근 가능
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        Main2 main = new Main2();
        System.out.println(main.solution(input));
    }

}
