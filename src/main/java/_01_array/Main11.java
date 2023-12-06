package _01_array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main11 {

    public static final int GRADE = 5;
    static List<Map<Integer, List<Integer>>> grade = new ArrayList<>();
    static List<List<Integer>> student = new ArrayList<>();

    public int solution(int studNum) {
        int answer = -1;

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < studNum; i++) {
            List<Integer> studentRooms = student.get(i);
            HashSet<Integer> studentCount = new HashSet<>();
            for (int j = 0; j < GRADE; j++) {
                List<Integer> studentsInRoom = grade.get(j).get(studentRooms.get(j));
                for (Integer student : studentsInRoom) {
                    studentCount.add(student);
                }
            }

            if (studentCount.size() > max) {
                max = studentCount.size();
                answer = i + 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            grade.add(new HashMap<>());
        }

        int studNum = sc.nextInt();
        for (int i = 0; i < studNum; i++) {
            student.add(new ArrayList<>());
            for (int j = 0; j < 5; j++) {
                student.get(i).add(sc.nextInt());
            }
        }

        for (int i = 0; i < studNum; i++) {
            for (int j = 0; j < GRADE; j++) {
                Map<Integer, List<Integer>> map = grade.get(j);
                int room = student.get(i).get(j);
                List<Integer> studList = map.getOrDefault(room, new ArrayList<>());
                map.put(room, studList);
                studList.add(i + 1);
            }
        }

        Main11 main11 = new Main11();
        System.out.println(main11.solution(studNum));

    }

}
