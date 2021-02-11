package 우아한테크코스.프로그래밍6;

import java.util.*;

public class Solution {

    public static class Student {
        private int index;
        private int grade;

        public Student(int index, int grade) {
            this.index = index;
            this.grade = grade;
        }
    }

    public static String[] solution(String[] logs) {
        String[] answer = {};
        HashMap<String, List<Student>> hashMap = new HashMap<>();
        HashSet<String> hashSet = new HashSet<>();

        for (String log : logs) {
            String[] temp = log.split(" ");
            hashSet.add(temp[0]);
            if (hashMap.get(temp[0]) == null) {
                List<Student> students = new ArrayList<>();
                students.add(new Student(Integer.parseInt(temp[1]), Integer.parseInt(temp[2])));
                hashMap.put(temp[0], students);
            } else {
                List<Student> students = hashMap.get(temp[0]);
                students.add(new Student(Integer.parseInt(temp[1]), Integer.parseInt(temp[2])));
                hashMap.put(temp[0], students);
            }
        }
        List<String> keySets = new ArrayList<>(hashMap.keySet());
        Collections.sort(keySets, (o1, o2) -> o1.compareTo(o2));

        Iterator<String> iterator = keySets.iterator();

        while (iterator.hasNext()) {
            String key = iterator.next();
            List<Student> students = hashMap.get(key);
            Collections.sort(students, new Comparator<Student>() {
                @Override
                public int compare(Student o1, Student o2) {
                    return o1.index - o2.index;
                }
            });
        }

        for (String s : hashMap.keySet()) {
            System.out.println(s);
            for (int i = 0; i < hashMap.get(s).size(); i++) {
                System.out.print(hashMap.get(s).get(i).index + " ");
            }
            System.out.println("");
        }

        return answer;
    }

    public static void main(String[] args) {
        solution(new String[]{
                "0001 3 95", "0001 5 90", "0001 5 100", "0002 3 95", "0001 7 80", "0001 8 80", "0001 10 90", "0002 10 90", "0002 7 80", "0002 8 80", "0002 5 100", "0003 99 90"
        });
    }
}
