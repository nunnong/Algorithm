import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int n = progresses.length;
        int[] days = new int[n];
        for (int i = 0; i < n; i++) {
            days[i] = (int) Math.ceil((100 - progresses[i]) / (double) speeds[i]);
        }

        List<Integer> answerList = new ArrayList<>();
        int leader = days[0];
        int cnt = 1;

        for (int i = 1; i < n; i++) {
            if (leader >= days[i]) {
                cnt++;
            } else {
                answerList.add(cnt);
                leader = days[i];
                cnt = 1;
            }
        }
        answerList.add(cnt);

        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }
}