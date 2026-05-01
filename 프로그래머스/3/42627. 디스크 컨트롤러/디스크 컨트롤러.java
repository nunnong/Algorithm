import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        
        // 1. jobs를 요청 시각 순으로 정렬
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        
        // 2. PQ 우선순위: 소요시간 -> 요청시각 -> 작업번호
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            if (a[1] != b[1]) return a[1] - b[1];
            return a[2] - b[2];
        });
        
        int currTime = 0;       // 현재 시각
        int idx = 0;            // 다음에 PQ에 넣을 jobs 인덱스
        long total = 0;         
        int n = jobs.length;    
        
        while (idx < n || !pq.isEmpty()) {
            
            // (A) currTime까지 도착한 작업들을 PQ에 모두 투입
            while (idx < n && jobs[idx][0] <= currTime) {
                int s = jobs[idx][0];   // 요청 시각
                int l = jobs[idx][1];   // 소요시간
                int i = idx;            // 작업 번호
                pq.offer(new int[]{l, s, i});
                idx++;
            }
            
            if (pq.isEmpty()) {
                // 처리할 작업이 없으면 다음 작업의 요청 시각으로 점프
                currTime = jobs[idx][0];
            } else {
                // 가장 짧은 작업 처리
                int[] task = pq.poll();
                int l = task[0];   // 작업의 소요시간
                int s = task[1];   // 작업이 요청되는 시점
                int i = task[2];   // 작업 번호
                
                currTime += l;              // 시간 진행
                total += currTime - s;      // 끝난 시각 - 요청 시각
            }
        }
        
        int answer = (int)(total / n);
        return answer;
    }
}