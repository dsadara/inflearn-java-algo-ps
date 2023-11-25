package _05_stack_and_queue;

/**
 * 4. 후위식 연산(postfix)
 * 설명
 *
 * 후위연산식이 주어지면 연산한 결과를 출력하는 프로그램을 작성하세요.
 *
 * 만약 3*(5+2)-9 을 후위연산식으로 표현하면 352+*9- 로 표현되며 그 결과는 12입니다.
 *
 *
 * 입력
 * 첫 줄에 후위연산식이 주어집니다. 연산식의 길이는 50을 넘지 않습니다.
 *
 * 식은 1~9의 숫자와 +, -, *, / 연산자로만 이루어진다.
 *
 *
 * 출력
 * 연산한 결과를 출력합니다.
 *
 *
 * 예시 입력 1
 *
 * 352+*9-
 * 예시 출력 1
 *
 * 12
 */

import java.util.Scanner;
import java.util.Stack;

public class Practice4 {
    public static int solution(String str) {
        Stack<Integer> stack = new Stack<>();
        int rt, lt;
        for (char c : str.toCharArray()) {
            switch (c) {
                case '+':
                    rt = stack.pop();
                    lt = stack.pop();
                    stack.push(lt + rt);
                    break;
                case '-':
                    rt = stack.pop();
                    lt = stack.pop();
                    stack.push(lt - rt);
                    break;
                case '*':
                    rt = stack.pop();
                    lt = stack.pop();
                    stack.push(lt * rt);
                    break;
                case '/':
                    rt = stack.pop();
                    lt = stack.pop();
                    stack.push(lt / rt);
                    break;
                default:
                    stack.push(Character.digit(c, 10));
                    break;
            }
        }
        return stack.pop();
    }

    public static int solution2(String str) {
        Stack<Integer> stack = new Stack<>();
        int rt, lt;
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                stack.push((int) c - 48);
            } else {
                rt = stack.pop();
                lt = stack.pop();
                if (c == '+') stack.push(lt + rt);
                else if (c == '-') stack.push(lt - rt);
                else if (c == '*') stack.push(lt * rt);
                else if (c == '/') stack.push(lt / rt);
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String str = kb.next();
        System.out.println(solution2(str));
    }
}
