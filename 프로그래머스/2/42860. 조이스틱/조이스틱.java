class Solution {
    public int solution(String name) {
        return calcUpDown(name) + calcLeftRight(name);
    }

    private int calcUpDown(String name) {
        int total = 0;
        for (char c : name.toCharArray()) {
            int diff = c - 'A';
            total += Math.min(diff, 26 - diff);
        }
        return total;
    }

    private int calcLeftRight(String name) {
        int n = name.length();
        int minMove = n - 1; // 기준: 오른쪽으로만 끝까지

        for (int i = 0; i < n; i++) {
            // i 이후 A 구간의 끝 (= 건너뛸 수 있는 구간)
            int next = i + 1;
            while (next < n && name.charAt(next) == 'A') next++;

            int goRightFirst = i + i + (n - next);
            int goLeftFirst = (n - next) * 2 + i;

            minMove = Math.min(minMove, Math.min(goRightFirst, goLeftFirst));
        }

        return minMove;
    }
}